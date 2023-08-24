package edu.it.polimorfismo;

import java.io.File;
import java.nio.charset.Charset;

public class OutputFile implements Output {
	private void escribirArchivo(File f, String escribir) {
		try {
			org.apache.commons.io.FileUtils.writeStringToFile(
					f, 
					escribir + System.lineSeparator(), 
					Charset.defaultCharset(), 
					true);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public void informarNumeroEstudiar(int x) {
		escribirArchivo(new File("/var/javalumi/estudiando.txt"), "Estudiando: " + x);
	}
	public void informarNumeroPrimoEncontrado(int x) {
		escribirArchivo(new File("/var/javalumi/numerosPrimos.txt"), "Agregando ..." + x);
	}
}
