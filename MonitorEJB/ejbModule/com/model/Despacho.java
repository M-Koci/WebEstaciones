package com.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the scarmelo database table.
 * 
 */
@Entity
@Table(name="despachos")
@NamedQuery(name="Despacho.findAll", query="SELECT d FROM Despacho d")
public class Despacho implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idUnicoDespacho")
	private Integer id;
	
	@Column(name="stationCode")
	private Integer stationCode;

	@Column(name="duracion")
	private Integer duracion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fechaHora")
	private Date fechaCuelgue;

	@Column(name="importe")
	private Double importe;

	@Column(name="litros")
	private Double litros;

	@Column(name="manguera")
	private Integer manguera;

	@Column(name="precioUnitario")
	private Double precioUnitario;

	@Column(name="numeroDespachoPtNet")
	private Integer ptnet;
	
	@Column(name="autorizador")
	private Integer autorizador;

	public Despacho() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStationCode() {
		return stationCode;
	}

	public void setStationCode(Integer stationCode) {
		this.stationCode = stationCode;
	}

	public Integer getDuracion() {
		return this.duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public Date getFechaCuelgue() {
		return this.fechaCuelgue;
	}

	public void setFechaCuelgue(Date fechaCuelgue) {
		this.fechaCuelgue = fechaCuelgue;
	}

	public Double getImporte() {
		return this.importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public Double getLitros() {
		return this.litros;
	}

	public void setLitros(Double litros) {
		this.litros = litros;
	}

	public Integer getManguera() {
		return this.manguera;
	}

	public void setManguera(Integer manguera) {
		this.manguera = manguera;
	}

	public Double getPrecioUnitario() {
		return this.precioUnitario;
	}

	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public Integer getPtnet() {
		return this.ptnet;
	}

	public void setPtnet(Integer ptnet) {
		this.ptnet = ptnet;
	}
	
	public Integer getAutorizador() {
		return autorizador;
	}

	public void setAutorizador(Integer autorizador) {
		this.autorizador = autorizador;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Despacho other = (Despacho) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}