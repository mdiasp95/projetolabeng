package managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import edu.dao.DaoRecebimento;
import edu.modelo.Recebimento;

@ManagedBean (name = "recebimentoMB")
@SessionScoped
public class RecebimentoMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Recebimento recebimento;
	private DaoRecebimento daoRecebimento;
	private List<Recebimento> lista = new ArrayList<Recebimento>();
	

	public Recebimento getRecebimento() {
		return recebimento;
	}
	public void setRecebimento(Recebimento recebimento) {
		this.recebimento = recebimento;
	}
	public DaoRecebimento getDaoRecebimento() {
		return daoRecebimento;
	}
	public void setDaoRecebimento(DaoRecebimento daoRecebimento) {
		this.daoRecebimento = daoRecebimento;
	}
	public List<Recebimento> getLista() {
		return lista;
	}
	public void setLista(List<Recebimento> lista) {
		this.lista = lista;
	}
	public RecebimentoMB(){
		recebimento = new Recebimento();
		daoRecebimento = new DaoRecebimento();
	}
		public void adicionar(){
			String msg = "Erro ao adicionar o recebimento no banco de dados";
			recebimento.setDataEntrada(new Date());
				daoRecebimento.adicionar( recebimento );
				msg = "recebimento foi adicionado com sucesso no banco de dados";
				recebimento = new Recebimento();
				
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage("", new FacesMessage(FacesMessage.SEVERITY_INFO,  msg, ""));
		
		}
		
		public void atualizar(){
			
			recebimento.setDataEntrada(new Date());
				daoRecebimento.atualizar( recebimento );
				recebimento = new Recebimento();
				String msg = "atualizado com sucesso";
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage("", new FacesMessage(FacesMessage.SEVERITY_INFO,  msg, ""));
		
		}

		public void buscarPorNota(){
			String msg = "Nenhuma nota encontrada";
			if(daoRecebimento.buscarRecebimento(recebimento.getNotaFiscal())!=null){
				recebimento = daoRecebimento.buscarRecebimento(recebimento.getNotaFiscal());
				msg = ""; 
			}
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage("", new FacesMessage(FacesMessage.SEVERITY_INFO,  msg, ""));
			
			
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
