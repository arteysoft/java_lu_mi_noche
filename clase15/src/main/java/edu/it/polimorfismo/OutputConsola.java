package edu.it.polimorfismo;

public class OutputConsola implements Output {
	public void informarNumeroEstudiar(int x) {
		System.out.println("Estudiando: " + x);
	}
	public void informarNumeroPrimoEncontrado(int x) {
		System.out.println("Agregando ..." + x);
	}
}
