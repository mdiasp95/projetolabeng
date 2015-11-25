package managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import edu.dao.DaoEntrega;
import edu.modelo.Entrega;


@ManagedBean (name = "entregaMB")
@SessionScoped
public class EntregaMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8474376610653221631L;

	private Entrega entrega;
	private DaoEntrega daoEntrega;
	private List<Entrega> lista = new ArrayList<Entrega>();
	
	public Entrega getEntrega() {
		return entrega;
	}

	public void setEntrega(Entrega entrega) {
		this.entrega = entrega;
	}

	public DaoEntrega getDaoEntrega() {
		return daoEntrega;
	}

	public void setDaoEntrega(DaoEntrega daoEntrega) {
		this.daoEntrega = daoEntrega;
	}

	public List<Entrega> getLista() {
		return lista;
	}

	public void setLista(List<Entrega> lista) {
		this.lista = lista;
	}

	public EntregaMB() { 
		entrega = new Entrega();
		daoEntrega = new DaoEntrega();
		 
	}

	public String adicionar() {
		String msg = "Erro ao adicionar o motorista no banco de dados";
			daoEntrega.adicionar( entrega );
			msg = "motorista foi adicionado com sucesso no banco de dados";
			entrega = new Entrega();
			
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage("", new FacesMessage(FacesMessage.SEVERITY_INFO,  msg, ""));
		return "motorista";
	}
	
	public String pesquisar() {
		String msg = "Erro ao pesquisar as entregas no banco de dados";
		lista = daoEntrega.listar();
		msg = "Foram localizados " + lista.size() + " motoristas no banco de dados";		
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage("", new FacesMessage(FacesMessage.SEVERITY_INFO,  msg, ""));
		return "motorista";
	}
}
