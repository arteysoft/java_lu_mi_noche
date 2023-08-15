package edu.it;

import java.io.IOException;
import java.sql.SQLException;

public class CursoSpringApplication {
	public static void main(String[] args) {
		System.out.println("Bienvenidos al curso de JAVA - clase 13");
		
		/*
		for (int x = 2; x <= 4; x++) {
			try {				
				new PilaStack().m1(x);				
			}
			catch (IOException ex) {
				System.out.println("Vino un IOException");
			}
			catch (SQLException ex) {
				System.out.println("Vino un SQLException");
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
			System.out.println("----------------------------------");
			try {Thread.sleep(6000); } catch (Exception ex) {}
		}
		*/
		
		new Transacciones().run();
	}
}
