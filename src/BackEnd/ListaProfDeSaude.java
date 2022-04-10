package BackEnd;

import BackEnd.Enfermeiro;
import BackEnd.Medico;
import BackEnd.ProfDeSaude;
import BackEnd.Utilizador;
import Ordenacao.OrdenarEnfermeiros;
import Ordenacao.OrdenarMedicos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class ListaProfDeSaude implements Serializable{
    
    //Variaveis de instância
    private ArrayList<ProfDeSaude> listaProfSaude;
    private ArrayList<Medico> listaMedico;
    private ArrayList<Enfermeiro> listaEnfermeiros;
    //Construtores
    public ListaProfDeSaude() {
        this.listaProfSaude = new ArrayList<ProfDeSaude>();
        this.listaMedico = new ArrayList<Medico>();
        this.listaEnfermeiros = new ArrayList<Enfermeiro>();
    }
    
    //Modificadores
    public void criarProfDeSaudeMed(Medico m){
        if (existeMed(m.getNomeUtilizador()) || existeProf(m.getNomeUtilizador()))
            throw new RuntimeException("Este utilizador ja existe");
        else {
            listaProfSaude.add(m);
            listaMedico.add(m);
        }
    }
    public void criarProfDeSaudeEnf(Enfermeiro e){
        if (existeEnf(e.getNomeUtilizador()) || existeProf(e.getNomeUtilizador()))
            throw new RuntimeException("Este utilizador ja existe");
        else {
            listaProfSaude.add(e);
            listaEnfermeiros.add(e);
        }
    }
    public void setApagarProfDeSaude (String nomeUtilizador){ 
        boolean flag = false;
        for(Medico m: listaMedico){
            if(m.getNomeUtilizador().equals(nomeUtilizador)){
                listaMedico.remove(m);
                for(ProfDeSaude p: listaProfSaude){
                    if(p.getNomeUtilizador().equals(nomeUtilizador)){
                        listaProfSaude.remove(p);
                        flag=true;
                        return;
                    }
                }
            }
        }
        if(flag == false){
            for(Enfermeiro e: listaEnfermeiros){
                if(e.getNomeUtilizador().equals(nomeUtilizador)){
                    listaEnfermeiros.remove(e);
                    for(ProfDeSaude p: listaProfSaude){
                        if(p.getNomeUtilizador().equals(nomeUtilizador)){
                            listaProfSaude.remove(e);
                            flag=true;
                            return;
                        }
                    }
                }
            }
        }
        if(flag==false){
            throw new RuntimeException("Este Profissional de Saúde nao existe");
        }
    }
    
    public boolean existeProf(String prof){
        for(ProfDeSaude p: listaProfSaude){
            if(p.getNomeUtilizador().equals(prof)){
                return true;
            }
        }
        return false;
    }
    public boolean existeCodProf(String codProf){
        for(ProfDeSaude p: listaProfSaude){
            if(p.getCodigoProf().equals(codProf)){
                return true;
            }
        }
        return false;
    }
    public boolean existeMed(String med){
        for(Medico m: listaMedico){
            if(m.getNomeUtilizador().equals(med)){
                return true;
            }
        }
        return false;
    }
    public Medico getMedico(String nomeUtilizador){
        for (Medico m : this.listaMedico){
            if (m.getNomeUtilizador().equals(nomeUtilizador)){
                return m;
            }
        }
        throw new RuntimeException("Dados nao encontrados");
    }
    public Enfermeiro getEnfermeiro(String nomeUtilizador){
        for (Enfermeiro e : this.listaEnfermeiros){
            if (e.getNomeUtilizador().equals(nomeUtilizador)){
                return e;
            }
        }
        throw new RuntimeException("Dados nao encontrados");
    }
    public ProfDeSaude getProfDeSaude(String nomeUtilizador){
        for (ProfDeSaude p : this.listaProfSaude){
            if (p.getNomeUtilizador().equals(nomeUtilizador)){
                return p;
            }
        }
        throw new RuntimeException("Dados nao encontrados");
    }
    
    public boolean verificarNomeUtilizadorMed(String nomeUtilizador, String password) { //Verificar o username do utilizador
        for (Utilizador u : this.listaMedico) {
            if(u instanceof Medico){
                if (u.getNomeUtilizador().equals(nomeUtilizador)) {
                    if (u.getPassword().equals(password)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean verificarNomeUtilizadorEnf(String nomeUtilizador, String password) { //Verificar o username do utilizador
        for (Utilizador u : this.listaEnfermeiros) {
            if(u instanceof Enfermeiro){
                if (u.getNomeUtilizador().equals(nomeUtilizador)) {
                    if (u.getPassword().equals(password)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean existeEnf(String enf){
        for(Enfermeiro e: listaEnfermeiros){
            if(e.getNomeUtilizador().equals(enf)){
                return true;
            }
        }
        return false;
    }
    
    public boolean verificarPassProf(String password) {
        for (ProfDeSaude p: listaProfSaude) {
                if (p.getPassword().equals(password)) {
                    return true;
                }
            }
        throw new RuntimeException("Password Invalida");
    }
    public boolean verificarPassMed(String password) {
        for (Medico m : listaMedico) {
                if (m.getPassword().equals(password)) {
                    return true;
                }
            }
        throw new RuntimeException("Password Invalida");
    }
    public boolean verificarPassEnf(String password) {
        for (Enfermeiro e : listaEnfermeiros) {
                if (e.getPassword().equals(password)) {
                    return true;
                }
            }
        throw new RuntimeException("Password Invalida");
    }
    
    //Tamanho da lista
    public int sizeProf(){
        return listaProfSaude.size();
    }
    public int sizeMed(){
        return listaMedico.size();
    }
    public int sizeEnf(){
        return listaEnfermeiros.size();
    }
    public ProfDeSaude getProfDeSaudeByIndex(int i){
        return this.listaProfSaude.get(i);
    }
    public Medico getMedicosByIndex(int i){
        return this.listaMedico.get(i);
    }
    public Enfermeiro getEnfermeirosByIndex(int i){
        return this.listaEnfermeiros.get(i);
    }
    public ArrayList<Medico> ordenacaoMedicos(){
        OrdenarMedicos ordenarNomeUtilizador = new OrdenarMedicos();
        Collections.sort(listaMedico, ordenarNomeUtilizador);
        return listaMedico;
    }
    public ArrayList<Enfermeiro> ordenacaoEnfermeiros(){
        OrdenarEnfermeiros ordenarNomeUtilizador = new OrdenarEnfermeiros();
        Collections.sort(listaEnfermeiros, ordenarNomeUtilizador);
        return listaEnfermeiros;
    }
    
    //Seletores
    public ArrayList<ProfDeSaude> getListaProfSaude(){
        return listaProfSaude;
    }
}
