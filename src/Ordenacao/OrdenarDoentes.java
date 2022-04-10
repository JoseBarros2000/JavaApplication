package Ordenacao;

import BackEnd.Doente;
import java.util.Comparator;

public class OrdenarDoentes implements Comparator<Doente> {

    @Override
    public int compare(Doente doen1, Doente doen2) {
        //ascending order
	return doen1.getCodigoDoen().compareTo(doen2.getCodigoDoen());

	//descending order
	//return StudentName2.compareTo(StudentName1);
    }
}
