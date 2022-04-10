
package FrontEnd;

import BackEnd.Hospital;
import BackEnd.ListaDoentes;
import BackEnd.ListaEnfermarias;
import BackEnd.ListaEquipamentos;
import BackEnd.ListaProfDeSaude;
import BackEnd.Sistema;
import FrontEnd.DashB;
import FrontEnd.Enfermarias;
import FrontEnd.Equipamentos;
import FrontEnd.ProfissionaisDeSaude;
import Serializacao.Serializacao;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class Hospitais extends javax.swing.JInternalFrame {

    private Sistema sistema;
    private Serializacao serializacao;
    private boolean foiClicado = false;
    private boolean foiClicadoHosp = false;
    JFrame frame;
    private DefaultListModel modelo;
    private String codOriginal;
    private String nomeOriginal;
    private String localidadeOriginal;
    
    
    public Hospitais(Sistema sistema,Serializacao serializacao){
        initComponents();
         this.sistema=sistema;
         this.serializacao=serializacao;
         
         this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
       
        modelo = new DefaultListModel(); //modelo -> lista
        PainelAdd.setVisible(true);
        PainelAddHosp.setVisible(false);
        PainelEditRemov.setVisible(false);
        PainelCriarHosp.setVisible(false);
        PainelGuardarDados.setVisible(false);
        ButtVoltar.setVisible(false);
        
        sistema.getListaHospital().ordenacaoHospitais();//ordenacao do hospital
        
        //inserir valores
        for(int i=0; i<sistema.getListaHospital().sizeListaHospital(); i++){
            String hospital = sistema.getListaHospital().getHospitalByIndex(i).getNome();
            modelo.addElement(hospital);
        }
        listaHospitais.setModel(modelo);
        listaHospitais.setSelectedIndex(0);
    }
    String atualizarLista(){
        for(int i=0; i<sistema.getListaHospital().sizeListaHospital(); i++){
            String hospital = sistema.getListaHospital().getHospitalByIndex(i).getNome();
            modelo.addElement(hospital);
        }
        return "Atualizar";
    }
    String removerElementosLista(){
        for(int i=0; i<sistema.getListaHospital().sizeListaHospital(); i++){
            String hospital = sistema.getListaHospital().getHospitalByIndex(i).getNome();
            modelo.removeElement(hospital);
        }
        return "Removido";
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaHospitais = new javax.swing.JList<>();
        PainelAdd = new javax.swing.JPanel();
        ButtAddHosp = new javax.swing.JButton();
        PainelEditRemov = new javax.swing.JPanel();
        ButtEditHosp = new javax.swing.JButton();
        ButtRemoverHosp = new javax.swing.JButton();
        PainelAddHosp = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtLocalidade = new javax.swing.JTextField();
        PainelButtListas = new javax.swing.JPanel();
        ButtEnfermaria = new javax.swing.JButton();
        ButtEquipamento = new javax.swing.JButton();
        ButtDoente = new javax.swing.JButton();
        ButtProfSaude = new javax.swing.JButton();
        ButtDashBoard = new javax.swing.JButton();
        PainelCriarHosp = new javax.swing.JPanel();
        ButtCriarHosp = new javax.swing.JButton();
        PainelGuardarDados = new javax.swing.JPanel();
        ButtGuardarDados = new javax.swing.JButton();
        ButtVoltar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setPreferredSize(new java.awt.Dimension(510, 420));
        getContentPane().setLayout(null);

        listaHospitais.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaHospitaisMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listaHospitais);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(6, 36, 500, 100);

        PainelAdd.setLayout(new java.awt.GridLayout(1, 0));

        ButtAddHosp.setText("Adicionar Hospital");
        ButtAddHosp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtAddHospMouseClicked(evt);
            }
        });
        PainelAdd.add(ButtAddHosp);

        getContentPane().add(PainelAdd);
        PainelAdd.setBounds(6, 147, 490, 30);

        PainelEditRemov.setLayout(new java.awt.GridLayout(1, 0));

        ButtEditHosp.setText("Editar Hospital");
        ButtEditHosp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtEditHospMouseClicked(evt);
            }
        });
        PainelEditRemov.add(ButtEditHosp);

        ButtRemoverHosp.setText("Remover Hospital");
        ButtRemoverHosp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtRemoverHospMouseClicked(evt);
            }
        });
        PainelEditRemov.add(ButtRemoverHosp);

        getContentPane().add(PainelEditRemov);
        PainelEditRemov.setBounds(10, 150, 480, 30);

        jLabel2.setText("Nome:");

        jLabel3.setText("Código:");

        jLabel4.setText("Localidade:");

        PainelButtListas.setLayout(new java.awt.GridBagLayout());

        ButtEnfermaria.setText("Enfermaria");
        ButtEnfermaria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtEnfermariaMouseClicked(evt);
            }
        });
        PainelButtListas.add(ButtEnfermaria, new java.awt.GridBagConstraints());

        ButtEquipamento.setText("Equipamento");
        ButtEquipamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtEquipamentoMouseClicked(evt);
            }
        });
        PainelButtListas.add(ButtEquipamento, new java.awt.GridBagConstraints());

        ButtDoente.setText("Doentes");
        ButtDoente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtDoenteMouseClicked(evt);
            }
        });
        PainelButtListas.add(ButtDoente, new java.awt.GridBagConstraints());

        ButtProfSaude.setText("Profissionais De Saúde");
        ButtProfSaude.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtProfSaudeMouseClicked(evt);
            }
        });
        PainelButtListas.add(ButtProfSaude, new java.awt.GridBagConstraints());

        ButtDashBoard.setText("DASHBOARD GERAL");
        ButtDashBoard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtDashBoardMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PainelAddHospLayout = new javax.swing.GroupLayout(PainelAddHosp);
        PainelAddHosp.setLayout(PainelAddHospLayout);
        PainelAddHospLayout.setHorizontalGroup(
            PainelAddHospLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PainelButtListas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
            .addGroup(PainelAddHospLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PainelAddHospLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PainelAddHospLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCodigo)
                    .addComponent(txtLocalidade)
                    .addComponent(txtNome))
                .addGap(44, 44, 44)
                .addComponent(ButtDashBoard)
                .addGap(33, 33, 33))
        );
        PainelAddHospLayout.setVerticalGroup(
            PainelAddHospLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelAddHospLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(PainelAddHospLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGroup(PainelAddHospLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelAddHospLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(ButtDashBoard))
                    .addGroup(PainelAddHospLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(PainelAddHospLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PainelAddHospLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtLocalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PainelButtListas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(PainelAddHosp);
        PainelAddHosp.setBounds(10, 190, 490, 160);

        PainelCriarHosp.setLayout(new java.awt.GridLayout(1, 0));

        ButtCriarHosp.setText("Criar Hospital");
        ButtCriarHosp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtCriarHospMouseClicked(evt);
            }
        });
        PainelCriarHosp.add(ButtCriarHosp);

        getContentPane().add(PainelCriarHosp);
        PainelCriarHosp.setBounds(10, 350, 480, 30);

        PainelGuardarDados.setLayout(new java.awt.GridLayout(1, 0));

        ButtGuardarDados.setText("Guardar Hospital");
        ButtGuardarDados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtGuardarDadosMouseClicked(evt);
            }
        });
        PainelGuardarDados.add(ButtGuardarDados);

        getContentPane().add(PainelGuardarDados);
        PainelGuardarDados.setBounds(10, 350, 480, 30);

        ButtVoltar.setText("Voltar");
        ButtVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtVoltarMouseClicked(evt);
            }
        });
        getContentPane().add(ButtVoltar);
        ButtVoltar.setBounds(400, 380, 90, 30);

        jLabel5.setText("Lista de Hospitais");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 10, 490, 13);

        setBounds(0, 0, 515, 432);
    }// </editor-fold>//GEN-END:initComponents

    private void ButtAddHospMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtAddHospMouseClicked
       PainelAddHosp.setVisible(true);
       PainelCriarHosp.setVisible(true);
       ButtVoltar.setVisible(true);
      
    }//GEN-LAST:event_ButtAddHospMouseClicked

    private void ButtCriarHospMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtCriarHospMouseClicked
        //criar hospital
        String nomeHosp = txtNome.getText();
        String codigoHosp = txtCodigo.getText();
        String localidadeHosp = txtLocalidade.getText();
        if(!sistema.getListaHospital().existeCodHospital(codigoHosp)){
            ListaDoentes listaDoentes = new ListaDoentes();
            ListaEnfermarias listaEnfermarias = new ListaEnfermarias();
            ListaEquipamentos listaEquipamentos = new ListaEquipamentos();
            ListaProfDeSaude listaProfDeSaude = new ListaProfDeSaude();
            sistema.getListaHospital().criarNovoHosp(new Hospital (codigoHosp, nomeHosp, localidadeHosp, listaDoentes, listaEnfermarias, listaEquipamentos, listaProfDeSaude));
            serializacao.guardar(sistema);
            removerElementosLista();
            sistema.getListaHospital().ordenacaoHospitais();
            atualizarLista();
        }
    }//GEN-LAST:event_ButtCriarHospMouseClicked

    private void ButtEnfermariaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtEnfermariaMouseClicked
       //abrir janela enfermaria
        String codigoHosp = txtCodigo.getText();
        String nomeHopital = txtNome.getText();
        Enfermarias enfermarias = new Enfermarias(sistema, serializacao, nomeHopital,codigoHosp);
        enfermarias.setVisible(true);
    }//GEN-LAST:event_ButtEnfermariaMouseClicked

    private void listaHospitaisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaHospitaisMouseClicked
        
        //selecionar hospital na lista
        PainelAdd.setVisible(false);
        PainelEditRemov.setVisible(true);
        PainelGuardarDados.setVisible(true);
        PainelCriarHosp.setVisible(false);
        PainelButtListas.setVisible(true);
        
        txtNome.setEditable(false);
        txtCodigo.setEditable(false);
        txtLocalidade.setEditable(false);
        
        PainelAddHosp.setVisible(true);
        ButtVoltar.setVisible(true);
        
        String nomeHosp = listaHospitais.getSelectedValue();
        
        if(nomeHosp.equals(String.valueOf(-1))){
            JOptionPane.showMessageDialog(null, "O hospital não existe", "ERRO", JOptionPane.ERROR_MESSAGE);
        }else{
        txtNome.setText(nomeHosp);
        txtCodigo.setText(sistema.getListaHospital().getNomeHospital(nomeHosp).getCodigo());
        txtLocalidade.setText(sistema.getListaHospital().getNomeHospital(nomeHosp).getLocalidade());
        }
        
        serializacao.guardar(sistema);
        removerElementosLista();
        sistema.getListaHospital().ordenacaoHospitais();
        atualizarLista();
    }//GEN-LAST:event_listaHospitaisMouseClicked

    private void ButtEditHospMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtEditHospMouseClicked
        txtNome.setEditable(true);
        txtCodigo.setEditable(true);
        txtLocalidade.setEditable(true);
        codOriginal = txtCodigo.getText();
        nomeOriginal = txtNome.getText();
        localidadeOriginal = txtLocalidade.getText();
        ButtVoltar.setVisible(true);
        
    }//GEN-LAST:event_ButtEditHospMouseClicked

    private void ButtGuardarDadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtGuardarDadosMouseClicked
        //guardar dados do hospital
        removerElementosLista();
        String nomeHosp = txtNome.getText();
        String codigoHosp = txtCodigo.getText();
        String localidadeHosp = txtLocalidade.getText();
        
        if(!sistema.getListaHospital().existeCodHospital(codOriginal)){
            JOptionPane.showMessageDialog(null, "O código original não existe", "ERRO", JOptionPane.ERROR_MESSAGE);
        
        }else if((sistema.getListaHospital().existeCodHospital(codigoHosp))){
            JOptionPane.showMessageDialog(null, "Não pode introduzir um código que já existe", "ERRO", JOptionPane.ERROR_MESSAGE);
            
        }else {sistema.getListaHospital().getCodHospital(codOriginal).setCodigo(codigoHosp); 

        }
        if(!sistema.getListaHospital().existeNomeHospital(nomeOriginal)){
            JOptionPane.showMessageDialog(null, "O nome original não existe", "ERRO", JOptionPane.ERROR_MESSAGE);
            
        }else if((sistema.getListaHospital().existeNomeHospital(nomeHosp))){
            JOptionPane.showMessageDialog(null, "Não pode introduzir um nome que já existe", "ERRO", JOptionPane.ERROR_MESSAGE);
        
        }else {sistema.getListaHospital().getNomeHospital(nomeOriginal).setNome(nomeHosp); 
      
        }    
        if(!sistema.getListaHospital().existeLocalidadeHospital(localidadeOriginal)){
            JOptionPane.showMessageDialog(null, "A localidade original não existe", "ERRO", JOptionPane.ERROR_MESSAGE);
        
        }else {sistema.getListaHospital().getLocHospital(localidadeOriginal).setLocalidade(localidadeHosp); 
        }
        serializacao.guardar(sistema);
        sistema.getListaHospital().ordenacaoHospitais();
        atualizarLista();
    }//GEN-LAST:event_ButtGuardarDadosMouseClicked

    private void ButtRemoverHospMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtRemoverHospMouseClicked
        
        //remover hospital 
        removerElementosLista();
        if(sistema.getListaHospital().existeNomeHospital(txtNome.getText())){
                sistema.getListaHospital().removerHospital(sistema.getListaHospital().getNomeHospital(txtNome.getText()));
                serializacao.guardar(sistema);
        }else{
            JOptionPane.showMessageDialog(null, "O hospital não existe", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        sistema.getListaHospital().ordenacaoHospitais();
        atualizarLista();
        
    }//GEN-LAST:event_ButtRemoverHospMouseClicked

    private void ButtVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtVoltarMouseClicked
        PainelAdd.setVisible(true);
        PainelAddHosp.setVisible(false);
        PainelButtListas.setVisible(false);
        PainelCriarHosp.setVisible(false);
        PainelEditRemov.setVisible(false);
        PainelGuardarDados.setVisible(false);
        ButtVoltar.setVisible(false);
        
        
    }//GEN-LAST:event_ButtVoltarMouseClicked

    private void ButtEquipamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtEquipamentoMouseClicked
        //abrir janela equipamentos
        String codigoHosp = txtCodigo.getText();
        String nomeHosp = txtNome.getText();
        Equipamentos equipamentos = new Equipamentos(sistema, serializacao, nomeHosp,codigoHosp);
        equipamentos.setVisible(true);
    }//GEN-LAST:event_ButtEquipamentoMouseClicked

    private void ButtDoenteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtDoenteMouseClicked
        //abrir janela doentes
        String codigoHosp = txtCodigo.getText();
        String nomeHosp = txtNome.getText();
        Doentes doentes = new Doentes(sistema, serializacao, nomeHosp,codigoHosp);
        doentes.setVisible(true);
    }//GEN-LAST:event_ButtDoenteMouseClicked

    private void ButtProfSaudeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtProfSaudeMouseClicked
        //abrir janela profissionais de saude
        String nomeHosp = txtNome.getText();
        ProfissionaisDeSaude prof = new ProfissionaisDeSaude(sistema, serializacao, nomeHosp);
        prof.setVisible(true);
    }//GEN-LAST:event_ButtProfSaudeMouseClicked

    private void ButtDashBoardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtDashBoardMouseClicked
        //abrir dashboard
        String nomeHosp = txtNome.getText();
        DashB dash = new DashB(sistema, serializacao, nomeHosp);
        dash.setVisible(true);
    }//GEN-LAST:event_ButtDashBoardMouseClicked
             
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtAddHosp;
    private javax.swing.JButton ButtCriarHosp;
    private javax.swing.JButton ButtDashBoard;
    private javax.swing.JButton ButtDoente;
    private javax.swing.JButton ButtEditHosp;
    private javax.swing.JButton ButtEnfermaria;
    private javax.swing.JButton ButtEquipamento;
    private javax.swing.JButton ButtGuardarDados;
    private javax.swing.JButton ButtProfSaude;
    private javax.swing.JButton ButtRemoverHosp;
    private javax.swing.JButton ButtVoltar;
    private javax.swing.JPanel PainelAdd;
    private javax.swing.JPanel PainelAddHosp;
    private javax.swing.JPanel PainelButtListas;
    private javax.swing.JPanel PainelCriarHosp;
    private javax.swing.JPanel PainelEditRemov;
    private javax.swing.JPanel PainelGuardarDados;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listaHospitais;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtLocalidade;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}

        
        
        
