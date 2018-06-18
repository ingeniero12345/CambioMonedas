package com.hernan.vo;

public class Rates {
	
	private String NombreMoneda;
	private String Valor;
	private String simbolo;
	
	public Rates(String nombreMoneda, String valor, String simb) {
		this.NombreMoneda = nombreMoneda;
		this.Valor = valor;
		this.simbolo = simb;

	}
	public Rates() {}
	public String getSimbolo() {
		return simbolo;
	}
	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	
	public String getValor() {
		return Valor;
	}
	public void setValor(String valor) {
		Valor = valor;
	}
	public String getNombreMoneda() {
		return NombreMoneda;
	}
	public void setNombreMoneda(String nombreMoneda) {
		NombreMoneda = nombreMoneda;
	}

}
