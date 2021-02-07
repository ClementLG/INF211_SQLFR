package eu.telecom_bretagne.cabinet_recrutement.front.controlesDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eu.telecom_bretagne.cabinet_recrutement.data.dao.CandidatureDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.dao.EntrepriseDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.dao.MessagecandidatureDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.dao.MessageoffredemploiDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.dao.NiveauqualificationDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.dao.OffreemploiDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.dao.SecteuractiviteDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.model.Candidature;
import eu.telecom_bretagne.cabinet_recrutement.data.model.Entreprise;
import eu.telecom_bretagne.cabinet_recrutement.data.model.MessageCandidature;
import eu.telecom_bretagne.cabinet_recrutement.data.model.MessageOffredemploi;
import eu.telecom_bretagne.cabinet_recrutement.data.model.NiveauQualification;
import eu.telecom_bretagne.cabinet_recrutement.data.model.OffreEmploi;
import eu.telecom_bretagne.cabinet_recrutement.data.model.SecteurActivite;
import eu.telecom_bretagne.cabinet_recrutement.front.utils.ServicesLocator;
import eu.telecom_bretagne.cabinet_recrutement.front.utils.ServicesLocatorException;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/ControlesDAO")
public class ControlesDAOServlet extends HttpServlet
{
  //-----------------------------------------------------------------------------
  private static final long serialVersionUID = 1L;
  //-----------------------------------------------------------------------------
  /**
   * @see HttpServlet#HttpServlet()
   */
  public ControlesDAOServlet()
  {
    super();
  }
  //-----------------------------------------------------------------------------
  /**
   * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
   */
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    // Flot de sortie pour écriture des résultats.
    PrintWriter out = response.getWriter();
    
 // -----------------ENTREPRISE------------------------------------------

    // Récupération de la réféence vers le(s) DAO(s)
    EntrepriseDAO entrepriseDAO = null;
    try
    {
      entrepriseDAO = (EntrepriseDAO) ServicesLocator.getInstance().getRemoteInterface("EntrepriseDAO");
    }
    catch (ServicesLocatorException e)
    {
      e.printStackTrace();
    }
    out.println("Contrôles de fonctionnement du DAO EntrepriseDAO");
    out.println();
    
    // Contrôle(s) de fonctionnalités.
    
    out.println("Liste des entreprises : ");
    List<Entreprise> entreprises = entrepriseDAO.findAll();
    for(Entreprise entreprise : entreprises)
    {
      out.println(entreprise.getNom());
    }
    out.println();
    
    out.println("Obtention de l'entreprise n° 1 :");
    Entreprise e = entrepriseDAO.findById(1);
    out.println(e.getId());
    out.println(e.getNom());
    out.println(e.getDescriptif());
    out.println(e.getAdressePostale());
    out.println();

    out.println("Obtention de l'entreprise n° 2 :");
    e = entrepriseDAO.findById(2);
    out.println(e.getId());
    out.println(e.getNom());
    out.println(e.getDescriptif());
    out.println(e.getAdressePostale());
    out.println();
    
	out.println("Obtention de l'entreprise n° 3 :");
	e = entrepriseDAO.findById(3);
	out.println(e.getId());
	out.println(e.getNom());
	out.println(e.getDescriptif());
	out.println(e.getAdressePostale());
	out.println();
	
	out.println("-----------------------------------------------------------------------------\n");
	
// -----------------CANDIDATURE------------------------------------------
	
	
	// Récupération de la référence vers le(s) DAO(s)
    CandidatureDAO candidatureDAO = null;
    try {
    	candidatureDAO = (CandidatureDAO) ServicesLocator.getInstance().getRemoteInterface("CandidatureDAO");
    } catch(ServicesLocatorException e1) {
    	e1.printStackTrace();
    }
    out.println("Contrôles de fonctionnement du DAO CandidatureDAO");
    out.println();

    // Contrôle(s) de fonctionnalités.
    out.println("Liste des candidatures :");
    List<Candidature> candidatures = candidatureDAO.findAll();

    for (Candidature candidature : candidatures) {
    	out.println(candidature.getCv());
    }
    out.println();

    out.println("Obtention de la candidature n° 1 :");
    Candidature c = candidatureDAO.findById(1);
    out.println(c.getId());
    out.println(c.getCv());
    out.println(c.getDatedepot());
    out.println(c.getAdresseemail());
    out.println(c.getDatenaissance());
    out.println(c.getAdressepostale());
    out.println(c.getNiveauqualificationBean().getIntitule());
    out.println();
    
    out.println("Obtention de la candidature n° 2 :");
    c = candidatureDAO.findById(2);
    out.println(c.getId());
    out.println(c.getCv());
    out.println(c.getDatedepot());
    out.println(c.getAdresseemail());
    out.println(c.getDatenaissance());
    out.println(c.getAdressepostale());
    out.println(c.getNiveauqualificationBean().getIntitule());
    out.println();
    
    out.println("Obtention de la candidature n° 3 :");
    c = candidatureDAO.findById(3);
    out.println(c.getId());
    out.println(c.getCv());
    out.println(c.getDatedepot());
    out.println(c.getAdresseemail());
    out.println(c.getDatenaissance());
    out.println(c.getAdressepostale());
    out.println(c.getNiveauqualificationBean().getIntitule());
    out.println();

	out.println("-----------------------------------------------------------------------------");
	
// ----------------- NIVEAU QUALIF------------------------------------------
	
	
	// Récupération de la référence vers le(s) DAO(s)
    NiveauqualificationDAO niveauqualificationDAO = null;
    try {
    	niveauqualificationDAO = (NiveauqualificationDAO) ServicesLocator.getInstance().getRemoteInterface("NiveauqualificationDAO");
    } catch(ServicesLocatorException e1) {
    	e1.printStackTrace();
    }
    out.println("Contrôles de fonctionnement du DAO NiveauqualificationDAO");
    out.println();
    
    // Contrôle(s) de fonctionnalités.
    out.println("Liste des niveauxqualifications :");
    List<NiveauQualification> niveauxqualifications = niveauqualificationDAO.findAll();

    for (NiveauQualification niveauqualification : niveauxqualifications) {
    	out.println(niveauqualification.getIntitule());
    }
    out.println();
    
    out.println("Obtention du niveauqualification n° 1 :");
    NiveauQualification nq = niveauqualificationDAO.findById(1);
    out.println(nq.getId());
    out.println(nq.getIntitule());
    out.println();
    
    out.println("Obtention du niveauqualification n° 2 :");
    nq = niveauqualificationDAO.findById(2);
    out.println(nq.getId());
    out.println(nq.getIntitule());
    out.println();
    
    out.println("Obtention du niveauqualification n° 3 :");
    nq = niveauqualificationDAO.findById(3);
    out.println(nq.getId());
    out.println(nq.getIntitule());
    out.println();

	out.println("-----------------------------------------------------------------------------");
	

// -----------------OFFRE EMPLOi------------------------------------------
	
	// Récupération de la référence vers le(s) DAO(s)
	out.println(); 
	OffreemploiDAO offreemploiDAO = null;
	try {
		offreemploiDAO = (OffreemploiDAO) ServicesLocator.getInstance().getRemoteInterface("OffreemploiDAO");
		
	} catch(ServicesLocatorException e1) {
		e1.printStackTrace();
	}
	try {
		out.println("Contrôles de fonctionnement du DAO OffreemploiDAO");
		out.println();  
	    
		// Contrôle(s) de fonctionnalités.
		out.println("Liste des offresemplois :");
		List<OffreEmploi> offresemplois = offreemploiDAO.findAll();

		for (OffreEmploi offreemploi : offresemplois) {
			offreemploi.getTitre();	
		}
		out.println();
		out.println("Obtention de l'offre n° 1 :");
	    OffreEmploi of = offreemploiDAO.findById(1);
	    out.println(of.getId());
	    out.println(of.getEntrepriseBean().getNom());
	    out.println(of.getDescriptifmission());
	    out.println(of.getProfilrecherche());
	    out.println(of.getNiveauQualificationBean().getIntitule());
	    out.println(of.getDatedepot());
	    out.println();
	    
	    out.println("Obtention de l'offre n° 2 :");
	    of = offreemploiDAO.findById(2);
	    out.println(of.getId());
	    out.println(of.getEntrepriseBean().getNom());
	    out.println(of.getDescriptifmission());
	    out.println(of.getProfilrecherche());
	    out.println(of.getNiveauQualificationBean().getIntitule());
	    out.println(of.getDatedepot());
	    out.println();
	    
	    out.println("Obtention de l'offre n° 3 :");
	    of = offreemploiDAO.findById(3);
	    out.println(of.getId());
	    out.println(of.getEntrepriseBean().getNom());
	    out.println(of.getDescriptifmission());
	    out.println(of.getProfilrecherche());
	    out.println(of.getNiveauQualificationBean().getIntitule());
	    out.println(of.getDatedepot());
	    out.println();
		
	} catch (Exception e2) {
		// TODO: handle exception
	}
	
	

	out.println("-----------------------------------------------------------------------------");
	

// -----------------Secteur Activité ------------------------------------------
	
	// Récupération de la référence vers le(s) DAO(s)
	out.println(); 
	SecteuractiviteDAO secteuractiviteDAO = null;
	try {
		secteuractiviteDAO = (SecteuractiviteDAO) ServicesLocator.getInstance().getRemoteInterface("SecteuractiviteDAO");
		out.println("Liste des secteurs d'activités :");
		List<SecteurActivite> secteursactivites = secteuractiviteDAO.findAll();

		for (SecteurActivite secteuractivite : secteursactivites) {
	out.println(secteuractivite.getIntitule());
		}
		out.println();
	} catch(ServicesLocatorException e1) {
		e1.printStackTrace();
	}


	out.println("-----------------------------------------------------------------------------");
	

// -----------------MSG CANDIDATURE------------------------------------------
	
	// Récupération de la référence vers le(s) DAO(s)
	MessagecandidatureDAO messagecandidatureDAO = null;
	out.println("Contrôles de fonctionnement du DAO MessagecandidatureDAO");
	try {
		messagecandidatureDAO = (MessagecandidatureDAO) ServicesLocator.getInstance().getRemoteInterface("MessagecandidatureDAO");
		
		
		
	} catch(ServicesLocatorException e1) {
		e1.printStackTrace();
	}
	
	try {
		// Contrôle(s) de fonctionnalités.
		out.println("Liste des messagescandidatures :");
		List<MessageCandidature> messagescandidatures = messagecandidatureDAO.findAll();

		for (MessageCandidature messagecandidature : messagescandidatures) {
			out.println(messagecandidature.getCorpsmessage());
		}
		out.println();
		out.println("Obtention de msg candi n° 1 :");		
		MessageCandidature mc = messagecandidatureDAO.findById(1);
		out.println(mc.getId());
		out.println(mc.getOffreEmploiBean().getTitre());
		out.println(mc.getCandidatureBean().getCv());
		out.println(mc.getDateenvoi());
		out.println(mc.getCorpsmessage());
		out.println();
		out.println("Obtention de msg candi n° 2:");		
		mc = messagecandidatureDAO.findById(2);
		out.println(mc.getId());
		out.println(mc.getOffreEmploiBean().getTitre());
		out.println(mc.getCandidatureBean().getCv());
		out.println(mc.getDateenvoi());
		out.println(mc.getCorpsmessage());
		out.println("Obtention de msg candi n° 3:");		
		mc = messagecandidatureDAO.findById(3);
		out.println(mc.getId());
		out.println(mc.getOffreEmploiBean().getTitre());
		out.println(mc.getCandidatureBean().getCv());
		out.println(mc.getDateenvoi());
		out.println(mc.getCorpsmessage());
		
	} catch (Exception e2) {
		// TODO: handle exception
	}
	


	out.println("-----------------------------------------------------------------------------");
	

// -----------------Msg Offreemploi------------------------------------------
	
	// Récupération de la référence vers le(s) DAO(s)
	MessageoffredemploiDAO messageoffredemploiDAO = null;
	try {
		messageoffredemploiDAO = (MessageoffredemploiDAO) ServicesLocator.getInstance().getRemoteInterface("MessageoffredemploiDAO");
	} catch(ServicesLocatorException e1) {
		e1.printStackTrace();
	}
	out.println("Contrôles de fonctionnement du DAO MessageoffredemploiDAO");
	out.println();
	
	// Contrôle(s) de fonctionnalités.
	out.println("Liste des messagesoffresdemplois :");
	List<MessageOffredemploi> messagesoffresdemplois = messageoffredemploiDAO.findAll();

	for (MessageOffredemploi messageoffredemploi : messagesoffresdemplois) {
		out.println(messageoffredemploi.getCorpsmessage());
	}
	out.println();

	out.println("Obtention du messageoffrecandidature n° 1 :");
	MessageOffredemploi mod = messageoffredemploiDAO.findById(1);
	out.println(mod.getId());
	out.println(mod.getCorpsmessage());
	out.println(mod.getDateenvoi());
	out.println(mod.getCandidatureBean().getCv());
	out.println(mod.getOffreEmploiBean().getTitre());
	out.println();
	
	out.println("Obtention du messageoffrecandidature n° 2 :");
	mod = messageoffredemploiDAO.findById(2);
	out.println(mod.getId());
	out.println(mod.getCorpsmessage());
	out.println(mod.getDateenvoi());
	out.println(mod.getCandidatureBean().getCv());
	out.println(mod.getOffreEmploiBean().getTitre());
	out.println();
	
	out.println("Obtention du messageoffrecandidature n° 3 :");
	mod = messageoffredemploiDAO.findById(3);
	out.println(mod.getId());
	out.println(mod.getCorpsmessage());
	out.println(mod.getDateenvoi());
	out.println(mod.getCandidatureBean().getCv());
	out.println(mod.getOffreEmploiBean().getTitre());
	out.println();
	
	
 }
  
  
 //-----------------------------------------------------------------------------
  
  
  
  
}
