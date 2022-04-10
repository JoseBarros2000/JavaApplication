package BackEnd;

import BackEnd.Enfermaria;
import Ordenacao.OrdenarCodigoEnfermaria;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class ListaEnfermarias implements Serializable{
    //Variaveis de instancia
    private ArrayList<Enfermaria> listaEnfermarias;
    
    //Construtores
    public ListaEnfermarias(){
        listaEnfermarias = new ArrayList<Enfermaria> (); //listaef vai ser um array com as enfermarias //listaEnfermarias ou enfermarias
    }
    
    //Modificadores
    public void setAdicionarEnfermaria (Enfermaria enferma){
        listaEnfermarias.add(enferma);
    }
    
    public void setRemoverEnfermaria(String codigoEnf){
        boolean flag = false;
        for (Enfermaria e : listaEnfermarias ){
            if(e.getCodigoEnf().equals(codigoEnf)){
                listaEnfermarias.remove(e);         //Secalhar mudar pra enfer
                flag=true;
                return;
            }
            if(flag==false){
            throw new RuntimeException("Esta enfermaria nao existe");
            }
        }
    }
    public void removerEnfermaria(Enfermaria e) {
        listaEnfermarias.remove(e);
    }
    //Verificar existencia de uma enfermaria
    public boolean existe(String codigoEnf){
        for(Enfermaria e: listaEnfermarias){
            if(e.getCodigoEnf().equals(codigoEnf)){
                return true;
            }
        }
        return false;
    }
    public Enfermaria getEnfermaria(String codigoEnfermaria){
        for (Enfermaria e : this.listaEnfermarias){
            if (e.getCodigoEnf().equals(codigoEnfermaria)){
                return e;
            }
        }
        throw new RuntimeException("Dados nao encontrados");
    }
    
    //Seletores
     public ArrayList getListaEnfermarias(){
        return listaEnfermarias;
    }
    public int sizeEnfermaria(){
        return listaEnfermarias.size();
    }
    public Enfermaria getEnfermariaByIndex(int i){
        return this.listaEnfermarias.get(i);
    }
    public ListaEnfermarias ordenacaoEnfermarias(){
       OrdenarCodigoEnfermaria ordenarCodigoEnfermaria = new OrdenarCodigoEnfermaria();
       Collections.sort(listaEnfermarias, ordenarCodigoEnfermaria);
       return this;
    }    
}