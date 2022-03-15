/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases.MenorTiempoRestante;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
    private JPanel ganttPanel;
    private int tiempoAQuemarTotal = 0;
    private int ultimoTiempoDeLlegada = 0;
    
    public Planificador(JPanel listaRegistro, JTable tablaProcesos, JPanel ganttPanel) {
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
                    this.obtenerNumeroAleatorio(1, 5)
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
        this.ordenarPorTiempoLlegada(this.listaProcesos);
        this.algoritmoSRP(0);
    }
    
    public void algoritmoSRP(int intervaloActual){
        if(intervaloActual > this.ultimoTiempoDeLlegada){
            this.agregarRegistro("Se ah alcanzado el ultimo tiempo de llegada.");
            this.agregarRegistro("Cambiando al algoritmo FCFS...");
            List<Proceso> tempListaProcesos =new ArrayList<>();
            for (int i = 0; i < this.listaProcesos.size(); i++) {
                if(this.listaProcesos.get(i).getTiempoRestante() != 0){
                    tempListaProcesos.add(this.listaProcesos.get(i));
                }
            }
            
            if(tempListaProcesos.size() > 0){
                this.ordenarPorTiempoRestante(tempListaProcesos);
                this.algoritmoFCFS(tempListaProcesos, intervaloActual);
            }
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
              
                this.agregarEjecucionDiagrama(procesoSRP.getAlias(), intervaloActual);
                this.agregarRegistro(String.format(
                        "Se ah ejecutado un intervalo del proceso %s", procesoSRP.getAlias()
                ));
                this.agregarRegistro(String.format(
                        "Al proceso %s le quedan %d intervalos", procesoSRP.getAlias(), procesoSRP.getTiempoRestante()
                ));
                
                if(procesoSRP.getTiempoRestante() == 0){
                    DefaultTableModel model = (DefaultTableModel)this.tablaProcesos.getModel();
                    model.setValueAt(String.format("%d", intervaloActual+1),procesoSRP.getIdentificador() , 3);
                    model.setValueAt(String.format("%d", (intervaloActual+1)-procesoSRP.getTiempoLlegada()),procesoSRP.getIdentificador() , 4);
                    model.setValueAt(String.format("%d", ((intervaloActual+1)-procesoSRP.getTiempoLlegada())-procesoSRP.getTiempoAQuemar()),procesoSRP.getIdentificador() , 5);
                }
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
    
    public void ordenarPorTiempoLlegada(List<Proceso> lista){
        int n = lista.size();
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (lista.get(j).getTiempoLlegada() > lista.get(j+1).getTiempoLlegada()){
                    lista.add(j+1, lista.remove(j));  
                }
    }
    
    public void ordenarPorTiempoRestante(List<Proceso> lista){
        int n = lista.size();
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (lista.get(j).getTiempoRestante() > lista.get(j+1).getTiempoRestante()){
                    lista.add(j+1, lista.remove(j));  
                }
    }
    
    public void algoritmoFCFS(List<Proceso> lista, int intervaloActual){
        if(lista.size() < 1){
            this.agregarRegistro(String.format("Se ah completado el ultimo intervalo: %d.",intervaloActual));
        }else{
          
            if(lista.get(0).getTiempoRestante()< 2){
                Proceso procesoFCFS = lista.remove(0);
                procesoFCFS.quemarTiempo();
           
                this.agregarEjecucionDiagrama(procesoFCFS.getAlias(), intervaloActual);
                this.agregarRegistro(String.format(
                        "Se ah ejecutado un intervalo del proceso %s", procesoFCFS.getAlias()
                ));
                this.agregarRegistro(String.format(
                        "Al proceso %s le quedan %d intervalos", procesoFCFS.getAlias(), procesoFCFS.getTiempoRestante()
                ));
                DefaultTableModel model = (DefaultTableModel)this.tablaProcesos.getModel();
                model.setValueAt(String.format("%d", intervaloActual+1),procesoFCFS.getIdentificador() , 3);
                model.setValueAt(String.format("%d", (intervaloActual+1)-procesoFCFS.getTiempoLlegada()),procesoFCFS.getIdentificador() , 4);
                model.setValueAt(String.format("%d", ((intervaloActual+1)-procesoFCFS.getTiempoLlegada())-procesoFCFS.getTiempoAQuemar()),procesoFCFS.getIdentificador() , 5);
            }else{
                Proceso procesoFCFS = lista.get(0);
                procesoFCFS.quemarTiempo();
            
                this.agregarEjecucionDiagrama(procesoFCFS.getAlias(), intervaloActual);
                this.agregarRegistro(String.format(
                        "Se ah ejecutado un intervalo del proceso %s", procesoFCFS.getAlias()
                ));
                this.agregarRegistro(String.format(
                        "Al proceso %s le quedan %d intervalos", procesoFCFS.getAlias(), procesoFCFS.getTiempoRestante()
                ));
                if(procesoFCFS.getTiempoRestante() == 0){
                    DefaultTableModel model = (DefaultTableModel)this.tablaProcesos.getModel();
                    model.setValueAt(String.format("%d", intervaloActual+1),procesoFCFS.getIdentificador() , 3);
                    model.setValueAt(String.format("%d", (intervaloActual+1)-procesoFCFS.getTiempoLlegada()),procesoFCFS.getIdentificador() , 4);
                    model.setValueAt(String.format("%d", ((intervaloActual+1)-procesoFCFS.getTiempoLlegada())-procesoFCFS.getTiempoAQuemar()),procesoFCFS.getIdentificador() , 5);
                }
            }
            
            this.algoritmoFCFS(lista, intervaloActual+1);
        }
    }
    
    
    public void agregarEjecucionDiagrama(String identificadorProceso, int location){
        JTextPane textPane = new JTextPane();
        textPane.setText(identificadorProceso);
        textPane.setSize(this.ganttPanel.getWidth(), this.ganttPanel.getHeight()/9);
        this.ganttPanel.add(textPane);
        this.ganttPanel.repaint();
    }
    
    
    

    
}
