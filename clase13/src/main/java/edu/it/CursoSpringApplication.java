package edu.it;

public class CursoSpringApplication {
	public static void main(String[] args) {
		System.out.println("Bienvenidos al curso de JAVA - clase 13");
		
		for (int x = 2; x <= 4; x++) {
			try {				
				new PilaStack().m1(x);				
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
			System.out.println("----------------------------------");
			try {Thread.sleep(6000); } catch (Exception ex) {}
		}
	}
}
