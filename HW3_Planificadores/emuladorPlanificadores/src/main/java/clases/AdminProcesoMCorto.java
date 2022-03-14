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
public class AdminProcesoMCorto {

    private ProcesoPMCorto proceso = null;
    private LinkedList<ProcesoPMCorto> procesos = new LinkedList();

    /**
     * @return the procesos
     */
    public LinkedList<ProcesoPMCorto> getProcesos() {
        return procesos;
    }

    /**
     * @param procesos the procesos to set
     */
    public void setProcesos(LinkedList<ProcesoPMCorto> procesos) {
        this.procesos = procesos;
    }

    public boolean setProceso(ProcesoPMCorto proceso) {

        return this.procesos.add(proceso);
    }
}
