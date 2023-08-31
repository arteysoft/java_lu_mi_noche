package edu.it.didi;

@FunctionalInterface
public interface GrupoInclusion {
	/*
	 * Aca es donde incluimos, el concepto de predicado
	 * El predicado es una funcion que recibe un objeto y retorna un Boolean
	 * a menudo se puede escuchar que una funcion va de Chofer -> Boolean
	 */
	public Boolean test(Chofer chofer);
}
