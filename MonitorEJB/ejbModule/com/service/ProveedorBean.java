package com.service;

import com.exception.MonitorException;
import com.model.Proveedor;
import com.service.interfaces.ProveedorBeanLocal;

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
public class ProveedorBean implements ProveedorBeanLocal {
	
	@PersistenceContext
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public ProveedorBean() {}
    
    @Override
	public Long createProveedor(Proveedor proveedor) throws MonitorException {
		try {
			em.persist(proveedor);
			em.flush();
			return proveedor.getIdProveedor();
		} catch (PersistenceException e) {
			throw new MonitorException("Ha ocurrido un error al dar de alta una localidad");
		}
	}

	@Override
	public Long update(Proveedor proveedor) throws MonitorException {
		try {
			em.merge(proveedor);
			em.flush();
			return proveedor.getIdProveedor();
		} catch (PersistenceException e) {
			throw new MonitorException("Error al actualizar la ternera");
		}
	}

	@Override
	public void removeProveedor(Long idProveedor) throws MonitorException {
		try {
			Proveedor proveedor = em.find(Proveedor.class, idProveedor);
			em.remove(proveedor);
			em.flush();
		} catch (PersistenceException e) {
			throw new MonitorException("Ha ocurrido un error al borrar una localidad");
		}	}

	@Override
	public Proveedor getProveedor(Long idProveedor) throws MonitorException {
		try {
			return em.find(Proveedor.class, idProveedor);
		}  catch (PersistenceException e) {
			throw new MonitorException("Ha ocurrido un error al buscar una localidad");
		}
	}
	
	@Override
	public Proveedor getProveedorNombre(String nomProveedor) throws MonitorException {
		String sql = "SELECT p FROM Proveedor p WHERE p.nombre = :nombre";
		try {
			TypedQuery<Proveedor> query = em.createQuery(sql, Proveedor.class);
			query.setParameter("nombre", nomProveedor);
			return query.getSingleResult();
		} catch (PersistenceException e) {
			throw new MonitorException("No existe la localidad con el nombre " + nomProveedor);
		}
		
	}

	@Override
	public List<Proveedor> getAllProveedores() throws MonitorException {
		try {
			TypedQuery<Proveedor> query = em.createQuery("SELECT p FROM Proveedor p ORDER BY p.idProveedor", Proveedor.class);
			return query.getResultList();
		} catch (PersistenceException e) {
			throw new MonitorException("Error al intentar recuperar todos los proveedores");
		}
	}

}
