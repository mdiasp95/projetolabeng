package edu.dao;

import java.util.Date;
import java.util.List;

import javax.swing.plaf.synth.SynthSeparatorUI;

import edu.modelo.Cliente;
import edu.modelo.Destinatario;
import edu.modelo.Entrega;
import edu.modelo.Motorista;
import edu.modelo.Recebimento;
import edu.modelo.Remetente;
import edu.modelo.Usuario;
import edu.modelo.Veiculo;
import edu.modelo.Viagem;

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
//		teste.testeAdicionaEntrega();
//		teste.testeDeletarEntrega();
//		teste.testeAdicionarMotorista();
//		teste.testeAlterarMotorista();
//		teste.testeRemoverMotorista();
//		teste.testeBuscarMotorista();
//		teste.testeBuscarMotoristaporCNH();
//		teste.testeAdicionarRecebimento();
//		teste.testeBuscarRecebimento();
//		teste.testeAdicionarVeiculo();
//		teste.testeAlterarVeiculo();
//		teste.testeremoverVeiculo();
//		teste.testeBuscarVeiculoPorPlaca();
//		teste.testeAdicionarViagem();
		System.out.println(new Date());
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
	public void testeAlteraCliente(){
		Cliente c = new Cliente();
		IDaoCliente id = new DaoCliente();
		c.setCnpj("12345");
		c.setNome("N4353535");
		id.alterar(c);
	}
	public void testeDeletarCliente(){
		Cliente c = new Cliente();
		IDaoCliente id = new DaoCliente();
		c.setCnpj("12345");
		c.setNome("Novo Teste");
		id.remover(c);
	}
	public void testelistarClienteporCNPJ(){
		IDaoCliente id = new DaoCliente();
		List <Cliente> cliente = id.listarPorCnpj("12345");
		System.out.println(cliente.toString());
		List<Cliente> dd = id.listar();
		System.out.println(dd.toString());
		}
	
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

	public void testeAdicionaEntrega(){
		Entrega e = new Entrega();
		Recebimento r = new Recebimento();
		r.setNotaFiscal(1111);
		r.setRemetente(new Remetente("11111"));
		e.setDataRetorno(new Date());
		e.setDataSaida(new Date());
		e.setObservacao("Observacao");
		e.setRecebimento(r);
		IDaoEntrega g = new DaoEntrega();
		g.adicionar(e);
	}
	public void testeAlterarEntrega(){
		Entrega e = new Entrega();
		Recebimento r = new Recebimento();
		r.setNotaFiscal(1111);
		r.setRemetente(new Remetente("11111"));
		e.setDataRetorno(new Date());
		e.setDataSaida(new Date());
		e.setObservacao("Mudando a Observacao");
		e.setRecebimento(r);
		IDaoEntrega g = new DaoEntrega();
		g.alterar(e);
	}

	public void testeDeletarEntrega(){
		Entrega e = new Entrega();
		Recebimento r = new Recebimento();
		r.setNotaFiscal(1111);
		r.setRemetente(new Remetente("11111"));
		e.setDataRetorno(new Date());
		e.setDataSaida(new Date());
		e.setObservacao("Mudando a Observacao");
		e.setRecebimento(r);
		IDaoEntrega g = new DaoEntrega();
//		g.adicionar(e);
		g.remover(e);
	}

	public void testeAdicionarMotorista(){
		Motorista m = new Motorista();
		m.setCnh("123456789");
		m.setNome("Edvaldo");
		m.setMopp(true);
		m.setVencimento(new Date());
		m.setDtCadastro(new Date());
		IDaoMotorista d = new DaoMotorista();
		d.adicionar(m);
	
	}
	public void testeAlterarMotorista(){
		Motorista m = new Motorista();
		m.setCnh("123456789");
		m.setNome("Kathleen");
		m.setMopp(false);
		m.setVencimento(new Date());
		m.setDtCadastro(new Date());
		IDaoMotorista d = new DaoMotorista();
		d.alterar(m);
	}
	public void testeRemoverMotorista(){
		Motorista m = new Motorista();
		m.setCnh("123456789");
		m.setNome("Kathleen");
		m.setMopp(false);
		m.setVencimento(new Date());
		m.setDtCadastro(new Date());
		IDaoMotorista d = new DaoMotorista();
		d.remover(m);
	}
	public void testeBuscarMotorista(){
/*		Motorista m = new Motorista();
		m.setCnh("123456789");
		m.setNome("Kathleen");
		m.setMopp(false);
		m.setVencimento(new Date());
		m.setDtCadastro(new Date());*/
		IDaoMotorista d = new DaoMotorista();
/*		d.adicionar(m);
		m.setCnh("655652");
		m.setNome("Matheus");
		d.adicionar(m);
		*/
		List<Motorista> ms= d.listar();
		System.out.println(ms.size());
	}
	public void testeBuscarMotoristaporCNH(){
/*		Motorista m = new Motorista();
		m.setCnh("123456789");
		m.setNome("Kathleen");
		m.setMopp(false);
		m.setVencimento(new Date());
		m.setDtCadastro(new Date());*/
		IDaoMotorista d = new DaoMotorista();
/*		d.adicionar(m);
		m.setCnh("655652");
		m.setNome("Matheus");
		d.adicionar(m);
		*/
		Motorista m= d.BuscarPorCNH("123456789");
		System.out.println(m.getCnh() + m.getNome());
	}

	public void testeAdicionarRecebimento(){
		Recebimento r = new Recebimento();
		r.setDataEntrada(new Date());
		r.setNotaFiscal(5454);
		r.setDestinatario(new Destinatario("5555"));
		r.setRemetente(new Remetente("11111"));
		IDaoRecebimento d = new DaoRecebimento();
		d.adicionar(r);
	}
	
	public void testeBuscarRecebimento(){
		IDaoRecebimento d = new DaoRecebimento();
		Recebimento r = d.buscarRecebimento(5454);
		System.out.println(r.getNotaFiscal() + r.getCnpjDestinatario());
	}
	
	public void testeAdicionarVeiculo(){
		Veiculo v = new Veiculo();
		v.setPlaca("CRS8096");
		v.setMarca("Volks");
		IDaoVeiculo d = new DaoVeiculo();
		d.adicionar(v);
	}
	public void testeAlterarVeiculo(){
		Veiculo v = new Veiculo();
		v.setPlaca("CRS8096");
		v.setMarca("FIAT");
		IDaoVeiculo d = new DaoVeiculo();
		d.alterar(v);
	}
	
	public void testeremoverVeiculo(){
		IDaoVeiculo d = new DaoVeiculo();
		Veiculo v = new Veiculo();
		v.setPlaca("CRS8096");
		d.remover(v);
	}
	
	public void testeBuscarVeiculoPorPlaca(){
		IDaoVeiculo d = new DaoVeiculo();
		List<Veiculo> v = d.listarPorPlaca("crs8096");
		System.out.println(v.size());
	}
	public void testeAdicionarViagem(){
		Viagem v = new Viagem();
		v.setDataChegada(new Date());
		v.setDataSaida(new Date());
		v.setMotorista(new DaoMotorista().BuscarPorCNH("123456789"));
		v.setVeiculo(new DaoVeiculo().listarPorPlaca("CRS8096").get(0));
		IDaoViagem d = new DaoViagem();
		d.adicionarViagem(v);
	}
}
