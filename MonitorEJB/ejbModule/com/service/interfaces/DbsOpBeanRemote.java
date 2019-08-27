package com.service.interfaces;

import java.util.List;

import javax.ejb.Remote;

import com.enums.Perfil;
import com.exception.MonitorException;
import com.model.Bcp;
import com.model.Contacto;
import com.model.ContactoEmail;
import com.model.ContactoRelacion;
import com.model.ContactoTelefono;
import com.model.Controladora;
import com.model.Departamento;
import com.model.Estacion;
import com.model.Gac;
import com.model.Localidad;
import com.model.Proveedor;
import com.model.Ptpos;
import com.model.SistemaGestion;
import com.model.Smcc;
import com.model.SomW;
import com.model.Usuario;

@Remote
public interface DbsOpBeanRemote {
	/* ---------- USUARIOS ---------- */
	public Integer addUsuario(Usuario usuario) throws MonitorException;
	public void delUsuario(Integer id) throws MonitorException;
	public Usuario getUsuario(Integer id) throws MonitorException;
	public Usuario getUsuario(String usuario) throws MonitorException;
	public long updateUsuario(Usuario usuario) throws MonitorException;
	public List<Usuario> getAll() throws MonitorException;
	public List<Usuario> getAllByUser(String usuario) throws MonitorException;
	public boolean validarUsuario(String usuario,String password) throws MonitorException;
	public Usuario iniciarSesion(String usuario, String password) throws MonitorException;
	public long desactivarUsuario(Usuario usuario) throws MonitorException;
	public Perfil[] getAllTipoPerfil() throws MonitorException;
	public List<Usuario> getAllUsuarios() throws MonitorException;
	public Usuario getStationCode(Usuario usuario) throws MonitorException;
	
	/* ---------- DEPARTAMENTOS ---------- */
	public Departamento create(Departamento departamento) throws MonitorException;
	public Departamento update(Departamento departamento) throws MonitorException;
	public void remove (Long idDepartamento) throws MonitorException;
	public Departamento getDepartamento(Long idDepartamento) throws MonitorException;
	public List<Departamento> getAllDepartamentos() throws MonitorException;
	
	/* ---------- Localidades ---------- */
	public Long createLocalidad(Localidad localidad) throws MonitorException;
	public Long update(Localidad localidad) throws MonitorException;
	public void removeLocalidad (Long idlocalidad) throws MonitorException;
	public Localidad getLocalidad(Long idlocalidad) throws MonitorException;
	public Localidad getLocalidadNombre(String nomLocalidad) throws MonitorException;
	public List<Localidad> getAllLocalidades() throws MonitorException;
	
	/* ---------- Proveedores ---------- */
	public Long createProveedor(Proveedor proveedor) throws MonitorException;
	public Long update(Proveedor proveedor) throws MonitorException;
	public void removeProveedor (Long idProveedor) throws MonitorException;
	public Proveedor getProveedor(Long idProveedor) throws MonitorException;
	public Proveedor getProveedorNombre(String nomProveedor) throws MonitorException;
	public List<Proveedor> getAllProveedores() throws MonitorException;
	
	/* ---------- Sistemas de Gestion ---------- */
	public Long createSG(SistemaGestion sistemaGestion) throws MonitorException;
	public Long update(SistemaGestion sistemaGestion) throws MonitorException;
	public void removeSG (Long idSG) throws MonitorException;
	public SistemaGestion getSG(Long idSG) throws MonitorException;
	public SistemaGestion getSGNombre(String nomSG) throws MonitorException;
	public List<SistemaGestion> getAllSG() throws MonitorException;
	
	/* ---------- Controladoras ---------- */
	public Long createControladora(Controladora controladora) throws MonitorException;
	public Long update(Controladora controladora) throws MonitorException;
	public void removeControladora(Long idControladora) throws MonitorException;
	public Controladora getControladora(Long idControladora) throws MonitorException;
	public Controladora getControladoraNombre(String nomControladora) throws MonitorException;
	public List<Controladora> getAllControladora() throws MonitorException;
	
	/* ---------- Estaciones ---------- */
	public Long createEstacion(Estacion estacion) throws MonitorException;
	public Long update(Estacion estacion) throws MonitorException;
	public void removeEstacion(Long idEstacion) throws MonitorException;
	public Estacion getEstacion(Long idEstacion) throws MonitorException;
	public Estacion getEstacionNombre(String nomEstacion) throws MonitorException;
	public List<Estacion> getAllEstaciones() throws MonitorException;
	
	
	/* ---------- SOM-W ---------- */
	public String createSomW(SomW somW) throws MonitorException;
	public String update(SomW somW) throws MonitorException;
	public void removeSom(String terminal) throws MonitorException;
	public SomW getSom(String terminal) throws MonitorException;
	public SomW getSomEstacion(Estacion idEstacion) throws MonitorException;
	public List<SomW> getAllSom() throws MonitorException;
	
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
	
	
	/*-------------PTPOS--------------*/
	public String createPtpos(Ptpos ptpos) throws MonitorException;
	public String update(Ptpos ptpos) throws MonitorException;
	public void removePtpos(String terminal) throws MonitorException;
	public Ptpos getPtpos(String terminal) throws MonitorException;
	public List<Ptpos> getPtposEstacion(Estacion idEstacion) throws MonitorException;
	public List<Ptpos> getAllPtpos() throws MonitorException;
	
	
	/*-------------GAC--------------*/
	public Long createGac(Gac gac) throws MonitorException;
	public Long update(Gac gac) throws MonitorException;
	public void removeGac(Long idGac) throws MonitorException;
	public 	Gac getGac(Long idGac) throws MonitorException;
	public 	Gac getGacEstacion(Estacion estacion) throws MonitorException;
	public 	List<Gac> getAllGac() throws MonitorException;
}
