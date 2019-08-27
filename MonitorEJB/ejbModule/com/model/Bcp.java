package com.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the bcp database table.
 * 
 */
@Entity
@Table(name="bcp")
@NamedQuery(name="Bcp.findAll", query="SELECT b FROM Bcp b")
public class Bcp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idBCP;

	private String llaveByPass;

	private String miTags;

	private String mpls;

	private String mwgt;

	private String ortr;

	private String passwordSOM;

	private Long picosVIS;

	private Long teamViewer;

	private String ups;

	private String usuarioSOM;

	private String versionPlaca;

	//bi-directional many-to-many association to Combustible
	@ManyToMany
	@JoinTable(
		name="bcp_combustible"
		, joinColumns={
			@JoinColumn(name="IdBCP")
			}
		, inverseJoinColumns={
			@JoinColumn(name="IdCombustible")
			}
		)
	private List<Combustible> combustibles;

	//bi-directional many-to-one association to Controladora
	@ManyToOne
	@JoinColumn(name="IdControladora")
	private Controladora controladora;

	//bi-directional many-to-one association to BcpCombustible
	@OneToMany(mappedBy="bcp")
	private List<BcpCombustible> bcpCombustibles;

	//bi-directional many-to-one association to Localidad
	@ManyToOne
	@JoinColumn(name="IdLocalidad")
	private Localidad localidad;

	public Bcp() {
	}

	public Long getIdBCP() {
		return this.idBCP;
	}

	public void setIdBCP(Long idBCP) {
		this.idBCP = idBCP;
	}

	public String getLlaveByPass() {
		return this.llaveByPass;
	}

	public void setLlaveByPass(String llaveByPass) {
		this.llaveByPass = llaveByPass;
	}

	public String getMiTags() {
		return this.miTags;
	}

	public void setMiTags(String miTags) {
		this.miTags = miTags;
	}

	public String getMpls() {
		return this.mpls;
	}

	public void setMpls(String mpls) {
		this.mpls = mpls;
	}

	public String getMwgt() {
		return this.mwgt;
	}

	public void setMwgt(String mwgt) {
		this.mwgt = mwgt;
	}

	public String getOrtr() {
		return this.ortr;
	}

	public void setOrtr(String ortr) {
		this.ortr = ortr;
	}

	public String getPasswordSOM() {
		return this.passwordSOM;
	}

	public void setPasswordSOM(String passwordSOM) {
		this.passwordSOM = passwordSOM;
	}

	public Long getPicosVIS() {
		return this.picosVIS;
	}

	public void setPicosVIS(Long picosVIS) {
		this.picosVIS = picosVIS;
	}

	public Long getTeamViewer() {
		return this.teamViewer;
	}

	public void setTeamViewer(Long teamViewer) {
		this.teamViewer = teamViewer;
	}

	public String getUps() {
		return this.ups;
	}

	public void setUps(String ups) {
		this.ups = ups;
	}

	public String getUsuarioSOM() {
		return this.usuarioSOM;
	}

	public void setUsuarioSOM(String usuarioSOM) {
		this.usuarioSOM = usuarioSOM;
	}

	public String getVersionPlaca() {
		return this.versionPlaca;
	}

	public void setVersionPlaca(String versionPlaca) {
		this.versionPlaca = versionPlaca;
	}

	public List<Combustible> getCombustibles() {
		return this.combustibles;
	}

	public void setCombustibles(List<Combustible> combustibles) {
		this.combustibles = combustibles;
	}

	public Controladora getControladora() {
		return this.controladora;
	}

	public void setControladora(Controladora controladora) {
		this.controladora = controladora;
	}

	public List<BcpCombustible> getBcpCombustibles() {
		return this.bcpCombustibles;
	}

	public void setBcpCombustibles(List<BcpCombustible> bcpCombustibles) {
		this.bcpCombustibles = bcpCombustibles;
	}

	public BcpCombustible addBcpCombustible(BcpCombustible bcpCombustible) {
		getBcpCombustibles().add(bcpCombustible);
		bcpCombustible.setBcp(this);

		return bcpCombustible;
	}

	public BcpCombustible removeBcpCombustible(BcpCombustible bcpCombustible) {
		getBcpCombustibles().remove(bcpCombustible);
		bcpCombustible.setBcp(null);

		return bcpCombustible;
	}

	public Localidad getLocalidad() {
		return this.localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idBCP == null) ? 0 : idBCP.hashCode());
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
		Bcp other = (Bcp) obj;
		if (idBCP == null) {
			if (other.idBCP != null)
				return false;
		} else if (!idBCP.equals(other.idBCP))
			return false;
		return true;
	}
	

}