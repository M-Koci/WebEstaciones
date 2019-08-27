package com.managedBeans;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;

import com.enums.Perfil;
import com.exception.MonitorException;
import com.model.Usuario;
import com.service.interfaces.DbsOpBeanRemote;;

@ManagedBean
@Named("usuarioMB")
@ViewScoped
public class UsuarioMB implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private DbsOpBeanRemote usuariosEJBBean;
	
	private Integer id;
	private String nombre;
	private String password;
	private String actualPass;
	private String tipoPerfil;
	private Perfil perfil;
	
	private List<Perfil> perfiles;
	
	private Usuario user;
	private List<Usuario> users;
	
	private String accion; 
	
	public boolean tienePerfil(Perfil perf) {
		return perfiles.contains(perf);
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getActualPass() {
		return actualPass;
	}

	public void setActualPass(String actualPass) {
		this.actualPass = actualPass;
	}

	public String getTipoPerfil() {
		return tipoPerfil;
	}
	public void setTipoPerfil(String tipoPerfil) {
		this.tipoPerfil = tipoPerfil;
	}
	public Perfil getPerfil() {
		return perfil;
	}
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	public Usuario getUser() {
		return user;
	}
	public void setUser(Usuario user) {
		this.user = user;
	}
	public List<Usuario> getUsers() {
		return users;
	}
	public void setUsers(List<Usuario> users) {
		this.users = users;
	}
	
	public String getAccion() {
		return accion;
	}
	public void setAccion(String accion) {
		this.accion = accion;
	}

	public void crearUsuario(){
		try {
			
			user = new Usuario();
			
			//if(existeId(user.getIdUsuario()) == null) {
				user.setIdUsuario(id);
			//}
			if(existeUsuario(user.getNombre()) == null) {
				user.setNombre(nombre.trim());
			} else if(nombre.isEmpty()) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Usuario ya existe. Debe ingresar un usuario diferente"));
			}
			String encript = DigestUtils.sha1Hex(password);
			user.setPassword(encript);
			user.setPerfil(Perfil.valueOf(tipoPerfil));
			
			if(existeUsuario(nombre) != null) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "El usuario ingresado ya existe"));
			} else {
			usuariosEJBBean.addUsuario(user);
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		    try {
				ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Usuario Registrado"));

			} catch (IOException e) {
				e.printStackTrace();
				}
			}
		} catch (MonitorException e ) {
			e.printStackTrace();
		}
	}
	
	public Usuario existeUsuario(String nombre) {
		try {
			return usuariosEJBBean.getUsuario(nombre);
		} catch (MonitorException e) {
			return null;
		}
	}
	
	public Usuario existeId(Integer idUsuario) {
		try {
			return usuariosEJBBean.getUsuario(idUsuario);
		} catch (MonitorException e) {
			return null;
		}
	}
	
	
	@PostConstruct
	public void init() {
		try {
			users = usuariosEJBBean.getAllUsuarios();
		} catch (MonitorException e) {
			e.printStackTrace();
		}
	}
	
	public void leer(Usuario userSelected ) {
		user = userSelected;
	}
	
	public void modificarUsuario() {
		try {
			String encript = DigestUtils.sha1Hex(user.getPassword());
			user.setPassword(encript);
			usuariosEJBBean.updateUsuario(user);
		} catch (MonitorException e) {
			e.printStackTrace();
		}
	}
	
	public void desactivarUsuario() throws MonitorException {
		usuariosEJBBean.desactivarUsuario(user);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Usuario desactivado"));
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
	    try {
			ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Perfil[] listarPerfiles() throws MonitorException {
		return usuariosEJBBean.getAllTipoPerfil();
	}
	
	public List<Perfil> editPerfiles(){
		return new ArrayList<Perfil>(Arrays.asList(Perfil.values()));
	}
	
	public List<Usuario> listarUsuarios() throws MonitorException{
		
		return usuariosEJBBean.getAllUsuarios();
	}
	
	public boolean hasRole(Perfil role) {
        return perfiles.contains(role);
    }
	
}
