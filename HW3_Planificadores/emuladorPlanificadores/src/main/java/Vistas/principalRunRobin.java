/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vistas;

import clases.AdminProceso;
import clases.Hilos;
import clases.Proceso;
import java.awt.Color;
import java.awt.Event;
import java.util.LinkedList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 *
 * @author RDragon197
 */
public class principalRunRobin extends javax.swing.JInternalFrame {

    int periodoQuantum = 1;
//    int desplazamientoX = 0;
    int id = 0;
    AdminProceso procesos = new AdminProceso();

    /**
     * Creates new form JFColegasDashboard
     */
    public principalRunRobin() {
        initComponents();

    }

    public void setLabel(int quantum) {
        this.periodoQuantum = quantum;
        this.jLabel1.setText("El periodo seleccionado es: " + String.valueOf(this.periodoQuantum) + " Unidades de tiempo");
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
        jComboBoxProgramas = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

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
        jLabel2.setText("¿QUE ESTA PASANDO EN MI PROCESADOR?");

        jPanelMemoria.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PROCESADOR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        javax.swing.GroupLayout jPanelMemoriaLayout = new javax.swing.GroupLayout(jPanelMemoria);
        jPanelMemoria.setLayout(jPanelMemoriaLayout);
        jPanelMemoriaLayout.setHorizontalGroup(
            jPanelMemoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 578, Short.MAX_VALUE)
        );
        jPanelMemoriaLayout.setVerticalGroup(
            jPanelMemoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 98, Short.MAX_VALUE)
        );

        jComboBoxProgramas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jComboBoxProgramas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "GOOGLE CHROME", "PUBG", "NETFLIX DESKTOP", "WORD", "EXCEL" }));

        jButton1.setText("AGREGAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("UT");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("JLABEL");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("SELECCIONE UN PROGRAMA Y ASIGNE EL QUANTUM A UTILIZAR");

        jProgressBar1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jProgressBar1.setForeground(new java.awt.Color(0, 0, 0));
        jProgressBar1.setStringPainted(true);

        jButton2.setText("CORRER");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("EL PROCESO EN EJECUCION ES:");

        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });

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
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jComboBoxProgramas, 0, 256, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jButton2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelMemoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxProgramas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jButton1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        int tmQuantum = Integer.valueOf(this.jTextField1.getText());

        Proceso proceso = new Proceso();
        proceso.setId(id);
        proceso.setNombre((String) this.jComboBoxProgramas.getSelectedItem());
        proceso.setQuantum(tmQuantum);
        proceso.setInicialQ(tmQuantum);
        proceso.setStatus(false);

        procesos.setProceso(proceso);

        graficarListo(procesos.getProcesos());

        id++;


    }//GEN-LAST:event_jButton1ActionPerformed

//    public void graficar(LinkedList<Proceso> procesos) {
//        this.jPanelMemoria.removeAll();
//        int width = getTParticiones(procesos, this.jPanelMemoria.getWidth());
//        int desplazamientoX = 0;
//        
//        for (Proceso proceso : procesos) {
//            JPanel jProceso = new JPanel();
//            JLabel jlbR = new JLabel();
//            String estado = (proceso.isStatus()) ? "Run" : "Espera";
//            jlbR.setText(estado);
//            
//            jProceso.setLocation(this.jPanelMemoria.getLocation().x + desplazamientoX, this.jPanelMemoria.getLocation().y - 40);
//            jProceso.setSize(width, 100);
//            jProceso.setBackground((proceso.isStatus()) ? Color.red : Color.orange);
//            jProceso.setBorder(new TitledBorder(proceso.getNombre()));
//            jProceso.add(jlbR);
//            
//            desplazamientoX = desplazamientoX + width;
//            
//            this.jPanelMemoria.add(jProceso);
//            this.jPanelMemoria.revalidate();
//            this.jPanelMemoria.repaint();
//        }
//        
//    }
    public void graficarListo(LinkedList<Proceso> procesos) {
        this.jPanelMemoria.removeAll();
        int width = getTParticiones(procesos, this.jPanelMemoria.getWidth());
        int desplazamientoX = 0;

        for (Proceso proceso : procesos) {
            JPanel jProceso = new JPanel();
            JLabel jlbR = new JLabel();
            String estado = (proceso.isStatus()) ? "Espera" : "Listo";
            jlbR.setText(estado);

            jProceso.setLocation(this.jPanelMemoria.getLocation().x + desplazamientoX, this.jPanelMemoria.getLocation().y - 40);
            jProceso.setSize(width, 100);
            jProceso.setBackground((proceso.isStatus()) ? Color.orange : Color.gray);
            jProceso.setBorder(new TitledBorder(proceso.getNombre()));
            jProceso.add(jlbR);

            desplazamientoX = desplazamientoX + width;

            this.jPanelMemoria.add(jProceso);
            this.jPanelMemoria.revalidate();
            this.jPanelMemoria.repaint();
        }
    }

    public int getTParticiones(LinkedList<Proceso> procesos, int tPanel) {

        return (int) tPanel / procesos.size();
    }


    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized

    }//GEN-LAST:event_formComponentResized

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //PROBANDO LA PROGRESS BAR

        JOptionPane.showMessageDialog(rootPane, "Comienza la simulacion");

        Hilos hilo = new Hilos();
        hilo.setBarradeProceso(jProgressBar1);
        hilo.setProcesos(this.procesos.getProcesos());
        hilo.setjPanelMemoria(jPanelMemoria);
        hilo.setTotalQuantum(this.periodoQuantum);
        hilo.setnProceso(this.jLabel6);

        Thread procesar = new Thread(hilo);
        procesar.start();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked

    }//GEN-LAST:event_jTextField1MouseClicked

    @Override
    public boolean action(Event evt, Object what) {
        return super.action(evt, what); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBoxProgramas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanelMemoria;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

}
