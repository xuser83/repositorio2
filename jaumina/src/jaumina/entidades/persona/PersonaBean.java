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

	private Persona personaSeleccionada = new Persona(true);
	private List<Persona> lista = null;
	private MensajesUtil m = new MensajesController();
	private String nombreABuscar;
	private String confirmar_clave;
	private String claveModificar;
	private Boolean desabilitarParaModificar = false;
	
	public void prepararEdit(Persona persona) {
		if(verificarObjetoNoNull(persona)) {
		setPersonaSeleccionada(persona); 
		if(verificarObjetoNoNull(persona.getClave()))
			claveModificar = persona.getClave();
		desabilitarParaModificar = true;}
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
		
if(verificarNombreCortoParaModificar(personaSeleccionada.getNombre_corto(), personaSeleccionada.getId())) {
  if(verificarDistintoNro_documentoMismoRolModificar(personaSeleccionada.getNro_documento(), 
		personaSeleccionada.getRol(), Long.toString(personaSeleccionada.getId()))) {
	  
	  if(verificarObjetoNoNull(claveModificar))
	personaSeleccionada.setClave(claveModificar);
	  
	  entityRN.modificar(this.personaSeleccionada);
	m.mostrarMensajeSeModifico();
			nuevo();
			}
		}
			} catch(Exception e) {
m.mostrarMensajeErrorModificar(e.getMessage());
			}
		}
		else {
	try{
		if(verificarClave()) {
			if(verificarObjetoNoNull(personaSeleccionada.getNombre_corto())) {
			if(verificarNombreCortoParaGuardar(personaSeleccionada.getNombre_corto())) {
	if(verificarDistintoNro_documentoMismoRol(personaSeleccionada.getNro_documento(), personaSeleccionada.getRol())) {
		personaSeleccionada.setFecha_creacion(new Date());
	entityRN.guardar(personaSeleccionada);
	m.mostrarMensajeSeGuardo();
	this.personaSeleccionada = new Persona();
			}
		} 
	} }
		else {
			m.mostrarMensaje(FacesMessage.SEVERITY_INFO,"Aviso!","Las claves no coinciden!");
		}
	}
		 catch(Exception e) {
 m.mostrarMensajeErrorGuardar(e.getMessage());
		}}
		
		this.lista = null;
		desabilitarParaModificar = false;
	}
	
	private Boolean verificarObjetoNoNull(Object o) {
		if(o != null)
			return true;
		else return false;
	}
	
	private Boolean verificarClave() {
		Boolean b = false;
		if(confirmar_clave != null && personaSeleccionada != null && personaSeleccionada.getClave() != null) {
			if(confirmar_clave.equals(personaSeleccionada.getClave()))
					b = true;
		}
		return b;
	}
	
	private Boolean verificarNombreCortoParaGuardar(String nombre_corto) throws Exception {
		Boolean b = false;
		
		if(verificarObjetoNoNull(nombre_corto)) {
			PersonaRN prn = new PersonaRN();
			Persona p = prn.buscarPersonaPorNombre_corto(nombre_corto);
		if(p == null)
			b= true;
		}
		if(!b) m.mostrarMensaje(FacesMessage.SEVERITY_INFO,"Aviso!","Ya existe una persona con este nombre corto!");
		
		return b;
	}

	private Boolean verificarDistintoNro_documentoMismoRol(String nro_documento, String rol) throws Exception {
		Boolean b = false;
		if(nro_documento != null && rol != null) {
		PersonaRN prn = new PersonaRN();
		Persona p = prn.buscarPersonaMismoNroDocMismoRol(nro_documento, rol);
		if(p == null)
			b = true; }
		
	if(!b) m.mostrarMensaje(FacesMessage.SEVERITY_INFO,"Aviso!","Ya existe un "+rol +" con este nro documento!");
		
		return b;
	}
	
	private Boolean verificarNombreCortoParaModificar(String nombre_corto, Long id) throws Exception {
		Boolean b = false;
		if(verificarObjetoNoNull(nombre_corto) && verificarObjetoNoNull(id)) {
		PersonaRN prn = new PersonaRN();
		Persona p = prn.buscarPersonaPorNombre_cortoDistintoId(nombre_corto, Long.toString(id));
		if(p.getId() == null) {
			b= true; }
		else {
		
				if(p.getId() == id)
					b = true;
			
		} }
		
		if(!b) m.mostrarMensaje(FacesMessage.SEVERITY_INFO,"Aviso!","Ya existe una persona con este nombre corto!");
		
		return b;
	}
	
	private Boolean verificarDistintoNro_documentoMismoRolModificar(String nro_documento, String rol, String id) throws Exception {
		Boolean b = false;
		
		if(verificarObjetoNoNull(nro_documento) && verificarObjetoNoNull(rol) && verificarObjetoNoNull(id)) {
			PersonaRN prn = new PersonaRN();
			Persona p = prn.buscarPersonaMismoDocMismoRolDistintoId(nro_documento, rol, id);
			if(p == null) { b = true;}
		}
		
		if(!b) m.mostrarMensaje(FacesMessage.SEVERITY_INFO,"Aviso!","Ya existe un "+ rol +" con este nro documento!");
		
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
		this.personaSeleccionada = new Persona(true	);
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

	public String getClaveModificar() {
		return claveModificar;
	}

	public void setClaveModificar(String claveModificar) {
		this.claveModificar = claveModificar;
	}

	public Boolean getDesabilitarParaModificar() {
		return desabilitarParaModificar;
	}

	public void setDesabilitarParaModificar(Boolean desabilitarParaModificar) {
		this.desabilitarParaModificar = desabilitarParaModificar;
	}
	
}
