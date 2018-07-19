package jaumina.entidades.ventas1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import jaumina.entidades.cliente.Cliente;
import jaumina.entidades.delivery.Delivery;
import jaumina.entidades.detalleventa.DetalleVenta;

/**@author Diego Benitez 
 * 
 *  xuser83@hotmail.com
 *  Luque, 30-06/2018
 *  */


@Entity
@Table(name="Venta1")
public class Venta1 
implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(length=3)
	private String destino;
	
	@Column(length=18)
	private String telefono;
	
	@ManyToOne
	@JoinColumn(name="id_cliente")	
	private Cliente cliente;
	
	@OneToMany(mappedBy = "venta")
	private List<DetalleVenta> listaDetalle = new ArrayList<DetalleVenta>();
	
	private String direccionAEntregar;
	
	@Column(length=3)
	private String entregado;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_Venta", nullable=false)
	private Date fechaVenta;

	@ManyToOne
	@JoinColumn(name="id_delivery")	
	private Delivery delivery;

	
	@Transient
	private Integer orden;
	
	public Venta1() {	
	}
	public Venta1(String delivery) {	}
	
	public String getDireccionAEntregar() {
		return direccionAEntregar;
	}

	public void setDireccionAEntregar(String direccionAEntregar) {
		this.direccionAEntregar = direccionAEntregar;
	}

	public Date getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public String getEntregado() {
		return entregado;
	}

	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
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

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Venta1 [id=" + id + ", cliente=" + cliente + ", fechaVenta=" + fechaVenta + "]";
	}
	public List<DetalleVenta> getListaDetalle() {
		return listaDetalle;
	}
	public void setListaDetalle(List<DetalleVenta> listaDetalle) {
		this.listaDetalle = listaDetalle;
	}
	public Delivery getDelivery() {
		return delivery;
	}
	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((delivery == null) ? 0 : delivery.hashCode());
		result = prime * result + ((destino == null) ? 0 : destino.hashCode());
		result = prime * result + ((direccionAEntregar == null) ? 0 : direccionAEntregar.hashCode());
		result = prime * result + ((entregado == null) ? 0 : entregado.hashCode());
		result = prime * result + ((fechaVenta == null) ? 0 : fechaVenta.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((listaDetalle == null) ? 0 : listaDetalle.hashCode());
		result = prime * result + ((orden == null) ? 0 : orden.hashCode());
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
		Venta1 other = (Venta1) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (delivery == null) {
			if (other.delivery != null)
				return false;
		} else if (!delivery.equals(other.delivery))
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
		if (listaDetalle == null) {
			if (other.listaDetalle != null)
				return false;
		} else if (!listaDetalle.equals(other.listaDetalle))
			return false;
		if (orden == null) {
			if (other.orden != null)
				return false;
		} else if (!orden.equals(other.orden))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		return true;
	}
	
	
}

