package Exceptions;

public class UtilizadorInvalido extends Exception{
    public UtilizadorInvalido(){
        super ("Utilizador Invalido");
    }
    public UtilizadorInvalido(String msg){
        super(msg); 
    }
}
