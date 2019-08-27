package com.service.interfaces;

import java.util.List;

import javax.ejb.Local;

import com.exception.MonitorException;
import com.model.Usuario;

@Local
public interface UsuarioBeanLocal {
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
	public Usuario getStationCode(Integer stationCode) throws MonitorException;

	
}
