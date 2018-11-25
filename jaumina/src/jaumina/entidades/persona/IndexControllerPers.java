package jaumina.entidades.persona;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class IndexControllerPers implements Serializable {
	
	private static final long serialVersionUID = 5192411076260117521L;
	/**
	* 27-07-2018 Luque - Paraguay 
	* @author Diego Manuel Benitez Enciso
	*/
	
	

	private Persona persona;

	public IndexControllerPers () {
	this.setPersona(new Persona());}

	public Persona getPersona() {
	return persona;}

	public void setPersona(Persona persona) {
	this.persona = persona;}

		public String iniciarSesion() {
	String redireccion = null;
	PersonaRN personaRN = new PersonaRN();
	Persona us;
	try {
		us = personaRN.iniciarSesion(persona);
		if(us != null) {
			if(us.getActivo()) {
FacesContext.getCurrentInstance().getExternalContext()
.getSessionMap().put("persona", us);
		redireccion = "/protegido/inicio?faces-redirect=true";} else {
			FacesContext.getCurrentInstance()
			.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_WARN, 
					"Aviso","Usuario Inactivo!"));
		}}
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
//private MensajesUtil m = new MensajesController();

/*public List<Persona> completePersona(String user) throws Exception {

List<Persona> listaPersonasBuscados = new ArrayList<Persona>();

try { PersonaRN urn = new PersonaRN();

if(user != null) {
listaPersonasBuscados = urn.listarPersonasPorUserName(user); 
}
if(listaPersonasBuscados == null) {
listaPersonasBuscados = new ArrayList<Persona>();
}

}
catch(Exception e) {
m.mostrarMensajeError("Error al listar Clientes! " + e.getMessage());
m.escribirArchivo("Clase: RegistroVentas, "
	+ "Línea: , Método: completeCliente, Exception: " + e.getMessage());
}
return listaPersonasBuscados;
}*/


