package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.DAO.Ejemplar;
import modelo.DAO.EjemplarDAO;
import modelo.DAO.Libro;
import modelo.DAO.LibroDAO;
import modelo.DAO.Prestamo;
import modelo.DAO.PrestamoDAO;
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
	private PrestamoDAO prestamoDAO;
	private List<Prestamo> listaPrestamos;
	
	private static String tipoObjeto = "";
	
	
	
	public Controlador(Vista vista, SocioDAO socioDAO, LibroDAO libroDAO, EjemplarDAO ejemplarDAO, PrestamoDAO prestamoDAO)
	{
		this.vista 		 = vista;
		this.socioDAO 	 = socioDAO;
		this.libroDAO 	 = libroDAO;
		this.ejemplarDAO = ejemplarDAO;
		this.prestamoDAO = prestamoDAO;
		
		ActionListener(this);
		
		listaSocios 	= socioDAO.getListaSocios();
		listaLibros 	= libroDAO.getListaLibros();
		listaEjemplares = ejemplarDAO.getListaEjemplares();
		listaPrestamos  = prestamoDAO.getListaPrestamos();
	}


	@Override
	public void actionPerformed(ActionEvent e)
	{
		switch(e.getActionCommand())
		{
		case "Añadir": //GENERALIZAR
			
			switch (tipoObjeto)
			{
			case "Libro":
				Libro libroNuevo = generarLibro();
				listaLibros.add(libroNuevo);
				Collections.sort(listaLibros);
				libroDAO.addLibro(libroNuevo);
				//limpiarCampos();
				System.out.println("Libro añadido");
				break;
				
			case "Ejemplar":
				Ejemplar ejemplarNuevo = generarEjemplar();
				listaEjemplares.add(ejemplarNuevo);
				//Collections.sort(listaEjemplares);		<- ¿Falta el compareTo?	
				ejemplarDAO.addEjemplar(ejemplarNuevo);
				//limpiarCampos();
				System.out.println("Ejemplar añadido");
				break;
				
			case "Socio":
				Socio socioNuevo = generarSocio();
				listaSocios.add(socioNuevo);
				Collections.sort(listaSocios);
				socioDAO.addSocio(socioNuevo);
				//limpiarCampos();
				System.out.println("Socio añadido");
				break;
				
			case "Préstamo":
				Prestamo prestamoNuevo = generarPrestamo();
				listaPrestamos.add(prestamoNuevo);
				//Collections.sort(listaPrestamos);
				prestamoDAO.addPrestamo(prestamoNuevo);
				//limpiarCampos();
				System.out.println("Préstamo añadido");
			
			default:
				JOptionPane.showMessageDialog(vista, "Para añadir un objeto, primero tienes que hacer esto:\n" + 
									"1. Cargar... (el tipo de objeto que quieras introducir)\n" + 
									"2. Rellenar los campos obligatorios y asegurarte de que son correctos los datos");
				break;
			}
			break; //Salir añadir
			
		case "Borrar":
			Socio socioABorrar = generarSocio();
			int reply = JOptionPane.showConfirmDialog(vista, "¿Seguro que desea borrarlo?", "Confirmación", JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_NO_OPTION) {
					listaSocios.remove(socioABorrar);
					socioDAO.borrarSocio(socioABorrar);
					System.out.println("Socio borrado");
				}
				else
					System.out.println("No ha sido borrado");
			break;
			
		case "Actualizar":
			System.out.println("Socio actualizado");
			break;
			
		case "... Libros":
			setTipoObjeto("Libro");
			mostrarLibro(0);
			break;
			
		case "... Ejemplares":
			setTipoObjeto("Ejemplar");
			mostrarEjemplar(0);
			break;
			
		case "... Socios":
			setTipoObjeto("Socio");
			mostrarSocio(0);
			break;
			
		case "... Préstamos":
			setTipoObjeto("Préstamo");
			mostrarPrestamo(0);
			break;
			
		case "Versión":
			JOptionPane.showMessageDialog(vista, "Versión 0.1");
			break;
			
		case "Créditos":
			JOptionPane.showMessageDialog(vista, "Programa desarrollado por Alejandro Macías Alcázar\n" + 
											"\nMención especial a Ángel por echarme una mano con las dudas");
			break;
			
		default: System.out.println("Error: actionPerformed desconocida");
		
		}
		
	}

	
	private void ActionListener(ActionListener escuchante) {
		
		vista.getBtnAadir()		 .addActionListener(escuchante);
		vista.getBtnActualizar() .addActionListener(escuchante);
		vista.getBtnBorrar()	 .addActionListener(escuchante);
		vista.getMntmLibros()	 .addActionListener(escuchante);
		vista.getMntmEjemplares().addActionListener(escuchante);
		vista.getMntmSocios()	 .addActionListener(escuchante);
		vista.getMntmPrestamos() .addActionListener(escuchante);
		vista.getMntmVersin()	 .addActionListener(escuchante);
		vista.getMntmCrditos()	 .addActionListener(escuchante);
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
	
	private Prestamo generarPrestamo() {
		String dni 				= vista.getTextField_0().getText();
		String isbn 			= vista.getTextField_1().getText();
		String idEjemplar 		= vista.getTextField_2().getText();
		LocalDate fechaPrestamo = pasarDeCadenaAFecha(vista.getTextField_3().getText());
		
		return new Prestamo(dni, isbn, idEjemplar, fechaPrestamo);
	}
	
	private void mostrarSocio(int index) {
		vista.getTextField_0().setText(listaSocios.get(index).getDni());
		vista.getTextField_1().setText(listaSocios.get(index).getNombre());
		vista.getTextField_2().setText(listaSocios.get(index).getApellidos());
		vista.getTextField_3().setText(listaSocios.get(index).getFechaAlta().toString());
	}
	
	private void mostrarLibro(int index) {
		vista.getTextField_0().setText(listaLibros.get(index).getIsbn());
		vista.getTextField_1().setText(listaLibros.get(index).getTitulo());
		vista.getTextField_2().setText(listaLibros.get(index).getAutores());
		vista.getTextField_3().setText(listaLibros.get(index).getTematicas());
	}
	
	private void mostrarEjemplar(int index) {
		vista.getTextField_0().setText(listaEjemplares.get(index).getIdEjemplar() + "");  // "": int -> String (implicit)
		vista.getTextField_1().setText(listaEjemplares.get(index).getIsbn());
		vista.getTextField_2().setText(listaEjemplares.get(index).getEditorial());
		vista.getTextField_3().setText(listaEjemplares.get(index).getEdicion() + "");
	}
	
	private void mostrarPrestamo(int index) {
		vista.getTextField_0().setText(listaPrestamos.get(index).getDni());
		vista.getTextField_1().setText(listaPrestamos.get(index).getIsbn());
		vista.getTextField_2().setText(listaPrestamos.get(index).getIdEjemplar());
		vista.getTextField_3().setText(listaPrestamos.get(index).getFechaPrestamo().toString());
	}
	
	public static void setTipoObjeto(String tipo) {
		tipoObjeto = tipo;
	}
	
	private static LocalDate pasarDeCadenaAFecha(String fecha) {
		return LocalDate.parse(fecha, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}
	
}








