package com.service;

import com.exception.MonitorException;
import com.model.Bcp;
import com.model.Contacto;
import com.model.ContactoEmail;
import com.model.ContactoRelacion;
import com.model.ContactoTelefono;
import com.model.Estacion;
import com.model.Smcc;
import com.service.interfaces.ContactoBeanLocal;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;


/**
 * Session Bean implementation class UsuarioBean
 */
@Stateless
public class ContactoBean implements ContactoBeanLocal {
	
	@PersistenceContext
	EntityManager em;
	
    public ContactoBean() {
    }

    /*-------------CONTACTOS--------------*/
	@Override
	public Long addContacto(Contacto contacto) throws MonitorException {
		try {
			em.persist(contacto);
			em.flush();
			return contacto.getIdContacto();
		} catch (PersistenceException e) {
			throw new MonitorException("Error al crear contacto");
		}
	}
	
	@Override
	public void delContacto(Long id) throws MonitorException {
		try {
			Contacto contacto = em.find(Contacto.class, id);
			em.remove(contacto);
			em.flush();
		} catch (PersistenceException e) {
			throw new MonitorException("Error al borrar el contacto");
		}
	}

	@Override
	public Contacto getContacto(Long id) throws MonitorException {
		try {
			Contacto contacto = em.find(Contacto.class, id);
			return contacto;
		} catch (PersistenceException e) {
			throw new MonitorException("Error al traer un contacto");
		}
	}
	

	@Override
	public Contacto getContactoNom(String nombre) throws MonitorException {
		try {
			TypedQuery<Contacto> query = em.createQuery("SELECT c FROM Contacto c WHERE c.nombre = :nombre", Contacto.class)
					.setParameter("nombre", nombre);
			return query.getSingleResult();
		} catch (PersistenceException e) {
			throw new MonitorException("Error al buscar el contacto");
		}
	}
	
	@Override
	public Contacto getContactoApe(String apellido) throws MonitorException {
		try {
			TypedQuery<Contacto> query = em.createQuery("SELECT c FROM Contacto c WHERE c.apellido = :apellido", Contacto.class)
					.setParameter("apellido", apellido);
			return query.getSingleResult();
		} catch (PersistenceException e) {
			throw new MonitorException("Error al buscar el contacto");
		}
	}


	@Override
	public long updateContacto(Contacto contacto) throws MonitorException {
		try {
			em.merge(contacto);
			em.flush();
			return contacto.getIdContacto();
		} catch (PersistenceException e) {
			throw new MonitorException("Error al actualizar el contacto");
		}
	}

	@Override
	public List<Contacto> getAllContacto() throws MonitorException {
		try {
			TypedQuery<Contacto> query = em.createQuery("SELECT c FROM Contacto c", Contacto.class); 
			return query.getResultList();
		} catch (PersistenceException e) {
			throw new MonitorException("Error al obtener todos los contactos");
		}
	}

	@Override
	public List<Contacto> getAllByName(String contacto) throws MonitorException {
		try {
			TypedQuery<Contacto> query = em.createQuery("SELECT c FROM Contacto c WHERE c.nombre LIKE :nombre", Contacto.class);
			query.setParameter("nombre", contacto);
			return query.getResultList();
		} catch (PersistenceException e) {
			throw new MonitorException("Error al obtener todos los contactos por nombre");
		}
	}
	
	
	/*-------------CONTACTO RELACION--------------*/
	@Override
	public Long addRelacion(ContactoRelacion relacion) throws MonitorException {
		try {
			em.persist(relacion);
			em.flush();
			return relacion.getIdRelacion();
		} catch (PersistenceException e) {
			throw new MonitorException("Error al crear la relacion");
		}
	}
	
	@Override
	public void delRelacion(Long id) throws MonitorException {
		try {
			ContactoRelacion relacion = em.find(ContactoRelacion.class, id);
			em.remove(relacion);
			em.flush();
		} catch (PersistenceException e) {
			throw new MonitorException("Error al borrar el email");
		}
	}
	
	@Override
	public ContactoRelacion getEstacionContacto(Estacion estacion) throws MonitorException {
		try {
			TypedQuery<ContactoRelacion> query = em.createQuery("SELECT c FROM ContactoRelacion c WHERE c.estacion = :estacion", ContactoRelacion.class)
					.setParameter("estacion", estacion);
			return query.getSingleResult();
		} catch (PersistenceException e) {
			throw new MonitorException("Error al buscar la estacion del contacto");
		}
	}
	
	@Override
	public ContactoRelacion getBcpContacto(Bcp bcp) throws MonitorException {
		try {
			TypedQuery<ContactoRelacion> query = em.createQuery("SELECT c FROM ContactoRelacion c WHERE c.idBcp = :bcp", ContactoRelacion.class)
					.setParameter("bcp", bcp);
			return query.getSingleResult();
		} catch (PersistenceException e) {
			throw new MonitorException("Error al buscar la estacion del contacto");
		}
	}
	
	@Override
	public ContactoRelacion getSmccContacto(Smcc smcc) throws MonitorException {
		try {
			TypedQuery<ContactoRelacion> query = em.createQuery("SELECT c FROM ContactoRelacion c WHERE c.idSmcc = :smcc", ContactoRelacion.class)
					.setParameter("smcc", smcc);
			return query.getSingleResult();
		} catch (PersistenceException e) {
			throw new MonitorException("Error al buscar el camion del contacto");
		}
	}
	
	@Override
	public long updateRelacion(ContactoRelacion relacion) throws MonitorException {
		try {
			em.merge(relacion);
			em.flush();
			return relacion.getIdRelacion();
		} catch (PersistenceException e) {
			throw new MonitorException("Error al actualizar la relacion");
		}
	}
	
	@Override
	public List<ContactoRelacion> getAllRelaciones() throws MonitorException {
		try {
			TypedQuery<ContactoRelacion> query = em.createQuery("SELECT c FROM ContactoRelacion c", ContactoRelacion.class); 
			return query.getResultList();
		} catch (PersistenceException e) {
			throw new MonitorException("Error al obtener todas las relaciones");
		}
	}
	
	
	
	
	
	
	/*-------------TELEFONO--------------*/
	@Override
	public Long addTelContacto(ContactoTelefono telefono) throws MonitorException {
		try {
			em.persist(telefono);
			em.flush();
			return telefono.getIdTelefono();
		} catch (PersistenceException e) {
			throw new MonitorException("Error al crear telefono");
		}
	}
	
	@Override
	public void delTelefono(Long id) throws MonitorException {
		try {
			ContactoTelefono telefono = em.find(ContactoTelefono.class, id);
			em.remove(telefono);
			em.flush();
		} catch (PersistenceException e) {
			throw new MonitorException("Error al borrar el telefono");
		}
	}
	
	@Override
	public List<ContactoTelefono> getTelContacto(Contacto contacto) throws MonitorException {
		try {
			TypedQuery<ContactoTelefono> query = em.createQuery("SELECT c FROM ContactoTelefono c WHERE c.contacto = :contacto", ContactoTelefono.class)
					.setParameter("contacto", contacto);
			return query.getResultList();
		} catch (PersistenceException e) {
			throw new MonitorException("Error al buscar el telefono del contacto");
		}
	}
	
	@Override
	public long updateTelefono(ContactoTelefono telefono) throws MonitorException {
		try {
			em.merge(telefono);
			em.flush();
			return telefono.getIdTelefono();
		} catch (PersistenceException e) {
			throw new MonitorException("Error al actualizar el contacto");
		}
	}
	
	@Override
	public List<ContactoTelefono> getAllTelefonos() throws MonitorException {
		try {
			TypedQuery<ContactoTelefono> query = em.createQuery("SELECT c FROM ContactoTelefono c", ContactoTelefono.class); 
			return query.getResultList();
		} catch (PersistenceException e) {
			throw new MonitorException("Error al obtener todos los telefonos");
		}
	}
	
	
	/*-------------CORREO--------------*/
	@Override
	public Long addEmail(ContactoEmail email) throws MonitorException {
		try {
			em.persist(email);
			em.flush();
			return email.getIdEmail();
		} catch (PersistenceException e) {
			throw new MonitorException("Error al crear email");
		}
	}
	
	@Override
	public void delEmail(Long id) throws MonitorException {
		try {
			ContactoEmail telefono = em.find(ContactoEmail.class, id);
			em.remove(telefono);
			em.flush();
		} catch (PersistenceException e) {
			throw new MonitorException("Error al borrar el email");
		}
	}
	
	@Override
	public List<ContactoEmail> getMailContacto(Contacto contacto) throws MonitorException {
		try {
			TypedQuery<ContactoEmail> query = em.createQuery("SELECT c FROM ContactoEmail c WHERE c.contacto = :contacto", ContactoEmail.class)
					.setParameter("contacto", contacto);
			return query.getResultList();
		} catch (PersistenceException e) {
			return null;
		}
	}
	
	@Override
	public long updateEmail(ContactoEmail mail) throws MonitorException {
		try {
			em.merge(mail);
			em.flush();
			return mail.getIdEmail();
		} catch (PersistenceException e) {
			throw new MonitorException("Error al actualizar el correo");
		}
	}
	
	@Override
	public List<ContactoEmail> getAllEmails() throws MonitorException {
		try {
			TypedQuery<ContactoEmail> query = em.createQuery("SELECT c FROM ContactoEmail c", ContactoEmail.class); 
			return query.getResultList();
		} catch (PersistenceException e) {
			throw new MonitorException("Error al obtener todos los telefonos");
		}
	}

}
