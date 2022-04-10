
package FrontEnd;

import BackEnd.Sistema;
import Serializacao.Serializacao;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;


public class JanelaAdmin extends javax.swing.JFrame {

    private Sistema sistema;
    private Serializacao serializacao;
    private boolean foiClicado = false;
    //private boolean foiClicadoHosp = false;
    JFrame frame;
    
    public JanelaAdmin(final Sistema sistema, Serializacao serializacao) {
        initComponents();
        
        this.sistema = sistema;
        this.serializacao = serializacao;
        
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        
        setBounds(400,100,500,500);
        setSize(915,535);
        setLocationRelativeTo(null);
        setResizable(false);

        desktopAdmin.setVisible(false);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        desktopAdmin = new javax.swing.JDesktopPane();
        btnSair = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        btnUtilizadores = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        desktopAdmin.setLayout(new java.awt.CardLayout());
        jPanel1.add(desktopAdmin);
        desktopAdmin.setBounds(350, 40, 510, 420);

        btnSair.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 18)); // NOI18N
        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_exit_sign_40px.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSairMouseClicked(evt);
            }
        });
        jPanel1.add(btnSair);
        btnSair.setBounds(180, 430, 140, 60);

        btnLogout.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 18)); // NOI18N
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_exit_40px.png"))); // NOI18N
        btnLogout.setText("Logout");
        btnLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogoutMouseClicked(evt);
            }
        });
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogout);
        btnLogout.setBounds(10, 430, 150, 60);

        btnUtilizadores.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 18)); // NOI18N
        btnUtilizadores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_user_groups_40px_2.png"))); // NOI18N
        btnUtilizadores.setText("Utilizadores");
        btnUtilizadores.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnUtilizadores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUtilizadores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUtilizadoresMouseClicked(evt);
            }
        });
        jPanel1.add(btnUtilizadores);
        btnUtilizadores.setBounds(30, 190, 230, 60);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Administrador");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(-20, 50, 290, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/caduceus-medical-symbol-abstract-geometric-with-medicine-science-concept-background_41814-395.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 900, 500);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 900, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUtilizadoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUtilizadoresMouseClicked
        
        //abrir janela utilizadores
        if(foiClicado==false){
            CriarUtilizadores criarUtilizadores = new CriarUtilizadores(sistema, serializacao);
            desktopAdmin.add(criarUtilizadores);
            desktopAdmin.setVisible(true);
            criarUtilizadores.setVisible(true);
            criarUtilizadores.setClosable(false);

            ((BasicInternalFrameUI)criarUtilizadores.getUI()).setNorthPane(null); //retirar o painel superior 
            criarUtilizadores.setBorder(null);//retirar bordas
            //foiClicadoHosp=false;
        }
        else{
            desktopAdmin.setVisible(false);
            
            
            CriarUtilizadores criarUtilizadores = new CriarUtilizadores(sistema, serializacao);
            criarUtilizadores.setVisible(true);
//            Utilizadores utili = new Utilizadores(sistema);
//            utili.setVisible(false);
        }
        foiClicado = !foiClicado;
    }//GEN-LAST:event_btnUtilizadoresMouseClicked

    private void btnLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseClicked
        
        //da logout
        LoginPage login = new LoginPage(sistema, serializacao);
        login.setVisible(true);

        JanelaAdmin admin = new JanelaAdmin(sistema, serializacao);
        admin.setVisible(false);

        dispose();
    }//GEN-LAST:event_btnLogoutMouseClicked

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSairMouseClicked
       //termina o sistema
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
    private javax.swing.JButton btnUtilizadores;
    private javax.swing.JDesktopPane desktopAdmin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
