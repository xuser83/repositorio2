package jaumina.entidades.persona;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/*Luque 28-07-2018*/
@ManagedBean
@SessionScoped
public class MenuControllerPers implements Serializable {
	
	private static final long serialVersionUID = 2730547848546581003L;
	/**
	* Luque - Paraguay 
	* 28-07-2018
	* @author Diego Manuel Benitez Enciso
	*/
	
	private String usuarioLogeado = null;
	@SuppressWarnings("unused")
	private Persona user = null;
public Persona getUser() {
		return 
				(Persona) FacesContext
				.getCurrentInstance()
				.getExternalContext()
				.getSessionMap()
				.get("persona");
	}
	public void setUser(Persona user) {
		this.user = user;
	}
public String getUsuarioLogeado() {
	Persona us =
			(Persona) FacesContext
			.getCurrentInstance()
			.getExternalContext()
			.getSessionMap()
			.get("persona");
	usuarioLogeado = us.getNombre_corto();
		return usuarioLogeado;
	}
	public void setUsuarioLogeado(String usuarioLogeado) {
		this.usuarioLogeado = usuarioLogeado;
	}

public void cerrarSesion() {
	FacesContext.getCurrentInstance()
	.getExternalContext().invalidateSession();}

public String mostrarUsuarioLogeado() {
	Persona us =
(Persona) FacesContext
.getCurrentInstance()
.getExternalContext()
.getSessionMap()
.get("persona");
	return us.getNombre_corto();}}