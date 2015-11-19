package edu.control;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import edu.dao.DaoFornecedor;
import edu.dao.IDaoFornecedor;
import model.Fornecedor;

public class CtrFornecedor implements TableModel {
	private String[] nomes = { "Cnpj", "Razão", "Status" }; 
	private Class<?>[] classes = new Class[] { String.class, String.class, String.class };
	private List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
	private IDaoFornecedor dao = new DaoFornecedor();
	

	
	public boolean adicionar(Fornecedor p) {
		try {
			dao.adicionar(p);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean alterar(Fornecedor p) {
		try {
			dao.alterar(p);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void remover() {

	}

	public List<Fornecedor> listar() {
		return fornecedores = dao.listar();
	}

	public List<Fornecedor> listarPorCnpj(String cnpj) {
		fornecedores = dao.listarPorCnpj(cnpj);
		return fornecedores;

	}

	public List<Fornecedor> listarPorRazao(String razao) {
		fornecedores = dao.listarPorRazao(razao);
		return fornecedores;
	}

	public Fornecedor getFornecedor(int row) {
		if (!fornecedores.isEmpty()) {
			return fornecedores.get(row);
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
		return fornecedores.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		Fornecedor v = fornecedores.get(linha);
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
