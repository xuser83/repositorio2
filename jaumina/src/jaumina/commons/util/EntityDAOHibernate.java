package jaumina.commons.util;

import java.util.ArrayList;
import java.util.Date;
//import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import jaumina.entidades.detalleventa.DetalleVenta;
import jaumina.entidades.persona.Persona;
import jaumina.entidades.productosventa.ProductosVenta;
//import jaumina.entidades.ventas.Venta;
import jaumina.entidades.ventas1.Venta1;


/**@author Diego Benitez 
 * 
 *  xuser83@hotmail.com
 *  
 *  Asunción sábado 06 de agosto de 2016
 *  */

public class EntityDAOHibernate<T> implements EntityDAO<T> {

	private Session session;
	
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
	
	@Override
	public void guardar(T t) {
		this.session.save(t);
	}

	@Override
	public void borrar(T t) {
		this.session.delete(t);		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T buscar(String string) {
		Query consultaNombre = this.session
				.createQuery("from T p where p.nombre like :nombre");
		consultaNombre.setString("nombre", "%" + string + "%");
		return (T) consultaNombre.uniqueResult();
	}

	@Override
	public void modificar(T t) {
		this.session.update(t);		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T buscarPorNombre(String nombre) {
		String sql = "from T p where p.nombre like :nombre";
		Query consulta = session.createQuery(sql);
		consulta.setString("nombre", "%" + nombre + "%");
		return (T) consulta.uniqueResult();
	}

	@Override
	public void eliminar(T t) {
		this.session.delete(t);
		
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<ProductosVenta> listarProductosVenta() throws Exception {
		Criteria lista = session.createCriteria(ProductosVenta.class);
		return lista.list();
	}
	
	@Override
	public ProductosVenta buscarProductoVentaPorNombreCorto(String nombrecorto) throws Exception {
	ProductosVenta p = new ProductosVenta();
		try {
		String sql ="from ProductosVenta c where c.nombrecorto like :nombrecorto";
		Query consulta = session.createQuery(sql);
		consulta.setString("nombrecorto", nombrecorto); 
		
		p = (ProductosVenta) consulta.list().get(0); } 
catch(IndexOutOfBoundsException e) {
	p = new ProductosVenta();
} 
		
		return p;
	}
	
	@Override
	public ProductosVenta buscarProductoVentaPorNombre(String nombre) throws Exception {
	ProductosVenta p = new ProductosVenta();
		try {
		String sql ="from ProductosVenta c where c.nombre like :nombre";
		Query consulta = session.createQuery(sql);
		consulta.setString("nombre", nombre); 
		
		p = (ProductosVenta) consulta.list().get(0); } 
catch(IndexOutOfBoundsException e) {
	p = new ProductosVenta();
} return p; }
		
		@Override
public ProductosVenta buscarProductoVentaPorCodigo(String codigo) throws Exception {
		ProductosVenta p = new ProductosVenta();
			try {
			String sql ="from ProductosVenta c where c.codigo like :codigo";
			Query consulta = session.createQuery(sql);
			consulta.setString("codigo", codigo); 
			
			p = (ProductosVenta) consulta.list().get(0); } 
	catch(IndexOutOfBoundsException e) {
		p = new ProductosVenta();
	} 
		
		return p;
	}
		@Override
	public ProductosVenta buscarProductoVentaPorNombreCortoDistintoId(String nombrecorto, String id) 
			throws Exception {
		ProductosVenta p = new ProductosVenta();
		try {
		String sql ="from ProductosVenta c where c.nombrecorto like :nombrecorto"
				+ " and c.id != :id";
		Query consulta = session.createQuery(sql);
		consulta.setString("nombrecorto", nombrecorto);
		consulta.setString("id", id);
		
		p = (ProductosVenta) consulta.list().get(0); } 
catch(IndexOutOfBoundsException e) {
	p = new ProductosVenta();
} 
		
		return p;	
	}
	@Override	
public ProductosVenta buscarProductoVentaPorNombreDistintoId(String nombre, String id) 
			throws Exception {
		ProductosVenta p = new ProductosVenta();
		try {
		String sql ="from ProductosVenta c where c.nombre like :nombre"
				+ " and c.id != :id";
		Query consulta = session.createQuery(sql);
		consulta.setString("nombre", nombre);
		consulta.setString("id", id);
		
		p = (ProductosVenta) consulta.list().get(0); } 
catch(IndexOutOfBoundsException e) {
	p = new ProductosVenta();
} 
		
		return p;	
	}
@Override
public ProductosVenta buscarProductoVentaPorCodigoDistintoId(String codigo, String id) 
		throws Exception {
	ProductosVenta p = new ProductosVenta();
	try {
	String sql ="from ProductosVenta c where c.codigo like :codigo"
			+ " and c.id != :id";
	Query consulta = session.createQuery(sql);
	consulta.setString("codigo", codigo);
	consulta.setString("id", id);
	
	p = (ProductosVenta) consulta.list().get(0); } 
catch(IndexOutOfBoundsException e) {
p = new ProductosVenta();
} 
	
	return p;	
}
	  
	 /*inicio Venta1*/
	
	@SuppressWarnings("unchecked")
	public List<Venta1> listarVentas1NoEntregadas() 
			throws Exception {
		String sql = "FROM Venta1 v WHERE v.entregado"
				+ " like :entregado ";
			Query consulta = session.createQuery(sql);
			consulta.setString("entregado", "no");
			return (List<Venta1>) consulta.list();		
	}
	
	@Override
	 public Long consultarVenta1UltimoId()  throws Exception {
		 String sql = "select max(v.id) from Venta1 v";
				 Query consulta = session.createQuery(sql);
			return (Long) consulta.uniqueResult();
			
	 }
	@Override
	public Venta1 consultarUltimaVenta1(Long id) throws Exception {
		String sql = "FROM Venta1 v WHERE v.id like :id)";
		 Query consulta = session.createQuery(sql);
		 consulta.setLong("id", id);
	return (Venta1) consulta.uniqueResult();
	}

	@Override
public Venta1 consultarVenta1PorId(Long id) throws Exception {
		String sql = "FROM Venta1 v WHERE v.id like :id)";
		 Query consulta = session.createQuery(sql);
		 consulta.setLong("id", id);
	return (Venta1) consulta.uniqueResult();
}
	
/*@SuppressWarnings("unchecked")
	@Override
	public List<Venta1> consultarVentaPorFecha(Date desde, Date hasta, Cliente cliente) throws Exception {
		String sql = "FROM Venta1 v WHERE v.cliente like :cliente AND"
				+ " v.fechaVenta BETWEEN :desde AND :hasta";
		Query consulta = session.createQuery(sql);
		consulta.setDate("desde", desde);
		consulta.setDate("hasta", hasta);
		consulta.setEntity("cliente", cliente);
		return (List<Venta1>) consulta.list();
	}*/

@SuppressWarnings("unchecked")
@Override
public List<Venta1> consultarVentaPorFecha(Date desde, Date hasta, Persona cliente) throws Exception {
	String sql = "FROM Venta1 v WHERE v.cliente like :cliente AND"
			+ " v.fechaVenta BETWEEN :desde AND :hasta";
	Query consulta = session.createQuery(sql);
	consulta.setDate("desde", desde);
	consulta.setDate("hasta", hasta);
	consulta.setEntity("cliente", cliente);
	return (List<Venta1>) consulta.list();
}

	 /*fin *Venta1*/

	/*inicio detalleventa*/
@Override
public DetalleVenta buscarDetalleVentaPorId(Long id) throws Exception {
	String sql = "FROM detalleventa d WHERE d.id like :id)";
	 Query consulta = session.createQuery(sql);
	 consulta.setLong("id", id);
return (DetalleVenta) consulta.uniqueResult();
}	
	/*fin detalleventa*/
	
	 /*@Override
	 public Cliente buscarClientePorId(Long id) throws Exception {
		 return (Cliente) session.get(Cliente.class, id);
	 }
	 @SuppressWarnings("unchecked")
	@Override
	public	List<Cliente> listarClientes() throws Exception {
		 Criteria lista = session.createCriteria(Cliente.class);
			return lista.list();
	 }
@SuppressWarnings("unchecked")
@Override
public List<Cliente> listarClientesPorNombres(String nombres) throws Exception {
	String sql = "FROM Cliente c WHERE c.nombres"
	 		+ " like :nombres";
	 	Query consulta = session.createQuery(sql);
	 	consulta.setString("nombres", "%" + nombres + "%");
	 	return (List<Cliente>) consulta.list(); 
}

@SuppressWarnings("unchecked")
@Override
public List<Cliente> listarClientesPorNroDocumento(String nro_documento) throws Exception {
	String sql = "FROM Cliente c WHERE c.nro_documento"
	 		+ " like :nro_documento";
	 	Query consulta = session.createQuery(sql);
	 	consulta.setString("nro_documento", "%" + nro_documento + "%");
	 	return (List<Cliente>) consulta.list(); 
}

@SuppressWarnings("unchecked")
@Override
public List<Usuario> listarUsuarios() throws Exception {
	Criteria lista = session.createCriteria(Usuario.class);
	return lista.list();
}

@SuppressWarnings("unchecked")
@Override
public Usuario iniciarSesion(Usuario us) {
	Usuario usuario = null;
	String consulta;
	try {
consulta = "from Usuario u where u.username like :username "
	+ "and u.clave like :clave";
Query query = session.createQuery(consulta);
query.setString("username", us.getUsername());
query.setString("clave", us.getClave());
List<Usuario> lista = (List<Usuario>) query.list();
if(!lista.isEmpty()) {
usuario = lista.get(0);
}
	} catch (Exception e) {
		System.out.println("Error: " + e.getMessage());
		throw e;
	} finally {}
	return usuario;	}

@SuppressWarnings("unchecked")
@Override
public List<Usuario> listarUsuariosPorUserName(String username) throws Exception {
	String sql = "FROM Usuario u WHERE u.username"
	 		+ " like :username";
	 	Query consulta = session.createQuery(sql);
	 	consulta.setString("username", "%" + username + "%");
	 	return (List<Usuario>) consulta.list(); 
}

@Override
public Usuario buscarUsuarioPorCodigo(Integer codigo) throws Exception {
	 return (Usuario) session.get(Usuario.class, codigo);
}

@Override
public Delivery buscarDeliveryPorId(Integer id) throws Exception {
	return (Delivery) session.get(Delivery.class, id);
}
@SuppressWarnings("unchecked")
@Override
public List<Delivery> listarDeliverys() throws Exception {
	Criteria lista = session.createCriteria(Delivery.class);
	return lista.list();
}

@SuppressWarnings("unchecked")
@Override
public List<Delivery> listarDeliverysPorNombres(String nombres) throws Exception {
	String sql = "FROM Delivery c WHERE c.nombres"
	 		+ " like :nombres";
	 	Query consulta = session.createQuery(sql);
	 	consulta.setString("nombres", "%" + nombres + "%");
	 	return (List<Delivery>) consulta.list(); 
}
@SuppressWarnings("unchecked")
@Override
public List<Delivery> listarDeliverysPorNroDocumento(String nro_documento) throws Exception {
	String sql = "FROM Delivery c WHERE c.nro_documento"
	 		+ " like :nro_documento";
	 	Query consulta = session.createQuery(sql);
	 	consulta.setString("nro_documento", "%" + nro_documento + "%");
	 	return (List<Delivery>) consulta.list(); 
	
}fin Cliente, Usuario Delivery*/
/*persona*/

@Override
public Persona buscarPersonaPorId(Long id) throws Exception {
	return (Persona) session.get(Persona.class, id);
}
@SuppressWarnings("unchecked")
@Override
public List<Persona> listarPersonas() throws Exception {
	Criteria lista = session.createCriteria(Persona.class);
	return lista.list();
}

@SuppressWarnings("unchecked")
@Override
public List<Persona> listarPersonasPorNombres(String nombres) throws Exception { 
	String sql = "FROM Persona c WHERE c.nombres"
	 		+ " like :nombres";
	 	Query consulta = session.createQuery(sql);
	 	consulta.setString("nombres", "%" + nombres + "%");
	 	return (List<Persona>) consulta.list(); 
}

@SuppressWarnings("unchecked")
@Override
public List<Persona> listarPersonasPorNroDocumento(String nro_documento) throws Exception {
	String sql = "FROM Persona c WHERE c.nro_documento"
	 		+ " like :nro_documento";
	 	Query consulta = session.createQuery(sql);
	 	consulta.setString("nro_documento", "%" + nro_documento + "%");
	 	return (List<Persona>) consulta.list();
}

@SuppressWarnings("unchecked")
@Override
public Persona iniciarSesion(Persona per) {
	Persona persona = null;
	String consulta;
	try {
consulta = "from Persona u where u.nombre_corto like :nombre_corto "
	+ "and u.clave like :clave and u.rol like :rol";
Query query = session.createQuery(consulta);
query.setString("nombre_corto", per.getNombre_corto());
query.setString("clave", per.getClave());
query.setString("rol", "usuariosistema");


List<Persona> lista = (List<Persona>) query.list();
if(!lista.isEmpty()) {
persona = lista.get(0);

}
	} catch (Exception e) {
		System.out.println("Error: " + e.getMessage());
		throw e;
	} finally {}
	return persona;	
	}
@Override
public Persona buscarPersonaPorNombre_corto(String nombre_corto) throws Exception {
	String sql = "FROM Persona d WHERE d.nombre_corto like :nombre_corto";
	 Query consulta = session.createQuery(sql);
	 consulta.setString("nombre_corto", nombre_corto);
return (Persona) consulta.uniqueResult();
}
@Override
public Persona buscarPersonaMismoNroDocMismoRol(String nro_documento, String rol) throws Exception {
	String sql = "FROM Persona d WHERE d.nro_documento like :nro_documento and d.rol like :rol";
	 Query consulta = session.createQuery(sql);
	 consulta.setString("nro_documento", nro_documento);
	 consulta.setString("rol", rol);
return (Persona) consulta.uniqueResult();
}

@Override	
public Persona buscarPersonaPorNombre_cortoDistintoId(String nombre_corto, String id) 
			throws Exception {
		Persona p = new Persona();
		try {
		String sql ="from Persona c where c.nombre_corto like :nombre_corto"
				+ " and c.id != :id";
		Query consulta = session.createQuery(sql);
		consulta.setString("nombre_corto", nombre_corto);
		consulta.setString("id", id);
		
		p = (Persona) consulta.list().get(0); } 
catch(IndexOutOfBoundsException e) {
	p = new Persona();
} 
		
		return p;	
	}

@Override
public Persona buscarPersonaMismoDocMismoRolDistintoId(String nro_documento, String rol, String id) throws Exception {
	String sql = "FROM Persona d WHERE d.nro_documento like :nro_documento and d.rol like :rol"
			+ " and d.id != :id";
	 Query consulta = session.createQuery(sql);
	 consulta.setString("nro_documento", nro_documento);
	 consulta.setString("rol", rol);
	 consulta.setString("id", id);
return (Persona) consulta.uniqueResult();
}
@Override
@SuppressWarnings("unchecked")
public List<Persona> listarPersonasClientesPorNombres(String nombres) throws Exception {
	String sql = "FROM Persona c WHERE c.nombres"
	 		+ " like :nombres and c.rol like :rol";
	 	Query consulta = session.createQuery(sql);
	 	consulta.setString("nombres", "%" + nombres + "%");
	 	consulta.setString("rol", "cliente");
	 	return (List<Persona>) consulta.list(); 
}

@Override
@SuppressWarnings("unchecked")
public List<Persona> listarPersonasClientesActivosPorNombres(String nombres) throws Exception {
	String sql = "FROM Persona c WHERE c.nombres"
	 		+ " like :nombres and c.rol like :rol";
	 	Query consulta = session.createQuery(sql);
	 	consulta.setString("nombres", "%" + nombres + "%");
	 	consulta.setString("rol", "cliente");
	 	
	 	List<Persona> listaPersonasClientesActivos = new ArrayList<Persona>();
	 	
	 	if(consulta.list() != null) {
	 	
	 	List<Persona> listaClientes = (List<Persona>) consulta.list();
	 		
	 		for (Persona persona : listaClientes) {
				if(persona.getActivo()) {
					listaPersonasClientesActivos.add(persona);
				}
			}
	 	}
	 	
	 	
	 	return listaPersonasClientesActivos; 
}
@Override
@SuppressWarnings("unchecked")
public List<Persona> listarClientesActivosPorNombreOApellido(String nombreOApellido) 
		throws Exception {
	String sql = "FROM Persona c WHERE c.nombres"
	 		+ " like :nombres and c.rol like :rol";
	 	Query consulta = session.createQuery(sql);
	 	consulta.setString("nombres", "%" + nombreOApellido + "%");
	 	consulta.setString("rol", "cliente");
	 	
	 	List<Persona> listaPersonasClientesActivos = new ArrayList<Persona>();
	 	
	 	if(consulta.list() != null) {
	 	
	 	List<Persona> listaClientes = (List<Persona>) consulta.list();
	 		
	 		for (Persona persona : listaClientes) {
				if(persona.getActivo()) {
					listaPersonasClientesActivos.add(persona);
				}
			}
	 	}
	 	
	 	if(consulta.list() == null || consulta.list().isEmpty()) {
	 		
	 		String sql1 = "FROM Persona c WHERE c.apellidos"
	 		 		+ " like :apellidos and c.rol like :rol";
	 		 	Query consulta1 = session.createQuery(sql1);
	 		 	consulta1.setString("apellidos", "%" + nombreOApellido + "%");
	 		 	consulta1.setString("rol", "cliente");
	 		 	
	 		 	if(consulta1.list() != null) {
	 		 		List<Persona> listaClientes = (List<Persona>) consulta1.list();	 		
	 		 		for (Persona persona : listaClientes) {
	 					if(persona.getActivo()) {
	 						listaPersonasClientesActivos.add(persona);
	 					}
	 				} 		
	 		 	}
	 		
	 	}
	 	
	 	
	 	return listaPersonasClientesActivos; 
} 

@Override
@SuppressWarnings("unchecked")
public List<Persona> listarPersonasDeliveryPorNombres(String nombres) throws Exception {
	String sql = "FROM Persona c WHERE c.nombres"
	 		+ " like :nombres and c.rol like :rol";
	 	Query consulta = session.createQuery(sql);
	 	consulta.setString("nombres", "%" + nombres + "%");
	 	consulta.setString("rol", "delivery");
	 	return (List<Persona>) consulta.list(); 
}
/*fin persona*/
}

/*public Persona buscarPersonaPorNombre(String nombre) throws Exception {
String sql = "FROM Persona c WHERE c.nombres"
 		+ " like :nombres";
 	Query consulta = session.createQuery(sql);
 	consulta.setString("nombres", "%" + nombres + "%");
 	return (List<Persona>) consulta.list(); 
}*/
/*@SuppressWarnings("unchecked")
@Override
public List<Venta> consultarVentaPorFecha(Date desde, Date hasta, 
		String delivery) throws Exception {
	String sql = "FROM Venta v WHERE v.delivery like :delivery AND"
			+ " v.fechaVenta BETWEEN :desde AND :hasta";
	Query consulta = session.createQuery(sql);
	consulta.setString("delivery", delivery);
	consulta.setDate("desde", desde);
	consulta.setDate("hasta", hasta);
	return (List<Venta>) consulta.list();
}
@Override
public Venta buscarVentaPorId(Integer id) throws Exception {
	 return (Venta) session.get(Venta.class, id);
}

@SuppressWarnings("unchecked")
@Override
public List<Venta> consultarVentaPorFecha(Date desde, Date hasta) throws Exception {
	String sql = "FROM Venta v WHERE v.fechaVenta BETWEEN :desde AND :hasta";
	Query consulta = session.createQuery(sql);
	consulta.setDate("desde", desde);
	consulta.setDate("hasta", hasta);
	return (List<Venta>) consulta.list();
}

@SuppressWarnings("unchecked")
@Override
public List<Venta> consultarVentaDeHoy(Date fechaVenta) throws Exception {
	String sql = "FROM Venta v WHERE v.fechaVenta like :fechaVenta";
	Query consulta = session.createQuery(sql);
	consulta.setDate("fechaVenta", fechaVenta);
	return (List<Venta>) consulta.list();
}

@SuppressWarnings("unchecked")
public List<Venta> listarVentaAEntregar(String cliente, String nroPedido, 
		String entregado, String ventacancelada)
		 throws Exception {
	String sql = "FROM Venta v WHERE v.cliente like :cliente AND "
			+ "v.nroPedido like :nroPedido And v.entregado like :entregado"
			+ " AND v.ventacancelada like :ventacancelada";
	Query consulta = session.createQuery(sql);
	consulta.setString("cliente", cliente);
	consulta.setString("nroPedido", nroPedido);
	consulta.setString("entregado", entregado);
	consulta.setString("ventacancelada", ventacancelada);
	return (List<Venta>) consulta.list();
}

@Override
public Integer consultarVentaUltimoId()  throws Exception {
	 String sql = "select max(v.id) from Venta v";
			 Query consulta = session.createQuery(sql);
		return (Integer) consulta.uniqueResult();
		
}
@Override
public Integer consultarVentaUltimoNroPedido()  throws Exception {
	 String sql = "select max(v.nroPedido) from Venta v";
			 Query consulta = session.createQuery(sql);
		return (Integer) consulta.uniqueResult();
		
}
@SuppressWarnings("unchecked")
@Override
public List<Venta> consultarVentaPorNroPedido(Integer nroPedido, String entregado) throws Exception {
String sql = "FROM Venta v WHERE v.nroPedido like :nroPedido and v.entregado"
		+ " like :entregado";
	Query consulta = session.createQuery(sql);
	consulta.setInteger("nroPedido", nroPedido);
	consulta.setString("entregado", entregado);
	return (List<Venta>) consulta.list(); }

@SuppressWarnings("unchecked")
@Override
public List<Venta> listarVentasPorNroPedidoElegirCanceladas(Integer nroPedido, 
	String entregado, String ventacancelada) throws Exception {
String sql = "FROM Venta v WHERE v.nroPedido like :nroPedido AND v.entregado"
+ " like :entregado AND v.ventacancelada like :ventacancelada";
Query consulta = session.createQuery(sql);
consulta.setInteger("nroPedido", nroPedido);
consulta.setString("entregado", entregado);
consulta.setString("ventacancelada", ventacancelada);
return (List<Venta>) consulta.list();	 
}*/
