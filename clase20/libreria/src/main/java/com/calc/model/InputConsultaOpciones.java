package com.calc.model;

public class InputConsultaOpciones {
	public String tipo;
	public String vencimiento;
	public Double precio;
	public String strike;
	public Double tasa;
	
	public InputConsultaOpciones(String tipo, String vencimiento, Double precio, String strike, Double tasa) {
		this.tipo = tipo;
		this.vencimiento = vencimiento;
		this.precio = precio;
		this.strike = strike;
		this.tasa = tasa;
	}

	public InputConsultaOpciones() {
	}
}
