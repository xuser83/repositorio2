package jaumina.entidades.persona;

import java.util.List;
import jaumina.commons.util.DAOFactory;
import jaumina.commons.util.EntityDAO;

/**@author Diego Benitez 
 * 
 *  xuser83@hotmail.com
 *  Luque 23-07-2018
 *  */

public class PersonaRN {

	private EntityDAO<Persona> entityDAO;
	
	public PersonaRN() {
		entityDAO = (EntityDAO<Persona>) DAOFactory.creaPersonaDAO();
	}
	
	public void guardar(Persona t) {
		entityDAO.guardar(t);
	}
	
	public void eliminar(Persona t) {
		entityDAO.eliminar(t);		
	}
	
	public void modificar(Persona t) {
		entityDAO.modificar(t);		
	}
	
	public Persona buscarPersonaPorId(Long id) throws Exception {
		return entityDAO.buscarPersonaPorId(id);
	}
	
	public List<Persona> listarPersonas() throws Exception {
		return entityDAO.listarPersonas();
	}
	
	public List<Persona> listarPersonasPorNombres(String nombres) throws Exception { 
		return entityDAO.listarPersonasPorNombres(nombres);
	}
	
	public List<Persona> listarPersonasPorNroDocumento(String nroDocumento) throws Exception {
		return entityDAO.listarPersonasPorNroDocumento(nroDocumento);
	}
	
	public Persona iniciarSesion(Persona persona) {
		return entityDAO.iniciarSesion(persona);
	}
	
	public Persona buscarPersonaPorNombre_corto(String nombre_corto) throws Exception { 
		return entityDAO.buscarPersonaPorNombre_corto(nombre_corto);
	}
	
	public Persona buscarPersonaMismoNroDocMismoRol(String nro_documento, String rol) throws Exception {
		return entityDAO.buscarPersonaMismoNroDocMismoRol(nro_documento, rol);
	}
	
	public Persona buscarPersonaPorNombre_cortoDistintoId(String nombre_corto, String id) 
			throws Exception { 
		return entityDAO.buscarPersonaPorNombre_cortoDistintoId(nombre_corto, id);
	}
	
	public Persona buscarPersonaMismoDocMismoRolDistintoId(String nro_documento, String rol, String id) throws Exception {
		return entityDAO.buscarPersonaMismoDocMismoRolDistintoId(nro_documento, rol, id);
	}
	
	public List<Persona> listarPersonasClientesPorNombres(String nombres) throws Exception {  
		return entityDAO.listarPersonasClientesPorNombres(nombres);
	}
	public List<Persona> listarPersonasClientesActivosPorNombres(String nombres) throws Exception {
		return entityDAO.listarPersonasClientesActivosPorNombres(nombres);
	}
	public List<Persona> listarClientesActivosPorNombreOApellido(String nombreOApellido) 
			throws Exception {
		return entityDAO.listarClientesActivosPorNombreOApellido(nombreOApellido);
	}
	public List<Persona> listarPersonasDeliveryPorNombres(String nombres) throws Exception {
		return entityDAO.listarPersonasDeliveryPorNombres(nombres);
	}
/*	public Persona buscarPersonaPorNombre(String nombre) throws Exception {
		
		return entityDAO.buscarPersonaPorNombre(nombre);
	}*/
}
