package jaumina.entidades.usuario;
import java.util.List;

import jaumina.commons.util.DAOFactory;
import jaumina.commons.util.EntityDAO;

public class UsuarioRN {
	/**
	* Luque - Paraguay 
	* 07-04-2018 cipiado de irp_morci
	* @author Diego Manuel Benitez Enciso
	*/
	
	private EntityDAO<Usuario> entityDAO;
	
	public UsuarioRN() {
		entityDAO = (EntityDAO<Usuario>) DAOFactory.creaUsuarioDAO();
		}
	
	public void guardar(Usuario usuario) {
		this.entityDAO.guardar(usuario);
		}
	
	 public List<Usuario> listar() throws Exception {
		return this.entityDAO.listarUsuarios();
		}
	
	public void modificar(Usuario usuario) {
		this.entityDAO.modificar(usuario);	
		}
	
	void eliminar(Usuario usuario) {
		this.entityDAO.eliminar(usuario);	
		}
	
	public Usuario iniciarSesion(Usuario us) {
		return this.entityDAO.iniciarSesion(us);}
	
	public List<Usuario> listarUsuariosPorUserName(String username) throws Exception {
		return entityDAO.listarUsuariosPorUserName(username);
	}
	
	public Usuario buscarUsuarioPorCodigo(Integer codigo) throws Exception {
		return entityDAO.buscarUsuarioPorCodigo(codigo);
	}
	
	}
