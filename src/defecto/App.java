package defecto;

import java.awt.EventQueue;

import controlador.Controlador;
import modelo.DAO.EjemplarDAO;
import modelo.DAO.LibroDAO;
import modelo.DAO.SocioDAO;
import vista.Vista;

public class App {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista frame = new Vista();
					SocioDAO socioDAO = new SocioDAO();
					LibroDAO libroDAO = new LibroDAO();
					EjemplarDAO ejemplarDAO = new EjemplarDAO();
					
					new Controlador(frame, socioDAO, libroDAO, ejemplarDAO);
				}
				catch (Exception e) {
					System.out.println("Error: Error al ejecutar main()");
				}
			}
		});
	}
}
