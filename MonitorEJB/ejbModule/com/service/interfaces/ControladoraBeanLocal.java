package com.service.interfaces;

import java.util.List;

import javax.ejb.Local;

import com.exception.MonitorException;
import com.model.Controladora;

@Local
public interface ControladoraBeanLocal {

	public Long createControladora(Controladora controladora) throws MonitorException;
	public Long update(Controladora controladora) throws MonitorException;
	public void removeControladora(Long idControladora) throws MonitorException;
	public Controladora getControladora(Long idControladora) throws MonitorException;
	public Controladora getControladoraNombre(String nomControladora) throws MonitorException;
	public List<Controladora> getAllControladora() throws MonitorException;

}
