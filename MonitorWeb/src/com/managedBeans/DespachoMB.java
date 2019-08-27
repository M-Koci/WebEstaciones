package com.managedBeans;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.exception.MonitorException;
import com.model.Despacho;
import com.model.Usuario;
import com.service.interfaces.DespachoBeanRemote;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Named
@ManagedBean
@ViewScoped
public class DespachoMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private DespachoBeanRemote despachoBean;

	public DespachoMB() {
	}

	private Integer id;
	private Integer ptnet;
	private Integer stationCode;
	private Integer manguera;
	private Integer autorizador;
	private Date fechaDescuelgue;
	private Date fechaCuelgue;
	private Date fechaDesde;
	private Date fechaHasta;
	private Double importe;
	private Double precioUnitario;
	private double litros;
	private Despacho despacho;
	private List<Despacho> despachos;
	private Usuario us;
	
//	@PostConstruct
//    public void init(){
//        stationCode = 0;
//    }

	public List<Despacho> listarDespachos() throws MonitorException{
		if(despacho == null) {
			despachos = despachoBean.getAllDespachos();
		}
		return despachos;
	}
	
	public List<Despacho> getDespachoFechas(Date fechaD, Date fechaH) throws MonitorException{

		fechaD = this.fechaDesde;
		fechaH = this.fechaHasta;
		
		us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
		System.out.println("hola" + us);
		this.despachos = despachoBean.getDespachoFechas(fechaD, fechaH, us.getIdUsuario());
		return despachos;
	}
	
	public List<Despacho> getDespachoAdmin(Date fechaD, Date fechaH, Integer id) throws MonitorException{

		fechaD = this.fechaDesde;
		fechaH = this.fechaHasta;
		if (this.stationCode == null) {
			id = 0;
			despachos = despachoBean.getDespachoFechas(fechaD, fechaH, id);
		} else {
			id = this.stationCode; 
			despachos = despachoBean.getDespachoFechas(fechaD, fechaH, id);
		}
		
		return despachos;
	}



	//----------------Getters y Setters--------------//
	public DespachoBeanRemote getDespachoBean() {
		return despachoBean;
	}
	public void setDespachoBean(DespachoBeanRemote despachoBean) {
		this.despachoBean = despachoBean;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPtnet() {
		return ptnet;
	}
	public void setPtnet(Integer ptnet) {
		this.ptnet = ptnet;
	}

	public Integer getStationCode() {
		return stationCode;
	}

	public void setStationCode(Integer stationCode) {
		this.stationCode = stationCode;
	}

	public Integer getManguera() {
		return manguera;
	}
	public void setManguera(Integer manguera) {
		this.manguera = manguera;
	}
	public Date getFechaDescuelgue() {
		return fechaDescuelgue;
	}
	public void setFechaDescuelgue(Date fechaDescuelgue) {
		this.fechaDescuelgue = fechaDescuelgue;
	}
	public Date getFechaCuelgue() {
		return fechaCuelgue;
	}
	public void setFechaCuelgue(Date fechaCuelgue) {
		this.fechaCuelgue = fechaCuelgue;
	}
	public Date getFechaDesde() {
		return fechaDesde;
	}

	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public Date getFechaHasta() {
		return fechaHasta;
	}

	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	public Double getImporte() {
		return importe;
	}
	public void setImporte(Double importe) {
		this.importe = importe;
	}
	public Double getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public double getLitros() {
		return litros;
	}
	public void setLitros(double litros) {
		this.litros = litros;
	}
	public Despacho getDespacho() {
		return despacho;
	}
	public void setDespacho(Despacho despacho) {
		this.despacho = despacho;
	}
	public List<Despacho> getDespachos() {
		return despachos;
	}
	public void setDespachos(List<Despacho> despachos) {
		this.despachos = despachos;
	}

	public Integer getAutorizador() {
		return autorizador;
	}

	public void setAutorizador(Integer autorizador) {
		this.autorizador = autorizador;
	}
	

}
