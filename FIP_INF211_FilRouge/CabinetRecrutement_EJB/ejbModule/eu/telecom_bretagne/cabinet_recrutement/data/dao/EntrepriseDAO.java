package eu.telecom_bretagne.cabinet_recrutement.data.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import eu.telecom_bretagne.cabinet_recrutement.data.model.Entreprise;

/**
 * Session Bean implementation class EntrepriseDAO
 * 
 * @author Elouan LE DUC
 * @author Clement LE GRUIEC
 */

@Stateless
@LocalBean
public class EntrepriseDAO {
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
	public EntrepriseDAO() {
		// TODO Auto-generated constructor stub
	}

	// -----------------------------------------------------------------------------
	public Entreprise findById(Integer id) {
		return entityManager.find(Entreprise.class, id);
	}

	// ----------------------------------------------------------------------------
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Entreprise> findAll() {
		Query query = entityManager.createQuery("select entreprise from Entreprise entreprise order by entreprise.id");
		List l = query.getResultList();

		return (List<Entreprise>) l;
	}
	// -----------------------------------------------------------------------------
	public Entreprise persist(Entreprise Entreprise) {
		if (Entreprise != null) {
			entityManager.persist(Entreprise);
		}
		return Entreprise;
	}

	// -----------------------------------------------------------------------------
	public Entreprise update(Entreprise Entreprise) {
		if (Entreprise != null) {
			entityManager.merge(Entreprise);
		}
		return Entreprise;
	}

	//-----------------------------------------------------------------------------
	public void remove(Entreprise Entreprise) {
		if ((Entreprise != null) & (!entityManager.contains(Entreprise))) {
			Entreprise ent_suppr = entityManager.merge(Entreprise);
			entityManager.remove(ent_suppr);
		}
	}

}
