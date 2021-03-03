package eu.telecom_bretagne.cabinet_recrutement.data.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import eu.telecom_bretagne.cabinet_recrutement.data.model.SecteurActivite;

/**
 * Session Bean implementation class SecteurActiviteDAO
 * 
 * @author Elouan LE DUC
 * @author Clement LE GRUIEC
 */

@Stateless
@LocalBean
public class SecteuractiviteDAO {
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
	public SecteuractiviteDAO() {
		// TODO Auto-generated constructor stub
	}

	// -----------------------------------------------------------------------------
	public SecteurActivite findById(Integer id) {
		return entityManager.find(SecteurActivite.class, id);
	}

	// ----------------------------------------------------------------------------
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<SecteurActivite> findAll() {
		Query query = entityManager
				.createQuery("select secteuractivite from SecteurActivite secteuractivite order by SecteurActivite.id");
		List l = query.getResultList();

		return (List<SecteurActivite>) l;
	}

	// -----------------------------------------------------------------------------
	public SecteurActivite persist(SecteurActivite SecteurActivite) {
		if (SecteurActivite != null) {
			entityManager.persist(SecteurActivite);
		}
		return SecteurActivite;
	}

	// -----------------------------------------------------------------------------
	public SecteurActivite update(SecteurActivite SecteurActivite) {
		if (SecteurActivite != null) {
			entityManager.merge(SecteurActivite);
		}
		return SecteurActivite;
	}
	// -----------------------------------------------------------------------------
	public SecteurActivite remove(SecteurActivite SecteurActivite) {
		if ((SecteurActivite != null) & (!entityManager.contains(SecteurActivite))) {
			SecteurActivite sa_suppr = entityManager.merge(SecteurActivite);
			entityManager.remove(sa_suppr);
		}
		return SecteurActivite;
	}
}
