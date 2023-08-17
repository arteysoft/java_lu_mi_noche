package edu.it;

public class Discovery {
	ProxyNumerosPrimos proxyNumerosPrimos;
	
	public Discovery(ProxyNumerosPrimos proxyNumerosPrimos) {
		this.proxyNumerosPrimos = proxyNumerosPrimos;
	}
	private Boolean testearQueNOTengaRaiz(int numero_a_testear) {
		for (; proxyNumerosPrimos.haySiguiente() ;) {
			var divisor = proxyNumerosPrimos.obtenerSiguiente();
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
				proxyNumerosPrimos.insertarNuvoNumero(numero_a_testear);
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
			probarConLosNumerosDeLaTabla(numerador);
			numerador++;
		}
	}
}
