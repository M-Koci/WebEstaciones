package com.managedBeans;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.exception.MonitorException;
import com.model.Estacion;
import com.model.Gac;
import com.model.SomW;
import com.service.interfaces.DbsOpBeanRemote;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@Named
@ViewScoped
public class GacMB implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private DbsOpBeanRemote gacBean;
	
	private Gac gac;
	private Long idGac;
	private Estacion estacion;
	private String usuario;
	private String password;

	private List<Gac> listGac;
	
	public GacMB() {
	}
	
	@PostConstruct
	public void init() {
		try {
			listGac = gacBean.getAllGac();
		} catch (MonitorException e) {
			e.printStackTrace();
		}
	}
	
	public void createGac() throws MonitorException {
		try {
			gac = new Gac();
			gac.setEstacion(estacion);
			gac.setUsuario(usuario);
			gac.setPassword(password);
			if(existeGac(gac.getEstacion()) != null) {
				if (existeEstacion(gac.getEstacion()) != null) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "La estación ya tiene GAC registrado"));
				}
			}  else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("GAC Registrado"));
				gacBean.createGac(gac);
			}
			
		} catch (MonitorException e) {
			e.printStackTrace();
		}
	}

	public Gac existeGac(Estacion estacion) throws MonitorException {
		try {
			return gacBean.getGacEstacion(estacion);
		} catch (MonitorException e) {
			return null;
		}
	}
	
	public SomW existeEstacion(Estacion estacion) throws MonitorException {
		try {
			return gacBean.getSomEstacion(estacion);
		} catch (MonitorException e) {
			return null;
		}
	}
	
	public boolean tieneGac(Estacion idEstacion) throws MonitorException {
		if (gacBean.getGacEstacion(idEstacion) == null) {
			return false;
		} else return true;
	}
	
	public void leerGac(Estacion estacionSelected) throws MonitorException {
		estacion = estacionSelected;
		gac = gacBean.getGacEstacion(estacion);
	}
	
	public void leer(Gac gacSelected) throws MonitorException {
		gac = gacSelected;
	}
	
	public void modificarGac() {
		try {
			gacBean.update(gac);
		} catch (MonitorException e) {
			e.printStackTrace();
		}
	}
	
	public List<Gac> listarGac() {
		try {
			return gacBean.getAllGac();
		} catch (MonitorException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	
	/* -#-#-#-#-#-#-#-#-# Getters y Setters #-#-#-#-#-#-#-#-#- */
	public Gac getGac() {
		return gac;
	}

	public void setGac(Gac gac) {
		this.gac = gac;
	}

	public Long getIdGac() {
		return idGac;
	}

	public void setIdGac(Long idGac) {
		this.idGac = idGac;
	}

	public Estacion getEstacion() {
		return estacion;
	}

	public void setEstacion(Estacion estacion) {
		this.estacion = estacion;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Gac> getListGac() {
		return listGac;
	}

	public void setListGac(List<Gac> listGac) {
		this.listGac = listGac;
	}
	
}
