/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author RDragon197
 */
public class Proceso {

    private int id;
    private String nombre;
    private int inicialQ = 1;
    private int quantum;
    private boolean Status = false;
    private boolean espera = false;
    private boolean finalizado = false;
    private int iDebarra = 1;
    private int tEjecucion = 0;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the quantum
     */
    public int getQuantum() {
        return quantum;
    }

    /**
     * @param quantum the quantum to set
     */
    public void setQuantum(int quantum) {
        this.quantum = quantum;
    }

    /**
     * @return
     */
    public boolean isStatus() {
        return Status;
    }

    /**
     * @param Status the Status to set
     */
    public void setStatus(boolean Status) {
        this.Status = Status;
    }

    /**
     * @return the finalizado
     */
    public boolean isFinalizado() {
        return finalizado;
    }

    /**
     * @param finalizado the finalizado to set
     */
    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    /**
     * @return the iDebarra
     */
    public int getiDebarra() {
        return iDebarra;
    }

    /**
     * @param iDebarra the iDebarra to set
     */
    public void setiDebarra(int iDebarra) {
        this.iDebarra = iDebarra;
    }

    /**
     * @return the inicialQ
     */
    public int getInicialQ() {
        return inicialQ;
    }

    /**
     * @param inicialQ the inicialQ to set
     */
    public void setInicialQ(int inicialQ) {
        this.inicialQ = inicialQ;
    }

    /**
     * @return the espera
     */
    public boolean isEspera() {
        return espera;
    }

    /**
     * @param espera the espera to set
     */
    public void setEspera(boolean espera) {
        this.espera = espera;
    }

    /**
     * @return the tEjecucion
     */
    public int gettEjecucion() {
        return tEjecucion;
    }

    /**
     * @param tEjecucion the tEjecucion to set
     */
    public void settEjecucion(int tEjecucion) {
        this.tEjecucion = tEjecucion;
    }

}
