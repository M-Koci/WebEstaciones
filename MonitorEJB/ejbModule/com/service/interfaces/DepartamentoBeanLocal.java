package com.service.interfaces;

import java.util.List;

import javax.ejb.Local;

import com.exception.MonitorException;
import com.model.Departamento;

@Local
public interface DepartamentoBeanLocal {
	public Departamento create(Departamento departamento) throws MonitorException;
	public Departamento update(Departamento departamento) throws MonitorException;
	public void remove (Long idDepartamento) throws MonitorException;
	public Departamento getDepartamento(Long idDepartamento) throws MonitorException;
	public List<Departamento> getAllDepartamentos() throws MonitorException;
}
