
package jaumina.entidades.usuario;

/**@author Diego Benitez 
 * Luque 08-04-2018
 *  xuser83@hotmail.com*/


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Usuario.class)
public class UsuarioConverter implements Converter {

	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String codigoString) {
		if(codigoString != null && codigoString.trim().length() > 0) {
			Integer codigo = Integer.valueOf(codigoString);
			UsuarioRN usuarioRN = new UsuarioRN();
			
			try {
				return usuarioRN.buscarUsuarioPorCodigo(codigo);
			} catch (Exception e) {
				
				System.out.println("Error al intentar convertir Usuario a Object: " + e.getMessage());
			}
		}
		return null;
	}
	
	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object usuarioObjeto) {
		if(usuarioObjeto != null) {
			Usuario usuario = (Usuario) usuarioObjeto;
			return usuario.getCodigo().toString();
		}
		return null;
	}

}
