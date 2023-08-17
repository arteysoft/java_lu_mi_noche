package edu.it;

public class CursoSpringApplication {
	public static void main(String[] args) {
		System.out.println("Bienvenidos al curso de JAVA - clase 14");
		
		new Discovery(new ProxyNumerosPrimosMemory()).run();
	}
}
