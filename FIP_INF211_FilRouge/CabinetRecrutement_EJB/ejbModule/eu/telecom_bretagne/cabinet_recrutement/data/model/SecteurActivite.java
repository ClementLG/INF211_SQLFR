package eu.telecom_bretagne.cabinet_recrutement.data.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the secteur_activite database table.
 * @author Elouan LE DUC
 * @author Clement LE GRUIEC
 * 
 */
@Entity
@Table(name="secteur_activite")
@NamedQuery(name="SecteurActivite.findAll", query="SELECT s FROM SecteurActivite s")
public class SecteurActivite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SECTEUR_ACTIVITE_ID_GENERATOR", sequenceName="SECTEUR_ACTIVITE_ID_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SECTEUR_ACTIVITE_ID_GENERATOR")
	private Integer id;

	private String intitule;

	//bi-directional many-to-many association to Candidature
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="secteur_candidature"
		, joinColumns={
			@JoinColumn(name="secteur_activite")
			}
		, inverseJoinColumns={
			@JoinColumn(name="candidature")
			}
		)
	private Set<Candidature> candidatures;

	//bi-directional many-to-many association to OffreEmploi
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="secteur_offre"
		, joinColumns={
			@JoinColumn(name="secteur_activite")
			}
		, inverseJoinColumns={
			@JoinColumn(name="offre_emploi")
			}
		)
	private Set<OffreEmploi> offreEmplois;

	public SecteurActivite() {
	}

	public SecteurActivite(String intitule)  {
		this.intitule = intitule;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	
	public void addCandidatures(Candidature candidature) {	
		this.candidatures.add(candidature);	
	}

	public Set<OffreEmploi> getOffreEmplois() {
		return this.offreEmplois;
	}

	public void setOffreEmplois(Set<OffreEmploi> offreEmplois) {
		this.offreEmplois = offreEmplois;
	}

}