package com.service;

import com.enums.Perfil;
import com.exception.MonitorException;
import com.model.Usuario;
import com.service.interfaces.UsuarioBeanLocal;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;


/**
 * Session Bean implementation class UsuarioBean
 */
@Stateless
public class UsuarioBean implements UsuarioBeanLocal {
	
	@PersistenceContext
	EntityManager em;
	
    public UsuarioBean() {
    }

	@Override
	public Integer addUsuario(Usuario usuario) throws MonitorException {
		try {
			em.persist(usuario);
			em.flush();
			return usuario.getIdUsuario();
		} catch (PersistenceException e) {
			throw new MonitorException("Error al crear usuario");
		}
	}

	@Override
	public void delUsuario(Integer id) throws MonitorException {
		try {
			Usuario usuario = em.find(Usuario.class, id);
			em.remove(usuario);
			em.flush();
		} catch (PersistenceException e) {
			throw new MonitorException("Error al borrar el usuario");
		}
	}

	@Override
	public Usuario getUsuario(Integer id) throws MonitorException {
		try {
			Usuario usuario = em.find(Usuario.class, id);
			return usuario;
		} catch (PersistenceException e) {
			throw new MonitorException("Error al traer un usuario");
		}
	}
	

	@Override
	public Usuario getUsuario(String usuario) throws MonitorException {
		try {
			TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.nombre = :usuario", Usuario.class)
					.setParameter("usuario", usuario);
			return query.getSingleResult();
		} catch (PersistenceException e) {
			throw new MonitorException("Error al buscar el usuario");
		}
	}


	@Override
	public long updateUsuario(Usuario usuario) throws MonitorException {
		try {
			em.merge(usuario);
			em.flush();
			return usuario.getIdUsuario();
		} catch (PersistenceException e) {
			throw new MonitorException("Error al actualizar el usuario");
		}
	}

	@Override
	public List<Usuario> getAll() throws MonitorException {
		try {
			TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u", Usuario.class); 
			return query.getResultList();
		} catch (PersistenceException e) {
			throw new MonitorException("Error al obtener todos los usuarios");
		}
	}

	
	@Override
	public List<Usuario> getAllByUser(String usuario) throws MonitorException {
		try {
			TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.usuario LIKE :usuario", Usuario.class);
			query.setParameter("nick", usuario);
			return query.getResultList();
		} catch (PersistenceException e) {
			throw new MonitorException("Error al obtener todos los usuarios por nick");
		}
	}

	@Override
	public boolean validarUsuario(String usuario, String password) throws MonitorException {
		try {
			String sql = "SELECT u FROM Usuario u WHERE u.usuario = :usuario AND u.password = :password";
			TypedQuery<Usuario> query = em.createQuery(sql, Usuario.class);
			query.setParameter("usuario", usuario);
			query.setParameter("password", password);
			if(query.getSingleResult()  != null) {
				return true;
			}
			return false;
			
		} catch (PersistenceException e) {
			throw new MonitorException("Error al validar Usuario");
		}
	}

	@Override
	public Usuario iniciarSesion(String usuario, String password) throws MonitorException {
		try {
			String sql = "SELECT u FROM Usuario u WHERE u.nombre = :usuario AND u.password = :password";
			TypedQuery<Usuario> query = em.createQuery(sql, Usuario.class);
			query.setParameter("usuario", usuario);
			query.setParameter("password", password);
			if(query.getSingleResult()  != null) {
				return query.getSingleResult();
			}
			return null;
			
		} catch (PersistenceException e) {
			throw new MonitorException("Error al validar Usuario");
		}
		
	}
	
	@Override
	public Usuario getStationCode(Integer stationCode) throws MonitorException {
		try {
			String sql = "SELECT u FROM Usuario u WHERE u.idUsuario = :stationCode ";
			TypedQuery<Usuario> query = em.createQuery(sql, Usuario.class);
			query.setParameter("idUsuario", stationCode);
			if(query.getSingleResult()  != null) {
				return query.getSingleResult();
			}
			return null;
		} catch (PersistenceException e) {
			throw new MonitorException("Error al obtener id");
		}
	}

	@Override
	public long desactivarUsuario(Usuario usuario) throws MonitorException {
		try {
			usuario.setPerfil(Perfil.DESACTIVADO);
			em.merge(usuario);
			em.flush();
			return usuario.getIdUsuario();
		} catch (PersistenceException e) {
			throw new MonitorException("Error al desactivar el usuario");
		}
	}

}
