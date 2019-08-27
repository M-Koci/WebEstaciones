package com.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the proveedor database table.
 * 
 */
@Entity
@Table(name="proveedor")
@NamedQuery(name="Proveedor.findAll", query="SELECT p FROM Proveedor p")
public class Proveedor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idProveedor;

	private String nombre;

	private Long telefonoGuardia;

	//bi-directional many-to-one association to Controladora
	@OneToMany(mappedBy="proveedor")
	private List<Controladora> controladoras;

	//bi-directional many-to-one association to SistemaGestion
	@OneToMany(mappedBy="proveedor")
	private List<SistemaGestion> sistemaGestions;

	//bi-directional many-to-one association to SomW
	@OneToMany(mappedBy="proveedor1")
	private List<SomW> somWs1;

	//bi-directional many-to-one association to SomW
	@OneToMany(mappedBy="proveedor2")
	private List<SomW> somWs2;

	public Proveedor() {
	}

	public Long getIdProveedor() {
		return this.idProveedor;
	}

	public void setIdProveedor(Long idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getTelefonoGuardia() {
		return this.telefonoGuardia;
	}

	public void setTelefonoGuardia(Long telefonoGuardia) {
		this.telefonoGuardia = telefonoGuardia;
	}

	public List<Controladora> getControladoras() {
		return this.controladoras;
	}

	public void setControladoras(List<Controladora> controladoras) {
		this.controladoras = controladoras;
	}

	public Controladora addControladora(Controladora controladora) {
		getControladoras().add(controladora);
		controladora.setProveedor(this);

		return controladora;
	}

	public Controladora removeControladora(Controladora controladora) {
		getControladoras().remove(controladora);
		controladora.setProveedor(null);

		return controladora;
	}

	public List<SistemaGestion> getSistemaGestions() {
		return this.sistemaGestions;
	}

	public void setSistemaGestions(List<SistemaGestion> sistemaGestions) {
		this.sistemaGestions = sistemaGestions;
	}

	public SistemaGestion addSistemaGestion(SistemaGestion sistemaGestion) {
		getSistemaGestions().add(sistemaGestion);
		sistemaGestion.setProveedor(this);

		return sistemaGestion;
	}

	public SistemaGestion removeSistemaGestion(SistemaGestion sistemaGestion) {
		getSistemaGestions().remove(sistemaGestion);
		sistemaGestion.setProveedor(null);

		return sistemaGestion;
	}

	public List<SomW> getSomWs1() {
		return this.somWs1;
	}

	public void setSomWs1(List<SomW> somWs1) {
		this.somWs1 = somWs1;
	}

	public SomW addSomWs1(SomW somWs1) {
		getSomWs1().add(somWs1);
		somWs1.setProveedor1(this);

		return somWs1;
	}

	public SomW removeSomWs1(SomW somWs1) {
		getSomWs1().remove(somWs1);
		somWs1.setProveedor1(null);

		return somWs1;
	}

	public List<SomW> getSomWs2() {
		return this.somWs2;
	}

	public void setSomWs2(List<SomW> somWs2) {
		this.somWs2 = somWs2;
	}

	public SomW addSomWs2(SomW somWs2) {
		getSomWs2().add(somWs2);
		somWs2.setProveedor2(this);

		return somWs2;
	}

	public SomW removeSomWs2(SomW somWs2) {
		getSomWs2().remove(somWs2);
		somWs2.setProveedor2(null);

		return somWs2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idProveedor == null) ? 0 : idProveedor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Proveedor other = (Proveedor) obj;
		if (idProveedor == null) {
			if (other.idProveedor != null)
				return false;
		} else if (!idProveedor.equals(other.idProveedor))
			return false;
		return true;
	}

}