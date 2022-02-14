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
public class ParticionColegasAdmin {

    private LinkedList<ParticionColegas> particiones = new LinkedList();

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

    public boolean setParticion(ParticionColegas particion) {
        return this.particiones.add(particion);
    }

    public ParticionColegas getParticion(int id) {
        return this.getParticiones().get(id);
    }
}
