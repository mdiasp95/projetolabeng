package edu.dao;

import java.util.List;

import javax.swing.plaf.synth.SynthSeparatorUI;

import edu.modelo.Cliente;
import edu.modelo.Destinatario;
import edu.modelo.Usuario;

public class TesteDao {

	public static void main(String[] args) {
		TesteDao teste = new TesteDao();
//		teste.testeAdicionaUsuario();
//		teste.testePesquisaUsuario();
//		teste.testeAdicionaCliente();
//		teste.testeAlteraCliente();
//		teste.testeDeletarCliente();
//		teste.testelistarClienteporCNPJ();
//		teste.testeAdicionaDestinatario();
//      teste.testeDeletarDestinatario();
//		teste.testeAlteraDestinatario();
//		teste.testeSelecionarDestinatario();
	 }
	
	//OK
	public void testeAdicionaUsuario(){
		Usuario u = new Usuario();
		u.setUserid("matheus");
		u.setSenha("12345");
		IDaoUsuario d = new DaoUsuario();
		d.adicionar(u);
	}
	public void testePesquisaUsuario(){
		Usuario u = new DaoUsuario().Pesquisar("matheus");
		System.out.println(u.getUserid() +"  " +u.getSenha());
	}
	//OK
	public void testeAdicionaCliente(){
		Cliente c = new Cliente();
		c.setCnpj("12345");
		c.setNome("Teste");
		IDaoCliente id = new DaoCliente();
		id.adicionar(c);
	}
	
	//OK
	public void testeAlteraCliente(){
		Cliente c = new Cliente();
		IDaoCliente id = new DaoCliente();
		c.setCnpj("12345");
		c.setNome("Novo Teste");
		id.alterar(c);
	}
	//OK
	public void testeDeletarCliente(){
		Cliente c = new Cliente();
		IDaoCliente id = new DaoCliente();
		c.setCnpj("12345");
		c.setNome("Novo Teste");
		id.remover(c);
	}
	
	//OK
	public void testelistarClienteporCNPJ(){
		IDaoCliente id = new DaoCliente();
		List <Cliente> cliente = id.listarPorCnpj("12345");
		System.out.println(cliente.toString());
		List<Cliente> dd = id.listar();
		System.out.println(dd.toString());
		}

	//OK
	public void testeAdicionaDestinatario(){
		Destinatario d = new Destinatario("12345");
		d.setContato("r=teste");
		IDaoDestinatario g = new DaoDestinatario();
		g.adicionar(d);
	}
	public void testeAlteraDestinatario(){
		Destinatario d = new Destinatario("12345");
		d.setContato("teste");
		d.setServProd("servidorao");
		d.setObservacao("blablahdiwhaf");
		IDaoDestinatario g = new DaoDestinatario();
		g.alterar(d);
	}
	public void testeDeletarDestinatario(){
		Destinatario d = new Destinatario("12345");
		IDaoDestinatario g = new DaoDestinatario();
		g.remover(d);
	}
	public void testeSelecionarDestinatario(){
		IDaoDestinatario g = new DaoDestinatario();
		Destinatario d = g.selecionar("12345");
		System.out.println(d.getCnpj() + d.getContato() + d.getObservacao());
		
	}
}
