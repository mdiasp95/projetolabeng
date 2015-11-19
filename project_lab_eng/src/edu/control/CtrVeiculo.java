package edu.control;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import edu.dao.DaoVeiculo;
import edu.dao.IDaoVeiculo;
import model.Veiculo;

public class CtrVeiculo implements TableModel {
	private String[] nomes = { "Placa", "Modelo", "Status" }; 
	private Class<?>[] classes = new Class[] { String.class, String.class, String.class };
	private List<Veiculo> veiculos = new ArrayList<Veiculo>();
	private IDaoVeiculo dao = new DaoVeiculo();

	public boolean adicionar(Veiculo v) {
		try {
			dao.adicionar(v);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean alterar(Veiculo v) {
		try {
			dao.alterar(v);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void remover() {

	}

	public List<Veiculo> listar() {
		return veiculos = dao.listar();
	}

	public List<Veiculo> listarPorPlaca(String placa) {
		veiculos = dao.listarPorPlaca(placa);
		return veiculos;

	}

	public List<Veiculo> listarPorStatus(String status) {
		veiculos = dao.listarPorStatus(status);
		return veiculos;

	}

	public Veiculo getVeiculo(String placa) {
		listarPorPlaca(placa);
		if (!veiculos.isEmpty()) {
			return veiculos.get(0);
		}
		return null;
	}
	
	public List<String> listarPlacasAtivas() {
		return dao.listarPlacasAtivas();
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
		return veiculos.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		Veiculo v = veiculos.get(linha);
		if (coluna == 0) {
			return v.getPlaca();
		} else if (coluna == 1) {
			return v.getModelo();
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
