package edu.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import edu.dao.DaoRecebimento;
import edu.dao.IDaoRecebimento;
import model.Recebimento;

public class CtrRecebimento implements TableModel {
	private String[] nomes = { "N.Fiscal", "Destinatario", "Volumes", "Peso",
			"Dt Entrada" };
	private Class<?>[] classes = new Class[] { Integer.class, String.class,
			Integer.class, Double.class, Date.class };
	private List<Recebimento> recebimentos = new ArrayList<Recebimento>();
	private IDaoRecebimento dao = new DaoRecebimento();

	
	public boolean adicionar(Recebimento d) {
		try {
			dao.adicionar(d);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public List<Recebimento> listarPorCliente(String cnpj) {
		recebimentos = dao.listarPorCliente(cnpj);
		return recebimentos;

	}

	public List<Recebimento> listarPorData(Date dataIni, Date dataFim) {
		recebimentos = dao.listarPorData(dataIni, dataFim);
		return recebimentos;
	}

	public List<Recebimento> listarPorStatus(String status) {
		recebimentos=dao.listarPorStatus(status);
		return recebimentos;
	}
	
	public Recebimento getRecebimento(int row) {

		return recebimentos.get(row);
	}

	public void addRecebimentoLista(Recebimento rec) {

		recebimentos.add(rec);
	}

	public Recebimento buscaRecebimento(int nota, String cnpj) {

		return dao.buscarRecebimento(nota, cnpj);

	}
	
	public Recebimento removeRecebimentoLista(int row){
		return recebimentos.remove(row);
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
		return recebimentos.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		Recebimento r = recebimentos.get(linha);
		if (coluna == 0) {
			return r.getNotaFiscal();
		} else if (coluna == 1) {
			return r.getDestinatario();
		} else if (coluna == 2) {
			return r.getVolumes();
		} else if (coluna == 3) {
			return r.getPeso();
		} else if (coluna == 4) {
			return r.getDataEntrada();
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
