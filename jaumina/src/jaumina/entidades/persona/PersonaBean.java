package jaumina.entidades.persona;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import jaumina.commons.util.MensajesController;
import jaumina.commons.util.MensajesUtil;

/**
 * @author Diego Benitez
 * 
 * Ciudad de Luque, Paraguay
 * martes 24-07-2018
 * */

@ManagedBean(name="personaBean")
@ViewScoped
public class PersonaBean {

	private Persona personaSeleccionada = new Persona();
	private List<Persona> lista = null;
	private MensajesUtil m = new MensajesController();
	private String nombreABuscar;
	private String confirmar_clave;
	
	public void prepararEdit(Persona persona) {
		setPersonaSeleccionada(persona);
	}
	
	public void buscarPersonaPorNombre() throws Exception {
		
		PersonaRN crn = new PersonaRN();
		try {
			if(nombreABuscar != null) {
			lista = crn.listarPersonasPorNombres(nombreABuscar);
			if(lista.isEmpty()) {
				lista = crn.listarPersonasPorNroDocumento(nombreABuscar);
			}
			
			} else {
lista = crn.listarPersonas();
			}
		} catch (Exception e) {
	m.mostrarMensajeError(e.getMessage());;
		}
	}
	
	public void guardar() {
		PersonaRN entityRN = new PersonaRN();
if(this.personaSeleccionada.getId() !=null 
&& this.personaSeleccionada.getId() != 0) {
	try{
		
		if(verificarClave()) {
	entityRN.modificar(this.personaSeleccionada);
	m.mostrarMensajeSeModifico();
			nuevo();
		} else {
			m.mostrarMensaje(FacesMessage.SEVERITY_INFO,"Aviso!","Las claves no coinciden!");
		}
			} catch(Exception e) {
m.mostrarMensajeErrorModificar(e.getMessage());
			}
		}
		else {
	try{
		if(verificarClave()) {
		personaSeleccionada.setFecha_creacion(new Date());
	entityRN.guardar(personaSeleccionada);
	m.mostrarMensajeSeGuardo();
	this.personaSeleccionada = new Persona();
	}
		else {
			m.mostrarMensaje(FacesMessage.SEVERITY_INFO,"Aviso!","Las claves no coinciden!");
		}
	}
		 catch(Exception e) {
 m.mostrarMensajeErrorGuardar(e.getMessage());
		}}
		
		this.lista = null;
	}
	
	private Boolean verificarClave() {
		Boolean b = false;
		if(confirmar_clave != null && personaSeleccionada != null && personaSeleccionada.getClave() != null) {
			if(confirmar_clave.equals(personaSeleccionada.getClave()))
					b = true;
		}
		return b;
	}
	
	public Persona getPersonaSeleccionada() {
		return this.personaSeleccionada;
	}
	
	public void setPersonaSeleccionada(Persona personaSeleccionada) {
		this.personaSeleccionada = personaSeleccionada;
	}
	
	public List<Persona> getLista() throws Exception {
		
		return lista;
	}
	
	public void eliminar() {
		try {
		PersonaRN entityRN = new PersonaRN();
		entityRN.eliminar(personaSeleccionada);
		this.lista = null;
		m.mostrarMensajeSeElimino();
		nuevo(); } catch (Exception e) {
m.mostrarMensajeErrorEliminar(e.getMessage());
		}
		
	}
	
	public void nuevo() {
		this.personaSeleccionada = new Persona();
	}

	public String getNombreABuscar() {
		return nombreABuscar;
	}

	public void setNombreABuscar(String nombreABuscar) {
		this.nombreABuscar = nombreABuscar;
	}

	public String getConfirmar_clave() {
		return confirmar_clave;
	}

	public void setConfirmar_clave(String confirmar_clave) {
		this.confirmar_clave = confirmar_clave;
	}
	
}
