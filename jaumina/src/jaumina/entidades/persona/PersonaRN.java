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
	
/*	public Persona buscarPersonaPorNombre(String nombre) throws Exception {
		
		return entityDAO.buscarPersonaPorNombre(nombre);
	}*/
}
