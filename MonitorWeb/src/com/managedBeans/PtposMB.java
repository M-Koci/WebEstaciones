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
import com.model.Estacion;
import com.model.Ptpos;
import com.model.SomW;
import com.service.interfaces.DbsOpBeanRemote;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@ManagedBean
@Named
@ViewScoped
public class PtposMB implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private DbsOpBeanRemote ptposBean;
	
	private Ptpos ptpos;
	private String terminal;
	private Estacion estacion;
	private String ipTerminal;
	private String ipLocal;
	private String ancapuntos;
	private String principal;
	private String version;
	private Date keystore;
	private String vales;
	private String ordenes;
	private String despachosReales;
	
	private List<Ptpos> listPtpos;
	private List<Ptpos> ptposEstacion;
	
	private List<ContactoTelefono> telefono;
	private ContactoRelacion relacion;
	
	public PtposMB() {
	}
	
	@PostConstruct
	public void init() {
		try {
			listPtpos = ptposBean.getAllPtpos();
		} catch (MonitorException e) {
			e.printStackTrace();
		}
	}
	
	public void createPtpos() throws MonitorException {
		try {
			ptpos = new Ptpos();
			ptpos.setTerminal(terminal);
			ptpos.setEstacion(estacion);
			ptpos.setIpLocal(ipLocal);
			ptpos.setIpTerminal(ipTerminal);
			ptpos.setAncapuntos(ancapuntos);
			ptpos.setPrincipal(principal);
			ptpos.setVersion(version);
			ptpos.setKeystore(keystore);
			ptpos.setVales(vales);
			ptpos.setOrdenes(ordenes);
			ptpos.setDespachosReales(despachosReales);
			
			if(existePtpos(ptpos.getTerminal()) != null) {
				if (existeEstacion(ptpos.getEstacion()) != null) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Ya existe una SOM con este nombre"));
				}
			}  else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("SomW Registrada"));
				ptposBean.createPtpos(ptpos);
			}
			
		} catch (MonitorException e) {
			e.printStackTrace();
		}
	}

	public Ptpos existePtpos(String terminalPtpos) throws MonitorException {
		try {
			return ptposBean.getPtpos(terminalPtpos);
		} catch (MonitorException e) {
			return null;
		}
	}
	
	public SomW existeEstacion(Estacion estacion) throws MonitorException {
		try {
			return ptposBean.getSomEstacion(estacion);
		} catch (MonitorException e) {
			return null;
		}
	}
	
	public void leerPtpos(Estacion estacionSelected) throws MonitorException {
		estacion = estacionSelected;
		ptposEstacion = ptposBean.getPtposEstacion(estacion);
		relacion = ptposBean.getEstacionContacto(estacion);
		telefono = ptposBean.getTelContacto(relacion.getContacto());
	}
	
	public void leerEstacion(Estacion estacionSelected) throws MonitorException {
		estacion = estacionSelected;
		ptposEstacion = ptposBean.getPtposEstacion(estacion);
	}
	
	public void leer(Ptpos ptposSelected) throws MonitorException {
		ptpos = ptposSelected;
	}
	
	public void modificarPtpos() {
		try {
			ptposBean.update(ptpos);
		} catch (MonitorException e) {
			e.printStackTrace();
		}
	}
	
	public List<Ptpos> listarPtpos() {
		try {
			return ptposBean.getAllPtpos();
		} catch (MonitorException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	/* -#-#-#-#-#-#-#-#-# Getters y Setters #-#-#-#-#-#-#-#-#- */
	public Ptpos getPtpos() {
		return ptpos;
	}

	public void setPtpos(Ptpos ptpos) {
		this.ptpos = ptpos;
	}

	public String getTerminal() {
		return terminal;
	}

	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}

	public Estacion getEstacion() {
		return estacion;
	}

	public void setEstacion(Estacion estacion) {
		this.estacion = estacion;
	}

	public String getIpTerminal() {
		return ipTerminal;
	}

	public void setIpTerminal(String ipTerminal) {
		this.ipTerminal = ipTerminal;
	}

	public String getIpLocal() {
		return ipLocal;
	}

	public void setIpLocal(String ipLocal) {
		this.ipLocal = ipLocal;
	}

	public String getAncapuntos() {
		return ancapuntos;
	}

	public void setAncapuntos(String ancapuntos) {
		this.ancapuntos = ancapuntos;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Date getKeystore() {
		return keystore;
	}

	public void setKeystore(Date keystore) {
		this.keystore = keystore;
	}

	public String getVales() {
		return vales;
	}

	public void setVales(String vales) {
		this.vales = vales;
	}

	public String getOrdenes() {
		return ordenes;
	}

	public void setOrdenes(String ordenes) {
		this.ordenes = ordenes;
	}

	public String getDespachosReales() {
		return despachosReales;
	}

	public void setDespachosReales(String despachosReales) {
		this.despachosReales = despachosReales;
	}

	public List<Ptpos> getListPtpos() {
		return listPtpos;
	}

	public void setListPtpos(List<Ptpos> listPtpos) {
		this.listPtpos = listPtpos;
	}

	public List<Ptpos> getPtposEstacion() {
		return ptposEstacion;
	}

	public void setPtposEstacion(List<Ptpos> ptposEstacion) {
		this.ptposEstacion = ptposEstacion;
	}

	public List<ContactoTelefono> getTelefono() {
		return telefono;
	}

	public void setTelefono(List<ContactoTelefono> telefono) {
		this.telefono = telefono;
	}

	public ContactoRelacion getRelacion() {
		return relacion;
	}

	public void setRelacion(ContactoRelacion relacion) {
		this.relacion = relacion;
	}
	
}
