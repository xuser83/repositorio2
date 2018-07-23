package jaumina.entidades.delivery;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import jaumina.commons.util.MensajesController;
import jaumina.commons.util.MensajesUtil;

/**
 * @author Diego Benitez
 * 
 * Ciudad de Luque, Paraguay
 * domingo 22-07-2018
 * */

@ManagedBean(name="deliveryBean")
@ViewScoped
public class DeliveryBean {

	private Delivery deliverySeleccionado = new Delivery();
	private List<Delivery> lista = null;
	private MensajesUtil m = new MensajesController();
	private String nombreABuscar;
	
	public void prepararEdit(Delivery delivery) {
		setDeliverySeleccionado(delivery);
	}
	
	public void buscarDeliveryPorNombre() throws Exception {
		
		DeliveryRN crn = new DeliveryRN();
		try {
			if(nombreABuscar != null) {
			lista = crn.listarDeliverysPorNombres(nombreABuscar);
			if(lista.isEmpty()) {
				lista = crn.listarDeliverysPorNroDocumento(nombreABuscar);
			}
			
			} else {
lista = crn.listarDeliverys();
			}
		} catch (Exception e) {
	m.mostrarMensajeError(e.getMessage());;
		}
	}
	
	public void guardar() {
		DeliveryRN entityRN = new DeliveryRN();
if(this.deliverySeleccionado.getId() !=null 
&& this.deliverySeleccionado.getId() != 0) {
	try{
	entityRN.modificar(this.deliverySeleccionado);
	m.mostrarMensajeSeModifico();
			nuevo();} catch(Exception e) {
m.mostrarMensajeErrorModificar(e.getMessage());
			}
		}
		else {
	try{
	entityRN.guardar(deliverySeleccionado);
	m.mostrarMensajeSeGuardo();
	this.deliverySeleccionado = new Delivery();}
		 catch(Exception e) {
 m.mostrarMensajeErrorGuardar(e.getMessage());
		}}
		
		this.lista = null;
	}
	
	public Delivery getDeliverySeleccionado() {
		return deliverySeleccionado;
	}

	public void setDeliverySeleccionado(Delivery deliverySeleccionado) {
		this.deliverySeleccionado = deliverySeleccionado;
	}

	public List<Delivery> getLista() throws Exception {
		
		return lista;
	}
	
	public void eliminar() {
		try {
		DeliveryRN entityRN = new DeliveryRN();
		entityRN.eliminar(deliverySeleccionado);
		this.lista = null;
		m.mostrarMensajeSeElimino();
		nuevo(); } catch (Exception e) {
m.mostrarMensajeErrorEliminar(e.getMessage());
		}
		
	}
	
	public void nuevo() {
		this.deliverySeleccionado = new Delivery();
	}

	public String getNombreABuscar() {
		return nombreABuscar;
	}

	public void setNombreABuscar(String nombreABuscar) {
		this.nombreABuscar = nombreABuscar;
	}
	
}
