package com.service;

import com.exception.MonitorException;
import com.model.Controladora;
import com.service.interfaces.ControladoraBeanLocal;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

/**
 * Session Bean implementation class ControladoraBean
 */
@Stateless
@LocalBean
public class ControladoraBean implements ControladoraBeanLocal {
	
	@PersistenceContext
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public ControladoraBean() {
    }
    
    @Override
	public Long createControladora(Controladora controladora) throws MonitorException {
		try {
			em.persist(controladora);
			em.flush();
			return controladora.getIdControladora();
		} catch (PersistenceException e) {
			throw new MonitorException("Ha ocurrido un error al dar de alta una controladora");
		}
	}

	@Override
	public Long update(Controladora controladora) throws MonitorException {
		try {
			em.merge(controladora);
			em.flush();
			return controladora.getIdControladora();
		} catch (PersistenceException e) {
			throw new MonitorException("Error al actualizar la controladora");
		}
	}

	@Override
	public void removeControladora(Long idControladora) throws MonitorException {
		try {
			//Controladora controladora = 
			em.find(Controladora.class, idControladora);
			em.remove(idControladora);
			em.flush();
		} catch (PersistenceException e) {
			throw new MonitorException("Ha ocurrido un error al borrar la controladora");
		}	}

	@Override
	public Controladora getControladora(Long idControladora) throws MonitorException {
		try {
			return em.find(Controladora.class, idControladora);
		}  catch (PersistenceException e) {
			throw new MonitorException("Ha ocurrido un error al buscar la controladora");
		}
	}
	
	@Override
	public Controladora getControladoraNombre(String nomControladora) throws MonitorException {
		String sql = "SELECT c FROM Controladora c WHERE c.nombre = :nombre";
		try {
			TypedQuery<Controladora> query = em.createQuery(sql, Controladora.class);
			query.setParameter("nombre", nomControladora);
			return query.getSingleResult();
		} catch (PersistenceException e) {
			throw new MonitorException("No existe el sistema de gestion con el nombre " + nomControladora);
		}
	}

	@Override
	public List<Controladora> getAllControladora() throws MonitorException {
		try {
			TypedQuery<Controladora> query = em.createQuery("SELECT c FROM Controladora c ORDER BY c.idControladora", Controladora.class);
			return query.getResultList();
		} catch (PersistenceException e) {
			throw new MonitorException("Error al intentar recuperar todas las controladoras");
		}
	}

}
