package edu.it.funcflecha;

interface Operacion {
	int operar(int x, int y);
}

class OperacionSumar implements Operacion {
	public int operar(int x, int y) {
		return x + y; 
	}
}

class OperacionRestar implements Operacion {
	public int operar(int x, int y) {
		return x - y; 
	}
}


public class EjemploFuncionesFlecha {
	private void realizarOperacion(Operacion operacion) {
		int resultado = operacion.operar(4, 5);
		System.out.println("El resultado de la operacion es: " + resultado);
	}
	public void run() {
		Operacion opeArrow = (int x, int y) -> x * x * y;
		Operacion opeMultiplicar = (int x, int y) -> x * y;
		// Hagan la operacion de resta
		// Hagan la operacion de suma
		// Borrar las clases y dejar solo la interfaz
		
		realizarOperacion(new OperacionSumar());
		realizarOperacion(opeMultiplicar);
		realizarOperacion(new OperacionRestar());
		realizarOperacion(opeArrow);
	}
}
