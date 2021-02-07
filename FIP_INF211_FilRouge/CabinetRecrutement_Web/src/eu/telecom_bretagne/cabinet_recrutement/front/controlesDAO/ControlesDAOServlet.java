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
public class ControlesDAOServlet extends HttpServlet {
	// -----------------------------------------------------------------------------
	private static final long serialVersionUID = 1L;

	// -----------------------------------------------------------------------------
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControlesDAOServlet() {
		super();
	}

	// -----------------------------------------------------------------------------
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Flot de sortie pour écriture des résultats.
		PrintWriter out = response.getWriter();

		// Récupération de la réféence vers le(s) DAO(s)
		EntrepriseDAO entrepriseDAO = null;
		try {
			entrepriseDAO = (EntrepriseDAO) ServicesLocator.getInstance().getRemoteInterface("EntrepriseDAO");
		} catch (ServicesLocatorException e) {
			e.printStackTrace();
		}
		out.println("Contrôles de fonctionnement du DAO EntrepriseDAO");
		out.println();

		// Contrôle(s) de fonctionnalités.

		out.println("Liste des entreprises :");
		List<Entreprise> entreprises = entrepriseDAO.findAll();

		for (Entreprise entreprise : entreprises) {
			out.println(entreprise.getNom());
		}
		out.println();

		out.println("Obtention de l'entreprise n° 1 :");
		Entreprise e = entrepriseDAO.findById(1);
		out.println(e.getId());
		out.println(e.getNom());
		out.println(e.getDescriptif());
		out.println(e.getAdressePostale());
		out.println(e.getOffreemplois());
		out.println();

		out.println("Obtention de l'entreprise n° 2 :");
		e = entrepriseDAO.findById(2);
		out.println(e.getId());
		out.println(e.getNom());
		out.println(e.getDescriptif());
		out.println(e.getAdressePostale());
		out.println(e.getOffreemplois());
		out.println();
		
		out.println("Obtention de l'entreprise n° 3 :");
		e = entrepriseDAO.findById(3);
		out.println(e.getId());
		out.println(e.getNom());
		out.println(e.getDescriptif());
		out.println(e.getAdressePostale());
		out.println(e.getOffreemplois());
		out.println();
		
		// -----------------------------------------------------------------------------
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
		out.println(c.getNiveauqualificationBean());
		out.println(c.getMessagecandidatures());
		out.println(c.getMessageoffredemplois());
		out.println(c.getSecteuractivites());
		out.println();
		
		out.println("Obtention de la candidature n° 2 :");
		c = candidatureDAO.findById(2);
		out.println(c.getId());
		out.println(c.getCv());
		out.println(c.getDatedepot());
		out.println(c.getAdresseemail());
		out.println(c.getDatenaissance());
		out.println(c.getAdressepostale());
		out.println(c.getNiveauqualificationBean());
		out.println(c.getMessagecandidatures());
		out.println(c.getMessageoffredemplois());
		out.println(c.getSecteuractivites());
		out.println();
		
		out.println("Obtention de la candidature n° 3 :");
		c = candidatureDAO.findById(3);
		out.println(c.getId());
		out.println(c.getCv());
		out.println(c.getDatedepot());
		out.println(c.getAdresseemail());
		out.println(c.getDatenaissance());
		out.println(c.getAdressepostale());
		out.println(c.getNiveauqualificationBean());
		out.println(c.getMessagecandidatures());
		out.println(c.getMessageoffredemplois());
		out.println(c.getSecteuractivites());
		out.println();
		
		// -----------------------------------------------------------------------------
		// Récupération de la référence vers le(s) DAO(s)
		MessagecandidatureDAO messagecandidatureDAO = null;
		try {
			messagecandidatureDAO = (MessagecandidatureDAO) ServicesLocator.getInstance().getRemoteInterface("MessagecandidatureDAO");
		} catch(ServicesLocatorException e1) {
			e1.printStackTrace();
		}
		out.println("Contrôles de fonctionnement du DAO MessagecandidatureDAO");
		out.println();
		
		// Contrôle(s) de fonctionnalités.
		out.println("Liste des messagescandidatures :");
		List<MessageCandidature> messagescandidatures = messagecandidatureDAO.findAll();

		for (MessageCandidature messagecandidature : messagescandidatures) {
			out.println(messagecandidature.getCorpsmessage());
		}
		out.println();

		out.println("Obtention du messagecandidature n° 1 :");
		MessageCandidature mc = messagecandidatureDAO.findById(1);
		out.println(mc.getId());
		out.println(mc.getCorpsmessage());
		out.println(mc.getDateenvoi());
		out.println(mc.getCandidatureBean());
		out.println(mc.getOffreEmploiBean());
		out.println();
		
		out.println("Obtention du messagecandidature n° 2 :");
		mc = messagecandidatureDAO.findById(2);
		out.println(mc.getId());
		out.println(mc.getCorpsmessage());
		out.println(mc.getDateenvoi());
		out.println(mc.getCandidatureBean());
		out.println(mc.getOffreEmploiBean());
		out.println();
		
		out.println("Obtention du messagecandidature n° 3 :");
		mc = messagecandidatureDAO.findById(3);
		out.println(mc.getId());
		out.println(mc.getCorpsmessage());
		out.println(mc.getDateenvoi());
		out.println(mc.getCandidatureBean());
		out.println(mc.getOffreEmploiBean());
		out.println();
		
		// -----------------------------------------------------------------------------
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
		out.println(mod.getCandidatureBean());
		out.println(mod.getOffreEmploiBean());
		out.println();
		
		out.println("Obtention du messageoffrecandidature n° 2 :");
		mod = messageoffredemploiDAO.findById(2);
		out.println(mod.getId());
		out.println(mod.getCorpsmessage());
		out.println(mod.getDateenvoi());
		out.println(mod.getCandidatureBean());
		out.println(mod.getOffreEmploiBean());
		out.println();
		
		out.println("Obtention du messageoffrecandidature n° 3 :");
		mod = messageoffredemploiDAO.findById(3);
		out.println(mod.getId());
		out.println(mod.getCorpsmessage());
		out.println(mod.getDateenvoi());
		out.println(mod.getCandidatureBean());
		out.println(mod.getOffreEmploiBean());
		out.println();
		
		// -----------------------------------------------------------------------------
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
		out.println(nq.getCandidatures());
		out.println(nq.getOffreEmplois());
		out.println();
		
		out.println("Obtention du niveauqualification n° 2 :");
		nq = niveauqualificationDAO.findById(2);
		out.println(nq.getId());
		out.println(nq.getIntitule());
		out.println(nq.getCandidatures());
		out.println(nq.getOffreEmplois());
		out.println();
		
		out.println("Obtention du niveauqualification n° 3 :");
		nq = niveauqualificationDAO.findById(3);
		out.println(nq.getId());
		out.println(nq.getIntitule());
		out.println(nq.getCandidatures());
		out.println(nq.getOffreEmplois());
		out.println();
		
		// -----------------------------------------------------------------------------
		// Récupération de la référence vers le(s) DAO(s)
		OffreemploiDAO offreemploiDAO = null;
		try {
			offreemploiDAO = (OffreemploiDAO) ServicesLocator.getInstance().getRemoteInterface("OffreemploiDAO");
		} catch(ServicesLocatorException e1) {
			e1.printStackTrace();
		}
		out.println("Contrôles de fonctionnement du DAO OffreemploiDAO");
		out.println();
		
		// Contrôle(s) de fonctionnalités.
		out.println("Liste des offresemplois :");
		List<OffreEmploi> offresemplois = offreemploiDAO.findAll();

		for (OffreEmploi offreemploi : offresemplois) {
			out.println(offreemploi.getTitre());
		}
		out.println();
		
		out.println("Obtention de l'offreemploi n° 1 :");
		OffreEmploi oe = offreemploiDAO.findById(1);
		out.println(oe.getId());
		out.println(oe.getTitre());
		out.println(oe.getDescriptifmission());
		out.println(oe.getProfilrecherche());
		out.println(oe.getDatedepot());
		out.println(oe.getEntrepriseBean());
		out.println(oe.getNiveauQualificationBean());
		out.println(oe.getMessageCandidatures());
		out.println(oe.getMessageOffredemplois());
		out.println(oe.getSecteurActivites());
		out.println();
		
		out.println("Obtention de l'offreemploi n° 2 :");
		oe = offreemploiDAO.findById(2);
		out.println(oe.getId());
		out.println(oe.getTitre());
		out.println(oe.getDescriptifmission());
		out.println(oe.getProfilrecherche());
		out.println(oe.getDatedepot());
		out.println(oe.getEntrepriseBean());
		out.println(oe.getNiveauQualificationBean());
		out.println(oe.getMessageCandidatures());
		out.println(oe.getMessageOffredemplois());
		out.println(oe.getSecteurActivites());
		out.println();
		
		out.println("Obtention de l'offreemploi n° 3 :");
		oe = offreemploiDAO.findById(3);
		out.println(oe.getId());
		out.println(oe.getTitre());
		out.println(oe.getDescriptifmission());
		out.println(oe.getProfilrecherche());
		out.println(oe.getDatedepot());
		out.println(oe.getEntrepriseBean());
		out.println(oe.getNiveauQualificationBean());
		out.println(oe.getMessageCandidatures());
		out.println(oe.getMessageOffredemplois());
		out.println(oe.getSecteurActivites());
		out.println();
		
		// -----------------------------------------------------------------------------
		// Récupération de la référence vers le(s) DAO(s)
		SecteuractiviteDAO secteuractiviteDAO = null;
		try {
			secteuractiviteDAO = (SecteuractiviteDAO) ServicesLocator.getInstance().getRemoteInterface("SecteuractiviteDAO");
		} catch(ServicesLocatorException e1) {
			e1.printStackTrace();
		}
		out.println("Contrôles de fonctionnement du DAO SecteuractiviteDAO");
		out.println();
		
		// Contrôle(s) de fonctionnalités.
		out.println("Liste des secteursactivites :");
		List<SecteurActivite> secteursactivites = secteuractiviteDAO.findAll();

		for (SecteurActivite secteuractivite : secteursactivites) {
			out.println(secteuractivite.getIntitule());
		}
		out.println();
		
		out.println("Obtention du secteuractivite n° 1 :");
		SecteurActivite sa = secteuractiviteDAO.findById(1);
		out.println(sa.getId());
		out.println(sa.getIntitule());
		out.println(sa.getCandidatures());
		out.println(sa.getOffreEmplois());
		out.println();
		
		out.println("Obtention du secteuractivite n° 2 :");
		sa = secteuractiviteDAO.findById(2);
		out.println(sa.getId());
		out.println(sa.getIntitule());
		out.println(sa.getCandidatures());
		out.println(sa.getOffreEmplois());
		out.println();
		
		out.println("Obtention du secteuractivite n° 3 :");
		sa = secteuractiviteDAO.findById(3);
		out.println(sa.getId());
		out.println(sa.getIntitule());
		out.println(sa.getCandidatures());
		out.println(sa.getOffreEmplois());
		out.println();
		
	}

	

}
