package eu.telecom_bretagne.cabinet_recrutement.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebService;

import eu.telecom_bretagne.cabinet_recrutement.data.dao.EntrepriseDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.dao.MessagecandidatureDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.dao.MessageoffredemploiDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.model.Entreprise;
import eu.telecom_bretagne.cabinet_recrutement.data.model.MessageCandidature;
import eu.telecom_bretagne.cabinet_recrutement.data.model.MessageOffredemploi;

/**
 * Session Bean implementation class ServiceEntreprise
 * @author Elouan LE DUC
 * @author Clement LE GRUIEC
 * 
 */
@Stateless
@LocalBean
public class ServiceMessage implements IServiceMessage
{
	//-----------------------------------------------------------------------------
	@EJB private MessagecandidatureDAO         messagecandidatureDAO;
	@EJB private MessageoffredemploiDAO         messageoffredemploiDAO;
	//-----------------------------------------------------------------------------
	/**
	 * Default constructor.
	 */
	public ServiceMessage()
	{
		// TODO Auto-generated constructor stub
	}
	//-----------------------------------------------------------------------------
	@Override
	public MessageCandidature getMessageCandidature(int id) {
		return messagecandidatureDAO.findById(id);
	}

	@Override
	public MessageOffredemploi getMessageOffreEmploi(int id) {
		return messageoffredemploiDAO.findById(id);
	}


}
