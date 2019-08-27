package com.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the contacto_relacion database table.
 * 
 */
@Entity
@Table(name="contacto_relacion")
@NamedQuery(name="ContactoRelacion.findAll", query="SELECT c FROM ContactoRelacion c")
public class ContactoRelacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idRelacion;

	private String relacion;

	//bi-directional many-to-one association to Bcp
	@ManyToOne
	@JoinColumn(name="IdBcp")
	private Bcp bcp;

	//bi-directional many-to-one association to Contacto
	@ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="IdContacto")
	private Contacto contacto;

	//bi-directional many-to-one association to Estacion
	@ManyToOne
	@JoinColumn(name="IdEstacion")
	private Estacion estacion;

	//bi-directional many-to-one association to Proveedor
	@ManyToOne
	@JoinColumn(name="IdProveedor")
	private Proveedor proveedor;

	public ContactoRelacion() {
	}

	public Long getIdRelacion() {
		return this.idRelacion;
	}

	public void setIdRelacion(Long idRelacion) {
		this.idRelacion = idRelacion;
	}

	public String getRelacion() {
		return this.relacion;
	}

	public void setRelacion(String relacion) {
		this.relacion = relacion;
	}

	public Bcp getBcp() {
		return this.bcp;
	}

	public void setBcp(Bcp bcp) {
		this.bcp = bcp;
	}

	public Contacto getContacto() {
		return this.contacto;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}

	public Estacion getEstacion() {
		return this.estacion;
	}

	public void setEstacion(Estacion estacion) {
		this.estacion = estacion;
	}

	public Proveedor getProveedor() {
		return this.proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idRelacion == null) ? 0 : idRelacion.hashCode());
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
		ContactoRelacion other = (ContactoRelacion) obj;
		if (idRelacion == null) {
			if (other.idRelacion != null)
				return false;
		} else if (!idRelacion.equals(other.idRelacion))
			return false;
		return true;
	}
	

}