/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ordenacao;

import BackEnd.Enfermeiro;
import java.util.Comparator;

public class OrdenarEnfermeiros implements Comparator<Enfermeiro> {

    @Override
    public int compare(Enfermeiro enf1, Enfermeiro enf2) {
        //ascending order
	return enf1.getNomeUtilizador().compareTo(enf2.getNomeUtilizador());

	//descending order
	//return StudentName2.compareTo(StudentName1);
    }

}