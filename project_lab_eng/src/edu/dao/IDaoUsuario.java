package edu.dao;

import edu.modelo.Usuario;

public interface IDaoUsuario {

	public Usuario Pesquisar(String id);
	
	public void adicionar(Usuario u);
}
