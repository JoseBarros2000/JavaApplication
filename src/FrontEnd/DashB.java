package FrontEnd;

import BackEnd.Doente;
import Serializacao.Serializacao;
import javax.swing.JOptionPane;
import BackEnd.Sistema;
import javax.swing.table.DefaultTableModel;

public class DashB extends javax.swing.JFrame {

    private Sistema sistema;
    private int numDoentes;
    private int numEquip;
    private int maiorPercCamasOcup;
    private int numEquipLivres;
    private int numTotalEquip;
    private String codEnfProblematica;
    
    DefaultTableModel modeloNumDoente;
    DefaultTableModel modeloPercDoente;
    DefaultTableModel modeloNumEquip;
    DefaultTableModel modeloPercEquip;
    
    private String estado;
    private String tipoEquip;
    private int numEstLeve;
    private int numEstMedio;
    private int numEstGrave;
    private int numEstMuitoGrave;
    private int numTipoI;
    private int numTipoII;
    private int numTipoIII;
    private int numTipoIV;
    private double percEstLeve;
    private double percEstMedio;
    private double percEstGrave;
    private double percEstMuitoGrave;
    private double percTipoI;
    private double percTipoII;
    private double percTipoIII;      
    private double percTipoIV;   
    
    public DashB(Sistema sistema, Serializacao serializacao, String nomeSelec) {
        initComponents();
        
        this.sistema = sistema;
        
        
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        
        nomeHospital.setText(nomeSelec);
        
        //Table e numero de doentes
        modeloNumDoente = (DefaultTableModel) tableNumDoente.getModel();
        tableNumDoente.setModel(modeloNumDoente);
        modeloNumDoente.setNumRows(0);
        if(sistema.getListaHospital().getNomeHospital(nomeSelec).getListaDoentes().sizeDoentes() != 0){
        for( int i=0; i<sistema.getListaHospital().getNomeHospital(nomeSelec).getListaDoentes().sizeDoentes(); i++){
            numDoentes = sistema.getListaHospital().getNomeHospital(nomeSelec).getListaDoentes().sizeDoentes() ;
            estado = sistema.getListaHospital().getNomeHospital(nomeSelec).getListaDoentes().getDoentesByIndex(i).getEstado();
            if(estado.equals("Leve")){
                numEstLeve++;
            }
            if(estado.equals("Médio")){
                numEstMedio++;
                }
            if(estado.equals("Grave")){
                numEstGrave++;
            }
            if(estado.equals("Muito Grave")){
                numEstMuitoGrave++;
            }
        }
            modeloNumDoente.addRow(new Object[]{numEstLeve, numEstMedio, numEstGrave, numEstMuitoGrave } );
        
        
        txtNumDoente.setText(String.valueOf(numDoentes));
        
        
        //Percentagem de doentes
        modeloPercDoente = (DefaultTableModel) tablePercDoente.getModel();
        tablePercDoente.setModel(modeloPercDoente);
        modeloPercDoente.setNumRows(0);
        try{
            double estLeve = numEstLeve * 100;
            percEstLeve = estLeve/numDoentes;
        }catch(ArithmeticException e){
            JOptionPane.showMessageDialog(null, "Não existem doentes", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        try{
            double estMedio = numEstMedio * 100;
            percEstMedio = estMedio/numDoentes;
        }catch(ArithmeticException e){
            JOptionPane.showMessageDialog(null, "Não existem doentes", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        try{
            double estGrave = numEstGrave * 100;
            percEstGrave = estGrave/numDoentes;
        }catch(ArithmeticException e){
            JOptionPane.showMessageDialog(null, "Não existem doentes", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        try{
            double estMuitoGrave = numEstMuitoGrave * 100;
            percEstMuitoGrave = estMuitoGrave/numDoentes;
        }catch(ArithmeticException e){
            JOptionPane.showMessageDialog(null, "Não existem doentes", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        modeloPercDoente.addRow(new Object[]{percEstLeve, percEstMedio, percEstGrave, percEstMuitoGrave});
        
        }
        
        //Table e numero de equipamentos
        modeloNumEquip = (DefaultTableModel) tableNumEquip.getModel();
        tableNumEquip.setModel(modeloNumEquip);
        modeloNumEquip.setNumRows(0);
        if(sistema.getListaHospital().getNomeHospital(nomeSelec).getListaEquipamento().sizeEquipamento() != 0){
        for(int i=0; i<sistema.getListaHospital().getNomeHospital(nomeSelec).getListaEquipamento().sizeEquipamento(); i++){
            numEquip = sistema.getListaHospital().getNomeHospital(nomeSelec).getListaEquipamento().sizeEquipamento();
            tipoEquip = sistema.getListaHospital().getNomeHospital(nomeSelec).getListaEquipamento().getEquipamentosByIndex(i).getTipoEqui();
            if(tipoEquip.equals("Classe I – baixo risco")){
                numTipoI++;
            }
            if(tipoEquip.equals("Classe II – médio risco")){
                numTipoII++;
            }
            if(tipoEquip.equals("Classe III – alto risco")){
                numTipoIII++;
            }
            if(tipoEquip.equals("Classe IV – máximo risco")){
                numTipoIV++;
            }
        }
        modeloNumEquip.addRow(new Object[]{numTipoI, numTipoII, numTipoIII, numTipoIV });
        txtNumEquip.setText(String.valueOf(numEquip));
        
            
        
        
        //Percentagem de equipamentos
        modeloPercEquip = (DefaultTableModel) tablePercEquip.getModel();
        tablePercEquip.setModel(modeloPercEquip);
        modeloPercEquip.setNumRows(0);
        try{
            double tipoI = numTipoI * 100;
            percTipoI = tipoI/numEquip;
        }catch(ArithmeticException e){
          JOptionPane.showMessageDialog(null, "Não existem doentes", "ERRO", JOptionPane.ERROR_MESSAGE);  
        }
        try{
            double tipoII = numTipoII * 100;
            percTipoII = tipoII/numEquip;
        }catch(ArithmeticException e){
           JOptionPane.showMessageDialog(null, "Não existem doentes", "ERRO", JOptionPane.ERROR_MESSAGE); 
        }
        try{
            double tipoIII = numTipoIII * 100;
            percTipoIII = tipoIII/numEquip;
        }catch(ArithmeticException e){
            JOptionPane.showMessageDialog(null, "Não existem doentes", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        try{
            double tipoIV = numTipoIV * 100;
            percTipoIV = tipoIV/numEquip;
        }catch(ArithmeticException e){
            JOptionPane.showMessageDialog(null, "Não existem doentes", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        modeloPercEquip.addRow(new Object[] {percTipoI, percTipoII, percTipoIII, percTipoIV});
        
    
    }
        maiorPercCamasOcup = -1;
        if(sistema.getListaHospital().getNomeHospital(nomeSelec).getListaEnfermaria().sizeEnfermaria() != 0 ){
            
        for(int i=0; i<sistema.getListaHospital().getNomeHospital(nomeSelec).getListaEnfermaria().sizeEnfermaria(); i++){
            if(!sistema.getListaHospital().getNomeHospital(nomeSelec).getListaEnfermaria().getEnfermariaByIndex(i).getListaCamas().isEmpty() && !sistema.getListaHospital().getNomeHospital(nomeSelec).getListaEnfermaria().getEnfermariaByIndex(i).getListaCamasOcupadas().isEmpty()){
                int camasOcupadas = sistema.getListaHospital().getNomeHospital(nomeSelec).getListaEnfermaria().getEnfermariaByIndex(i).getListaCamasOcupadas().size();
                int totalCamas =sistema.getListaHospital().getNomeHospital(nomeSelec).getListaEnfermaria().getEnfermariaByIndex(i).getListaCamas().size();
                if (camasOcupadas/totalCamas > maiorPercCamasOcup){
                
                    maiorPercCamasOcup = camasOcupadas/totalCamas;
                    codEnfProblematica = sistema.getListaHospital().getNomeHospital(nomeSelec).getListaEnfermaria().getEnfermariaByIndex(i).getCodigoEnf();
                    txtEnfProblematica.setText(codEnfProblematica);
                    txtNumCamasOcup.setText(camasOcupadas+"/"+totalCamas);
               
            }
        }
        }
        }
        
        numEquipLivres=0;
        if(sistema.getListaHospital().getNomeHospital(nomeSelec).getListaEnfermaria().sizeEnfermaria() != 0){
        for(int i=0; i<sistema.getListaHospital().getNomeHospital(nomeSelec).getListaEnfermaria().sizeEnfermaria(); i++){
            
            String codEnf = sistema.getListaHospital().getNomeHospital(nomeSelec).getListaEquipamento(). getEquipamentosByIndex(i).getEnfColocado().getCodigoEnf();
            String estadoEquip = sistema.getListaHospital().getNomeHospital(nomeSelec).getListaEquipamento(). getEquipamentosByIndex(i).getLivre();
            if(codEnfProblematica.equals(codEnf)){
               numTotalEquip++;
                if(estadoEquip.equals("Livre") && codEnfProblematica.equals(codEnf)){
                numEquipLivres++;
                
            
            }
            }
        } 
        txtNumEquipLivres.setText(numEquipLivres+"/"+numTotalEquip);
                
        }       
                
                
            
        
    }    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nomeHospital = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableNumDoente = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtNumDoente = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablePercDoente = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableNumEquip = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txtNumEquip = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tablePercEquip = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtEnfProblematica = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtNumCamasOcup = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtNumEquipLivres = new javax.swing.JTextField();
        butVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("DashBoard");

        jLabel2.setText("Hospital:");

        nomeHospital.setEnabled(false);

        jLabel3.setText("Número de Doentes:");

        tableNumDoente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Leve", "Médio", "Grave", "Muito Grave"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableNumDoente.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tableNumDoente);
        if (tableNumDoente.getColumnModel().getColumnCount() > 0) {
            tableNumDoente.getColumnModel().getColumn(0).setResizable(false);
            tableNumDoente.getColumnModel().getColumn(1).setResizable(false);
            tableNumDoente.getColumnModel().getColumn(2).setResizable(false);
            tableNumDoente.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel6.setText("Número de Doentes em Estado:");

        txtNumDoente.setEnabled(false);

        jLabel7.setText("Percentagem de Doentes em Estado:");

        tablePercDoente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Leve", "Medio", "Grave", "Muito Grave"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablePercDoente.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tablePercDoente);
        if (tablePercDoente.getColumnModel().getColumnCount() > 0) {
            tablePercDoente.getColumnModel().getColumn(0).setResizable(false);
            tablePercDoente.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(txtNumDoente, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 139, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNumDoente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        jLabel8.setText("Número de Equipamentos:");

        tableNumEquip.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Classe I", "Classe II", "Classe III", "Classe IV"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableNumEquip.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(tableNumEquip);
        if (tableNumEquip.getColumnModel().getColumnCount() > 0) {
            tableNumEquip.getColumnModel().getColumn(0).setResizable(false);
            tableNumEquip.getColumnModel().getColumn(1).setResizable(false);
            tableNumEquip.getColumnModel().getColumn(2).setResizable(false);
            tableNumEquip.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel9.setText("Número de Equipamentos Ocupados do Tipo:");

        txtNumEquip.setEnabled(false);

        jLabel10.setText("Percentagem de Equipamentos Ocupados do Tipo:");

        tablePercEquip.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Classe I", "Classe II", "Classe III", "Classe IV"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablePercEquip.getTableHeader().setReorderingAllowed(false);
        jScrollPane7.setViewportView(tablePercEquip);
        if (tablePercEquip.getColumnModel().getColumnCount() > 0) {
            tablePercEquip.getColumnModel().getColumn(0).setResizable(false);
            tablePercEquip.getColumnModel().getColumn(1).setResizable(false);
            tablePercEquip.getColumnModel().getColumn(2).setResizable(false);
            tablePercEquip.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(txtNumEquip, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(86, Short.MAX_VALUE))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtNumEquip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        jLabel11.setText("Enfermaria mais problemática:");

        txtEnfProblematica.setEnabled(false);

        jLabel12.setText("Número de camas ocupadas:");

        txtNumCamasOcup.setEnabled(false);

        jLabel13.setText("Número de equipamentos livres:");

        txtNumEquipLivres.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtEnfProblematica))
                .addGap(47, 47, 47)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(txtNumCamasOcup, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNumEquipLivres))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEnfProblematica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumCamasOcup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumEquipLivres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        butVoltar.setText("Voltar");
        butVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butVoltarMouseClicked(evt);
            }
        });
        butVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 670, Short.MAX_VALUE)
                                .addComponent(butVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nomeHospital, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(butVoltar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nomeHospital, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butVoltarMouseClicked
        dispose();
    }//GEN-LAST:event_butVoltarMouseClicked

    private void butVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butVoltarActionPerformed
       
    }//GEN-LAST:event_butVoltarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextField nomeHospital;
    private javax.swing.JTable tableNumDoente;
    private javax.swing.JTable tableNumEquip;
    private javax.swing.JTable tablePercDoente;
    private javax.swing.JTable tablePercEquip;
    private javax.swing.JTextField txtEnfProblematica;
    private javax.swing.JTextField txtNumCamasOcup;
    private javax.swing.JTextField txtNumDoente;
    private javax.swing.JTextField txtNumEquip;
    private javax.swing.JTextField txtNumEquipLivres;
    // End of variables declaration//GEN-END:variables
}
