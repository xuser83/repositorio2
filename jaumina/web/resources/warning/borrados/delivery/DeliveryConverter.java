
package jaumina.entidades.delivery;

/**@author Diego Benitez 
 * 
 *  xuser83@hotmail.com
 *  Luque, 22-07-2018
 *  
 *  */


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Delivery.class)
public class DeliveryConverter implements Converter {

	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String codigoString) {
		
		boolean esEntero = false;
		 
		 for(int i = 0; i< codigoString.length(); i++)
		 if( !Character.isDigit(codigoString.charAt(i)) ) {
		 esEntero = false;
		 	 } else 
		 	 {	 esEntero = true; }
			
		
		if(codigoString != null && codigoString.trim().length() > 0 && esEntero) {
			Integer codigo = Integer.valueOf(codigoString);
			DeliveryRN deliveryRN = new DeliveryRN();
			
			try {
				return deliveryRN.buscarDeliveryPorId(codigo);
			} catch (Exception e) {
				
				System.out.println("Error al intentar convertir Delivery a Object: " + e.getMessage());
			}
		}
		return null;
	}
	
	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object deliveryObjeto) {
		if(deliveryObjeto != null) {
			Delivery delivery = (Delivery) deliveryObjeto;
			if(delivery.getId() != null)
			return delivery.getId().toString();
			
			else return "";
		}
		return null;
	}

}
