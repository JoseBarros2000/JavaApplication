package BackEnd;

import BackEnd.Equipamento;
import FrontEnd.Equipamentos;
import Ordenacao.OrdenarEquipamentos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class ListaEquipamentos implements Serializable{
    
    //Variaveis de Instancia
    private ArrayList<Equipamento> listaEquipamentos;
    
    //Construtor
    public ListaEquipamentos(){
        listaEquipamentos = new ArrayList<Equipamento>();
    }
    
    //Modificador
    //Adicionar novo equipamento
    public void addEquipamento (Equipamento e){
        listaEquipamentos.add(e);
    }
    
    public void setRemoverEquipamento (String codigoEqui){
        boolean flag = false;
        for (Equipamento e : listaEquipamentos){
            if(e.getCodigoEqui().equals(codigoEqui)){
                listaEquipamentos.remove(e);         
                flag=true;
                return;
            }
            if(flag==false){
            throw new RuntimeException("Este equipamento nao existe");
            }
        }
    }
    public boolean existe(String codigoEquip){
        for(Equipamento e: listaEquipamentos){
            if(e.getCodigoEqui().equals(codigoEquip)){
                return true;
            }
        }
        return false;
    }
    
    //Seletores
     public ArrayList getListaEquipamentos(){
        return listaEquipamentos;
    }
    public int sizeEquipamento(){
        return listaEquipamentos.size();
    }
    public Equipamento getEquipamentosByIndex(int i){
        return this.listaEquipamentos.get(i);
    }
    public ListaEquipamentos ordenacaoEquipamentos(){
        OrdenarEquipamentos ordenarCodEquipamentos = new OrdenarEquipamentos();
        Collections.sort(listaEquipamentos, ordenarCodEquipamentos);
        return this;
    }  
}