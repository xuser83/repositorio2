package jaumina.entidades.usuario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import jaumina.commons.util.MensajesController;
import jaumina.commons.util.MensajesUtil;

@ManagedBean
@SessionScoped
public class IndexController implements Serializable {
	/**
	* Asuncion - Paraguay 
	* 07-04-2018
	* Clase copiada de irp_morci
	* @author Diego Manuel Benitez Enciso
	*/
	
	private static final long serialVersionUID = -1115977600582280578L;

	private Usuario usuario;
	private MensajesUtil m = new MensajesController();

	public IndexController () {
	this.setUsuario(new Usuario());}

	public Usuario getUsuario() {
	return usuario;}

	public void setUsuario(Usuario usuario) {
	this.usuario = usuario;}

	public List<Usuario> completeUsuario(String user) throws Exception {
		
		List<Usuario> listaUsuariosBuscados = new ArrayList<Usuario>();
		
		try { UsuarioRN urn = new UsuarioRN();
		
		if(user != null) {
listaUsuariosBuscados = urn.listarUsuariosPorUserName(user); 
		}
if(listaUsuariosBuscados == null) {
	listaUsuariosBuscados = new ArrayList<Usuario>();
}
	
	}
		catch(Exception e) {
	m.mostrarMensajeError("Error al listar Clientes! " + e.getMessage());
	m.escribirArchivo("Clase: RegistroVentas, "
			+ "Línea: , Método: completeCliente, Exception: " + e.getMessage());
		}
	return listaUsuariosBuscados;
	}

	
	public String iniciarSesion() {
	String redireccion = null;
	UsuarioRN usuarioRN = new UsuarioRN();
	Usuario us;
	try {
		us = usuarioRN.iniciarSesion(usuario);
		if(us != null) {
FacesContext.getCurrentInstance().getExternalContext()
.getSessionMap().put("usuario", us);
		redireccion = "/protegido/inicio?faces-redirect=true";}
		else {
			FacesContext.getCurrentInstance()
			.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_WARN, 
					"Aviso","Credenciales Incorrectas"));
		}
	} catch (Exception e) {
		FacesContext.getCurrentInstance()
		.addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_INFO, 
				"Aviso","Error al iniciar session: " + e.getMessage()));}
	return redireccion;}}
