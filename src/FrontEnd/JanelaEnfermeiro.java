
package FrontEnd;

import BackEnd.Enfermaria;
import BackEnd.Enfermeiro;
import BackEnd.Hospital;
import BackEnd.Sistema;
import Serializacao.Serializacao;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class JanelaEnfermeiro extends javax.swing.JFrame {

    
   private Sistema sistema;
   private Serializacao serializacao;
   private Enfermeiro enfermeiro;
   private Hospital hospital;
   private Enfermaria enfermaria;
   private boolean foiClicado = false;
   private boolean foiClicadoEnf = false;

    
    
    public JanelaEnfermeiro(Sistema sistema, Serializacao serializacao) {
      initComponents();
        
        this.sistema = sistema;
        this.serializacao = serializacao;
        this.enfermeiro = enfermeiro;
        this.hospital = hospital;
        this.enfermaria = enfermaria;
    
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        
        setBounds(400,100,500,500);
        setSize(915,535);
        setLocationRelativeTo(null);
        setResizable(false);

        desktopEnfermeiro.setVisible(false);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLogout = new javax.swing.JButton();
        butDadosPessoais = new javax.swing.JButton();
        butListaDeEnfermarias = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        desktopEnfermeiro = new javax.swing.JDesktopPane();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        btnLogout.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 18)); // NOI18N
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_exit_40px.png"))); // NOI18N
        btnLogout.setText("Logout");
        btnLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogoutMouseClicked(evt);
            }
        });
        getContentPane().add(btnLogout);
        btnLogout.setBounds(20, 410, 150, 60);

        butDadosPessoais.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 14)); // NOI18N
        butDadosPessoais.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_resume_40px.png"))); // NOI18N
        butDadosPessoais.setText("Dados Pessoais");
        butDadosPessoais.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butDadosPessoaisMouseClicked(evt);
            }
        });
        getContentPane().add(butDadosPessoais);
        butDadosPessoais.setBounds(30, 180, 260, 49);

        butListaDeEnfermarias.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 14)); // NOI18N
        butListaDeEnfermarias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_nurse_call_40px.png"))); // NOI18N
        butListaDeEnfermarias.setText("Lista de Enfermarias");
        butListaDeEnfermarias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butListaDeEnfermariasMouseClicked(evt);
            }
        });
        getContentPane().add(butListaDeEnfermarias);
        butListaDeEnfermarias.setBounds(30, 240, 260, 54);

        btnSair.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 18)); // NOI18N
        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_exit_sign_40px.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSairMouseClicked(evt);
            }
        });
        getContentPane().add(btnSair);
        btnSair.setBounds(180, 410, 140, 60);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Enfermeiro");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 50, 260, 50);

        javax.swing.GroupLayout desktopEnfermeiroLayout = new javax.swing.GroupLayout(desktopEnfermeiro);
        desktopEnfermeiro.setLayout(desktopEnfermeiroLayout);
        desktopEnfermeiroLayout.setHorizontalGroup(
            desktopEnfermeiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        desktopEnfermeiroLayout.setVerticalGroup(
            desktopEnfermeiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        getContentPane().add(desktopEnfermeiro);
        desktopEnfermeiro.setBounds(360, 50, 500, 400);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/caduceus-medical-symbol-abstract-geometric-with-medicine-science-concept-background_41814-395.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, -10, 900, 520);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butDadosPessoaisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butDadosPessoaisMouseClicked
        //abrir dados pessoais do enfermeiro
        if(foiClicado == false){
            DadosPessoaisEnfermeiro dados = new DadosPessoaisEnfermeiro(sistema, sistema.getEnfermeiroLigado(), sistema.getEnfermeiroLigado().getHospitalOndeTrabalha(), serializacao);
            desktopEnfermeiro.add(dados);
            desktopEnfermeiro.setVisible(true);
            dados.setVisible(true);
            dados.setClosable(false);

            ((BasicInternalFrameUI)dados.getUI()).setNorthPane(null);
            dados.setBorder(null);
            foiClicadoEnf = false;
        }else{
            desktopEnfermeiro.setVisible(false);
            DadosPessoaisEnfermeiro dados = new DadosPessoaisEnfermeiro(sistema, sistema.getEnfermeiroLigado(), sistema.getEnfermeiroLigado().getHospitalOndeTrabalha(), serializacao);
            dados.setVisible(false);
        }
        foiClicado = !foiClicado;
    }//GEN-LAST:event_butDadosPessoaisMouseClicked

    private void butListaDeEnfermariasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butListaDeEnfermariasMouseClicked
       //abrir lista de enfermarias
        if(foiClicado == false){
            ListaEnfermarias listaenf = new ListaEnfermarias(sistema, serializacao, enfermaria);
            desktopEnfermeiro.add(listaenf);
            desktopEnfermeiro.setVisible(true);
            listaenf.setVisible(true);
            listaenf.setClosable(false);

            ((BasicInternalFrameUI)listaenf.getUI()).setNorthPane(null);
            listaenf.setBorder(null);
            foiClicadoEnf = false;
        }else{
            desktopEnfermeiro.setVisible(false);
            ListaEnfermarias listaenf = new ListaEnfermarias(sistema, serializacao, enfermaria);
            listaenf.setVisible(false);
        }
        foiClicado = !foiClicado;
    }//GEN-LAST:event_butListaDeEnfermariasMouseClicked

    private void btnLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseClicked
      //dar logout
        LoginPage login = new LoginPage(sistema, serializacao);
        login.setVisible(true);

        JanelaEnfermeiro enf = new JanelaEnfermeiro(sistema, serializacao);
        enf.setVisible(false);

        dispose();
    }//GEN-LAST:event_btnLogoutMouseClicked

    private void btnSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSairMouseClicked
        //terminar sistema
        JFrame frame = new JFrame();
        int result = JOptionPane.showConfirmDialog(frame, "Pretende sair?", "Confirme a decisão: ", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION){
            sistema.terminar();
        }else 
            if(result == JOptionPane.NO_OPTION)
                frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }//GEN-LAST:event_btnSairMouseClicked

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton butDadosPessoais;
    private javax.swing.JButton butListaDeEnfermarias;
    private javax.swing.JDesktopPane desktopEnfermeiro;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
