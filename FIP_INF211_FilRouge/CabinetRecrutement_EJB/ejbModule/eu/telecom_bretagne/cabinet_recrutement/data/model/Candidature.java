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
	@SequenceGenerator(name="CANDIDATURE_ID_GENERATOR", sequenceName="CANDIDATURE_ID_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CANDIDATURE_ID_GENERATOR")
	private Integer id;

	private String adresseemail;

	private String adressepostale;

	private String cv;

	@Temporal(TemporalType.DATE)
	private Date datedepot;

	@Temporal(TemporalType.DATE)
	private Date datenaissance;

	//bi-directional many-to-one association to NiveauQualification
	@ManyToOne
	@JoinColumn(name="niveau_qualification")
	private NiveauQualification niveauQualificationBean;

	//bi-directional many-to-one association to MessageCandidature
	@OneToMany(mappedBy="candidatureBean")
	private Set<MessageCandidature> messageCandidatures;

	//bi-directional many-to-one association to MessageOffredemploi
	@OneToMany(mappedBy="candidatureBean")
	private Set<MessageOffredemploi> messageOffredemplois;

	//bi-directional many-to-many association to SecteurActivite
	@ManyToMany(mappedBy="candidatures")
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
		return this.niveauQualificationBean;
	}

	public void setNiveauQualificationBean(NiveauQualification niveauQualificationBean) {
		this.niveauQualificationBean = niveauQualificationBean;
	}

	public Set<MessageCandidature> getMessagecandidatures() {
		return this.messageCandidatures;
	}

	public void setMessageCandidatures(Set<MessageCandidature> messageCandidatures) {
		this.messageCandidatures = messageCandidatures;
	}

	public MessageCandidature addMessageCandidature(MessageCandidature messageCandidature) {
		getMessagecandidatures().add(messageCandidature);
		messageCandidature.setCandidatureBean(this);

		return messageCandidature;
	}

	public MessageCandidature removeMessageCandidature(MessageCandidature messageCandidature) {
		getMessagecandidatures().remove(messageCandidature);
		messageCandidature.setCandidatureBean(null);

		return messageCandidature;
	}

	public Set<MessageOffredemploi> getMessageoffredemplois() {
		return this.messageOffredemplois;
	}

	public void setMessageOffredemplois(Set<MessageOffredemploi> messageOffredemplois) {
		this.messageOffredemplois = messageOffredemplois;
	}

	public MessageOffredemploi addMessageOffredemploi(MessageOffredemploi messageOffredemploi) {
		getMessageoffredemplois().add(messageOffredemploi);
		messageOffredemploi.setCandidatureBean(this);

		return messageOffredemploi;
	}

	public MessageOffredemploi removeMessageOffredemploi(MessageOffredemploi messageOffredemploi) {
		getMessageoffredemplois().remove(messageOffredemploi);
		messageOffredemploi.setCandidatureBean(null);

		return messageOffredemploi;
	}

	public Set<SecteurActivite> getSecteuractivites() {
		return this.secteurActivites;
	}

	public void setSecteurActivites(Set<SecteurActivite> secteurActivites) {
		this.secteurActivites = secteurActivites;
	}

}