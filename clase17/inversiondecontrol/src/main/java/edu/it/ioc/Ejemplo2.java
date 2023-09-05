package edu.it.ioc;

import java.util.Optional;

public class Ejemplo2 implements Runnable {
	private Optional<Integer> realizarOPeracion(Integer x, Integer y) {
		try {
			Integer ret = (x + y * 4) / y;
			return Optional.of(ret);
		}
		catch (Exception ex) {
			return Optional.empty();
		}
	}
	public void run() {
		Optional<Integer> x = realizarOPeracion(3, 2);
		System.out.println(x);
	}
}
