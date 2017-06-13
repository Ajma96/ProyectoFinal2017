package defecto;

import java.awt.EventQueue;


import vista.Vista;

public class App {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista frame = new Vista();
					/*
					 * Vista frame = new Vista();
					 * UserDAO userDAO = new UserDAO();
					 * new Controlador(frame, userDAO);
					 */
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
