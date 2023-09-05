package edu.it.ioc;

public class Ejemplo3 implements Runnable {	
	public void run() {
		var res = new Calculo()
			.sumar(10)
			.sumar(11)
			.restar(20)
			.multiplicar(10)
			.dividir(10)
			.sumar(5)
			.obtenerValor();
		
		res.ifPresentOrElse(z -> {
			System.out.print("Esta presente el valor es ... ");
			System.out.println(z);
		}, () -> {
			System.out.println("No esta presente");
		});
	}
}
