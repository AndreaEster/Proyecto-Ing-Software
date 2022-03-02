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

    public int indexProcesoID(int id) {
        int i = 0;
        int index = -1;
        for (ProcesoColegas proceso : this.procesos) {
            if (proceso.getId() == id) {
                index = i;
            }
            i++;
        }
        return index;
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

    public ProcesoColegas getProceso(int id) {
        return this.procesos.get(id);
    }
}
