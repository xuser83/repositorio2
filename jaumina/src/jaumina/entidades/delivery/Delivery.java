package jaumina.entidades.delivery;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**@author Diego Manuel Benitez Enciso 
 * 
 * Iniciando: domingo 08-07-2018*/
@Entity
@Table(name="Delivery")
public class Delivery implements Serializable {

	private static final long serialVersionUID = 775535741716319765L;

	@Id
	@GeneratedValue
	private Integer id;

	@Column(length=15)
	private String nro_documento;

	@Column(length=60)
	private String nombres;

	@Column(length=50)
	private String apellidos;

	private String direccion;

	@Column(length=50)
	private String telefono;
	
	@Column(length=1)
	private String activo;
	
	private Date fecha_nacimiento;

	public Integer getId() {
		return id;
	}

	public String getNro_documento() {
		return nro_documento;
	}

	public String getNombres() {
		return nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getActivo() {
		return activo;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNro_documento(String nro_documento) {
		this.nro_documento = nro_documento;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

public Delivery() {}

@Override
public String toString() {
	return "Delivery [id=" + id + ", nro_documento=" + nro_documento + ", nombres=" + nombres + ", apellidos="
			+ apellidos + ", activo=" + activo + "]";
}

public Date getFecha_nacimiento() {
	return fecha_nacimiento;
}

public void setFecha_nacimiento(Date fecha_nacimiento) {
	this.fecha_nacimiento = fecha_nacimiento;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((activo == null) ? 0 : activo.hashCode());
	result = prime * result + ((apellidos == null) ? 0 : apellidos.hashCode());
	result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
	result = prime * result + ((fecha_nacimiento == null) ? 0 : fecha_nacimiento.hashCode());
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
	Delivery other = (Delivery) obj;
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
	if (direccion == null) {
		if (other.direccion != null)
			return false;
	} else if (!direccion.equals(other.direccion))
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
