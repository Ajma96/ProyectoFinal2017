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


	public Vista() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCargar = new JMenu("Cargar...");
		menuBar.add(mnCargar);
		
		JMenuItem mntmLibros = new JMenuItem("... Libros");
		mnCargar.add(mntmLibros);
		
		JMenuItem mntmEjemplares = new JMenuItem("... Ejemplares");
		mnCargar.add(mntmEjemplares);
		
		JMenuItem mntmSocios = new JMenuItem("... Socios");
		mnCargar.add(mntmSocios);
		
		JMenuItem mntmPrstamos = new JMenuItem("... Préstamos");
		mnCargar.add(mntmPrstamos);
		
		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
		
		JMenuItem mntmVersin = new JMenuItem("Versión");
		mnAbout.add(mntmVersin);
		
		JMenuItem mntmCrditos = new JMenuItem("Créditos");
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
		
		JButton btnAadir = new JButton("Añadir");
		
		JButton btnBorrar = new JButton("Borrar");
		
		JButton btnActualizar = new JButton("Actualizar");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(48)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(textField_0, Alignment.LEADING)
								.addComponent(textField_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
								.addComponent(textField_2, Alignment.LEADING)
								.addComponent(textField_3, Alignment.LEADING)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(btnAadir)
							.addGap(18)
							.addComponent(btnBorrar))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(55)
							.addComponent(btnActualizar)))
					.addGap(48))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(40)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(32)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnAadir)
								.addComponent(btnBorrar))
							.addGap(18)
							.addComponent(btnActualizar)))
					.addGap(15))
		);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
	}
}
