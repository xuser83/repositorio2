package jaumina.entidades.productosventa;

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
m.escribirArchivo("Clase: ProductosVentasBean, "
					+ "Línea: 44, Método: Guardar, Exception: " + e.getMessage());
		}
	}
	
	
	private void save() throws Exception {
if(productosVentaSeleccionado != null) {
ProductosVentaRN prn2 = new ProductosVentaRN();
productosVentaSeleccionado.setNombre(productosVentaSeleccionado.getNombre().toUpperCase());
productosVentaSeleccionado.setCodigo(productosVentaSeleccionado.getCodigo().toUpperCase());
productosVentaSeleccionado.setNombrecorto(productosVentaSeleccionado.getNombrecorto().toUpperCase());

if(!verificarNombreCortoRepetido(prn2))
{ 
if(!verificarNombreRepetido(prn2)) {
if(!verificarCodigoRepetido(prn2)) {
	try{
prn2.guardar(productosVentaSeleccionado);
productosVentaSeleccionado = new ProductosVenta();
m.mostrarMensajeSeGuardo();			}
catch(Exception e) {
m.mostrarMensajeErrorGuardar(e.getMessage());
m.escribirArchivo("Clase: ProductosVentasBean, "
		+ "Línea: 44, Método: Save, Exception: " + e.getMessage());
}
}  else {
	m.mostrarMensaje(FacesMessage.SEVERITY_INFO,"Nombre", 
			"Ya existe un producto con ese código!");	
}

} else {
	m.mostrarMensaje(FacesMessage.SEVERITY_INFO,"Nombre", 
			"Ya existe un producto con ese nombre!");	
}
} else {
m.mostrarMensaje(FacesMessage.SEVERITY_INFO,"Nombre Corto", 
		"Ya existe un producto con el nombre corto!");}}
else {
	m.mostrarMensajeError("No hay producto a guardar!");
	}				
	}
	
	private void update(){
	if(productosVentaSeleccionado!= null) {	
productosVentaSeleccionado.setNombre(productosVentaSeleccionado.getNombre().toUpperCase());
productosVentaSeleccionado.setCodigo(productosVentaSeleccionado.getCodigo().toUpperCase());
productosVentaSeleccionado.setNombrecorto(productosVentaSeleccionado.getNombrecorto().toUpperCase());
		
try {
ProductosVentaRN prn = new ProductosVentaRN();
productosVentaSeleccionado.setNombrecorto(productosVentaSeleccionado.getNombrecorto().toUpperCase());
if(!verificarNombreCortoDistintoId(prn)) {
if(!verificarNombreDistintoId(prn)) {
if(!verificarCodigoDistintoId(prn)) {
	prn.modificar(this.productosVentaSeleccionado);
	nuevo(); 
m.mostrarMensajeSeModifico();
} else {
	m.mostrarMensaje(FacesMessage.SEVERITY_INFO,"Codigo", 
			"Ya existe un producto con el codigo!");
}
} 
else {m.mostrarMensaje(FacesMessage.SEVERITY_INFO,"Nombre", 
		"Ya existe un producto con el nombre!");} 
				
			}else {
	m.mostrarMensaje(FacesMessage.SEVERITY_INFO,"Nombre Corto", 
	"Ya existe un producto con el nombre corto!");
				}		
				
				} catch(Exception e) {
			m.mostrarMensajeErrorModificar(e.getMessage());
m.escribirArchivo("Clase: ProductosVentasBean, "
+ "Línea: 44, Método: Guardar, Exception: " + e.getMessage());
				}}
	else {
	m.mostrarMensajeError("No hay producto a modificar!");
	}
	}
	
	private boolean verificarNombreCortoRepetido(ProductosVentaRN pvrn)  {
		boolean nombreRepetido = false;
		try {
			ProductosVenta p1 = pvrn.buscarProductoVentaPorNombreCorto(productosVentaSeleccionado.getNombrecorto());
			if(p1.getNombrecorto() != null) {nombreRepetido = true;}
		} catch (Exception e) {
		m.mostrarMensajeError("Error al intentar verificar Nombre Corto Repetido! " + e.getMessage());
m.escribirArchivo("Clase: ProductosVentasBean, "
+ " Método: verificarNombreCortoRepetido, Error al intentar verificar Nombre Corto Repetido,"
+ " Exception: " + e.getMessage());}		
		return nombreRepetido;
	}
	
	private boolean verificarNombreRepetido(ProductosVentaRN pvrn)  {
		boolean nombreRepetido = false;
		try {
			ProductosVenta p1 = pvrn.buscarProductoVentaPorNombre(productosVentaSeleccionado.getNombre());
			if(p1.getNombre() != null) {nombreRepetido = true;}
		} catch (Exception e) {
		m.mostrarMensajeError("Error al intentar verificar Nombre Repetido! " + e.getMessage());
m.escribirArchivo("Clase: ProductosVentasBean, "
+ " Método: verificarNombreRepetido, Error al intentar verificar NombreRepetido,"
+ " Exception: " + e.getMessage());}		
		return nombreRepetido;
	}
	
	private boolean verificarCodigoRepetido(ProductosVentaRN pvrn)  {
		boolean codigoRepetido = false;
		try {
			ProductosVenta p1 = pvrn.buscarProductoVentaPorCodigo(productosVentaSeleccionado.getCodigo());
			if(p1.getCodigo() != null) {codigoRepetido = true;}
		} catch (Exception e) {
		m.mostrarMensajeError("Error al intentar verificar Código Repetido! " + e.getMessage());
m.escribirArchivo("Clase: ProductosVentasBean, "
+ " Método: verificarCodigoRepetido, Error al intentar verificar código Repetido,"
+ " Exception: " + e.getMessage());	}		
		return codigoRepetido;
	}
	
	private boolean verificarNombreCortoDistintoId(ProductosVentaRN pvrn)  {
		boolean nombreCortoRepetido = false;
		try {
ProductosVenta p1 = pvrn.buscarProductoVentaPorNombreCortoDistintoId(
productosVentaSeleccionado.getNombrecorto(), productosVentaSeleccionado.getId().toString());
			if(p1.getNombrecorto() != null) {nombreCortoRepetido = true;}
		} catch (Exception e) {
		m.mostrarMensajeError("Error al intentar verificar Nombre Corto Repetido de distinto id! "
		+ e.getMessage());
		m.escribirArchivo("Clase: ProductosVentasBean, "
+ " Método: verificarNombreCortoDistintoId, "
+ "Error al intentar verificar Nombre Corto Repetido de distinto id!,"
				+ " Exception: " + e.getMessage());	
		}		
		return nombreCortoRepetido;
	}
	
	private boolean verificarNombreDistintoId(ProductosVentaRN pvrn)  {
		boolean nombre = false;
		try {
ProductosVenta p1 = pvrn.buscarProductoVentaPorNombreDistintoId(
productosVentaSeleccionado.getNombre(), productosVentaSeleccionado.getId().toString());
			if(p1.getNombre() != null) {nombre = true;}
		} catch (Exception e) {
		m.mostrarMensajeError("Error al intentar verificar Nombre Repetido de distinto id! "
		+ e.getMessage());
		}		
		return nombre;
	}
	
private boolean verificarCodigoDistintoId(ProductosVentaRN pvrn)  {
		boolean codigo = false;
		try {
ProductosVenta p1 = pvrn.buscarProductoVentaPorCodigoDistintoId(
productosVentaSeleccionado.getCodigo(), productosVentaSeleccionado.getId().toString());
			if(p1.getCodigo() != null) {codigo = true;}
		} catch (Exception e) {
		m.mostrarMensajeError("Error al intentar verificar Código Repetido de distinto id! "
		+ e.getMessage());
		}		
		return codigo;
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
	/*private FileWriter archivo = null;
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
		
		} finally {
			if(archivo != null){
			archivo.close();}
		}
	}*/
	
}
