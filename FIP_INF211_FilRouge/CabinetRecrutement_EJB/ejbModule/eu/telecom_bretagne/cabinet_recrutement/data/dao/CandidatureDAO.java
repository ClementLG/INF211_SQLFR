package eu.telecom_bretagne.cabinet_recrutement.data.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import eu.telecom_bretagne.cabinet_recrutement.data.model.Candidature;

/**
* Session Bean implementation class CandidatureDAO
* @author Elouan LE DUC
* @author Clement LE GRUIEC
*/

@Stateless
@LocalBean
public class CandidatureDAO {
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
	public CandidatureDAO() {
		// TODO Auto-generated constructor stub
	}

	// -----------------------------------------------------------------------------
	public Candidature findById(Integer id) {
		return entityManager.find(Candidature.class, id);
	}
	
	// -----------------------------------------------------------------------------
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Candidature> findAll()
	  {
	    Query query = entityManager.createQuery("select candidature from Candidature candidature order by candidature.id desc");
	    List l = query.getResultList(); 
	    
	    return (List<Candidature>)l;
	  }

	// -----------------------------------------------------------------------------
	//Ajout d’une méthode pour l’obtention de la liste des candidatures qui correspondent à un secteur d’activité et un niveau de qualiﬁcation donnés.
	@SuppressWarnings({"unchecked" })
	public List<Candidature> findByActivitySector(int idSecteurActivite, int idNiveauQualification)
	{
		Query query = entityManager.createQuery("select candidature from Candidature candidature join candidature.secteurActivites secteur "
				+ "where secteur.id = :idSA and candidature.niveauQualificationBean.id = :idNQ " + "order by candidature.id desc");
		query.setParameter("idSA", idSecteurActivite);
		query.setParameter("idNQ", idNiveauQualification);
		List<Candidature> l = query.getResultList();
		return l;
	}

	// -----------------------------------------------------------------------------
	public Candidature persist(Candidature Candidature) {
		if (Candidature != null) {
			entityManager.persist(Candidature);
		}
		return Candidature;
	}
	//-----------------------------------------------------------------------------
	public Candidature update(Candidature Candidature) {
		if (Candidature != null) {
			entityManager.merge(Candidature);
		}
		return Candidature;
	}
	//-----------------------------------------------------------------------------
	public void remove(Candidature Candidature) {
		if (Candidature != null) {
			Candidature cand_suppr = entityManager.merge(Candidature);
			entityManager.remove(cand_suppr);
		}
	}

}
