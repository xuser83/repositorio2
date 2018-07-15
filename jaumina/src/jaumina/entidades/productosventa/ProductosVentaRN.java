package jaumina.entidades.productosventa;

import java.util.List;

import jaumina.commons.util.DAOFactory;
import jaumina.commons.util.EntityDAO;

/**@author Diego Benitez 
 * 
 *  xuser83@hotmail.com
 *  Luque, Jueves 28 de julio de 2016
 *  */

public class ProductosVentaRN {

	private EntityDAO<ProductosVenta> productosVentaDAO;
	
	public ProductosVentaRN() {
		this.productosVentaDAO = DAOFactory.creaProductosVentaDAO();
	}
	
	public void guardar(ProductosVenta productosVenta) {
		this.productosVentaDAO.guardar(productosVenta);
	}
	
	public void eliminar(ProductosVenta productosVenta) {
		this.productosVentaDAO.eliminar(productosVenta);		
	}
	
	public void modificar(ProductosVenta productosVenta) {
		this.productosVentaDAO.modificar(productosVenta);		
	}
	
	public List<ProductosVenta> listar() throws Exception {
		return this.productosVentaDAO.listarProductosVenta();
	}
	
	public ProductosVenta buscarProductoVentaPorNombreCorto(String nombrecorto) throws Exception {
		return productosVentaDAO.buscarProductoVentaPorNombreCorto(nombrecorto);
	}
	
	public ProductosVenta buscarProductoVentaPorNombre(String nombre) throws Exception {
		return productosVentaDAO.buscarProductoVentaPorNombre(nombre);
	}
	
	public ProductosVenta buscarProductoVentaPorCodigo(String codigo) throws Exception {
		return productosVentaDAO.buscarProductoVentaPorCodigo(codigo);
	}
	
	public ProductosVenta buscarProductoVentaPorNombreCortoDistintoId(String nombrecorto, String id) throws Exception {
		return productosVentaDAO.buscarProductoVentaPorNombreCortoDistintoId(nombrecorto, id);
	}
	public ProductosVenta buscarProductoVentaPorNombreDistintoId(String nombre, String id) 
			throws Exception {
		return productosVentaDAO.buscarProductoVentaPorNombreDistintoId(nombre, id);
	} 
	public ProductosVenta buscarProductoVentaPorCodigoDistintoId(String codigo, String id) 
			throws Exception {
		return productosVentaDAO.buscarProductoVentaPorCodigoDistintoId(codigo, id);
	}
	
}
