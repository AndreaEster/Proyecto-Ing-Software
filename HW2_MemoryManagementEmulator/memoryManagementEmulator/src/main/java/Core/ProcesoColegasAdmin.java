/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Core;

import java.util.LinkedList;

/**
 *
 * @author RDragon197
 */
public class ProcesoColegasAdmin {

    private LinkedList<ProcesoColegas> procesos = new LinkedList();

    /**
     * @return the procesos
     */
    public LinkedList<ProcesoColegas> getProcesos() {
        return procesos;
    }

    /**
     * @param procesos the procesos to set
     */
    public void setProcesos(LinkedList procesos) {
        this.procesos = procesos;
    }

    public boolean agregarProceso(ProcesoColegas proceso) {

        return this.procesos.add(proceso);
    }
    public ProcesoColegas getProceso(int id){
        return this.procesos.get(id);
    }
}
