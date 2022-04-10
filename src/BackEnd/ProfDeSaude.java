package BackEnd;

public class ProfDeSaude extends Utilizador{
    //Variaveis de instancia
    private String codigoProf;
    private String nomeProf;
    private Enfermaria enfTrab; //Enfermaria onde estao a trabalhar
    private Hospital hospitalOndeTrabalha;
    
    //Construtor
    public ProfDeSaude(String nomeUtilizador, String password, String codigoProf, String nomeProf,Hospital hospitalOndeTrabalha ,Enfermaria enfTrab){ //Ver esta parte
        super(nomeUtilizador, password);                        //Ver esta parte
        this.codigoProf=codigoProf;
        this.nomeProf=nomeProf;
        this.enfTrab= enfTrab;
        this.hospitalOndeTrabalha= hospitalOndeTrabalha;
    }
    
    //Modificadores
    public void setCodigoProf(String codigoProf) {
        this.codigoProf = codigoProf;
    }
    public void setNomeProf(String nomeProf) {
        this.nomeProf = nomeProf;
    }
    public void setEnfTrab(Enfermaria enfTrab) {
        this.enfTrab = enfTrab;
    }
    
    //Seletores
    public String getCodigoProf() {
        return codigoProf;
    }
    public String getNomeProf() {
        return nomeProf;
    }
    public Enfermaria getEnfTrab() {
        return enfTrab;
    }
    public Hospital getHospitalOndeTrabalha() {
        return hospitalOndeTrabalha;
    }
    
}
