package com.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ptpos database table.
 * 
 */
@Entity
@Table(name="ptpos")
@NamedQuery(name="Ptpos.findAll", query="SELECT p FROM Ptpos p")
public class Ptpos implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String terminal;

	private String ancapuntos;

	private String despachosReales;

	private String ipLocal;

	private String ipTerminal;

	@Temporal(TemporalType.DATE)
	private Date keystore;

	private String ordenes;

	private String principal;

	private String vales;

	private String version;

	//bi-directional many-to-one association to Estacion
	@ManyToOne
	@JoinColumn(name="IdEstacion")
	private Estacion estacion;

	public Ptpos() {
	}

	public String getTerminal() {
		return this.terminal;
	}

	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}

	public String getAncapuntos() {
		return this.ancapuntos;
	}

	public void setAncapuntos(String ancapuntos) {
		this.ancapuntos = ancapuntos;
	}

	public String getDespachosReales() {
		return this.despachosReales;
	}

	public void setDespachosReales(String despachosReales) {
		this.despachosReales = despachosReales;
	}

	public String getIpLocal() {
		return this.ipLocal;
	}

	public void setIpLocal(String ipLocal) {
		this.ipLocal = ipLocal;
	}

	public String getIpTerminal() {
		return this.ipTerminal;
	}

	public void setIpTerminal(String ipTerminal) {
		this.ipTerminal = ipTerminal;
	}

	public Date getKeystore() {
		return this.keystore;
	}

	public void setKeystore(Date keystore) {
		this.keystore = keystore;
	}

	public String getOrdenes() {
		return this.ordenes;
	}

	public void setOrdenes(String ordenes) {
		this.ordenes = ordenes;
	}

	public String getPrincipal() {
		return this.principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public String getVales() {
		return this.vales;
	}

	public void setVales(String vales) {
		this.vales = vales;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
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
		result = prime * result + ((terminal == null) ? 0 : terminal.hashCode());
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
		Ptpos other = (Ptpos) obj;
		if (terminal == null) {
			if (other.terminal != null)
				return false;
		} else if (!terminal.equals(other.terminal))
			return false;
		return true;
	}

}