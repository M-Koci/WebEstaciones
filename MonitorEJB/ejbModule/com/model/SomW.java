package com.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the som_w database table.
 * 
 */
@Entity
@Table(name="som_w")
@NamedQuery(name="SomW.findAll", query="SELECT s FROM SomW s")
public class SomW implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String terminal;

	private String billeteraPistero;

	@Temporal(TemporalType.DATE)
	private Date cambioPila;

	private String fuenteSurtidor;

	private String llaveByPass;

	private String miTags;

	private String modeloPC;

	private String mpls;

	private String mwgt;

	private String ortr;

	private String passwordSOM;

	private String picosFuera;

	private String picosSOM;

	private String picosVIS;

	private String redAncapuntos;

	private String reguladorVoltaje;

	private String separacionPista;

	private String teamViewer;

	private String ups;

	private String usuarioSOM;

	private String version;
	
	private String ipTerminal;

	//bi-directional many-to-one association to Controladora
	@ManyToOne
	@JoinColumn(name="Controladora")
	private Controladora controladora;

	//bi-directional many-to-one association to Estacion
	@ManyToOne
	@JoinColumn(name="IdEstacion")
	private Estacion idEstacion;

	//bi-directional many-to-one association to Proveedor
	@ManyToOne
	@JoinColumn(name="IdProveedor")
	private Proveedor proveedor1;

	//bi-directional many-to-one association to Proveedor
	@ManyToOne
	@JoinColumn(name="IdMantenimiento")
	private Proveedor proveedor2;

	public SomW() {
	}

	public String getTerminal() {
		return this.terminal;
	}

	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}

	public String getBilleteraPistero() {
		return this.billeteraPistero;
	}

	public void setBilleteraPistero(String billeteraPistero) {
		this.billeteraPistero = billeteraPistero;
	}

	public Date getCambioPila() {
		return this.cambioPila;
	}

	public void setCambioPila(Date cambioPila) {
		this.cambioPila = cambioPila;
	}

	public String getFuenteSurtidor() {
		return this.fuenteSurtidor;
	}

	public void setFuenteSurtidor(String fuenteSurtidor) {
		this.fuenteSurtidor = fuenteSurtidor;
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

	public String getModeloPC() {
		return this.modeloPC;
	}

	public void setModeloPC(String modeloPC) {
		this.modeloPC = modeloPC;
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

	public String getPicosFuera() {
		return this.picosFuera;
	}

	public void setPicosFuera(String picosFuera) {
		this.picosFuera = picosFuera;
	}

	public String getPicosSOM() {
		return this.picosSOM;
	}

	public void setPicosSOM(String picosSOM) {
		this.picosSOM = picosSOM;
	}

	public String getPicosVIS() {
		return this.picosVIS;
	}

	public void setPicosVIS(String picosVIS) {
		this.picosVIS = picosVIS;
	}

	public String getRedAncapuntos() {
		return this.redAncapuntos;
	}

	public void setRedAncapuntos(String redAncapuntos) {
		this.redAncapuntos = redAncapuntos;
	}

	public String getReguladorVoltaje() {
		return this.reguladorVoltaje;
	}

	public void setReguladorVoltaje(String reguladorVoltaje) {
		this.reguladorVoltaje = reguladorVoltaje;
	}

	public String getSeparacionPista() {
		return this.separacionPista;
	}

	public void setSeparacionPista(String separacionPista) {
		this.separacionPista = separacionPista;
	}

	public String getTeamViewer() {
		return this.teamViewer;
	}

	public void setTeamViewer(String teamViewer) {
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

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getTerminalIP() {
		return ipTerminal;
	}

	public void setTerminalIP(String terminalIP) {
		this.ipTerminal = terminalIP;
	}

	public Controladora getControladora() {
		return this.controladora;
	}

	public void setControladora(Controladora controladoraBean) {
		this.controladora = controladoraBean;
	}

	public Estacion getEstacion() {
		return this.idEstacion;
	}

	public void setEstacion(Estacion estacion) {
		this.idEstacion = estacion;
	}

	public Proveedor getProveedor1() {
		return this.proveedor1;
	}

	public void setProveedor1(Proveedor proveedor1) {
		this.proveedor1 = proveedor1;
	}

	public Proveedor getProveedor2() {
		return this.proveedor2;
	}

	public void setProveedor2(Proveedor proveedor2) {
		this.proveedor2 = proveedor2;
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
		SomW other = (SomW) obj;
		if (terminal == null) {
			if (other.terminal != null)
				return false;
		} else if (!terminal.equals(other.terminal))
			return false;
		return true;
	}

}