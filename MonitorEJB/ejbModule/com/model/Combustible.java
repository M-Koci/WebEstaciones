package com.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the combustible database table.
 * 
 */
@Entity
@Table(name="combustible")
@NamedQuery(name="Combustible.findAll", query="SELECT c FROM Combustible c")
public class Combustible implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCombustible;

	private String nombre;

	private BigDecimal precio;

	//bi-directional many-to-many association to Bcp
	@ManyToMany(mappedBy="combustibles")
	private List<Bcp> bcps;

	//bi-directional many-to-one association to BcpCombustible
	@OneToMany(mappedBy="combustible")
	private List<BcpCombustible> bcpCombustibles;

	//bi-directional many-to-one association to EstacionCombustible
	@OneToMany(mappedBy="combustible")
	private List<EstacionCombustible> estacionCombustibles;

	public Combustible() {
	}

	public Long getIdCombustible() {
		return this.idCombustible;
	}

	public void setIdCombustible(Long idCombustible) {
		this.idCombustible = idCombustible;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public List<Bcp> getBcps() {
		return this.bcps;
	}

	public void setBcps(List<Bcp> bcps) {
		this.bcps = bcps;
	}

	public List<BcpCombustible> getBcpCombustibles() {
		return this.bcpCombustibles;
	}

	public void setBcpCombustibles(List<BcpCombustible> bcpCombustibles) {
		this.bcpCombustibles = bcpCombustibles;
	}

	public BcpCombustible addBcpCombustible(BcpCombustible bcpCombustible) {
		getBcpCombustibles().add(bcpCombustible);
		bcpCombustible.setCombustible(this);

		return bcpCombustible;
	}

	public BcpCombustible removeBcpCombustible(BcpCombustible bcpCombustible) {
		getBcpCombustibles().remove(bcpCombustible);
		bcpCombustible.setCombustible(null);

		return bcpCombustible;
	}

	public List<EstacionCombustible> getEstacionCombustibles() {
		return this.estacionCombustibles;
	}

	public void setEstacionCombustibles(List<EstacionCombustible> estacionCombustibles) {
		this.estacionCombustibles = estacionCombustibles;
	}

	public EstacionCombustible addEstacionCombustible(EstacionCombustible estacionCombustible) {
		getEstacionCombustibles().add(estacionCombustible);
		estacionCombustible.setCombustible(this);

		return estacionCombustible;
	}

	public EstacionCombustible removeEstacionCombustible(EstacionCombustible estacionCombustible) {
		getEstacionCombustibles().remove(estacionCombustible);
		estacionCombustible.setCombustible(null);

		return estacionCombustible;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCombustible == null) ? 0 : idCombustible.hashCode());
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
		Combustible other = (Combustible) obj;
		if (idCombustible == null) {
			if (other.idCombustible != null)
				return false;
		} else if (!idCombustible.equals(other.idCombustible))
			return false;
		return true;
	}
	

}