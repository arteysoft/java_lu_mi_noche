package edu.it.model;

public class Alumno {
    public String id;
    public String nombre;
    public String apellido;
    public String calle;
    public String calleNumero;
    public String estado;
    public String pais;
    
    public Alumno() {
    }

	public Alumno(String id, String nombre, String apellido, String calle, String calleNumero, String estado,
			String pais) {
		
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.calle = calle;
		this.calleNumero = calleNumero;
		this.estado = estado;
		this.pais = pais;
	}
}
