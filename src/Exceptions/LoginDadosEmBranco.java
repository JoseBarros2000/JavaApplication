package Exceptions;

public class LoginDadosEmBranco extends Exception {
    public LoginDadosEmBranco(){
        super ("Dados em branco");
    }
    public LoginDadosEmBranco(String msg){
        super(msg); 
    }
}