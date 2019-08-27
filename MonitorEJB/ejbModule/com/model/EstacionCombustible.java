package com.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the estacion_combustible database table.
 * 
 */
@Entity
@Table(name="estacion_combustible")
@NamedQuery(name="EstacionCombustible.findAll", query="SELECT e FROM EstacionCombustible e")
public class EstacionCombustible implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idEstacionCombustible;

	//bi-directional many-to-one association to Combustible
	@ManyToOne
	@JoinColumn(name="IdCombustible")
	private Combustible combustible;

	//bi-directional many-to-one association to Estacion
	@ManyToOne
	@JoinColumn(name="IdEstacion")
	private Estacion estacion;

	public EstacionCombustible() {
	}

	public Long getIdEstacionCombustible() {
		return this.idEstacionCombustible;
	}

	public void setIdEstacionCombustible(Long idEstacionCombustible) {
		this.idEstacionCombustible = idEstacionCombustible;
	}

	public Combustible getCombustible() {
		return this.combustible;
	}

	public void setCombustible(Combustible combustible) {
		this.combustible = combustible;
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
		result = prime * result + ((idEstacionCombustible == null) ? 0 : idEstacionCombustible.hashCode());
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
		EstacionCombustible other = (EstacionCombustible) obj;
		if (idEstacionCombustible == null) {
			if (other.idEstacionCombustible != null)
				return false;
		} else if (!idEstacionCombustible.equals(other.idEstacionCombustible))
			return false;
		return true;
	}
	
}