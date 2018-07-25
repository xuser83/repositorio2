package jaumina.entidades.persona;
import java.util.Date;
import java.util.List;
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
	entityRN.modificar(this.personaSeleccionada);
	m.mostrarMensajeSeModifico();
			nuevo();} catch(Exception e) {
m.mostrarMensajeErrorModificar(e.getMessage());
			}
		}
		else {
	try{
		personaSeleccionada.setFecha_creacion(new Date());
	entityRN.guardar(personaSeleccionada);
	m.mostrarMensajeSeGuardo();
	this.personaSeleccionada = new Persona();}
		 catch(Exception e) {
 m.mostrarMensajeErrorGuardar(e.getMessage());
		}}
		
		this.lista = null;
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
	
}
