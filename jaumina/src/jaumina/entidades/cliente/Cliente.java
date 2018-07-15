package jaumina.entidades.cliente;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
/**@author Diego Manuel Benitez Enciso 55
 * 
 * Iniciando: viernes 03-03-2017*/
@Entity
@Table(name="Cliente")
public class Cliente implements Serializable {

private static final long serialVersionUID = -3296235113400002859L;

@Id
@GeneratedValue
private Long id;

@Column(length=15)
private String nro_documento;

@Column(length=60)
private String nombres;

@Column(length=50)
private String apellidos;

private String direccion;

@Column(length=50)
private String telefono;

public Cliente() {}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getTelefono() {
	return telefono;
}

public void setTelefono(String telefono) {
	this.telefono = telefono;
}

public String getDireccion() {
	return direccion;
}

public void setDireccion(String direccion) {
	this.direccion = direccion;
}


public String getNombres() {
	return nombres;
}

public void setNombres(String nombres) {
	this.nombres = nombres;
}

public String getApellidos() {
	return apellidos;
}

public void setApellidos(String apellidos) {
	this.apellidos = apellidos;
}

public String getNro_documento() {
	return nro_documento;
}

public void setNro_documento(String nro_documento) {
	this.nro_documento = nro_documento;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((apellidos == null) ? 0 : apellidos.hashCode());
	result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((nombres == null) ? 0 : nombres.hashCode());
	result = prime * result + ((nro_documento == null) ? 0 : nro_documento.hashCode());
	result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Cliente other = (Cliente) obj;
	if (apellidos == null) {
		if (other.apellidos != null)
			return false;
	} else if (!apellidos.equals(other.apellidos))
		return false;
	if (direccion == null) {
		if (other.direccion != null)
			return false;
	} else if (!direccion.equals(other.direccion))
		return false;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	if (nombres == null) {
		if (other.nombres != null)
			return false;
	} else if (!nombres.equals(other.nombres))
		return false;
	if (nro_documento == null) {
		if (other.nro_documento != null)
			return false;
	} else if (!nro_documento.equals(other.nro_documento))
		return false;
	if (telefono == null) {
		if (other.telefono != null)
			return false;
	} else if (!telefono.equals(other.telefono))
		return false;
	return true;
}


}
