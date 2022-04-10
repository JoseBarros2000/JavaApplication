package FrontEnd;

import BackEnd.Sistema;
import Serializacao.Serializacao;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.*;
import java.awt.*;
import static java.time.Clock.system;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class PaginaUtilizador extends javax.swing.JFrame {
    
    private Sistema sistema;
    private Serializacao serializacao;
    private boolean foiClicado = false;
    private boolean foiClicadoHosp = false;
    JFrame frame;
       
    public PaginaUtilizador( Sistema sistema, Serializacao serializacao) {
        initComponents();
        this.sistema = sistema;
        this.serializacao = serializacao;
        
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        setBounds(400,100,500,500);
        setSize(915,535);
        setLocationRelativeTo(null);
        setResizable(false);

        desktop.setVisible(false);
        
    }
    private void guardarAlteracoes() {
        serializacao.guardar(sistema);
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jMenu1 = new javax.swing.JMenu();
        jPanel4 = new javax.swing.JPanel();
        desktop = new javax.swing.JDesktopPane();
        btnSair = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        btnHospitais = new javax.swing.JButton();
        btnPerfil = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel1.setText("jLabel1");

        jTextField1.setText("jTextField1");

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel4.setLayout(null);

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );

        jPanel4.add(desktop);
        desktop.setBounds(350, 40, 510, 420);

        btnSair.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 18)); // NOI18N
        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_exit_sign_40px.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSairMouseClicked(evt);
            }
        });
        jPanel4.add(btnSair);
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
        jPanel4.add(btnLogout);
        btnLogout.setBounds(10, 430, 150, 60);

        btnHospitais.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 24)); // NOI18N
        btnHospitais.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_hospital_sign_40px.png"))); // NOI18N
        btnHospitais.setText("Hospitais");
        btnHospitais.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnHospitais.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHospitais.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHospitaisMouseClicked(evt);
            }
        });
        jPanel4.add(btnHospitais);
        btnHospitais.setBounds(50, 250, 210, 60);

        btnPerfil.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 18)); // NOI18N
        btnPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_profiles_40px.png"))); // NOI18N
        btnPerfil.setText("Dados Pessoais");
        btnPerfil.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnPerfil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPerfilMouseClicked(evt);
            }
        });
        jPanel4.add(btnPerfil);
        btnPerfil.setBounds(50, 180, 210, 60);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Utilizador");
        jPanel4.add(jLabel4);
        jLabel4.setBounds(0, 50, 260, 50);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/caduceus-medical-symbol-abstract-geometric-with-medicine-science-concept-background_41814-395.png"))); // NOI18N
        jPanel4.add(jLabel2);
        jLabel2.setBounds(0, -20, 920, 540);

        getContentPane().add(jPanel4);
        jPanel4.setBounds(0, 0, 900, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPerfilMouseClicked
        //abrir perfil do uti
        if(foiClicado==false){
            PerfilPage perfil = new PerfilPage(sistema,serializacao, sistema.getUtilizadorLigado());
            desktop.add(perfil);
            desktop.setVisible(true);
            perfil.setVisible(true);
            perfil.setClosable(false);

            ((BasicInternalFrameUI)perfil.getUI()).setNorthPane(null); //retirar o painel superior 
            perfil.setBorder(null);//retirar bordas
            foiClicadoHosp=false;
        }
        else{
            desktop.setVisible(false);
            PerfilPage perfil = new PerfilPage(sistema,serializacao, sistema.getUtilizadorLigado());
            perfil.setVisible(false);
        }
        foiClicado = !foiClicado;
    }//GEN-LAST:event_btnPerfilMouseClicked

    private void btnHospitaisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHospitaisMouseClicked
        //abrir hospitais
        if(foiClicadoHosp==false){
            Hospitais hospitais = new Hospitais(sistema, serializacao);
            desktop.add(hospitais);
            desktop.setVisible(true);
            hospitais.setVisible(true);
            hospitais.setClosable(false);

            ((BasicInternalFrameUI)hospitais.getUI()).setNorthPane(null); //retirar o painel superior da internal frame
            hospitais.setBorder(null);//retirar bordas da internal frame
        
        
            foiClicado=false;
        }
        else{
            desktop.setVisible(false);
            PerfilPage perfil = new PerfilPage(sistema,serializacao, sistema.getUtilizadorLigado());
            perfil.setVisible(false);
        }
        foiClicadoHosp = !foiClicadoHosp;
    }//GEN-LAST:event_btnHospitaisMouseClicked

    private void btnLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseClicked
        //dar logout
        LoginPage login = new LoginPage(sistema, serializacao);    
        login.setVisible(true);
        
        PaginaUtilizador paguti = new PaginaUtilizador(sistema, serializacao);
        paguti.setVisible(false);
        
        dispose();
    }//GEN-LAST:event_btnLogoutMouseClicked

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLogoutActionPerformed

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

    public void removeJPanel (JPanel pPanel) {

            getRootPane().remove(pPanel);
            getRootPane().revalidate();
            getRootPane().repaint();

}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHospitais;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnPerfil;
    private javax.swing.JButton btnSair;
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
