package edu.it;

import java.util.ArrayList;
import java.util.List;

public class AlmacenNumerosPrimosMemoria implements AlmacenNumerosPrimos {
	List<Integer> listaDeNumerosPrimosEncontrados = null;
	int posicionDeArrayList = 0;
	
	public AlmacenNumerosPrimosMemoria() {
		listaDeNumerosPrimosEncontrados = new ArrayList<Integer>();
		listaDeNumerosPrimosEncontrados.add(2);
	}
	
	public Boolean haySiguiente() {
		return (listaDeNumerosPrimosEncontrados.size() > posicionDeArrayList);
	}
	
	public int obtenerSiguiente() {
		int ret = listaDeNumerosPrimosEncontrados.get(posicionDeArrayList);
		posicionDeArrayList++;
		return ret;
	}
	
	public void fetchNumerosPrimos() {
		posicionDeArrayList = 0;
	}
	
	public void insertarNuvoNumero(int n) {
		listaDeNumerosPrimosEncontrados.add(n);
	}

}
