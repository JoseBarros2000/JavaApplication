package BackEnd;

import java.io.Serializable;
import java.util.Comparator;

/*import java.util.ArrayList;*/

public class Utilizador implements Serializable{
    //Variaveis de instancia
    private String nomeUtilizador;
    private String password;
    
    //Construtor
    public Utilizador (String nomeUtilizador, String password){
        this.nomeUtilizador=nomeUtilizador;
        this.password=password;
    }
    
    //Modificador
    public void setNomeUtilizador(String nomeUtilizador) {
        this.nomeUtilizador = nomeUtilizador;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    //Seletores
    public String getNomeUtilizador() {
        return nomeUtilizador;
    }
    public String getPassword() {
        return password;
    }
    public String getNomeUtilizadorByIndex() {
        return nomeUtilizador;
    }
        
    //toString
    @Override
    public String toString(){
        String s = "Utilizador:"+nomeUtilizador+"| Password:"+password+"\n";
        return s;
    }
}
