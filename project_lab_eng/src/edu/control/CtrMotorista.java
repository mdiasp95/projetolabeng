package edu.control;

import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import edu.dao.DaoMotorista;
import edu.dao.IDaoMotorista;
import model.Motorista;

public class CtrMotorista implements TableModel {
	private String[] nomes = { "CPF", "Nome", "Status" };
	private Class<?>[] classes = new Class[] { String.class, String.class,
			String.class };
	private List<Motorista> motoristas = new ArrayList<Motorista>();
	private IDaoMotorista dao = new DaoMotorista();

	public boolean adicionar(Motorista p) {
		try {
			dao.adicionar(p);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean alterar(Motorista p) {
		try {
			dao.alterar(p);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void remover() {

	}

	public List<Motorista> listar() {
		return motoristas = dao.listar();
	}

	public List<Motorista> listarPorCnpj(int cpf) {
		motoristas = dao.listarPorCpf(cpf);
		return motoristas;

	}

	public List<Motorista> listarPorNome(String nome) {
		motoristas = dao.listarPorNome(nome);
		return motoristas;
	}

	public Motorista getMotorista(int cpf) {
		listarPorCnpj(cpf);
		if (!motoristas.isEmpty()) {
			return motoristas.get(0);
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
		return motoristas.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		Motorista v = motoristas.get(linha);
		if (coluna == 0) {
			return v.getCpf();
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
