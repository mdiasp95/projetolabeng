package managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import edu.dao.DaoCliente;
import edu.modelo.Cliente;

@ManagedBean (name = "clienteMB")
@SessionScoped
public class ClienteMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Cliente cliente;
	private DaoCliente daoUsuario;
	private List<Cliente> lista = new ArrayList<Cliente>();
	
	public ClienteMB() { 
		cliente = new Cliente();
		daoUsuario = new DaoCliente();
		 
	}

	public Cliente getUsuario() {
		return cliente;
	}

	public void setCliente(Cliente cli) {
		this.cliente = cli;
	}
	public String adicionar() {
		String msg = "Erro ao adicionar o cliente no banco de dados";
			daoUsuario.adicionar( cliente );
			msg = "Cliente foi adicionado com sucesso no banco de dados";
			cliente = new Cliente();
			
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage("", new FacesMessage(FacesMessage.SEVERITY_INFO,  msg, ""));
		return "cliente";
	}
	
	public String atualizar(){
		String msg = "Erro ao atualizar o cliente no banco de dados";
			daoUsuario.alterar(cliente);
			msg = "cliente foi alterado com sucesso no banco de dados";
			cliente = new Cliente();
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage("", new FacesMessage(FacesMessage.SEVERITY_INFO,  msg, ""));
			return "cliente";
			
	}
	
	public String pesquisar() {
		String msg = "Erro ao pesquisar o animal no banco de dados";
		lista = daoUsuario.listar();
		msg = "Foram localizados " + lista.size() + " Clientes no banco de dados";		
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage("", new FacesMessage(FacesMessage.SEVERITY_INFO,  msg, ""));
		return "cliente";
	}
	
	public String buscarPorCnpj(){
		String msg = "Nenhum CNPJ encontrado";
		lista = daoUsuario.listarPorCnpj(cliente.getCnpj());
		if(lista.size()>0){
			cliente = lista.get(0);
			msg = "";
		}
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage("", new FacesMessage(FacesMessage.SEVERITY_INFO,  msg, ""));
		return "cliente";
		
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setAnimalAtual(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public List<Cliente> getLista() {
		return lista;
	}
	public void setLista(List<Cliente> lista) {
		this.lista = lista;
	}
	
}