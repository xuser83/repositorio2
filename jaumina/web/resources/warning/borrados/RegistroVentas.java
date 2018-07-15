package jaumina.entidades.ventas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import jaumina.commons.util.MensajesController;
import jaumina.entidades.cliente.Cliente;
import jaumina.entidades.cliente.ClienteRN;
import jaumina.entidades.productosventa.ProductosVenta;
import jaumina.entidades.productosventa.ProductosVentaRN;

@ManagedBean(name = "registroVentas")
@ViewScoped
public class RegistroVentas implements Serializable{
	
	public void cargarPedido() {
		try {
			cargarPedidoNoEntregado();
if(lista != null && !lista.isEmpty()) {
	seObtuvoUltimoNroPedido = true;
	
	if(listaProductos != null && !listaProductos.isEmpty()) {
		for(ProductosVenta p : listaProductos) {p.setCantPedido(0);	}
	for(Venta venta : lista) {
		for(ProductosVenta p : listaProductos) {
		if(venta.getProductosVenta().getNombre().equals(p.getNombre())){
			p.setCantPedido(p.getCantPedido() + venta.getCantidad());
		}
		}
	}}
	
	
} else{seObtuvoUltimoNroPedido = false;}			
			
	} catch (Exception e) {
		m.mostrarMensajeError("Error al intentar cargar pedido: " + e.getMessage());
		}
	mostrarFormularioCantPedido = false;
	}
	
	private void cargarPedidoNoEntregado() throws Exception {
		if(nroPedido != null && nroPedido != 0) {
		VentaRN v = new VentaRN();
	//	lista = v.consultarVentaPorNroPedido(nroPedido, "no");
		lista = v.listarVentasPorNroPedidoElegirCanceladas(nroPedido, "no", "no");
		
		if(lista.isEmpty() || lista == null) {
			seObtuvoUltimoNroPedido = false;
		}
		
		Integer orden = 0;
		for (Venta venta : lista) {
			venta.setOrden(orden + 1);
			orden += 1;
		}}
	}

	public void nuevoCliente() {
		    clienteBuscado = new Cliente();
			cliente = "";
			telefonoCliente = "";
			direccionAEntregar = "";
			salsa = "";		}
	
	public void cerrarFormCantPedido() {
		setMostrarFormularioCantPedido(false);	}
	
	public void verCantPedidos() {
		setMostrarFormularioCantPedido(true);}
	
	public void buscarCliente() throws Exception {
try {
	ClienteRN crn = new ClienteRN();
	if(cliente != null && !cliente.equals("")) {
	listaClientes = crn.listarClientesPorNombres(cliente);}
	else {}
} catch (Exception e) {
	m.mostrarMensajeError("Error al buscar cliente: " + e.getMessage());
}
if(listaClientes!= null && !listaClientes.isEmpty()) {
	mostrarFormularioCliente = true;
} else {mostrarFormularioCliente = false;}
	}
	
	public void elegirCliente(Cliente cliente) {
		if(cliente != null) {
		clienteBuscado = cliente;
		this.cliente = clienteBuscado.getNombres() + " " + clienteBuscado.getApellidos();
		setTelefonoCliente(clienteBuscado.getTelefono());
		setDireccionAEntregar(clienteBuscado.getDireccion());
		mostrarFormularioCliente = false;
		listaClientes = new ArrayList<Cliente>();}
		System.out.println("elegirCliente(cliente) - Cliente: " + cliente);
	}
	
	public void elegirCliente() {
		cliente = clienteBuscado.getNombres() + " " + clienteBuscado.getApellidos();
		setTelefonoCliente(clienteBuscado.getTelefono());
		setDireccionAEntregar(clienteBuscado.getDireccion());
		mostrarFormularioCliente = false;
		listaClientes = new ArrayList<Cliente>();
		System.out.println("elegirCliente()...");
	}
	
	public void elegirClienteAutoComplete() throws Exception {

		if(clienteBuscado!= null) {
			if(cliente != null) {
		if(clienteBuscado.getNombres() != null && clienteBuscado.getApellidos() != null) 
		cliente = clienteBuscado.getNombres() + " " + clienteBuscado.getApellidos();
				
		if(clienteBuscado.getTelefono() != null)		
		setTelefonoCliente(clienteBuscado.getTelefono());
		
		if (clienteBuscado.getDireccion() != null)
		setDireccionAEntregar(clienteBuscado.getDireccion());
		listaClientes = new ArrayList<Cliente>();}
			
		}
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
	m.escribirArchivo("Clase: RegistroVentas, "
			+ "Línea: , Método: completeCliente, Exception: " + e.getMessage());
		}
	return listaClientesBuscados;
	}

	public void quitar(Venta item) throws Exception {
	
if(item != null && item.getCliente() != null) {
		if(item.getCliente().equals("")) {
		ventaEntregada = item;
	entregado();}
		else {
	entregarACliente(item);
		}		
}
	}

	public void cancelarVenta(Venta item) {
VentaRN ventaRN = new VentaRN();
try { if(item!= null) {
item.setVentacancelada("si");

if(listaProductos != null && !listaProductos.isEmpty()) {
	
	for (ProductosVenta p : listaProductos) {
		if(p.getCantPedido() == null) {
			p.setCantPedido(0);
		}
		
if(p.getNombre().equals(item.getProductosVenta().getNombre()) 
		&& p.getCantPedido() > 0) {
p.setCantPedido(p.getCantPedido() - item.getCantidad());
		}} }

ventaRN.modificar(item);

cargarPedidoNoEntregado();

}}catch(Exception e) {
	m.mostrarMensajeError("Error al intentar cancelar venta! " + e.getMessage());
}
	} 
	
private void entregarACliente(Venta item) {

		if(item != null) {
try {

	VentaRN vrn = new VentaRN();
	
List<Venta> listaAEntregar = 
vrn.listarVentaAEntregar(item.getCliente(), item.getNroPedido().toString(),"no","no");

if(listaAEntregar!= null && !listaAEntregar.isEmpty()) {
	for (Venta venta : listaAEntregar) {
		venta.setEntregado("si");
		vrn.modificar(venta);		
		
		if(listaProductos != null && !listaProductos.isEmpty()) {
			
			for (ProductosVenta p : listaProductos) {
				if(p.getCantPedido() == null) {
					p.setCantPedido(0);
				}
				
		if(p.getNombre().equals(venta.getProductosVenta().getNombre()) 
				&& p.getCantPedido() > 0) {
		p.setCantPedido(p.getCantPedido() - venta.getCantidad());
				}}}
		
	}
	
}
	
	cargarPedidoNoEntregado();
	if(listaProductos != null && !listaProductos.isEmpty()) {
	agregarCantidadDePedido();	}
	
	m.imprimirVenta(listaAEntregar);
		
} catch (Exception e) {
m.mostrarMensajeError("Error al intentar entragar venta: " + e.getMessage());
}
		}
	}

	private void entregado() throws Exception {
		if(ventaEntregada != null){
if(listaProductos != null && !listaProductos.isEmpty()) {
	
	for (ProductosVenta p : listaProductos) {
		if(p.getCantPedido() == null) {
			p.setCantPedido(0);
		}
		
if(p.getNombre().equals(ventaEntregada.getProductosVenta().getNombre()) 
		&& p.getCantPedido() > 0) {
p.setCantPedido(p.getCantPedido() - ventaEntregada.getCantidad());
		}} }
	
	VentaRN v = new VentaRN();

	ventaEntregada.setEntregado("si");

	v.modificar(ventaEntregada);
	
	cargarPedidoNoEntregado();	
	
	List<Venta> listaDeProductoEntregado = new ArrayList<Venta>();
	listaDeProductoEntregado.add(ventaEntregada);
	m.imprimirVenta(listaDeProductoEntregado);
	
} else {m.mostrarMensajeError("Venta entregada es null!");}
	}	
	
	private void obtenerUltimoNroPedido() {
		
		if(!seObtuvoUltimoNroPedido){
		
		VentaRN vid = new VentaRN();
		try {
			if(vid.consultarVentaUltimoId() != null) {
			Integer ultimoId = vid.consultarVentaUltimoId();
			Venta ultimaVenta = vid.buscarVentaPorId(ultimoId);
			setNroPedido(ultimaVenta.getNroPedido() + 1);
			seObtuvoUltimoNroPedido = true;
} else {
			setNroPedido(1);
			seObtuvoUltimoNroPedido = true;}
		} catch (Exception e) {
		m.mostrarMensajeError("Error al intentar obtener nro pedido: " + e.getMessage());
		}}	}
	
public void agregar() throws Exception {
	
	obtenerUltimoNroPedido();
	
		if(cantidad != null && cantidad > 0){
if(productoBuscado != null &&
productoBuscado.getId() != null){
			
if(destino != null && destino != ""){
venta.setDestino(destino);
guardarVenta(); 
}
cargarPedidoNoEntregado();
if(listaProductos != null && !listaProductos.isEmpty()) {
agregarCantidadDePedido();	}
} 
				
}
		cantidad = 0;
	productoBuscado = new ProductosVenta();	
	productoSeleccionado = new ProductosVenta();
}

private void guardarVenta() {
	venta.setEntregado("no");
	venta.setProductosVenta(productoBuscado);
	venta.setCosto(productoBuscado.getPrecioventa());
	venta.setCantidad(cantidad);
	venta.setCliente(cliente);
	venta.setTelefonoCliente(telefonoCliente);
	venta.setFechaVenta(new Date());
	venta.setNroPedido(nroPedido);
	venta.setDireccionAEntregar(direccionAEntregar);
	venta.setSalsa(salsa);
	venta.setVentacancelada("no");
	VentaRN v = new VentaRN();
	v.registraVenta(venta);
	venta = new Venta();
}

private void agregarCantidadDePedido() {
	for (ProductosVenta p : listaProductos) {
		if(p.getCantPedido() == null) {
			p.setCantPedido(0);
		}
		if(p.getNombre().equals(productoBuscado.getNombre())) {
			p.setCantPedido(p.getCantPedido() + cantidad);
		}
	}
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
	

public RegistroVentas() {
	try {
		listaProductos = new ProductosVentaRN().listar();
		setCliente("");
	} catch (Exception e) {
m.mostrarMensajeError("Error al intentar listar productos: " + e.getMessage());
	}
}

private static final long serialVersionUID = -4783795830738592256L;
private Venta venta = new Venta() ;
private ProductosVenta productoSeleccionado = new ProductosVenta();
private ProductosVenta productoBuscado;
private Integer cantidad;
private String destino;
private List<Venta> lista = new ArrayList<Venta>();
private List<ProductosVenta> listaProductos;
private Boolean seObtuvoUltimoNroPedido = false;
private Integer nroPedido = 0;
private String entregado ;
private Venta ventaEntregada;
private String cliente;
private String espacio = " ";
private List<Cliente> listaClientes;
private Cliente clienteBuscado;
private String telefonoCliente;
private String direccionAEntregar;
private String salsa;
private MensajesController m = new MensajesController();
private boolean mostrarFormularioCliente = false;
private boolean mostrarFormularioCantPedido = false;

public Venta getVenta() {
		return venta;
	}
	public void setVenta(Venta venta) {
		this.venta = venta;
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

	public List<Venta> getLista() {
		return lista;
	}

	public void setLista(List<Venta> lista) {
		this.lista = lista;
	}

	public List<ProductosVenta> getListaProductos() throws Exception {
		return listaProductos;	}

	public void setListaProductos(List<ProductosVenta> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public Integer getNroPedido() {
		return nroPedido;
	}

	public void setNroPedido(Integer nroPedido) {
		this.nroPedido = nroPedido;
	}

	public String getEntregado() {
		return entregado;
	}

	public void setEntregado(String entregado) {
		this.entregado = entregado;
	}

	public Venta getVentaEntregada() {
		return ventaEntregada;
	}

	public void setVentaEntregada(Venta ventaEntregada) {
		this.ventaEntregada = ventaEntregada;
	}

	public String getTelefonoCliente() {
		return telefonoCliente;
	}

	public void setTelefonoCliente(String telefonoCliente) {
		this.telefonoCliente = telefonoCliente;
	}

	public String getCliente() {
		return cliente;
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public Cliente getClienteBuscado() {
		return clienteBuscado;
	}

	public void setClienteBuscado(Cliente clienteBuscado) {
		this.clienteBuscado = clienteBuscado;
	}

	public void setCliente(String cliente) {
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

	
/*private String fechaActualFormateada() {
	   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

       Date date = new Date();
       String dateformat = "";
       try {
           
           sdf.applyPattern("dd-MMM-yyyy HH:mm");
           dateformat = sdf.format(date);
       } catch (Exception e) {
  m.mostrarMensajeError("Error al intentar formatear fecha! " + e.getMessage());
       }
       return dateformat;
}*/

	/*private void imprimirVenta(List<Venta> listaVenta) {
		if(listaVenta != null && !listaVenta.isEmpty()) {
		List<String> listaString = new ArrayList<String>();
		String nombreProducto = null;
		
		listaString.add(fechaActualFormateada());
		listaString.add("Ja'umiina - Gracias por su Compra!");
		listaString.add("Cliente: " + listaVenta.get(0).getCliente());
		listaString.add("Prod           Cant   Precio");
		Integer total = 0;
		for (Venta venta : listaVenta) {
			nombreProducto = venta.getProductosVenta().getNombrecorto(); 
			if(nombreProducto.length() > 10) {
	nombreProducto = nombreProducto.substring(0,10); 
			} else {
				if(nombreProducto.length() == 1) {nombreProducto = nombreProducto.concat("                   ");}
				if(nombreProducto.length() == 2) {nombreProducto = nombreProducto.concat("                  ");}
				if(nombreProducto.length() == 3) {nombreProducto = nombreProducto.concat("             ");}
				if(nombreProducto.length() == 4) {nombreProducto = nombreProducto.concat("            ");}
				if(nombreProducto.length() == 5) {nombreProducto = nombreProducto.concat("           ");}
				if(nombreProducto.length() == 6) {nombreProducto = nombreProducto.concat("         ");}
				if(nombreProducto.length() == 7) {nombreProducto = nombreProducto.concat("       ");}
				if(nombreProducto.length() == 8) {nombreProducto = nombreProducto.concat("     ");}
			}
			
			
			listaString.add(nombreProducto + "  " + venta.getCantidad() + "   " + formatearNumero(venta.getCosto().toString()));
		total += venta.getCantidad() * venta.getCosto();
		
		}
		String totalString = String.valueOf(total);
		
		
		listaString.add("Total: " + formatearNumero(totalString) + " Gs.");
		
		ObjetoDeImpresion o = new ObjetoDeImpresion();
		o.setLista(listaString);
		
		PrinterJob job = PrinterJob.getPrinterJob();
		job.setPrintable(o);
		
		try{
		job.print();
		}catch(PrinterException e){
		System.out.println(e);
		}
		
		} else {
			m.mostrarMensaje(FacesMessage.SEVERITY_INFO,"Aviso!","Lista a mostrar esta vacia!");
		}
	}*/
	
	/*private String formatearNumero(String numero) {
		boolean formateado = false;
		if(numero.length() == 4 && !formateado) {
			String s1 = numero.substring(0, 1);
			String s3 = numero.substring(1, 4);
			numero = s1.concat(".").concat(s3);
			formateado = true;
		}
		
		if(numero.length() == 5 && !formateado) {
			String s1 = numero.substring(0, 2);
			String s3 = numero.substring(2, 5);
			numero = s1.concat(".").concat(s3);
			formateado = true;
		}
		
		if(numero.length() == 6 && !formateado) { 
			String s1 = numero.substring(0, 3);
			String s3 = numero.substring(3, 6);
			numero = s1.concat(".").concat(s3);
			formateado = true;
		}
		
		if(numero.length()==7 && !formateado) {  // 1.000.000
			String s0 = numero.substring(0,1);
			String s1 = numero.substring(1, 4);
			String s3 = numero.substring(4,7);
			numero = s0.concat(".").concat(s1).concat(".").concat(s3);
			formateado = true;
		}
		
		return numero;
	}*/
	

/*private void testVerCantTotalPedidos() {
	if(listaProductos != null && !listaProductos.isEmpty()) {
		for (ProductosVenta p: listaProductos) {
if(p.getCantPedido() > 0 && p.getCantPedido() != null){
			System.out.println(p.getNombre() + " " + p.getCantPedido());
}}
	}
}*/

/*private void evitarNull() {
	if(cliente == null)  {cliente = "";}
	if(telefonoCliente == null)  {telefonoCliente = "";}
	if(direccionAEntregar == null)  {direccionAEntregar = "";}
}*/
}
