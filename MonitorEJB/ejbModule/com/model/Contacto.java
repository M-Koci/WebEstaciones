package com.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the contacto database table.
 * 
 */
@Entity
@NamedQuery(name="Contacto.findAll", query="SELECT c FROM Contacto c")
public class Contacto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idContacto;

	private String apellido;

	private String nombre;
	
	//bi-directional many-to-one association to ContactoRelacion
	@OneToMany(mappedBy="contacto")
	private List<ContactoRelacion> contactoRelacions;

	//bi-directional many-to-one association to ContactoEmail
	@OneToMany(mappedBy="contacto")
	private List<ContactoEmail> contactoEmails;

	//bi-directional many-to-one association to ContactoTelefono
	@OneToMany(mappedBy = "contacto")
	private List<ContactoTelefono> contactoTelefonos;

	public Contacto() {
	}
	
	public ContactoTelefono addTelefono(ContactoTelefono contactoTelefono) {
		getContactoTelefonos().add(contactoTelefono);
		contactoTelefono.setContacto(this);
		return contactoTelefono;
	}
	
	public ContactoEmail addEmail(ContactoEmail contactoEmail) {
		getContactoEmails().add(contactoEmail);
		contactoEmail.setContacto(this);
		return contactoEmail;
	}

	public Long getIdContacto() {
		return this.idContacto;
	}

	public void setIdContacto(Long idContacto) {
		this.idContacto = idContacto;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public List<ContactoRelacion> getContactoRelacions() {
		return this.contactoRelacions;
	}

	public void setContactoRelacions(List<ContactoRelacion> contactoRelacions) {
		this.contactoRelacions = contactoRelacions;
	}

	public List<ContactoEmail> getContactoEmails() {
		return this.contactoEmails;
	}

	public void setContactoEmails(List<ContactoEmail> contactoEmails) {
		this.contactoEmails = contactoEmails;
	}

	public ContactoEmail addContactoEmail(ContactoEmail contactoEmail) {
		getContactoEmails().add(contactoEmail);
		contactoEmail.setContacto(this);

		return contactoEmail;
	}

	public ContactoEmail removeContactoEmail(ContactoEmail contactoEmail) {
		getContactoEmails().remove(contactoEmail);
		contactoEmail.setContacto(null);

		return contactoEmail;
	}

	public List<ContactoTelefono> getContactoTelefonos() {
		return this.contactoTelefonos;
	}

	public void setContactoTelefonos(List<ContactoTelefono> contactoTelefonos) {
		this.contactoTelefonos = contactoTelefonos;
	}

	public ContactoTelefono addContactoTelefono(ContactoTelefono contactoTelefono) {
		getContactoTelefonos().add(contactoTelefono);
		contactoTelefono.setContacto(this);

		return contactoTelefono;
	}

	public ContactoTelefono removeContactoTelefono(ContactoTelefono contactoTelefono) {
		getContactoTelefonos().remove(contactoTelefono);
		contactoTelefono.setContacto(null);

		return contactoTelefono;
	}
	
	public ContactoRelacion addContactoRelacion(ContactoRelacion contactoRelacion) {
		getContactoRelacions().add(contactoRelacion);
		contactoRelacion.setContacto(this);

		return contactoRelacion;
	}

	public ContactoRelacion removeContactoRelacion(ContactoRelacion contactoRelacion) {
		getContactoRelacions().remove(contactoRelacion);
		contactoRelacion.setContacto(null);

		return contactoRelacion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idContacto == null) ? 0 : idContacto.hashCode());
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
		Contacto other = (Contacto) obj;
		if (idContacto == null) {
			if (other.idContacto != null)
				return false;
		} else if (!idContacto.equals(other.idContacto))
			return false;
		return true;
	}

}