/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ordenacao;

import BackEnd.Equipamento;
import java.util.Comparator;

/**
 *
 * @author david
 */
public class OrdenarEquipamentos implements Comparator<Equipamento> {

    @Override
    public int compare(Equipamento equi1, Equipamento equi2) {
        //ascending order
	return equi1.getCodigoEqui().compareTo(equi2.getCodigoEqui());

	//descending order
	//return StudentName2.compareTo(StudentName1);
    }
}
