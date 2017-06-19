package modelo.DAO;

import java.time.LocalDate;

import modelo.DAO.Socio;

public class Socio implements Comparable<Socio> {
	
	private String dni;
	private String nombre;
	private String apellidos;
	private LocalDate fechaAlta;
	
	
	public Socio(String dni, String nombre, String apellidos, LocalDate fechaAlta) {
		
		this.dni 		= dni;
		this.nombre 	= nombre;
		this.apellidos  = apellidos;
		this.fechaAlta  = fechaAlta;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	@Override
	public String toString() {
		return "Socio [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fechaAlta=" + fechaAlta
				+ "]";
	}
	
	@Override
	public int compareTo(Socio o) {
		return dni.compareTo(o.dni);
	}
	
	
}










