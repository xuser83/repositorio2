package jaumina.entidades.persona;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
/**@author Diego Manuel Benitez Enciso 55
 * 
 * Iniciando: Lunes 23-07-2017*/
@Entity
@Table(name="Persona")
public class Persona implements Serializable {

	private static final long serialVersionUID = -2294648310669075113L;

@Id
@GeneratedValue
private Long id;

@Column(length=15) 
private String nro_documento;

@Column(length=60)
private String nombres;

@Column(length=50)
private String apellidos;

@Column(length=15, unique=true)
private String nombre_corto;

private String direccion;

@Column(length=50)
private String telefono;

private Date fecha_nacimiento;

private Date fecha_creacion;

@Column(length=1)
private String activo;

@Column(length=30) 
private String rol;

@Column(length=25)
private String clave;

public String getClave() {
	return clave;
}

public void setClave(String clave) {
	this.clave = clave;
}

public Persona() {}

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
public String toString() {
	return "Persona [id=" + id + ", nro_documento=" + nro_documento + ", nombres=" + nombres + ", apellidos="
			+ apellidos + ", direccion=" + direccion + ", telefono=" + telefono + ", fecha_nacimiento="
			+ fecha_nacimiento + ", fecha_creacion=" + fecha_creacion + ", activo=" + activo + ", rol=" + rol + "]";
}

public Date getFecha_nacimiento() {
	return fecha_nacimiento;
}

public Date getFecha_creacion() {
	return fecha_creacion;
}

public String getActivo() {
	return activo;
}

public String getRol() {
	return rol;
}

public void setFecha_nacimiento(Date fecha_nacimiento) {
	this.fecha_nacimiento = fecha_nacimiento;
}

public void setFecha_creacion(Date fecha_creacion) {
	this.fecha_creacion = fecha_creacion;
}

public void setActivo(String activo) {
	this.activo = activo;
}

public void setRol(String rol) {
	this.rol = rol;
}

public String getNombre_corto() {
	return nombre_corto;
}

public void setNombre_corto(String nombre_corto) {
	this.nombre_corto = nombre_corto;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((activo == null) ? 0 : activo.hashCode());
	result = prime * result + ((apellidos == null) ? 0 : apellidos.hashCode());
	result = prime * result + ((clave == null) ? 0 : clave.hashCode());
	result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
	result = prime * result + ((fecha_creacion == null) ? 0 : fecha_creacion.hashCode());
	result = prime * result + ((fecha_nacimiento == null) ? 0 : fecha_nacimiento.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((nombre_corto == null) ? 0 : nombre_corto.hashCode());
	result = prime * result + ((nombres == null) ? 0 : nombres.hashCode());
	result = prime * result + ((nro_documento == null) ? 0 : nro_documento.hashCode());
	result = prime * result + ((rol == null) ? 0 : rol.hashCode());
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
	Persona other = (Persona) obj;
	if (activo == null) {
		if (other.activo != null)
			return false;
	} else if (!activo.equals(other.activo))
		return false;
	if (apellidos == null) {
		if (other.apellidos != null)
			return false;
	} else if (!apellidos.equals(other.apellidos))
		return false;
	if (clave == null) {
		if (other.clave != null)
			return false;
	} else if (!clave.equals(other.clave))
		return false;
	if (direccion == null) {
		if (other.direccion != null)
			return false;
	} else if (!direccion.equals(other.direccion))
		return false;
	if (fecha_creacion == null) {
		if (other.fecha_creacion != null)
			return false;
	} else if (!fecha_creacion.equals(other.fecha_creacion))
		return false;
	if (fecha_nacimiento == null) {
		if (other.fecha_nacimiento != null)
			return false;
	} else if (!fecha_nacimiento.equals(other.fecha_nacimiento))
		return false;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	if (nombre_corto == null) {
		if (other.nombre_corto != null)
			return false;
	} else if (!nombre_corto.equals(other.nombre_corto))
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
	if (rol == null) {
		if (other.rol != null)
			return false;
	} else if (!rol.equals(other.rol))
		return false;
	if (telefono == null) {
		if (other.telefono != null)
			return false;
	} else if (!telefono.equals(other.telefono))
		return false;
	return true;
}


}
