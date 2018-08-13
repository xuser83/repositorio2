package jaumina.entidades.usuario;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class UsuarioController
implements Serializable {
	/**
	* Asuncion - Paraguay 
	* 17/07/2016
	* @author Diego Manuel Benitez Enciso
	*/
	private static final long serialVersionUID = 5651071482932506068L;
	public UsuarioController() {
		usuario = new Usuario();}
	
	private Usuario usuario;
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
public void registrar() {
	UsuarioRN usuarioRN = new UsuarioRN();
	try {
if(usuario.getCodigo() !=null
&& usuario.getCodigo() != 0) {		
		usuarioRN.modificar(usuario);
		FacesContext.getCurrentInstance()
		.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Aviso","Modificado don Éxito"));
nuevo();} else {
	usuarioRN.guardar(usuario);
	FacesContext.getCurrentInstance()
	.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
			"Aviso","Se Guardó con Éxito!"));
}
	} catch (Exception e) {
		FacesContext.getCurrentInstance()
		.addMessage(null, new FacesMessage(
	FacesMessage.SEVERITY_FATAL, "Aviso","Error: " + e.getMessage()));}}
private void nuevo() {
	
	usuario = new Usuario();
}

public static void mostrarMensaje(	Severity severity,
									String resumen,
									String detalle) {
	FacesContext.getCurrentInstance()
	.addMessage(null, new FacesMessage(
severity, resumen,detalle));
}
}
