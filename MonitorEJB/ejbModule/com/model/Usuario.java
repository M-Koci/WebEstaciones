package com.model;

import java.io.Serializable;
import javax.persistence.*;

import com.enums.Perfil;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Table (name="usuario")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
@NamedQuery(name="Usuario.findByNombre", query="SELECT u FROM Usuario u WHERE u.nombre = :nombre")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idUsuario;

	private String nombre;

	private String password;
	
	@Enumerated(EnumType.STRING)
	private Perfil perfil;

	public Usuario() {
	}
	
	public boolean isAdmin(){
        return Perfil.ADMIN.equals(perfil);
    }

	public Integer getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Integer idusuario) {
		this.idUsuario = idusuario;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Perfil getPerfil() {
		return this.perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((perfil == null) ? 0 : perfil.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (perfil != other.perfil)
			return false;
		return true;
	}

	

}