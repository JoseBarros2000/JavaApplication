
package FrontEnd;

import BackEnd.Enfermaria;
import BackEnd.Hospital;
import BackEnd.Sistema;
import FrontEnd.EquipamentosLE;
import static FrontEnd.Equipamentos.linha;
import Serializacao.Serializacao;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class ListaEnfermarias extends javax.swing.JInternalFrame {
    private Sistema sistema;
    private Serializacao serializacao;
    private Enfermaria enfermaria;
    DefaultTableModel modelo; 
    
    public ListaEnfermarias(Sistema sistema, Serializacao serializacao, Enfermaria enfermaria) {
        initComponents();
        
      this.sistema = sistema;
      this.serializacao = serializacao;
      this.enfermaria = enfermaria;
      
      this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
      
      modelo = (DefaultTableModel) tabelaEnfermarias.getModel();
      
      atualizarTabela();
    
    }
//ordenar tabela
    public void sort() {
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelo);
        tabelaEnfermarias.setRowSorter(sorter);
    }
   public void atualizarTabela() {
        tabelaEnfermarias.setModel(modelo);
        modelo.setNumRows(0);
        for (int i=0; i<sistema.getListaHospital().getCodHospital(sistema.getEnfermeiroLigado().getHospitalOndeTrabalha().getCodigo()).getListaEnfermaria().sizeEnfermaria(); i++) {
            Enfermaria enfermaria = sistema.getListaHospital().getCodHospital(sistema.getEnfermeiroLigado().getHospitalOndeTrabalha().getCodigo()).getListaEnfermaria().getEnfermariaByIndex(i);
            modelo.addRow(new Object[]{enfermaria.getCodigoEnf(), enfermaria.getTipoEnf(), enfermaria.getCamas(), enfermaria.getListaCamasOcupadas(), enfermaria.getListaCamasDesocupadas()});
        }
    }
   
   //filtrar
    public void filterListaEnf(String searchlistaenf){
        TableRowSorter<DefaultTableModel> tlistaenf = new TableRowSorter<>(modelo);
        tabelaEnfermarias.setRowSorter(tlistaenf);
        tlistaenf.setRowFilter(RowFilter.regexFilter(searchlistaenf));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaEnfermarias = new javax.swing.JTable();
        butEquipamentos = new javax.swing.JButton();
        txtPesquisar = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        jLabel1.setText("Enfermarias:");

        tabelaEnfermarias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Tipo", "Nº Camas", "Camas Ocupadas", "Camas Vazias"
            }
        ));
        tabelaEnfermarias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaEnfermariasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaEnfermarias);

        butEquipamentos.setText("Equipamentos");
        butEquipamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butEquipamentosMouseClicked(evt);
            }
        });

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
                .addGap(32, 32, 32)
                .addComponent(butEquipamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPesquisar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(butEquipamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butEquipamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butEquipamentosMouseClicked
        
        EquipamentosLE equipamentosLE = new EquipamentosLE(sistema, serializacao, sistema.getEnfermeiroLigado().getHospitalOndeTrabalha().getCodigo(), sistema.getEnfermeiroLigado().getHospitalOndeTrabalha().getNome());
        equipamentosLE.setVisible(true);

        
    }//GEN-LAST:event_butEquipamentosMouseClicked

    private void txtPesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPesquisarMouseClicked
        txtPesquisar.setText("");
    }//GEN-LAST:event_txtPesquisarMouseClicked

    private void txtPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarKeyReleased
       //pesquisar na tabela
        String searchlistaenf = txtPesquisar.getText();
        filterListaEnf(searchlistaenf);
    }//GEN-LAST:event_txtPesquisarKeyReleased

    private void tabelaEnfermariasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaEnfermariasMouseClicked
        linha = tabelaEnfermarias.getSelectedRow();
    }//GEN-LAST:event_tabelaEnfermariasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butEquipamentos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaEnfermarias;
    private javax.swing.JTextField txtPesquisar;
    // End of variables declaration//GEN-END:variables
}
