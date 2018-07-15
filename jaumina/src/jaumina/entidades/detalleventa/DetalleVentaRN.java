package jaumina.entidades.detalleventa;

import jaumina.commons.util.DAOFactory;
import jaumina.commons.util.EntityDAO;

/*Diego Manuel Benitez Enciso
 * Luque 30-06-2018*/

public class DetalleVentaRN {

	private EntityDAO<DetalleVenta> detalleVentaDAO;
	
	public DetalleVentaRN() {
		detalleVentaDAO = DAOFactory.creaDetalleVentaDAO();
	}
	public void registraDetalleVenta(DetalleVenta venta1) {
		detalleVentaDAO.guardar(venta1);
	}
	
	public void modificar(DetalleVenta venta1) {
		detalleVentaDAO.modificar(venta1);		
	}
	
	public void eliminar(DetalleVenta venta1) {
		detalleVentaDAO.borrar(venta1);
	}
	
	public DetalleVenta buscarDetalleVentaPorId(Long id) throws Exception {
		return detalleVentaDAO.buscarDetalleVentaPorId(id);
	}
	
	
}
