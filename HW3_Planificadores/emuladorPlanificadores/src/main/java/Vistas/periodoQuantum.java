/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vistas;

import javax.swing.JOptionPane;

/**
 *
 * @author Ramon Rivera este formulario recibe la informacion de la memoria a
 * asignar dentro de nuestra simulacion Contiene como parametro El Tamaño de la
 * memoria
 */
public class periodoQuantum extends javax.swing.JInternalFrame {

    /**
     * Creates new form BrotherSeg
     */
    public periodoQuantum() {
        initComponents();
        this.RButton1024.requestFocus();
        this.RButton1024.setSelected(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        RButton1024 = new javax.swing.JRadioButton();
        RButton4096 = new javax.swing.JRadioButton();
        RButton2048 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Segmentacion colega");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BIENVENIDO Al ALGORITMO RUN ROBIN");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("¿ QUE PERIODO DEL QUANTUM DESEAS USAR ?");

        RButton1024.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        RButton1024.setText("1 T");
        RButton1024.setName("RButton1024"); // NOI18N
        RButton1024.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RButton1024ActionPerformed(evt);
            }
        });

        RButton4096.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        RButton4096.setText("10 T");
        RButton4096.setName("RButton4096"); // NOI18N
        RButton4096.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RButton4096ActionPerformed(evt);
            }
        });

        RButton2048.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        RButton2048.setText("5 T");
        RButton2048.setName("RButton2048"); // NOI18N
        RButton2048.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RButton2048ActionPerformed(evt);
            }
        });

        jButton1.setText("COMENCEMOS");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(RButton1024)
                        .addGap(182, 182, 182)
                        .addComponent(RButton2048)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(RButton4096)
                        .addGap(37, 37, 37)))
                .addContainerGap(39, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(262, 262, 262)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RButton1024)
                    .addComponent(RButton4096)
                    .addComponent(RButton2048))
                .addGap(37, 37, 37)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(127, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Author: Ramon Rivera
     *
     * @param evt Este metodo no recibe parametros solo se encarga de desactivar
     * los radiobuttons que esten anterior mente seleccionados al momento de dar
     * click
     */
    private void RButton2048ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RButton2048ActionPerformed
        this.RButton1024.setSelected(false);
        this.RButton4096.setSelected(false);
    }//GEN-LAST:event_RButton2048ActionPerformed

    /**
     * Author: Ramon Rivera
     *
     * @param evt Este metodo no recibe parametros solo se encarga de desactivar
     * los radiobuttons que esten anterior mente seleccionados al momento de dar
     * click
     */
    private void RButton4096ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RButton4096ActionPerformed
        this.RButton2048.setSelected(false);
        this.RButton1024.setSelected(false);
    }//GEN-LAST:event_RButton4096ActionPerformed

    /**
     * Author: Ramon Rivera
     *
     * @param evt Este metodo no recibe parametros solo se encarga de desactivar
     * los radiobuttons que esten anterior mente seleccionados al momento de dar
     * click
     */
    private void RButton1024ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RButton1024ActionPerformed
        this.RButton4096.setSelected(false);
        this.RButton2048.setSelected(false);
    }//GEN-LAST:event_RButton1024ActionPerformed

    /**
     * Author: Ramon Rivera
     *
     * @param evt
     *
     * Este evento obtine la cantidad de memoria seleccionada por el usuario y
     * la guarda en una varia ble <b>int</b> Tmemoria, la cual almacena la
     * seleccion echa por el usuario
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int Tmemoria;
        Tmemoria = (this.RButton1024.isSelected()) ? 1 : (this.RButton4096.isSelected()) ? 10 : (this.RButton2048.isSelected()) ? 5 : 0;
        principalRunRobin prunRobin = new principalRunRobin();
        prunRobin.setLabel(Tmemoria);
        MenuPrincipal.panelPrincipal.add(prunRobin).setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton RButton1024;
    private javax.swing.JRadioButton RButton2048;
    private javax.swing.JRadioButton RButton4096;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
