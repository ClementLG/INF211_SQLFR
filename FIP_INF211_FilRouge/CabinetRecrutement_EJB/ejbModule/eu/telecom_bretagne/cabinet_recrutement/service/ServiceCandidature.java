package eu.telecom_bretagne.cabinet_recrutement.service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import eu.telecom_bretagne.cabinet_recrutement.data.dao.CandidatureDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.dao.MessagecandidatureDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.dao.MessageoffredemploiDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.dao.NiveauqualificationDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.dao.OffreemploiDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.dao.SecteuractiviteDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.model.Candidature;
import eu.telecom_bretagne.cabinet_recrutement.data.model.MessageCandidature;
import eu.telecom_bretagne.cabinet_recrutement.data.model.MessageOffredemploi;
import eu.telecom_bretagne.cabinet_recrutement.data.model.NiveauQualification;
import eu.telecom_bretagne.cabinet_recrutement.data.model.OffreEmploi;
import eu.telecom_bretagne.cabinet_recrutement.data.model.SecteurActivite;

/**
 * Session Bean implementation class ServiceEntreprise
 * @author Elouan LE DUC
 * @author Clement LE GRUIEC
 * 
 */
@Stateless
@LocalBean
public class ServiceCandidature extends ServicesGeneriques implements IServiceCandidature
{
	//-----------------------------------------------------------------------------
	@EJB private CandidatureDAO         candidatureDAO;
	@EJB private OffreemploiDAO         offreemploiDAO;
	@EJB private NiveauqualificationDAO         niveauqualificationDAO;
	@EJB private SecteuractiviteDAO         secteuractiviteDAO;
	@EJB private MessagecandidatureDAO         messagecandidatureDAO;
	@EJB private MessageoffredemploiDAO         messageoffredemploiDAO;
	//-----------------------------------------------------------------------------
	/**
	 * 
	 * Default constructor.
	 */
	public ServiceCandidature()
	{
		// TODO Auto-generated constructor stub
	}
	//-----------------------------------------------------------------------------
	@Override
	public Candidature getCandidature(int id)
	{
		return candidatureDAO.findById(id);
	}
	//-----------------------------------------------------------------------------
	@Override
	public List<Candidature> listeCandidature()
	{
		return candidatureDAO.findAll();
	}
	//-----------------------------------------------------------------------------
	@Override
	public NiveauQualification findNQByID(Integer id)
	{
		return niveauqualificationDAO.findById(id);
	}

	//-----------------------------------------------------------------------------

	@Override
	public String GetSecteursString(Candidature cand) {
		String SecteursToString = "";

		try {
			for (SecteurActivite secteurs_recup : cand.getSecteurActivites()) {
				SecteursToString+=secteurs_recup.getIntitule()+"<br>";
				//System.out.println(secteurs_recup.getIntitule());
			}			 
		} catch (Exception e) {
			System.out.println("---------------- cassé get secteur acti ServiceCandidature");
		}

		return SecteursToString;
	}

	//-----------------------------------------------------------------------------
	public Candidature execPersist(Candidature candidature) {
		Candidature c = candidatureDAO.persist(candidature);
		return c;
	}

	//-----------------------------------------------------------------------------
	public Candidature execUpdate(Candidature candidature) {
		Candidature c = candidatureDAO.update(candidature);
		return c;
	}

	//-----------------------------------------------------------------------------
	public void majSecteursActivites(String[] sects, int idC) {
		SecteurActivite s;
		Candidature c;
		c = candidatureDAO.findById(idC);
		//System.out.println("-------------> idC = "+idC);
		for(String sect : sects) {
			try {
				s = secteuractiviteDAO.findById(Integer.parseInt(sect));
				s.getCandidatures().add(c);
				secteuractiviteDAO.update(s);
				c.getSecteurActivites().add(s);
				candidatureDAO.update(c);	
			} catch (Exception e) {
				System.out.println("---------------> majDuSecteurDansCandErreur");
			}


		}
	}
	//-----------------------------------------------------------------------------
	public Candidature RAZsecteurs(int idC) {
		 Candidature c = candidatureDAO.findById(idC);
		 Set<SecteurActivite> sas = c.getSecteurActivites();
		 try {
			 for(SecteurActivite sa : sas) {
				 System.out.println("rm-----"+sa.getIntitule());
				 sa.getCandidatures().remove(c);
				 secteuractiviteDAO.update(sa);
			 }
			 
			 c.getSecteurActivites().clear();
			 c=candidatureDAO.update(c);
			
		} catch (Exception e) {
			System.out.println("RAZ cassé");
			System.out.println(e);
		}
		 return c;
		 
	}
	//-----------------------------------------------------------------------------
	public Set<SecteurActivite> transformSecteurs(String[] sect) {
		//System.out.println(sect[0]+""+sect[1]);
		Set<SecteurActivite> mySet = new HashSet<SecteurActivite>();
		for (String s : sect) {
			mySet.add(secteuractiviteDAO.findById(Integer.parseInt(s)));
			//System.out.println(secteuractiviteDAO.findById(Integer.parseInt(sect[i])).getIntitule());
		}
		return mySet;
	}
	//-----------------------------------------------------------------------------
	public Boolean doesSectorExist(Set<SecteurActivite> sects, int id) {
		for(SecteurActivite s : sects) {
			if(s.getId()==id) {
				return true;
			}
		}
		return false;
	}
	
	//-----------------------------------------------------------------------------
	public void supressionDuneCandidature(Candidature c) {
		try {
			//suppression des messages candidatures
			for(MessageCandidature msgC : c.getMessageCandidatures()) {
				msgC.getOffreEmploiBean().removeMessageCandidature(msgC);
				offreemploiDAO.update(msgC.getOffreEmploiBean());
				messagecandidatureDAO.remove(msgC);
			}
			System.out.println("---------------ok 1 ");
			//suppression des messages offresEmplois
			for(MessageOffredemploi msgOF : c.getMessageOffredemplois()) {
				msgOF.getOffreEmploiBean().removeMessageOffredemploi(msgOF);
				messageoffredemploiDAO.remove(msgOF);
			}
			System.out.println("---------------ok 2 ");
			//suppression dans les secteur activite
			c.getNiveauQualificationBean().removeCandidature(c);
			System.out.println("---------------ok 3 ");
			//suppression dans le niveau qualification
			for (SecteurActivite sa : c.getSecteurActivites()) {
				if(c != null) sa.getCandidatures().remove(c);
			}
			System.out.println("---------------ok 4 ");
			//suppression des messages offresEmplois
			candidatureDAO.remove(c);
			System.out.println("---------------ok 5 ");

		} catch (Exception e) {
			
			System.out.println("--------suppression candidature kassé");
			System.out.println(e);
		}

	}
}
