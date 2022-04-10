package BackEnd;




public class Adminstrador extends Utilizador {
    
    public Adminstrador(String nomeUtilizador, String password) {
        super(nomeUtilizador, password);
    }
    
    
    
    //toString
    @Override
    public String toString(){
        String s= "Logou-se como adminstrador.";
        return s;
    }
}
