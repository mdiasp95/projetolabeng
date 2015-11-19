package edu.dao;

import java.util.List;

import model.Cliente;

public interface IDaoCliente {
	public void adicionar(Cliente f);

	public void alterar(Cliente f);

	public void remover(Cliente f);

	public List<Cliente> listarPorCnpj(String t);

	public List<Cliente> listarPorRazao(String t);

	public List<Cliente> listar();
}
