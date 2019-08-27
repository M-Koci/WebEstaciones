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
import com.model.Departamento;
import com.model.Localidad;
import com.service.interfaces.DbsOpBeanRemote;

@ManagedBean
@ViewScoped
@Named
public class LocalidadMB implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private DbsOpBeanRemote localidadBean;
	
	private Long id;
	private String depto;
	private Departamento departamento;
	private String nombre;
	private Localidad localidad;
	private List<Localidad> localidades;
	
		
	
	
	public LocalidadMB() {
	}
	
	@PostConstruct
	public void init() {
		try {
			localidades = localidadBean.getAllLocalidades();
		} catch (MonitorException e) {
			e.printStackTrace();
		}
	}
	
	public void createLocalidad() throws MonitorException {
		try {
			localidad = new Localidad();
			localidad.setNombre(nombre);
			localidad.setDepartamento(departamento);
			if(existeLocalidad (localidad.getNombre()) != null && existeDepartamento(departamento.getIdDepartamento()) != null) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Ya existe una localidad con este nombre en este departamento"));
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Localidad Registrada"));
				localidadBean.createLocalidad(localidad);
				
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

	public Localidad existeLocalidad(String nomLocalidad) throws MonitorException {
		try {
			return localidadBean.getLocalidadNombre(nomLocalidad);
		} catch (MonitorException e) {
			return null;
		}
	}
	
	public Departamento existeDepartamento(Long idDepartamento)throws MonitorException {
		try {
			return localidadBean.getDepartamento(idDepartamento);
		} catch (MonitorException e) {
			return null;
		}
	}
	
	public List<Departamento> listarDepartamentos() {
		try {
			return localidadBean.getAllDepartamentos();
		} catch (MonitorException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Localidad> listarLocalidades() {
		try {
			return localidadBean.getAllLocalidades();
		} catch (MonitorException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Localidad getLocalidadId(int idLocalidad) {
        // Aqui se debe implementar una llamda a base de datos.
        Localidad localidad_ = null;
        for (Localidad l : localidades) {
            if (l.getIdLocalidad() == idLocalidad) {
                localidad_ = l;
            }
        }
        return localidad_;
    }

	/*---------- Getters y Setters ----------*/
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	public String getDepto() {
		return depto;
	}

	public void setDepto(String depto) {
		this.depto = depto;
	}

	public List<Localidad> getLocalidades() {
		return localidades;
	}

	public void setLocalidades(List<Localidad> localidades) {
		this.localidades = localidades;
	}
	
}
