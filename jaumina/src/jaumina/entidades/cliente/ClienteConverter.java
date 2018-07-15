
package jaumina.entidades.cliente;

/**@author Diego Benitez 
 * 
 *  xuser83@hotmail.com*/


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Cliente.class)
public class ClienteConverter implements Converter {

	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String codigoString) {
		
		boolean esEntero = false;
		 
		 for(int i = 0; i< codigoString.length(); i++)
		 if( !Character.isDigit(codigoString.charAt(i)) ) {
		 esEntero = false;
		 	 } else 
		 	 {	 esEntero = true; }
			
		
		if(codigoString != null && codigoString.trim().length() > 0 && esEntero) {
			Long codigo = Long.valueOf(codigoString);
			ClienteRN clienteRN = new ClienteRN();
			
			try {
				return clienteRN.buscarClientePorId(codigo);
			} catch (Exception e) {
				
				System.out.println("Error al intentar convertir Cliente a Object: " + e.getMessage());
			}
		}
		return null;
	}
	
	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object clienteObjeto) {
		if(clienteObjeto != null) {
			Cliente cliente = (Cliente) clienteObjeto;
			if(cliente.getId() != null)
			return cliente.getId().toString();
			
			else return "";
		}
		return null;
	}

}
