package controlador;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import modelo.DAO.EjemplarDAO;

public class TableModeEjemplares extends AbstractTableModel implements TableModelListener{
	private static String[] nombresDeColumna = 
	{
			"ID",
            "ISBN",
            "Editorial",
            "Edición"
    };

	private static Object[][] data = { EjemplarDAO.listaAMatriz(new EjemplarDAO().getListaEjemplares()) };

	
	public TableModeEjemplares() {
		addTableModelListener(this);
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
        TableModeLibros modelo = (TableModeLibros)e.getSource();
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










