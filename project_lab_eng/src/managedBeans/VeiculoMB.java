package managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


import edu.dao.DaoVeiculo;
import edu.modelo.Veiculo;


@ManagedBean (name = "veiculoMB")
@SessionScoped
public class VeiculoMB  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Veiculo veicAtual;
	private DaoVeiculo daoVeiculo;
	private List<Veiculo> lista = new ArrayList<Veiculo>();
	
	
	public Veiculo getVeicAtual() {
		return veicAtual;
	}

	public void setVeicAtual(Veiculo veicAtual) {
		this.veicAtual = veicAtual;
	}

	public DaoVeiculo getDaoVeiculo() {
		return daoVeiculo;
	}

	public void setDaoVeiculo(DaoVeiculo daoVeiculo) {
		this.daoVeiculo = daoVeiculo;
	}

	public List<Veiculo> getLista() {
		return lista;
	}

	public void setLista(List<Veiculo> lista) {
		this.lista = lista;
	}

	public VeiculoMB() { 
		veicAtual = new Veiculo();
		daoVeiculo = new DaoVeiculo();
		 
	}

	public String adicionar() {
		String msg = "Erro ao adicionar o cliente no banco de dados";
			daoVeiculo.adicionar( veicAtual );
			msg = "Cliente foi adicionado com sucesso no banco de dados";
			veicAtual = new Veiculo();
			
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage("", new FacesMessage(FacesMessage.SEVERITY_INFO,  msg, ""));
		return "veiculo";
	}
	
	
	public String pesquisar() {
		String msg = "Erro ao pesquisar veiculls no banco de dados";
		lista = daoVeiculo.listar();
		msg = "Foram localizados " + lista.size() + " Clientes no banco de dados";		
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage("", new FacesMessage(FacesMessage.SEVERITY_INFO,  msg, ""));
		return "animais";
	}
	
	
}