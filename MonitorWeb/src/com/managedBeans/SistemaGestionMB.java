package com.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.faces.context.FacesContext;

import com.exception.MonitorException;
import com.model.Proveedor;
import com.model.SistemaGestion;
import com.service.interfaces.DbsOpBeanRemote;

@ManagedBean
@ViewScoped
@Named
public class SistemaGestionMB implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private DbsOpBeanRemote sgestionBean;
	
	private Long id;
	private String version;
	private String nombre;
	private SistemaGestion sistemaGestion;
	private List<SistemaGestion> sistemas;
	private Proveedor proveedor;
	
		
	
	
	public SistemaGestionMB() {
	}
	
	@PostConstruct
	public void init() {
		try {
			sistemas = sgestionBean.getAllSG();
		} catch (MonitorException e) {
			e.printStackTrace();
		}
	}
	
	public void createSistemaGestion() throws MonitorException {
		try {
			sistemaGestion = new SistemaGestion();
			sistemaGestion.setNombre(nombre);
			sistemaGestion.setVersion(version);
			sistemaGestion.setProveedor(proveedor);
			if(existeSistemaGestion (sistemaGestion.getNombre()) != null) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Ya existe un sistema de gestion con este nombre"));
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sistema de Gestion Registrado"));
				sgestionBean.createSG(sistemaGestion);
				
				//ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
//				try {
//					
//					ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
//
//				} catch (IOException e) {
//					e.printStackTrace();
//					}
			}
			
		} catch (MonitorException e) {
			e.printStackTrace();
		}
	}

	public SistemaGestion existeSistemaGestion(String nombreSG) throws MonitorException {
		try {
			return sgestionBean.getSGNombre(nombreSG);
		} catch (MonitorException e) {
			return null;
		}
	}
	
	public void leer(SistemaGestion sgSelected ) {
		sistemaGestion = sgSelected;
	}
	
	public void modificarSistemaGestion() {
		try {
			sgestionBean.update(sistemaGestion);
		} catch (MonitorException e) {
			e.printStackTrace();
		}
	}
	
	public List<SistemaGestion> listarSG() {
		try {
			return sgestionBean.getAllSG();
		} catch (MonitorException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/*---------- Getters y Setters ----------*/
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public SistemaGestion getSistemaGestion() {
		return sistemaGestion;
	}

	public void setSistemaGestion(SistemaGestion sistemaGestion) {
		this.sistemaGestion = sistemaGestion;
	}

	public List<SistemaGestion> getSistemas() {
		return sistemas;
	}

	public void setSistemas(List<SistemaGestion> sistemas) {
		this.sistemas = sistemas;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	
	
}
