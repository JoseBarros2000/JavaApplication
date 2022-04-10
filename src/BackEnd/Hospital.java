package BackEnd;

import java.io.Serializable;

public class Hospital implements Serializable{
    //variaveis de instancia
    private String codigo; //0201 H0201
    private String nome;
    private String localidade;
    private ListaDoentes listaDoentes;	//conjunto de doente
    private ListaEnfermarias listaEnfermaria; //conjunto da Enfermaria
    private ListaEquipamentos listaEquipamento; //conjunto do Equipamento
    private ListaProfDeSaude listaProfDeSaude; //conjunto de Profissionais de Saude

    //Construtores
    public Hospital(String codigo, String nome, String localidade, ListaDoentes listaDoentes, ListaEnfermarias listaEnfermaria, ListaEquipamentos listaEquipamento, ListaProfDeSaude listaProfDeSaude) {
        this.codigo = codigo;
        this.nome = nome;
        this.localidade = localidade;
        this.listaDoentes = listaDoentes;
        this.listaEnfermaria = listaEnfermaria;
        this.listaEquipamento = listaEquipamento;
        this.listaProfDeSaude = listaProfDeSaude;
    }
    
    //Modificadores
    public void setProfDeSaudeDoHospitalMed(Medico m){
        listaProfDeSaude.criarProfDeSaudeMed(m);
    }
    public void setProfDeSaudeDoHospitalEnf(Enfermeiro e){
        listaProfDeSaude.criarProfDeSaudeEnf(e);
    }
    public void apagagarProfDeSaudeDoHospitalMed(String medico){
        listaProfDeSaude.setApagarProfDeSaude(medico);
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }
    public void setListaDoentes(ListaDoentes listaDoentes) {
        this.listaDoentes = listaDoentes;
    }
    public void setListaEnfermaria(ListaEnfermarias listaEnfermaria) {
        this.listaEnfermaria = listaEnfermaria;
    }
    public void setListaEquipamento(ListaEquipamentos listaEquipamento) {
        this.listaEquipamento = listaEquipamento;
    }
    public void setListaProfDeSaude(ListaProfDeSaude listaProfDeSaude) {
        this.listaProfDeSaude = listaProfDeSaude;
    }
    //Seletores
    public String getCodigo(){    
        return codigo;
    }
    public String getNome() {
        return nome;
    }
    public String getLocalidade() {
        return localidade;
    }
    public ListaDoentes getListaDoentes() {
        return listaDoentes;
    }
    public ListaEnfermarias getListaEnfermaria() {
        return listaEnfermaria;
    }
    public ListaEquipamentos getListaEquipamento() {
        return listaEquipamento;
    }
    public ListaProfDeSaude getListaProfDeSaude() {
        return listaProfDeSaude;
    }
    
    //toString
    @Override
    public String toString() {
        String s = "Codigo do Hospital:"+codigo+" Nome:"+nome+" Localidade:"+localidade+" Lista de doentes do hospital:"+listaDoentes+" Lista de enfermarias:"+listaEnfermaria+" Lista de equipamentos:"+listaEquipamento+" Lista de profissionais de saude:"+listaProfDeSaude;
        return s;
    }
}