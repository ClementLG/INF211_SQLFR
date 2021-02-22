package eu.telecom_bretagne.cabinet_recrutement.data.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the message_offredemploi database table.
 * 
 */
@Entity
@Table(name="message_offredemploi")
@NamedQuery(name="MessageOffredemploi.findAll", query="SELECT m FROM MessageOffredemploi m")
public class MessageOffredemploi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MESSAGE_OFFREDEMPLOI_ID_GENERATOR", sequenceName="MESSAGE_OFFREDEMPLOI_ID_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MESSAGE_OFFREDEMPLOI_ID_GENERATOR")
	private Integer id;

	private String corpsmessage;

	@Temporal(TemporalType.DATE)
	private Date dateenvoi;

	//bi-directional many-to-one association to Candidature
	@ManyToOne
	@JoinColumn(name="candidature")
	private Candidature candidatureBean;

	//bi-directional many-to-one association to OffreEmploi
	@ManyToOne
	@JoinColumn(name="offre_emploi")
	private OffreEmploi offreEmploiBean;

	public MessageOffredemploi() {
	}

	public MessageOffredemploi(String corps, Date envoi, Candidature candidature, OffreEmploi offre) {
		this.corpsmessage = corps;
		this.dateenvoi = envoi;
		this.candidatureBean = candidature;
		this.offreEmploiBean = offre;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCorpsmessage() {
		return this.corpsmessage;
	}

	public void setCorpsmessage(String corpsmessage) {
		this.corpsmessage = corpsmessage;
	}

	public Date getDateenvoi() {
		return this.dateenvoi;
	}

	public void setDateenvoi(Date dateenvoi) {
		this.dateenvoi = dateenvoi;
	}

	public Candidature getCandidatureBean() {
		return this.candidatureBean;
	}

	public void setCandidatureBean(Candidature candidatureBean) {
		this.candidatureBean = candidatureBean;
	}

	public OffreEmploi getOffreEmploiBean() {
		return this.offreEmploiBean;
	}

	public void setOffreEmploiBean(OffreEmploi offreEmploiBean) {
		this.offreEmploiBean = offreEmploiBean;
	}

}