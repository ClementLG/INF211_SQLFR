package eu.telecom_bretagne.cabinet_recrutement.data.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the messageoffredemploi database table.
 * 
 */
@Entity
@NamedQuery(name="Messageoffredemploi.findAll", query="SELECT m FROM Messageoffredemploi m")
public class Messageoffredemploi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MESSAGEOFFREDEMPLOI_ID_GENERATOR", sequenceName="MESSAGEOFFREDEMPLOI_ID_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MESSAGEOFFREDEMPLOI_ID_GENERATOR")
	private Integer id;

	private String corpsmessage;

	@Temporal(TemporalType.DATE)
	private Date dateenvoi;

	//bi-directional many-to-one association to Candidature
	@ManyToOne
	@JoinColumn(name="candidature")
	private Candidature candidatureBean;

	//bi-directional many-to-one association to Offreemploi
	@ManyToOne
	@JoinColumn(name="offreemploi")
	private Offreemploi offreemploiBean;

	public Messageoffredemploi() {
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

	public Offreemploi getOffreemploiBean() {
		return this.offreemploiBean;
	}

	public void setOffreemploiBean(Offreemploi offreemploiBean) {
		this.offreemploiBean = offreemploiBean;
	}

}