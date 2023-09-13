package edu.it.errores;

public class HttpError extends RuntimeException {
	public final Integer codigoError;

	public HttpError(Integer codigoError) {
		this.codigoError = codigoError;
	}
}
