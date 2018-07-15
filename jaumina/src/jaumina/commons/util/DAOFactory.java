package jaumina.commons.util;

import jaumina.entidades.cliente.Cliente;
import jaumina.entidades.delivery.Delivery;
import jaumina.entidades.detalleventa.DetalleVenta;
import jaumina.entidades.productosventa.ProductosVenta;
import jaumina.entidades.usuario.Usuario;
import jaumina.entidades.ventas1.Venta1;



/**@author Diego Benitez 
 * 
 *  xuser83@hotmail.com
 *	Modificado: Luque, 24/02/2017
 */

public class DAOFactory<T> {
	
	public static EntityDAO<Usuario> creaUsuarioDAO() {
		EntityDAOHibernate<Usuario> entityDAOHibernate
		= new EntityDAOHibernate<Usuario>();		
		entityDAOHibernate.setSession(HibernateUtil.getSession()
				.getCurrentSession());		
		return entityDAOHibernate;
	}
	
	public static EntityDAO<ProductosVenta> creaProductosVentaDAO() {
		EntityDAOHibernate<ProductosVenta> entityDAOHibernate
		= new EntityDAOHibernate<ProductosVenta>();		
		entityDAOHibernate.setSession(HibernateUtil.getSession()
				.getCurrentSession());		
		return entityDAOHibernate;
	}
	
	public static EntityDAO<Venta1> creaVenta1DAO() {
		EntityDAOHibernate<Venta1> entityDAOHibernate
		= new EntityDAOHibernate<Venta1>();		
		entityDAOHibernate.setSession(HibernateUtil.getSession()
				.getCurrentSession());		
		return entityDAOHibernate;
	}
	
	public static EntityDAO<DetalleVenta> creaDetalleVentaDAO() {
		EntityDAOHibernate<DetalleVenta> entityDAOHibernate
		= new EntityDAOHibernate<DetalleVenta>();		
		entityDAOHibernate.setSession(HibernateUtil.getSession()
				.getCurrentSession());		
		return entityDAOHibernate;
	}
	
	public static EntityDAO<Cliente> creaClienteDAO() {
		EntityDAOHibernate<Cliente> entityDAOHibernate
		= new EntityDAOHibernate<Cliente>();		
		entityDAOHibernate.setSession(HibernateUtil.getSession()
				.getCurrentSession());		
		return entityDAOHibernate;
	}
	
	public static EntityDAO<Delivery> creaDeliveryDAO() {
		EntityDAOHibernate<Delivery> entityDAOHibernate
		= new EntityDAOHibernate<Delivery>();		
		entityDAOHibernate.setSession(HibernateUtil.getSession()
				.getCurrentSession());		
		return entityDAOHibernate;
	}
	
	
}
