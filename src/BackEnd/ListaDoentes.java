package BackEnd;

import BackEnd.Doente;
import Ordenacao.OrdenarDoentes;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class ListaDoentes implements Serializable{
    //Variaveis de instância
    private ArrayList<Doente> listaDoente;
    
    //Construtores
    public ListaDoentes(){
        this.listaDoente = new ArrayList<Doente>();
    }
    
    //Modificadores
    public void setCriarNovoDoen(Doente d){    //Criar um novo doente
        listaDoente.add(d);
    }
    public void setApagarDoen (String doente){  //Apagar um doente
        boolean flag = false;
        for(Doente d: listaDoente){
            if(d.getNome().equals(doente)){
                listaDoente.remove(d);
                flag=true;
                return;
                }
            }
        if(flag==false){
        throw new RuntimeException("Este utilizador nao existe");
        }
    }
    public void removerDoente(Doente d) {
        listaDoente.remove(d);
    }
    //Verificar existencia de um doente
    public boolean existe(String doente){
        for(Doente d: listaDoente){
            if(d.getCodigoDoen().equals(doente)){
                return true;
            }
        }
        return false;
    }
    //Seletores
    public ArrayList<Doente> getListaDoentes(){
        return listaDoente;
    }
    //Ir buscar um doente da lista
    public Doente getDoente(String codigo){
        for (Doente d : listaDoente){
            if (d.getCodigoDoen().equals(codigo)){
                return d;
            }
        }
        throw new RuntimeException("Dados nao encontrados");
    }
    //toString
    public String toString(){
        String s = "Doentes presentes no sistema:\n";
        for ( Doente d : listaDoente){
            s += d.toString();
        }
        return s;
    }
     public int sizeDoentes(){
        return listaDoente.size();
    }
     public Doente getDoentesByIndex(int i){
        return this.listaDoente.get(i);
    }
     public ListaDoentes ordenacaoDoentes(){
         OrdenarDoentes ordenarCodDoente = new OrdenarDoentes();
        Collections.sort(listaDoente, ordenarCodDoente);
        return this;
    }
}
