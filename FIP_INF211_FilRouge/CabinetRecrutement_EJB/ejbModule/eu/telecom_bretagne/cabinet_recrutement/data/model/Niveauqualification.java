package eu.telecom_bretagne.cabinet_recrutement.data.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the niveauqualification database table.
 * 
 */
@Entity
@NamedQuery(name="Niveauqualification.findAll", query="SELECT n FROM Niveauqualification n")
public class Niveauqualification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="NIVEAUQUALIFICATION_INTITULE_GENERATOR", sequenceName="NIVEAUQUALIFICATION_INTITULE_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="NIVEAUQUALIFICATION_INTITULE_GENERATOR")
	private String intitule;

	//bi-directional many-to-one association to Candidature
	@OneToMany(mappedBy="niveauqualificationBean")
	private Set<Candidature> candidatures;

	//bi-directional many-to-one association to Offreemploi
	@OneToMany(mappedBy="niveauqualificationBean")
	private Set<Offreemploi> offreemplois;

	public Niveauqualification() {
	}

	public String getIntitule() {
		return this.intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public Set<Candidature> getCandidatures() {
		return this.candidatures;
	}

	public void setCandidatures(Set<Candidature> candidatures) {
		this.candidatures = candidatures;
	}

	public Candidature addCandidature(Candidature candidature) {
		getCandidatures().add(candidature);
		candidature.setNiveauqualificationBean(this);

		return candidature;
	}

	public Candidature removeCandidature(Candidature candidature) {
		getCandidatures().remove(candidature);
		candidature.setNiveauqualificationBean(null);

		return candidature;
	}

	public Set<Offreemploi> getOffreemplois() {
		return this.offreemplois;
	}

	public void setOffreemplois(Set<Offreemploi> offreemplois) {
		this.offreemplois = offreemplois;
	}

	public Offreemploi addOffreemploi(Offreemploi offreemploi) {
		getOffreemplois().add(offreemploi);
		offreemploi.setNiveauqualificationBean(this);

		return offreemploi;
	}

	public Offreemploi removeOffreemploi(Offreemploi offreemploi) {
		getOffreemplois().remove(offreemploi);
		offreemploi.setNiveauqualificationBean(null);

		return offreemploi;
	}

}