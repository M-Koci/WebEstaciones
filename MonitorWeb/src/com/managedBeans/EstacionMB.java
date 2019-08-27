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
import com.model.Localidad;
import com.model.SistemaGestion;
import com.model.SomW;
import com.service.interfaces.DbsOpBeanRemote;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@Named
@ViewScoped
public class EstacionMB implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private DbsOpBeanRemote estacionBean;

	private Long idEstacion;
	private String razonSocial;
	private String direccion;
	private Localidad localidad;
	private SistemaGestion idSistemaGestion;
	private Long promedioMensual;
	private Estacion estacion;
	private List<Estacion> estaciones;
	private SomW som;
	private List<SomW> somW;

	public EstacionMB() {
	}

	@PostConstruct
	public void init() {
		try {
			estaciones = estacionBean.getAllEstaciones();
		} catch (MonitorException e) {
			e.printStackTrace();
		}
	}

	public void createEstacion() throws MonitorException {
		try {
			estacion = new Estacion();
			estacion.setIdEstacion(idEstacion);
			estacion.setRazonSocial(razonSocial.toUpperCase().trim());
			estacion.setDireccion(direccion);
			estacion.setSistemaGestion(idSistemaGestion);
			estacion.setPromedioMensual(promedioMensual);
			estacion.setLocalidad(localidad);
			if(existeEstacion (estacion.getRazonSocial()) != null) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Ya existe una estación con este nombre"));
			}  else {
				System.out.println("Se registra la ESTACION: " + estacion.getRazonSocial());
				System.out.println("Localidad: " + estacion.getLocalidad().getNombre());

				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Estacion Registrada"));
				estacionBean.createEstacion(estacion);
			}

		} catch (MonitorException e) {
			e.printStackTrace();
		}
	}

	public Estacion existeEstacion(String nombreEstacion) throws MonitorException {
		try {
			return estacionBean.getEstacionNombre(nombreEstacion);
		} catch (MonitorException e) {
			return null;
		}
	}

	public void leer(Estacion estacionSelected ) throws MonitorException {
		estacion = estacionSelected;
	}

	public boolean tieneSom(Estacion idEstacion) throws MonitorException {
		if (estacionBean.getSomEstacion(idEstacion) == null) {
			return false;
		} else return true;
	}

	public void modificarEstacion() {
		try {
			estacionBean.update(estacion);
		} catch (MonitorException e) {
			e.printStackTrace();
		}
	}

	public List<Estacion> listarEstaciones() {
		try {
			return estacionBean.getAllEstaciones();
		} catch (MonitorException e) {
			e.printStackTrace();
		}
		return null;
	}


	public List<Localidad> completeLoc(String query) throws MonitorException {
		List<Localidad> allLocalidades = estacionBean.getAllLocalidades();
		List<Localidad> filteredLocalidades = new ArrayList<Localidad>();

		for (int i = 0; i < allLocalidades.size(); i++) {
			Localidad skin = allLocalidades.get(i);
			if(skin.getNombre().toLowerCase().contains(query)) {
				filteredLocalidades.add(skin);
			}
		}

		return filteredLocalidades;
	}



	/* -#-#-#-#-#-#-#-#-# Getters y Setters #-#-#-#-#-#-#-#-#- */ 
	public Long getIdEstacion() {
		return idEstacion;
	}
	public void setIdEstacion(Long idEstacion) {
		this.idEstacion = idEstacion;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Localidad getLocalidad() {
		return localidad;
	}
	public void setLocalidad(Localidad idLocalidad) {
		this.localidad = idLocalidad;
	}
	public SistemaGestion getIdSistemaGestion() {
		return idSistemaGestion;
	}
	public void setIdSistemaGestion(SistemaGestion idSistemaGestion) {
		this.idSistemaGestion = idSistemaGestion;
	}
	public Long getPromedioMensual() {
		return promedioMensual;
	}
	public void setPromedioMensual(Long promedioMensual) {
		this.promedioMensual = promedioMensual;
	}
	public Estacion getEstacion() {
		return estacion;
	}
	public void setEstacion(Estacion estacion) {
		this.estacion = estacion;
	}
	public List<Estacion> getEstaciones() {
		return estaciones;
	}
	public void setEstaciones(List<Estacion> estaciones) {
		this.estaciones = estaciones;
	}

	public SomW getSom() {
		return som;
	}
	public void setSom(SomW som) {
		this.som = som;
	}

	public List<SomW> getSomW() {
		return somW;
	}

	public void setSomW(List<SomW> somW) {
		this.somW = somW;
	}

}
