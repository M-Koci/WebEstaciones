package com.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the controladora database table.
 * 
 */
@Entity
@Table(name="controladora")
@NamedQuery(name="Controladora.findAll", query="SELECT c FROM Controladora c")
public class Controladora implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idControladora;

	private String nombre;

	private String version;

	//bi-directional many-to-one association to Bcp
	@OneToMany(mappedBy="controladora")
	private List<Bcp> bcps;

	//bi-directional many-to-one association to Proveedor
	@ManyToOne
	@JoinColumn(name="IdProveedor")
	private Proveedor proveedor;

	//bi-directional many-to-one association to Smcc
	@OneToMany(mappedBy="controladora")
	private List<Smcc> smccs;

	//bi-directional many-to-one association to SomW
	@OneToMany(mappedBy="controladora")
	private List<SomW> somWs;

	public Controladora() {
	}

	public Long getIdControladora() {
		return this.idControladora;
	}

	public void setIdControladora(Long idControladora) {
		this.idControladora = idControladora;
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

	public List<Bcp> getBcps() {
		return this.bcps;
	}

	public void setBcps(List<Bcp> bcps) {
		this.bcps = bcps;
	}

	public Bcp addBcp(Bcp bcp) {
		getBcps().add(bcp);
		bcp.setControladora(this);

		return bcp;
	}

	public Bcp removeBcp(Bcp bcp) {
		getBcps().remove(bcp);
		bcp.setControladora(null);

		return bcp;
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
		smcc.setControladora(this);

		return smcc;
	}

	public Smcc removeSmcc(Smcc smcc) {
		getSmccs().remove(smcc);
		smcc.setControladora(null);

		return smcc;
	}

	public List<SomW> getSomWs() {
		return this.somWs;
	}

	public void setSomWs(List<SomW> somWs) {
		this.somWs = somWs;
	}

	public SomW addSomW(SomW somW) {
		getSomWs().add(somW);
		somW.setControladora(this);

		return somW;
	}

	public SomW removeSomW(SomW somW) {
		getSomWs().remove(somW);
		somW.setControladora(null);

		return somW;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idControladora == null) ? 0 : idControladora.hashCode());
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
		Controladora other = (Controladora) obj;
		if (idControladora == null) {
			if (other.idControladora != null)
				return false;
		} else if (!idControladora.equals(other.idControladora))
			return false;
		return true;
	}

}