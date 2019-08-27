package com.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sistema_gestion database table.
 * 
 */
@Entity
@Table(name="sistema_gestion")
@NamedQuery(name="SistemaGestion.findAll", query="SELECT s FROM SistemaGestion s")
public class SistemaGestion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idSistemaGestion;

	private String nombre;

	private String version;

	//bi-directional many-to-one association to Estacion
	@OneToMany(mappedBy="sistemaGestion")
	private List<Estacion> estacions;

	//bi-directional many-to-one association to Proveedor
	@ManyToOne
	@JoinColumn(name="IdProveedor")
	private Proveedor proveedor;

	//bi-directional many-to-one association to Smcc
	@OneToMany(mappedBy="sistemaGestion")
	private List<Smcc> smccs;

	public SistemaGestion() {
	}

	public Long getIdSistemaGestion() {
		return this.idSistemaGestion;
	}

	public void setIdSistemaGestion(Long idSistemaGestion) {
		this.idSistemaGestion = idSistemaGestion;
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

	public List<Estacion> getEstacions() {
		return this.estacions;
	}

	public void setEstacions(List<Estacion> estacions) {
		this.estacions = estacions;
	}

	public Estacion addEstacion(Estacion estacion) {
		getEstacions().add(estacion);
		estacion.setSistemaGestion(this);

		return estacion;
	}

	public Estacion removeEstacion(Estacion estacion) {
		getEstacions().remove(estacion);
		estacion.setSistemaGestion(null);

		return estacion;
	}

	public Proveedor getProveedor() {
		return this.proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public List<Smcc> getSmccs() {
		return this.smccs;
	}

	public void setSmccs(List<Smcc> smccs) {
		this.smccs = smccs;
	}

	public Smcc addSmcc(Smcc smcc) {
		getSmccs().add(smcc);
		smcc.setSistemaGestion(this);

		return smcc;
	}

	public Smcc removeSmcc(Smcc smcc) {
		getSmccs().remove(smcc);
		smcc.setSistemaGestion(null);

		return smcc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idSistemaGestion == null) ? 0 : idSistemaGestion.hashCode());
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
		SistemaGestion other = (SistemaGestion) obj;
		if (idSistemaGestion == null) {
			if (other.idSistemaGestion != null)
				return false;
		} else if (!idSistemaGestion.equals(other.idSistemaGestion))
			return false;
		return true;
	}

}