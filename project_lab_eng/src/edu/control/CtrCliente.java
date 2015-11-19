package edu.control;

import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import edu.dao.DaoCliente;
import edu.dao.IDaoCliente;
import edu.modelo.Cliente;


public class CtrCliente implements TableModel {
	private String[] nomes = { "Cnpj", "Razão", "Status" };
	private Class<?>[] classes = new Class[] { String.class, String.class,
			String.class };
	private List<Cliente> clientes = new ArrayList<Cliente>();
	private IDaoCliente dao = new DaoCliente();

	public boolean adicionar(Cliente p) {
		try {
			dao.adicionar(p);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean alterar(Cliente p) {
		try {
			dao.alterar(p);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void remover() {

	}

	public List<Cliente> listar() {
		return clientes = dao.listar();
	}

	public List<Cliente> listarPorCnpj(String cnpj) {
		clientes = dao.listarPorCnpj(cnpj);
		return clientes;

	}

	public List<Cliente> listarPorRazao(String razao) {
		clientes = dao.listarPorRazao(razao);
		return clientes;
	}

	public Cliente getCliente(int row) {
		if (!clientes.isEmpty()) {
			return clientes.get(row);
		}
		return null;
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return classes[columnIndex];
	}

	@Override
	public int getColumnCount() {
		return nomes.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return nomes[columnIndex];
	}

	@Override
	public int getRowCount() {
		return clientes.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		Cliente v = clientes.get(linha);
		if (coluna == 0) {
			return v.getCnpj();
		} else if (coluna == 1) {
			return v.getNome();
		} else if (coluna == 2) {
			return v.getStatus();
		}
		return "";
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub

	}
}
