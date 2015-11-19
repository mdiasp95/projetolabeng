package edu.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import edu.dao.DaoDespesa;
import edu.dao.IDaoDespesa;
import model.Despesa;

public class CtrDespesa implements TableModel {
	private String[] nomes = { "N.Fiscal", "Placa", "Data", "Valor", "Serviço" };
	private Class<?>[] classes = new Class[] { String.class, String.class,
			Date.class, Double.class, String.class };
	private List<Despesa> despesas = new ArrayList<Despesa>();
	private IDaoDespesa dao = new DaoDespesa();

	public void limparDespesas() {
		despesas = new ArrayList<Despesa>();
	}

	public boolean adicionar(Despesa d) {
		try {
			dao.adicionar(d);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public List<Despesa> listarPorPlaca(String placa) {
		return despesas = dao.listarPorPlaca(placa);
	}

	public List<Despesa> listarPorForn(String cnpj) {
		despesas = dao.listarPorForn(cnpj);
		return despesas;

	}

	public List<Despesa> listarPorData(Date dataIni, Date dataFim) {
		despesas = dao.listarPorData(dataIni, dataFim);
		return despesas;
	}

	public Despesa getDespesa(int row) {

		return despesas.get(row);
	}

	public Despesa buscaDesp(int nota, String cnpj) {

		return dao.buscarDespesa(nota, cnpj);

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
		return despesas.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		Despesa v = despesas.get(linha);
		if (coluna == 0) {
			return v.getNotaFiscal();
		} else if (coluna == 1) {
			return v.getPlaca();
		} else if (coluna == 2) {
			return v.getDataDespesa();
		} else if (coluna == 3) {
			return v.getValor();
		} else if (coluna == 4) {
			return v.getTipo();
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
