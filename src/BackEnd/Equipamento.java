package BackEnd;

import java.io.Serializable;

public class Equipamento implements Serializable{
    //informação sobre os equipamentos
    //variaveis de instancia
    private String codigoEqui;
    private String tipoEqui;
    private Enfermaria enfColocado;
    private String livre;
    private Doente doenteAUsar; //apontador Doente a usar o equipamento

    public Equipamento(String codigoEqui, String tipoEqui, Enfermaria enfColocado, String livre, Doente doenteAUsar) {
        this.codigoEqui = codigoEqui;
        this.tipoEqui = tipoEqui;
        this.enfColocado = enfColocado;
        this.livre = livre;
        this.doenteAUsar = doenteAUsar;
    }
    public Equipamento(String codigoEqui, String tipoEqui, Enfermaria enfColocado, String livre) {
        this.codigoEqui = codigoEqui;
        this.tipoEqui = tipoEqui;
        this.enfColocado = enfColocado;
        this.livre = livre;
        this.doenteAUsar = null;
    }
    
    //Modificador

    public void setCodigoEqui(String codigoEqui) {
        this.codigoEqui = codigoEqui;
    }
    public void setLivre(String livre) {
        this.livre = livre;
    }
    public void setDoenteAUsar(Doente doenteAUsar) {
        this.doenteAUsar = doenteAUsar;
    }
    
    //Seletor
    public String getCodigoEqui() {
        return codigoEqui;
    }
    public String getTipoEqui() {
        return tipoEqui;
    }
    public Enfermaria getEnfColocado() {
        return enfColocado;
    }
    public String getLivre() {
        return livre;
    }
    public Doente getDoenteAUsar() {
        return doenteAUsar;
    }
    
    public String toString(){
        String s = "Codigo do equipamento:"+codigoEqui+" Tipo de equipamento:"+tipoEqui+" Enfermaria colocado:"+" Estado:"+livre+" Doente a usar:"+doenteAUsar;
        return s;
    }
}
