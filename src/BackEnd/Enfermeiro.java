package BackEnd;

import java.io.Serializable;

public class Enfermeiro extends ProfDeSaude{
    //Variaveis de instancia
    
    //Construtor
    public Enfermeiro(String nomeUtilizador, String password, String codigoProf, String nomeProf, Hospital hospTrab, Enfermaria enfTrab) {
        super(nomeUtilizador, password, codigoProf, nomeProf, hospTrab, enfTrab);
    }
}
