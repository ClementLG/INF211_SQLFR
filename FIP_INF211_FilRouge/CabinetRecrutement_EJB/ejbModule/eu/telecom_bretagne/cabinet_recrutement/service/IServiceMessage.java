package eu.telecom_bretagne.cabinet_recrutement.service;

import java.util.List;

import javax.ejb.Remote;

import eu.telecom_bretagne.cabinet_recrutement.data.model.Candidature;
import eu.telecom_bretagne.cabinet_recrutement.data.model.MessageCandidature;
import eu.telecom_bretagne.cabinet_recrutement.data.model.MessageOffredemploi;
import eu.telecom_bretagne.cabinet_recrutement.data.model.OffreEmploi;


/**
 * Interface du service gérant les Messages.
 * @author Elouan LE DUC
 * @author Clement LE GRUIEC
 * 
 */
@Remote
public interface IServiceMessage
{
	  /**
	   * permet de récupérer un message
	   * 
	   * @param id du message candidature
	   * 
	   * @return MessageCandidature
	   */
	  public MessageCandidature getMessageCandidature(int id);
	  /**
	   * permet de récupérer un message
	   * 
	   * @param id du message offre emploi
	   * 
	   * @return MessageOffredemploi
	   */
	  public MessageOffredemploi getMessageOffreEmploi(int id);
	
}
