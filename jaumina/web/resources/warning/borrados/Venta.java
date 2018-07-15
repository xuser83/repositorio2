package jaumina.entidades.ventas;

import jaumina.entidades.productosventa.ProductosVenta;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**@author Diego Benitez 
 * 
 *  xuser83@hotmail.com
 *  Luque, 23-02-2017
 *  */


@Entity
@Table(name="Venta")
public class Venta 
implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;
	
	private Integer nroPedido;
	
	@Column(length=30)
	private String telefonoCliente;
	
	@Column(length=3)
	private String destino;
	
	private String salsa;
	
	@Column(length=100)
	private String cliente;
	
	private String direccionAEntregar;
	
	@Column(length=3)
	private String entregado;
	
	@ManyToOne
	@JoinColumn(name="id_produto", nullable=false)	
	private ProductosVenta productosVenta;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_Venta", nullable=false)
	private Date fechaVenta;
	
	private Integer cantidad;
	private Integer costo;

	@Column(length=2)
	private String ventacancelada;
	
	@Transient
	private Integer orden;
	
	public Venta() {	
	}
	public Venta(String delivery) {	}
	
	public String getDireccionAEntregar() {
		return direccionAEntregar;
	}

	public void setDireccionAEntregar(String direccionAEntregar) {
		this.direccionAEntregar = direccionAEntregar;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ProductosVenta getProductosVenta() {
		return productosVenta;
	}

	public void setProductosVenta(ProductosVenta productosVenta) {
		this.productosVenta = productosVenta;
	}

	public Date getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
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

	public String getEntregado() {
		return entregado;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public void setEntregado(String entregado) {
		this.entregado = entregado;
	}

	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	public String getTelefonoCliente() {
		return telefonoCliente;
	}

	public void setTelefonoCliente(String telefonoCliente) {
		this.telefonoCliente = telefonoCliente;
	}

	public Integer getNroPedido() {
		return nroPedido;
	}

	public void setNroPedido(Integer nroPedido) {
		this.nroPedido = nroPedido;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getVentacancelada() {
		return ventacancelada;
	}

	public void setVentacancelada(String ventacancelada) {
		this.ventacancelada = ventacancelada;
	}
	@Override
	public String toString() {
		return "Venta [id=" + id + ", nroPedido=" + nroPedido + ", telefonoCliente=" + telefonoCliente + ", destino="
				+ destino + ", salsa=" + salsa + ", cliente=" + cliente + ", direccionAEntregar=" + direccionAEntregar
				+ ", entregado=" + entregado + ", productosVenta=" + productosVenta + ", fechaVenta=" + fechaVenta
				+ ", cantidad=" + cantidad + ", costo=" + costo + ", ventacancelada=" + ventacancelada + ", orden="
				+ orden + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cantidad == null) ? 0 : cantidad.hashCode());
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((costo == null) ? 0 : costo.hashCode());
		result = prime * result + ((destino == null) ? 0 : destino.hashCode());
		result = prime * result + ((direccionAEntregar == null) ? 0 : direccionAEntregar.hashCode());
		result = prime * result + ((entregado == null) ? 0 : entregado.hashCode());
		result = prime * result + ((fechaVenta == null) ? 0 : fechaVenta.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nroPedido == null) ? 0 : nroPedido.hashCode());
		result = prime * result + ((orden == null) ? 0 : orden.hashCode());
		result = prime * result + ((productosVenta == null) ? 0 : productosVenta.hashCode());
		result = prime * result + ((salsa == null) ? 0 : salsa.hashCode());
		result = prime * result + ((telefonoCliente == null) ? 0 : telefonoCliente.hashCode());
		result = prime * result + ((ventacancelada == null) ? 0 : ventacancelada.hashCode());
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
		Venta other = (Venta) obj;
		if (cantidad == null) {
			if (other.cantidad != null)
				return false;
		} else if (!cantidad.equals(other.cantidad))
			return false;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (costo == null) {
			if (other.costo != null)
				return false;
		} else if (!costo.equals(other.costo))
			return false;
		if (destino == null) {
			if (other.destino != null)
				return false;
		} else if (!destino.equals(other.destino))
			return false;
		if (direccionAEntregar == null) {
			if (other.direccionAEntregar != null)
				return false;
		} else if (!direccionAEntregar.equals(other.direccionAEntregar))
			return false;
		if (entregado == null) {
			if (other.entregado != null)
				return false;
		} else if (!entregado.equals(other.entregado))
			return false;
		if (fechaVenta == null) {
			if (other.fechaVenta != null)
				return false;
		} else if (!fechaVenta.equals(other.fechaVenta))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nroPedido == null) {
			if (other.nroPedido != null)
				return false;
		} else if (!nroPedido.equals(other.nroPedido))
			return false;
		if (orden == null) {
			if (other.orden != null)
				return false;
		} else if (!orden.equals(other.orden))
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
		if (telefonoCliente == null) {
			if (other.telefonoCliente != null)
				return false;
		} else if (!telefonoCliente.equals(other.telefonoCliente))
			return false;
		if (ventacancelada == null) {
			if (other.ventacancelada != null)
				return false;
		} else if (!ventacancelada.equals(other.ventacancelada))
			return false;
		return true;
	}
	public Venta(Integer id, Integer nroPedido, String telefonoCliente, String destino, String salsa, String cliente,
			String direccionAEntregar, String entregado, ProductosVenta productosVenta, Date fechaVenta,
			Integer cantidad, Integer costo, String ventacancelada, Integer orden) {
		this.id = id;
		this.nroPedido = nroPedido;
		this.telefonoCliente = telefonoCliente;
		this.destino = destino;
		this.salsa = salsa;
		this.cliente = cliente;
		this.direccionAEntregar = direccionAEntregar;
		this.entregado = entregado;
		this.productosVenta = productosVenta;
		this.fechaVenta = fechaVenta;
		this.cantidad = cantidad;
		this.costo = costo;
		this.ventacancelada = ventacancelada;
		this.orden = orden;
	}
	
	
}

