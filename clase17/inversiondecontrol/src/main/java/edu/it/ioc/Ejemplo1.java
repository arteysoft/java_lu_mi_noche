package edu.it.ioc;

public class Ejemplo1 implements Runnable {
	private void correrProcesoSinRespuesta(Runnable r) {
		try {
			r.run();
		}
		catch (Exception ex) {
			ex.printStackTrace();  // Tragar la exception
		}
	}
	
	private void etapa1() {}
	private void etapa2(Boolean fallo) { if (fallo) throw new RuntimeException("Fallo en etapa 2"); }
	private void etapa3() {}	
	private void correrUnProceso() {
		correrProcesoSinRespuesta(() -> {
			etapa1();
			etapa2(true);
			etapa3();
		});
	}
	
	private void otroProceso(int z) {
		correrProcesoSinRespuesta(() -> {
			int x = 1;
			int y = z / (z - x);
		});
	}
	
	public void run() {
		correrUnProceso();
		otroProceso(2);
	}
}
