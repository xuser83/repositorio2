package jaumina.entidades.ventas1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import jaumina.commons.util.MensajesController;
import jaumina.entidades.cliente.Cliente;
import jaumina.entidades.cliente.ClienteRN;
import jaumina.entidades.delivery.Delivery;
import jaumina.entidades.detalleventa.DetalleVenta;
import jaumina.entidades.detalleventa.DetalleVentaRN;
import jaumina.entidades.productosventa.ProductosVenta;
import jaumina.entidades.productosventa.ProductosVentaRN;
/*Diego Manuel Benitez Enciso 
 * Luque - Domingo 08-07-2018*/
@ManagedBean(name = "entregarVentaBean")
@ViewScoped
public class EntregarVentaBean implements Serializable {
	
	private static final long serialVersionUID = 5925947590564761083L;
	private Venta1 venta1 = new Venta1();
	private Cliente cliente = new Cliente();
	private String espacio = " ";
	private MensajesController m = new MensajesController();
	private Delivery delivery = new Delivery();
	private String direccionAEntregar;
	private String telefonoCliente;
	private ProductosVenta productoSeleccionado = new ProductosVenta();
	private Integer cantidad; 
	private String destino;
	private String salsa;
	private List<DetalleVenta> listaDetalle = new ArrayList<DetalleVenta>();
	private List<Venta1> listaUltimasVentasDelCliente = new ArrayList<Venta1>();
	private Date fechaDesde;
	private Date fechaHasta;
	
	public void agregar() throws Exception {
		
		if(cantidad != null && cantidad > 0){
if(productoSeleccionado != null &&
productoSeleccionado.getId() != null){

guardarVenta1(); 

}}
	cantidad = 0;
	
productoSeleccionado = new ProductosVenta();
}

	private void guardarVenta1() throws Exception {
		
	DetalleVenta detalleVenta = new DetalleVenta();
	if(productoSeleccionado != null) {
	detalleVenta.setProductosVenta(productoSeleccionado);
	
	if(productoSeleccionado.getPrecioventa() != null)
		detalleVenta.setCosto(productoSeleccionado.getPrecioventa());
	}
	
	if(salsa != null)
	detalleVenta.setSalsa(salsa);
	
	if(cantidad != null && cantidad > 0)
	detalleVenta.setCantidad(cantidad);
	
	if(venta1 != null)
	detalleVenta.setVenta(venta1);
	
	DetalleVentaRN drn = new DetalleVentaRN();
	drn.registraDetalleVenta(detalleVenta);		
		
	if(primerAgregar) {
		 detalleVenta.setVenta(venta1);
		 venta1.getListaDetalle().add(detalleVenta);
		 setPrimerAgregar(false);		 
	 } else {
		 VentaRN1 vr = new VentaRN1();
		 if(venta1 != null && venta1.getId() != null) {
		 venta1 = vr.consultarVenta1PorId(venta1.getId());
		 
		 if(venta1.getListaDetalle() != null)
		 listaDetalle = venta1.getListaDetalle();
		 }
	 }
	}
private Boolean primerAgregar = true;
	public void eliminarDetalle(DetalleVenta d) throws Exception {
		DetalleVentaRN detalleVentaRN = new DetalleVentaRN();
				
		if(d != null)
		detalleVentaRN.eliminar(d);
		
		if(venta1.getListaDetalle() != null)
		listaDetalle = venta1.getListaDetalle();
		
		consultarVenta1();
	}
	
	public void buscarProductoPorCodigo() {
		ProductosVentaRN productoRN = new ProductosVentaRN();
		
		if(productoSeleccionado.getCodigo() != null
				&& ! productoSeleccionado.getCodigo().equals("")) {
			
			try {
	setProductoSeleccionado(productoRN.buscarProductoVentaPorCodigo(productoSeleccionado.getCodigo()));
			} catch (Exception e) {
				m.mostrarMensajeError(e.getMessage());
			}
		}
	}
	
	public void consultarVenta1() throws Exception {
		
		VentaRN1 vr = new VentaRN1();
		
		if(venta1 != null && venta1.getId() != null) {
			
			venta1 = vr.consultarVenta1PorId(venta1.getId());
			
			if(venta1.getCliente() != null) {
			cliente = venta1.getCliente();
			
			if(venta1.getCliente().getTelefono() != null)
				telefonoCliente = venta1.getCliente().getTelefono();			
			}
			
			if(venta1.getDireccionAEntregar() != null)
				direccionAEntregar = venta1.getDireccionAEntregar();
			
			if(venta1.getListaDetalle() != null) {
				listaDetalle = venta1.getListaDetalle(); }
			else listaDetalle = new ArrayList<DetalleVenta>();
			
		} else	if (cliente != null && fechaDesde != null && fechaHasta != null) {
			listaUltimasVentasDelCliente = vr.consultarVentaPorFecha(fechaDesde, fechaHasta, cliente);
					} 
	}
	
public void entregar(DetalleVenta d) throws Exception {	
		
	if(d != null && d.getVenta() != null) {
		
		d.getVenta().setEntregado("si");
		
		VentaRN1 v = new VentaRN1();
		v.modificar(d.getVenta()); }
				
		new MensajesController().imprimirDetalleVenta(d.getVenta().getListaDetalle());
		
	}
	
	public Delivery getDelivery() {
		return delivery;
	}

	public String getDireccionAEntregar() {
		return direccionAEntregar;
	}

	public String getTelefonoCliente() {
		return telefonoCliente;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}

	public void setDireccionAEntregar(String direccionAEntregar) {
		this.direccionAEntregar = direccionAEntregar;
	}

	public void setTelefonoCliente(String telefonoCliente) {
		this.telefonoCliente = telefonoCliente;
	}

	public List<Cliente> completeCliente(String nombres) throws Exception {
		
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
		}
	return listaClientesBuscados;
	}
	
	public void elegirClienteAutoComplete() throws Exception {

		if(cliente != null) {
			
		}
	}

	
	public Venta1 getVenta1() {
		return venta1;
	}

	public void setVenta1(Venta1 venta1) {
		this.venta1 = venta1;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getEspacio() {
		return espacio;
	}

	public void setEspacio(String espacio) {
		this.espacio = espacio;
	}

	public ProductosVenta getProductoSeleccionado() {
		return productoSeleccionado;
	}

	public void setProductoSeleccionado(ProductosVenta productoSeleccionado) {
		this.productoSeleccionado = productoSeleccionado;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public List<DetalleVenta> getListaDetalle() {
		return listaDetalle;
	}

	public void setListaDetalle(List<DetalleVenta> listaDetalle) {
		this.listaDetalle = listaDetalle;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getDestino() {
		return destino;
	}

	public String getSalsa() {
		return salsa;
	}

	public Date getFechaDesde() {
		return fechaDesde;
	}

	public Date getFechaHasta() {
		return fechaHasta;
	}

	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public void setSalsa(String salsa) {
		this.salsa = salsa;
	}

	public Boolean getPrimerAgregar() {
		return primerAgregar;
	}

	public void setPrimerAgregar(Boolean primerAgregar) {
		this.primerAgregar = primerAgregar;
	}

	public List<Venta1> getListaUltimasVentasDelCliente() {
		return listaUltimasVentasDelCliente;
	}

	public void setListaUltimasVentasDelCliente(List<Venta1> listaUltimasVentasDelCliente) {
		this.listaUltimasVentasDelCliente = listaUltimasVentasDelCliente;
	}

}
