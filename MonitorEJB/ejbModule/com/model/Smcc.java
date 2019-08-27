package com.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the smcc database table.
 * 
 */
@Entity
@Table(name="smcc")
@NamedQuery(name="Smcc.findAll", query="SELECT s FROM Smcc s")
public class Smcc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCamion;

	private String matricula;

	private String miTags;

	private String modeloPC;

	private String ortr;

	private Long picosVIS;

	//bi-directional many-to-one association to Controladora
	@ManyToOne
	@JoinColumn(name="IdControladora")
	private Controladora controladora;

	//bi-directional many-to-one association to Estacion
	@ManyToOne
	@JoinColumn(name="IdEstacion")
	private Estacion estacion;

	//bi-directional many-to-one association to SistemaGestion
	@ManyToOne
	@JoinColumn(name="IdSistemaGestion")
	private SistemaGestion sistemaGestion;

	//bi-directional many-to-one association to SistemaOperativo
	@ManyToOne
	@JoinColumn(name="IdSistemaOperativo")
	private SistemaOperativo sistemaOperativo;

	//bi-directional many-to-one association to TipoSurtidor
	@ManyToOne
	@JoinColumn(name="IdTipoSurtidor")
	private TipoSurtidor tipoSurtidor;

	public Smcc() {
	}

	public Long getIdCamion() {
		return this.idCamion;
	}

	public void setIdCamion(Long idCamion) {
		this.idCamion = idCamion;
	}

	public String getMatricula() {
		return this.matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMiTags() {
		return this.miTags;
	}

	public void setMiTags(String miTags) {
		this.miTags = miTags;
	}

	public String getModeloPC() {
		return this.modeloPC;
	}

	public void setModeloPC(String modeloPC) {
		this.modeloPC = modeloPC;
	}

	public String getOrtr() {
		return this.ortr;
	}

	public void setOrtr(String ortr) {
		this.ortr = ortr;
	}

	public Long getPicosVIS() {
		return this.picosVIS;
	}

	public void setPicosVIS(Long picosVIS) {
		this.picosVIS = picosVIS;
	}

	public Controladora getControladora() {
		return this.controladora;
	}

	public void setControladora(Controladora controladora) {
		this.controladora = controladora;
	}

	public Estacion getEstacion() {
		return this.estacion;
	}

	public void setEstacion(Estacion estacion) {
		this.estacion = estacion;
	}

	public SistemaGestion getSistemaGestion() {
		return this.sistemaGestion;
	}

	public void setSistemaGestion(SistemaGestion sistemaGestion) {
		this.sistemaGestion = sistemaGestion;
	}

	public SistemaOperativo getSistemaOperativo() {
		return this.sistemaOperativo;
	}

	public void setSistemaOperativo(SistemaOperativo sistemaOperativo) {
		this.sistemaOperativo = sistemaOperativo;
	}

	public TipoSurtidor getTipoSurtidor() {
		return this.tipoSurtidor;
	}

	public void setTipoSurtidor(TipoSurtidor tipoSurtidor) {
		this.tipoSurtidor = tipoSurtidor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCamion == null) ? 0 : idCamion.hashCode());
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
		Smcc other = (Smcc) obj;
		if (idCamion == null) {
			if (other.idCamion != null)
				return false;
		} else if (!idCamion.equals(other.idCamion))
			return false;
		return true;
	}

}