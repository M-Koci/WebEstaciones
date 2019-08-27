package com.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import com.model.Usuario;

@Named
@ViewScoped
public class PlantillaController implements Serializable {

	private static final long serialVersionUID = 1L;

	FacesContext context = FacesContext.getCurrentInstance();
	private Usuario us = (Usuario) context.getExternalContext().getSessionMap().get("usuario");

	public void verificarSesion() {

		try {
			if (us == null) {
				FacesContext.getCurrentInstance().getExternalContext().redirect("login.dbs");
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Usuario inexistente"));
			} else if (us.getPerfil().toString().equals("DESACTIVADO")) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Usuario Inactivo"));
				FacesContext.getCurrentInstance().getExternalContext().redirect("desactivado.dbs");
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verificarAdmin() {

		try {
			if (us == null) {
				FacesContext.getCurrentInstance().getExternalContext().redirect("login.dbs");
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Usuario inexistente"));
			} else if (us.getPerfil().name() != "ADMIN" ) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,
						"Aviso", "No tiene permiso para acceder a este recurso"));
				FacesContext.getCurrentInstance().getExternalContext().redirect("estacionesTecnicos.dbs");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verificarEncargado() {

		try {
			if (us == null) {
				FacesContext.getCurrentInstance().getExternalContext().redirect("login.dbs");
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Usuario inexistente"));
			} else if (us.getPerfil().name() != "ENCARGADO" && us.getPerfil().name() != "ADMIN") {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,
						"Aviso", "No tiene permiso para acceder a este recurso"));
				FacesContext.getCurrentInstance().getExternalContext().redirect("index.devit");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void verificarTecnico() {

		try {
			if (us == null) {
				FacesContext.getCurrentInstance().getExternalContext().redirect("login.dbs");
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Usuario inexistente"));
			} else if (us.getPerfil().name() != "TECNICO" && us.getPerfil().name() != "ADMIN") {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,
						"Aviso", "No tiene permiso para acceder a este recurso"));
				FacesContext.getCurrentInstance().getExternalContext().redirect("index.dbs");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Usuario getUs() {
		return us;
	}

	public void setUs(Usuario us) {
		this.us = us;
	}

}
