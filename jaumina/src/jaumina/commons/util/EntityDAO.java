package jaumina.commons.util;

import java.util.Date;
import java.util.List;

import jaumina.entidades.detalleventa.DetalleVenta;
import jaumina.entidades.persona.Persona;
import jaumina.entidades.productosventa.ProductosVenta;
import jaumina.entidades.ventas1.Venta1;


/**@author Diego Benitez 
 * 
 *  xuser83@hotmail.com
 *  Asunción viernes 05 de agosto de 2016.
 *  */

public interface EntityDAO<T> {

	public void guardar(T t);
	public void eliminar(T t);
	public T buscar(String string);
	public T buscarPorNombre(String nombre);
	public void modificar(T t);
	void borrar(T t);
	public List<ProductosVenta> listarProductosVenta() throws Exception;
	ProductosVenta buscarProductoVentaPorNombreCorto(String nombrecorto) throws Exception;
	ProductosVenta buscarProductoVentaPorNombre(String nombre) throws Exception;
	ProductosVenta buscarProductoVentaPorCodigo(String codigo) throws Exception;
	ProductosVenta buscarProductoVentaPorNombreCortoDistintoId(String nombrecorto, String id) throws Exception;
	ProductosVenta buscarProductoVentaPorNombreDistintoId(String nombre, String id) 
			throws Exception;
	ProductosVenta buscarProductoVentaPorCodigoDistintoId(String codigo, String id) 
			throws Exception; 

/*inicio Venta1*/


List<Venta1> listarVentas1NoEntregadas() throws Exception;
Long consultarVenta1UltimoId()  throws Exception;
Venta1 consultarUltimaVenta1(Long id) throws Exception;
Venta1 consultarVenta1PorId(Long id) throws Exception;
//List<Venta1> consultarVentaPorFecha(Date desde, Date hasta, Cliente cliente) throws Exception;
List<Venta1> consultarVentaPorFecha(Date desde, Date hasta, Persona cliente) throws Exception;
/*fin Venta1*/

/*inicio detalleventa*/
DetalleVenta buscarDetalleVentaPorId(Long id) throws Exception;
/*fin detalleventa*/

/* Cliente, Usuario Delivery
	Cliente buscarClientePorId(Long id) throws Exception;
	List<Cliente> listarClientes() throws Exception;
	List<Cliente> listarClientesPorNombres(String nombres) throws Exception;
	public List<Cliente> listarClientesPorNroDocumento(String nombreABuscar) throws Exception;
	
	List<Usuario> listarUsuarios() throws Exception;
	Usuario iniciarSesion(Usuario us);
	List<Usuario> listarUsuariosPorUserName(String username) throws Exception;
	Usuario buscarUsuarioPorCodigo(Integer codigo) throws Exception;

	Delivery buscarDeliveryPorId(Integer id) throws Exception;
	List<Delivery> listarDeliverys() throws Exception;
	List<Delivery> listarDeliverysPorNombres(String nombres) throws Exception;
	List<Delivery> listarDeliverysPorNroDocumento(String nro_documento) throws Exception;
	fin Cliente, Usuario Delivery*/
/*persona*/
	
/*Persona buscarPersonaPorNombre(String nombre) throws Exception;*/ 
Persona buscarPersonaPorId(Long id) throws Exception;
List<Persona> listarPersonas() throws Exception;
List<Persona> listarPersonasPorNombres(String nombres) throws Exception;
public List<Persona> listarPersonasClientesActivosPorNombres(String nombres) throws Exception;
public List<Persona> listarClientesActivosPorNombreOApellido(String nombreOApellido) throws Exception;
List<Persona> listarPersonasPorNroDocumento(String nroDocumento) throws Exception;
Persona iniciarSesion(Persona persona);
Persona buscarPersonaPorNombre_corto(String nombre_corto) throws Exception;
Persona buscarPersonaMismoNroDocMismoRol(String nro_documento, String rol) throws Exception;
Persona buscarPersonaPorNombre_cortoDistintoId(String nombre_corto, String id) throws Exception;
Persona buscarPersonaMismoDocMismoRolDistintoId(String nro_documento, String rol, String id) throws Exception;
List<Persona> listarPersonasClientesPorNombres(String nombres) throws Exception;
List<Persona> listarPersonasDeliveryPorNombres(String nombres) throws Exception;
/*fin persona*/}
/*	List<Venta> consultarVentaPorFecha(Date desde, Date hasta, 
String delivery) throws Exception;
Venta buscarVentaPorId(Integer id) throws Exception;
List<Venta> consultarVentaPorFecha(Date desde, Date hasta) throws Exception;
List<Venta> consultarVentaDeHoy(Date fechaVenta) throws Exception;
List<Venta> listarVentaAEntregar(String cliente, 
String nroPedido, String entregado, String ventacancelada) throws Exception;
Integer consultarVentaUltimoId()  throws Exception;
public Integer consultarVentaUltimoNroPedido()  throws Exception;
List<Venta> consultarVentaPorNroPedido(Integer nroPedido, String entregado) 
throws Exception;
List<Venta> listarVentasPorNroPedidoElegirCanceladas(Integer nroPedido, 
String entregado, String ventacancelada) 
throws Exception;*/