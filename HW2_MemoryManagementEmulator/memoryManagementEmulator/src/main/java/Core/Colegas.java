/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Core;

import java.awt.Color;

/**
 *
 * @author RDragon197
 */
public class Colegas {

    private int idParticion = 0;
    private int idHermano = 0;
    private MemoriaColegas memoria = new MemoriaColegas();

    public Colegas(MemoriaColegas memoria) {
        this.memoria = memoria;
    }

    public void nEjecucion(int tmPrograma, ProcesoColegas proceso) {
        int i = this.getMemoria().getParticiones().size() - 1;
        int r = 0;

        boolean centinela = true;
        if (!this.memoria.getParticiones().isEmpty()) {
            int id = idParticion++;
            int idHer = idHermano++;
            while (centinela) {
                ParticionColegas NParticion = new ParticionColegas();

                if (tmPrograma == this.getMemoria().getParticion(i).getTmemoria() && false == this.getMemoria().getParticion(i).ispExiste()) {
                    r = -1;
                    proceso.setCorriendo(true);
                    this.getMemoria().getParticion(i).setpExiste(true);
                    this.getMemoria().getParticion(i).setProceso(proceso);
                }

                if (tmPrograma <= this.getMemoria().getParticion(i).getTmemoria() && false == this.getMemoria().getParticion(i).ispExiste()) {
                    ParticionColegas Nparticion2 = new ParticionColegas();
                    int ParMem = this.getMemoria().getParticion(i).getTmemoria();
                    int sPar = ParMem / 2;
                    int l = getL(sPar);

                    NParticion.setId(id);
                    NParticion.setpExiste(false);
                    NParticion.setTmemoria(sPar);
                    NParticion.setIdHder(idHer);
                    this.getMemoria().remplazePartition(i, NParticion);

                    Nparticion2.setId(id++);
                    Nparticion2.setL(l);
                    Nparticion2.setProceso(null);
                    Nparticion2.setTmemoria(sPar);
                    Nparticion2.setpExiste(false);
                    Nparticion2.setIdHder(idHer);
                    this.getMemoria().getParticiones().addLast(Nparticion2);

                }

                if (((int) this.getMemoria().getParticion(i).getTmemoria() / 2) < tmPrograma && tmPrograma <= ((int) this.getMemoria().getParticion(i).getTmemoria())) {
                    if (!this.memoria.getParticion(i).ispExiste()) {
                        //JOptionPane.showMessageDialog(rootPane, "No hay procesos afileados");
                        r = -1;
                        proceso.setCorriendo(true);
                        this.getMemoria().getParticion(i).setpExiste(true);
                        this.getMemoria().getParticion(i).setProceso(proceso);
                    }
                }

                i--;
                if (i < 0 || r == -1) {
                    centinela = false;
                }

            }
        }

        this.getMemoria().getProcesos().add(proceso);
    }

    public void primeraEjecucion(int tmPrograma, ProcesoColegas proceso) {
        int i = 0;
        int r = 0;

        boolean centinela = true;
        if (!this.memoria.getParticiones().isEmpty()) {
            while (centinela) {
                int id = idParticion++;
                int idHer = idHermano++;
                ParticionColegas NParticion = new ParticionColegas();

                if (((int) this.getMemoria().getParticion(i).getTmemoria() / 2) < tmPrograma && tmPrograma <= ((int) this.getMemoria().getParticion(i).getTmemoria())) {
                    if (!this.memoria.getParticion(i).ispExiste()) {
                        //JOptionPane.showMessageDialog(rootPane, "No hay procesos afileados");
                        r = -1;
                        proceso.setCorriendo(true);
                        this.getMemoria().getParticion(i).setpExiste(true);
                        this.getMemoria().getParticion(i).setProceso(proceso);
                    }
                } else if (this.getMemoria().getParticion(i).getProceso() == null && this.getMemoria().isparDis()) {
                    ParticionColegas Nparticion2 = new ParticionColegas();
                    int ParMem = this.getMemoria().getParticion(i).getTmemoria();
                    int sPar = ParMem / 2;
                    int l = getL(sPar);

                    NParticion.setId(i);
                    NParticion.setIdHder(idHer);
                    NParticion.setpExiste(false);
                    NParticion.setTmemoria(sPar);
                    this.getMemoria().remplazePartition(i, NParticion);

                    Nparticion2.setL(l);
                    Nparticion2.setProceso(null);
                    Nparticion2.setTmemoria(sPar);
                    Nparticion2.setpExiste(false);
                    Nparticion2.setId(i + 1);
                    Nparticion2.setIdHder(idHer);
                    this.getMemoria().getParticiones().addLast(Nparticion2);

                }

                i++;

                if (this.getMemoria().getParticiones().size() - 1 < i || r == -1) {
                    centinela = false;
                }
            }
        }
    }

    public int getL(int Tmemoria) {
        return (int) (Math.log(Tmemoria) / Math.log(2));
    }

    public boolean hayMemoriaLibre() {
        boolean centinela = false;
        for (ParticionColegas particione : this.getMemoria().getParticiones()) {
            if (particione.ispExiste()) {
                centinela = true;
            }
        }
        return centinela;
    }

    /**
     * @return the memoria
     */
    public MemoriaColegas getMemoria() {
        return memoria;
    }

    /**
     * @param memoria the memoria to set
     */
    public void setMemoria(MemoriaColegas memoria) {
        this.memoria = memoria;
    }

    public int buscarColegaIndex(ParticionColegas particion) {
        int i = 0;
        int index = -1;
        for (ParticionColegas particion1 : this.memoria.getParticiones()) {
            if (particion1.getTmemoria() == particion.getTmemoria() && !particion1.ispExiste()) {
                index = i;
            }
            i++;
        }
        return index;
    }

    public int buscarParIndexProceso(ParticionColegas particion, int idPRoceso) {
        int i = 0;
        int index = -1;
        for (ParticionColegas particion1 : this.memoria.getParticiones()) {
            if (particion1.getTmemoria() == particion.getTmemoria() && particion1.ispExiste() && particion1.getProceso().getId() == idPRoceso) {
                index = i;
            }
            i++;
        }
        return index;
    }

    public ParticionColegas buscarPArticionProceso(int id) {
        ParticionColegas par = new ParticionColegas();
        par = null;
        for (ParticionColegas particion1 : this.memoria.getParticiones()) {
            if (particion1.ispExiste()) {
                if (particion1.getProceso().getId() == id) {
                    par = particion1;
                }
            }

        }
        return par;
    }

}
