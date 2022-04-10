
package Ordenacao;

import BackEnd.Enfermaria;
import java.util.Comparator;

public class OrdenarCodigoEnfermaria implements Comparator<Enfermaria> {

    @Override
    public int compare(Enfermaria enf1, Enfermaria enf2) {
        //ascending order
	return enf1.getCodigoEnf().compareTo(enf2.getCodigoEnf());

	//descending order
	//return StudentName2.compareTo(StudentName1);
    }

}
