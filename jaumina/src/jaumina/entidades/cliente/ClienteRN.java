package jaumina.entidades.cliente;

import java.util.List;
import jaumina.commons.util.DAOFactory;
import jaumina.commons.util.EntityDAO;

/**@author Diego Benitez 
 * 
 *  xuser83@hotmail.com
 *  Luque 03-03-2017
 *  */

public class ClienteRN {

	private EntityDAO<Cliente> entityDAO;
	
	public ClienteRN() {
		entityDAO = (EntityDAO<Cliente>) DAOFactory.creaClienteDAO();
	}
	
	public void guardar(Cliente t) {
		entityDAO.guardar(t);
	}
	
	public void eliminar(Cliente t) {
		entityDAO.eliminar(t);		
	}
	
	public void modificar(Cliente t) {
		entityDAO.modificar(t);		
	}
	
	public Cliente buscarPorNombre(String nombre) {
		
		return entityDAO.buscarPorNombre(nombre);
	}
	public Cliente buscarClientePorId(Long id) throws Exception {
		return entityDAO.buscarClientePorId(id);
	}
	
	public List<Cliente> listarClientes() throws Exception {
		return entityDAO.listarClientes();
	}
	
	public List<Cliente> listarClientesPorNombres(String nombres) throws Exception { 
		return entityDAO.listarClientesPorNombres(nombres);
	}
	
	public List<Cliente> listarClientesPorNroDocumento(String nombreABuscar) throws Exception {
		return entityDAO.listarClientesPorNroDocumento(nombreABuscar);
	}
}
