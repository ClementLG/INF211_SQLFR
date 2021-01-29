package eu.telecom_bretagne.cabinet_recrutement.data.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the candidature database table.
 * 
 */
@Entity
@NamedQuery(name="Candidature.findAll", query="SELECT c FROM Candidature c")
public class Candidature implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CANDIDATURE_ID_GENERATOR", sequenceName="CANDIDATURE_ID_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CANDIDATURE_ID_GENERATOR")
	private Integer id;

	private String adresseemail;

	private String adressepostale;

	private String cv;

	@Temporal(TemporalType.DATE)
	private Date datedepot;

	@Temporal(TemporalType.DATE)
	private Date datenaissance;

	//bi-directional many-to-one association to Niveauqualification
	@ManyToOne
	@JoinColumn(name="niveauqualification")
	private Niveauqualification niveauqualificationBean;

	//bi-directional many-to-one association to Messagecandidature
	@OneToMany(mappedBy="candidatureBean")
	private Set<Messagecandidature> messagecandidatures;

	//bi-directional many-to-one association to Messageoffredemploi
	@OneToMany(mappedBy="candidatureBean")
	private Set<Messageoffredemploi> messageoffredemplois;

	//bi-directional many-to-many association to Secteuractivite
	@ManyToMany(mappedBy="candidatures")
	private Set<Secteuractivite> secteuractivites;

	public Candidature() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAdresseemail() {
		return this.adresseemail;
	}

	public void setAdresseemail(String adresseemail) {
		this.adresseemail = adresseemail;
	}

	public String getAdressepostale() {
		return this.adressepostale;
	}

	public void setAdressepostale(String adressepostale) {
		this.adressepostale = adressepostale;
	}

	public String getCv() {
		return this.cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	public Date getDatedepot() {
		return this.datedepot;
	}

	public void setDatedepot(Date datedepot) {
		this.datedepot = datedepot;
	}

	public Date getDatenaissance() {
		return this.datenaissance;
	}

	public void setDatenaissance(Date datenaissance) {
		this.datenaissance = datenaissance;
	}

	public Niveauqualification getNiveauqualificationBean() {
		return this.niveauqualificationBean;
	}

	public void setNiveauqualificationBean(Niveauqualification niveauqualificationBean) {
		this.niveauqualificationBean = niveauqualificationBean;
	}

	public Set<Messagecandidature> getMessagecandidatures() {
		return this.messagecandidatures;
	}

	public void setMessagecandidatures(Set<Messagecandidature> messagecandidatures) {
		this.messagecandidatures = messagecandidatures;
	}

	public Messagecandidature addMessagecandidature(Messagecandidature messagecandidature) {
		getMessagecandidatures().add(messagecandidature);
		messagecandidature.setCandidatureBean(this);

		return messagecandidature;
	}

	public Messagecandidature removeMessagecandidature(Messagecandidature messagecandidature) {
		getMessagecandidatures().remove(messagecandidature);
		messagecandidature.setCandidatureBean(null);

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
		messageoffredemploi.setCandidatureBean(this);

		return messageoffredemploi;
	}

	public Messageoffredemploi removeMessageoffredemploi(Messageoffredemploi messageoffredemploi) {
		getMessageoffredemplois().remove(messageoffredemploi);
		messageoffredemploi.setCandidatureBean(null);

		return messageoffredemploi;
	}

	public Set<Secteuractivite> getSecteuractivites() {
		return this.secteuractivites;
	}

	public void setSecteuractivites(Set<Secteuractivite> secteuractivites) {
		this.secteuractivites = secteuractivites;
	}

}