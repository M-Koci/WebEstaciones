package com.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the bcp_combustible database table.
 * 
 */
@Entity
@Table(name="bcp_combustible")
@NamedQuery(name="BcpCombustible.findAll", query="SELECT b FROM BcpCombustible b")
public class BcpCombustible implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idBCPCombustible;

	//bi-directional many-to-one association to Bcp
	@ManyToOne
	@JoinColumn(name="IdBCP")
	private Bcp bcp;

	//bi-directional many-to-one association to Combustible
	@ManyToOne
	@JoinColumn(name="IdCombustible")
	private Combustible combustible;

	public BcpCombustible() {
	}

	public Long getIdBCPCombustible() {
		return this.idBCPCombustible;
	}

	public void setIdBCPCombustible(Long idBCPCombustible) {
		this.idBCPCombustible = idBCPCombustible;
	}

	public Bcp getBcp() {
		return this.bcp;
	}

	public void setBcp(Bcp bcp) {
		this.bcp = bcp;
	}

	public Combustible getCombustible() {
		return this.combustible;
	}

	public void setCombustible(Combustible combustible) {
		this.combustible = combustible;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idBCPCombustible == null) ? 0 : idBCPCombustible.hashCode());
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
		BcpCombustible other = (BcpCombustible) obj;
		if (idBCPCombustible == null) {
			if (other.idBCPCombustible != null)
				return false;
		} else if (!idBCPCombustible.equals(other.idBCPCombustible))
			return false;
		return true;
	}
	
	

}