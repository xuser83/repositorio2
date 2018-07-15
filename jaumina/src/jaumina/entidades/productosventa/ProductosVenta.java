package jaumina.entidades.productosventa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
public class ProductosVenta implements Serializable {

	private static final long serialVersionUID = 1657224151184648406L;

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name="codigo", length=20, unique=true)
	private String codigo;
	
	@Transient
	private Integer cantPedido;

	@Column(name="nombre", length=30, unique=true)
	private String nombre;
	
	@Column(name="nombrecorto", length=15, unique=true)
	private String nombrecorto;
	
	private Integer preciocosto;
	
	private Integer precioventa;
	
	@Transient
	private Integer orden;
	
	public ProductosVenta() {}

	public ProductosVenta(Integer id, String codigo, String nombre,
			String nombrecorto, Integer preciocosto, Integer precioventa) {
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
		this.nombrecorto = nombrecorto;
		this.preciocosto = preciocosto;
		this.precioventa = precioventa;
	}

	public Integer getCantPedido() {
		return cantPedido;
	}

	public void setCantPedido(Integer cantPedido) {
		this.cantPedido = cantPedido;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombrecorto() {
		return nombrecorto;
	}

	public void setNombrecorto(String nombrecorto) {
		this.nombrecorto = nombrecorto;
	}

	public Integer getPreciocosto() {
		return preciocosto;
	}

	public void setPreciocosto(Integer preciocosto) {
		this.preciocosto = preciocosto;
	}

	public Integer getPrecioventa() {
		return precioventa;
	}

	public void setPrecioventa(Integer precioventa) {
		this.precioventa = precioventa;
	}

	@Override
	public String toString() {
		return "ProductosVenta [id=" + id + ", codigo=" + codigo + ", nombre="
				+ nombre + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result
				+ ((nombrecorto == null) ? 0 : nombrecorto.hashCode());
		result = prime * result
				+ ((preciocosto == null) ? 0 : preciocosto.hashCode());
		result = prime * result
				+ ((precioventa == null) ? 0 : precioventa.hashCode());
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
		ProductosVenta other = (ProductosVenta) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (nombrecorto == null) {
			if (other.nombrecorto != null)
				return false;
		} else if (!nombrecorto.equals(other.nombrecorto))
			return false;
		if (preciocosto == null) {
			if (other.preciocosto != null)
				return false;
		} else if (!preciocosto.equals(other.preciocosto))
			return false;
		if (precioventa == null) {
			if (other.precioventa != null)
				return false;
		} else if (!precioventa.equals(other.precioventa))
			return false;
		return true;
	}

	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}
	
	
}
