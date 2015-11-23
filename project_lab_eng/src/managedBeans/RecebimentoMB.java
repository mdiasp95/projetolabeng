package managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import edu.dao.DaoRecebimento;
import edu.modelo.Entrega;
import edu.modelo.Recebimento;

@ManagedBean (name = "entregaMB")
@SessionScoped
public class RecebimentoMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Recebimento recebimento;
	private DaoRecebimento daoRecebimento;
	private List<Recebimento> lista = new ArrayList();
	

	public RecebimentoMB(){
		recebimento = new Recebimento();
		daoRecebimento = new DaoRecebimento();
	}
		public String adicionar(){
			String msg = "Erro ao adicionar o recebimento no banco de dados";
				daoRecebimento.adicionar( recebimento );
				msg = "recebimento foi adicionado com sucesso no banco de dados";
				recebimento = new Recebimento();
				
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage("", new FacesMessage(FacesMessage.SEVERITY_INFO,  msg, ""));
			return "recebimento";
		}
		
		public String pesquisar() {
			String msg = "Erro ao pesquisar os recebimentos no banco de dados";
//			lista = daoRecebimento
			msg = "Foram localizados " + lista.size() + " motoristas no banco de dados";		
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage("", new FacesMessage(FacesMessage.SEVERITY_INFO,  msg, ""));
			return "recebimento";
		}
			
}
