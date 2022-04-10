package BackEnd;

import BackEnd.Hospital;
import Ordenacao.OrdenarEnfermeiros;
import Ordenacao.OrdenarHospitais;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class ListaHospital implements Serializable{
    //Variaveis de instância
    private ArrayList<Hospital> listaHospital;
    
    //Construtores
    public ListaHospital(){
        listaHospital = new ArrayList<Hospital>();
    }
    
    //Modificadores
    //Criar um novo hospital
    public void criarNovoHosp(Hospital h){
        listaHospital.add(h);
    }
    //Apagar hospital
    public void setApagarHosp (String hospital){
        boolean flag = false;
        for(Hospital h: listaHospital){
            if(h.getNome().equals(hospital)){
                listaHospital.remove(h);
                flag = true;
                return;
            }
            if(flag==false){
            throw new RuntimeException("Este hospital não existe");
            }
        }
    }
    
    public Hospital getCodHospital(String codigoHospital){
        for (Hospital h : this.listaHospital){
            if (h.getCodigo().equals(codigoHospital)){
                return h;
            }
        }
        throw new RuntimeException("Dados não encontrados");
    }
    
    public Hospital getNomeHospital (String nomeHospital){
        for (Hospital h : this.listaHospital){
            if(h.getNome().equals(nomeHospital)){
                return h;
            }
        }
        throw new RuntimeException("Dados não encontrados");
    }
    
    public Hospital getLocHospital (String localidadeHospital){
        for (Hospital h : this.listaHospital){
            if(h.getLocalidade().equals(localidadeHospital)){
                return h;
            }
        }
        throw new RuntimeException ("Dados não Encontrados");
    }
    
    public boolean existeCodHospital(String codigoHospital){
        for (Hospital h : this.listaHospital){
            if(h.getCodigo().equals(codigoHospital)){
                return true;
            }
        }
        return false;
    }
    
   public boolean existeNomeHospital (String nomeHospital){
       for(Hospital h: listaHospital){
           if(h.getNome().equals(nomeHospital)){
               return true;
           }
       }
       return false;
   }
   
   public boolean existeLocalidadeHospital (String localidadeHospital){
       for(Hospital h : listaHospital){
           if(h.getLocalidade().equals(localidadeHospital)){
               return true;
           }
       }
       return false;
   }
   
    public void removerHospital(Hospital e) {
        listaHospital.remove(e);
    }
   
    //Seletores
    public ArrayList<Hospital> getHosp() {
        return listaHospital;
    }
    public int sizeListaHospital(){
        return listaHospital.size();
    }
    public Hospital getHospitalByIndex(int i){
        return this.listaHospital.get(i);
    }
    public ArrayList<Hospital> ordenacaoHospitais(){
        OrdenarHospitais ordenarCodigoHospital = new OrdenarHospitais();
        Collections.sort(listaHospital, ordenarCodigoHospital);
        return listaHospital;
    }
}

