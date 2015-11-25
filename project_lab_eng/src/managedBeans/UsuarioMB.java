package managedBeans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import edu.dao.DAOException;
import edu.dao.DaoUsuario;
import edu.dao.IDaoUsuario;
import edu.modelo.Usuario;

@ManagedBean (name = "usuarioMB")
@SessionScoped
public class UsuarioMB {

	private Usuario usuario;
	private boolean logado = false;
	private IDaoUsuario daoUsuario;

	public UsuarioMB() {
		usuario = new Usuario();
		daoUsuario = new DaoUsuario();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String login() { 
		String msg = "";
		Usuario u = daoUsuario.Pesquisar(usuario.getUserid());
				if (u.getUserid().equals( usuario.getUserid() ) &&
						u.getSenha().equals(usuario.getSenha())){
					setLogado(true);
					return "index.xhtml";
				} else { 
					setLogado(false);
					msg = "Usuario ou senha inválidos";
				}

		msg = "Erro no acesso ao database";
	 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(msg));return"";

	}

	public boolean isLogado() {
		return logado;
	}

	public void setLogado(boolean logado) {
		this.logado = logado;
	}

}
