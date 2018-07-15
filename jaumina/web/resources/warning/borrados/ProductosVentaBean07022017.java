package jaumina.entidades.productosventa;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import jaumina.commons.util.MensajesController;

/**
 * @author Diego Benitez
 * 
 * Ciudad de Luque, Paraguay
 * Miercoles, jueves 28 de julio de 2016.
 * */

@ManagedBean(name="productosVentaBean")
@RequestScoped
public class ProductosVentaBean {

	private ProductosVenta productosVentaSeleccionado = new ProductosVenta();
	private List<ProductosVenta> lista = null;
	MensajesController m = new MensajesController();
	
	public void guardar() throws Exception {
		try {
		
if(this.productosVentaSeleccionado.getId() !=null 
&& this.productosVentaSeleccionado.getId() != 0) {
	
	update();

		}
		else {
			
			save();
		}
		this.lista = null;
		} catch(Exception e) {
			m.mostrarMensajeError(e.getMessage());
		}
	}
	private FileWriter archivo = null;
	private PrintWriter printer = null;
	
	@SuppressWarnings("unused")
	private void escribirArchivo(ProductosVenta p) throws IOException {
		try {
			archivo = new FileWriter("C:\\ultra\\diego.txt", true);
			
			
			printer = new PrintWriter(archivo);
			
			printer.println(" ");
			printer.println(  new Date());
			
			printer.print("Se guardo un producto: "
					 +p.getNombre() + ", Nombre Corto: "
					 +p.getNombrecorto());
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if(archivo != null){
			archivo.close();}
		}
	}
	
	private void save() throws Exception {
		
ProductosVentaRN prn2 = new ProductosVentaRN();
productosVentaSeleccionado.setNombre(productosVentaSeleccionado.getNombre().toUpperCase());
productosVentaSeleccionado.setCodigo(productosVentaSeleccionado.getCodigo().toUpperCase());
productosVentaSeleccionado.setNombrecorto(productosVentaSeleccionado.getNombrecorto().toUpperCase());

ProductosVenta p1 = prn2.buscarPorNombreCorto(productosVentaSeleccionado.getNombrecorto());
if(p1.getNombrecorto() == null)
{
					try{
ProductosVentaRN prn3 = new ProductosVentaRN();
prn3.guardar(productosVentaSeleccionado);
this.productosVentaSeleccionado = new ProductosVenta();
m.mostrarMensajeSeGuardo();	
		
		}
		catch(Exception e) {
		m.mostrarMensajeErrorGuardar(e.getMessage());	
		}} else {m.mostrarMensaje(FacesMessage.SEVERITY_INFO,"Nombre Corto", "Ya existe un producto con el nombre corto!");}
				
	}
	
	private void update(){
		
		try {
			ProductosVentaRN prn = new ProductosVentaRN();
			productosVentaSeleccionado.setNombrecorto(productosVentaSeleccionado.getNombrecorto().toUpperCase());

			if(prn.buscarPorNombreCortoDistintoId(productosVentaSeleccionado.getNombrecorto(), 
					productosVentaSeleccionado.getId().toString()).getNombrecorto() == null) {
				System.out.println("No encontro ningun producto con ese nombre corto");
				prn.modificar(this.productosVentaSeleccionado);
				nuevo(); 
			m.mostrarMensajeSeModifico();
			}else {
			m.mostrarMensaje(FacesMessage.SEVERITY_INFO,"Nombre Corto", "Ya existe un producto con el nombre corto!");
				}		
				
				} catch(Exception e) {
			m.mostrarMensajeErrorModificar(e.getMessage());
				}
	}
	
	public ProductosVenta getProductosVentaSeleccionado() {
		return this.productosVentaSeleccionado;
	}
	
	public void setProductosVentaSeleccionado(ProductosVenta productosVentaSeleccionado) {
		this.productosVentaSeleccionado = productosVentaSeleccionado;
	}
	
	public List<ProductosVenta> getLista() throws Exception {
		Integer orden = 0;
		ProductosVentaRN productosVentaRN = new ProductosVentaRN();
		if(lista == null) {
			lista = productosVentaRN.listar();
			for (ProductosVenta productosVenta : lista) {
				productosVenta.setOrden(orden + 1);
				orden += 1;
			}
		}
		return lista;
	}
	
	public void eliminar() {
		try {
		ProductosVentaRN productosVentaRN = new ProductosVentaRN();
		productosVentaRN.eliminar(productosVentaSeleccionado);
		this.lista = null;

m.mostrarMensajeSeElimino();
		nuevo(); } catch (Exception e) {
m.mostrarMensajeErrorEliminar(e.getMessage());
		}
		
	}
	
	public void nuevo() {
		this.productosVentaSeleccionado = new ProductosVenta();
	}
	
}
