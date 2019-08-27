package com.service.interfaces;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import com.exception.MonitorException;
import com.model.Despacho;

@Remote
public interface DespachoBeanRemote {
	
	public Integer addDespacho(Despacho despacho) throws MonitorException;
	public List<Despacho> getAllDespachos() throws MonitorException;
	public List<Despacho> getDespachoFechas(Date fechaD, Date fechaH, Integer stationCode) throws MonitorException;
	
}
