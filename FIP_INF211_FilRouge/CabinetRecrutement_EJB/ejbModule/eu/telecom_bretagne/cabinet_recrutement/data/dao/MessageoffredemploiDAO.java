package eu.telecom_bretagne.cabinet_recrutement.data.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import eu.telecom_bretagne.cabinet_recrutement.data.model.MessageOffredemploi;

/**
 * Session Bean implementation class MessageOffredemploiDAO
 * 
 * @author Elouan LE DUC
 * @author Clement LE GRUIEC
 */

@Stateless
@LocalBean
public class MessageoffredemploiDAO {
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
		  public MessageoffredemploiDAO()
		  {
		    // TODO Auto-generated constructor stub
		  }

	// -----------------------------------------------------------------------------
	public MessageOffredemploi findById(Integer id) {
		return entityManager.find(MessageOffredemploi.class, id);
	}

	// ----------------------------------------------------------------------------
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<MessageOffredemploi> findAll() {
		Query query = entityManager.createQuery(
				"select messageoffredemploi from MessageOffredemploi messageoffredemploi order by MessageOffredemploi.id");
		List l = query.getResultList();

		return (List<MessageOffredemploi>) l;
	}

	// -----------------------------------------------------------------------------
	public MessageOffredemploi persist(MessageOffredemploi MessageOffredemploi) {
		if (MessageOffredemploi != null) {
			entityManager.persist(MessageOffredemploi);
		}
		return MessageOffredemploi;
	}
	//-----------------------------------------------------------------------------
	public MessageOffredemploi update(MessageOffredemploi MessageOffredemploi) {
		if (MessageOffredemploi != null) {
			entityManager.merge(MessageOffredemploi);
		}
		return MessageOffredemploi;
	}
	//-----------------------------------------------------------------------------
	public void remove(MessageOffredemploi MessageOffredemploi) {
		if (MessageOffredemploi != null) {
			entityManager.remove(MessageOffredemploi);
		}
	}
}
