package com.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the estacion database table.
 * 
 */
@Entity
@Table(name="estacion")
@NamedQuery(name="Estacion.findAll", query="SELECT e FROM Estacion e")
public class Estacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long idEstacion;

	private String direccion;

	private Long promedioMensual;

	private String razonSocial;
	

	//bi-directional many-to-one association to Localidad
	@ManyToOne
	@JoinColumn(name="IdLocalidad")
	private Localidad localidad;

	//bi-directional many-to-one association to SistemaGestion
	@ManyToOne
	@JoinColumn(name="IdSistemaGestion")
	private SistemaGestion sistemaGestion;

	//bi-directional many-to-one association to EstacionCombustible
	@OneToMany(mappedBy="estacion")
	private List<EstacionCombustible> estacionCombustibles;

	//bi-directional many-to-one association to Ptpo
	@OneToMany(mappedBy="estacion")
	private List<Ptpos> ptpos;

	//bi-directional many-to-one association to Smcc
	@OneToMany(mappedBy="estacion")
	private List<Smcc> smccs;

	//bi-directional many-to-one association to SomW
	@OneToMany(mappedBy="idEstacion")
	private List<SomW> somWs;

	//bi-directional many-to-one association to SurtidorEstacion
	@OneToMany(mappedBy="estacion")
	private List<SurtidorEstacion> surtidorEstacions;

	//bi-directional many-to-one association to Tressesenta
	@OneToMany(mappedBy="estacion")
	private List<Tressesenta> tressesentas;

	public Estacion() {
	}

	public Long getIdEstacion() {
		return this.idEstacion;
	}

	public void setIdEstacion(Long idEstacion) {
		this.idEstacion = idEstacion;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Long getPromedioMensual() {
		return this.promedioMensual;
	}

	public void setPromedioMensual(Long promedioMensual) {
		this.promedioMensual = promedioMensual;
	}

	public String getRazonSocial() {
		return this.razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public Localidad getLocalidad() {
		return this.localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	public SistemaGestion getSistemaGestion() {
		return this.sistemaGestion;
	}

	public void setSistemaGestion(SistemaGestion sistemaGestion) {
		this.sistemaGestion = sistemaGestion;
	}

	public List<EstacionCombustible> getEstacionCombustibles() {
		return this.estacionCombustibles;
	}

	public void setEstacionCombustibles(List<EstacionCombustible> estacionCombustibles) {
		this.estacionCombustibles = estacionCombustibles;
	}

	public EstacionCombustible addEstacionCombustible(EstacionCombustible estacionCombustible) {
		getEstacionCombustibles().add(estacionCombustible);
		estacionCombustible.setEstacion(this);

		return estacionCombustible;
	}

	public EstacionCombustible removeEstacionCombustible(EstacionCombustible estacionCombustible) {
		getEstacionCombustibles().remove(estacionCombustible);
		estacionCombustible.setEstacion(null);

		return estacionCombustible;
	}

	public List<Ptpos> getPtpos() {
		return this.ptpos;
	}

	public void setPtpos(List<Ptpos> ptpos) {
		this.ptpos = ptpos;
	}

	public Ptpos addPtpo(Ptpos ptpo) {
		getPtpos().add(ptpo);
		ptpo.setEstacion(this);

		return ptpo;
	}

	public Ptpos removePtpo(Ptpos ptpo) {
		getPtpos().remove(ptpo);
		ptpo.setEstacion(null);

		return ptpo;
	}

	public List<Smcc> getSmccs() {
		return this.smccs;
	}

	public void setSmccs(List<Smcc> smccs) {
		this.smccs = smccs;
	}

	public Smcc addSmcc(Smcc smcc) {
		getSmccs().add(smcc);
		smcc.setEstacion(this);

		return smcc;
	}

	public Smcc removeSmcc(Smcc smcc) {
		getSmccs().remove(smcc);
		smcc.setEstacion(null);

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
		somW.setEstacion(this);

		return somW;
	}

	public SomW removeSomW(SomW somW) {
		getSomWs().remove(somW);
		somW.setEstacion(null);

		return somW;
	}

	public List<SurtidorEstacion> getSurtidorEstacions() {
		return this.surtidorEstacions;
	}

	public void setSurtidorEstacions(List<SurtidorEstacion> surtidorEstacions) {
		this.surtidorEstacions = surtidorEstacions;
	}

	public SurtidorEstacion addSurtidorEstacion(SurtidorEstacion surtidorEstacion) {
		getSurtidorEstacions().add(surtidorEstacion);
		surtidorEstacion.setEstacion(this);

		return surtidorEstacion;
	}

	public SurtidorEstacion removeSurtidorEstacion(SurtidorEstacion surtidorEstacion) {
		getSurtidorEstacions().remove(surtidorEstacion);
		surtidorEstacion.setEstacion(null);

		return surtidorEstacion;
	}

	public List<Tressesenta> getTressesentas() {
		return this.tressesentas;
	}

	public void setTressesentas(List<Tressesenta> tressesentas) {
		this.tressesentas = tressesentas;
	}

	public Tressesenta addTressesenta(Tressesenta tressesenta) {
		getTressesentas().add(tressesenta);
		tressesenta.setEstacion(this);

		return tressesenta;
	}

	public Tressesenta removeTressesenta(Tressesenta tressesenta) {
		getTressesentas().remove(tressesenta);
		tressesenta.setEstacion(null);

		return tressesenta;
	}

	@Override
	public String toString() {
		return this.getIdEstacion().toString();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEstacion == null) ? 0 : idEstacion.hashCode());
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
		Estacion other = (Estacion) obj;
		if (idEstacion == null) {
			if (other.idEstacion != null)
				return false;
		} else if (!idEstacion.equals(other.idEstacion))
			return false;
		return true;
	}
	
}