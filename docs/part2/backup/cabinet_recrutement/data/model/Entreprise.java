package eu.telecom_bretagne.cabinet_recrutement.data.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the entreprise database table.
 * 
 */
@Entity
@NamedQuery(name="Entreprise.findAll", query="SELECT e FROM Entreprise e")
public class Entreprise implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ENTREPRISE_ID_GENERATOR", sequenceName="ENTREPRISE_ID_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ENTREPRISE_ID_GENERATOR")
	private Integer id;

	private String adressepostale;

	private String descriptif;

	private String nom;

	//bi-directional many-to-one association to Offreemploi
	@OneToMany(mappedBy="entrepriseBean")
	private Set<Offreemploi> offreemplois;

	public Entreprise() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAdressepostale() {
		return this.adressepostale;
	}

	public void setAdressepostale(String adressepostale) {
		this.adressepostale = adressepostale;
	}

	public String getDescriptif() {
		return this.descriptif;
	}

	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Set<Offreemploi> getOffreemplois() {
		return this.offreemplois;
	}

	public void setOffreemplois(Set<Offreemploi> offreemplois) {
		this.offreemplois = offreemplois;
	}

	public Offreemploi addOffreemploi(Offreemploi offreemploi) {
		getOffreemplois().add(offreemploi);
		offreemploi.setEntrepriseBean(this);

		return offreemploi;
	}

	public Offreemploi removeOffreemploi(Offreemploi offreemploi) {
		getOffreemplois().remove(offreemploi);
		offreemploi.setEntrepriseBean(null);

		return offreemploi;
	}

}