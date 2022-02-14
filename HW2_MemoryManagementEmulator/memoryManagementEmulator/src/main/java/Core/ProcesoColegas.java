/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Core;

import java.awt.Color;

/**
 *
 * @author RDragon197 Esta clase recivira todos los procesos asignado por el
 * usuario desde el dashboard
 */
public class ProcesoColegas {

    private int id;
    private String nombre;
    private int tamaño;
    private boolean existente = false;
    private boolean corriendo = false;
    private Color color = Color.red;

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
     * @return the tamaño
     */
    public int getTamaño() {
        return tamaño;
    }

    /**
     * @param tamaño the tamaño to set
     */
    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    /**
     * @return the dirMemoria
     */
    public boolean getExistente() {
        return existente;
    }

    /**
     * @param dirMemoria the dirMemoria to set
     */
    public void setExistente(boolean dirMemoria) {
        this.existente = dirMemoria;
    }

    /**
     * @return the corriendo
     */
    public boolean isCorriendo() {
        return corriendo;
    }

    /**
     * @param corriendo the corriendo to set
     */
    public void setCorriendo(boolean corriendo) {
        this.corriendo = corriendo;
    }

    /**
     * @return the color
     */
    public Color getColor() {
        return (this.isCorriendo()) ? Color.green : Color.gray;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }

}
