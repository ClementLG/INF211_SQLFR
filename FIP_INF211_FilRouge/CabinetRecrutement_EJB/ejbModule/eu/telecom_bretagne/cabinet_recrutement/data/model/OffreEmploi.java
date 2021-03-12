package eu.telecom_bretagne.cabinet_recrutement.data.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the offre_emploi database table.
 * @author Elouan LE DUC
 * @author Clement LE GRUIEC
 * 
 */
@Entity
@Table(name="offre_emploi")
@NamedQuery(name="OffreEmploi.findAll", query="SELECT o FROM OffreEmploi o")
public class OffreEmploi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="OFFRE_EMPLOI_ID_GENERATOR", sequenceName="OFFRE_EMPLOI_ID_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OFFRE_EMPLOI_ID_GENERATOR")
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Date datedepot;

	private String descriptifmission;

	private String profilrecherche;

	private String titre;

	//bi-directional many-to-one association to MessageCandidature
	@OneToMany(mappedBy="offreEmploiBean", fetch=FetchType.EAGER)
	private Set<MessageCandidature> messageCandidatures;

	//bi-directional many-to-one association to MessageOffredemploi
	@OneToMany(mappedBy="offreEmploiBean", fetch=FetchType.EAGER)
	private Set<MessageOffredemploi> messageOffredemplois;

	//bi-directional many-to-one association to Entreprise
	@ManyToOne
	@JoinColumn(name="entreprise")
	private Entreprise entrepriseBean;

	//bi-directional many-to-one association to NiveauQualification
	@ManyToOne
	@JoinColumn(name="niveau_qualification")
	private NiveauQualification niveauQualificationBean;

	//bi-directional many-to-many association to SecteurActivite
	@ManyToMany(mappedBy="offreEmplois", fetch=FetchType.EAGER)
	private Set<SecteurActivite> secteurActivites;

	public OffreEmploi() {
	}

	public OffreEmploi(Date depot, String descriptif, String profil, String titre, Entreprise entreprise, NiveauQualification qualif, Set<SecteurActivite> liste_secteurs) {
		this.datedepot = depot;
		this.descriptifmission = descriptif;
		this.profilrecherche = profil;
		this.titre = titre;
		this.entrepriseBean = entreprise;
		this.niveauQualificationBean = qualif;
		this.secteurActivites = liste_secteurs;
	}
	
	public OffreEmploi(Date depot, String descriptif, String profil, String titre, Entreprise entreprise, NiveauQualification qualif) {
		this.datedepot = depot;
		this.descriptifmission = descriptif;
		this.profilrecherche = profil;
		this.titre = titre;
		this.entrepriseBean = entreprise;
		this.niveauQualificationBean = qualif;
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

	public Set<MessageCandidature> getMessageCandidatures() {
		return this.messageCandidatures;
	}

	public void setMessageCandidatures(Set<MessageCandidature> messageCandidatures) {
		this.messageCandidatures = messageCandidatures;
	}

	public MessageCandidature addMessageCandidature(MessageCandidature messageCandidature) {
		getMessageCandidatures().add(messageCandidature);
		messageCandidature.setOffreEmploiBean(this);

		return messageCandidature;
	}

	public MessageCandidature removeMessageCandidature(MessageCandidature messageCandidature) {
		getMessageCandidatures().remove(messageCandidature);
		messageCandidature.setOffreEmploiBean(null);

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
		messageOffredemploi.setOffreEmploiBean(this);

		return messageOffredemploi;
	}

	public MessageOffredemploi removeMessageOffredemploi(MessageOffredemploi messageOffredemploi) {
		getMessageOffredemplois().remove(messageOffredemploi);
		messageOffredemploi.setOffreEmploiBean(null);

		return messageOffredemploi;
	}

	public Entreprise getEntrepriseBean() {
		return this.entrepriseBean;
	}

	public void setEntrepriseBean(Entreprise entrepriseBean) {
		this.entrepriseBean = entrepriseBean;
	}

	public NiveauQualification getNiveauQualificationBean() {
		return this.niveauQualificationBean;
	}

	public void setNiveauQualificationBean(NiveauQualification niveauQualificationBean) {
		this.niveauQualificationBean = niveauQualificationBean;
	}

	public Set<SecteurActivite> getSecteurActivites() {
		return this.secteurActivites;
	}

	public void setSecteurActivites(Set<SecteurActivite> secteurActivites) {
		this.secteurActivites = secteurActivites;
	}

}