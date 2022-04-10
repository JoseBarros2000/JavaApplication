package FrontEnd;

import BackEnd.Sistema;
import BackEnd.Utilizador;
import Serializacao.Serializacao;
import java.awt.Color;
import java.beans.PropertyVetoException;
import javax.swing.JOptionPane;

public class PerfilPage extends javax.swing.JInternalFrame {

    private Sistema sistema;
    private final Serializacao serializacao;
    private Utilizador utilizador;
    
    
    
    public PerfilPage(Sistema sistema,Serializacao serializacao, Utilizador utilizador) {
        initComponents();
        
        this.sistema=sistema;
        this.serializacao = serializacao;
        this.utilizador=utilizador;
        
        txtUsername.setText(utilizador.getNomeUtilizador());
        
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        
        txtPassword.setText(utilizador.getPassword());
        
        txtUsername.setEditable(false);
        txtPassword.setEditable(false);
        
        butGuardar.setVisible(false);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PasswordLabel = new javax.swing.JLabel();
        UsernameLabel = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        butEditarPassword = new javax.swing.JButton();
        butGuardar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Perfil");
        setPreferredSize(new java.awt.Dimension(510, 420));
        getContentPane().setLayout(null);

        PasswordLabel.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 24)); // NOI18N
        PasswordLabel.setText("Password : ");
        getContentPane().add(PasswordLabel);
        PasswordLabel.setBounds(10, 144, 160, 37);

        UsernameLabel.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 24)); // NOI18N
        UsernameLabel.setText("Username : ");
        getContentPane().add(UsernameLabel);
        UsernameLabel.setBounds(10, 81, 160, 37);

        txtUsername.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtUsername.setText("Username");
        getContentPane().add(txtUsername);
        txtUsername.setBounds(172, 81, 210, 37);

        txtPassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtPassword.setText("Password");
        getContentPane().add(txtPassword);
        txtPassword.setBounds(172, 144, 211, 37);

        butEditarPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_edit_24px_2.png"))); // NOI18N
        butEditarPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butEditarPasswordMouseClicked(evt);
            }
        });
        getContentPane().add(butEditarPassword);
        butEditarPassword.setBounds(417, 144, 54, 37);

        butGuardar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        butGuardar.setText("Guardar");
        butGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(butGuardar);
        butGuardar.setBounds(245, 263, 138, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butGuardarActionPerformed
        //editar dados
        butGuardar.setVisible(false);
        txtUsername.setEditable(false);
        txtPassword.setEditable(false);
        if(txtPassword.getText().length() == 0 || txtPassword.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Não introduziu a password", "ERRO", JOptionPane.ERROR_MESSAGE);
            txtPassword.requestFocus();
            txtPassword.setEditable(true);
            butGuardar.setVisible(true);
        }else{
            utilizador.setPassword(txtPassword.getText());
            butEditarPassword.setVisible(true);
        }
        serializacao.guardar(sistema);
    }//GEN-LAST:event_butGuardarActionPerformed

    private void butEditarPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butEditarPasswordMouseClicked
        txtPassword.setEditable(true);
        butGuardar.setVisible(true);
        txtPassword.setText("");
        txtPassword.requestFocus();
        butEditarPassword.setVisible(false);
    }//GEN-LAST:event_butEditarPasswordMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PasswordLabel;
    private javax.swing.JLabel UsernameLabel;
    private javax.swing.JButton butEditarPassword;
    private javax.swing.JButton butGuardar;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
