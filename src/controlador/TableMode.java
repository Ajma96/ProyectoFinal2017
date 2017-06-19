package controlador;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import modelo.DAO.EjemplarDAO;
import modelo.DAO.LibroDAO;
import modelo.DAO.PrestamoDAO;
import modelo.DAO.SocioDAO;

@SuppressWarnings("serial")
public class TableMode extends AbstractTableModel implements TableModelListener {
	private static Object[][] data;
	private static String[] nombresDeColumna;
	
	private static String[] nombresColumnaLibro 	= {"ISBN", "Título", "Autores", "Temáticas"};
	private static String[] nombresColumnaEjemplar  = {"ID del ejemplar", "ISBN", "Editorial", "Edición"};
	private static String[] nombresColumnaSocio 	= {"DNI", "Nombre", "Apellidos", "Fecha de alta"};
	private static String[] nombresColumnaPrestamo  = {"DNI", "ISBN", "ID del ejemplar", "Fecha de inicio del préstamo"};
	
	
	
	public TableMode() {
		inicializar();
		addTableModelListener(this);
	}
	
	private static void inicializar() {
		
		switch (Controlador.getTipoObjeto()) {
		
		case "Libro":
			nombresDeColumna = nombresColumnaLibro;
			data = LibroDAO.listaAMatriz(new LibroDAO().getListaLibros());
			
			break;
			
		case "Ejemplar":
			nombresDeColumna = nombresColumnaEjemplar;
			data =  EjemplarDAO.listaAMatriz(new EjemplarDAO().getListaEjemplares());
			
			break;
			
		case "Socio":
			nombresDeColumna = nombresColumnaSocio;
			data = SocioDAO.listaAMatriz(new SocioDAO().getListaSocios());
			
			break;
			
		case "Préstamo":
			nombresDeColumna = nombresColumnaPrestamo;
			data = PrestamoDAO.listaAMatriz(new PrestamoDAO().getListaPrestamos());
			
			break;
			
		default:
			nombresDeColumna = nombresColumnaLibro;
			data = LibroDAO.listaAMatriz(new LibroDAO().getListaLibros());
			
			break;
		}
	}
	
	
	@Override
	public int getColumnCount() {
		return nombresDeColumna.length;
	}

	@Override
	public int getRowCount() {
		return data.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return data[rowIndex][columnIndex];
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if (columnIndex < 1) {
            return false;
        }
		else {
            return true;
        }
	}
	@Override
	public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }
	public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

	@Override
	public void tableChanged(TableModelEvent e) {
		int row = e.getFirstRow(); 
        int column = e.getColumn();
        TableMode modelo = (TableMode)e.getSource();
        String nombreDeColumna = modelo.getColumnName(column);
        Object data = modelo.getValueAt(row, column);
        System.out.printf("Cambio en la fila %d, en la columna %d,"
        		+ " nuevo valor %S%n", row, column, data);
	}
	
	@Override
	public String getColumnName(int column) {
		return nombresDeColumna[column];
	}
	
}









