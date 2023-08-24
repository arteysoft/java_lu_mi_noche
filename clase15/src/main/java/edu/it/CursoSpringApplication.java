package edu.it;

import java.io.File;
import java.nio.charset.Charset;

import edu.it.funcflecha.EjemploFuncionesFlecha;
import edu.it.polimorfismo.OutputFile;

public class CursoSpringApplication {
	private static Discovery createDiscoveryFactory() {
		return new Discovery(
					new AlmacenNumerosPrimosMariaDB(), 
					new OutputFile());
	}	
	public static void main(String[] args) {
		System.out.println("Bienvenidos al curso de JAVA - clase 14");
		
		// createDiscoveryFactory().run();
		new EjemploFuncionesFlecha().run();
	}
}
