package com.service;

import com.exception.MonitorException;
import com.model.Estacion;
import com.service.interfaces.EstacionBeanLocal;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

/**
 * Session Bean implementation class EstacionBean
 */
@Stateless
@LocalBean
public class EstacionBean implements EstacionBeanLocal {


	@PersistenceContext
	private EntityManager em;
	
	public EstacionBean() {
    }

	@Override
	public Long createEstacion(Estacion estacion) throws MonitorException {
		try {
			em.persist(estacion);
			em.flush();
			return estacion.getIdEstacion();
		} catch (PersistenceException e) {
			throw new MonitorException("Ha ocurrido un error al dar de alta una estacion");
		}
	}

	@Override
	public Long update(Estacion estacion) throws MonitorException {
		try {
			em.merge(estacion);
			em.flush();
			return estacion.getIdEstacion();
		} catch (PersistenceException e) {
			throw new MonitorException("Error al actualizar la estacion");
		}
	}

	@Override
	public void removeEstacion(Long idEstacion) throws MonitorException {
		try {
			//Estacion estacion = 
			em.find(Estacion.class, idEstacion);
			em.remove(idEstacion);
			em.flush();
		} catch (PersistenceException e) {
			throw new MonitorException("Ha ocurrido un error al borrar la estacion");
		}
	}

	@Override
	public Estacion getEstacion(Long idEstacion) throws MonitorException {
		try {
			return em.find(Estacion.class, idEstacion);
		}  catch (PersistenceException e) {
			throw new MonitorException("Ha ocurrido un error al buscar la estacion");
		}
	}

	@Override
	public Estacion getEstacionNombre(String nomEstacion) throws MonitorException {
		String sql = "SELECT e FROM Estacion e WHERE e.razonSocial = :nombre";
		try {
			TypedQuery<Estacion> query = em.createQuery(sql, Estacion.class);
			query.setParameter("nombre", nomEstacion);
			return query.getSingleResult();
		} catch (PersistenceException e) {
			throw new MonitorException("No existe la estacion con la razon social: " + nomEstacion);
		}
	}

	@Override
	public List<Estacion> getAllEstaciones() throws MonitorException {
		try {
			TypedQuery<Estacion> query = em.createQuery("SELECT e FROM Estacion e ORDER BY e.razonSocial", Estacion.class);
			return query.getResultList();
		} catch (PersistenceException e) {
			throw new MonitorException("Error al intentar recuperar todas las estaciones");
		}
	}

}
