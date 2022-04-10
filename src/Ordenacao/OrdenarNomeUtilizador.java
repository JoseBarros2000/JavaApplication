package Ordenacao;

import BackEnd.Utilizador;
import java.util.Comparator;

public class OrdenarNomeUtilizador implements Comparator<Utilizador> {

    @Override
    public int compare(Utilizador uti1, Utilizador uti2) {
        //ascending order
	return uti1.getNomeUtilizador().compareTo(uti2.getNomeUtilizador());

	//descending order
	//return StudentName2.compareTo(StudentName1);
    }

}