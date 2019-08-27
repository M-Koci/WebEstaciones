package com.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_terminal database table.
 * 
 */
@Entity
@Table(name="tipo_terminal")
@NamedQuery(name="TipoTerminal.findAll", query="SELECT t FROM TipoTerminal t")
public class TipoTerminal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idTipoTerminal;

	private String tipo;

	//bi-directional many-to-one association to Tressesenta
	@OneToMany(mappedBy="tipoTerminal")
	private List<Tressesenta> tressesentas;

	public TipoTerminal() {
	}

	public Long getIdTipoTerminal() {
		return this.idTipoTerminal;
	}

	public void setIdTipoTerminal(Long idTipoTerminal) {
		this.idTipoTerminal = idTipoTerminal;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Tressesenta> getTressesentas() {
		return this.tressesentas;
	}

	public void setTressesentas(List<Tressesenta> tressesentas) {
		this.tressesentas = tressesentas;
	}

	public Tressesenta addTressesenta(Tressesenta tressesenta) {
		getTressesentas().add(tressesenta);
		tressesenta.setTipoTerminal(this);

		return tressesenta;
	}

	public Tressesenta removeTressesenta(Tressesenta tressesenta) {
		getTressesentas().remove(tressesenta);
		tressesenta.setTipoTerminal(null);

		return tressesenta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTipoTerminal == null) ? 0 : idTipoTerminal.hashCode());
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
		TipoTerminal other = (TipoTerminal) obj;
		if (idTipoTerminal == null) {
			if (other.idTipoTerminal != null)
				return false;
		} else if (!idTipoTerminal.equals(other.idTipoTerminal))
			return false;
		return true;
	}

}