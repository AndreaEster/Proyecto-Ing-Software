/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Views;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
/**
 *
 * @author Marco Tulio Work
 */
public class DynamicSeg extends javax.swing.JInternalFrame implements InternalFrameListener{

    /**
     * Creates new form DynamicSeg
     */
    private Core.DynamicPartitionEngine dpeOS;
    private int processSize;
    private float mainMemoryPanelWidth = 750;
    private float mainMemoryPanelHeight = 50;
    private float localStoragePanelWidth = 750;
    private float localStoragePanelHeight = 50;
    
    
    public DynamicSeg() {
        initComponents();
        this.dpeOS = new Core.DynamicPartitionEngine();
        this.addInternalFrameListener(this);
    }
     
    public void drawMemory(){
        //Declaracion de instancias
        List<JPanel> panelListMainMemory = new ArrayList<>();
        List<JLabel> labelListMainMemory = new ArrayList<>();
        List<JPanel> panelListLocalStorage = new ArrayList<>();
        List<JLabel> labelListLocalStorage = new ArrayList<>();
        FlowLayout experimentLayout = new FlowLayout();
        
        //Metodos que aseguran la actualizacion del panel de la Memoria Principal
        this.mainMemoryPanel.removeAll();
        this.mainMemoryPanel.revalidate();
        this.mainMemoryPanel.repaint();
        this.mainMemoryPanel.setLayout(experimentLayout);
        
        //Metodos que aseguran la actualizacion del panel de la Memoria de Almacenamiento
        this.localStoragePanel.removeAll();
        this.localStoragePanel.revalidate();
        this.localStoragePanel.repaint();
        this.localStoragePanel.setLayout(experimentLayout);
        
        //Llamado de la funcion interior para dibujar las particiones en el panel de Memoria Principal
        drawPartition(this.dpeOS.getMainMemory().getFirst(),0, panelListMainMemory, labelListMainMemory, "MainMemory");
        
        //Llamado de la funcion interior para dibujar las particiones en el panel de Memoria Principal
        drawPartition(this.dpeOS.getLocalStorage().getFirst(),0, panelListLocalStorage, labelListLocalStorage, "LocalStorage");
    }
    
    public void drawPartition(Core.Node partition, int location, List<JPanel> panelList, List<JLabel> labelList, String memory){
        
        float memorySize;
        float memoryPanelWidth;
        float memoryPanelHeight;
        JPanel memoryPanel;
        
        if(memory.equals("MainMemory")){
            memorySize = this.dpeOS.getMainMemory().getMemorySize();
            memoryPanelWidth = this.mainMemoryPanelWidth;
            memoryPanelHeight = this.mainMemoryPanelHeight;
            memoryPanel = this.mainMemoryPanel;
        }else{
            memorySize = this.dpeOS.getLocalStorage().getMemorySize();
            memoryPanelWidth = this.localStoragePanelWidth;
            memoryPanelHeight = this.localStoragePanelHeight;
            memoryPanel = this.localStoragePanel;
        }

        //Estas variables son utilizadas para calcular el tamano que debe tener la particion en la interfaz
        float memoryAverage = (partition.getNodeSize()/memorySize)*100;
        float sizeInMemory = (memoryPanelWidth*memoryAverage)/100;
        
        //Se agrega el respectivo panel y etiqueta de la particion que se esta dibujando.
        panelList.add(new JPanel());
        labelList.add(new JLabel());
        
        //Instrucciones que agregan apariencia al panel y etiqueta de la particion
        panelList.get(location).setLayout(new BorderLayout());
        
        panelList.get(location).setPreferredSize(new Dimension(
                (int)sizeInMemory, 
                (int)memoryPanelHeight
        ));
        if(partition.getItem() == null){
            panelList.get(location).setBackground(Color.LIGHT_GRAY);
        }else{
            panelList.get(location).setBackground(Color.YELLOW);
        }   
        labelList.get(location).setText(Integer.toString((int)partition.getNodeSize()));   
        
        //Aqui se mete la etiqueta dentro del panel de la particion
        panelList.get(location).add(labelList.get(location));
        //El panel de la particion se mete dentro del panel de la Memoria principal
        memoryPanel.add(panelList.get(location),location);
        
        //
        if( partition.getNext() != null ){
            drawPartition(partition.getNext(), location + 1, panelList, labelList, memory);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainMemoryPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        localStoragePanel = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        processSizeInput = new javax.swing.JTextField();
        addBtn = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        algorithmComboBox = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        processNumberInput = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        memoryComboBox = new javax.swing.JComboBox<>();
        changeBtn = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        memoryComboBox2 = new javax.swing.JComboBox<>();
        compactBtn = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Segmentacion Dinamica");

        mainMemoryPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        mainMemoryPanel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                mainMemoryPanelComponentShown(evt);
            }
        });

        javax.swing.GroupLayout mainMemoryPanelLayout = new javax.swing.GroupLayout(mainMemoryPanel);
        mainMemoryPanel.setLayout(mainMemoryPanelLayout);
        mainMemoryPanelLayout.setHorizontalGroup(
            mainMemoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        mainMemoryPanelLayout.setVerticalGroup(
            mainMemoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Almacenamiento Local:");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Memoria Principal:");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Instrucciones:");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("2- La Memoria Principal inicia sin procesos por defecto.");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("1- El tamano inicial de la Memoria Principal es de 1024(MB) por defecto.");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("4- La Colocacion, Compactacion y el Intercambio de procesos los realizara de forma automatica el OS.");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("3- Se debe indicar el tamano del proceso que se desea agregar.");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel8.setText("AREA DE CONTROL");

        jLabel9.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel9.setText("AREA DE EMULACION");

        localStoragePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout localStoragePanelLayout = new javax.swing.GroupLayout(localStoragePanel);
        localStoragePanel.setLayout(localStoragePanelLayout);
        localStoragePanelLayout.setHorizontalGroup(
            localStoragePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 748, Short.MAX_VALUE)
        );
        localStoragePanelLayout.setVerticalGroup(
            localStoragePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 58, Short.MAX_VALUE)
        );

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setText("Indicar el tamano del proceso (en MB):");

        addBtn.setBackground(new java.awt.Color(0, 153, 102));
        addBtn.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        addBtn.setForeground(new java.awt.Color(255, 255, 255));
        addBtn.setText("Agregar");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setText("Indicar el algoritmo de colocacion:");

        algorithmComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "first", "next", "best", " " }));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel12.setText("COLOCACION");

        jLabel13.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel13.setText("REUBICACION");

        jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel14.setText("Indicar el numero de proceso:");

        jLabel15.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel15.setText("Indicar el tipo de memoria:");

        memoryComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Principal", "Almacenamiento local", " " }));

        changeBtn.setBackground(new java.awt.Color(255, 153, 51));
        changeBtn.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        changeBtn.setForeground(new java.awt.Color(255, 255, 255));
        changeBtn.setText("Cambiar");
        changeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeBtnActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel16.setText("COMPACTACION");

        jLabel17.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel17.setText("Indicar que memoria desea compactar:");

        memoryComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Principal", "Almacenamiento", " " }));
        memoryComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memoryComboBox2ActionPerformed(evt);
            }
        });

        compactBtn.setBackground(new java.awt.Color(0, 102, 204));
        compactBtn.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        compactBtn.setForeground(new java.awt.Color(255, 255, 255));
        compactBtn.setText("Compactar");
        compactBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compactBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(localStoragePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mainMemoryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(250, 250, 250))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel10)
                                        .addComponent(processSizeInput, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(algorithmComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel14)
                                        .addComponent(processNumberInput, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(memoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addComponent(changeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(memoryComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addComponent(compactBtn)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(491, 491, 491)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(508, 508, 508)
                        .addComponent(jLabel8)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainMemoryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(localStoragePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(1, 1, 1)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(processSizeInput, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(algorithmComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(1, 1, 1)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(processNumberInput, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(memoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(changeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)))
                        .addGap(1, 1, 1)))
                .addGap(18, 18, 18)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(memoryComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(compactBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        String validation;
        
        if(this.processSizeInput.getText().strip()!= ""){
            this.processSize = Integer.parseInt(this.processSizeInput.getText().strip());
            //Metodo estatico de la clase Validator que permite verificar que el valor insertado en el input de agregar proceso sea valido
            validation = Core.Validator.validateDinamycProcessSize(this.processSize, (int)this.dpeOS.getMainMemory().getMemorySize());
            if(validation.equals("valid")){
                if(this.algorithmComboBox.getSelectedIndex() == 0){
                    //Aqui se manda a llamar al metodo que se encarga de implementar el algoritmo de colocacion First-fit
                    boolean addState = this.dpeOS.addProcess(this.processSize, "First-fit");
                    if(addState == false){
                        JOptionPane.showMessageDialog(this,
                            "No se encontro una particion con espacio suficiente en la memoria, libere espacio.",
                            "ATENCION!",
                            JOptionPane.WARNING_MESSAGE
                        );
                    }
                }else{
                    if(this.algorithmComboBox.getSelectedIndex() == 2){
                        //Aqui se manda a llamar al metodo que se encarga de implementar el algoritmo de colocacion First-fit
                        boolean addState = this.dpeOS.addProcess(this.processSize, "Best-fit");
                        if(addState == false){
                            JOptionPane.showMessageDialog(this,
                                "No se encontro una particion con espacio suficiente en la memoria, libere espacio.",
                                "ATENCION!",
                                JOptionPane.WARNING_MESSAGE
                            );
                        }
                    }else{
                        if(this.dpeOS.getMainMemory().getLastPlacement()!= null){
                            boolean addState = this.dpeOS.addProcess(this.processSize, "Next-fit");
                            if(addState == false){
                                JOptionPane.showMessageDialog(this,
                                    "No se encontro una particion con espacio suficiente en la memoria, libere espacio.",
                                    "ATENCION!",
                                    JOptionPane.WARNING_MESSAGE
                                );
                            }
                        }else{
                            JOptionPane.showMessageDialog(this,
                                "No se ah registrado una colocacion de proceso aun, por lo que no se puede utilizar el algoritmo Next-fit.",
                                "ATENCION!",
                                JOptionPane.WARNING_MESSAGE
                            );
                        }
                    }
                }
            }else{
                JOptionPane.showMessageDialog(this,
                    validation,
                    "ATENCION!",
                    JOptionPane.WARNING_MESSAGE
                );
                this.processSizeInput.setText("");
            }
            drawMemory();
        }else{
            JOptionPane.showMessageDialog(this,
                    "Debe especificar un tamano de proceso.",
                    "ATENCION!",
                    JOptionPane.WARNING_MESSAGE
            );
        }
        this.processSizeInput.setText("");
    }//GEN-LAST:event_addBtnActionPerformed

    private void mainMemoryPanelComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_mainMemoryPanelComponentShown

    }//GEN-LAST:event_mainMemoryPanelComponentShown

    private void changeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeBtnActionPerformed
        String validation;
        int partitionNumber;
        
        if(this.processNumberInput.getText().strip()!= ""){
            partitionNumber = Integer.parseInt(this.processNumberInput.getText().strip());
            //Metodo estatico de la clase Validator que permite verificar que el valor insertado en el input de cambiar proceso sea valido
            validation = Core.Validator.validateDinamycProcessLocation(partitionNumber, this.dpeOS.getMainMemory().getNumElements());
            if(validation.equals("valid")){
                if(this.memoryComboBox.getSelectedIndex() == 0){
                    //Aqui se manda a llamar al metodo que se encarga de reubicar el proceso
                    boolean changeState = this.dpeOS.changeProcessMemory(partitionNumber, "toLocalStorage");
                    if(changeState == false){
                        JOptionPane.showMessageDialog(this,
                            "No se encontro un proceso en la particion indicada.",
                            "ATENCION!",
                            JOptionPane.WARNING_MESSAGE
                        );
                    }
                }else{
                     //Aqui se manda a llamar al metodo que se encarga de reubicar el proceso
                    boolean changeState = this.dpeOS.changeProcessMemory(partitionNumber, "toMainMemory");
                    if(changeState == false){
                        JOptionPane.showMessageDialog(this,
                            "No se encontro un proceso en la particion indicada.",
                            "ATENCION!",
                            JOptionPane.WARNING_MESSAGE
                        );
                    }
                }
            }else{
                JOptionPane.showMessageDialog(this,
                    validation,
                    "ATENCION!",
                    JOptionPane.WARNING_MESSAGE
                );
                this.processSizeInput.setText("");
            }
            drawMemory();
        }else{
            JOptionPane.showMessageDialog(this,
                    "Debe especificar un numero de particion.",
                    "ATENCION!",
                    JOptionPane.WARNING_MESSAGE
            );
        }
        this.processNumberInput.setText("");
    }//GEN-LAST:event_changeBtnActionPerformed

    private void compactBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compactBtnActionPerformed
        if(this.memoryComboBox.getSelectedIndex() == 0){
            //Aqui se manda a llamar al metodo que se encarga de reubicar el proceso
            boolean compactState = this.dpeOS.compactMemory("MainMemory");
            if(compactState == false){
                JOptionPane.showMessageDialog(this,
                    "No se pudo compactar la memoria indicada.",
                    "ATENCION!",
                    JOptionPane.WARNING_MESSAGE
                );
            }
        }else{
            //Aqui se manda a llamar al metodo que se encarga de reubicar el proceso
            boolean compactState = this.dpeOS.compactMemory("LocalStorage");
            if(compactState == false){
                JOptionPane.showMessageDialog(this,
                    "No se pudo compactar la memoria indicada.",
                    "ATENCION!",
                    JOptionPane.WARNING_MESSAGE
                );
            }
        }
        drawMemory();
    }//GEN-LAST:event_compactBtnActionPerformed

    private void memoryComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memoryComboBox2ActionPerformed
  
    }//GEN-LAST:event_memoryComboBox2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JComboBox<String> algorithmComboBox;
    private javax.swing.JButton changeBtn;
    private javax.swing.JButton compactBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel localStoragePanel;
    private javax.swing.JPanel mainMemoryPanel;
    private javax.swing.JComboBox<String> memoryComboBox;
    private javax.swing.JComboBox<String> memoryComboBox2;
    private javax.swing.JTextField processNumberInput;
    private javax.swing.JTextField processSizeInput;
    // End of variables declaration//GEN-END:variables

    @Override
    public void internalFrameOpened(InternalFrameEvent e) {
        drawMemory();
    }

    @Override
    public void internalFrameClosing(InternalFrameEvent e) {
        
    }

    @Override
    public void internalFrameClosed(InternalFrameEvent e) {
        
    }

    @Override
    public void internalFrameIconified(InternalFrameEvent e) {
        
    }

    @Override
    public void internalFrameDeiconified(InternalFrameEvent e) {
        
    }

    @Override
    public void internalFrameActivated(InternalFrameEvent e) {
        
    }

    @Override
    public void internalFrameDeactivated(InternalFrameEvent e) {
        
    }

}
