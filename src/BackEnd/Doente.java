package BackEnd;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Doente implements Serializable{
    //variaveis de instancia
    private String codigoDoen;
    private String nome;
    private String localidade;
    private String enfermariaOndeEstaODoente; //apontador para o objeto Emfermaria onde esta o doente
    private int cama;
    private String estado; //Moderado, Grave, Muito Grave
    private String dataEntrada;
    private String medicoAtribuido;
    private LocalDateTime dataSaida;
    
    //Construtor
    public Doente(String codigoDoen, String nome, String localidade, String enfermariaOndeEstaODoente, int cama, String estado, String dataEntrada, String medicoAtribuido) {
        this.codigoDoen = codigoDoen;
        this.nome = nome;
        this.localidade = localidade;
        this.enfermariaOndeEstaODoente = enfermariaOndeEstaODoente;
        this.cama = cama;
        this.estado = estado;
        this.dataEntrada = dataEntrada;
        this.medicoAtribuido = medicoAtribuido;
        this.dataSaida = null;
    }

     //Modificadores
    public void setCodigoDoen(String codigoDoen) {
        this.codigoDoen = codigoDoen;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }
    public void setEnfermariaOndeEstaODoente(String enfermariaOndeEstaODoente) {
        this.enfermariaOndeEstaODoente = enfermariaOndeEstaODoente;
    }
    public void setCama(int cama) {
        this.cama = cama;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }
    public void setDataSaida(LocalDateTime dataSaida) {
        this.dataSaida = dataSaida;
    }
    public void setMedicoAtribuido(String medicoAtribuido){
        this.medicoAtribuido = medicoAtribuido;
    }
 
    //Seletores
    public String getCodigoDoen() {
        return codigoDoen;
    }
    public String getNome() {
        return nome;
    }
    public String getLocalidade() {
        return localidade;
    }
    public String getEnfermariaOndeEstaODoente() {
        return enfermariaOndeEstaODoente;
    }
    public int getCama() {
        return cama;
    }
    public String getEstado() {
        return estado;
    }
    public String getDataEntrada() {
        return dataEntrada;
    }
    public LocalDateTime getDataSaida() {
        return dataSaida;
    }
    public String getMedicoAtribuido() {
        return medicoAtribuido;
    }
    
    
    //toString
    @Override
    public String toString(){
        String s = "Codigo:"+codigoDoen+"| Nome do Doente:"+nome+"| Localidade:"+localidade+"| Enfermaria onde se encontra:"+enfermariaOndeEstaODoente+"| Cama:"+cama+"| Estado:"+estado+"| Data de entrada:"+dataEntrada+"| Data de saida:"+dataSaida;
        return s;
    }
    //Equals
    /*@Override
    public boolean equals(Object obj) {
        if (this == obj) 
            return true;
        if ((this.getClass() != obj.getClass()) || (obj == null))
            return false;
        if (this.getCodigoDoen() == )
        Doente x = (Doente) obj;
        return true; //algoritmo de comparação
    }*/
}