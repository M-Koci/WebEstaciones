package com.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the surtidor_estacion database table.
 * 
 */
@Entity
@Table(name="surtidor_estacion")
@NamedQuery(name="SurtidorEstacion.findAll", query="SELECT s FROM SurtidorEstacion s")
public class SurtidorEstacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idSurtidorEstacion;

	//bi-directional many-to-one association to TipoSurtidor
	@ManyToOne
	@JoinColumn(name="IdSurtidor")
	private TipoSurtidor tipoSurtidor;

	//bi-directional many-to-one association to Estacion
	@ManyToOne
	@JoinColumn(name="IdEstacion")
	private Estacion estacion;

	public SurtidorEstacion() {
	}

	public Long getIdSurtidorEstacion() {
		return this.idSurtidorEstacion;
	}

	public void setIdSurtidorEstacion(Long idSurtidorEstacion) {
		this.idSurtidorEstacion = idSurtidorEstacion;
	}

	public TipoSurtidor getTipoSurtidor() {
		return this.tipoSurtidor;
	}

	public void setTipoSurtidor(TipoSurtidor tipoSurtidor) {
		this.tipoSurtidor = tipoSurtidor;
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
		result = prime * result + ((idSurtidorEstacion == null) ? 0 : idSurtidorEstacion.hashCode());
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
		SurtidorEstacion other = (SurtidorEstacion) obj;
		if (idSurtidorEstacion == null) {
			if (other.idSurtidorEstacion != null)
				return false;
		} else if (!idSurtidorEstacion.equals(other.idSurtidorEstacion))
			return false;
		return true;
	}

}