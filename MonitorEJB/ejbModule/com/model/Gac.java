package com.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="gac")
@NamedQuery(name="Gac.findAll", query="SELECT g FROM Gac g")
public class Gac implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idGac;

	private String usuario;

	private String password;

	//bi-directional many-to-one association to Estacion
	@ManyToOne
	@JoinColumn(name="IdEstacion")
	private Estacion estacion;

	public Gac() {
	}
	

	public Long getIdGac() {
		return idGac;
	}


	public void setIdGac(Long idGac) {
		this.idGac = idGac;
	}

	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Estacion getEstacion() {
		return this.estacion;
	}

	public void setEstacion(Estacion estacion) {
		this.estacion = estacion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idGac == null) ? 0 : idGac.hashCode());
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
		Gac other = (Gac) obj;
		if (idGac == null) {
			if (other.idGac != null)
				return false;
		} else if (!idGac.equals(other.idGac))
			return false;
		return true;
	}

}