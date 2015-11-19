package edu.dao;

import java.util.List;

import model.Motorista;

public interface IDaoMotorista {
	public void adicionar(Motorista f);

	public void alterar(Motorista f);

	public void remover(Motorista f);

	public List<Motorista> listarPorCpf(int t);

	public List<Motorista> listarPorNome(String t);

	public List<Motorista> listar();
}
