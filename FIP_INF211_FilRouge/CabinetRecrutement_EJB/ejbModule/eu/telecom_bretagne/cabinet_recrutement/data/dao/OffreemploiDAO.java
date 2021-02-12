package eu.telecom_bretagne.cabinet_recrutement.data.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import eu.telecom_bretagne.cabinet_recrutement.data.model.Candidature;
import eu.telecom_bretagne.cabinet_recrutement.data.model.OffreEmploi;

/**
 * Session Bean implementation class OffreEmploiDAO
 * 
 * @author Elouan LE DUC
 * @author Clement LE GRUIEC
 */

@Stateless
@LocalBean
public class OffreemploiDAO {
	// -----------------------------------------------------------------------------
	/**
	 * Référence vers le gestionnaire de persistance.
	 */
	@PersistenceContext
	EntityManager entityManager;

	// -----------------------------------------------------------------------------
	/**
				   * Default constructor.
				   */
				  public OffreemploiDAO()
				  {
				    // TODO Auto-generated constructor stub
				  }

	// -----------------------------------------------------------------------------
	public OffreEmploi findById(Integer id) {
		return entityManager.find(OffreEmploi.class, id);
	}

	// ----------------------------------------------------------------------------
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<OffreEmploi> findAll() {
<<<<<<< HEAD
		Query query = entityManager.createQuery("select offreemploi from OffreEmploi offreemploi order by offreemploi.id desc");
=======
		Query query = entityManager.createQuery(
				"select offreemploi from OffreEmploi offreemploi order by offreemploi.id");
>>>>>>> ac6c6fc... work in progress offreemploi test
		List l = query.getResultList();

	// ----------------------------------------------------------------------------
    //Ajout d’une méthode pour l’obtention de la liste des offres d’emploi pour une entreprise donnée.
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<OffreEmploi> findOfferByEnterprise(int idEnterprise) {
		Query query = entityManager.createQuery(
				"select offreemploi from OffreEmploi offreemploi where offreemploi.entreprise.id = :idE order by OffreEmploi.id");
		query.setParameter("idE", idEnterprise);
		List l = query.getResultList();

		return (List<OffreEmploi>) l;
	}
	// ----------------------------------------------------------------------------
    //Ajout d’une méthode pour l’obtention de la liste des offres d’emploi qui correspond à un secteur d’activité et un niveau de qualiﬁcation donnés.
	@SuppressWarnings({"unchecked" })
	public List<OffreEmploi> findByActivitySector(int idSecteurActivite, int idNiveauQualification)
	{
		Query query = entityManager.createQuery("select offreemploi from OffreEmploi offreemploi join offreemploi.secteurActivites secteur "
				+ "where secteur.id = :idSA and offreemploi.niveauQualificationBean.id = :idNQ " + "order by offreemploi.id desc");
		query.setParameter("idSA", idSecteurActivite);
		query.setParameter("idNQ", idNiveauQualification);
		List<OffreEmploi> l = query.getResultList();
		return l;
	}
	// -----------------------------------------------------------------------------
	public OffreEmploi persist(OffreEmploi OffreEmploi) {
		if (OffreEmploi != null) {
			entityManager.persist(OffreEmploi);
		}
		return OffreEmploi;
	}
	//-----------------------------------------------------------------------------
	public OffreEmploi update(OffreEmploi OffreEmploi) {
		if (OffreEmploi != null) {
			entityManager.merge(OffreEmploi);
		}
		return OffreEmploi;
	}
	//-----------------------------------------------------------------------------
	public void remove(OffreEmploi OffreEmploi) {
		if (OffreEmploi != null) {
			OffreEmploi oe_suppr = entityManager.merge(OffreEmploi);
			entityManager.remove(oe_suppr);
		}
	}
}
