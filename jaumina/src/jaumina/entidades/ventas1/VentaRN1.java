package jaumina.entidades.ventas1;

import java.util.Date;
import java.util.List;

import jaumina.commons.util.DAOFactory;
import jaumina.commons.util.EntityDAO;
import jaumina.entidades.cliente.Cliente;

public class VentaRN1 {

	private EntityDAO<Venta1> ventaDAO1;
	
	public VentaRN1() {
		ventaDAO1 = DAOFactory.creaVenta1DAO();
	}
	public void registraVenta1(Venta1 venta1) {
		ventaDAO1.guardar(venta1);
	}
	
	public void modificar(Venta1 venta1) {
		ventaDAO1.modificar(venta1);		
	}
	
	public void eliminar(Venta1 venta1) {
		ventaDAO1.borrar(venta1);
	}
	
	public List<Venta1> listarVentas1NoEntregadas() throws Exception {
		return ventaDAO1.listarVentas1NoEntregadas();
	}
	
	public Long consultarVenta1UltimoId()  throws Exception {
		return ventaDAO1.consultarVenta1UltimoId();
	}
	
	public Venta1 consultarUltimaVenta1(Long id) throws Exception {
		return ventaDAO1.consultarUltimaVenta1(id);
	}
	
	public Venta1 consultarVenta1PorId(Long id) throws Exception {
return ventaDAO1.consultarVenta1PorId(id);
}
	
	public List<Venta1> consultarVentaPorFecha(Date desde, Date hasta, Cliente cliente) throws Exception {
		return ventaDAO1.consultarVentaPorFecha(desde, hasta, cliente);
	}
}
