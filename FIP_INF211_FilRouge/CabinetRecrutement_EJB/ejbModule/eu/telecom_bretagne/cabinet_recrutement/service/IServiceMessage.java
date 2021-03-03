package eu.telecom_bretagne.cabinet_recrutement.service;

import java.util.List;

import javax.ejb.Remote;

import eu.telecom_bretagne.cabinet_recrutement.data.model.Candidature;
import eu.telecom_bretagne.cabinet_recrutement.data.model.MessageCandidature;
import eu.telecom_bretagne.cabinet_recrutement.data.model.MessageOffredemploi;
import eu.telecom_bretagne.cabinet_recrutement.data.model.OffreEmploi;


/**
 * Interface du service gérant les entreprises.
 * @author Philippe TANGUY
 */
@Remote
public interface IServiceMessage
{

	  public MessageCandidature getMessageCandidature(int id);
	  //-----------------------------------------------------------------------------
	  //-----------------------------------------------------------------------------
	  public MessageOffredemploi getMessageOffreEmploi(int id);
	  //-----------------------------------------------------------------------------
	  //-----------------------------------------------------------------------------
  
}
