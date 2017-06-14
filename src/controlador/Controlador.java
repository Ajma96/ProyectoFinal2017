package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

import modelo.DAO.Ejemplar;
import modelo.DAO.EjemplarDAO;
import modelo.DAO.Libro;
import modelo.DAO.LibroDAO;
import modelo.DAO.Prestamo;
import modelo.DAO.Socio;
import modelo.DAO.SocioDAO;
import vista.Vista;

public class Controlador implements ActionListener {

	private Vista vista;
	private SocioDAO socioDAO;
	private List<Socio> listaSocios;
	private LibroDAO libroDAO;
	private List<Libro> listaLibros;
	private EjemplarDAO ejemplarDAO;
	private List<Ejemplar> listaEjemplares;
	
	
	
	public Controlador(Vista vista, SocioDAO socioDAO, LibroDAO libroDAO, EjemplarDAO ejemplarDAO)
	{
		this.vista 		 = vista;
		this.socioDAO 	 = socioDAO;
		this.libroDAO 	 = libroDAO;
		this.ejemplarDAO = ejemplarDAO;
		
		ActionListener(this);
		
		listaSocios = socioDAO.getListaSocios();
		listaLibros = libroDAO.getListaLibros();
		listaEjemplares = ejemplarDAO.getListaEjemplares();
	}


	@Override
	public void actionPerformed(ActionEvent e)
	{
		switch(e.getActionCommand())
		{
		case "Añadir":
			limpiarCampos();
			Socio socio = generarSocio();
			listaSocios.add(socio);
			Collections.sort(listaSocios);
			socioDAO.addSocio(socio);
			break;
			
		case "Borrar":
			break;
			
		case "Actualizar":
			break;
			
		default: System.out.println("Error al detectar actionPerformed");
		}
		
	}

	
	private void ActionListener(ActionListener escuchante) {
		vista.getBtnAadir()		.addActionListener(escuchante);
		vista.getBtnActualizar().addActionListener(escuchante);
		vista.getBtnBorrar()	.addActionListener(escuchante);
	}

	private void limpiarCampos() {
		vista.getTextField_0().setText("");
		vista.getTextField_1().setText("");
		vista.getTextField_2().setText("");
		vista.getTextField_3().setText("");
	}
	
	private Socio generarSocio() {
		String dni 			= vista.getTextField_0().getText();
		String nombre 		= vista.getTextField_1().getText();
		String apellidos 	= vista.getTextField_2().getText();
		LocalDate fechaAlta = pasarDeCadenaAFecha(vista.getTextField_3().getText());
		
		return new Socio(dni, nombre, apellidos, fechaAlta);
	}
	
	private Libro generarLibro() {
		String isbn 	 = vista.getTextField_0().getText();
		String titulo 	 = vista.getTextField_1().getText();
		String autores 	 = vista.getTextField_2().getText();
		String tematicas = vista.getTextField_3().getText();
		
		return new Libro(isbn, titulo, autores, tematicas);
	}
	
	private Ejemplar generarEjemplar() {
		int idEjemplar 	 = Integer.parseInt(vista.getTextField_0().getText());
		String isbn 	 = vista.getTextField_1().getText();
		String editorial = vista.getTextField_2().getText();
		int edicion 	 = Integer.parseInt(vista.getTextField_3().getText());
		
		return new Ejemplar(idEjemplar, isbn, editorial, edicion);
	}
	
	/*private Prestamo generarPrestamo() {
		String dni 				= vista.getTextField_0().getText();
		String isbn 			= vista.getTextField_1().getText();
		String idEjemplar 		= vista.getTextField_2().getText();
		LocalDate fechaPrestamo = pasarDeCadenaAFecha(vista.getTextField_3().getText());
		
		return new Prestamo(dni, isbn, idEjemplar, fechaPrestamo);
	}*/		// <- Implementar PrestamosDAO 
	
	private void mostrarSocio(int index) {
		vista.getTextField_0().setText(listaSocios.get(index).getDni());
		vista.getTextField_1().setText(listaSocios.get(index).getNombre());
		vista.getTextField_2().setText(listaSocios.get(index).getApellidos());
		vista.getTextField_3().setText(listaSocios.get(index).getFechaAlta().toString());
	}
	
	private void mostrarLibro(int index) {
		
	}
	
	private void mostrarEjemplar(int index) {
		
	}
	
	private void mostrarPrestamo(int index) {
		
	}
	
	private static LocalDate pasarDeCadenaAFecha(String fecha) {
		return LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
}








