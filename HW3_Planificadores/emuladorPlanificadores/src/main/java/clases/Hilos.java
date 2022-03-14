/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.awt.Color;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.TitledBorder;

/**
 *
 * @author RDragon197
 */
public class Hilos implements Runnable {

    /**
     * @return the espera
     */
    public LinkedList<Proceso> getEspera() {
        return espera;
    }

    /**
     * @param espera the espera to set
     */
    public void setEspera(LinkedList<Proceso> espera) {
        this.espera = espera;
    }

    /**
     * @return the finalizado
     */
    public LinkedList<Proceso> getFinalizado() {
        return finalizado;
    }

    /**
     * @param finalizado the finalizado to set
     */
    public void setFinalizado(LinkedList<Proceso> finalizado) {
        this.finalizado = finalizado;
    }

    private JProgressBar barradeProceso = null;
    private JPanel jPanelMemoria = null;
    private LinkedList<Proceso> listos = new LinkedList();
    private LinkedList<Proceso> espera = new LinkedList();
    private LinkedList<Proceso> finalizado = new LinkedList();
    private JLabel nProceso = new JLabel();
    private boolean centinela = true;
    private int totalQuantum = 1;
    private int tEjecucion = 0;

    /**
     * Este proceso ejecuta el algoritmo <B>RUNROBYN</B> donde tiene tres
     * listas, listo espera y finalizado mueve cada proceso segun el estado en
     * el que se va encontrando hasta finalizar con todos los procesos
     *
     */
    @Override
    public void run() {
        while (this.centinela) {
            graficarBarra(0);

            graficarListo();

            if (!listos.isEmpty()) {
                if (listos.peek().isFinalizado()) {
                    finalizado.add(listos.poll());
                } else {
                    espera.add(listos.poll());
                }
            }
            if (!espera.isEmpty()) {
                if (espera.peek().getQuantum() >= 0) {
                    espera.peek().setQuantum(espera.peek().getQuantum() - totalQuantum);

                    //int pBarra = Math.round(getPorcentajeBarra((float) Float.valueOf(espera.peek().getiDebarra()), (float) Float.valueOf(espera.peek().getInicialQ())));
                    espera.peek().setStatus(true);
                    espera.peek().setEspera(false);

                    graficarListo();
                    this.nProceso.setText("EL PROCESO EN EJECUCION ES:" + espera.peek().getNombre());
                    for (int i = 1; i <= totalQuantum; i++) {
                        espera.peek().setiDebarra(espera.peek().getiDebarra() + 1);
                        graficarBarra(espera.peek().getiDebarra());
                        esperar();
                    }

                    if (espera.peek().getQuantum() <= 0) {
                        espera.peek().setFinalizado(true);
                        espera.peek().settEjecucion(tEjecucion);
                        espera.peek().setEspera(false);
                        espera.peek().setStatus(false);
                    } else {
                        espera.peek().setFinalizado(false);
                        espera.peek().setEspera(true);
                        espera.peek().setStatus(false);
                    }
                    listos.add(espera.poll());
                }
            }

            if (listos.isEmpty() && espera.isEmpty() && !finalizado.isEmpty()) {
                centinela = false;
            }

            tEjecucion++;

        }
        this.nProceso.setText("FINALIZADO!!!");
        this.barradeProceso.setValue(100);
        this.barradeProceso.setString("100%");
    }

    /**
     * este metodo obtiene el porcentaje de la barra de progreso en base a su
     * tiempo de ejecucion
     *
     * @param quantum
     * @return
     */
    public float getPorcentajeBarra(float i, float quantum) {
        //Obtenemos el porcentaje de ejecucion de la barra
        float resultado = 1;
        if (i > quantum) {
            resultado = (float) (quantum / i) * 100;
        } else {
            resultado = (float) (i / quantum) * 100;
        }

        return resultado;
    }

    /**
     * con este metodo graficamos los procesos en forma de jpanel ya procesados
     */
    public void graficarListo() {
        this.jPanelMemoria.removeAll();

        LinkedList<Proceso> allProcesos = new LinkedList();
        if (!listos.isEmpty()) {
            allProcesos.addAll(listos);
        }
        if (!espera.isEmpty()) {
            allProcesos.addAll(espera);
        }
        if (!finalizado.isEmpty()) {
            allProcesos.addAll(finalizado);
        }

        int width = getTParticiones(allProcesos, this.jPanelMemoria.getWidth());
        int desplazamientoX = 0;

        for (Proceso proceso : allProcesos) {
            JPanel jProceso = new JPanel();
            JLabel jlbR = new JLabel();
            String estado = "";
            Color color = null;
            if (proceso.isEspera()) {
                estado = "Espera...";
                color = Color.gray;
            } else if (proceso.isStatus()) {
                estado = "Run...";
                color = Color.red;
            } else if (proceso.isFinalizado()) {
                estado = "Finalizado en:" + proceso.gettEjecucion() + "s N:" + proceso.getId();
                color = Color.green;
            }

            jlbR.setText(estado);

            jProceso.setLocation(this.jPanelMemoria.getLocation().x + desplazamientoX, this.jPanelMemoria.getLocation().y - 40);
            jProceso.setSize(width, 100);
            jProceso.setBackground(color);
            jProceso.setBorder(new TitledBorder(proceso.getNombre()));
            jProceso.add(jlbR);

            desplazamientoX = desplazamientoX + width;
            this.jPanelMemoria.add(jProceso);
        }

        this.jPanelMemoria.revalidate();
        this.jPanelMemoria.repaint();
    }

    /**
     * Este metodo obtiene el tamano de las particiones de los jpanel
     *
     * @param procesos
     * @param tPanel
     * @return
     */
    public int getTParticiones(LinkedList<Proceso> procesos, int tPanel) {

        return (int) tPanel / procesos.size();
    }

    /**
     * Con este metodo podemos graficar la barra de progreso principal segun el
     * proceso en ejecucion
     *
     * @param i
     */
    public void graficarBarra(int i) {
        this.getBarradeProceso().setValue(i);
        this.getBarradeProceso().setString(String.valueOf(i) + "%");
        this.getBarradeProceso().revalidate();
        this.getBarradeProceso().repaint();
    }

    /**
     * Este proceso genera un tiempo de espera en la ejecucion del programa
     */
    public void esperar() {
        try {
            Thread.sleep(100); //Dormir sistema
        } catch (InterruptedException ex) {
            Logger.getLogger(Hilos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * @return the barradeProceso
     */
    public JProgressBar getBarradeProceso() {
        return barradeProceso;
    }

    /**
     * @param barradeProceso the barradeProceso to set
     */
    public void setBarradeProceso(JProgressBar barradeProceso) {
        this.barradeProceso = barradeProceso;
    }

    /**
     * @return the procesos
     */
    public LinkedList<Proceso> getProcesos() {
        return listos;
    }

    /**
     * @param procesos the procesos to set
     */
    public void setProcesos(LinkedList<Proceso> procesos) {
        this.listos = procesos;
    }

    /**
     * @return the jPanelMemoria
     */
    public JPanel getjPanelMemoria() {
        return jPanelMemoria;
    }

    /**
     * @param jPanelMemoria the jPanelMemoria to set
     */
    public void setjPanelMemoria(JPanel jPanelMemoria) {
        this.jPanelMemoria = jPanelMemoria;
    }

    /**
     * @return the totalQuantum
     */
    public int getTotalQuantum() {
        return totalQuantum;
    }

    /**
     * @param totalQuantum the totalQuantum to set
     */
    public void setTotalQuantum(int totalQuantum) {
        this.totalQuantum = totalQuantum;
    }

    /**
     * @return the nProceso
     */
    public JLabel getnProceso() {
        return nProceso;
    }

    /**
     * @param nProceso the nProceso to set
     */
    public void setnProceso(JLabel nProceso) {
        this.nProceso = nProceso;
    }

}
