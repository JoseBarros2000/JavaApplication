package FrontEnd;

import BackEnd.Enfermaria;
import BackEnd.Doente;
import BackEnd.Hospital;
import BackEnd.ListaEnfermarias;
import BackEnd.ListaHospital;
import BackEnd.Sistema;
import Serializacao.Serializacao;
import java.awt.FlowLayout;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Enfermarias extends javax.swing.JFrame {
    private Sistema sistema;
    private Serializacao serializacao;
    private DefaultTableModel modelo;
    private DefaultTableModel modeloCamasDoentes;
    private String codigoHospital;
    public static Integer linha;
    
    public Enfermarias(Sistema sistema, Serializacao serializacao, String nomeHospital, String codigoHospital) {
        initComponents();
        this.sistema = sistema;
        this.serializacao = serializacao;
        this.codigoHospital = codigoHospital;
        
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        
        panelCriarEnfermaria.setVisible(false);
        
        setSize(490,440);
        setLocationRelativeTo(null);
        setResizable(false);
        
       //criação de modelos de tabelas e combobox´s
        modelo = (DefaultTableModel) tabelaEnfermarias.getModel();
        modeloCamasDoentes = (DefaultTableModel) tabelaCamasDeEnfermaria.getModel();
        
        tabelaEnfermarias.setModel(modelo);
        tabelaCamasDeEnfermaria.setModel(modeloCamasDoentes);
        
        modeloCamasDoentes.setNumRows(0);
        modelo.setNumRows(0);
        
        //definir valores da tabela
        for (int i=0; i<sistema.getListaHospital().getCodHospital(codigoHospital).getListaEnfermaria().sizeEnfermaria(); i++) {
            Enfermaria enfermaria = sistema.getListaHospital().getCodHospital(codigoHospital).getListaEnfermaria().getEnfermariaByIndex(i);
            modelo.addRow(new Object[]{enfermaria.getCodigoEnf(), enfermaria.getTipoEnf(), enfermaria.getCamas()});
        }
        
        painelNomeHospital.setText(codigoHospital);
        
        
        tabelaEnfermarias.setAutoCreateRowSorter(true);
        
        //ordenação das enfermarias
        sistema.getListaHospital().getCodHospital(codigoHospital).getListaEnfermaria().ordenacaoEnfermarias();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCriarEnfermaria = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCodEnfermaria = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTipoEnfermaria = new javax.swing.JTextField();
        txtCamas = new javax.swing.JTextField();
        butCancelar = new javax.swing.JButton();
        butGravarDados = new javax.swing.JButton();
        butCriar = new javax.swing.JButton();
        painelNomeHospital = new javax.swing.JLabel();
        butRemoverEnf = new javax.swing.JButton();
        butAdicionarEnf = new javax.swing.JButton();
        butVoltar = new javax.swing.JButton();
        butEditar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaEnfermarias = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaCamasDeEnfermaria = new javax.swing.JTable();
        butVerCamas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Código de Enfermaria :");

        jLabel2.setText("    Tipo de Enfermaria :");

        jLabel3.setText("   Número de camas:");

        txtTipoEnfermaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoEnfermariaActionPerformed(evt);
            }
        });

        txtCamas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCamasActionPerformed(evt);
            }
        });
        txtCamas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCamasKeyTyped(evt);
            }
        });

        butCancelar.setText("Cancelar");
        butCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butCancelarActionPerformed(evt);
            }
        });

        butGravarDados.setText("Gravar Dados");
        butGravarDados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butGravarDadosMouseClicked(evt);
            }
        });

        butCriar.setText("Criar");
        butCriar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butCriarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelCriarEnfermariaLayout = new javax.swing.GroupLayout(panelCriarEnfermaria);
        panelCriarEnfermaria.setLayout(panelCriarEnfermariaLayout);
        panelCriarEnfermariaLayout.setHorizontalGroup(
            panelCriarEnfermariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCriarEnfermariaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCriarEnfermariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelCriarEnfermariaLayout.createSequentialGroup()
                        .addGroup(panelCriarEnfermariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCriarEnfermariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCriarEnfermariaLayout.createSequentialGroup()
                                .addComponent(txtCamas, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(butCriar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelCriarEnfermariaLayout.createSequentialGroup()
                                .addComponent(txtTipoEnfermaria, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(butCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelCriarEnfermariaLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodEnfermaria, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(butGravarDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelCriarEnfermariaLayout.setVerticalGroup(
            panelCriarEnfermariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCriarEnfermariaLayout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addGroup(panelCriarEnfermariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodEnfermaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(butGravarDados))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCriarEnfermariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTipoEnfermaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(butCancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCriarEnfermariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCamas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(butCriar)))
        );

        butRemoverEnf.setText("Remover Enfermaria");
        butRemoverEnf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butRemoverEnfMouseClicked(evt);
            }
        });

        butAdicionarEnf.setText("Adicionar Enfermaria");
        butAdicionarEnf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butAdicionarEnfMouseClicked(evt);
            }
        });
        butAdicionarEnf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butAdicionarEnfActionPerformed(evt);
            }
        });

        butVoltar.setText("Voltar");
        butVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butVoltarMouseClicked(evt);
            }
        });

        butEditar.setText("Editar Dados");
        butEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butEditarMouseClicked(evt);
            }
        });

        tabelaEnfermarias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Codigo de Enfermaria", "Tipo de Enfermaria", "Camas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaEnfermarias.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabelaEnfermarias.getTableHeader().setReorderingAllowed(false);
        tabelaEnfermarias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaEnfermariasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaEnfermarias);
        if (tabelaEnfermarias.getColumnModel().getColumnCount() > 0) {
            tabelaEnfermarias.getColumnModel().getColumn(0).setResizable(false);
            tabelaEnfermarias.getColumnModel().getColumn(1).setResizable(false);
            tabelaEnfermarias.getColumnModel().getColumn(2).setResizable(false);
        }

        tabelaCamasDeEnfermaria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nº da cama", "Doente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaCamasDeEnfermaria.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabelaCamasDeEnfermaria.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tabelaCamasDeEnfermaria);
        if (tabelaCamasDeEnfermaria.getColumnModel().getColumnCount() > 0) {
            tabelaCamasDeEnfermaria.getColumnModel().getColumn(0).setResizable(false);
            tabelaCamasDeEnfermaria.getColumnModel().getColumn(1).setResizable(false);
        }

        butVerCamas.setText("Ver camas ocupadas da enfermaria");
        butVerCamas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butVerCamasMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelCriarEnfermaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(painelNomeHospital, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(butVerCamas, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(butVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(butEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(butAdicionarEnf, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(butRemoverEnf))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(butVoltar)
                                .addComponent(butVerCamas))
                            .addComponent(painelNomeHospital, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(butEditar)
                            .addComponent(butAdicionarEnf)
                            .addComponent(butRemoverEnf))
                        .addGap(28, 28, 28)
                        .addComponent(panelCriarEnfermaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        setBounds(0, 0, 1046, 477);
    }// </editor-fold>//GEN-END:initComponents

    private void butAdicionarEnfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butAdicionarEnfMouseClicked
       //paineis visiveis
        panelCriarEnfermaria.setVisible(true);
        panelCriarEnfermaria.revalidate();
        butAdicionarEnf.setVisible(false);
        butRemoverEnf.setVisible(false);
        butEditar.setVisible(false);
        butGravarDados.setVisible(false);
        butCriar.setVisible(true);
    }//GEN-LAST:event_butAdicionarEnfMouseClicked

    private void butVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butVoltarMouseClicked
        //butao voltar a pagina anterior
        dispose();
    }//GEN-LAST:event_butVoltarMouseClicked

    private void butRemoverEnfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butRemoverEnfMouseClicked
        //remover linha da tabela
        String codigoEnfermaria = (String) tabelaEnfermarias.getValueAt(tabelaEnfermarias.getSelectedRow(), 0);
        for(int i=0;i<sistema.getListaHospital().getCodHospital(codigoHospital).getListaEnfermaria().sizeEnfermaria();i++){
            if(codigoEnfermaria.equals(sistema.getListaHospital().getCodHospital(codigoHospital).getListaEnfermaria().getEnfermariaByIndex(i).getCodigoEnf())){
                modelo.removeRow(tabelaEnfermarias.getSelectedRow());
                sistema.getListaHospital().getCodHospital(codigoHospital).getListaEnfermaria().removerEnfermaria(sistema.getListaHospital().getCodHospital(codigoHospital).getListaEnfermaria().getEnfermariaByIndex(i));
            }
        }
        serializacao.guardar(sistema);
    }//GEN-LAST:event_butRemoverEnfMouseClicked

    private void butCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butCancelarActionPerformed
        
        
        //paineis visiveis
        panelCriarEnfermaria.setVisible(false);
        butRemoverEnf.setVisible(true);
        butAdicionarEnf.setVisible(true);
    }//GEN-LAST:event_butCancelarActionPerformed

    private void butCriarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butCriarMouseClicked
        
        //criar enfermaria
        try{
            String codigoEnfermaria = txtCodEnfermaria.getText();
            String tipoEnfermaria = txtTipoEnfermaria.getText();
            int camasEnfermaria = Integer.parseInt(txtCamas.getText()); //Fazer exceções
            //Verificar se é um numero
        
            camasEnfermaria = Integer.parseInt(txtCamas.getText()); //Fazer exceções
        
        
            if(!sistema.getListaHospital().getCodHospital(codigoHospital).getListaEnfermaria().existe(codigoEnfermaria))
            {
                sistema.getListaHospital().getCodHospital(codigoHospital).getListaEnfermaria().setAdicionarEnfermaria(new Enfermaria(codigoEnfermaria, tipoEnfermaria, camasEnfermaria));
                sistema.getListaHospital().getCodHospital(codigoHospital).getListaEnfermaria().getEnfermaria(codigoEnfermaria).defenirCamas();
                Enfermaria enfermaria = sistema.getListaHospital().getCodHospital(codigoHospital).getListaEnfermaria().getEnfermaria(codigoEnfermaria);
                modelo.addRow(new Object[]{enfermaria.getCodigoEnf(), enfermaria.getTipoEnf(), enfermaria.getCamas()}); 
            }
            }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Não introduziu um número", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        serializacao.guardar(sistema);
    }//GEN-LAST:event_butCriarMouseClicked

    private void txtCamasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCamasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCamasActionPerformed

    private void txtTipoEnfermariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoEnfermariaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoEnfermariaActionPerformed

    private void butGravarDadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butGravarDadosMouseClicked
       
        //gravar dados editados
        try{
            String codigoEnfermaria = (String) tabelaEnfermarias.getValueAt(linha, 0);
            String tipoEnfermaria = (String) tabelaEnfermarias.getValueAt(linha, 1);
            int camas = (Integer) tabelaEnfermarias.getValueAt(linha, 2);
            
            String codigoEnfermariaDoText = txtCodEnfermaria.getText();
            
            if(sistema.getListaHospital().getCodHospital(codigoHospital).getListaEnfermaria().existe(codigoEnfermariaDoText) && !codigoEnfermaria.equals(codigoEnfermariaDoText)){
                JOptionPane.showMessageDialog(null, "Não introduziu um número", "ERRO", JOptionPane.ERROR_MESSAGE);
            }else{
                String tipoEnfermariaDoText = txtTipoEnfermaria.getText();
                int camasEnfermariaDoText = Integer.parseInt(txtCamas.getText());
            
                for(int i=0;i<sistema.getListaHospital().getCodHospital(codigoHospital).getListaEnfermaria().sizeEnfermaria();i++){
                    if(codigoEnfermaria.equals(sistema.getListaHospital().getCodHospital(codigoHospital).getListaEnfermaria().getEnfermariaByIndex(i).getCodigoEnf())){
                        Enfermaria enfermaria = (sistema.getListaHospital().getCodHospital(codigoHospital).getListaEnfermaria().getEnfermariaByIndex(i));
                        enfermaria.setCodigoEnf(codigoEnfermariaDoText);
                        enfermaria.setTipoEnf(tipoEnfermariaDoText);
                        enfermaria.setCamas(camasEnfermariaDoText);
                        enfermaria.defenirCamas();
                        modelo.removeRow(linha);
                        modelo.addRow(new Object[]{enfermaria.getCodigoEnf(), enfermaria.getTipoEnf(), enfermaria.getCamas()});
                    }
                }
            }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Não introduziu um número", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        serializacao.guardar(sistema);
    }//GEN-LAST:event_butGravarDadosMouseClicked

    private void butEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butEditarMouseClicked
        //obter valores da tabela e paineis visiveis
        
        String codigoEnfermaria = (String) tabelaEnfermarias.getValueAt(tabelaEnfermarias.getSelectedRow(), 0);
        String tipoEnfermaria = (String) tabelaEnfermarias.getValueAt(tabelaEnfermarias.getSelectedRow(), 1);
        int camas = (Integer) tabelaEnfermarias.getValueAt(tabelaEnfermarias.getSelectedRow(), 2);
        
        panelCriarEnfermaria.setVisible(true);
        butCriar.setVisible(false);
        txtCodEnfermaria.setText(codigoEnfermaria);
        txtTipoEnfermaria.setText(tipoEnfermaria);
        txtCamas.setText(String.valueOf(camas));
    }//GEN-LAST:event_butEditarMouseClicked

    private void txtCamasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCamasKeyTyped
        
    }//GEN-LAST:event_txtCamasKeyTyped

    private void tabelaEnfermariasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaEnfermariasMouseClicked
        
        //selecionar linha da tabela
        linha = tabelaEnfermarias.getSelectedRow();
        setSize(490,440);
        setLocationRelativeTo(null);
    }//GEN-LAST:event_tabelaEnfermariasMouseClicked

    private void butAdicionarEnfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butAdicionarEnfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_butAdicionarEnfActionPerformed

    private void butVerCamasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butVerCamasMouseClicked
        //ver camas utilizadas por doentes
        setSize(1043,440);
        setLocationRelativeTo(null);
        String codigoEnfermaria = (String) tabelaEnfermarias.getValueAt(linha, 0);
        
        int rowCount = modeloCamasDoentes.getRowCount();
        if (rowCount !=0){
            for(int i=0; i<rowCount; i++){
                modeloCamasDoentes.removeRow(i);
            }
        }
        
        for(int i=0;i<sistema.getListaHospital().getCodHospital(codigoHospital).getListaDoentes().sizeDoentes();i++){
            if(sistema.getListaHospital().getCodHospital(codigoHospital).getListaDoentes().getDoentesByIndex(i).getEnfermariaOndeEstaODoente().equals(codigoEnfermaria)){
                modeloCamasDoentes.addRow(new Object[]{sistema.getListaHospital().getCodHospital(codigoHospital).getListaDoentes().getDoentesByIndex(i).getCama(), sistema.getListaHospital().getCodHospital(codigoHospital).getListaDoentes().getDoentesByIndex(i).getNome()});
            }
        }
    }//GEN-LAST:event_butVerCamasMouseClicked

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butAdicionarEnf;
    private javax.swing.JButton butCancelar;
    private javax.swing.JButton butCriar;
    private javax.swing.JButton butEditar;
    private javax.swing.JButton butGravarDados;
    private javax.swing.JButton butRemoverEnf;
    private javax.swing.JButton butVerCamas;
    private javax.swing.JButton butVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel painelNomeHospital;
    private javax.swing.JPanel panelCriarEnfermaria;
    private javax.swing.JTable tabelaCamasDeEnfermaria;
    private javax.swing.JTable tabelaEnfermarias;
    private javax.swing.JTextField txtCamas;
    private javax.swing.JTextField txtCodEnfermaria;
    private javax.swing.JTextField txtTipoEnfermaria;
    // End of variables declaration//GEN-END:variables
}
