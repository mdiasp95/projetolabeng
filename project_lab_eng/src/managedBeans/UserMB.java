package managedBeans;


import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import edu.dao.DAOException;


@ManagedBean
@SessionScoped
public class UserMB {
	
	private Usuario usuario;
	private boolean logado = false;
	private DAOImpl<Usuario> daoUsuario;
	
	public UserMB() { 
		usuario = new Usuario();
		daoUsuario = new DAOImpl<Usuario>(Usuario.class, "userid");
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String login() { 
		String msg = "";
		try {
			List<Usuario> lista = daoUsuario.pesquisar( usuario.getUserid() );
			if (lista != null && lista.size() > 0) { 
				Usuario u = lista.get(0);
				if (u.getUserid().equals( usuario.getUserid() ) &&
						u.getPassword().equals( usuario.getPassword() ) ) {
					setLogado(true);
					return "animais.xhtml";
				} else { 
					setLogado(false);
					msg = "Usuario ou senha inválidos";
				}
			} else { 
				setLogado(false);
				msg = "Usuario ou senha inválidos";
			}
		} catch (DAOException e) {
			msg = "Erro no acesso ao database";
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(msg) );
		return "";
	}

	public boolean isLogado() {
		return logado;
	}

	public void setLogado(boolean logado) {
		this.logado = logado;
	}

}
