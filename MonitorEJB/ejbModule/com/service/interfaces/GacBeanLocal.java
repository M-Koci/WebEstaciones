package com.service.interfaces;

import java.util.List;
import javax.ejb.Local;
import com.exception.MonitorException;
import com.model.Estacion;
import com.model.Gac;

@Local
public interface GacBeanLocal {
	public Long createGac(Gac gac) throws MonitorException;
	public Long update(Gac gac) throws MonitorException;
	public void removeGac(Long idGac) throws MonitorException;
	public 	Gac getGac(Long idGac) throws MonitorException;
	public 	Gac getGacEstacion(Estacion estacion) throws MonitorException;
	public 	List<Gac> getAllGac() throws MonitorException;
}
