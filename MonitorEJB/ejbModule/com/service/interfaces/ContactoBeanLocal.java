package com.service.interfaces;

import java.util.List;

import com.exception.MonitorException;
import com.model.Bcp;
import com.model.Contacto;
import com.model.ContactoEmail;
import com.model.ContactoRelacion;
import com.model.ContactoTelefono;
import com.model.Estacion;
import com.model.Smcc;

public interface ContactoBeanLocal {

	/*-------------CONTACTO--------------*/
	public Long addContacto(Contacto contacto) throws MonitorException;
	public void delContacto(Long id) throws MonitorException;
	public Contacto getContacto(Long id) throws MonitorException;
	public Contacto getContactoNom(String nombre) throws MonitorException;
	public Contacto getContactoApe(String apellido) throws MonitorException;
	public long updateContacto(Contacto contacto) throws MonitorException;
	public List<Contacto> getAllContacto() throws MonitorException;
	public List<Contacto> getAllByName(String contacto) throws MonitorException;

	/*-------------TELEFONO--------------*/
	public Long addTelContacto(ContactoTelefono telefono) throws MonitorException;
	public void delTelefono(Long id) throws MonitorException;
	public List<ContactoTelefono> getTelContacto(Contacto contacto) throws MonitorException;
	public long updateTelefono(ContactoTelefono telefono) throws MonitorException;
	public List<ContactoTelefono> getAllTelefonos() throws MonitorException;

	/*-------------CORREO--------------*/
	public Long addEmail(ContactoEmail email) throws MonitorException;
	public void delEmail(Long id) throws MonitorException;
	public List<ContactoEmail> getMailContacto(Contacto contacto) throws MonitorException;
	public long updateEmail(ContactoEmail mail) throws MonitorException;
	public List<ContactoEmail> getAllEmails() throws MonitorException;
	
	/*-------------CONTACTO RELACION--------------*/
	public Long addRelacion(ContactoRelacion relacion) throws MonitorException;
	public void delRelacion(Long id) throws MonitorException;
	public ContactoRelacion getEstacionContacto(Estacion estacion) throws MonitorException;
	public ContactoRelacion getBcpContacto(Bcp bcp) throws MonitorException;
	public long updateRelacion(ContactoRelacion relacion) throws MonitorException;
	public ContactoRelacion getSmccContacto(Smcc smcc) throws MonitorException;
	public List<ContactoRelacion> getAllRelaciones() throws MonitorException;

}
