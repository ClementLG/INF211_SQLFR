package eu.telecom_bretagne.cabinet_recrutement.data.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import eu.telecom_bretagne.cabinet_recrutement.data.model.MessageCandidature;

/**
 * Session Bean implementation class MessageCandidatureDAO
 * 
 * @author Elouan LE DUC
 * @author Clement LE GRUIEC
 */

@Stateless
@LocalBean
public class MessagecandidatureDAO {
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
	  public MessagecandidatureDAO()
	  {
	    // TODO Auto-generated constructor stub
	  }

	// -----------------------------------------------------------------------------
	public MessageCandidature findById(Integer id) {
		return entityManager.find(MessageCandidature.class, id);
	}

	// ----------------------------------------------------------------------------
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<MessageCandidature> findAll() {
		Query query = entityManager.createQuery("select messagecandidature from MessageCandidature messagecandidature order by MessageCandidature.id");
		List l = query.getResultList();

		return (List<MessageCandidature>) l;
	}

	// -----------------------------------------------------------------------------
	public MessageCandidature persist(MessageCandidature MessageCandidature) {
		if (MessageCandidature != null) {
			entityManager.persist(MessageCandidature);
		}
		return MessageCandidature;
	}
	//-----------------------------------------------------------------------------
	public MessageCandidature update(MessageCandidature MessageCandidature) {
		if (MessageCandidature != null) {
			entityManager.merge(MessageCandidature);
		}
		return MessageCandidature;
	}
	//-----------------------------------------------------------------------------
	public void remove(MessageCandidature MessageCandidature) {
		if (MessageCandidature != null) {
			MessageCandidature mc_suppr = entityManager.merge(MessageCandidature);
			entityManager.remove(mc_suppr);
		}
	}
}
