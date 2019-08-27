package com.service;

import com.exception.MonitorException;
import com.model.Despacho;
import com.service.interfaces.DespachoBeanLocal;
import com.service.interfaces.DespachoBeanRemote;
import com.service.interfaces.UsuarioBeanLocal;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

/**
 * Session Bean implementation class DespachoBean
 */
@Stateless
@LocalBean
public class DespachoBean implements DespachoBeanRemote, DespachoBeanLocal {

	@PersistenceContext
	EntityManager em;
	
	@EJB
	private UsuarioBeanLocal usuarioBean;
    
    public DespachoBean() {
    }
    
    @Override
	public Integer addDespacho(Despacho despacho) throws MonitorException {
		try {
			em.persist(despacho);
			em.flush();
			return despacho.getId();
		} catch (PersistenceException e) {
			throw new MonitorException("Ha ocurrido un error al ingresar el despacho");
		}
	}

	@Override
	public List<Despacho> getAllDespachos() throws MonitorException {
		try {
			TypedQuery<Despacho> query = em.createQuery("SELECT d FROM Despacho d", Despacho.class); 
			return query.getResultList();
		} catch (PersistenceException e) {
			throw new MonitorException("Error al obtener los despachos");
		}
	}
	
	@Override
	public List<Despacho> getDespachoFechas(Date fechaD, Date fechaH, Integer stationCode) throws MonitorException {
		try {
			String sql = "SELECT s FROM Despacho s WHERE s.fechaCuelgue BETWEEN :fechaD and :fechaH and s.stationCode = :stationCode order by s.fechaCuelgue";
			String sql2 = "SELECT s FROM Despacho s WHERE s.fechaCuelgue BETWEEN :fechaD and :fechaH order by s.fechaCuelgue";
			TypedQuery<Despacho> query;
			if (stationCode != 0) {
			query = em.createQuery(sql, Despacho.class);
			query.setParameter("fechaD", fechaD);
			query.setParameter("fechaH", fechaH);
			query.setParameter("stationCode", stationCode);
			} else {
				query = em.createQuery(sql2, Despacho.class);
				query.setParameter("fechaD", fechaD);
				query.setParameter("fechaH", fechaH);
			}
			
			return query.getResultList();
		} catch (PersistenceException e) {
			throw new MonitorException("Error al intentar obtener el costo de alimentacion por ternera");
		}
	}

	
}
