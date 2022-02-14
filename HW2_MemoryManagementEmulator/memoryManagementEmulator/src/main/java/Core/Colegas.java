/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Core;

/**
 *
 * @author RDragon197
 */
public class Colegas {

    private int idParticion = 0;
    MemoriaColegas memoria = new MemoriaColegas();

    public Colegas(MemoriaColegas memoria) {
        this.memoria = memoria;
    }

    public void nEjecucion(int tmPrograma, ProcesoColegas proceso) {
        int i = this.memoria.getParticiones().size() - 1;
        int r = 0;

        boolean centinela = true;
        if (!this.memoria.getParticiones().isEmpty()) {
            while (centinela) {
                ParticionColegas NParticion = new ParticionColegas();
                NParticion.setId(idParticion++);

                if (tmPrograma == this.memoria.getParticion(i).getTmemoria() && false == this.memoria.getParticion(i).ispExiste()) {
                    r = -1;
                    proceso.setCorriendo(true);
                    this.memoria.getParticion(i).setpExiste(true);
                    this.memoria.getParticion(i).setProceso(proceso);
                }

                if (tmPrograma <= this.memoria.getParticion(i).getTmemoria() && false == this.memoria.getParticion(i).ispExiste()) {
                    ParticionColegas Nparticion2 = new ParticionColegas();
                    int ParMem = this.memoria.getParticion(i).getTmemoria();
                    int sPar = ParMem / 2;
                    int l = getL(sPar);
                    Nparticion2.setL(l);
                    Nparticion2.setProceso(null);
                    Nparticion2.setTmemoria(sPar);
                    Nparticion2.setpExiste(false);
                    NParticion.setpExiste(false);
                    NParticion.setTmemoria(sPar);
                    this.memoria.remplazePartition(i, NParticion);
                    Nparticion2.setId(idParticion++);
                    this.memoria.getParticiones().addLast(Nparticion2);

                }

                if (((int) this.memoria.getParticion(i).getTmemoria() / 2) < tmPrograma && tmPrograma <= ((int) this.memoria.getParticion(i).getTmemoria())) {
                    if (!this.memoria.getParticion(i).ispExiste()) {
                        //JOptionPane.showMessageDialog(rootPane, "No hay procesos afileados");
                        r = -1;
                        proceso.setCorriendo(true);
                        this.memoria.getParticion(i).setpExiste(true);
                        this.memoria.getParticion(i).setProceso(proceso);
                    }
                }

                i--;
                if (i < 0 || r == -1) {
                    centinela = false;
                }

            }
        }
    }

    public void primeraEjecucion(int tmPrograma, ProcesoColegas proceso) {
        int i = 0;
        int r = 0;

        boolean centinela = true;
        if (!this.memoria.getParticiones().isEmpty()) {
            while (centinela) {
                int idPHder = idParticion++;
                ParticionColegas NParticion = new ParticionColegas();
                NParticion.setId(idPHder);

                if (((int) this.memoria.getParticion(i).getTmemoria() / 2) < tmPrograma && tmPrograma <= ((int) this.memoria.getParticion(i).getTmemoria())) {
                    if (!this.memoria.getParticion(i).ispExiste()) {
                        //JOptionPane.showMessageDialog(rootPane, "No hay procesos afileados");
                        r = -1;
                        proceso.setCorriendo(true);
                        this.memoria.getParticion(i).setpExiste(true);
                        this.memoria.getParticion(i).setProceso(proceso);
                    }
                } else if (this.memoria.getParticion(i).getProceso() == null && this.memoria.isparDis()) {
                    ParticionColegas Nparticion2 = new ParticionColegas();
                    int ParMem = this.memoria.getParticion(i).getTmemoria();
                    int sPar = ParMem / 2;
                    int l = getL(sPar);
                    int idHIzsq = idParticion++;
                    Nparticion2.setL(l);
                    Nparticion2.setProceso(null);
                    Nparticion2.setTmemoria(sPar);
                    Nparticion2.setpExiste(false);
                    Nparticion2.setId(idHIzsq);
                    NParticion.setIdHder(i);

                    NParticion.setpExiste(false);
                    NParticion.setTmemoria(sPar);
                    NParticion.setIdHder(idHIzsq);

                    this.memoria.remplazePartition(i, NParticion);
                    this.memoria.getParticiones().addLast(Nparticion2);

                }

                i++;

                if (this.memoria.getParticiones().size() - 1 < i || r == -1) {
                    centinela = false;
                }
            }
        }
    }

    public int getL(int Tmemoria) {
        return (int) (Math.log(Tmemoria) / Math.log(2));
    }
}
