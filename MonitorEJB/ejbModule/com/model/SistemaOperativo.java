package com.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sistema_operativo database table.
 * 
 */
@Entity
@Table(name="sistema_operativo")
@NamedQuery(name="SistemaOperativo.findAll", query="SELECT s FROM SistemaOperativo s")
public class SistemaOperativo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idSistemaOperativo;

	private String nombre;

	private String version;

	//bi-directional many-to-one association to Smcc
	@OneToMany(mappedBy="sistemaOperativo")
	private List<Smcc> smccs;

	public SistemaOperativo() {
	}

	public Long getIdSistemaOperativo() {
		return this.idSistemaOperativo;
	}

	public void setIdSistemaOperativo(Long idSistemaOperativo) {
		this.idSistemaOperativo = idSistemaOperativo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public List<Smcc> getSmccs() {
		return this.smccs;
	}

	public void setSmccs(List<Smcc> smccs) {
		this.smccs = smccs;
	}

	public Smcc addSmcc(Smcc smcc) {
		getSmccs().add(smcc);
		smcc.setSistemaOperativo(this);

		return smcc;
	}

	public Smcc removeSmcc(Smcc smcc) {
		getSmccs().remove(smcc);
		smcc.setSistemaOperativo(null);

		return smcc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idSistemaOperativo == null) ? 0 : idSistemaOperativo.hashCode());
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
		SistemaOperativo other = (SistemaOperativo) obj;
		if (idSistemaOperativo == null) {
			if (other.idSistemaOperativo != null)
				return false;
		} else if (!idSistemaOperativo.equals(other.idSistemaOperativo))
			return false;
		return true;
	}

}