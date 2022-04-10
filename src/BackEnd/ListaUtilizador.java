package BackEnd;

import BackEnd.Utilizador;
import Ordenacao.OrdenarNomeUtilizador;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class ListaUtilizador implements Serializable{
    //Variavel de  instancia
    private ArrayList<Utilizador> listaUti;
    
    //Construtor
    public ListaUtilizador(){
	listaUti = new ArrayList<Utilizador>();
    }
    
    //Verificar a existencia de um utilizador
    public boolean existe(String utilizador){
        for(Utilizador u: listaUti){
            if(u.getNomeUtilizador().equals(utilizador)){
                return true;
            }
        }
        return false;
    }
    
    //Criar um novo utilizador   Admin -> Criar um novo utilizador
    public void criarNovoUti(Utilizador u){
        if (existe(u.getNomeUtilizador()))
            throw new RuntimeException("Este utilizador ja existe");
        listaUti.add(u);
    }
    
    //Apagar utilizador
    public void setApagarUti (String utilizador){ //Ver se fica melhor so o nomeUtilizador
        boolean flag = false;
        for(Utilizador u: listaUti){
                if(u.getNomeUtilizador().equals(utilizador)){
                    listaUti.remove(u);
                    flag=true;
                    return;
                }
            }
        if(flag==false){
        throw new RuntimeException("Este utilizador nao existe");
        }
    }
    public void removerUtilizador(Utilizador utilizador) {
        listaUti.remove(utilizador);
    }
    
    //Verificar dados introduzidos
    public boolean verificarNomeUtilizadorUti(String nomeUtilizador, String password) { //Verificar o username do utilizador
        for (Utilizador u : this.listaUti) {
            if(u instanceof Utilizador){
                if (u.getNomeUtilizador().equals(nomeUtilizador)) {
                    if (u.getPassword().equals(password)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    //Ir buscar um utilizador da lista
    public Utilizador getUtilizador(String username){
        for (Utilizador u : this.listaUti){
            if (u.getNomeUtilizador().equals(username)){
                return u;
            }
        }
        throw new RuntimeException("Dados nao encontrados");
    }
    
    
    //Devolve a lista de utilizadores
    public ArrayList<Utilizador> getListaUtilizador(){
        return listaUti;
    }
    public ListaUtilizador ordenacaoUtilizadores(){
       OrdenarNomeUtilizador ordenarNomeUtilizador = new OrdenarNomeUtilizador();
       Collections.sort(listaUti, ordenarNomeUtilizador);
       return this;
    }
    public Utilizador getUtilizadorByIndex(int i){
        return this.listaUti.get(i);
    }
    public int sizeUtilizador(){
        return listaUti.size();
    }
    
    //toString   ADMIN -> LISTAR TODOS OS UTILIZADORES
    @Override
    public String toString(){
        String s = "Os utilizadores presentes no sistema são os seguintes: \n";
        for ( Utilizador u : listaUti){
            s += u.toString();
        }
        return s;
    }
    
}
