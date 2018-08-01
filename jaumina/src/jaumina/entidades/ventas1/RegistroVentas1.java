package jaumina.entidades.ventas1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import jaumina.commons.util.MensajesController;
import jaumina.entidades.cliente.Cliente;
import jaumina.entidades.detalleventa.DetalleVenta;
import jaumina.entidades.detalleventa.DetalleVentaRN;
import jaumina.entidades.persona.Persona;
import jaumina.entidades.persona.PersonaRN;
import jaumina.entidades.productosventa.ProductosVenta;
import jaumina.entidades.productosventa.ProductosVentaRN;

@ManagedBean(name = "registroVentas1")
@ViewScoped
public class RegistroVentas1 implements Serializable{

	private boolean seCargoVentaNoEntregada = false;
	
	public void entregar(DetalleVenta d) throws Exception {	
		
		d.getVenta().setEntregado("si");
		
		VentaRN1 v = new VentaRN1();
		v.modificar(d.getVenta());
		seCargoVentaNoEntregada = false;
		
		if(primerAgregar == 0) {
			primerAgregar = 1;
			cargarVentaNoEntregada();
			primerAgregar = 0;
		}
		else 
			cargarVentaNoEntregada();
		
		for (DetalleVenta de : d.getVenta().getListaDetalle() ) {
			restarCantidadPedido(de);
		}
		
		new MensajesController().imprimirDetalleVenta(d.getVenta().getListaDetalle());
		
	}

	public void cargarVentaNoEntregada() throws Exception {
		
		VentaRN1 v = new VentaRN1();
		
		lista = v.listarVentas1NoEntregadas();
		listaDetalle = new ArrayList<DetalleVenta>();
		
		Integer orden = 0;
		for (Venta1 venta1 : lista) {
						
			for(DetalleVenta det : venta1.getListaDetalle()) {
				if(det.getEliminado() != "si")
				listaDetalle.add(det);
				
				if(primerCargarVentaNoEntregada == 0 ) {
					for (ProductosVenta productosVenta : listaProductos) 
						productosVenta.setCantPedido(0);
					primerCargarVentaNoEntregada += 1;
				}
				if(primerAgregar == 0 && !seCargoVentaNoEntregada)
					agregarCantidadDePedido(det);
				
			}
			
			venta1.setOrden(orden + 1);
			orden += 1;
		}
		seCargoVentaNoEntregada = true;
	}

	public void agregar() throws Exception {
		
				if(cantidad != null && cantidad > 0){
	if(productoBuscado != null &&
	productoBuscado.getId() != null){
		
	if(primerCargarVentaNoEntregada == 0)
		primerCargarVentaNoEntregada = 1;
		
	guardarVenta1(); 
	
	} 
					
	}
			cantidad = 0;
		productoBuscado = new ProductosVenta();	
		productoSeleccionado = new ProductosVenta();
	}

	private void guardarVenta1() throws Exception {
		
		VentaRN1 v = new VentaRN1();
		
		if(venta1 != null) {
		if(venta1.getId() == null) {
	    	venta1.setEntregado("no");
	    	
	    if(clienteBuscado!= null) {
		venta1.setCliente(clienteBuscado);
		
	    if(verificarObjetoNoNull(clienteBuscado.getTelefono()))
	    	venta1.setTelefono(clienteBuscado.getTelefono());
	    }
	    
		venta1.setFechaVenta(new Date());
		
		if(direccionAEntregar!= null)
		venta1.setDireccionAEntregar(direccionAEntregar);
		
		
		
		if(destino != null && primerAgregar == 0)
			venta1.setDestino(destino);
		
		v.registraVenta1(venta1); 
		
		if (primerAgregar == 0)
		{	idUltimaVenta = v.consultarVenta1UltimoId();
		    venta1 = v.consultarUltimaVenta1(idUltimaVenta); }		 
		    deshabDestDirecc = true;
		 } }
		
	 guardarDetalleDeVenta();
	 seCargoVentaNoEntregada = false;
		cargarVentaNoEntregada();
	}
	
	private Boolean verificarObjetoNoNull(Object o) {
		if(o != null)
			return true;
		else return false;
	}
	
	private void guardarDetalleDeVenta() {
		DetalleVenta detalleVenta = new DetalleVenta();
		
		if(productoBuscado != null) {
		detalleVenta.setProductosVenta(productoBuscado);
		
		if(productoBuscado.getPrecioventa() != null)
			detalleVenta.setCosto(productoBuscado.getPrecioventa());
		}
		
		if(cantidad > 0 && cantidad != null)
			detalleVenta.setCantidad(cantidad);
		
		if(salsa != null )
			detalleVenta.setSalsa(salsa);
		
		if(venta1 != null)
		detalleVenta.setVenta(venta1);
		
		agregarCantidadDePedido(detalleVenta);
		
		DetalleVentaRN d = new DetalleVentaRN();
		d.registraDetalleVenta(detalleVenta);	
		
		/**/
		 if(primerAgregar == 0) {
			 detalleVenta.setVenta(venta1);
			 venta1.getListaDetalle().add(detalleVenta);
			 
		 }
		 
		 primerAgregar += 1;
		 /**/
	}
	
	public void nuevoCliente() {
		    clienteBuscado = new Persona();
			cliente = new Persona();
			direccionAEntregar = "";
			salsa = "";		
			venta1 = new Venta1();
			primerAgregar = 0;
			deshabDestDirecc = false;
			}
	
	public void cerrarFormCantPedido() {
		setMostrarFormularioCantPedido(false);	}
	
	public void verCantPedidos() {
		setMostrarFormularioCantPedido(true);}
	
	public void elegirClienteAutoComplete() throws Exception {

		if(clienteBuscado!= null) {
		if(clienteBuscado.getNombres() != null && clienteBuscado.getApellidos() != null) 
						
		if (clienteBuscado.getDireccion() != null)
		setDireccionAEntregar(clienteBuscado.getDireccion());
		listaClientes = new ArrayList<Cliente>();
			
		}
	}
	
		
	public List<Persona> completePersonaCliente(String nombres) throws Exception {
		
		List<Persona> listaPersonasClientesBuscados = new ArrayList<Persona>();
		
		try { PersonaRN crn = new PersonaRN();
		
		if(nombres != null) {
listaPersonasClientesBuscados = crn.listarPersonasClientesPorNombres(nombres); 
		}
if(listaPersonasClientesBuscados == null) {
	listaPersonasClientesBuscados = new ArrayList<Persona>();
}
	
	}
		catch(Exception e) {
	m.mostrarMensajeError("Error al listar Clientes! " + e.getMessage());
		}
	return listaPersonasClientesBuscados;
	}

	

public void correrAjax() {}

public void buscarProductoPorCodigo() {
	ProductosVentaRN productoRN = new ProductosVentaRN();
	setProductoBuscado(new ProductosVenta());
	
	if(productoSeleccionado.getCodigo() != null
			&& ! productoSeleccionado.getCodigo().equals("")) {
		
		try {
setProductoBuscado(productoRN.buscarProductoVentaPorCodigo(productoSeleccionado.getCodigo()));
		} catch (Exception e) {
			m.mostrarMensajeError(e.getMessage());
		}
	}
	productoSeleccionado = new ProductosVenta();
}
	
@SuppressWarnings("unused")
private String buscarProductoPorNombreCorto() throws Exception {
		
		ProductosVentaRN productoRN = new ProductosVentaRN();
		setProductoBuscado(new ProductosVenta());
		
		if(productoSeleccionado.getNombrecorto() != null
				&& ! productoSeleccionado.getNombrecorto().equals("")) {
			
			setProductoBuscado(productoRN.buscarProductoVentaPorNombreCorto(productoSeleccionado.getNombrecorto()));
		}
		productoSeleccionado = new ProductosVenta();
		return null;
	}

private void agregarCantidadDePedido(DetalleVenta d) {
	
	if(listaProductos != null && !listaProductos.isEmpty()) {
	
	for (ProductosVenta p : listaProductos) {
		if(p.getCantPedido() == null) {
			p.setCantPedido(0);
		}
		if(p.getNombre().equals(d.getProductosVenta().getNombre())) {
			p.setCantPedido(p.getCantPedido() + d.getCantidad());
		}
	}
	}
}

private void restarCantidadPedido(DetalleVenta d) {

	if(listaProductos != null && !listaProductos.isEmpty()) {
		
		for (ProductosVenta p : listaProductos) {
			if(p.getCantPedido() == null) {
				p.setCantPedido(0);
			}
			
	if(p.getNombre().equals(d.getProductosVenta().getNombre()) 
			&& p.getCantPedido() > 0) {
	p.setCantPedido(p.getCantPedido() - d.getCantidad());
			}
	} }
}

public void eliminarDetalle(DetalleVenta d) throws Exception {
	DetalleVentaRN detalleVentaRN = new DetalleVentaRN();
	
	d.setEliminado("si");
	
	detalleVentaRN.eliminar(d);
	seCargoVentaNoEntregada = false;
	
	restarCantidadPedido(d);
	
	if(primerAgregar == 0) {
		primerAgregar = 1;
		cargarVentaNoEntregada();
		primerAgregar = 0;} 
	else
		cargarVentaNoEntregada();
}

public RegistroVentas1() {
	try {
		listaProductos = new ProductosVentaRN().listar();
		cargarVentaNoEntregada();
		
	} catch (Exception e) {
m.mostrarMensajeError("Error al intentar listar productos: " + e.getMessage());
	}
}

private static final long serialVersionUID = -4783795830738592256L;
private Venta1 venta1 = new Venta1() ;
private ProductosVenta productoSeleccionado = new ProductosVenta();
private ProductosVenta productoBuscado;
private Integer cantidad;
private String destino;
private List<Venta1> lista = new ArrayList<Venta1>();
private List<DetalleVenta> listaDetalle = new ArrayList<DetalleVenta>();
private List<ProductosVenta> listaProductos;
private String entregado ;
private Venta1 ventaEntregada1;
private Persona cliente;
private String espacio = " ";
private List<Cliente> listaClientes;
private Persona clienteBuscado;
private String direccionAEntregar;
private String salsa;
private MensajesController m = new MensajesController();
private boolean mostrarFormularioCliente = false;
private boolean mostrarFormularioCantPedido = false;
private Long idUltimaVenta;
private int primerAgregar = 0;
private int primerCargarVentaNoEntregada = 0;
private boolean deshabDestDirecc = false;

public Venta1 getVenta1() {
		return venta1;
	}
	public void setVenta1(Venta1 venta1) {
		this.venta1 = venta1;
	}

	public ProductosVenta getProductoSeleccionado() {
		return productoSeleccionado;
	}

	public void setProductoSeleccionado(ProductosVenta productoSeleccionado) {
		this.productoSeleccionado = productoSeleccionado;
	}

	public ProductosVenta getProductoBuscado() {
		return productoBuscado;
	}

	public void setProductoBuscado(ProductosVenta productoBuscado) {
		this.productoBuscado = productoBuscado;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public List<Venta1> getLista() {
		return lista;
	}

	public void setLista(List<Venta1> lista) {
		this.lista = lista;
	}

	public List<ProductosVenta> getListaProductos() throws Exception {
		return listaProductos;	}

	public void setListaProductos(List<ProductosVenta> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public String getEntregado() {
		return entregado;
	}

	public void setEntregado(String entregado) {
		this.entregado = entregado;
	}

	public Venta1 getVentaEntregada1() {
		return ventaEntregada1;
	}

	public void setVentaEntregada1(Venta1 ventaEntregada1) {
		this.ventaEntregada1 = ventaEntregada1;
	}

	public Persona getCliente() {
		return cliente;
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public Persona getClienteBuscado() {
		return clienteBuscado;
	}

	public void setClienteBuscado(Persona clienteBuscado) {
		this.clienteBuscado = clienteBuscado;
	}

	public void setCliente(Persona cliente) {
		this.cliente = cliente;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getDireccionAEntregar() {
		return direccionAEntregar;
	}

	public void setDireccionAEntregar(String direccionAEntregar) {
		this.direccionAEntregar = direccionAEntregar;
	}

	public String getSalsa() {
		return salsa;
	}

	public void setSalsa(String salsa) {
		this.salsa = salsa;
	}

	public boolean isMostrarFormularioCliente() {
		return mostrarFormularioCliente;
	}

	public void setMostrarFormularioCliente(boolean mostrarFormularioCliente) {
		this.mostrarFormularioCliente = mostrarFormularioCliente;
	}

	public boolean isMostrarFormularioCantPedido() {
		return mostrarFormularioCantPedido;
	}

	public void setMostrarFormularioCantPedido(boolean mostrarFormularioCantPedido) {
		this.mostrarFormularioCantPedido = mostrarFormularioCantPedido;
	}

	public String getEspacio() {
		return espacio;
	}

	public void setEspacio(String espacio) {
		this.espacio = espacio;
	}

	public Long getIdUltimaVenta() {
		return idUltimaVenta;
	}

	public void setIdUltimaVenta(Long idUltimaVenta) {
		this.idUltimaVenta = idUltimaVenta;
	}

	public List<DetalleVenta> getListaDetalle() {
		return listaDetalle;
	}

	public void setListaDetalle(List<DetalleVenta> listaDetalle) {
		this.listaDetalle = listaDetalle;
	}

	public int getPrimerAgregar() {
		return primerAgregar;
	}

	public void setPrimerAgregar(int primerAgregar) {
		this.primerAgregar = primerAgregar;
	}

	public int getPrimerCargarVentaNoEntregada() {
		return primerCargarVentaNoEntregada;
	}

	public void setPrimerCargarVentaNoEntregada(int primerCargarVentaNoEntregada) {
		this.primerCargarVentaNoEntregada = primerCargarVentaNoEntregada;
	}

	public boolean isDeshabDestDirecc() {
		return deshabDestDirecc;
	}

	public void setDeshabDestDirecc(boolean deshabDestDirecc) {
		this.deshabDestDirecc = deshabDestDirecc;
	}
/*public List<Cliente> completeCliente(String nombres) throws Exception {
	
		List<Cliente> listaClientesBuscados = new ArrayList<Cliente>();
		
		try { ClienteRN crn = new ClienteRN();
		
		if(nombres != null) {
listaClientesBuscados = crn.listarClientesPorNombres(nombres); 
		}
if(listaClientesBuscados == null) {
	listaClientesBuscados = new ArrayList<Cliente>();
}
	
	}
		catch(Exception e) {
	m.mostrarMensajeError("Error al listar Clientes! " + e.getMessage());
	m.escribirArchivo("Clase: RegistroVentas, "
			+ "Línea: , Método: completeCliente, Exception: " + e.getMessage());
		}
	return listaClientesBuscados;
	}
*/
	
}
