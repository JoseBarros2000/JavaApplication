package BackEnd;

import Exceptions.LoginDadosEmBranco;
import Exceptions.UtilizadorInvalido;
import java.io.Serializable;
import java.time.LocalDateTime;


public class Sistema implements Serializable{
    
    //Variaveis de instancia
    private final ListaHospital listaHospital;
    private final ListaUtilizador listaUtilizador;
    private Utilizador utilizadorLigado;
    private Enfermeiro enfermeiroLigado;
    private Medico medicoLigado;
    
    public Sistema() {
        this.listaHospital = new ListaHospital();
        this.listaUtilizador = new ListaUtilizador();
    }
    
    public Utilizador getUtilizadorLigado(){
        return utilizadorLigado;
    }
    
    public Enfermeiro getEnfermeiroLigado(){
        return enfermeiroLigado;
    }
    
    public Medico getMedicoLigado(){
        return medicoLigado;
    }
    
    //Variaveis iniciais
    public void inicializar() {
        listaUtilizador.criarNovoUti(new Utilizador("uti", "uti")); 
        listaUtilizador.criarNovoUti(new Adminstrador("admin", "admin"));
        
        
        
//        Enfermaria enf1;
//        enf1 = new Enfermaria("Enf#123", "Autistas", 5);
//        ListaEnfermarias listaEnf = new ListaEnfermarias();
//        Doente doen1;
//        ListaDoentes listadoen = new ListaDoentes();
//        LocalDateTime now = LocalDateTime.now();
//        doen1 = new Doente("Doente#431", "Marega", "Camaroes", enf1 , 5, "Grave", now, now, listadoen);
//        Equipamento equi = new Equipamento("#001","X-ray", enf1, "Livre", doen1);
//        ListaEquipamentos listaEqui = new ListaEquipamentos();
//        ListaProfDeSaude listaProfHosp1 = new ListaProfDeSaude();
//        Hospital hosp1;
//        hosp1 = new Hospital("#12", "Hospital de Braga", "Braga", listadoen, listaEnf, listaEqui,listaProfHosp1);
//        Enfermaria enfermaria = new Enfermaria("Enfermaria Braga", "Dont know", 5);
//        listaUtilizador.criarNovoUti(new Medico("med", "med", "123AB", "Jocaids Frits", enfermaria,"Operação", "15"));
//        hosp1.setProfDeSaudeDoHospitalMed(new Medico("med", "med", "123AB", "Jocaids Frits", enfermaria,"Operação", "15"));
    }
    public void terminar(){
        System.exit(0);
    }
    
    //Autenticadores
    public boolean autenticarUtilizador(String nomeuti, String password) throws LoginDadosEmBranco, UtilizadorInvalido{
        //Campos vazios
        if(nomeuti.equals("") && password.equals(""))
            throw new LoginDadosEmBranco("Nome de utilizador e password nao inseridos");
        else if(nomeuti.equals(""))
            throw new LoginDadosEmBranco("Nome de utilizador nao inserido");
        else if(password.equals(""))
            throw new LoginDadosEmBranco("Password nao inserida");
        
        if(listaUtilizador.verificarNomeUtilizadorUti(nomeuti, password)){
            utilizadorLigado = listaUtilizador.getUtilizador(nomeuti);
            return true;
        }
        else{
            //Utilizador nao existe
            throw new UtilizadorInvalido("Utilizador Invalido");
        }
    }
    public boolean autenticarMedico(String nomeuti, String password){
            for(int i=0; i<getListaHospital().sizeListaHospital(); i++){
                if(listaHospital.getHospitalByIndex(i).getListaProfDeSaude().verificarNomeUtilizadorMed(nomeuti, password)){
                    medicoLigado = listaHospital.getHospitalByIndex(i).getListaProfDeSaude().getMedico(nomeuti);
                    return true;
                }
            }
        return false;
    }
    public boolean autenticarEnfermeiro(String nomeuti, String password){
            for(int i=0; i<getListaHospital().sizeListaHospital(); i++){
                if(listaHospital.getHospitalByIndex(i).getListaProfDeSaude().verificarNomeUtilizadorEnf(nomeuti, password)){
                    enfermeiroLigado = listaHospital.getHospitalByIndex(i).getListaProfDeSaude().getEnfermeiro(nomeuti);
                    return true;
                }
            }
        return false;
    }
//    public boolean autenticarMedico(String nomeuti, String password) throws LoginDadosEmBranco, UtilizadorInvalido{
//        //Campos vazios
//        if(nomeuti.equals("") && password.equals(""))
//            throw new LoginDadosEmBranco("Nome de utilizador e password nao inseridos");
//        else if(nomeuti.equals(""))
//            throw new LoginDadosEmBranco("Nome de utilizador nao inserido");
//        else if(password.equals(""))
//            throw new LoginDadosEmBranco("Password nao inserida");
//        
//        if(listaUtilizador.verificarNomeUtilizadorUti(nomeuti, password)){
//            for(int i=0; i<listaHospital.sizeHospital(); i++){
//                for(int a=0; a<listaHospital.getHospitalByIndex(i).getListaProfDeSaude().sizeMed(); a++){
//                        utilizadorLigado = listaHospital.getHospitalByIndex(i).getListaProfDeSaude().getMedicosByIndex(a);
//                        return true;
//                    
//                }
//            }
//        }
//        else{
//            //Utilizador nao existe
//            throw new UtilizadorInvalido("Utilizador Invalido");
//        }
//        return false;
//    }
    
    //Seletores
    public ListaHospital getListaHospital() {
        return listaHospital;
    }
    public ListaUtilizador getListaUtilizador() {
        return listaUtilizador;
    }
    
}