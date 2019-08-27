package com.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.apache.commons.codec.digest.DigestUtils;

import com.model.Usuario;
import com.service.interfaces.DbsOpBeanRemote;;

@Named
@SessionScoped
public class LoginController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private DbsOpBeanRemote EJBUsuario;

	private Usuario usuario;

	@PostConstruct
	public void init() {
		usuario = new Usuario();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String iniciarSesion() {
		String redireccion = null;
		try {
			String encript = DigestUtils.sha1Hex(usuario.getPassword());
			usuario = EJBUsuario.iniciarSesion(usuario.getNombre(), encript);
			if (usuario != null) {
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuario);

				if(usuario.getPerfil().toString().equals("DESACTIVADO")) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso","Usuario Inactivo"));
				}
				else if(usuario.getPerfil().toString().equals("ADMIN")) {
					redireccion = "editarEstaciones?faces-redirect=true";				}
				else {
					redireccion = "estacionesTecnicos?faces-redirect=true";
				}
			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Aviso","Datos incorrectos"));
		}
		return redireccion;
	}

	public String cerrarSesion() {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
		return "login?faces-redirect=true";
	}
}