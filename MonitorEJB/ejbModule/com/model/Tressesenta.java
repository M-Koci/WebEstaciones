package com.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tressesenta database table.
 * 
 */
@Entity
@Table(name="tressesenta")
@NamedQuery(name="Tressesenta.findAll", query="SELECT t FROM Tressesenta t")
public class Tressesenta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long terminal;

	private String rgi;

	private Long teamViewer;

	//bi-directional many-to-one association to Estacion
	@ManyToOne
	@JoinColumn(name="IdEstacion")
	private Estacion estacion;

	//bi-directional many-to-one association to TipoTerminal
	@ManyToOne
	@JoinColumn(name="IdTipoTerminal")
	private TipoTerminal tipoTerminal;

	public Tressesenta() {
	}

	public Long getTerminal() {
		return this.terminal;
	}

	public void setTerminal(Long terminal) {
		this.terminal = terminal;
	}

	public String getRgi() {
		return this.rgi;
	}

	public void setRgi(String rgi) {
		this.rgi = rgi;
	}

	public Long getTeamViewer() {
		return this.teamViewer;
	}

	public void setTeamViewer(Long teamViewer) {
		this.teamViewer = teamViewer;
	}

	public Estacion getEstacion() {
		return this.estacion;
	}

	public void setEstacion(Estacion estacion) {
		this.estacion = estacion;
	}

	public TipoTerminal getTipoTerminal() {
		return this.tipoTerminal;
	}

	public void setTipoTerminal(TipoTerminal tipoTerminal) {
		this.tipoTerminal = tipoTerminal;
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
		Tressesenta other = (Tressesenta) obj;
		if (terminal == null) {
			if (other.terminal != null)
				return false;
		} else if (!terminal.equals(other.terminal))
			return false;
		return true;
	}

}