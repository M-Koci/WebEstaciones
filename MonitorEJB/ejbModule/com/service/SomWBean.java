package com.service;

import com.exception.MonitorException;
import com.model.Estacion;
import com.model.SomW;
import com.service.interfaces.SomWBeanLocal;

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
public class SomWBean implements SomWBeanLocal {


	@PersistenceContext
	private EntityManager em;
	
	public SomWBean() {
    }

	@Override
	public String createSomW(SomW somW) throws MonitorException {
		try {
			em.persist(somW);
			em.flush();
			return somW.getTerminal();
		} catch (PersistenceException e) {
			throw new MonitorException("Ha ocurrido un error al dar de alta una SOM-W");
		}
	}

	@Override
	public String update(SomW somW) throws MonitorException {
		try {
			em.merge(somW);
			em.flush();
			return somW.getTerminal();
		} catch (PersistenceException e) {
			throw new MonitorException("Error al actualizar la SOM");
		}
	}

	@Override
	public void removeSom(String terminal) throws MonitorException {
		try {
			em.find(SomW.class, terminal);
			em.remove(terminal);
			em.flush();
		} catch (PersistenceException e) {
			throw new MonitorException("Ha ocurrido un error al borrar la estacion");
		}
	}

	@Override
	public SomW getSom(String terminal) throws MonitorException {
		try {
			return em.find(SomW.class, terminal);
		}  catch (PersistenceException e) {
			throw new MonitorException("Ha ocurrido un error al buscar la SOM");
		}
	}

	@Override
	public SomW getSomEstacion(Estacion idEstacion) throws MonitorException {
		String sql = "SELECT e FROM SomW e WHERE e.idEstacion = :idEstacion";
		try {
			TypedQuery<SomW> query = em.createQuery(sql, SomW.class);
			query.setParameter("idEstacion", idEstacion);
			return query.getSingleResult();
		} catch (PersistenceException e) {
			return null;
		}
	}

	@Override
	public List<SomW> getAllSom() throws MonitorException {
		try {
			TypedQuery<SomW> query = em.createQuery("SELECT e FROM SomW e ORDER BY e.terminal", SomW.class);
			return query.getResultList();
		} catch (PersistenceException e) {
			throw new MonitorException("Error al intentar recuperar todas las SOM");
		}
	}

}
