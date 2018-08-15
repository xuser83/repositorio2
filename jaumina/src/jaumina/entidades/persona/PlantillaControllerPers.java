package jaumina.entidades.persona;

import java.io.IOException;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
@ManagedBean
@ViewScoped
public class PlantillaControllerPers implements Serializable {
	/**
	* Luque - Paraguay 
	* 28-07-2018
	* @author Diego Manuel Benitez Enciso
	 * https://www.youtube.com/user/xuser83
	* 
	*/
	private static final long serialVersionUID = -4092641556852701862L;

public void verificarSesion() throws IOException {
	try {
		FacesContext context = FacesContext.getCurrentInstance();
	Persona us =	(Persona) context
		.getExternalContext()
		.getSessionMap().get("persona");
	if(us == null) {
		context
		.getExternalContext()
		.redirect("/jaumina/Index.jsf");
	}
	} catch(Exception e) {}finally {}}}
