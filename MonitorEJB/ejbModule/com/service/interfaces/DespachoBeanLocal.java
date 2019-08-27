package com.service.interfaces;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.exception.MonitorException;
import com.model.Despacho;

@Local
public interface DespachoBeanLocal {
	
	public Integer addDespacho(Despacho despacho) throws MonitorException;
	
	public List<Despacho> getAllDespachos() throws MonitorException;

	public List<Despacho> getDespachoFechas(Date fechaD, Date fechaH, Integer stationCode) throws MonitorException;

}
