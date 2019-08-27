package com.service.interfaces;

import java.util.List;

import javax.ejb.Local;

import com.exception.MonitorException;
import com.model.Proveedor;

@Local
public interface ProveedorBeanLocal {
	public Long createProveedor(Proveedor proveedor) throws MonitorException;
	public Long update(Proveedor proveedor) throws MonitorException;
	public void removeProveedor (Long idProveedor) throws MonitorException;
	public Proveedor getProveedor(Long idProveedor) throws MonitorException;
	public Proveedor getProveedorNombre(String nomProveedor) throws MonitorException;
	public List<Proveedor> getAllProveedores() throws MonitorException;
	
}
