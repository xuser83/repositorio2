package jaumina.commons.util;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

import jaumina.entidades.cliente.Cliente;
import jaumina.entidades.detalleventa.DetalleVenta;
import jaumina.entidades.productosventa.ProductosVenta;
import jaumina.entidades.ventas1.Venta1;
import jaumina.entidades.ventas1.PedidoAImprimir1;
//import jaumina.entidades.ventas.PedidoAImprimir;
//import jaumina.entidades.ventas.Venta;


public class MensajesController
implements Serializable, MensajesUtil {
	/**
	* Asuncion - Paraguay 
	* 06/08/2016
	* @author Diego Manuel Benitez Enciso
	*/
	private static final long serialVersionUID = 5651071482932506068L;
	public MensajesController() {}
	
	

@Override
public void mostrarMensaje(	Severity severity,
									String resumen,
									String detalle) {
	FacesContext.getCurrentInstance()
	.addMessage(null, new FacesMessage(
severity, resumen,detalle));
}

@Override
public  void mostrarMensajeSeModifico() {
FacesContext.getCurrentInstance()
.addMessage(null, new FacesMessage(
FacesMessage.SEVERITY_INFO, "Modificado!",
"Modificado con Éxito"));
}

@Override
public void mostrarMensajeSeGuardo() {
FacesContext.getCurrentInstance()
.addMessage(null, new FacesMessage(
FacesMessage.SEVERITY_INFO, "Guardado!",
"Guardado con Éxito"));
}

@Override
public void mostrarMensajeSeElimino() {
FacesContext.getCurrentInstance()
.addMessage(null, new FacesMessage(
FacesMessage.SEVERITY_INFO, "Se Elimino!",
"Eliminado con Éxito"));}

@Override
public void mostrarMensajeError(String exceptionMessage) {
FacesContext.getCurrentInstance()
.addMessage(null, new FacesMessage(
FacesMessage.SEVERITY_FATAL, "Error!",
"Error!: " + exceptionMessage));
}

@Override
public void mostrarMensajeErrorGuardar(String exceptionMessage) {
FacesContext.getCurrentInstance()
.addMessage(null, new FacesMessage(
FacesMessage.SEVERITY_FATAL, "Error!",
"Error al intentar guardar!: " + exceptionMessage));
}

@Override
public void mostrarMensajeErrorModificar(String exceptionMessage) {
FacesContext.getCurrentInstance()
.addMessage(null, new FacesMessage(
FacesMessage.SEVERITY_FATAL, "Error!",
"Error al intentar modificar!: " + exceptionMessage));
}

@Override
public void mostrarMensajeErrorEliminar(String exceptionMessage) {
FacesContext.getCurrentInstance()
.addMessage(null, new FacesMessage(
FacesMessage.SEVERITY_FATAL, "Error!",
"Error al intentar eliminar!: " + exceptionMessage));
}

private FileWriter archivo = null;
private PrintWriter printer = null;
@Override
public void escribirArchivo(String string) {
	try {
		archivo = new FileWriter("C:\\ultra\\diego.txt", true);
		
		
		printer = new PrintWriter(archivo);
		
		printer.println(" ");
		printer.println(" ");
		printer.println(  new Date());
		
		printer.print(string);
	} catch (Exception e) {
	System.out.println("Error al intentar escribir Archivo!" + e.getMessage());
	} finally {
		if(archivo != null){
		try {
			archivo.close();
		} catch (IOException e) {
			System.out.println("Error al intentar cerrar archivo!" + e.getMessage());
		}}
	}
}

/*Inicio imprimirDetalleVenta*/
@Override
public void imprimirDetalleVenta(List<DetalleVenta> listaDetalle) {
	
	if(listaDetalle != null && !listaDetalle.isEmpty()) {
	
		List<PedidoAImprimir1> listaPedido  = new ArrayList<PedidoAImprimir1>();
	String nombreProducto = null;
	Integer vertical = 100;
	/**/
	Integer horizontalInicial = 71;
	Integer horizontal = horizontalInicial;
	
	listaPedido.add(new PedidoAImprimir1(fechaActualFormateada(), horizontal, vertical));
	vertical += 11;
	listaPedido.add(new PedidoAImprimir1("Ja'umiina - Gracias por su Compra!", horizontal, vertical));
	vertical += 11;
	listaPedido.add(new PedidoAImprimir1("Av. Cerro Corá c/ Campo Vía", horizontal, vertical));
	vertical += 11;
	listaPedido.add(new PedidoAImprimir1("Watsapp: 0975 927 056", horizontal, vertical));
	vertical += 11;
	Venta1 venta1 = listaDetalle.get(0).getVenta();
	listaPedido.add(new PedidoAImprimir1("Venta N°: " + venta1.getId().toString(), horizontal, vertical));
	
	vertical += 11;
	listaPedido.add(new PedidoAImprimir1("Prod", horizontal, vertical));
	horizontal += 60;
	listaPedido.add(new PedidoAImprimir1("Cant", horizontal, vertical));
	horizontal += 40;
	listaPedido.add(new PedidoAImprimir1("Prec", horizontal, vertical));
	horizontal += 40;
	listaPedido.add(new PedidoAImprimir1("Subt", horizontal, vertical));
	Integer total = 0;
	
	vertical += 11;
	
	for (DetalleVenta d : listaDetalle) {
		
		nombreProducto = d.getProductosVenta().getNombrecorto(); 
		if(nombreProducto.length() > 10) {
nombreProducto = nombreProducto.substring(0,8); 
		}
		/**/
		horizontal = horizontalInicial;
		listaPedido.add(new PedidoAImprimir1(nombreProducto, horizontal, vertical));
		horizontal += 60;
		listaPedido.add(new PedidoAImprimir1(formatearNumero(d.getCantidad().toString()), horizontal, vertical));
		horizontal += 40;
		listaPedido.add(new PedidoAImprimir1(formatearNumero(d.getCosto().toString()).toString(), horizontal, vertical));
		Integer subtotal = d.getCantidad() * d.getCosto();
		horizontal += 40;
		listaPedido.add(new PedidoAImprimir1(formatearNumero(subtotal.toString()).toString(), horizontal, vertical));
		
	total += d.getCantidad() * d.getCosto();
	vertical += 11;
	}
	
	String totalString = String.valueOf(total);
	horizontal = horizontalInicial + 30 ;
	listaPedido.add(new PedidoAImprimir1("Total: " + formatearNumero(totalString) + " Gs.", horizontal, vertical));
	
	horizontal = horizontalInicial;
	if(venta1.getCliente() != null && venta1.getCliente().getNombres() 
			!= null && venta1.getCliente().getApellidos() != null) {
				vertical += 11;
				listaPedido.add(
						new PedidoAImprimir1("Cliente: " 
				+ venta1.getCliente().getNombres() + " " 
								+ venta1.getCliente().getApellidos(), horizontal, vertical)); }
	
	if(venta1.getDireccionAEntregar() != null) {
		vertical += 11;
		if(venta1.getDireccionAEntregar().length() > 35)
			venta1.setDireccionAEntregar("Dir: " + venta1.getDireccionAEntregar().substring(0, 35));
			 listaPedido.add(new PedidoAImprimir1(venta1.getDireccionAEntregar(), horizontal, vertical));}
	
	if(venta1.getCliente().getTelefono() != null) {
		vertical += 11;
		 listaPedido.add(new PedidoAImprimir1("Tel: " + venta1.getCliente().getTelefono(), horizontal, vertical)); }
	
	/**************************************************************/
	ObjetoDeImpresion o = new ObjetoDeImpresion();
	o.setLista(listaPedido);
	
	PrinterJob job = PrinterJob.getPrinterJob();
	job.setPrintable(o);
	
	try{
	job.print();
	}catch(PrinterException e){
	System.out.println(e);
	}
	
	} else {
	mostrarMensaje(FacesMessage.SEVERITY_INFO,"Aviso!","Lista a mostrar esta vacia!");
	}
}
//fin imprimir detalle

/*probar impresora*/

public static void main(String[] args) {

	ProductosVenta p = new ProductosVenta(1, "1", "Hambur", "Hamb", 10000, 11000);
	ProductosVenta p1 = new ProductosVenta(2, "2", "Hambur Especial", "Hamb Esp", 11000, 12000);
	ProductosVenta p2 = new ProductosVenta(3, "3", "Hambur Super Especial", "Hamb Sup Es", 12000, 13000);
	ProductosVenta p3 = new ProductosVenta(4, "4", "Hambur Pollo", "Hamb Poll", 10000, 11000);
	ProductosVenta p4 = new ProductosVenta(5, "5", "Hambur Pollo Dobl", "Hamb Poll Dob", 11000, 12000);
	ProductosVenta p5 = new ProductosVenta(6, "6", "Lomito", "Lom", 10000, 11000);
	ProductosVenta p6 = new ProductosVenta(7, "7", "Lomito Especial", "Lom Esp", 11000, 12000);
	ProductosVenta p7 = new ProductosVenta(8, "8", "Coca Cola 2L", "Coc 2L", 10000, 11000);
	ProductosVenta p8 = new ProductosVenta(9, "9", "Brama Lata", "Bran Lat", 10000, 11000);
	ProductosVenta p9 = new ProductosVenta(10, "10", "Bram Botella", "Bra Bot", 10000, 11000);
	
	Cliente cliente = new Cliente();
	cliente.setApellidos("Cañete Fleitas");
	cliente.setDireccion("Tte Rojas Silva c/ Manchester.");
	cliente.setId((long) 200);
	cliente.setNombres("Marciano Aurelio");
	cliente.setNro_documento("3.555.111");
	cliente.setTelefono("+595 971 222 222");
	
	
	Venta1 venta1 = new Venta1();
	venta1.setCliente(cliente);
	venta1.setDireccionAEntregar(cliente.getDireccion());
	venta1.setFechaVenta(new Date());
	venta1.setId((long) 110);
	venta1.setTelefono(cliente.getTelefono());
	
	DetalleVenta d = new DetalleVenta();
	d.setCantidad(1110);
	d.setCosto(10000);
	d.setProductosVenta(p);
	d.setVenta(venta1);
	
	DetalleVenta d1 = new DetalleVenta();
	d1.setCantidad(1200);
	d1.setCosto(10000);
	d1.setProductosVenta(p1);
	d1.setVenta(venta1);
	
	DetalleVenta d2 = new DetalleVenta();
	d2.setCantidad(1);
	d2.setCosto(10000);
	d2.setProductosVenta(p2);
	d2.setVenta(venta1);
	
	DetalleVenta d3 = new DetalleVenta();
	d3.setCantidad(1);
	d3.setCosto(10000);
	d3.setProductosVenta(p3);
	d3.setVenta(venta1);
	
	DetalleVenta d4 = new DetalleVenta();
	d4.setCantidad(1);
	d4.setCosto(10000);
	d4.setProductosVenta(p4);
	d4.setVenta(venta1);
	
	DetalleVenta d5 = new DetalleVenta();
	d5.setCantidad(1);
	d5.setCosto(10000);
	d5.setProductosVenta(p5);
	d5.setVenta(venta1);
	
	DetalleVenta d6 = new DetalleVenta();
	d6.setCantidad(1);
	d6.setCosto(10000);
	d6.setProductosVenta(p6);
	d6.setVenta(venta1);
	
	DetalleVenta d7 = new DetalleVenta();
	d7.setCantidad(1);
	d7.setCosto(10000);
	d7.setProductosVenta(p7);
	d7.setVenta(venta1);
	
	DetalleVenta d8 = new DetalleVenta();
	d8.setCantidad(1);
	d8.setCosto(10000);
	d8.setProductosVenta(p8);
	d8.setVenta(venta1);
	
	DetalleVenta d9 = new DetalleVenta();
	d9.setCantidad(1);
	d9.setCosto(10000);
	d9.setProductosVenta(p9);
	d9.setVenta(venta1);
	
	List<DetalleVenta> listaDetalle = new ArrayList<DetalleVenta>();
	listaDetalle.add(d);
	listaDetalle.add(d1);
	listaDetalle.add(d2);
	listaDetalle.add(d3);
	listaDetalle.add(d4);
	listaDetalle.add(d5);
	listaDetalle.add(d6);
	listaDetalle.add(d7);
	listaDetalle.add(d8);
	listaDetalle.add(d9);
	
	MensajesController m = new MensajesController();
	m.imprimirDetalleVenta(listaDetalle);
}



/*fin probar impresora*/


private String formatearNumero(String numeroString) {
	boolean formateado = false;
	if(numeroString.length() == 4 && !formateado) {
		String s1 = numeroString.substring(0, 1);
		String s3 = numeroString.substring(1, 4);
		numeroString = s1.concat(".").concat(s3);
		formateado = true;
	}
	
	if(numeroString.length() == 5 && !formateado) {//10.000
		String s1 = numeroString.substring(0, 2);
		String s3 = numeroString.substring(2, 5);
		numeroString = s1.concat(".").concat(s3);
		formateado = true;
	}
	
	if(numeroString.length() == 6 && !formateado) { //100.000
		String s1 = numeroString.substring(0, 3);
		String s3 = numeroString.substring(3, 6);
		numeroString = s1.concat(".").concat(s3);
		formateado = true;
	}
	
	if(numeroString.length()==7 && !formateado) {  // 1.000.000
		String s0 = numeroString.substring(0,1);
		String s1 = numeroString.substring(1, 4);
		String s3 = numeroString.substring(4,7);
		numeroString = s0.concat(".").concat(s1).concat(".").concat(s3);
		formateado = true;
	}
	
	if(numeroString.length()==8 && !formateado) {  // 10.000.000
		String s0 = numeroString.substring(0,2);
		String s1 = numeroString.substring(2, 5);
		String s3 = numeroString.substring(5,8);
		numeroString = s0.concat(".").concat(s1).concat(".").concat(s3);
		formateado = true;
	}
	                                               // 012 345 678
	if(numeroString.length()==9 && !formateado) {  // 100.000.000
		String s0 = numeroString.substring(0,3);
		String s1 = numeroString.substring(3, 6);
		String s3 = numeroString.substring(6,9);
		numeroString = s0.concat(".").concat(s1).concat(".").concat(s3);
		formateado = true;
	}
		
	return numeroString;
}

private String fechaActualFormateada() {
	   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    Date date = new Date();
    String dateformat = "";
    try {
        
        sdf.applyPattern("dd-MMM-yyyy HH:mm");
        dateformat = sdf.format(date);
    } catch (Exception e) {
mostrarMensajeError("Error al intentar formatear fecha! " + e.getMessage());
    }
    return dateformat;
}

}
/*@Override
public void imprimirVenta(List<Venta> listaVenta) {
	
	if(listaVenta != null && !listaVenta.isEmpty()) {
	List<PedidoAImprimir> listaPedido  = new ArrayList<PedidoAImprimir>();
	String nombreProducto = null;
	
	listaPedido.add(new PedidoAImprimir(fechaActualFormateada(), 100, 100));
	listaPedido.add(new PedidoAImprimir("Ja'umiina - Gracias por su Compra!", 100, 111));
	
	if(listaVenta.get(0).getCliente() != null) {
	listaPedido.add(new PedidoAImprimir("Cliente: " + listaVenta.get(0).getCliente(), 100, 122)); }
	
	listaPedido.add(new PedidoAImprimir("Prod", 100, 133));
	listaPedido.add(new PedidoAImprimir("Cant", 200, 133));
	listaPedido.add(new PedidoAImprimir("Precio", 250, 133));
	Integer total = 0;
	
	Integer vertical = 144;
	
	for (Venta venta : listaVenta) {
		
		nombreProducto = venta.getProductosVenta().getNombrecorto(); 
		if(nombreProducto.length() > 10) {
nombreProducto = nombreProducto.substring(0,10); 
		} else {
		/*	if(nombreProducto.length() == 1) {nombreProducto = nombreProducto.concat("                   ");}
			if(nombreProducto.length() == 2) {nombreProducto = nombreProducto.concat("                  ");}
			if(nombreProducto.length() == 3) {nombreProducto = nombreProducto.concat("             ");}
			if(nombreProducto.length() == 4) {nombreProducto = nombreProducto.concat("            ");}
			if(nombreProducto.length() == 5) {nombreProducto = nombreProducto.concat("           ");}
			if(nombreProducto.length() == 6) {nombreProducto = nombreProducto.concat("         ");}
			if(nombreProducto.length() == 7) {nombreProducto = nombreProducto.concat("       ");}
			if(nombreProducto.length() == 8) {nombreProducto = nombreProducto.concat("     ");}
		}
		
		listaPedido.add(new PedidoAImprimir(nombreProducto, 100, vertical));
		listaPedido.add(new PedidoAImprimir(venta.getCantidad().toString(), 200, vertical));
		listaPedido.add(new PedidoAImprimir(formatearNumero(venta.getCosto().toString()).toString(), 250, vertical));
		
	total += venta.getCantidad() * venta.getCosto();
	vertical += 11;
	}
	String totalString = String.valueOf(total);
	
	
	listaPedido.add(new PedidoAImprimir("Total: " + formatearNumero(totalString) + " Gs.", 150, vertical));
	
	ObjetoDeImpresion o = new ObjetoDeImpresion();
	o.setLista(listaPedido);
	
	PrinterJob job = PrinterJob.getPrinterJob();
	job.setPrintable(o);
	
	try{
	job.print();
	}catch(PrinterException e){
	System.out.println(e);
	}
	
	} else {
	mostrarMensaje(FacesMessage.SEVERITY_INFO,"Aviso!","Lista a mostrar esta vacia!");
	}
}
*/