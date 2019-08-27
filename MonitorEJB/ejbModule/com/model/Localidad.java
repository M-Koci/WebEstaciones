package com.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the localidad database table.
 * 
 */
@Entity
@Table(name="localidad")
@NamedQuery(name="Localidad.findAll", query="SELECT l FROM Localidad l")
public class Localidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idLocalidad;

	private String nombre;

	//bi-directional many-to-one association to Bcp
	@OneToMany(mappedBy="localidad")
	private List<Bcp> bcps;

	//bi-directional many-to-one association to Estacion
	@OneToMany(mappedBy="localidad")
	private List<Estacion> estacions;

	//bi-directional many-to-one association to Departamento
	@ManyToOne
	@JoinColumn(name="IdDepartamento")
	private Departamento departamento;

	public Localidad() {
	}

	public Long getIdLocalidad() {
		return this.idLocalidad;
	}

	public void setIdLocalidad(Long idLocalidad) {
		this.idLocalidad = idLocalidad;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Bcp> getBcps() {
		return this.bcps;
	}

	public void setBcps(List<Bcp> bcps) {
		this.bcps = bcps;
	}

	public Bcp addBcp(Bcp bcp) {
		getBcps().add(bcp);
		bcp.setLocalidad(this);

		return bcp;
	}

	public Bcp removeBcp(Bcp bcp) {
		getBcps().remove(bcp);
		bcp.setLocalidad(null);

		return bcp;
	}

	public List<Estacion> getEstacions() {
		return this.estacions;
	}

	public void setEstacions(List<Estacion> estacions) {
		this.estacions = estacions;
	}

	public Estacion addEstacion(Estacion estacion) {
		getEstacions().add(estacion);
		estacion.setLocalidad(this);

		return estacion;
	}

	public Estacion removeEstacion(Estacion estacion) {
		getEstacions().remove(estacion);
		estacion.setLocalidad(null);

		return estacion;
	}

	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	@Override
	public String toString() {
		return this.getIdLocalidad().toString();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idLocalidad == null) ? 0 : idLocalidad.hashCode());
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
		Localidad other = (Localidad) obj;
		if (idLocalidad == null) {
			if (other.idLocalidad != null)
				return false;
		} else if (!idLocalidad.equals(other.idLocalidad))
			return false;
		return true;
	}

}