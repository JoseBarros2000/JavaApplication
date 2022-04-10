package Exceptions;

public class CamasIndisponiveis extends Exception {
    public CamasIndisponiveis(){
        super ("Não existem camas disponiveis");
    }
    public CamasIndisponiveis(String msg){
        super(msg); 
    }
}
