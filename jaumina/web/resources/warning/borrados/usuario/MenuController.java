package jaumina.entidades.usuario;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


@ManagedBean
@SessionScoped
public class MenuController implements Serializable {
	/**
	* Asuncion - Paraguay 
	* 18/07/2016
	* @author Diego Manuel Benitez Enciso
	*/
	private static final long serialVersionUID = -379177221533494416L;
	private String usuarioLogeado = null;
	@SuppressWarnings("unused")
	private Usuario user = null;
public Usuario getUser() {
		return 
				(Usuario) FacesContext
				.getCurrentInstance()
				.getExternalContext()
				.getSessionMap()
				.get("usuario");
	}
	public void setUser(Usuario user) {
		this.user = user;
	}
public String getUsuarioLogeado() {
	Usuario us =
			(Usuario) FacesContext
			.getCurrentInstance()
			.getExternalContext()
			.getSessionMap()
			.get("usuario");
	usuarioLogeado = us.getUsername();
		return usuarioLogeado;
	}
	public void setUsuarioLogeado(String usuarioLogeado) {
		this.usuarioLogeado = usuarioLogeado;
	}

public void cerrarSesion() {
	FacesContext.getCurrentInstance()
	.getExternalContext().invalidateSession();}

public String mostrarUsuarioLogeado() {
	Usuario us =
(Usuario) FacesContext
.getCurrentInstance()
.getExternalContext()
.getSessionMap()
.get("usuario");
	return us.getUsername();}}