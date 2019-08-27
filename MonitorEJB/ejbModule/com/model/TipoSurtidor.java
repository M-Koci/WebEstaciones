package com.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_surtidor database table.
 * 
 */
@Entity
@Table(name="tipo_surtidor")
@NamedQuery(name="TipoSurtidor.findAll", query="SELECT t FROM TipoSurtidor t")
public class TipoSurtidor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idTipoSurtidor;

	private String nombre;

	//bi-directional many-to-one association to SurtidorEstacion
	@OneToMany(mappedBy="tipoSurtidor")
	private List<SurtidorEstacion> surtidorEstacions;

	//bi-directional many-to-one association to Smcc
	@OneToMany(mappedBy="tipoSurtidor")
	private List<Smcc> smccs;

	public TipoSurtidor() {
	}

	public Long getIdTipoSurtidor() {
		return this.idTipoSurtidor;
	}

	public void setIdTipoSurtidor(Long idTipoSurtidor) {
		this.idTipoSurtidor = idTipoSurtidor;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<SurtidorEstacion> getSurtidorEstacions() {
		return this.surtidorEstacions;
	}

	public void setSurtidorEstacions(List<SurtidorEstacion> surtidorEstacions) {
		this.surtidorEstacions = surtidorEstacions;
	}

	public SurtidorEstacion addSurtidorEstacion(SurtidorEstacion surtidorEstacion) {
		getSurtidorEstacions().add(surtidorEstacion);
		surtidorEstacion.setTipoSurtidor(this);

		return surtidorEstacion;
	}

	public SurtidorEstacion removeSurtidorEstacion(SurtidorEstacion surtidorEstacion) {
		getSurtidorEstacions().remove(surtidorEstacion);
		surtidorEstacion.setTipoSurtidor(null);

		return surtidorEstacion;
	}

	public List<Smcc> getSmccs() {
		return this.smccs;
	}

	public void setSmccs(List<Smcc> smccs) {
		this.smccs = smccs;
	}

	public Smcc addSmcc(Smcc smcc) {
		getSmccs().add(smcc);
		smcc.setTipoSurtidor(this);

		return smcc;
	}

	public Smcc removeSmcc(Smcc smcc) {
		getSmccs().remove(smcc);
		smcc.setTipoSurtidor(null);

		return smcc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTipoSurtidor == null) ? 0 : idTipoSurtidor.hashCode());
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
		TipoSurtidor other = (TipoSurtidor) obj;
		if (idTipoSurtidor == null) {
			if (other.idTipoSurtidor != null)
				return false;
		} else if (!idTipoSurtidor.equals(other.idTipoSurtidor))
			return false;
		return true;
	}

}