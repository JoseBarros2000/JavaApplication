
package FrontEnd;

import BackEnd.Enfermeiro;
import BackEnd.Medico;
import BackEnd.ProfDeSaude;
import BackEnd.Sistema;
import Serializacao.Serializacao;
import javax.swing.table.DefaultTableModel;

public class ProfissionaisDeSaude extends javax.swing.JFrame {

    DefaultTableModel modeloProfSaude;
    private Sistema sistema;
    
    public ProfissionaisDeSaude(Sistema sistema, Serializacao serializacao, String nomeSelecionado) {
        initComponents();
        
        this.sistema=sistema;
        
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        
        //modelos e inserir dados na tabela
        modeloProfSaude = (DefaultTableModel) tableProfSaude.getModel();
        tableProfSaude.setModel(modeloProfSaude);
        modeloProfSaude.setNumRows(0);
        for(int i=0; i<sistema.getListaHospital().getNomeHospital(nomeSelecionado).getListaProfDeSaude().sizeProf(); i++){
            ProfDeSaude profSaude = sistema.getListaHospital().getNomeHospital(nomeSelecionado).getListaProfDeSaude().getProfDeSaudeByIndex(i);
            if(profSaude instanceof Medico){
              modeloProfSaude.addRow(new Object[]{"Médico", profSaude.getCodigoProf(), profSaude.getNomeProf(), ((Medico) profSaude).getEspecialidade(), ((Medico) profSaude).getNumDoentesAtribuidos()} );
        }
            if(profSaude instanceof Enfermeiro){
              modeloProfSaude.addRow(new Object[] {"Enfermeiro",profSaude.getCodigoProf(), profSaude.getNomeProf()});
            }
        
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableProfSaude = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        nomeHosp = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableProfSaude.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cargo", "Código", "Nome", "Especialidade", "Número de Doentes"
            }
        ));
        jScrollPane1.setViewportView(tableProfSaude);

        jLabel1.setText("Hospital:");

        jLabel2.setText("Profissionais de Saúde");

        btnVoltar.setText("Voltar");
        btnVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVoltarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nomeHosp, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12)))
                .addContainerGap(32, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nomeHosp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVoltar)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltarMouseClicked
        dispose();
    }//GEN-LAST:event_btnVoltarMouseClicked

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nomeHosp;
    private javax.swing.JTable tableProfSaude;
    // End of variables declaration//GEN-END:variables
}
