package FrontEnd;

import BackEnd.Sistema;
import Serializacao.Serializacao;
import java.util.Collections;
import javax.swing.JFrame;


public class MainGUI {
    
    public static void main(String args[]){
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
       
        /* Create and display the form */
        
        Sistema sistema;
        String ficheiroDados = String.format("%s\\utilizador.data", System.getProperty("user.dir"));
        Serializacao serializacao = new Serializacao(ficheiroDados);
        
        //Se o ficheiro de base de dados nao existir
        if (!serializacao.getFicheiro().exists()) {
            //Cria uma instancia do sistema
            sistema = new Sistema();      
            
            sistema.inicializar();
        }else{
            sistema = serializacao.carregar();            
        } 
        
        //inicializar janelas
        LoginPage login = new LoginPage(sistema, serializacao);    
        login.setVisible(true);
        
        PaginaUtilizador paguti = new PaginaUtilizador(sistema, serializacao);
        paguti.setVisible(false);
        
        JanelaAdmin admin = new JanelaAdmin(sistema, serializacao);
        admin.setVisible(false);
        

        
    }
}
