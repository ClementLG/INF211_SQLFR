package eu.telecom_bretagne.cabinet_recrutement.data.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the offreemploi database table.
 * 
 */
@Entity
@NamedQuery(name="Offreemploi.findAll", query="SELECT o FROM Offreemploi o")
public class Offreemploi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="OFFREEMPLOI_ID_GENERATOR", sequenceName="OFFREEMPLOI_ID_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OFFREEMPLOI_ID_GENERATOR")
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Date datedepot;

	private String descriptifmission;

	private String profilrecherche;

	private String titre;

	//bi-directional many-to-one association to Messagecandidature
	@OneToMany(mappedBy="offreemploiBean")
	private Set<Messagecandidature> messagecandidatures;

	//bi-directional many-to-one association to Messageoffredemploi
	@OneToMany(mappedBy="offreemploiBean")
	private Set<Messageoffredemploi> messageoffredemplois;

	//bi-directional many-to-one association to Entreprise
	@ManyToOne
	@JoinColumn(name="entreprise")
	private Entreprise entrepriseBean;

	//bi-directional many-to-one association to Niveauqualification
	@ManyToOne
	@JoinColumn(name="niveauqualification")
	private Niveauqualification niveauqualificationBean;

	//bi-directional many-to-many association to Secteuractivite
	@ManyToMany(mappedBy="offreemplois")
	private Set<Secteuractivite> secteuractivites;

	public Offreemploi() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDatedepot() {
		return this.datedepot;
	}

	public void setDatedepot(Date datedepot) {
		this.datedepot = datedepot;
	}

	public String getDescriptifmission() {
		return this.descriptifmission;
	}

	public void setDescriptifmission(String descriptifmission) {
		this.descriptifmission = descriptifmission;
	}

	public String getProfilrecherche() {
		return this.profilrecherche;
	}

	public void setProfilrecherche(String profilrecherche) {
		this.profilrecherche = profilrecherche;
	}

	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Set<Messagecandidature> getMessagecandidatures() {
		return this.messagecandidatures;
	}

	public void setMessagecandidatures(Set<Messagecandidature> messagecandidatures) {
		this.messagecandidatures = messagecandidatures;
	}

	public Messagecandidature addMessagecandidature(Messagecandidature messagecandidature) {
		getMessagecandidatures().add(messagecandidature);
		messagecandidature.setOffreemploiBean(this);

		return messagecandidature;
	}

	public Messagecandidature removeMessagecandidature(Messagecandidature messagecandidature) {
		getMessagecandidatures().remove(messagecandidature);
		messagecandidature.setOffreemploiBean(null);

		return messagecandidature;
	}

	public Set<Messageoffredemploi> getMessageoffredemplois() {
		return this.messageoffredemplois;
	}

	public void setMessageoffredemplois(Set<Messageoffredemploi> messageoffredemplois) {
		this.messageoffredemplois = messageoffredemplois;
	}

	public Messageoffredemploi addMessageoffredemploi(Messageoffredemploi messageoffredemploi) {
		getMessageoffredemplois().add(messageoffredemploi);
		messageoffredemploi.setOffreemploiBean(this);

		return messageoffredemploi;
	}

	public Messageoffredemploi removeMessageoffredemploi(Messageoffredemploi messageoffredemploi) {
		getMessageoffredemplois().remove(messageoffredemploi);
		messageoffredemploi.setOffreemploiBean(null);

		return messageoffredemploi;
	}

	public Entreprise getEntrepriseBean() {
		return this.entrepriseBean;
	}

	public void setEntrepriseBean(Entreprise entrepriseBean) {
		this.entrepriseBean = entrepriseBean;
	}

	public Niveauqualification getNiveauqualificationBean() {
		return this.niveauqualificationBean;
	}

	public void setNiveauqualificationBean(Niveauqualification niveauqualificationBean) {
		this.niveauqualificationBean = niveauqualificationBean;
	}

	public Set<Secteuractivite> getSecteuractivites() {
		return this.secteuractivites;
	}

	public void setSecteuractivites(Set<Secteuractivite> secteuractivites) {
		this.secteuractivites = secteuractivites;
	}

}