package edu.it.didi;

@FunctionalInterface
public interface Predicado<T> {
	public Boolean test(T t);
}
