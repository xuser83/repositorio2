package jaumina.commons.util;

import jaumina.entidades.detalleventa.DetalleVenta;
import jaumina.entidades.persona.Persona;
import jaumina.entidades.productosventa.ProductosVenta;
import jaumina.entidades.ventas1.Venta1;



/**@author Diego Benitez 
 * 
 *  xuser83@hotmail.com
 *	Modificado: Luque, 24/02/2017
 */

public class DAOFactory<T> {
	
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
	public static EntityDAO<Persona> creaPersonaDAO() {
		EntityDAOHibernate<Persona> entityDAOHibernate
		= new EntityDAOHibernate<Persona>();		
		entityDAOHibernate.setSession(HibernateUtil.getSession()
				.getCurrentSession());		
		return entityDAOHibernate;
	}
	
	
}
