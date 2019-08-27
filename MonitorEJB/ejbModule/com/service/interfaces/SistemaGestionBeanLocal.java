package com.service.interfaces;

import java.util.List;

import javax.ejb.Local;

import com.exception.MonitorException;
import com.model.SistemaGestion;

@Local
public interface SistemaGestionBeanLocal {
	public Long createSG(SistemaGestion sistemaGestion) throws MonitorException;
	public Long update(SistemaGestion sistemaGestion) throws MonitorException;
	public void removeSG (Long idSG) throws MonitorException;
	public SistemaGestion getSG(Long idSG) throws MonitorException;
	public SistemaGestion getSGNombre(String nomSG) throws MonitorException;
	public List<SistemaGestion> getAllSG() throws MonitorException;
}
