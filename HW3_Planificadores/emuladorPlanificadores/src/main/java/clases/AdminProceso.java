/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.LinkedList;

/**
 *
 * @author RDragon197
 */
public class AdminProceso {

    private Proceso proceso = null;
    private LinkedList<Proceso> procesos = new LinkedList();

    /**
     * @return the procesos
     */
    public LinkedList<Proceso> getProcesos() {
        return procesos;
    }

    /**
     * @param procesos the procesos to set
     */
    public void setProcesos(LinkedList<Proceso> procesos) {
        this.procesos = procesos;
    }

    public boolean setProceso(Proceso proceso) {

        return this.procesos.add(proceso);
    }
}
