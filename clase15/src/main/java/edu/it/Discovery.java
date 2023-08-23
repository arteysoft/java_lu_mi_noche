package edu.it;

public class Discovery {
	private AlmacenNumerosPrimos almacenNumerosPrimos;
	
	public Discovery(AlmacenNumerosPrimos proxyNumerosPrimos) {
		this.almacenNumerosPrimos = proxyNumerosPrimos;
	}
	private Boolean testearQueNOTengaRaiz(int numero_a_testear) {
		for (; almacenNumerosPrimos.haySiguiente() ;) {
			var divisor = almacenNumerosPrimos.obtenerSiguiente();
			if (numero_a_testear % divisor == 0) {
				return false;
			}
		}
		return true;
	}
	private void probarConLosNumerosDeLaTabla(int numero_a_testear) {
		try {
			if (testearQueNOTengaRaiz(numero_a_testear)) {
				System.out.println("Agregando ..." + numero_a_testear);
				almacenNumerosPrimos.insertarNuvoNumero(numero_a_testear);
			}
			Thread.sleep(10);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public void run() {
		int numerador = 3;
		for (;;) {
			almacenNumerosPrimos.fetchNumerosPrimos();
			probarConLosNumerosDeLaTabla(numerador);
			numerador++;
			System.out.println(numerador);
		}
	}
}
