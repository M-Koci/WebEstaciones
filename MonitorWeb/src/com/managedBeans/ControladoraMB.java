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
import com.model.Controladora;
import com.model.Proveedor;
import com.model.SistemaGestion;
import com.service.interfaces.DbsOpBeanRemote;

@ManagedBean
@ViewScoped
@Named
public class ControladoraMB implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private DbsOpBeanRemote controladoraBean;
	
	private Long id;
	private Controladora controladora;
	private String nombre;
	private String version;
	private SistemaGestion sistemaGestion;
	private List<Controladora> controladoras;
	private Proveedor proveedor;
	
	public ControladoraMB() {
	}
	
	@PostConstruct
	public void init() {
		try {
			controladoras = controladoraBean.getAllControladora();
		} catch (MonitorException e) {
			e.printStackTrace();
		}
	}
	
	public void createControladora() throws MonitorException {
		try {
			controladora = new Controladora();
			controladora.setNombre(nombre);
			controladora.setVersion(version);
			controladora.setProveedor(proveedor);
			if(existeControladora (controladora.getNombre()) != null) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Ya existe una controladora con este nombre y esta version"));
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Controladora Registrada"));
				controladoraBean.createControladora(controladora);
				
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

	public Controladora existeControladora(String nombreControladora) throws MonitorException {
		try {
			return controladoraBean.getControladoraNombre(nombreControladora);
		} catch (MonitorException e) {
			return null;
		}
	}
	
	public void leer(Controladora conSelected ) {
		controladora = conSelected;
	}
	
	public void modificarControladora() {
		try {
			controladoraBean.update(controladora);
		} catch (MonitorException e) {
			e.printStackTrace();
		}
	}
	
	public List<Controladora> listarControladoras() {
		try {
			return controladoraBean.getAllControladora();
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

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public Controladora getControladora() {
		return controladora;
	}

	public void setControladora(Controladora controladora) {
		this.controladora = controladora;
	}

	public List<Controladora> getControladoras() {
		return controladoras;
	}

	public void setControladoras(List<Controladora> controladoras) {
		this.controladoras = controladoras;
	}
	
}
