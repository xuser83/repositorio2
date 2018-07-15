package jaumina.commons.util;

import java.util.List;
import javax.faces.application.FacesMessage.Severity;
import jaumina.entidades.detalleventa.DetalleVenta;
//import jaumina.entidades.ventas.Venta;

public interface MensajesUtil {

	void mostrarMensaje(Severity severity, String resumen, String detalle);

	void mostrarMensajeSeModifico();

	void mostrarMensajeSeGuardo();

	void mostrarMensajeSeElimino();

	void mostrarMensajeError(String exceptionMessage);

	void mostrarMensajeErrorGuardar(String exceptionMessage);

	void mostrarMensajeErrorModificar(String exceptionMessage);

	void mostrarMensajeErrorEliminar(String exceptionMessage);
	
	void escribirArchivo(String string);
	
	//void imprimirVenta(List<Venta1> listaVenta);
	
	void imprimirDetalleVenta(List<DetalleVenta> listaDetalle);
}
