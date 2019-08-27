package com.service.interfaces;

import java.util.List;

import javax.ejb.Local;

import com.exception.MonitorException;
import com.model.Localidad;

@Local
public interface LocalidadBeanLocal {
	public Long createLocalidad(Localidad localidad) throws MonitorException;
	public Long update(Localidad localidad) throws MonitorException;
	public void removeLocalidad (Long idlocalidad) throws MonitorException;
	public Localidad getLocalidad(Long idlocalidad) throws MonitorException;
	public Localidad getLocalidadNombre(String nomLocalidad) throws MonitorException;
	public List<Localidad> getAllLocalidades() throws MonitorException;
}
