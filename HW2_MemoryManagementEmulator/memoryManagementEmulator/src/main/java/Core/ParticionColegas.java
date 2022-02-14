/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Core;

/**
 *
 * @author RDragon197
 */
public class ParticionColegas {
    private int id;
    private int l;
    private int Tmemoria;
    private ProcesoColegas proceso;
    private boolean pExiste = false;

    public int getL(){
    return (int) (Math.log(Tmemoria) / Math.log(2));
    }
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

    /**
     * @return the proceso
     */
    public ProcesoColegas getProceso() {
        return proceso;
    }

    /**
     * @param proceso the proceso to set
     */
    public void setProceso(ProcesoColegas proceso) {
        this.proceso = proceso;
    }

    /**
     * @return the l
     */

    /**
     * @param l the l to set
     */
    public void setL(int l) {
        this.l = l;
    }

    /**
     * @return the pExiste
     */
    public boolean ispExiste() {
        return pExiste;
    }

    /**
     * @param pExiste the pExiste to set
     */
    public void setpExiste(boolean pExiste) {
        this.pExiste = pExiste;
    }
    
   
    
}
