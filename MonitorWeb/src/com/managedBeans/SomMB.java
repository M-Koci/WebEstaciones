package com.managedBeans;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.exception.MonitorException;
import com.model.ContactoRelacion;
import com.model.ContactoTelefono;
import com.model.Controladora;
import com.model.Estacion;
import com.model.Proveedor;
import com.model.SomW;
import com.service.interfaces.DbsOpBeanRemote;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@ManagedBean
@Named
@ViewScoped
public class SomMB implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private DbsOpBeanRemote somBean;
	
	private Estacion idEstacion;
	private String terminal;
	private String teamViewer;
	private String mpls;
	private String modeloPC;
	private Date cambioPila;
	private String reguladorVoltaje;
	private String ups;
	private String llaveByPass;
	private String billeteraPistero;
	private String separacionPista;
	private String picosVis;
	private String picosSom;
	private String mitags;
	private String ortr;
	private String fuenteSurtidor;
	private String mwgt;
	private String picosFuera;
	private Controladora idControladora;
	private String version;
	private String ipTerminal;
	private String redAncapuntos;
	private String usuarioSom;
	private String passwordSom;
	private Proveedor idProveedor;
	private Proveedor idMantenimiento;
	
	private Estacion estacion;
	private SomW som;
	private List<SomW> somW;
	
	private List<ContactoTelefono> telefono;
	private ContactoRelacion relacion;
	
	public SomMB() {
	}
	
	@PostConstruct
	public void init() {
		try {
			somW = somBean.getAllSom();
		} catch (MonitorException e) {
			e.printStackTrace();
		}
	}
	
	public void createSom() throws MonitorException {
		try {
			som = new SomW();
			som.setTerminal(terminal);
			som.setEstacion(idEstacion);
			som.setTeamViewer(teamViewer);
			som.setMpls(mpls);
			som.setModeloPC(modeloPC);
			som.setCambioPila(cambioPila);
			som.setFuenteSurtidor(fuenteSurtidor);
			som.setReguladorVoltaje(reguladorVoltaje);
			som.setUps(ups);
			som.setMiTags(mitags);
			som.setMwgt(mwgt);
			som.setOrtr(ortr);
			som.setLlaveByPass(llaveByPass);
			som.setBilleteraPistero(billeteraPistero);
			som.setSeparacionPista(separacionPista);
			som.setPicosSOM(picosSom);
			som.setPicosFuera(picosFuera);
			som.setPicosVIS(picosVis);
			som.setControladora(idControladora);
			som.setVersion(version);
			som.setTerminalIP(ipTerminal);
			som.setRedAncapuntos(redAncapuntos);
			som.setUsuarioSOM(usuarioSom);
			som.setPasswordSOM(passwordSom);
			som.setProveedor1(idProveedor);
			som.setProveedor2(idMantenimiento);
			
			if(existeSom (som.getTerminal()) != null) {
				if (existeEstacion(som.getEstacion()) != null) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Ya existe una SOM con este nombre"));
				}
			}  else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("SomW Registrada"));
				somBean.createSomW(som);
			}
			
		} catch (MonitorException e) {
			e.printStackTrace();
		}
	}

	public SomW existeSom(String terminalSom) throws MonitorException {
		try {
			return somBean.getSom(terminalSom);
		} catch (MonitorException e) {
			return null;
		}
	}
	
	public SomW existeEstacion(Estacion estacion) throws MonitorException {
		try {
			return somBean.getSomEstacion(estacion);
		} catch (MonitorException e) {
			return null;
		}
	}
	
	public void leerSom(Estacion estacionSelected) throws MonitorException {
		estacion = estacionSelected;
		som = somBean.getSomEstacion(estacion);
		relacion = somBean.getEstacionContacto(estacion);
		telefono = somBean.getTelContacto(relacion.getContacto());
	}
	
	public void leerEstacion(Estacion estacionSelected) throws MonitorException {
		idEstacion = estacionSelected;
		som = somBean.getSomEstacion(idEstacion);
	}
	
	
	public void leer(SomW somSelected) throws MonitorException {
		som = somSelected;
	}
	
	public void modificarSom() {
		try {
			somBean.update(som);
		} catch (MonitorException e) {
			e.printStackTrace();
		}
	}
	
	public List<SomW> listarSom() {
		try {
			return somBean.getAllSom();
		} catch (MonitorException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	/* -#-#-#-#-#-#-#-#-# Getters y Setters #-#-#-#-#-#-#-#-#- */
	public Estacion getIdEstacion() {
		return idEstacion;
	}

	public void setIdEstacion(Estacion idEstacion) {
		this.idEstacion = idEstacion;
	}

	public String getTerminal() {
		return terminal;
	}

	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}

	public String getTeamViewer() {
		return teamViewer;
	}

	public void setTeamViewer(String teamViewer) {
		this.teamViewer = teamViewer;
	}

	public String getMpls() {
		return mpls;
	}

	public void setMpls(String mpls) {
		this.mpls = mpls;
	}

	public String getModeloPC() {
		return modeloPC;
	}

	public void setModeloPC(String modeloPC) {
		this.modeloPC = modeloPC;
	}

	public Date getCambioPila() {
		return cambioPila;
	}

	public void setCambioPila(Date cambioPila) {
		this.cambioPila = cambioPila;
	}

	public String getReguladorVoltaje() {
		return reguladorVoltaje;
	}

	public void setReguladorVoltaje(String reguladorVoltaje) {
		this.reguladorVoltaje = reguladorVoltaje;
	}

	public String getUps() {
		return ups;
	}

	public void setUps(String ups) {
		this.ups = ups;
	}

	public String getLlaveByPass() {
		return llaveByPass;
	}

	public void setLlaveByPass(String llaveByPass) {
		this.llaveByPass = llaveByPass;
	}

	public String getBilleteraPistero() {
		return billeteraPistero;
	}

	public void setBilleteraPistero(String billeteraPistero) {
		this.billeteraPistero = billeteraPistero;
	}

	public String getSeparacionPista() {
		return separacionPista;
	}

	public void setSeparacionPista(String separacionPista) {
		this.separacionPista = separacionPista;
	}

	public String getPicosVis() {
		return picosVis;
	}

	public void setPicosVis(String picosVis) {
		this.picosVis = picosVis;
	}

	public String getPicosSom() {
		return picosSom;
	}

	public void setPicosSom(String picosSom) {
		this.picosSom = picosSom;
	}

	public String getMitags() {
		return mitags;
	}

	public void setMitags(String mitags) {
		this.mitags = mitags;
	}

	public String getOrtr() {
		return ortr;
	}

	public void setOrtr(String ortr) {
		this.ortr = ortr;
	}

	public String getFuenteSurtidor() {
		return fuenteSurtidor;
	}

	public void setFuenteSurtidor(String fuenteSurtidor) {
		this.fuenteSurtidor = fuenteSurtidor;
	}

	public String getMwgt() {
		return mwgt;
	}

	public void setMwgt(String mwgt) {
		this.mwgt = mwgt;
	}

	public String getPicosFuera() {
		return picosFuera;
	}

	public void setPicosFuera(String picosFuera) {
		this.picosFuera = picosFuera;
	}

	public Controladora getIdControladora() {
		return idControladora;
	}

	public void setIdControladora(Controladora idControladora) {
		this.idControladora = idControladora;
	}

	public String getVersion() {
		return version;
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

	public String getRedAncapuntos() {
		return redAncapuntos;
	}

	public void setRedAncapuntos(String redAncapuntos) {
		this.redAncapuntos = redAncapuntos;
	}

	public String getUsuarioSom() {
		return usuarioSom;
	}

	public void setUsuarioSom(String usuarioSom) {
		this.usuarioSom = usuarioSom;
	}

	public String getPasswordSom() {
		return passwordSom;
	}

	public void setPasswordSom(String passwordSom) {
		this.passwordSom = passwordSom;
	}

	public Proveedor getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(Proveedor idProveedor) {
		this.idProveedor = idProveedor;
	}

	public Proveedor getIdMantenimiento() {
		return idMantenimiento;
	}

	public void setIdMantenimiento(Proveedor idMantenimiento) {
		this.idMantenimiento = idMantenimiento;
	}

	public List<SomW> getSomW() {
		return somW;
	}

	public void setSomW(List<SomW> somW) {
		this.somW = somW;
	}

	public SomW getSom() {
		return som;
	}

	public void setSom(SomW som) {
		this.som = som;
	} 
	
	public List<ContactoTelefono> getTelefono() {
		return telefono;
	}

	public void setTelefono(List<ContactoTelefono> relacion) {
		this.telefono = relacion;
	}

	public ContactoRelacion getRelacion() {
		return relacion;
	}

	public void setRelacion(ContactoRelacion relacion) {
		this.relacion = relacion;
	}

	public Estacion getEstacion() {
		return estacion;
	}

	public void setEstacion(Estacion estacion) {
		this.estacion = estacion;
	}
	
}
