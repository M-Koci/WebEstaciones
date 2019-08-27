package com.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.CellEditEvent;

import javax.faces.context.FacesContext;

import com.exception.MonitorException;
import com.model.Bcp;
import com.model.Contacto;
import com.model.ContactoEmail;
import com.model.ContactoRelacion;
import com.model.ContactoTelefono;
import com.model.Estacion;
import com.model.Smcc;
import com.service.interfaces.DbsOpBeanRemote;

@ManagedBean
@ViewScoped
@Named
public class ContactoMB implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private DbsOpBeanRemote contactoBean;
	
	private Long id;
	private String nombre;
	private String apellido;
	private String telefono;
	private String email;
	private ContactoTelefono contactoTelefono;
	private ContactoEmail contactoEmail;
	private ContactoRelacion relacion;
	private Contacto contacto;
	private Smcc smcc;
	private Bcp bcp;
	private Estacion estacion;
	private List<Contacto> contactos;
	private List<ContactoTelefono> telefonos;
	private List<ContactoEmail> emails;
	private List<ContactoRelacion> relaciones;
	
	public ContactoMB() {
	}
	
	@PostConstruct
	public void init() {
		try {
			contactos = contactoBean.getAllContacto();
			telefonos = contactoBean.getAllTelefonos();
			emails = contactoBean.getAllEmails();
			relaciones = contactoBean.getAllRelaciones();
		} catch (MonitorException e) {
			e.printStackTrace();
		}
	}
	

	
	public void createContacto() throws MonitorException {
		try {
			contacto = new Contacto();
			contactoTelefono = new ContactoTelefono();
			contactoEmail = new ContactoEmail();
			contacto.setNombre(nombre);
			contacto.setApellido(apellido);
			contactoTelefono.setContacto(contacto);
			contactoTelefono.setTelefono(telefono);
			contactoEmail.setContacto(contactoTelefono.getContacto());
			contactoEmail.setEmail(email);
			if(existeContactoNom(contacto.getNombre()) != null && existeContactoApe(contacto.getApellido()) != null) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Ya existe un contacto con este nombre"));
			} else if (contactoEmail.getEmail().isEmpty()){
				contactoBean.addTelContacto(contactoTelefono);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Contacto Registrado"));
				//ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
//				try {
//					
//					ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
// 
//				} catch (IOException e) {
//					e.printStackTrace();
//					}
			} else {
				//contactoBean.addTelContacto(contactoTelefono);
				contactoBean.addEmail(contactoEmail);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Contacto Registrado"));
			}
			
		} catch (MonitorException e) {
			e.printStackTrace();
		}
	}
	
	
	public Contacto existeContactoNom(String nombre) throws MonitorException {
		try {
			return contactoBean.getContactoNom(nombre);
		} catch (MonitorException e) {
			return null;
		}
	}
	
	public Contacto existeContactoApe(String apellido) throws MonitorException {
		try {
			return contactoBean.getContactoApe(apellido);
		} catch (MonitorException e) {
			return null;
		}
	}
	
	public void leer(Contacto conSelected ) throws MonitorException {
		contacto = conSelected;
		emails = contactoBean.getMailContacto(contacto);
		telefonos = contactoBean.getTelContacto(contacto);
		
	}
	
	public void onCellEdit(CellEditEvent event) throws MonitorException {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
        contacto = (Contacto)((DataTable)event.getComponent()).getRowData();
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Datos cambiados", "Anterior: " + oldValue + ",\n Nuevo:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
            contactoBean.updateContacto(contacto);
        }
    }
	
	public void onCellEditTel(CellEditEvent event) throws MonitorException {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
        contactoTelefono = (ContactoTelefono)((DataTable)event.getComponent()).getRowData();
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Datos cambiados", " " + " " );
            FacesContext.getCurrentInstance().addMessage(null, msg);
            contactoBean.updateTelefono(contactoTelefono);
        }
    }
	
	public void onCellEditMail(CellEditEvent event) throws MonitorException {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
        contactoEmail = (ContactoEmail)((DataTable)event.getComponent()).getRowData();
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Datos cambiados", " " + " " );
            FacesContext.getCurrentInstance().addMessage(null, msg);
            contactoBean.updateEmail(contactoEmail);
        }
    }
	
	
	public void modificarContacto() {
		try {
			contactoBean.updateContacto(contacto);
		} catch (MonitorException e) {
			e.printStackTrace();
		}
	}
	
	public void obtenerCorreo(Contacto contacto) throws MonitorException {
		emails = contactoBean.getMailContacto(contacto);
	}
	
	public List<Contacto> listarContactos() {
		try {
			return contactoBean.getAllContacto();
		} catch (MonitorException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/*---------- Getters y Setters ----------*/
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Contacto getContacto() {
		return contacto;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}

	public Smcc getSmcc() {
		return smcc;
	}

	public void setSmcc(Smcc smcc) {
		this.smcc = smcc;
	}

	public Bcp getBcp() {
		return bcp;
	}

	public void setBcp(Bcp bcp) {
		this.bcp = bcp;
	}

	public Estacion getEstacion() {
		return estacion;
	}

	public void setEstacion(Estacion estacion) {
		this.estacion = estacion;
	}

	public List<Contacto> getContactos() {
		return contactos;
	}

	public void setContactos(List<Contacto> contactos) {
		this.contactos = contactos;
	}

	public List<ContactoTelefono> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(List<ContactoTelefono> telefonos) {
		this.telefonos = telefonos;
	}

	public List<ContactoEmail> getEmails() {
		return emails;
	}

	public void setEmails(List<ContactoEmail> emails) {
		this.emails = emails;
	}

	public List<ContactoRelacion> getRelaciones() {
		return relaciones;
	}

	public void setRelaciones(List<ContactoRelacion> relaciones) {
		this.relaciones = relaciones;
	}

	public ContactoRelacion getRelacion() {
		return relacion;
	}

	public void setRelacion(ContactoRelacion relacion) {
		this.relacion = relacion;
	}

	public ContactoTelefono getContactoTelefono() {
		return contactoTelefono;
	}

	public void setContactoTelefono(ContactoTelefono contactoTelefono) {
		this.contactoTelefono = contactoTelefono;
	}

	public ContactoEmail getContactoEmail() {
		return contactoEmail;
	}

	public void setContactoEmail(ContactoEmail contactoEmail) {
		this.contactoEmail = contactoEmail;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
