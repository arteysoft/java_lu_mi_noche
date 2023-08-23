package edu.it;

import java.io.File;
import java.nio.charset.Charset;

public class CursoSpringApplication {
	private static Discovery createDiscoveryFactory() {
		// return new Discovery(new AlmacenNumerosPrimosMemoria());
		return new Discovery(new AlmacenNumerosPrimosMariaDB());
	}
	private static void ejemplitoEscribirArchivo() {
		try {
			org.apache.commons.io.FileUtils.writeStringToFile(
					new File("/var/javalumi/ejemplo.txt"), 
					"hola" + System.lineSeparator(), 
					Charset.defaultCharset(), 
					true);
			
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public static void main(String[] args) {
		System.out.println("Bienvenidos al curso de JAVA - clase 14");
		
		// createDiscoveryFactory().run();
		ejemplitoEscribirArchivo();
	}
}
