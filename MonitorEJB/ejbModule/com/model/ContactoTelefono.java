package com.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the contacto_telefono database table.
 * 
 */
@Entity
@Table(name="contacto_telefono")
@NamedQuery(name="ContactoTelefono.findAll", query="SELECT c FROM ContactoTelefono c")
public class ContactoTelefono implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idTelefono;

	private String telefono;

	//bi-directional many-to-one association to Contacto
	@ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="IdContacto")
	private Contacto contacto;

	public ContactoTelefono() {
	}

	public Long getIdTelefono() {
		return this.idTelefono;
	}

	public void setIdTelefono(Long idTelefono) {
		this.idTelefono = idTelefono;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Contacto getContacto() {
		return this.contacto;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTelefono == null) ? 0 : idTelefono.hashCode());
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
		ContactoTelefono other = (ContactoTelefono) obj;
		if (idTelefono == null) {
			if (other.idTelefono != null)
				return false;
		} else if (!idTelefono.equals(other.idTelefono))
			return false;
		return true;
	}
	
	

}