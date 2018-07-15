
package jaumina.entidades.productosventa;

/**@author Diego Benitez 
 * 
 *  xuser83@hotmail.com
 *  
 *  Asunción, lunes 25 de julio de 2017
 *  */


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = ProductosVenta.class)
public class ProductosVentaConverter implements Converter {

	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String codigoString) {
		if(codigoString != null && codigoString.trim().length() > 0) {
			@SuppressWarnings("unused")
			Integer codigo = Integer.valueOf(codigoString);
			@SuppressWarnings("unused")
			ProductosVentaRN compradorRN = new ProductosVentaRN();
			
			return null;
		}
		return null;
	}
	
	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object compradorObjeto) {
		if(compradorObjeto != null) {
			ProductosVenta comprador= (ProductosVenta) compradorObjeto;
			return comprador.getId().toString();
		}
		return null;
	}

}
