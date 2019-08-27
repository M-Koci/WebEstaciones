package com.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the contacto_email database table.
 * 
 */
@Entity
@Table(name="contacto_email")
@NamedQuery(name="ContactoEmail.findAll", query="SELECT c FROM ContactoEmail c")
public class ContactoEmail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idEmail;

	private String email;

	//bi-directional many-to-one association to Contacto
	@ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="IdContacto")
	private Contacto contacto;

	public ContactoEmail() {
	}

	public Long getIdEmail() {
		return this.idEmail;
	}

	public void setIdEmail(Long idEmail) {
		this.idEmail = idEmail;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Contacto getContacto() {
		return this.contacto;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}

}