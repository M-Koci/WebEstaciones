package com.service;

import com.exception.MonitorException;
import com.model.Estacion;
import com.model.Gac;
import com.service.interfaces.GacBeanLocal;
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
public class GacBean implements GacBeanLocal {


	@PersistenceContext
	private EntityManager em;
	
	public GacBean() {
    }

	@Override
	public Long createGac(Gac gac) throws MonitorException {
		try {
			em.persist(gac);
			em.flush();
			return gac.getIdGac();
		} catch (PersistenceException e) {
			throw new MonitorException("Ha ocurrido un error al dar de alta el Gac");
		}
	}

	@Override
	public Long update(Gac gac) throws MonitorException {
		try {
			em.merge(gac);
			em.flush();
			return gac.getIdGac();
		} catch (PersistenceException e) {
			throw new MonitorException("Error al actualizar Gac");
		}
	}

	@Override
	public void removeGac(Long idGac) throws MonitorException {
		try {
			em.find(Gac.class, idGac);
			em.remove(idGac);
			em.flush();
		} catch (PersistenceException e) {
			throw new MonitorException("Ha ocurrido un error al borrar Gac");
		}
	}

	@Override
	public Gac getGac(Long idGac) throws MonitorException {
		try {
			return em.find(Gac.class, idGac);
		}  catch (PersistenceException e) {
			throw new MonitorException("Ha ocurrido un error al buscar Gac");
		}
	}

	@Override
	public Gac getGacEstacion(Estacion estacion) throws MonitorException {
		String sql = "SELECT g FROM Gac g WHERE g.estacion = :estacion";
		try {
			TypedQuery<Gac> query = em.createQuery(sql, Gac.class);
			query.setParameter("estacion", estacion);
			return query.getSingleResult();
		} catch (PersistenceException e) {
			return null;
		}
	}

	@Override
	public List<Gac> getAllGac() throws MonitorException {
		try {
			TypedQuery<Gac> query = em.createQuery("SELECT g FROM Gac g ORDER BY g.idGac", Gac.class);
			return query.getResultList();
		} catch (PersistenceException e) {
			throw new MonitorException("Error al intentar recuperar todos los GAC");
		}
	}

}
