package edu.dao;

import edu.modelo.Usuario;

public class TesteDao {

	public static void main(String[] args) {
		TesteDao teste = new TesteDao();
		teste.testePesquisaUsuario();
	}
	
	//OK
	public void testeAdicionaUsuario(){
		Usuario u = new Usuario();
		u.setUserid("matheus");
		u.setSenha("12345");
		IDaoUsuario d = new DaoUsuario();
		d.adicionar(u);
	}
	
	//OK
	public void testePesquisaUsuario(){
		Usuario u = new DaoUsuario().Pesquisar("matheus");
		System.out.println(u.getUserid() +"  " +u.getSenha());
	}
	
}
