package BackEnd;

import BackEnd.Enfermaria;
import BackEnd.Hospital;
import BackEnd.ProfDeSaude;
import java.util.ArrayList;

public class Medico extends ProfDeSaude {
    //Variaveis de instancia
    private String especialidade;
    private int numDoentesAtribuidos;
    private ArrayList<String> listaDoentesDoMedico;
    //Construtor
    public Medico(String nomeUtilizador, String password, String codigoProf, String nomeProf, Hospital hospTrab, Enfermaria enfTrab, String especialidade) {
        super(nomeUtilizador, password, codigoProf, nomeProf, hospTrab, enfTrab);
        this.especialidade=especialidade;
        this.numDoentesAtribuidos=0;
        this.listaDoentesDoMedico=new ArrayList<String>();
    }
    
    //Moficadores
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    public void setNumDoentesAtribuidos() {
        
            this.numDoentesAtribuidos = listaDoentesDoMedico.size()+1;
    }
    public void setDoenteDoMedico(String codigoDoente){
        listaDoentesDoMedico.add(codigoDoente);
    }
    public void removeDoenteDoMedico(String codigoDoente){
        listaDoentesDoMedico.remove(codigoDoente);
    }
    //Seletores
    public String getEspecialidade() {
        return especialidade;
    }
    public int getNumDoentesAtribuidos() {
        return numDoentesAtribuidos;
    }
    
    @Override
    public String toString(){
        String s = "Especialidade:"+especialidade+"| Numero de doentes atribuidos:"+numDoentesAtribuidos;
        return s;
    }
}
