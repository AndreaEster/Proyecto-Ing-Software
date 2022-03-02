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
public class MemoriaColegas {

    private int u;
    private int id;
    private LinkedList<ParticionColegas> particiones = new LinkedList<>();
    private LinkedList<ProcesoColegas> procesos = new LinkedList<>();
    private int Tmemoria;
    private int TMParticiones = 0;

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
     * @return the particiones
     */
    public LinkedList<ParticionColegas> getParticiones() {
        return particiones;
    }

    /**
     * @param particiones the particiones to set
     */
    public void setParticiones(LinkedList<ParticionColegas> particiones) {
        this.particiones = particiones;
    }

    /**
     * @return the procesos
     */
    public LinkedList<ProcesoColegas> getProcesos() {
        return procesos;
    }

    /**
     * @param procesos the procesos to set
     */
    public void setProcesos(LinkedList<ProcesoColegas> procesos) {
        this.procesos = procesos;
    }

    /**
     * @return the Tmemoria
     */
    public int getTmemoria() {
        return Tmemoria;
    }

    /**
     * @param Tmemoria the Tmemoria to set
     */
    public void setTmemoria(int Tmemoria) {
        this.Tmemoria = Tmemoria;
    }

    public boolean setParticion(ParticionColegas particion) {
        return this.particiones.add(particion);
    }

    public ParticionColegas getParticion(int id) {
        return this.particiones.get(id);
    }

    /**
     * @return the u
     */
    public int getU() {
        return u;
    }

    /**
     * @param u the u to set
     */
    public void setU(int u) {
        this.u = u;
    }

    public boolean remplazePartition(int id, ParticionColegas particion) {
        boolean status = false;
        try {
            this.particiones.set(id, particion);
            status = true;
        } catch (Exception e) {

        }
        return status;
    }

    /**
     * @return the TMParticiones
     */
    public int getTMParticiones() {
        this.TMParticiones = 0;
        for (int i = 0; i < this.particiones.size(); i++) {
            this.TMParticiones = this.TMParticiones + this.particiones.get(i).getTmemoria();
        }
        return TMParticiones;
    }

    public boolean isparDis() {
        return (this.TMParticiones == this.Tmemoria) ? false : true;
    }

}
