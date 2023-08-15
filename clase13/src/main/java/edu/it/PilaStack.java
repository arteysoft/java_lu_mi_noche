package edu.it;

import java.io.IOException;
import java.sql.SQLException;

public class PilaStack {
	public void m6(int x) throws IOException, SQLException {
		System.out.println("Llegue a m6");
		if (x == 0) {
			throw new IOException("El valor del divisor es 0");
		}
		if (x == 1) {
			throw new SQLException("");
		}
		int resultado = 10000 / x;
		System.out.println("El valor de x es: " + x);
		System.out.println("El valor de resultado es: " + resultado);
	}
	public void m5(int x) throws IOException, SQLException {
		System.out.println("Antes de llamar a m6");
		m6(x + 1);
		System.out.println("Despues de llamar a m6");
	}
	public void m4(int x) throws IOException, SQLException {
		System.out.println("Antes de llamar a m5");
		m5(x - 1);
		System.out.println("Despues de llamar a m5");
	}
	public void m3(int x) throws IOException, SQLException {
		System.out.println("Antes de llamar a m4");
		m4(x - 1);
		System.out.println("Despues de llamar a m4");
	}
	public void m2(int x) throws IOException, SQLException {
		System.out.println("Antes de llamar a m3");
		m3(x - 1);
		System.out.println("Despues de llamar a m3");
	}
	public void m1(int x) throws IOException, SQLException {
		System.out.println("Antes de llamar a m2");
		m2(x - 1);
		System.out.println("Despues de llamar a m2");
	}
}
