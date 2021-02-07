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
@NamedQuery(name = "Candidature.findAll", query = "SELECT c FROM Candidature c")
public class Candidature implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "CANDIDATURE_ID_GENERATOR", sequenceName = "CANDIDATURE_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CANDIDATURE_ID_GENERATOR")
	private Integer id;

	private String adresseemail;

	private String adressepostale;

	private String cv;

	@Temporal(TemporalType.DATE)
	private Date datedepot;

	@Temporal(TemporalType.DATE)
	private Date datenaissance;

	// bi-directional many-to-one association to Niveauqualification
	@ManyToOne
	@JoinColumn(name = "niveauqualification")
	private NiveauQualification niveauqualificationBean;

	// bi-directional many-to-one association to Messagecandidature
	@OneToMany(mappedBy = "candidatureBean")
	private Set<MessageCandidature> messagecandidatures;

	// bi-directional many-to-one association to Messageoffredemploi
	@OneToMany(mappedBy = "candidatureBean")
	private Set<MessageOffredemploi> messageoffredemplois;

	// bi-directional many-to-many association to Secteuractivite
	@ManyToMany(mappedBy = "candidatures")
	private Set<SecteurActivite> secteuractivites;
	// bi-directional many-to-one association to NiveauQualification
	@ManyToOne
	@JoinColumn(name = "niveau_qualification")
	private NiveauQualification niveauQualificationBean;

	// bi-directional many-to-one association to MessageCandidature
	@OneToMany(mappedBy = "candidatureBean")
	private Set<MessageCandidature> messageCandidatures;

	// bi-directional many-to-one association to MessageOffredemploi
	@OneToMany(mappedBy = "candidatureBean")
	private Set<MessageOffredemploi> messageOffredemplois;

	// bi-directional many-to-many association to SecteurActivite
	@ManyToMany(mappedBy = "candidatures")
	private Set<SecteurActivite> secteurActivites;

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

	public NiveauQualification getNiveauqualificationBean() {
		return this.niveauqualificationBean;
	}

	public void setNiveauqualificationBean(NiveauQualification niveauqualificationBean) {
		this.niveauqualificationBean = niveauqualificationBean;
	}

	public Set<MessageCandidature> getMessagecandidatures() {
		return this.messagecandidatures;
	}

	public void setMessagecandidatures(Set<MessageCandidature> messagecandidatures) {
		this.messagecandidatures = messagecandidatures;
	}

	public MessageCandidature addMessagecandidature(MessageCandidature messagecandidature) {
		getMessagecandidatures().add(messagecandidature);
		messagecandidature.setCandidatureBean(this);

		return messagecandidature;
	}

	public MessageCandidature removeMessagecandidature(MessageCandidature messagecandidature) {
		getMessagecandidatures().remove(messagecandidature);
		messagecandidature.setCandidatureBean(null);

		return messagecandidature;
	}

	public Set<MessageOffredemploi> getMessageoffredemplois() {
		return this.messageoffredemplois;
	}

	public void setMessageoffredemplois(Set<MessageOffredemploi> messageoffredemplois) {
		this.messageoffredemplois = messageoffredemplois;
	}

	public MessageOffredemploi addMessageoffredemploi(MessageOffredemploi messageoffredemploi) {
		getMessageoffredemplois().add(messageoffredemploi);
		messageoffredemploi.setCandidatureBean(this);

		return messageoffredemploi;
	}

	public MessageOffredemploi removeMessageoffredemploi(MessageOffredemploi messageoffredemploi) {
		getMessageoffredemplois().remove(messageoffredemploi);
		messageoffredemploi.setCandidatureBean(null);

		return messageoffredemploi;
	}

	public Set<SecteurActivite> getSecteuractivites() {
		return this.secteuractivites;
	}

	public void setSecteuractivites(Set<SecteurActivite> secteuractivites) {
		this.secteuractivites = secteuractivites;
	}

	public NiveauQualification getNiveauQualificationBean() {
		return this.niveauQualificationBean;
	}

	public void setNiveauQualificationBean(NiveauQualification niveauQualificationBean) {
		this.niveauQualificationBean = niveauQualificationBean;
	}

	public Set<MessageCandidature> getMessageCandidatures() {
		return this.messageCandidatures;
	}

	public void setMessageCandidatures(Set<MessageCandidature> messageCandidatures) {
		this.messageCandidatures = messageCandidatures;
	}

	public MessageCandidature addMessageCandidature(MessageCandidature messageCandidature) {
		getMessageCandidatures().add(messageCandidature);
		messageCandidature.setCandidatureBean(this);

		return messageCandidature;
	}

	public MessageCandidature removeMessageCandidature(MessageCandidature messageCandidature) {
		getMessageCandidatures().remove(messageCandidature);
		messageCandidature.setCandidatureBean(null);

		return messageCandidature;
	}

	public Set<MessageOffredemploi> getMessageOffredemplois() {
		return this.messageOffredemplois;
	}

	public void setMessageOffredemplois(Set<MessageOffredemploi> messageOffredemplois) {
		this.messageOffredemplois = messageOffredemplois;
	}

	public MessageOffredemploi addMessageOffredemploi(MessageOffredemploi messageOffredemploi) {
		getMessageOffredemplois().add(messageOffredemploi);
		messageOffredemploi.setCandidatureBean(this);

		return messageOffredemploi;
	}

	public MessageOffredemploi removeMessageOffredemploi(MessageOffredemploi messageOffredemploi) {
		getMessageOffredemplois().remove(messageOffredemploi);
		messageOffredemploi.setCandidatureBean(null);

		return messageOffredemploi;
	}

	public Set<SecteurActivite> getSecteurActivites() {
		return this.secteurActivites;
	}

	public void setSecteurActivites(Set<SecteurActivite> secteurActivites) {
		this.secteurActivites = secteurActivites;
	}

}