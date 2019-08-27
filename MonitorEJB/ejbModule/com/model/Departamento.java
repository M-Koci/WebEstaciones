package com.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the departamento database table.
 * 
 */
@Entity
@Table(name="departamento")
@NamedQuery(name="Departamento.findAll", query="SELECT d FROM Departamento d")
public class Departamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idDepartamento;

	private String nombre;

	//bi-directional many-to-one association to Localidad
	@OneToMany(mappedBy="departamento")
	private List<Localidad> localidads;

	public Departamento() {
	}

	public Long getIdDepartamento() {
		return this.idDepartamento;
	}

	public void setIdDepartamento(Long idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Localidad> getLocalidads() {
		return this.localidads;
	}

	public void setLocalidads(List<Localidad> localidads) {
		this.localidads = localidads;
	}

	public Localidad addLocalidad(Localidad localidad) {
		getLocalidads().add(localidad);
		localidad.setDepartamento(this);

		return localidad;
	}

	public Localidad removeLocalidad(Localidad localidad) {
		getLocalidads().remove(localidad);
		localidad.setDepartamento(null);

		return localidad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idDepartamento == null) ? 0 : idDepartamento.hashCode());
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
		Departamento other = (Departamento) obj;
		if (idDepartamento == null) {
			if (other.idDepartamento != null)
				return false;
		} else if (!idDepartamento.equals(other.idDepartamento))
			return false;
		return true;
	}

}