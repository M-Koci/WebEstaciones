package com.service;

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
import com.service.interfaces.ContactoBeanLocal;
import com.service.interfaces.ControladoraBeanLocal;
import com.service.interfaces.DbsOpBeanLocal;
import com.service.interfaces.DbsOpBeanRemote;
import com.service.interfaces.DepartamentoBeanLocal;
import com.service.interfaces.EstacionBeanLocal;
import com.service.interfaces.GacBeanLocal;
import com.service.interfaces.LocalidadBeanLocal;
import com.service.interfaces.ProveedorBeanLocal;
import com.service.interfaces.PtposBeanLocal;
import com.service.interfaces.SistemaGestionBeanLocal;
import com.service.interfaces.SomWBeanLocal;
import com.service.interfaces.UsuarioBeanLocal;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class DbsOpBean
 */
@Stateless
public class DbsOpBean implements DbsOpBeanRemote, DbsOpBeanLocal {

	@EJB
	private UsuarioBeanLocal usuarioBean;
	
	@EJB
	private DepartamentoBeanLocal departamentoBean;
	
	@EJB
	private LocalidadBeanLocal localidadBean;
	
	@EJB
	private ProveedorBeanLocal proveedorBean;
	
	@EJB
	private SistemaGestionBeanLocal sgBean;
	
	@EJB
	private ControladoraBeanLocal controladoraBean;
	
	@EJB
	private EstacionBeanLocal estacionBean;
	
	@EJB
	private SomWBeanLocal somBean;
	
	@EJB
	private ContactoBeanLocal contactoBean;
	
	@EJB
	private PtposBeanLocal ptposBean;
	
	@EJB
	private GacBeanLocal gacBean;
	
	public DbsOpBean() {
    }
	
	
	/* ----------------- USUARIOS ----------------- */
	@Override
	public Integer addUsuario(Usuario usuario) throws MonitorException {
		return usuarioBean.addUsuario(usuario);
	}

	@Override
	public void delUsuario(Integer id) throws MonitorException {
		usuarioBean.delUsuario(id);
	}

	@Override
	public Usuario getUsuario(Integer id) throws MonitorException {
		return usuarioBean.getUsuario(id);
	}

	@Override
	public Usuario getUsuario(String usuario) throws MonitorException {
		return usuarioBean.getUsuario(usuario);
	}
	
	@Override
	public long updateUsuario(Usuario usuario) throws MonitorException {
		return usuarioBean.updateUsuario(usuario);
	}

	@Override
	public List<Usuario> getAll() throws MonitorException {
		return usuarioBean.getAll();
	}

	@Override
	public List<Usuario> getAllByUser(String usuario) throws MonitorException {
		return usuarioBean.getAllByUser(usuario);
	}

	@Override
	public boolean validarUsuario(String usuario, String password) throws MonitorException {
		return usuarioBean.validarUsuario(usuario, password);
	}

	@Override
	public Usuario iniciarSesion(String usuario, String password) throws MonitorException {
		return usuarioBean.iniciarSesion(usuario, password);
	}
	
	@Override
	public Usuario getStationCode(Usuario usuario) throws MonitorException {
		return usuarioBean.getStationCode(usuario.getIdUsuario());
	}

	@Override
	public long desactivarUsuario(Usuario usuario) throws MonitorException {
		return usuarioBean.desactivarUsuario(usuario);
	}
	
	@Override
	public List<Usuario> getAllUsuarios() throws MonitorException {
		return usuarioBean.getAll();
	}
	
	@Override
	public Perfil[] getAllTipoPerfil() throws MonitorException {
		return Perfil.values();
	}
	
	
	
	
	/* ----------------- DEPARTAMENTOS ----------------- */
	@Override
	public Departamento create(Departamento departamento) throws MonitorException {
		return departamentoBean.create(departamento);
	}
	@Override
	public Departamento update(Departamento departamento) throws MonitorException{
		return departamentoBean.update(departamento);
	}
	@Override
	public void remove(Long idDepartamento) throws MonitorException{
		departamentoBean.remove(idDepartamento);
	}
	@Override
	public Departamento getDepartamento(Long idDepartamento) throws MonitorException{
		return departamentoBean.getDepartamento(idDepartamento);
	}
	@Override
	public List<Departamento> getAllDepartamentos() throws MonitorException {
		return departamentoBean.getAllDepartamentos();
	}
	
	
	

	/* ----------------- LOCALIDADES ----------------- */
	@Override
	public Long createLocalidad(Localidad localidad) throws MonitorException {
		return localidadBean.createLocalidad(localidad);
	}
	@Override
	public Long update(Localidad localidad) throws MonitorException {
		return localidadBean.update(localidad);
	}
	@Override
	public void removeLocalidad(Long idlocalidad) throws MonitorException {
			localidadBean.removeLocalidad(idlocalidad);
	}
	@Override
	public Localidad getLocalidad(Long idlocalidad) throws MonitorException {
		return localidadBean.getLocalidad(idlocalidad);
	}
	@Override
	public Localidad getLocalidadNombre(String nomLocalidad) throws MonitorException {
		return localidadBean.getLocalidadNombre(nomLocalidad);
	}
	@Override
	public List<Localidad> getAllLocalidades() throws MonitorException {
		return localidadBean.getAllLocalidades();
	}


	
	
	/* ----------------- PROVEEDORES ----------------- */
	@Override
	public Long createProveedor(Proveedor proveedor) throws MonitorException {
		return proveedorBean.createProveedor(proveedor);
	}

	@Override
	public Long update(Proveedor proveedor) throws MonitorException {
		return proveedorBean.update(proveedor);
	}

	@Override
	public void removeProveedor(Long idProveedor) throws MonitorException {
			proveedorBean.removeProveedor(idProveedor);
	}

	@Override
	public Proveedor getProveedor(Long idProveedor) throws MonitorException {
		return proveedorBean.getProveedor(idProveedor);
	}

	@Override
	public Proveedor getProveedorNombre(String nomProveedor) throws MonitorException {
		return proveedorBean.getProveedorNombre(nomProveedor);
	}

	@Override
	public List<Proveedor> getAllProveedores() throws MonitorException {
		return proveedorBean.getAllProveedores();
	}

	
	
	
	/* ----------------- SISTEMAS DE GESTION ----------------- */
	@Override
	public Long createSG(SistemaGestion sistemaGestion) throws MonitorException {
		return sgBean.createSG(sistemaGestion);
	}

	@Override
	public Long update(SistemaGestion sistemaGestion) throws MonitorException {
		return sgBean.update(sistemaGestion);
	}

	@Override
	public void removeSG(Long idSG) throws MonitorException {
		sgBean.removeSG(idSG);
	}

	@Override
	public SistemaGestion getSG(Long idSG) throws MonitorException {
		return sgBean.getSG(idSG);
	}

	@Override
	public SistemaGestion getSGNombre(String nomSG) throws MonitorException {
		return sgBean.getSGNombre(nomSG);
	}

	@Override
	public List<SistemaGestion> getAllSG() throws MonitorException {
		return sgBean.getAllSG();
	}
	
	
	
	
	/* ----------------- CONTROLADORAS ----------------- */
	@Override
	public Long createControladora(Controladora controladora) throws MonitorException {
		return controladoraBean.createControladora(controladora);
	}

	@Override
	public Long update(Controladora controladora) throws MonitorException {
		return controladoraBean.update(controladora);
	}

	@Override
	public void removeControladora(Long idControladora) throws MonitorException {
		controladoraBean.removeControladora(idControladora);
	}

	@Override
	public Controladora getControladora(Long idControladora) throws MonitorException {
		return controladoraBean.getControladora(idControladora);
	}

	@Override
	public Controladora getControladoraNombre(String nomControladora) throws MonitorException {
		return controladoraBean.getControladoraNombre(nomControladora);
	}

	@Override
	public List<Controladora> getAllControladora() throws MonitorException {
		return controladoraBean.getAllControladora();
	}
	
	
	
	
	/* ----------------- ESTACIONES ----------------- */
	@Override
	public Long createEstacion(Estacion estacion) throws MonitorException {
		return estacionBean.createEstacion(estacion);
	}

	@Override
	public Long update(Estacion estacion) throws MonitorException {
		return estacionBean.update(estacion);
	}

	@Override
	public void removeEstacion(Long idEstacion) throws MonitorException {
		estacionBean.removeEstacion(idEstacion);
	}

	@Override
	public Estacion getEstacion(Long idEstacion) throws MonitorException {
		return estacionBean.getEstacion(idEstacion);
	}

	@Override
	public Estacion getEstacionNombre(String nomEstacion) throws MonitorException {
		return estacionBean.getEstacionNombre(nomEstacion);
	}

	@Override
	public List<Estacion> getAllEstaciones() throws MonitorException {
		return estacionBean.getAllEstaciones();
	}
	
	
	/* ---------- SOM-W ---------- */
	@Override
	public String createSomW(SomW somW) throws MonitorException{
		return somBean.createSomW(somW);
	}
	
	@Override
	public String update(SomW somW) throws MonitorException{
		return somBean.update(somW);
	}
	
	@Override
	public void removeSom(String terminal) throws MonitorException{
		somBean.removeSom(terminal);
	}
	
	@Override
	public SomW getSom(String terminal) throws MonitorException{
		return somBean.getSom(terminal);
	}
	
	@Override
	public SomW getSomEstacion(Estacion idEstacion) throws MonitorException{
		return somBean.getSomEstacion(idEstacion);
	}
	
	@Override
	public List<SomW> getAllSom() throws MonitorException{
		return somBean.getAllSom();
	}

	
	
	
	
	/*-------------CONTACTO--------------*/
	@Override
	public Long addContacto(Contacto contacto) throws MonitorException {
		return contactoBean.addContacto(contacto);
	}

	@Override
	public void delContacto(Long id) throws MonitorException {
		contactoBean.delContacto(id);
	}

	@Override
	public Contacto getContacto(Long id) throws MonitorException {
		return contactoBean.getContacto(id);
	}


	@Override
	public Contacto getContactoNom(String nombre) throws MonitorException {
		return contactoBean.getContactoNom(nombre);
	}
	
	@Override
	public Contacto getContactoApe(String apellido) throws MonitorException {
		return contactoBean.getContactoApe(apellido);
	}
	
	@Override
	public List<Contacto> getAllContacto() throws MonitorException {
		return contactoBean.getAllContacto();
	}

	@Override
	public long updateContacto(Contacto contacto) throws MonitorException {
		return contactoBean.updateContacto(contacto);
	}

	@Override
	public List<Contacto> getAllByName(String contacto) throws MonitorException {
		return contactoBean.getAllByName(contacto);
	}

	
	/*-------------TELEFONO--------------*/
	@Override
	public Long addTelContacto(ContactoTelefono telefono) throws MonitorException {
		return contactoBean.addTelContacto(telefono);
	}

	@Override
	public void delTelefono(Long id) throws MonitorException {
		contactoBean.delTelefono(id);
	}

	@Override
	public List<ContactoTelefono> getTelContacto(Contacto contacto) throws MonitorException {
		return contactoBean.getTelContacto(contacto);
	}

	@Override
	public long updateTelefono(ContactoTelefono telefono) throws MonitorException {
		return contactoBean.updateTelefono(telefono);
	}

	@Override
	public List<ContactoTelefono> getAllTelefonos() throws MonitorException {
		return contactoBean.getAllTelefonos();
	}
	
	
	/*-------------EMAIL--------------*/
	@Override
	public Long addEmail(ContactoEmail email) throws MonitorException {
		return contactoBean.addEmail(email);
	}

	@Override
	public void delEmail(Long id) throws MonitorException {
		contactoBean.delEmail(id);
	}

	@Override
	public List<ContactoEmail> getMailContacto(Contacto contacto) throws MonitorException {
		return contactoBean.getMailContacto(contacto);
	}

	@Override
	public long updateEmail(ContactoEmail mail) throws MonitorException {
		return contactoBean.updateEmail(mail);
	}
	
	@Override
	public List<ContactoEmail> getAllEmails() throws MonitorException {
		return contactoBean.getAllEmails();
	}

	
	
	
	/*-------------RELACION--------------*/
	@Override
	public Long addRelacion(ContactoRelacion relacion) throws MonitorException {
		return contactoBean.addRelacion(relacion);
	}

	@Override
	public void delRelacion(Long id) throws MonitorException {
		contactoBean.delRelacion(id);
	}

	@Override
	public ContactoRelacion getEstacionContacto(Estacion estacion) throws MonitorException {
		return contactoBean.getEstacionContacto(estacion);
	}

	@Override
	public ContactoRelacion getBcpContacto(Bcp bcp) throws MonitorException {
		return contactoBean.getBcpContacto(bcp);
	}


	@Override
	public long updateRelacion(ContactoRelacion relacion) throws MonitorException {
		return contactoBean.updateRelacion(relacion);
	}

	@Override
	public ContactoRelacion getSmccContacto(Smcc smcc) throws MonitorException {
		return contactoBean.getSmccContacto(smcc);
	}

	@Override
	public List<ContactoRelacion> getAllRelaciones() throws MonitorException {
		return contactoBean.getAllRelaciones();
	}


	
	
	
	/* ---------- PTPOS ---------- */
	@Override
	public String createPtpos(Ptpos ptpos) throws MonitorException {
		return ptposBean.createPtpos(ptpos);
	}

	@Override
	public String update(Ptpos ptpos) throws MonitorException {
		return ptposBean.update(ptpos);
	}

	@Override
	public void removePtpos(String terminal) throws MonitorException {
		ptposBean.removePtpos(terminal);
	}

	@Override
	public Ptpos getPtpos(String terminal) throws MonitorException {
		return ptposBean.getPtpos(terminal);
	}

	@Override
	public List<Ptpos> getPtposEstacion(Estacion idEstacion) throws MonitorException {
		return ptposBean.getPtposEstacion(idEstacion);
	}

	@Override
	public List<Ptpos> getAllPtpos() throws MonitorException {
		return ptposBean.getAllPtpos();
	}


	
	
	/* ---------- GAC ---------- */
	@Override
	public Long createGac(Gac gac) throws MonitorException {
		return gacBean.createGac(gac);
	}

	@Override
	public Long update(Gac gac) throws MonitorException {
		return gacBean.update(gac);
	}

	@Override
	public void removeGac(Long idGac) throws MonitorException {
		gacBean.removeGac(idGac);
	}

	@Override
	public Gac getGac(Long idGac) throws MonitorException {
		return gacBean.getGac(idGac);
	}

	@Override
	public Gac getGacEstacion(Estacion estacion) throws MonitorException {
		return gacBean.getGacEstacion(estacion);
	}


	@Override
	public List<Gac> getAllGac() throws MonitorException {
		return gacBean.getAllGac();
	}

}
