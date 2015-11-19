package edu.dao;

import java.util.Date;
import java.util.List;

import model.Recebimento;

public interface IDaoRecebimento {

	public void adicionar(Recebimento receb);	

	public List<Recebimento> listarPorCliente(String cli);

	public List<Recebimento> listarPorData(Date dataIni, Date dataFim);
	
	public List<Recebimento> listarPorStatus(String status);
	
	public Recebimento buscarRecebimento(int nota, String cnpj);
}
