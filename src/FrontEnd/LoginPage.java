package FrontEnd;

//Imports
import BackEnd.ListaUtilizador;
import BackEnd.Sistema;
import BackEnd.Utilizador;
import BackEnd.Adminstrador;
import Exceptions.LoginDadosEmBranco;
import Exceptions.UtilizadorInvalido;
import Serializacao.Serializacao;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class LoginPage extends JFrame {
    
    //Variaveis de instancia
    private Sistema sistema;
    private Serializacao serializacao;
    JFrame frame;
    
    public LoginPage(Sistema sistema, Serializacao serializacao) {
        initComponents();
        this.sistema=sistema;
        this.serializacao=serializacao;
        
        setBounds(400,100,500,500);
        setSize(675,350);
        setLocationRelativeTo(null);
        setResizable(false);
        
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }

    //AUTENTICAR NO PROGRAMA
        
    private void autenticar(){ //Autenticador
        String nomeUtilizador = textUsername.getText();
        String password = new String(textPassword.getPassword());

        
        try{
             if(nomeUtilizador.equals("admin") && password.equals("admin")){
                JanelaAdmin admin = new JanelaAdmin(sistema, serializacao);
                admin.setLocationRelativeTo(null);
                admin.setVisible(true);
                dispose();
             
             }else
                if(sistema.autenticarMedico(nomeUtilizador, password)){
                    JanelaMedico medico = new JanelaMedico(sistema, serializacao);
                    medico.setLocationRelativeTo(null);
                    medico.setVisible(true);
                    dispose();
                }else
                    if(sistema.autenticarEnfermeiro(nomeUtilizador, password)){
                        JanelaEnfermeiro enfermeiro = new JanelaEnfermeiro(sistema, serializacao);
                        enfermeiro.setLocationRelativeTo(null);
                        enfermeiro.setVisible(true);
                        dispose();
                    }else
                        if(sistema.autenticarUtilizador(nomeUtilizador, password)){
                            PaginaUtilizador paguti = new PaginaUtilizador(sistema, serializacao);
                            paguti.setLocationRelativeTo(null);
                            paguti.setVisible(true);
                            dispose();
                    }
                
                
        }catch(LoginDadosEmBranco | UtilizadorInvalido exc){
            JOptionPane.showMessageDialog(null, exc.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textUsername = new javax.swing.JTextField();
        textPassword = new javax.swing.JPasswordField();
        btnSair = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        btnAutenticar1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel3.setLayout(null);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/medicina-5c499af256d10.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(0, 0, 306, 319);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_password_1_26px.png"))); // NOI18N
        jPanel1.add(jLabel6);
        jLabel6.setBounds(80, 180, 30, 30);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_user_male_26px.png"))); // NOI18N
        jPanel1.add(jLabel5);
        jLabel5.setBounds(80, 120, 30, 30);

        textUsername.setBorder(null);
        textUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textUsernameKeyPressed(evt);
            }
        });
        jPanel1.add(textUsername);
        textUsername.setBounds(110, 120, 198, 30);

        textPassword.setBorder(null);
        textPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textPasswordKeyPressed(evt);
            }
        });
        jPanel1.add(textPassword);
        textPassword.setBounds(110, 180, 198, 30);

        btnSair.setBackground(new java.awt.Color(93, 188, 210));
        btnSair.setFont(new java.awt.Font("Verdana Pro Semibold", 0, 10)); // NOI18N
        btnSair.setText("Cancelar");
        btnSair.setBorder(new javax.swing.border.MatteBorder(null));
        btnSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSairMouseClicked(evt);
            }
        });
        jPanel1.add(btnSair);
        btnSair.setBounds(80, 240, 110, 30);

        jLabel4.setFont(new java.awt.Font("Verdana Pro Semibold", 0, 24)); // NOI18N
        jLabel4.setText("LOGIN");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(130, 40, 130, 30);

        jSeparator1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(110, 150, 200, 10);

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator2);
        jSeparator2.setBounds(110, 210, 200, 10);

        btnAutenticar1.setBackground(new java.awt.Color(93, 188, 210));
        btnAutenticar1.setFont(new java.awt.Font("Verdana Pro Semibold", 0, 10)); // NOI18N
        btnAutenticar1.setText("Autenticar");
        btnAutenticar1.setBorder(new javax.swing.border.MatteBorder(null));
        btnAutenticar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAutenticar1MouseClicked(evt);
            }
        });
        jPanel1.add(btnAutenticar1);
        btnAutenticar1.setBounds(200, 240, 110, 30);

        jPanel3.add(jPanel1);
        jPanel1.setBounds(302, -2, 360, 320);

        jPanel2.setLayout(null);
        jPanel3.add(jPanel2);
        jPanel2.setBounds(310, 0, 0, 0);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 0, 660, 320);

        setBounds(0, 0, 672, 356);
    }// </editor-fold>//GEN-END:initComponents

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

    private void textUsernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textUsernameKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            autenticar();
        }
    }//GEN-LAST:event_textUsernameKeyPressed

    private void textPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textPasswordKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            autenticar();
        }
    }//GEN-LAST:event_textPasswordKeyPressed

    private void btnAutenticar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAutenticar1MouseClicked
        autenticar();
    }//GEN-LAST:event_btnAutenticar1MouseClicked
 
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAutenticar1;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPasswordField textPassword;
    private javax.swing.JTextField textUsername;
    // End of variables declaration//GEN-END:variables
}
