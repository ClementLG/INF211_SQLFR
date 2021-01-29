package eu.telecom_bretagne.cabinet_recrutement.data.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the secteuractivite database table.
 * 
 */
@Entity
@NamedQuery(name="Secteuractivite.findAll", query="SELECT s FROM Secteuractivite s")
public class Secteuractivite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SECTEURACTIVITE_INTITULE_GENERATOR", sequenceName="SECTEURACTIVITE_INTITULE_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SECTEURACTIVITE_INTITULE_GENERATOR")
	private String intitule;

	//bi-directional many-to-many association to Candidature
	@ManyToMany
	@JoinTable(
		name="secteurcandidature"
		, joinColumns={
			@JoinColumn(name="secteuractivite")
			}
		, inverseJoinColumns={
			@JoinColumn(name="candidature")
			}
		)
	private Set<Candidature> candidatures;

	//bi-directional many-to-many association to Offreemploi
	@ManyToMany
	@JoinTable(
		name="secteuroffre"
		, joinColumns={
			@JoinColumn(name="secteuractivite")
			}
		, inverseJoinColumns={
			@JoinColumn(name="offreemploi")
			}
		)
	private Set<Offreemploi> offreemplois;

	public Secteuractivite() {
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

	public Set<Offreemploi> getOffreemplois() {
		return this.offreemplois;
	}

	public void setOffreemplois(Set<Offreemploi> offreemplois) {
		this.offreemplois = offreemplois;
	}

}