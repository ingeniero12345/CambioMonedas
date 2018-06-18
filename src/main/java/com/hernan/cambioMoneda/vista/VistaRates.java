package com.hernan.cambioMoneda.vista;

import java.util.List;

import com.hernan.vo.Rates;
 
public class VistaRates {
	public void verRates(Rates rates) {
		System.out.println("Datos del Rates: "+rates);
	}
	
	public void verClientes(List<Rates> rates) {
		for (Rates cliente : rates) {
			System.out.println("Datos del Cliente: "+cliente);
		}		
	}
}