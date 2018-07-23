package jaumina.entidades.delivery;

import java.util.List;
import jaumina.commons.util.DAOFactory;
import jaumina.commons.util.EntityDAO;

/**@author Diego Benitez 
 * 
 *  xuser83@hotmail.com
 *  Luque 03-03-2017
 *  */

public class DeliveryRN {

	private EntityDAO<Delivery> entityDAO;
	
	public DeliveryRN() {
		entityDAO = (EntityDAO<Delivery>) DAOFactory.creaDeliveryDAO();
	}
	
	public void guardar(Delivery t) {
		entityDAO.guardar(t);
	}
	
	public void eliminar(Delivery t) {
		entityDAO.eliminar(t);		
	}
	
	public void modificar(Delivery t) {
		entityDAO.modificar(t);		
	}
	public Delivery buscarDeliveryPorId(Integer id) throws Exception {
		return entityDAO.buscarDeliveryPorId(id);
	}
	
	public List<Delivery> listarDeliverys() throws Exception {
		return entityDAO.listarDeliverys();
	}

	public List<Delivery> listarDeliverysPorNombres(String nombres) throws Exception {
		 	return entityDAO.listarDeliverysPorNombres(nombres); 
	}
	
	public List<Delivery> listarDeliverysPorNroDocumento(String nro_documento) throws Exception {
		return entityDAO.listarDeliverysPorNroDocumento(nro_documento);
	}
}
