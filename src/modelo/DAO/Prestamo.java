package modelo.DAO;

import java.time.LocalDate;

public class Prestamo {
	private LocalDate fechaPrestamo;
	private String dni; //No olvides arreglar la DB
	private String isbn;
	private String idEjemplar;
	
	
	public Prestamo(LocalDate fechaPrestamo, String dni, String isbn, String idEjemplar) {
		this.fechaPrestamo = fechaPrestamo;
		this.dni = dni;
		this.isbn = isbn;
		this.idEjemplar = idEjemplar;
	}

	
	public LocalDate getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(LocalDate fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getIdEjemplar() {
		return idEjemplar;
	}

	public void setIdEjemplar(String idEjemplar) {
		this.idEjemplar = idEjemplar;
	}


	@Override
	public String toString() {
		return "Prestamo [fechaPrestamo=" + fechaPrestamo + ", dni=" + dni + ", isbn=" + isbn + ", idEjemplar="
				+ idEjemplar + "]";
	}

}








