package com.service;

import com.exception.MonitorException;
import com.model.Departamento;
import com.service.interfaces.DepartamentoBeanLocal;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

/**
 * Session Bean implementation class DepartamentoBean
 */
@Stateless
public class DepartamentoBean implements DepartamentoBeanLocal {
	
	@PersistenceContext
	private EntityManager em;

    /**
     * Default constructor. 
     */
    public DepartamentoBean() {
    }

	@Override
	public Departamento create(Departamento departamento) throws MonitorException {
		em.persist(departamento);
		return departamento;
	}

	@Override
	public Departamento update(Departamento departamento) throws MonitorException {
		em.merge(departamento);
		return departamento;
	}

	@Override
	public void remove(Long idDepartamento) throws MonitorException {
		em.remove(getDepartamento(idDepartamento));
	}

	@Override
	public Departamento getDepartamento(Long idDepartamento) throws MonitorException {
		return em.find(Departamento.class, idDepartamento);
	}

	@Override
	public List<Departamento> getAllDepartamentos() throws MonitorException {
		try {
			TypedQuery<Departamento> query = em.createQuery("SELECT d FROM Departamento d",Departamento.class);
			return query.getResultList();
		}  catch (PersistenceException e) {
			throw new MonitorException("Error al intentar obtener los departamentos");
		}
	}

}
