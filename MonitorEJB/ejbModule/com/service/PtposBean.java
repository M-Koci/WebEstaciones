package com.service;

import com.exception.MonitorException;
import com.model.Estacion;
import com.model.Ptpos;
import com.service.interfaces.PtposBeanLocal;
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
public class PtposBean implements PtposBeanLocal {


	@PersistenceContext
	private EntityManager em;
	
	public PtposBean() {
    }

	@Override
	public String createPtpos(Ptpos ptpos) throws MonitorException {
		try {
			em.persist(ptpos);
			em.flush();
			return ptpos.getTerminal();
		} catch (PersistenceException e) {
			throw new MonitorException("Ha ocurrido un error al dar de alta el ptpos");
		}
	}

	@Override
	public String update(Ptpos ptpos) throws MonitorException {
		try {
			em.merge(ptpos);
			em.flush();
			return ptpos.getTerminal();
		} catch (PersistenceException e) {
			throw new MonitorException("Error al actualizar Ptpos");
		}
	}

	@Override
	public void removePtpos(String terminal) throws MonitorException {
		try {
			em.find(Ptpos.class, terminal);
			em.remove(terminal);
			em.flush();
		} catch (PersistenceException e) {
			throw new MonitorException("Ha ocurrido un error al borrar Ptpos");
		}
	}

	@Override
	public Ptpos getPtpos(String terminal) throws MonitorException {
		try {
			return em.find(Ptpos.class, terminal);
		}  catch (PersistenceException e) {
			throw new MonitorException("Ha ocurrido un error al buscar Ptpos");
		}
	}

	@Override
	public List<Ptpos> getPtposEstacion(Estacion estacion) throws MonitorException {
		String sql = "SELECT p FROM Ptpos p WHERE p.estacion = :estacion";
		try {
			TypedQuery<Ptpos> query = em.createQuery(sql, Ptpos.class);
			query.setParameter("estacion", estacion);
			return query.getResultList();
		} catch (PersistenceException e) {
			return null;
		}
	}

	@Override
	public List<Ptpos> getAllPtpos() throws MonitorException {
		try {
			TypedQuery<Ptpos> query = em.createQuery("SELECT p FROM Ptpos p ORDER BY p.terminal", Ptpos.class);
			return query.getResultList();
		} catch (PersistenceException e) {
			throw new MonitorException("Error al intentar recuperar todos los PTPOS");
		}
	}

}
