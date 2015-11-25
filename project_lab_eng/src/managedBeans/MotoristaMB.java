package managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import edu.dao.DaoMotorista;
import edu.modelo.Motorista;


@ManagedBean (name = "motoristaMB")
@SessionScoped
public class MotoristaMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Motorista motorista;
	private DaoMotorista daoUsuario;
	private List<Motorista> lista = new ArrayList<Motorista>();
	
	public MotoristaMB() { 
		motorista = new Motorista();
		daoUsuario = new DaoMotorista();
		 
	}

	public String adicionar() {
		String msg = "Erro ao adicionar o motorista no banco de dados";
			daoUsuario.adicionar( motorista );
			msg = "motorista foi adicionado com sucesso no banco de dados";
			motorista = new Motorista();
			
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage("", new FacesMessage(FacesMessage.SEVERITY_INFO,  msg, ""));
		return "motorista";
	}
	
	public String pesquisar() {
		String msg = "Erro ao pesquisar o animal no banco de dados";
		lista = daoUsuario.listar();
		msg = "Foram localizados " + lista.size() + " motoristas no banco de dados";		
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage("", new FacesMessage(FacesMessage.SEVERITY_INFO,  msg, ""));
		return "motorista";
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

	public DaoMotorista getDaoUsuario() {
		return daoUsuario;
	}

	public void setDaoUsuario(DaoMotorista daoUsuario) {
		this.daoUsuario = daoUsuario;
	}

	public List<Motorista> getLista() {
		return lista;
	}

	public void setLista(List<Motorista> lista) {
		this.lista = lista;
	}
	
	
}