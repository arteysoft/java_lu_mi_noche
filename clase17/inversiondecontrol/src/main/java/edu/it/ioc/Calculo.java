package edu.it.ioc;

import java.util.Optional;

public class Calculo {
	private Optional<Integer> estadoInterno;
	
	public Calculo() {
		estadoInterno = Optional.of(0);
	}
	
	public Calculo sumar(Integer x) {
		if (estadoInterno.isEmpty()) {
			return this;
		}
		
		estadoInterno = Optional.of(estadoInterno.get() + x); 
		return this;
	}
	
	public Calculo restar(Integer x) {
		if (estadoInterno.isEmpty()) {
			return this;
		}
		
		estadoInterno = Optional.of(estadoInterno.get() - x);
		return this;
	}
	
	public Calculo multiplicar(Integer x) {
		if (estadoInterno.isEmpty()) {
			return this;
		}
		
		estadoInterno = Optional.of(estadoInterno.get() * x);
		return this;
	}
	
	public Calculo dividir(Integer dividendo) {
		if (estadoInterno.isEmpty()) {
			return this;
		}
		
		if (estadoInterno.get() == 0) {
			estadoInterno = Optional.empty();
			return this;
		}
		
		estadoInterno = Optional.of(dividendo / estadoInterno.get());
		return this;
	}
	
	public Optional<Integer> obtenerValor() {
		return estadoInterno;
	}
}
