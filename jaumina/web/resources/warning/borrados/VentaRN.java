package jaumina.entidades.ventas;

import java.util.Date;
import java.util.List;

import jaumina.commons.util.DAOFactory;
import jaumina.commons.util.EntityDAO;

public class VentaRN {

	private EntityDAO<Venta> ventaDAO;
	
	public VentaRN() {
		ventaDAO = DAOFactory.creaVentaDAO();
	}
	public void registraVenta(Venta venta) {
		ventaDAO.guardar(venta);
	}
	
	public void modificar(Venta venta) {
		ventaDAO.modificar(venta);		
	}
	
	public List<Venta> consultarVentaPorFecha(Date desde, Date hasta, 
			String delivery) throws Exception {
		return ventaDAO.consultarVentaPorFecha(desde, hasta, delivery);
	}
	public Venta buscarVentaPorId(Integer id) throws Exception {
		return ventaDAO.buscarVentaPorId(id);
	}
	
	public List<Venta> consultarVentaPorFecha(Date desde, Date hasta) throws Exception {
		return ventaDAO.consultarVentaPorFecha(desde, hasta);
	}
	public List<Venta> consultarVentaDeHoy(Date fechaVenta) throws Exception {
		return ventaDAO.consultarVentaDeHoy(fechaVenta);
	}
	public List<Venta> listarVentaAEntregar(String cliente, String nroPedido,
			String entregado, String ventacancelada)
			 throws Exception { 
return ventaDAO.listarVentaAEntregar(cliente, nroPedido, entregado, ventacancelada);
	}
	public Integer consultarVentaUltimoId()  throws Exception { 
		return ventaDAO.consultarVentaUltimoId();
	}
	 public Integer consultarUltimoNroPedido()  throws Exception {
		 return ventaDAO.hashCode();
			
	 }
	public List<Venta> consultarVentaPorNroPedido(Integer nroPedido, String entregado) throws Exception { 
		return ventaDAO.consultarVentaPorNroPedido(nroPedido, entregado);
	}
	
public List<Venta> listarVentasPorNroPedidoElegirCanceladas(Integer nroPedido, 
			String entregado, String ventacancelada) throws Exception {
return ventaDAO.listarVentasPorNroPedidoElegirCanceladas(nroPedido,
entregado, ventacancelada);
}

}
