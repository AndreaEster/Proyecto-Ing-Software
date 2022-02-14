/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Views;


import Core.MemoriaColegas;
import Core.ParticionColegas;
import Core.ParticionColegasAdmin;
import Core.ProcesoColegas;
import Core.ProcesoColegasAdmin;
import java.awt.Color;
import java.awt.Event;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 *
 * @author RDragon197
 */
public class JFColegasDashboard extends javax.swing.JInternalFrame {

    public int Tmemoria;
    int idProceso = 0;
    int idParticion = 0;
    int U = 0;
    int L = 0;
    int ej = 0;
    ProcesoColegasAdmin procesos = new ProcesoColegasAdmin();
    ProcesoColegas proceso = new ProcesoColegas();
    ParticionColegas particion = new ParticionColegas();
    ParticionColegasAdmin particiones = new ParticionColegasAdmin();
    MemoriaColegas memoria = new MemoriaColegas();

    /**
     * Creates new form JFColegasDashboard
     */
    public JFColegasDashboard() {
        initComponents();

    }

    public void setLabel(int Tmemoria) {
        this.U = (int) (Math.log(Tmemoria) / Math.log(2));
        this.Tmemoria = (int) Math.pow(2, U);

        this.particion.setId(0);
        this.particion.setProceso(null);
        this.particion.setTmemoria(Tmemoria);
        this.memoria.setU(U);
        this.memoria.setParticion(particion);
        this.memoria.setId(0);
        this.memoria.setTmemoria(Tmemoria);
        //vamos a asumir que ya existe una particion de tamaño Tmemoria
        this.jLabel1.setText("La memoria escogida es: " + Tmemoria + " MB");
        graficarPanel(this.jPanelMemoria, 10, 22, 430, 105, String.valueOf(Tmemoria) + " MB", Color.orange, false);
    }

    public int getL(int Tmemoria) {
        return (int) (Math.log(Tmemoria) / Math.log(2));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanelMemoria = new javax.swing.JPanel();
        jPanelProcesos = new javax.swing.JPanel();
        jComboBoxProgramas = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Segmentacion Colega Simulacion de memoria");
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("¿QUE ESTA PASANDO EN MI MEMORIA?");

        jPanelMemoria.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MEMORIA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        javax.swing.GroupLayout jPanelMemoriaLayout = new javax.swing.GroupLayout(jPanelMemoria);
        jPanelMemoria.setLayout(jPanelMemoriaLayout);
        jPanelMemoriaLayout.setHorizontalGroup(
            jPanelMemoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelMemoriaLayout.setVerticalGroup(
            jPanelMemoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 98, Short.MAX_VALUE)
        );

        jPanelProcesos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PROCESOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        javax.swing.GroupLayout jPanelProcesosLayout = new javax.swing.GroupLayout(jPanelProcesos);
        jPanelProcesos.setLayout(jPanelProcesosLayout);
        jPanelProcesosLayout.setHorizontalGroup(
            jPanelProcesosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 122, Short.MAX_VALUE)
        );
        jPanelProcesosLayout.setVerticalGroup(
            jPanelProcesosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 294, Short.MAX_VALUE)
        );

        jComboBoxProgramas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jComboBoxProgramas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "GOOGLE CHROME", "PUBG", "NETFLIX DESKTOP", "WORD", "EXCEL" }));

        jButton1.setText("CORRER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("MB");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("JLABEL");

        jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###0"))));
        jFormattedTextField1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jFormattedTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jFormattedTextField1MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("SELECCIONE UN PROGRAMA Y ASIGNE LA MEMORIA A UTILIZAR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelMemoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBoxProgramas, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)))
                        .addGap(0, 22, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelProcesos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jPanelProcesos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jPanelMemoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxProgramas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(15, 15, 15)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.jPanelMemoria.removeAll();
        this.jPanelProcesos.removeAll();
        ProcesoColegas proceso = new ProcesoColegas();
        int tmPrograma = Integer.valueOf(this.jFormattedTextField1.getText());
        proceso.setId(idProceso++);
        proceso.setNombre(this.jComboBoxProgramas.getSelectedItem().toString());
        proceso.setTamaño(tmPrograma);

        if (ej == 0) {
            primeraEjecucion(tmPrograma, proceso);
            ej++;
        } else {
            nEjecucion(tmPrograma, proceso);
        }

        int x = 0;
        for (int i = 0; i < this.memoria.getParticiones().size(); i++) {
            graficarPanel(jPanelMemoria, x + 15, 20, getPixelesDeParticion((float) this.memoria.getParticion(i).getTmemoria(), (float) this.memoria.getTmemoria(), this.jPanelMemoria.getSize().width), 105, String.valueOf(this.memoria.getParticion(i).getTmemoria()), (this.memoria.getParticion(i).ispExiste()) ? Color.green : Color.GRAY, false);
            x = x + getPixelesDeParticion(this.memoria.getParticion(i).getTmemoria(), this.memoria.getTmemoria(), this.jPanelMemoria.getWidth());
        }

        int y = 20;
        for (int i = 0; i < this.memoria.getParticiones().size(); i++) {
            if (this.memoria.getParticion(i).ispExiste()) {
                graficarPanel(jPanelProcesos, 12, y, this.jPanelProcesos.getSize().width - 20, 35, this.memoria.getParticion(i).getProceso().getNombre(), Color.green, false);
                y = y + 36;
            }
        }


    }//GEN-LAST:event_jButton1ActionPerformed
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
                    this.memoria.setParticion(Nparticion2);

                }

                if (((int) this.memoria.getParticion(i).getTmemoria() / 2) < tmPrograma && tmPrograma <= ((int) this.memoria.getParticion(i).getTmemoria())) {
                    if (!this.memoria.getParticion(i).ispExiste()) {
                        //JOptionPane.showMessageDialog(rootPane, "No hay procesos afileados");
                        r = -1;
                        this.proceso.setCorriendo(true);
                        this.memoria.getParticion(i).setpExiste(true);
                        this.memoria.getParticion(i).setProceso(proceso);
                    }
                }

                i--;
                if (i < 0 || r == -1) {
                    centinela = false;
                }

            }

            //JOptionPane.showMessageDialog(rootPane, "Finalizo la operacion correctamente: " + this.memoria.getTMParticiones());
//            for (int j = 0; j < this.memoria.getParticiones().size(); j++) {
//                JOptionPane.showMessageDialog(rootPane, "Tamaño: " + this.memoria.getParticion(j).getTmemoria() + " estado:" + this.memoria.getParticion(j).ispExiste());
//            }
        }
    }

    public void primeraEjecucion(int tmPrograma, ProcesoColegas proceso) {
        int i = 0;
        int r = 0;

        boolean centinela = true;
        if (!this.memoria.getParticiones().isEmpty()) {
            while (centinela) {
                ParticionColegas NParticion = new ParticionColegas();
                NParticion.setId(idParticion++);

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
                    Nparticion2.setL(l);
                    Nparticion2.setProceso(null);
                    Nparticion2.setTmemoria(sPar);
                    Nparticion2.setpExiste(false);
                    NParticion.setpExiste(false);
                    NParticion.setTmemoria(sPar);
                    this.memoria.remplazePartition(i, NParticion);
                    Nparticion2.setId(idParticion++);
                    this.memoria.setParticion(Nparticion2);

                }

                i++;

                if (this.memoria.getParticiones().size() - 1 < i || r == -1) {
                    centinela = false;
                }
            }
//
//            JOptionPane.showMessageDialog(rootPane, "Finalizo la operacion correctamente: " + this.memoria.getTMParticiones());
//
//            for (int j = 0; j < this.memoria.getParticiones().size(); j++) {
//                JOptionPane.showMessageDialog(rootPane, "Tamaño: " + this.memoria.getParticion(j).getTmemoria() + " estado:" + this.memoria.getParticion(j).ispExiste());
//            }
        }
    }

    public void graficarPanel(JPanel thisPanel, int x, int y, int width, int heigth, String nameProgram, Color color, boolean frack) {
        JPanel jParticion = new JPanel();
        JPanel jPFrack = new JPanel();
        jParticion.setSize(width, heigth);
        jParticion.setLocation(x, y);
        jParticion.setBorder(new TitledBorder(nameProgram));
        jParticion.setBackground(color);

        jPFrack.setBackground(Color.red);
        jPFrack.setSize(50, 50);
        jPFrack.setLocation(jParticion.getLocation().x + 44, jParticion.getLocation().y + 40);
        //jParticion.add(jPFrack);

        if (frack) {
            thisPanel.add(jPFrack);
        }

        thisPanel.add(jParticion);
        thisPanel.revalidate();
        thisPanel.repaint();

    }

    public int getPixelesDeParticion(float TPrograma, float TMemoria, int parPanel) {
        //JOptionPane.showMessageDialog(rootPane, "Tprograma:" + TPrograma + "TMemoria:" + TMemoria);
        float resultado = (float) (TPrograma / TMemoria) * parPanel;
        //JOptionPane.showMessageDialog(rootPane, "Resultado pixeles:" + resultado);
        return (int) Math.round(resultado);
    }

    private void jFormattedTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jFormattedTextField1MouseClicked

    }//GEN-LAST:event_jFormattedTextField1MouseClicked

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        jPanelMemoria.removeAll();
        jPanelProcesos.removeAll();
        int x = 0;
        for (int i = 0; i < this.memoria.getParticiones().size(); i++) {
            graficarPanel(jPanelMemoria, x + 15, 20, getPixelesDeParticion((float) this.memoria.getParticion(i).getTmemoria(), (float) this.memoria.getTmemoria(), this.jPanelMemoria.getSize().width), 105, String.valueOf(this.memoria.getParticion(i).getTmemoria()), (this.memoria.getParticion(i).ispExiste()) ? Color.green : Color.GRAY, false);
            x = x + getPixelesDeParticion(this.memoria.getParticion(i).getTmemoria(), this.memoria.getTmemoria(), this.jPanelMemoria.getWidth());
        }

        int y = 20;
        for (int i = 0; i < this.memoria.getParticiones().size(); i++) {
            if (this.memoria.getParticion(i).ispExiste()) {
                graficarPanel(jPanelProcesos, 12, y, this.jPanelProcesos.getSize().width - 20, 35, this.memoria.getParticion(i).getProceso().getNombre(), Color.green, false);
                y = y + 36;
            }
        }
    }//GEN-LAST:event_formComponentResized

    @Override
    public boolean action(Event evt, Object what) {
        return super.action(evt, what); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBoxProgramas;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanelMemoria;
    private javax.swing.JPanel jPanelProcesos;
    // End of variables declaration//GEN-END:variables

}