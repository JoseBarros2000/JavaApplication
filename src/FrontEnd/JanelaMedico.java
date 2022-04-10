
package FrontEnd;

import BackEnd.Medico;
import BackEnd.Sistema;
import FrontEnd.ListaDoentes;
import Serializacao.Serializacao;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;


public class JanelaMedico extends javax.swing.JFrame {

    private Sistema sistema;
    private Serializacao serializacao;
    private boolean foiClicado = false;
    private boolean foiClicadoMed = false;
    
    JFrame frame;
    
    public JanelaMedico(final Sistema sistema, Serializacao serializacao) {
        initComponents();
        
        this.sistema = sistema;
        this.serializacao = serializacao;
        
        setBounds(400,100,500,500);
        setSize(915,535);
        setLocationRelativeTo(null);
        setResizable(false);

        desktopMedico.setVisible(false);
        
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        
        System.out.println(sistema.getMedicoLigado().getHospitalOndeTrabalha());
         System.out.println("123");
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        desktopMedico = new javax.swing.JDesktopPane();
        btnDadosPessoais = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        butDoentes = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        desktopMedico.setLayout(new java.awt.CardLayout());
        jPanel1.add(desktopMedico);
        desktopMedico.setBounds(350, 40, 510, 420);

        btnDadosPessoais.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 18)); // NOI18N
        btnDadosPessoais.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_resume_40px.png"))); // NOI18N
        btnDadosPessoais.setText("Dados Pessoais");
        btnDadosPessoais.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDadosPessoaisMouseClicked(evt);
            }
        });
        jPanel1.add(btnDadosPessoais);
        btnDadosPessoais.setBounds(30, 180, 240, 60);

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

        butDoentes.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 18)); // NOI18N
        butDoentes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_list_40px.png"))); // NOI18N
        butDoentes.setText("Lista Doentes");
        butDoentes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butDoentesMouseClicked(evt);
            }
        });
        jPanel1.add(butDoentes);
        butDoentes.setBounds(30, 250, 240, 60);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Médico");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(-20, 50, 290, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/caduceus-medical-symbol-abstract-geometric-with-medicine-science-concept-background_41814-395.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 900, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 899, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butDoentesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butDoentesMouseClicked
        //abre os doentes do medico
        if(foiClicado==false){
            ListaDoentes doentes = new ListaDoentes(sistema, serializacao);
            desktopMedico.add(doentes);
            desktopMedico.setVisible(true);
            doentes.setVisible(true);
            doentes.setClosable(false);

            ((BasicInternalFrameUI)doentes.getUI()).setNorthPane(null); //retirar o painel superior
            doentes.setBorder(null);//retirar bordas
            foiClicadoMed = false;
        }
        else{
            desktopMedico.setVisible(false);
           ListaDoentes doentes = new ListaDoentes(sistema,serializacao);
            doentes.setVisible(false);
        }
        foiClicado = !foiClicado;
    }//GEN-LAST:event_butDoentesMouseClicked

    private void btnLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseClicked
        //dar logout
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
        //terminar sistema
        JFrame frame = new JFrame();
        int result = JOptionPane.showConfirmDialog(frame, "Pretende sair?", "Confirme a decisão: ", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION){
            sistema.terminar();
        }else 
            if(result == JOptionPane.NO_OPTION)
                frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }//GEN-LAST:event_btnSairMouseClicked

    private void btnDadosPessoaisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDadosPessoaisMouseClicked
        //abrir dados pessoais
        if(foiClicado == false){
            DadosPessoaisMedico dados = new DadosPessoaisMedico(sistema,serializacao);
            desktopMedico.add(dados);
            desktopMedico.setVisible(true);
            dados.setVisible(true);
            dados.setClosable(false);

            ((BasicInternalFrameUI)dados.getUI()).setNorthPane(null);
            dados.setBorder(null);
            foiClicadoMed = false;
        }else{
            desktopMedico.setVisible(false);
            DadosPessoaisMedico dados = new DadosPessoaisMedico(sistema, serializacao);
            dados.setVisible(false);
        }
        foiClicado = !foiClicado;
    }//GEN-LAST:event_btnDadosPessoaisMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDadosPessoais;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton butDoentes;
    private javax.swing.JDesktopPane desktopMedico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
