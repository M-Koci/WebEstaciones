package com.service.interfaces;

import java.util.List;

import javax.ejb.Local;

import com.exception.MonitorException;
import com.model.Estacion;
import com.model.Ptpos;

@Local
public interface PtposBeanLocal {
	public String createPtpos(Ptpos ptpos) throws MonitorException;
	public String update(Ptpos ptpos) throws MonitorException;
	public void removePtpos(String terminal) throws MonitorException;
	public Ptpos getPtpos(String terminal) throws MonitorException;
	public List<Ptpos> getPtposEstacion(Estacion idEstacion) throws MonitorException;
	public List<Ptpos> getAllPtpos() throws MonitorException;
}
