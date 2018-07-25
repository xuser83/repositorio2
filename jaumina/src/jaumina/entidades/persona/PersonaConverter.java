
package jaumina.entidades.persona;

/**@author Diego Benitez 
 * 
 *  xuser83@hotmail.com
 *  23-07-2018*/


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Persona.class)
public class PersonaConverter implements Converter {

	
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
			PersonaRN personaRN = new PersonaRN();
			
			try {
				return personaRN.buscarPersonaPorId(codigo);
			} catch (Exception e) {
				
				System.out.println("Error al intentar convertir Persona a Object: " + e.getMessage());
			}
		}
		return null;
	}
	
	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object personaObjeto) {
		if(personaObjeto != null) {
			Persona persona = (Persona) personaObjeto;
			if(persona.getId() != null)
			return persona.getId().toString();
			
			else return "";
		}
		return null;
	}

}
