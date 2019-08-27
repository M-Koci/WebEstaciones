package com.service.interfaces;

import java.util.List;

import javax.ejb.Local;

import com.exception.MonitorException;
import com.model.Estacion;

@Local
public interface EstacionBeanLocal {
	public Long createEstacion(Estacion estacion) throws MonitorException;
	public Long update(Estacion estacion) throws MonitorException;
	public void removeEstacion(Long idEstacion) throws MonitorException;
	public Estacion getEstacion(Long idEstacion) throws MonitorException;
	public Estacion getEstacionNombre(String nomEstacion) throws MonitorException;
	public List<Estacion> getAllEstaciones() throws MonitorException;
}
