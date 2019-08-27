package com.service;

import com.exception.MonitorException;
import com.model.Localidad;
import com.service.interfaces.LocalidadBeanLocal;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

/**
 * Session Bean implementation class LocalidadBean
 */
@Stateless
public class LocalidadBean implements LocalidadBeanLocal {
	
	@PersistenceContext
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public LocalidadBean() {}
    
    @Override
	public Long createLocalidad(Localidad localidad) throws MonitorException {
		try {
			em.persist(localidad);
			em.flush();
			return localidad.getIdLocalidad();
		} catch (PersistenceException e) {
			throw new MonitorException("Ha ocurrido un error al dar de alta una localidad");
		}
	}

	@Override
	public Long update(Localidad localidad) throws MonitorException {
		try {
			em.merge(localidad);
			em.flush();
			return localidad.getIdLocalidad();
		} catch (PersistenceException e) {
			throw new MonitorException("Error al actualizar la ternera");
		}
	}

	@Override
	public void removeLocalidad(Long idlocalidad) throws MonitorException {
		try {
			Localidad localidad = em.find(Localidad.class, idlocalidad);
			em.remove(localidad);
			em.flush();
		} catch (PersistenceException e) {
			throw new MonitorException("Ha ocurrido un error al borrar una localidad");
		}	}

	@Override
	public Localidad getLocalidad(Long idlocalidad) throws MonitorException {
		try {
			return em.find(Localidad.class, idlocalidad);
		}  catch (PersistenceException e) {
			throw new MonitorException("Ha ocurrido un error al buscar una localidad");
		}
	}
	
	@Override
	public Localidad getLocalidadNombre(String nomLocalidad) throws MonitorException {
		String sql = "SELECT l FROM Localidad l WHERE l.nombre = :nombre";
		try {
			TypedQuery<Localidad> query = em.createQuery(sql, Localidad.class);
			query.setParameter("nombre", nomLocalidad);
			return query.getSingleResult();
		} catch (PersistenceException e) {
			throw new MonitorException("No existe la localidad con el nombre " + nomLocalidad);
		}
		
	}

	@Override
	public List<Localidad> getAllLocalidades() throws MonitorException {
		try {
			TypedQuery<Localidad> query = em.createQuery("SELECT l FROM Localidad l ORDER BY l.idLocalidad", Localidad.class);
			return query.getResultList();
		} catch (PersistenceException e) {
			throw new MonitorException("Error al intentar recuperar todas las localidades");
		}
	}

}
