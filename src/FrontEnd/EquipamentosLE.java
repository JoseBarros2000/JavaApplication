
package FrontEnd;

import BackEnd.Doente;
import BackEnd.Enfermaria;
import BackEnd.Equipamento;
import BackEnd.Sistema;
import static FrontEnd.Doentes.linha;
import Serializacao.Serializacao;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class EquipamentosLE extends javax.swing.JFrame {
    private Sistema sistema;
    private Serializacao serializacao;
    private String codigoHospital;
    private String nomeHospital;
    private DefaultTableModel modelo;
    private DefaultComboBoxModel modelBoxDoenteAUsar;
    private String codigoEqui;
    private String tipoEqui;
    private String enfColocado;
    private String estado;
    
    
    public EquipamentosLE(Sistema sistema, Serializacao serializacao, String codigoHospital, String nomeHospital) {
        initComponents();
        this.sistema = sistema;
        this.serializacao = serializacao;
        this.codigoHospital = codigoHospital;
        this.nomeHospital = nomeHospital;
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        
        //modelos
        modelo = (DefaultTableModel) tabelaEquipamentos.getModel();
        modelBoxDoenteAUsar = (DefaultComboBoxModel) boxDoenteAUsar.getModel();
         
        painelDados.setVisible(true);
        butGravarEstado.setVisible(false);
        butAlterarEstado.setVisible(true);
        boxDoenteAUsar.setVisible(false);
        labelDoente.setVisible(false);
        labelEstado.setVisible(false);
        boxEstado.setVisible(false);
        
        //adicionar elementos a tabela
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
    
    //filtrar tabela
    public void filterEqui(String searchequi){
        TableRowSorter<DefaultTableModel> tequi = new TableRowSorter<>(modelo);
        tabelaEquipamentos.setRowSorter(tequi);
        tequi.setRowFilter(RowFilter.regexFilter(searchequi));
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaEquipamentos = new javax.swing.JTable();
        butVoltar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        painelDados = new javax.swing.JPanel();
        butGravarEstado = new javax.swing.JToggleButton();
        butAlterarEstado = new javax.swing.JToggleButton();
        boxEstado = new javax.swing.JComboBox<>();
        boxDoenteAUsar = new javax.swing.JComboBox<>();
        labelEstado = new javax.swing.JLabel();
        labelDoente = new javax.swing.JLabel();
        txtPesquisar = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

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
        tabelaEquipamentos.getTableHeader().setReorderingAllowed(false);
        tabelaEquipamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaEquipamentosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaEquipamentos);

        butVoltar.setText("Voltar");
        butVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butVoltarMouseClicked(evt);
            }
        });

        jLabel1.setText("Equipamentos");

        butGravarEstado.setText("Gravar Estado");
        butGravarEstado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butGravarEstadoMouseClicked(evt);
            }
        });

        butAlterarEstado.setText("Alterar Estado");
        butAlterarEstado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butAlterarEstadoMouseClicked(evt);
            }
        });

        boxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escolha um estado", "Livre","Ocupado" }));
        boxEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxEstadoActionPerformed(evt);
            }
        });

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

        labelEstado.setText("         Estado:");

        labelDoente.setText("  Doente a usar:");

        javax.swing.GroupLayout painelDadosLayout = new javax.swing.GroupLayout(painelDados);
        painelDados.setLayout(painelDadosLayout);
        painelDadosLayout.setHorizontalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelDoente, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(boxDoenteAUsar, 0, 164, Short.MAX_VALUE)
                    .addComponent(boxEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(butAlterarEstado, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                    .addComponent(butGravarEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(42, 42, 42))
        );
        painelDadosLayout.setVerticalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(butAlterarEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(boxDoenteAUsar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDoente, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(butGravarEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtPesquisar.setText("Pesquisar");
        txtPesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPesquisarMouseClicked(evt);
            }
        });
        txtPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisarKeyReleased(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_search_16px.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(painelDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(butVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(butVoltar)))
                    .addComponent(txtPesquisar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(painelDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaEquipamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaEquipamentosMouseClicked
       //selecionar linha
        linha = tabelaEquipamentos.getSelectedRow();
        butAlterarEstado.setVisible(true);
        butGravarEstado.setVisible(false);
    }//GEN-LAST:event_tabelaEquipamentosMouseClicked

    private void butVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butVoltarMouseClicked
        this.dispose();
    }//GEN-LAST:event_butVoltarMouseClicked

    private void boxEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxEstadoActionPerformed
        //estado do equipamento
        String estado = (String) boxEstado.getSelectedItem();
        if (!estado.equals("Ocupado")){
            labelDoente.setVisible(false);
            boxDoenteAUsar.setVisible(false);
        }else{
            labelDoente.setVisible(true);
            boxDoenteAUsar.setVisible(true);
        }
    }//GEN-LAST:event_boxEstadoActionPerformed

    private void boxDoenteAUsarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boxDoenteAUsarMouseClicked
        
        //adicionar doentes que podem usar
        modelBoxDoenteAUsar.removeAllElements();
        
        for (int i=0; i<sistema.getListaHospital().getCodHospital(sistema.getEnfermeiroLigado().getHospitalOndeTrabalha().getCodigo()).getListaDoentes().sizeDoentes(); i++) {
            Doente doente = sistema.getListaHospital().getCodHospital(sistema.getEnfermeiroLigado().getHospitalOndeTrabalha().getCodigo()).getListaDoentes().getDoentesByIndex(i);
            modelBoxDoenteAUsar.addElement(doente.getCodigoDoen());
        }
    }//GEN-LAST:event_boxDoenteAUsarMouseClicked

    private void boxDoenteAUsarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxDoenteAUsarActionPerformed

    }//GEN-LAST:event_boxDoenteAUsarActionPerformed

    private void butAlterarEstadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butAlterarEstadoMouseClicked
        
        //alterar estado do equipamento e paineis visiveis
        try{
            codigoEqui = (String) tabelaEquipamentos.getValueAt(linha, 0);
            tipoEqui = (String) tabelaEquipamentos.getValueAt(linha, 1);
            enfColocado = (String) tabelaEquipamentos.getValueAt(linha, 2);
            estado = (String) tabelaEquipamentos.getValueAt(linha, 3);
            
            boxEstado.setSelectedItem(estado);
            butGravarEstado.setVisible(true);
            boxEstado.setVisible(true);
            labelEstado.setVisible(true);

        }catch(NullPointerException exc){
            JOptionPane.showMessageDialog(null, "Não selecionou uma linha!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        serializacao.guardar(sistema);
    }//GEN-LAST:event_butAlterarEstadoMouseClicked

    private void butGravarEstadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butGravarEstadoMouseClicked
        //gravar estado do equipamentos
        try{     
            String estado = (String) boxEstado.getSelectedItem();
            String doenteColocado = (String) boxDoenteAUsar.getSelectedItem();

            for(int i=0; i<sistema.getListaHospital().getCodHospital(sistema.getEnfermeiroLigado().getHospitalOndeTrabalha().getCodigo()).getListaEquipamento().sizeEquipamento();i++){
                if(!estado.equals(sistema.getListaHospital().getCodHospital(sistema.getEnfermeiroLigado().getHospitalOndeTrabalha().getCodigo()).getListaEquipamento().getEquipamentosByIndex(i).getLivre())){
                    sistema.getListaHospital().getCodHospital(sistema.getEnfermeiroLigado().getHospitalOndeTrabalha().getCodigo()).getListaEquipamento().getEquipamentosByIndex(i).setLivre(estado);
                    if(estado.equals("Livre")){
                        sistema.getListaHospital().getCodHospital(sistema.getEnfermeiroLigado().getHospitalOndeTrabalha().getCodigo()).getListaEquipamento().getEquipamentosByIndex(i).setDoenteAUsar(null);
                        modelo.removeRow(linha);
                        modelo.addRow(new Object[]{codigoEqui,tipoEqui,enfColocado, estado});
                    }
                    if(estado.equals("Ocupado")){
                        sistema.getListaHospital().getCodHospital(sistema.getEnfermeiroLigado().getHospitalOndeTrabalha().getCodigo()).getListaEquipamento().getEquipamentosByIndex(i).setDoenteAUsar(sistema.getListaHospital().getCodHospital(sistema.getEnfermeiroLigado().getHospitalOndeTrabalha().getCodigo()).getListaDoentes().getDoente(doenteColocado));
                        modelo.removeRow(linha);
                        modelo.addRow(new Object[]{codigoEqui,tipoEqui,enfColocado, estado, doenteColocado});
                    }
                }
            }

        }catch(NullPointerException exc){
            JOptionPane.showMessageDialog(null, "Introduza um doente para receber o equipamento!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }catch(RuntimeException exc){
            JOptionPane.showMessageDialog(null, "Introduza um doente para receber o equipamento!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        serializacao.guardar(sistema);
    }//GEN-LAST:event_butGravarEstadoMouseClicked

    private void txtPesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPesquisarMouseClicked
        txtPesquisar.setText("");
    }//GEN-LAST:event_txtPesquisarMouseClicked

    private void txtPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarKeyReleased
        //pesquisar na tabela
        String searchequi = txtPesquisar.getText();
        filterEqui(searchequi);
    }//GEN-LAST:event_txtPesquisarKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxDoenteAUsar;
    private javax.swing.JComboBox<String> boxEstado;
    private javax.swing.JToggleButton butAlterarEstado;
    private javax.swing.JToggleButton butGravarEstado;
    private javax.swing.JButton butVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelDoente;
    private javax.swing.JLabel labelEstado;
    private javax.swing.JPanel painelDados;
    private javax.swing.JTable tabelaEquipamentos;
    private javax.swing.JTextField txtPesquisar;
    // End of variables declaration//GEN-END:variables
}
