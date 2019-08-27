package com.service;

import com.exception.MonitorException;
import com.model.SistemaGestion;
import com.service.interfaces.SistemaGestionBeanLocal;

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
public class SistemaGestionBean implements SistemaGestionBeanLocal {
	
	@PersistenceContext
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public SistemaGestionBean() {}
    
    @Override
	public Long createSG(SistemaGestion sistemaGestion) throws MonitorException {
		try {
			em.persist(sistemaGestion);
			em.flush();
			return sistemaGestion.getIdSistemaGestion();
		} catch (PersistenceException e) {
			throw new MonitorException("Ha ocurrido un error al dar de alta una localidad");
		}
	}

	@Override
	public Long update(SistemaGestion sistemaGestion) throws MonitorException {
		try {
			em.merge(sistemaGestion);
			em.flush();
			return sistemaGestion.getIdSistemaGestion();
		} catch (PersistenceException e) {
			throw new MonitorException("Error al actualizar la ternera");
		}
	}

	@Override
	public void removeSG (Long idSG) throws MonitorException {
		try {
			SistemaGestion sistemaGestion = em.find(SistemaGestion.class, idSG);
			em.remove(sistemaGestion);
			em.flush();
		} catch (PersistenceException e) {
			throw new MonitorException("Ha ocurrido un error al borrar el Sistema de Gestion");
		}	}

	@Override
	public SistemaGestion getSG(Long idSG) throws MonitorException {
		try {
			return em.find(SistemaGestion.class, idSG);
		}  catch (PersistenceException e) {
			throw new MonitorException("Ha ocurrido un error al buscar el sistema de gestion");
		}
	}
	
	@Override
	public SistemaGestion getSGNombre(String nomSG) throws MonitorException {
		String sql = "SELECT s FROM SistemaGestion s WHERE s.nombre = :nombre";
		try {
			TypedQuery<SistemaGestion> query = em.createQuery(sql, SistemaGestion.class);
			query.setParameter("nombre", nomSG);
			return query.getSingleResult();
		} catch (PersistenceException e) {
			throw new MonitorException("No existe el sistema de gestion con el nombre " + nomSG);
		}
		
	}

	@Override
	public List<SistemaGestion> getAllSG() throws MonitorException {
		try {
			TypedQuery<SistemaGestion> query = em.createQuery("SELECT s FROM SistemaGestion s ORDER BY s.idSistemaGestion", SistemaGestion.class);
			return query.getResultList();
		} catch (PersistenceException e) {
			throw new MonitorException("Error al intentar recuperar todos los Sistemas de Gestion");
		}
	}

}
