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
import jaumina.entidades.detalleventa.DetalleVenta;
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
	listaPedido.add(new PedidoAImprimir1(fechaActualFormateada(), 100, vertical));
	vertical += 11;
	listaPedido.add(new PedidoAImprimir1("Ja'umiina - Gracias por su Compra!", 100, vertical));
	vertical += 11;
	listaPedido.add(new PedidoAImprimir1("Av. Cerro Corá c/ Campo Vía", 100, vertical));
	vertical += 11;
	listaPedido.add(new PedidoAImprimir1("Watsapp: 0975 927 056", 100, vertical));
	vertical += 11;
	Venta1 venta1 = listaDetalle.get(0).getVenta();
	listaPedido.add(new PedidoAImprimir1("Venta N°: " + venta1.getId().toString(), 100, vertical));
	
	vertical += 11;
	listaPedido.add(new PedidoAImprimir1("Prod", 100, vertical));
	listaPedido.add(new PedidoAImprimir1("Cant", 190, vertical));
	listaPedido.add(new PedidoAImprimir1("Prec", 240, vertical));
	listaPedido.add(new PedidoAImprimir1("Subt", 290, vertical));
	Integer total = 0;
	
	vertical += 11;
	
	for (DetalleVenta d : listaDetalle) {
		
		nombreProducto = d.getProductosVenta().getNombrecorto(); 
		if(nombreProducto.length() > 10) {
nombreProducto = nombreProducto.substring(0,10); 
		}
		
		listaPedido.add(new PedidoAImprimir1(nombreProducto, 100, vertical));
		listaPedido.add(new PedidoAImprimir1(formatearNumero(d.getCantidad().toString()), 190, vertical));
		listaPedido.add(new PedidoAImprimir1(formatearNumero(d.getCosto().toString()).toString(), 240, vertical));
		Integer subtotal = d.getCantidad() * d.getCosto();
		listaPedido.add(new PedidoAImprimir1(formatearNumero(subtotal.toString()).toString(), 290, vertical));
		
	total += d.getCantidad() * d.getCosto();
	vertical += 11;
	}
	
	String totalString = String.valueOf(total);
	listaPedido.add(new PedidoAImprimir1("Total: " + formatearNumero(totalString) + " Gs.", 150, vertical));
	
	if(venta1.getCliente() != null && venta1.getCliente().getNombres() 
			!= null && venta1.getCliente().getApellidos() != null) {
				vertical += 11;
				listaPedido.add(
						new PedidoAImprimir1("Cliente: " 
				+ venta1.getCliente().getNombres() + " " 
								+ venta1.getCliente().getApellidos(), 100, vertical)); }
	
	if(venta1.getDireccionAEntregar() != null) {
		vertical += 11;
		if(venta1.getDireccionAEntregar().length() > 35)
			venta1.setDireccionAEntregar("Dir: " + venta1.getDireccionAEntregar().substring(0, 35));
			 listaPedido.add(new PedidoAImprimir1(venta1.getDireccionAEntregar(), 100, vertical));}
	
	if(venta1.getCliente().getTelefono() != null) {
		vertical += 11;
		 listaPedido.add(new PedidoAImprimir1("Tel: " + venta1.getCliente().getTelefono(), 100, vertical)); }
	
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