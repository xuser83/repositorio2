package jaumina.entidades.detalleventa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import jaumina.entidades.productosventa.ProductosVenta;
import jaumina.entidades.ventas1.Venta1;

/**@author Diego Benitez 
 * 
 *  xuser83@hotmail.com
 *  Luque, 30-06/2018
 *  */

@Entity
@Table(name="detalleventa")
public class DetalleVenta implements Serializable {

	private static final long serialVersionUID = 7022499547190174511L;

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	@JoinColumn(name="id_produto", nullable=false)	
	private ProductosVenta productosVenta;

	@ManyToOne
	@JoinColumn(name="id_venta1", nullable=false)
	private Venta1 venta;
	
	private Integer cantidad;
	
	private Integer costo;
	
	private String salsa;

	@Column(length = 2)
	private String eliminado;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProductosVenta getProductosVenta() {
		return productosVenta;
	}

	public void setProductosVenta(ProductosVenta productosVenta) {
		this.productosVenta = productosVenta;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Integer getCosto() {
		return costo;
	}

	public void setCosto(Integer costo) {
		this.costo = costo;
	}

	public String getSalsa() {
		return salsa;
	}

	public void setSalsa(String salsa) {
		this.salsa = salsa;
	}

	public Venta1 getVenta() {
		return venta;
	}

	public void setVenta(Venta1 venta) {
		this.venta = venta;
	}

	public String getEliminado() {
		return eliminado;
	}

	public void setEliminado(String eliminado) {
		this.eliminado = eliminado;
	}

	@Override
	public String toString() {
		return "DetalleVenta [id=" + id + ", productosVenta=" + productosVenta + ", venta=" + venta + ", cantidad="
				+ cantidad + ", eliminado=" + eliminado + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cantidad == null) ? 0 : cantidad.hashCode());
		result = prime * result + ((costo == null) ? 0 : costo.hashCode());
		result = prime * result + ((eliminado == null) ? 0 : eliminado.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((productosVenta == null) ? 0 : productosVenta.hashCode());
		result = prime * result + ((salsa == null) ? 0 : salsa.hashCode());
		result = prime * result + ((venta == null) ? 0 : venta.hashCode());
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
		DetalleVenta other = (DetalleVenta) obj;
		if (cantidad == null) {
			if (other.cantidad != null)
				return false;
		} else if (!cantidad.equals(other.cantidad))
			return false;
		if (costo == null) {
			if (other.costo != null)
				return false;
		} else if (!costo.equals(other.costo))
			return false;
		if (eliminado == null) {
			if (other.eliminado != null)
				return false;
		} else if (!eliminado.equals(other.eliminado))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (productosVenta == null) {
			if (other.productosVenta != null)
				return false;
		} else if (!productosVenta.equals(other.productosVenta))
			return false;
		if (salsa == null) {
			if (other.salsa != null)
				return false;
		} else if (!salsa.equals(other.salsa))
			return false;
		if (venta == null) {
			if (other.venta != null)
				return false;
		} else if (!venta.equals(other.venta))
			return false;
		return true;
	}
	
}
