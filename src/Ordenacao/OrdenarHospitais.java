/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ordenacao;

import BackEnd.Enfermeiro;
import BackEnd.Hospital;
import java.util.Comparator;

/**
 *
 * @author david
 */
public class OrdenarHospitais implements Comparator<Hospital> {

    @Override
    public int compare(Hospital hosp1, Hospital hosp2) {
        //ascending order
	return hosp1.getNome().compareTo(hosp2.getNome());

	//descending order
	//return StudentName2.compareTo(StudentName1);
    }
}
