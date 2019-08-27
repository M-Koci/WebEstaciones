package com.service.interfaces;

import java.util.List;

import javax.ejb.Local;

import com.exception.MonitorException;
import com.model.Estacion;
import com.model.SomW;

@Local
public interface SomWBeanLocal {
	public String createSomW(SomW somW) throws MonitorException;
	public String update(SomW somW) throws MonitorException;
	public void removeSom(String terminal) throws MonitorException;
	public SomW getSom(String terminal) throws MonitorException;
	public SomW getSomEstacion(Estacion idEstacion) throws MonitorException;
	public List<SomW> getAllSom() throws MonitorException;
}
