package vista;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Vista extends JFrame {
	
	private JTextField textField_0;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	private JButton btnAadir;
	private JButton btnBorrar;
	private JButton btnActualizar;
	private JMenuItem mntmLibros;
	private JMenuItem mntmEjemplares;
	private JMenuItem mntmSocios;
	private JMenuItem mntmPrstamos;
	private JMenuItem mntmVersin;
	private JMenuItem mntmCrditos;



	public JTextField getTextField_0() {
		return textField_0;
	}


	public JTextField getTextField_1() {
		return textField_1;
	}


	public JTextField getTextField_2() {
		return textField_2;
	}


	public JTextField getTextField_3() {
		return textField_3;
	}


	public JTable getTable() {
		return table;
	}


	public JButton getBtnAadir() {
		return btnAadir;
	}


	public JButton getBtnBorrar() {
		return btnBorrar;
	}

	
	public JButton getBtnActualizar() {
		return btnActualizar;
	}

	public JMenuItem getMntmLibros() {
		return mntmLibros;
	}
	
	public JMenuItem getMntmEjemplares() {
		return mntmEjemplares;
	}
	
	public JMenuItem getMntmSocios() {
		return mntmSocios;
	}
	
	public JMenuItem getMntmPrestamos() {
		return mntmPrstamos;
	}
	
	public JMenuItem getMntmVersin() {
		return mntmVersin;
	}
	
	public JMenuItem getMntmCrditos() {
		return mntmCrditos;
	}

	public Vista() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 500);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCargar = new JMenu("Cargar...");
		menuBar.add(mnCargar);
		
		mntmLibros = new JMenuItem("... Libros");
		mnCargar.add(mntmLibros);
		
		mntmEjemplares = new JMenuItem("... Ejemplares");
		mnCargar.add(mntmEjemplares);
		
		mntmSocios = new JMenuItem("... Socios");
		mnCargar.add(mntmSocios);
		
		mntmPrstamos = new JMenuItem("... Préstamos");
		mnCargar.add(mntmPrstamos);
		
		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
		
		mntmVersin = new JMenuItem("Versión");
		mnAbout.add(mntmVersin);
		
		mntmCrditos = new JMenuItem("Créditos");
		mnAbout.add(mntmCrditos);
		
		textField_0 = new JTextField();
		textField_0.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		
		btnAadir = new JButton("Añadir");
		btnBorrar = new JButton("Borrar");
		btnActualizar = new JButton("Actualizar");
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(textField_1)
						.addComponent(textField_0, 286, 286, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(textField_3, Alignment.LEADING)
								.addComponent(textField_2, Alignment.LEADING, 286, 286, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(67)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAadir)
						.addComponent(btnBorrar)
						.addComponent(btnActualizar))
					.addGap(71))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textField_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(14)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnAadir)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnActualizar)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnBorrar)))
					.addGap(49))
		);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
	}
}
