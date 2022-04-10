
package FrontEnd;

import BackEnd.Enfermaria;
import BackEnd.Equipamento;
import BackEnd.Doente;
import BackEnd.Sistema;
import static FrontEnd.CriarUtilizadores.linha;
import Serializacao.Serializacao;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.table.DefaultTableModel;


public class Equipamentos extends javax.swing.JFrame {
    private Sistema sistema;
    private Serializacao serializacao;
    private String codigoHospital;
    private String nomeHospital;
    private DefaultTableModel modelo;
    private DefaultComboBoxModel model;
    private DefaultComboBoxModel modelBoxDoenteAUsar;
    public static Integer linha;
    
    public Equipamentos(Sistema sistema, Serializacao serializacao, String nomeHospital, String codigoHospital) {
        initComponents();
        this.sistema = sistema;
        this.serializacao = serializacao;
        this.codigoHospital = codigoHospital;
        this.nomeHospital = nomeHospital;
        
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        
        //criação de modelos de tabelas e combobox´s
        modelo = (DefaultTableModel) tabelaEquipamentos.getModel();
        model = (DefaultComboBoxModel) boxEnfermariaColocado.getModel();
        modelBoxDoenteAUsar = (DefaultComboBoxModel) boxDoenteAUsar.getModel();
        
        setLocationRelativeTo(null);
        setResizable(false);
        
        painelDados.setVisible(false);
        labelDoente.setVisible(false);
        boxDoenteAUsar.setVisible(false);
        butGravarEstado.setVisible(false);
        butAlterarEstado.setVisible(false);
        
        //adicionar os valores na tabela
        tabelaEquipamentos.setModel(modelo);
        modelo.setNumRows(0);
        for (int i=0; i<sistema.getListaHospital().getCodHospital(codigoHospital).getListaEquipamento().sizeEquipamento(); i++) {
            Equipamento equipamento = sistema.getListaHospital().getCodHospital(codigoHospital).getListaEquipamento().getEquipamentosByIndex(i);
            if(equipamento.getDoenteAUsar()!=null)
                modelo.addRow(new Object[]{equipamento.getCodigoEqui(), equipamento.getTipoEqui(), equipamento.getEnfColocado().getCodigoEnf(), equipamento.getLivre(), equipamento.getDoenteAUsar().getCodigoDoen()});
            else
                modelo.addRow(new Object[]{equipamento.getCodigoEqui(), equipamento.getTipoEqui(), equipamento.getEnfColocado().getCodigoEnf(), equipamento.getLivre()});
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaEquipamentos = new javax.swing.JTable();
        butAdicionar = new javax.swing.JButton();
        painelDados = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCodigoEquipamento = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        boxEnfermariaColocado = new javax.swing.JComboBox<>();
        labelEstado = new javax.swing.JLabel();
        boxDoenteAUsar = new javax.swing.JComboBox<>();
        labelDoente = new javax.swing.JLabel();
        boxEstado = new javax.swing.JComboBox<>();
        butCriarEquipamento = new javax.swing.JToggleButton();
        boxTipoDeEquipamento = new javax.swing.JComboBox<>();
        butVoltar = new javax.swing.JButton();
        butAlterarEstado = new javax.swing.JToggleButton();
        butRemover = new javax.swing.JToggleButton();
        butGravarEstado = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabelaEquipamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Tipo", "Enfermaria colocado", "Estado", "Doente a usar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaEquipamentos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabelaEquipamentos.getTableHeader().setReorderingAllowed(false);
        tabelaEquipamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaEquipamentosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaEquipamentos);
        if (tabelaEquipamentos.getColumnModel().getColumnCount() > 0) {
            tabelaEquipamentos.getColumnModel().getColumn(0).setResizable(false);
            tabelaEquipamentos.getColumnModel().getColumn(1).setResizable(false);
            tabelaEquipamentos.getColumnModel().getColumn(2).setResizable(false);
            tabelaEquipamentos.getColumnModel().getColumn(3).setResizable(false);
            tabelaEquipamentos.getColumnModel().getColumn(4).setResizable(false);
        }

        butAdicionar.setText("Adicionar");
        butAdicionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butAdicionarMouseClicked(evt);
            }
        });

        jLabel1.setText("Codigo do Equipamento:");

        jLabel2.setText("Tipo de Equipamento:");

        jLabel3.setText(" Enfermaria colocado:");

        boxEnfermariaColocado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleciona uma opção" }));
        boxEnfermariaColocado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boxEnfermariaColocadoMouseClicked(evt);
            }
        });
        boxEnfermariaColocado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxEnfermariaColocadoActionPerformed(evt);
            }
        });

        labelEstado.setText("         Estado:");

        boxDoenteAUsar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escolha um doente" }));
        boxDoenteAUsar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boxDoenteAUsarMouseClicked(evt);
            }
        });
        boxDoenteAUsar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxDoenteAUsarActionPerformed(evt);
            }
        });

        labelDoente.setText("  Doente a usar:");

        boxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Livre","Ocupado" }));
        boxEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxEstadoActionPerformed(evt);
            }
        });

        butCriarEquipamento.setText("Criar equipamento");
        butCriarEquipamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butCriarEquipamentoMouseClicked(evt);
            }
        });

        boxTipoDeEquipamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Classe I – baixo risco", "Classe II – médio risco", "Classe III – alto risco", "Classe IV – máximo risco" }));
        boxTipoDeEquipamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxTipoDeEquipamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelDadosLayout = new javax.swing.GroupLayout(painelDados);
        painelDados.setLayout(painelDadosLayout);
        painelDadosLayout.setHorizontalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCodigoEquipamento)
                    .addComponent(boxEnfermariaColocado, 0, 170, Short.MAX_VALUE)
                    .addComponent(boxTipoDeEquipamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(painelDadosLayout.createSequentialGroup()
                            .addGap(187, 187, 187)
                            .addComponent(butCriarEquipamento, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
                        .addGroup(painelDadosLayout.createSequentialGroup()
                            .addGap(84, 84, 84)
                            .addComponent(labelDoente, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(boxDoenteAUsar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDadosLayout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(labelEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        painelDadosLayout.setVerticalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCodigoEquipamento)
                        .addComponent(labelEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDadosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(boxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(boxTipoDeEquipamento, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(boxDoenteAUsar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelDoente, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(butCriarEquipamento)
                    .addComponent(boxEnfermariaColocado))
                .addGap(44, 44, 44))
        );

        butVoltar.setText("Voltar");
        butVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butVoltarMouseClicked(evt);
            }
        });

        butAlterarEstado.setText("Alterar Estado");
        butAlterarEstado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butAlterarEstadoMouseClicked(evt);
            }
        });

        butRemover.setText("Remover");
        butRemover.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butRemoverMouseClicked(evt);
            }
        });
        butRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butRemoverActionPerformed(evt);
            }
        });

        butGravarEstado.setText("Gravar Estado");
        butGravarEstado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butGravarEstadoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(painelDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(butAlterarEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(butRemover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(butGravarEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(butAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 30, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(butVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(butVoltar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(butAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(butRemover)
                        .addGap(9, 9, 9)
                        .addComponent(butAlterarEstado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(butGravarEstado)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(painelDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        setBounds(0, 0, 872, 569);
    }// </editor-fold>//GEN-END:initComponents

    private void boxEnfermariaColocadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxEnfermariaColocadoActionPerformed
        //remover todos os elementos da combobox
        modelBoxDoenteAUsar.removeAllElements();
    }//GEN-LAST:event_boxEnfermariaColocadoActionPerformed

    private void boxEnfermariaColocadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boxEnfermariaColocadoMouseClicked
        //adicionar elementos na combobox
        model.removeAllElements();
        for (int o=0; o<sistema.getListaHospital().getCodHospital(codigoHospital).getListaEnfermaria().sizeEnfermaria(); o++) {
            Enfermaria enfermaria = sistema.getListaHospital().getCodHospital(codigoHospital).getListaEnfermaria().getEnfermariaByIndex(o);
            model.addElement(enfermaria.getCodigoEnf());
        }
    }//GEN-LAST:event_boxEnfermariaColocadoMouseClicked

    private void butVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butVoltarMouseClicked
        //voltar atras
        this.dispose();
    }//GEN-LAST:event_butVoltarMouseClicked

    private void boxDoenteAUsarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxDoenteAUsarActionPerformed
        
    }//GEN-LAST:event_boxDoenteAUsarActionPerformed

    private void boxDoenteAUsarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boxDoenteAUsarMouseClicked
        
        //adicionar elementos na combobox
        modelBoxDoenteAUsar.removeAllElements();
        String codigoEnfermaria = (String)model.getSelectedItem();
        for (int i=0; i<sistema.getListaHospital().getCodHospital(codigoHospital).getListaDoentes().sizeDoentes(); i++) {
            Doente doente = sistema.getListaHospital().getCodHospital(codigoHospital).getListaDoentes().getDoentesByIndex(i);
            if(codigoEnfermaria.equals(doente.getEnfermariaOndeEstaODoente()))
                modelBoxDoenteAUsar.addElement(doente.getCodigoDoen());
        }
    }//GEN-LAST:event_boxDoenteAUsarMouseClicked

    private void butAdicionarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butAdicionarMouseClicked
        //paineis visiveis
        painelDados.setVisible(true);
        butCriarEquipamento.setVisible(true);
        butGravarEstado.setVisible(false);
        butAlterarEstado.setVisible(false);
        
    }//GEN-LAST:event_butAdicionarMouseClicked

    private void boxEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxEstadoActionPerformed
        
        //estado do equipamento
        painelDados.setVisible(true);
        String estado = (String) boxEstado.getSelectedItem();
        if (!estado.equals("Ocupado")){
            labelDoente.setVisible(false);
            boxDoenteAUsar.setVisible(false);
        }else{
            labelDoente.setVisible(true);
            boxDoenteAUsar.setVisible(true);
        }
    }//GEN-LAST:event_boxEstadoActionPerformed

    private void butRemoverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butRemoverMouseClicked
        
        //remover equipamento da tabela
        try{
            butCriarEquipamento.setVisible(false);
            String codigoEquipamento = (String) tabelaEquipamentos.getValueAt(linha, 0);
                for(int i=0; i<sistema.getListaHospital().getCodHospital(codigoHospital).getListaEquipamento().sizeEquipamento();i++){
                if(codigoEquipamento.equals(sistema.getListaHospital().getCodHospital(codigoHospital).getListaEquipamento().getEquipamentosByIndex(i).getCodigoEqui())){
                    modelo.removeRow(linha);
                    sistema.getListaHospital().getCodHospital(codigoHospital).getListaEquipamento().setRemoverEquipamento(sistema.getListaHospital().getCodHospital(codigoHospital).getListaEquipamento().getEquipamentosByIndex(i).getCodigoEqui());
                }
            }
        }catch(NullPointerException exc){
            JOptionPane.showMessageDialog(null, "Não selecionou uma linha!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        serializacao.guardar(sistema);
    }//GEN-LAST:event_butRemoverMouseClicked

    private void tabelaEquipamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaEquipamentosMouseClicked
        //selecionar linha da tabela
        linha = tabelaEquipamentos.getSelectedRow();
        butAlterarEstado.setVisible(true);
        butGravarEstado.setVisible(false);
    }//GEN-LAST:event_tabelaEquipamentosMouseClicked

    private void butAlterarEstadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butAlterarEstadoMouseClicked
        //obter valores da tabela e paineis visiveis
        try{
            butCriarEquipamento.setVisible(false);
            String codigoEquipamento = (String) tabelaEquipamentos.getValueAt(linha, 0);
            String tipoEquipamento = (String) tabelaEquipamentos.getValueAt(linha, 1);
            String enfermariaColocado = (String) tabelaEquipamentos.getValueAt(linha, 2);
            String estado = (String) tabelaEquipamentos.getValueAt(linha, 3);
            String doenteAUsar = (String) tabelaEquipamentos.getValueAt(linha, 4);
            txtCodigoEquipamento.setText(codigoEquipamento);
            boxTipoDeEquipamento.setSelectedItem(tipoEquipamento);
            model.setSelectedItem(enfermariaColocado);
            boxEstado.setSelectedItem(estado);
            txtCodigoEquipamento.setEditable(false);
            boxTipoDeEquipamento.setEnabled(false);
            boxEnfermariaColocado.setEnabled(false);
            butGravarEstado.setVisible(true);
            
        }catch(NullPointerException exc){
            JOptionPane.showMessageDialog(null, "Não selecionou uma linha!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        serializacao.guardar(sistema);
    }//GEN-LAST:event_butAlterarEstadoMouseClicked

    private void butRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butRemoverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_butRemoverActionPerformed

    private void butGravarEstadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butGravarEstadoMouseClicked
        //alterar estado do equipamento
        try{
            butCriarEquipamento.setVisible(false);
        
            String codigoEquipamento = (String) txtCodigoEquipamento.getText();
            String tipoEquipamento = (String) boxTipoDeEquipamento.getSelectedItem();
            String enfermariaColocado = (String) boxEnfermariaColocado.getSelectedItem();
            String estado = (String) boxEstado.getSelectedItem();
            String doenteColocado = (String) boxDoenteAUsar.getSelectedItem();
            
            for(int i=0; i<sistema.getListaHospital().getCodHospital(codigoHospital).getListaEquipamento().sizeEquipamento();i++){
                if(codigoEquipamento.equals(sistema.getListaHospital().getCodHospital(codigoHospital).getListaEquipamento().getEquipamentosByIndex(i).getCodigoEqui())){
                    sistema.getListaHospital().getCodHospital(codigoHospital).getListaEquipamento().getEquipamentosByIndex(i).setLivre(estado);
                    if(estado.equals("Livre")){
                        sistema.getListaHospital().getCodHospital(codigoHospital).getListaEquipamento().getEquipamentosByIndex(i).setDoenteAUsar(null);
                        modelo.removeRow(linha);
                        modelo.addRow(new Object[]{codigoEquipamento, tipoEquipamento, sistema.getListaHospital().getCodHospital(codigoHospital).getListaEnfermaria().getEnfermaria(enfermariaColocado).getCodigoEnf(), estado});
                    }
                    if(estado.equals("Ocupado")){
                        sistema.getListaHospital().getCodHospital(codigoHospital).getListaEquipamento().getEquipamentosByIndex(i).setDoenteAUsar(sistema.getListaHospital().getCodHospital(codigoHospital).getListaDoentes().getDoente(doenteColocado));
                        modelo.removeRow(linha);
                        modelo.addRow(new Object[]{codigoEquipamento, tipoEquipamento, sistema.getListaHospital().getCodHospital(codigoHospital).getListaEnfermaria().getEnfermaria(enfermariaColocado).getCodigoEnf(), estado, sistema.getListaHospital().getCodHospital(codigoHospital).getListaDoentes().getDoente(doenteColocado).getCodigoDoen()});
                    }
                }
            }
            painelDados.setVisible(false);
            butGravarEstado.setVisible(false);
            butAlterarEstado.setVisible(false);
        }catch(NullPointerException exc){
            JOptionPane.showMessageDialog(null, "Introduza um doente para receber o equipamento!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }catch(RuntimeException exc){
            JOptionPane.showMessageDialog(null, "Introduza um doente para receber o equipamento!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_butGravarEstadoMouseClicked

    private void butCriarEquipamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butCriarEquipamentoMouseClicked
        //criar equipamento
        try{
            String codigoEquipamento = (String) txtCodigoEquipamento.getText();
            String tipoEquipamento = (String) boxTipoDeEquipamento.getSelectedItem();
            String enfermariaColocado = (String) boxEnfermariaColocado.getSelectedItem();
            String estado = (String) boxEstado.getSelectedItem();
            String doenteColocado = (String) boxDoenteAUsar.getSelectedItem();
            
            if(!sistema.getListaHospital().getCodHospital(codigoHospital).getListaEquipamento().existe(codigoEquipamento)){
                if(estado.equals("Ocupado")){
                    sistema.getListaHospital().getCodHospital(codigoHospital).getListaEquipamento().addEquipamento(new Equipamento(codigoEquipamento, tipoEquipamento, sistema.getListaHospital().getCodHospital(codigoHospital).getListaEnfermaria().getEnfermaria(enfermariaColocado), estado, sistema.getListaHospital().getCodHospital(codigoHospital).getListaDoentes().getDoente(doenteColocado)));
                    modelo.addRow(new Object[]{codigoEquipamento, tipoEquipamento, sistema.getListaHospital().getCodHospital(codigoHospital).getListaEnfermaria().getEnfermaria(enfermariaColocado).getCodigoEnf(), estado, sistema.getListaHospital().getCodHospital(codigoHospital).getListaDoentes().getDoente(doenteColocado).getCodigoDoen()});
                }else if((estado.equals("Livre"))){
                    sistema.getListaHospital().getCodHospital(codigoHospital).getListaEquipamento().addEquipamento(new Equipamento(codigoEquipamento, tipoEquipamento, sistema.getListaHospital().getCodHospital(codigoHospital).getListaEnfermaria().getEnfermaria(enfermariaColocado), estado));
                    modelo.addRow(new Object[]{codigoEquipamento, tipoEquipamento, sistema.getListaHospital().getCodHospital(codigoHospital).getListaEnfermaria().getEnfermaria(enfermariaColocado).getCodigoEnf(), estado});
                }
            }else{
                JOptionPane.showMessageDialog(null, "Já existe um equipamento com este código!", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
            painelDados.setVisible(false);
            serializacao.guardar(sistema);
        }
        catch(NullPointerException exc){
            JOptionPane.showMessageDialog(null, "Introduza os valores solicitados!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        catch(RuntimeException exc){
            JOptionPane.showMessageDialog(null, "Introduza os valores solicitados!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_butCriarEquipamentoMouseClicked

    private void boxTipoDeEquipamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxTipoDeEquipamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxTipoDeEquipamentoActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxDoenteAUsar;
    private javax.swing.JComboBox<String> boxEnfermariaColocado;
    private javax.swing.JComboBox<String> boxEstado;
    private javax.swing.JComboBox<String> boxTipoDeEquipamento;
    private javax.swing.JButton butAdicionar;
    private javax.swing.JToggleButton butAlterarEstado;
    private javax.swing.JToggleButton butCriarEquipamento;
    private javax.swing.JToggleButton butGravarEstado;
    private javax.swing.JToggleButton butRemover;
    private javax.swing.JButton butVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelDoente;
    private javax.swing.JLabel labelEstado;
    private javax.swing.JPanel painelDados;
    private javax.swing.JTable tabelaEquipamentos;
    private javax.swing.JTextField txtCodigoEquipamento;
    // End of variables declaration//GEN-END:variables

}
