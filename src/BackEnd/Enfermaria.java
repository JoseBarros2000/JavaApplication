package BackEnd;

import Exceptions.CamasIndisponiveis;
import java.io.Serializable;
import java.util.ArrayList;

public class Enfermaria implements Serializable{
    //variaveis de instancia
    private String codigoEnf;
    private String tipoEnf;
    private int camas;
    private ArrayList<String> listaCamas;
    private ArrayList<String> listaCamasOcupadas;
    private ArrayList<String> listaCamasDesocupadas;
    
    //Construtores
    public Enfermaria(String codigoEnf, String tipoEnf, int camas) {
        this.codigoEnf = codigoEnf;
        this.tipoEnf = tipoEnf;
        this.camas=camas;
        this.listaCamas=new ArrayList<String>();
        this.listaCamasDesocupadas=new ArrayList<String>();
        this.listaCamasOcupadas=new ArrayList<String>();
    }

    //Modificadores
    //Alterar o numero de camas
    public void defenirCamas(){
        for(int i=0; i<camas;i++){
            String s = String.valueOf(i+1);
            listaCamas.add(s);
            listaCamasDesocupadas.add(s);
        }
    }
    public void ocuparCama(String numeroCama) throws CamasIndisponiveis{
        if(listaCamasDesocupadas.size()<=0){
            throw new CamasIndisponiveis("Não existem camas disponiveis");
        }else{
            for(int n=0; n<listaCamasDesocupadas.size(); n++){
                if(String.valueOf(n+1).equals(numeroCama)){
                    listaCamasOcupadas.add(numeroCama);
                    listaCamasDesocupadas.remove(numeroCama);
                    return;
                }
            }
        }
    }
    public void desocuparCama(String numeroCama) throws CamasIndisponiveis{
        if(listaCamasDesocupadas.size() >= listaCamas.size()){
            throw new CamasIndisponiveis("Não existem mais camas para serem desocupadas");
        }else{
            for(int n=0; n<listaCamasOcupadas.size(); n++){
                if(String.valueOf(n+1).equals(numeroCama)){
                    listaCamasDesocupadas.add(numeroCama);
                    listaCamasOcupadas.remove(numeroCama);
                    return;
                }
            }
        }
    }
    public boolean existemCamasDisponiveis(){
       if(listaCamasDesocupadas.size()!=0){
           return true;
       }else{
           return false;
       }
    }

    public void setCodigoEnf(String codigoEnf) {
        this.codigoEnf = codigoEnf;
    }
    public void setTipoEnf(String tipoEnf) {
        this.tipoEnf = tipoEnf;
    }
    public void setListaCamas(ArrayList<String> listaCamas) {
        this.listaCamas = listaCamas;
    }
    public void setListaCamasOcupadas(ArrayList<String> listaCamasOcupadas) {
        this.listaCamasOcupadas = listaCamasOcupadas;
    }
    public void setListaCamasDesocupadas(ArrayList<String> listaCamasDesocupadas) {
        this.listaCamasDesocupadas = listaCamasDesocupadas;
    }
    public void setCamas(int camas) {
        this.camas = camas;
    }
    //Seletores

    public String getCodigoEnf() {
        return codigoEnf;
    }
    public String getTipoEnf() {
        return tipoEnf;
    }
    public ArrayList<String> getListaCamas() {
        return listaCamas;
    }
    public ArrayList<String> getListaCamasOcupadas() {
        return listaCamasOcupadas;
    }
    public ArrayList<String> getListaCamasDesocupadas() {
        return listaCamasDesocupadas;
    }
    public int getCamas() {
        return camas;
    }
    
    public int sizeCamasDesocupadas(){
        return listaCamasDesocupadas.size();
    }
    public String getCamasDesocupadasByIndex(int i){
        return this.listaCamasDesocupadas.get(i);
    }
    
    //toString
    @Override
    public String toString(){
        String s = "Codigo da enfermaria:"+getCodigoEnf()+" Tipo de enfermaria:"+getTipoEnf()+" Lista de camas"+getListaCamas()+" Lista de camas ocupadas:"+getListaCamasOcupadas()+" Lista de camas desocupadas:"+getListaCamasDesocupadas();
        return s;
    }
}
