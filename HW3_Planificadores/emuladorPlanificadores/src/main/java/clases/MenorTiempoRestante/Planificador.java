/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases.MenorTiempoRestante;



import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author marcotulio
 */
public class Planificador {
    
    private JPanel listaRegistro;
    private List<Proceso> listaProcesos;
    private JTable tablaProcesos;
    private JScrollPane ganttPanel;
    private int tiempoAQuemarTotal = 0;
    private int ultimoTiempoDeLlegada = 0;
    
    public Planificador(JPanel listaRegistro, JTable tablaProcesos, JScrollPane ganttPanel) {
        this.listaProcesos = new ArrayList<>();
        this.listaRegistro = listaRegistro;
        this.tablaProcesos = tablaProcesos;
        this.ganttPanel = ganttPanel;
    }
    
    public void agregarRegistro(String mensaje){      
        JTextPane textPane = new JTextPane();
        textPane.setText(mensaje);
        textPane.setSize(listaRegistro.getWidth(), listaRegistro.getHeight()/9);
        listaRegistro.add(textPane);
        listaRegistro.repaint();
    }
    
    public void generarProcesos(int numProcesos){
        this.generarProcesosRecursivo(numProcesos, 0);
    }
    
    public void generarProcesosRecursivo(int numProcesos, int numProceso){
        if(numProceso >= numProcesos){
            this.agregarRegistro(String.format("Se han generado un total de %d procesos", numProcesos));
        }else{
            Proceso proceso = new Proceso(
                    numProceso,
                    String.format("P%d", numProceso),
                    this.obtenerNumeroAleatorio(0, numProcesos+1),
                    this.obtenerNumeroAleatorio(1, 3)
            );
            this.tiempoAQuemarTotal = this.tiempoAQuemarTotal + proceso.getTiempoAQuemar();
            if(proceso.getTiempoLlegada() > this.ultimoTiempoDeLlegada){
                this.ultimoTiempoDeLlegada = proceso.getTiempoLlegada();
            }
            this.listaProcesos.add(proceso);
            
            DefaultTableModel model = (DefaultTableModel)this.tablaProcesos.getModel();
            model.addRow(new Object[] { proceso.getAlias(),proceso.getTiempoLlegada(), proceso.getTiempoAQuemar() });
            this.agregarRegistro(String.format("Se agrego a la cola al proceso %s", proceso.getAlias()));
            this.tablaProcesos.repaint();
            this.generarProcesosRecursivo(numProcesos, numProceso+1);
        }
    }
    
    public int obtenerNumeroAleatorio(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
    
    public void planificarProcesos(){
        this.ordenarProcesos();
        this.algoritmoSRP(0);
    }
    
    public void algoritmoSRP(int intervaloActual){
        if(intervaloActual > this.ultimoTiempoDeLlegada){
            this.agregarRegistro("Se ah alcanzado el ultimo tiempo de llegada.");
            this.agregarRegistro("Cambiando al algoritmo FSP...");
        }else{
            List<Proceso> tempListaProcesos =new ArrayList<>();
            for (int i = 0; i < this.listaProcesos.size(); i++) {
                if(this.listaProcesos.get(i).getTiempoLlegada()>intervaloActual){
                    i = this.listaProcesos.size();
                }else{
                    if(this.listaProcesos.get(i).getTiempoRestante() != 0){
                        tempListaProcesos.add(this.listaProcesos.get(i));
                    }
                }
            }
            
            if(tempListaProcesos.size()>0){
                Proceso procesoSRP = this.obtenerSRP(tempListaProcesos);
                procesoSRP.quemarTiempo();
                this.agregarRegistro(String.format(
                        "Se ah ejecutado un intervalo del proceso %s", procesoSRP.getIdentificador()
                ));
                this.agregarRegistro(String.format(
                        "Al proceso %s le quedan %d intervalos", procesoSRP.getIdentificador(), procesoSRP.getTiempoRestante()
                ));
                algoritmoSRP(intervaloActual+1);
            }
            
        }
    }
    
    public Proceso obtenerSRP(List<Proceso> tempListaProcesos){
        Proceso procesoSRP = null;     
        for (Proceso proceso : tempListaProcesos) {
            if(procesoSRP == null){
                procesoSRP = proceso;
            }else{
                if(procesoSRP.getTiempoRestante() > proceso.getTiempoRestante()){
                    procesoSRP = proceso;
                }
            }
        }
        return procesoSRP;
    }
    
    public void ordenarProcesos(){
        int n = this.listaProcesos.size();
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (this.listaProcesos.get(j).getTiempoLlegada() > this.listaProcesos.get(j+1).getTiempoLlegada()){
                    this.listaProcesos.add(j+1, this.listaProcesos.remove(j));  
                }
    }
    
    
    

    
}
