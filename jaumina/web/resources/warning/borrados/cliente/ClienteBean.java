package jaumina.entidades.cliente;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import jaumina.commons.util.MensajesController;
import jaumina.commons.util.MensajesUtil;

/**
 * @author Diego Benitez
 * 
 * Ciudad de Luque, Paraguay
 * viernes 03-03-2017
 * */

@ManagedBean(name="clienteBean")
@ViewScoped
public class ClienteBean {

	private Cliente clienteSeleccionado = new Cliente();
	private List<Cliente> lista = null;
	private MensajesUtil m = new MensajesController();
	private String nombreABuscar;
	
	public void prepararEdit(Cliente cliente) {
		setClienteSeleccionado(cliente);
	}
	
	public void buscarClientePorNombre() throws Exception {
		
		ClienteRN crn = new ClienteRN();
		try {
			if(nombreABuscar != null) {
			lista = crn.listarClientesPorNombres(nombreABuscar);
			if(lista.isEmpty()) {
				lista = crn.listarClientesPorNroDocumento(nombreABuscar);
			}
			
			} else {
lista = crn.listarClientes();
			}
		} catch (Exception e) {
	m.mostrarMensajeError(e.getMessage());;
		}
	}
	
	public void guardar() {
		ClienteRN entityRN = new ClienteRN();
if(this.clienteSeleccionado.getId() !=null 
&& this.clienteSeleccionado.getId() != 0) {
	try{
	entityRN.modificar(this.clienteSeleccionado);
	m.mostrarMensajeSeModifico();
			nuevo();} catch(Exception e) {
m.mostrarMensajeErrorModificar(e.getMessage());
			}
		}
		else {
	try{
	entityRN.guardar(clienteSeleccionado);
	m.mostrarMensajeSeGuardo();
	this.clienteSeleccionado = new Cliente();}
		 catch(Exception e) {
 m.mostrarMensajeErrorGuardar(e.getMessage());
		}}
		
		this.lista = null;
	}
	
	public Cliente getClienteSeleccionado() {
		return this.clienteSeleccionado;
	}
	
	public void setClienteSeleccionado(Cliente clienteSeleccionado) {
		this.clienteSeleccionado = clienteSeleccionado;
	}
	
	public List<Cliente> getLista() throws Exception {
		
		return lista;
	}
	
	public void eliminar() {
		try {
		ClienteRN entityRN = new ClienteRN();
		entityRN.eliminar(clienteSeleccionado);
		this.lista = null;
		m.mostrarMensajeSeElimino();
		nuevo(); } catch (Exception e) {
m.mostrarMensajeErrorEliminar(e.getMessage());
		}
		
	}
	
	public void nuevo() {
		this.clienteSeleccionado = new Cliente();
	}

	public String getNombreABuscar() {
		return nombreABuscar;
	}

	public void setNombreABuscar(String nombreABuscar) {
		this.nombreABuscar = nombreABuscar;
	}
	
}
