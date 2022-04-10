/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ordenacao;

import java.util.Comparator;
import BackEnd.Medico;

public class OrdenarMedicos implements Comparator<Medico> {

    @Override
    public int compare(Medico med1, Medico med2) {
        //ascending order
	return med1.getNomeUtilizador().compareTo(med2.getNomeUtilizador());

	//descending order
	//return StudentName2.compareTo(StudentName1);
    }

}