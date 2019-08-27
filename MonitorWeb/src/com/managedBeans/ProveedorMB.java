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
import com.service.interfaces.DbsOpBeanRemote;

@ManagedBean
@ViewScoped
@Named
public class ProveedorMB implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private DbsOpBeanRemote proveedorBean;
	
	private Long id;
	private String nombre;
	private Long telefonoGuardia;
	private List<Proveedor> proveedores;
	private Proveedor proveedor;
		
	public ProveedorMB() {
	}
	
	@PostConstruct
	public void init() {
		try {
			proveedores = proveedorBean.getAllProveedores();
		} catch (MonitorException e) {
			e.printStackTrace();
		}
	}
	
	public void createProveedor() throws MonitorException {
		try {
			proveedor = new Proveedor();
			proveedor.setNombre(nombre);
			proveedor.setTelefonoGuardia(telefonoGuardia);
			if(existeProveedor (proveedor.getNombre()) != null) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Ya existe un proveedor registrado con ese nombre"));
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Proveedor Registrado"));
				proveedorBean.createProveedor(proveedor);
				
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
	
	public void modificarProveedor() {
		try {
			proveedorBean.update(proveedor);
		} catch (MonitorException e) {
			e.printStackTrace();
		}
	}

	public Proveedor existeProveedor(String nomProveedor) throws MonitorException {
		try {
			return proveedorBean.getProveedorNombre(nomProveedor);
		} catch (MonitorException e) {
			return null;
		}
	}
	
	public void leer(Proveedor provSelected ) {
		proveedor = provSelected;
	}
		
	public List<Proveedor> listarProveedores() {
		try {
			return proveedorBean.getAllProveedores();
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

	public Long getTelefonoGuardia() {
		return telefonoGuardia;
	}

	public void setTelefonoGuardia(Long telefonoGuardia) {
		this.telefonoGuardia = telefonoGuardia;
	}

	public List<Proveedor> getProveedores() {
		return proveedores;
	}

	public void setProveedores(List<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	
}
