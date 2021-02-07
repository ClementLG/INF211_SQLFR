package eu.telecom_bretagne.cabinet_recrutement.data.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import eu.telecom_bretagne.cabinet_recrutement.data.model.NiveauQualification;

/**
 * Session Bean implementation class NiveauQualificationDAO
 * 
 * @author Elouan LE DUC
 * @author Clement LE GRUIEC
 */

@Stateless
@LocalBean
public class NiveauqualificationDAO {
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
			  public NiveauqualificationDAO()
			  {
			    // TODO Auto-generated constructor stub
			  }

	// -----------------------------------------------------------------------------
	public NiveauQualification findById(Integer id) {
		return entityManager.find(NiveauQualification.class, id);
	}

	// ----------------------------------------------------------------------------
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<NiveauQualification> findAll() {
		Query query = entityManager.createQuery(
				"select niveauqualification from NiveauQualification niveauqualification order by NiveauQualification.id");
		List l = query.getResultList();

		return (List<NiveauQualification>) l;
	}

	// -----------------------------------------------------------------------------
	public NiveauQualification persist(NiveauQualification NiveauQualification) {
		if (NiveauQualification != null) {
			entityManager.persist(NiveauQualification);
		}
		return NiveauQualification;
	}
	//-----------------------------------------------------------------------------
	public NiveauQualification update(NiveauQualification NiveauQualification) {
		if (NiveauQualification != null) {
			entityManager.merge(NiveauQualification);
		}
		return NiveauQualification;
	}
}
