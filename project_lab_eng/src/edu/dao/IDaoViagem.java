package edu.dao;

import java.util.Date;
import java.util.List;

import edu.modelo.Viagem;



public interface IDaoViagem {

	public void adicionarViagem(Viagem via);
	
	public void atualizar(Viagem via);

	public List<Viagem> listarPorCliente(String cli);

	public List<Viagem> listarPorData(Date dataIni, Date dataFim);
	
	public List<Viagem> listarPorStatus(String status);
	
	public Viagem buscarViagem(int nota, String cnpj);

	
}
