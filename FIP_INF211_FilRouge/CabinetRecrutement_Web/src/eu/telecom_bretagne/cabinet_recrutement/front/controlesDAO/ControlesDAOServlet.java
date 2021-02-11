package eu.telecom_bretagne.cabinet_recrutement.front.controlesDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Flot de sortie pour écriture des résultats.
		PrintWriter out = response.getWriter();

		// -----------------ENTREPRISE------------------------------------------

		// Récupération de la réféence vers le(s) DAO(s)
		EntrepriseDAO entrepriseDAO = null;
		try {
			entrepriseDAO = (EntrepriseDAO) ServicesLocator.getInstance().getRemoteInterface("EntrepriseDAO");
		} catch (ServicesLocatorException e) {
			e.printStackTrace();
		}
		out.println("Contrôles de fonctionnement du DAO EntrepriseDAO");
		out.println();

		try {
			// Contrôle(s) de fonctionnalités d'affichage
			out.println("Liste des entreprises : ");
			List<Entreprise> entreprises = entrepriseDAO.findAll();
			for (Entreprise entreprise : entreprises) {
				out.println(entreprise.getNom());
			}
			out.println();

			out.println("Obtention de l'entreprise n° 1 :");
			Entreprise e = entrepriseDAO.findById(1);
			out.println("Id : " + e.getId());
			out.println("Nom : " + e.getNom());
			out.println("Descriptif : " + e.getDescriptif());
			out.println("Adresse Postale : " + e.getAdressePostale());
			out.println();

			out.println("Obtention de l'entreprise n° 2 :");
			e = entrepriseDAO.findById(2);
			out.println("Id : " + e.getId());
			out.println("Nom : " + e.getNom());
			out.println("Descriptif : " + e.getDescriptif());
			out.println("Adresse Postale : " + e.getAdressePostale());
			out.println();

			out.println("Obtention de l'entreprise n° 3 :");
			e = entrepriseDAO.findById(3);
			out.println("Id : " + e.getId());
			out.println("Nom : " + e.getNom());
			out.println("Descriptif : " + e.getDescriptif());
			out.println("Adresse Postale : " + e.getAdressePostale());
			out.println();

			try {
				Entreprise ent_test = new Entreprise("42 rue du test", "Entreprise de Test", "TEST&CO");
				Entreprise ent_recup = null;
				int id_ent = 0;
				out.println("Ajout de l'entreprise de test");
				ent_test = entrepriseDAO.persist(ent_test);
				id_ent = ent_test.getId();

				ent_recup = entrepriseDAO.findById(id_ent);
				if ((ent_test.getId() == ent_recup.getId()) && (ent_test.getNom().equals(ent_recup.getNom()))
						&& (ent_test.getDescriptif().equals(ent_recup.getDescriptif()))
						&& (ent_test.getAdressePostale().equals(ent_recup.getAdressePostale()))
						/**&& (ent_test.getOffreemplois().equals(ent_recup.getOffreemplois()))*/) {
					out.println("Ajout et Recup OK");
				} else {
					out.println("Ajout et Recup KO");
				}
				out.println();

				out.println("Liste des entreprises : ");
				entreprises = entrepriseDAO.findAll();
				for (Entreprise entreprise : entreprises) {
					out.println(entreprise.getNom());
				}
				out.println();

				out.println("Modification de l'entreprise de test");
				ent_recup.setNom("TEST&COModif");
				entrepriseDAO.update(ent_recup);

				ent_recup = entrepriseDAO.findById(id_ent);
				if (ent_test.getNom() != ent_recup.getNom()) {
					out.println("Modif OK");
					out.println("Ancien Nom : " + ent_test.getNom());
					out.println("Nouveau Nom : " + ent_recup.getNom());
				} else {
					out.println("Modif KO");
					out.println("Ancien Nom : " + ent_test.getNom());
					out.println("Nouveau Nom : " + ent_recup.getNom());
				}
				out.println();

				out.println("Suppression de l'entreprise de test");
				entrepriseDAO.remove(ent_recup);

				if (entrepriseDAO.findById(id_ent) == null) {
					out.println("Suppression OK");
				} else {
					out.println("Suppression KO");
				}
				out.println();

				out.println("Liste des entreprises : ");
				entreprises = entrepriseDAO.findAll();
				for (Entreprise entreprise : entreprises) {
					out.println(entreprise.getNom());
				}
				out.println();

			} catch (Exception e_ajout) {
				// TODO Auto-generated catch block
				e_ajout.printStackTrace();
			}

		} catch (Exception e_tests) {
			// TODO Auto-generated catch block
			e_tests.printStackTrace();
		}

		out.println("-----------------------------------------------------------------------------\n");

		// ---------------------------- NIVEAU
		// QUALIFICATION------------------------------------------

		// Récupération de la référence vers le(s) DAO(s)
		NiveauqualificationDAO niveauqualificationDAO = null;
		try {
			niveauqualificationDAO = (NiveauqualificationDAO) ServicesLocator.getInstance()
					.getRemoteInterface("NiveauqualificationDAO");
		} catch (ServicesLocatorException e2) {
			e2.printStackTrace();
		}
		out.println("Contrôles de fonctionnement du DAO NiveauqualificationDAO");
		out.println();

		try {
			// Contrôle(s) de fonctionnalités.
			out.println("Liste des niveauxqualifications :");
			List<NiveauQualification> niveauxqualifications = niveauqualificationDAO.findAll();

			for (NiveauQualification niveauqualification : niveauxqualifications) {
				out.println(niveauqualification.getIntitule());
			}
			out.println();

			out.println("Obtention du niveauqualification n° 1 :");
			NiveauQualification nq = niveauqualificationDAO.findById(1);
			out.println("Id : " + nq.getId());
			out.println("Intitule : " + nq.getIntitule());
			out.println();

			out.println("Obtention du niveauqualification n° 2 :");
			nq = niveauqualificationDAO.findById(2);
			out.println("Id : " + nq.getId());
			out.println("Intitule : " + nq.getIntitule());
			out.println();

			out.println("Obtention du niveauqualification n° 3 :");
			nq = niveauqualificationDAO.findById(3);
			out.println("Id : " + nq.getId());
			out.println("Intitule : " + nq.getIntitule());
			out.println();
			
			try {
				NiveauQualification nq_test = new NiveauQualification("LE MEGA BREVET DES COLLEGES");
				NiveauQualification nq_recup = null;
				int id_ent = 0;
				out.println("Ajout du niveauqualification de test");
				nq_test = niveauqualificationDAO.persist(nq_test);
				id_ent = nq_test.getId();

				nq_recup = niveauqualificationDAO.findById(id_ent);
				if ((nq_test.getId() == nq_recup.getId()) && (nq_test.getIntitule().equals(nq_recup.getIntitule()))) {
					out.println("Ajout et Recup OK");
				} else {
					out.println("Ajout et Recup KO");
				}
				out.println();

				out.println("Liste des niveauxqualifications : ");
				niveauxqualifications = niveauqualificationDAO.findAll();
				for (NiveauQualification niveauqualification : niveauxqualifications) {
					out.println(niveauqualification.getIntitule());
				}
				out.println();

				out.println("Modification du niveauqualification de test");
				nq_recup.setIntitule("LE DNB");
				niveauqualificationDAO.update(nq_recup);

				nq_recup = niveauqualificationDAO.findById(id_ent);
				if (nq_test.getIntitule() != nq_recup.getIntitule()) {
					out.println("Modif OK");
					out.println("Ancien Intitule : " + nq_test.getIntitule());
					out.println("Nouveau Intitule : " + nq_recup.getIntitule());
				} else {
					out.println("Modif KO");
					out.println("Ancien Intitule : " + nq_test.getIntitule());
					out.println("Nouveau Intitule : " + nq_recup.getIntitule());
				}
				out.println();

				out.println("Suppression du niveauqualification de test");
				niveauqualificationDAO.remove(nq_recup);

				if (niveauqualificationDAO.findById(id_ent) == null) {
					out.println("Suppression OK");
				} else {
					out.println("Suppression KO");
				}
				out.println();

				out.println("Liste des niveauxqualifications : ");
				niveauxqualifications = niveauqualificationDAO.findAll();
				for (NiveauQualification niveauqualification : niveauxqualifications) {
					out.println(niveauqualification.getIntitule());
				}
				out.println();

			} catch (Exception e_ajout_2) {
				// TODO Auto-generated catch block
				e_ajout_2.printStackTrace();
			}
			
			
		} catch (Exception e_tests_2) {
			// TODO Auto-generated catch block
			e_tests_2.printStackTrace();
		}

		out.println("-----------------------------------------------------------------------------");

		// -----------------------------------CANDIDATURE------------------------------------------

		// Récupération de la référence vers le(s) DAO(s)
		CandidatureDAO candidatureDAO = null;
		try {
			candidatureDAO = (CandidatureDAO) ServicesLocator.getInstance().getRemoteInterface("CandidatureDAO");
		} catch (ServicesLocatorException e1) {
			e1.printStackTrace();
		}
		out.println("Contrôles de fonctionnement du DAO CandidatureDAO");
		out.println();

		try {
			// Contrôle(s) de fonctionnalités.
			out.println("Liste des candidatures :");
			List<Candidature> candidatures = candidatureDAO.findAll();

			for (Candidature candidature : candidatures) {
				out.println(candidature.getCv());
			}
			out.println();

			out.println("Obtention de la candidature n° 1 :");
			Candidature c = candidatureDAO.findById(1);
			out.println("Id : " + c.getId());
			out.println("Cv : " + c.getCv());
			out.println("Date de Depot : " + c.getDatedepot());
			out.println("Adresse Mail : " + c.getAdresseemail());
			out.println("Date de Naissance : " + c.getDatenaissance());
			out.println("Adresse Postale : " + c.getAdressepostale());
			out.println("Niveau Qualification : " + c.getNiveauqualificationBean().getIntitule());
			out.println();

			out.println("Obtention de la candidature n° 2 :");
			c = candidatureDAO.findById(2);
			out.println("Id : " + c.getId());
			out.println("Cv : " + c.getCv());
			out.println("Date de Depot : " + c.getDatedepot());
			out.println("Adresse Mail : " + c.getAdresseemail());
			out.println("Date de Naissance : " + c.getDatenaissance());
			out.println("Adresse Postale : " + c.getAdressepostale());
			out.println("Niveau Qualification : " + c.getNiveauqualificationBean().getIntitule());
			out.println();

			out.println("Obtention de la candidature n° 3 :");
			c = candidatureDAO.findById(3);
			out.println("Id : " + c.getId());
			out.println("Cv : " + c.getCv());
			out.println("Date de Depot : " + c.getDatedepot());
			out.println("Adresse Mail : " + c.getAdresseemail());
			out.println("Date de Naissance : " + c.getDatenaissance());
			out.println("Adresse Postale : " + c.getAdressepostale());
			out.println("Niveau Qualification : " + c.getNiveauqualificationBean().getIntitule());
			out.println();

			try {
				String s_datenaissance = "23/05/1998";
				Date datenaissance = new SimpleDateFormat("dd/MM/yyyy").parse(s_datenaissance);
				s_datenaissance = "11/03/2021";
				Date datedepot = new SimpleDateFormat("dd/MM/yyyy").parse(s_datenaissance);
				Candidature cand_test = new Candidature("Florianelanesse@gmail.com", "Carquefou", "CV trop lourd",
						datedepot, datenaissance, niveauqualificationDAO.findById(1));
				Candidature cand_recup = null;
				int id_cand = 0;
				out.println("Ajout de la candidature de test");
				cand_test = candidatureDAO.persist(cand_test);
				out.println();
				id_cand = cand_test.getId();
				cand_recup = candidatureDAO.findById(id_cand);
				out.println();
				if ((cand_test.getId() == cand_recup.getId())
						&& (cand_test.getAdresseemail().equals(cand_recup.getAdresseemail()))
						&& (cand_test.getCv().equals(cand_recup.getCv()))
						&& (cand_test.getAdressepostale().equals(cand_recup.getAdressepostale()))
						&& (cand_test.getDatenaissance().equals(cand_recup.getDatenaissance()))
						&& (cand_test.getDatedepot().equals(cand_recup.getDatedepot()))
						&& (cand_test.getNiveauqualificationBean().getId().equals(cand_recup.getNiveauqualificationBean().getId()))) {
					out.println("Ajout et Recup OK");
				} else {
					out.println("Ajout et Recup KO");
				}
				out.println();

				out.println("Liste des Candidatures : ");
				candidatures = candidatureDAO.findAll();
				for (Candidature candidature : candidatures) {
					out.println(candidature.getCv());
				}
				out.println();

				out.println("Modification de la candidature de test");
				cand_recup.setCv("CV pas si lourd en fait");
				candidatureDAO.update(cand_recup);

				cand_recup = candidatureDAO.findById(id_cand);
				if (cand_test.getCv() != cand_recup.getCv()) {
					out.println("Modif OK");
					out.println("Ancien CV : " + cand_test.getCv());
					out.println("Nouveau CV : " + cand_recup.getCv());
				} else {
					out.println("Modif KO");
					out.println("Ancien CV : " + cand_test.getCv());
					out.println("Nouveau CV : " + cand_recup.getCv());
				}
				out.println();
				
				out.println("Affichage par Secteur Activité et Niveau Qualif (Informatique et Bac+4) ");
				List<Candidature> list_test = candidatureDAO.findByActivitySector(19, 4);
				for (Candidature candidature : list_test) {
					out.println(candidature.getCv());
				}
				out.println();

				out.println("Suppression de la Candidature de test");
				candidatureDAO.remove(cand_recup);

				if (candidatureDAO.findById(id_cand) == null) {
					out.println("Suppression OK");
				} else {
					out.println("Suppression KO");
				}
				out.println();

				out.println("Liste des Candidatures : ");
				candidatures = candidatureDAO.findAll();
				for (Candidature candidature : candidatures) {
					out.println(candidature.getCv());
				}
				out.println();

			} catch (Exception e_ajout_1) {
				// TODO Auto-generated catch block
				e_ajout_1.printStackTrace();
			}

		} catch (Exception e_tests_1) {
			// TODO Auto-generated catch block
			e_tests_1.printStackTrace();
		}

		out.println("-----------------------------------------------------------------------------");

		// -----------------OFFRE EMPLOi------------------------------------------

		// Récupération de la référence vers le(s) DAO(s)
		out.println();
		OffreemploiDAO offreemploiDAO = null;
		try {
			offreemploiDAO = (OffreemploiDAO) ServicesLocator.getInstance().getRemoteInterface("OffreemploiDAO");

		} catch (ServicesLocatorException e3) {
			e3.printStackTrace();
		}

		out.println("Contrôles de fonctionnement du DAO OffreemploiDAO");
		out.println();

		try {
			// Contrôle(s) de fonctionnalités.
			out.println("Liste des offresemplois :");
			List<OffreEmploi> offresemplois = offreemploiDAO.findAll();

			for (OffreEmploi offreemploi : offresemplois) {
				out.println(offreemploi.getTitre());
			}
			out.println();
			out.println("Obtention de l'offre n° 1 :");
			OffreEmploi of = offreemploiDAO.findById(1);
			out.println("Id : " + of.getId());
			out.println("Entreprise : " + of.getEntrepriseBean().getNom());
			out.println("Descriptif Mission : " + of.getDescriptifmission());
			out.println("Profil Recherche : " + of.getProfilrecherche());
			out.println("Niveau Qualification : " + of.getNiveauQualificationBean().getIntitule());
			out.println("Date de Depot : " + of.getDatedepot());
			out.println();

			out.println("Obtention de l'offre n° 2 :");
			of = offreemploiDAO.findById(2);
			out.println("Id : " + of.getId());
			out.println("Entreprise : " + of.getEntrepriseBean().getNom());
			out.println("Descriptif Mission : " + of.getDescriptifmission());
			out.println("Profil Recherche : " + of.getProfilrecherche());
			out.println("Niveau Qualification : " + of.getNiveauQualificationBean().getIntitule());
			out.println("Date de Depot : " + of.getDatedepot());
			out.println();

			out.println("Obtention de l'offre n° 3 :");
			of = offreemploiDAO.findById(3);
			out.println("Id : " + of.getId());
			out.println("Entreprise : " + of.getEntrepriseBean().getNom());
			out.println("Descriptif Mission : " + of.getDescriptifmission());
			out.println("Profil Recherche : " + of.getProfilrecherche());
			out.println("Niveau Qualification : " + of.getNiveauQualificationBean().getIntitule());
			out.println("Date de Depot : " + of.getDatedepot());
			out.println();
		} catch (Exception e_tests_3) {
			// TODO Auto-generated catch block
			e_tests_3.printStackTrace();
		}

		out.println("-----------------------------------------------------------------------------");

		// -------------------------SECTEUR ACTIVITE------------------------------
		// Récupération de la référence vers le(s) DAO(s)
		SecteuractiviteDAO secteuractiviteDAO = null;
		try {
			secteuractiviteDAO = (SecteuractiviteDAO) ServicesLocator.getInstance()
					.getRemoteInterface("SecteuractiviteDAO");
		} catch (ServicesLocatorException e4) {
			e4.printStackTrace();
		}
		out.println("Contrôles de fonctionnement du DAO SecteuractiviteDAO");
		out.println();

		try {
			// Contrôle(s) de fonctionnalités.
			out.println("Liste des secteursactivites :");
			List<SecteurActivite> secteursactivites = secteuractiviteDAO.findAll();

			for (SecteurActivite secteuractivite : secteursactivites) {
				out.println(secteuractivite.getIntitule());
			}
			out.println();

			out.println("Obtention du secteuractivite n° 1 :");
			SecteurActivite sa = secteuractiviteDAO.findById(1);
			out.println("Id : " + sa.getId());
			out.println("Intitule : " + sa.getIntitule());
			out.println();

			out.println("Obtention du secteuractivite n° 2 :");
			sa = secteuractiviteDAO.findById(2);
			out.println("Id : " + sa.getId());
			out.println("Intitule : " + sa.getIntitule());
			out.println();

			out.println("Obtention du secteuractivite n° 3 :");
			sa = secteuractiviteDAO.findById(3);
			out.println("Id : " + sa.getId());
			out.println("Intitule : " + sa.getIntitule());
			out.println();
		} catch (Exception e_tests_4) {
			// TODO Auto-generated catch block
			e_tests_4.printStackTrace();
		}

		out.println("-----------------------------------------------------------------------------");

		// ----------------------MSG CANDIDATURE------------------------------
		// Récupération de la référence vers le(s) DAO(s)
		MessagecandidatureDAO messagecandidatureDAO = null;
		try {
			messagecandidatureDAO = (MessagecandidatureDAO) ServicesLocator.getInstance()
					.getRemoteInterface("MessagecandidatureDAO");
		} catch (ServicesLocatorException e5) {
			e5.printStackTrace();
		}
		out.println("Contrôles de fonctionnement du DAO MessagecandidatureDAO");
		out.println();

		try {
			// Contrôle(s) de fonctionnalités.
			out.println("Liste des messagescandidatures :");
			List<MessageCandidature> messagescandidatures = messagecandidatureDAO.findAll();

			for (MessageCandidature messagecandidature : messagescandidatures) {
				out.println(messagecandidature.getCorpsmessage());
			}
			out.println();

			out.println("Obtention du messagecandidature n° 1 :");
			MessageCandidature mc = messagecandidatureDAO.findById(1);
			out.println("Id : " + mc.getId());
			out.println("Corps Message : " + mc.getCorpsmessage());
			out.println("Date d'Envoi : " + mc.getDateenvoi());
			out.println("Cv : " + mc.getCandidatureBean().getCv());
			out.println("Offre Emploi : " + mc.getOffreEmploiBean().getTitre());
			out.println();

			out.println("Obtention du messagecandidature n° 2 :");
			mc = messagecandidatureDAO.findById(2);
			out.println("Id : " + mc.getId());
			out.println("Corps Message : " + mc.getCorpsmessage());
			out.println("Date d'Envoi : " + mc.getDateenvoi());
			out.println("Cv : " + mc.getCandidatureBean().getCv());
			out.println("Offre Emploi : " + mc.getOffreEmploiBean().getTitre());
			out.println();

			out.println("Obtention du messagecandidature n° 3 :");
			mc = messagecandidatureDAO.findById(3);
			out.println("Id : " + mc.getId());
			out.println("Corps Message : " + mc.getCorpsmessage());
			out.println("Date d'Envoi : " + mc.getDateenvoi());
			out.println("Cv : " + mc.getCandidatureBean().getCv());
			out.println("Offre Emploi : " + mc.getOffreEmploiBean().getTitre());
			out.println();
		} catch (Exception e_tests_5) {
			// TODO Auto-generated catch block
			e_tests_5.printStackTrace();
		}

		out.println("-----------------------------------------------------------------------------");

		// ----------------------MSG OFFREEMPLOI---------------------------------
		// Récupération de la référence vers le(s) DAO(s)
		MessageoffredemploiDAO messageoffredemploiDAO = null;
		try {
			messageoffredemploiDAO = (MessageoffredemploiDAO) ServicesLocator.getInstance()
					.getRemoteInterface("MessageoffredemploiDAO");
		} catch (ServicesLocatorException e6) {
			e6.printStackTrace();
		}
		out.println("Contrôles de fonctionnement du DAO MessageoffredemploiDAO");
		out.println();

		try {
			// Contrôle(s) de fonctionnalités.
			out.println("Liste des messagesoffresdemplois :");
			List<MessageOffredemploi> messagesoffresdemplois = messageoffredemploiDAO.findAll();

			for (MessageOffredemploi messageoffredemploi : messagesoffresdemplois) {
				out.println(messageoffredemploi.getCorpsmessage());
			}
			out.println();

			out.println("Obtention du messageoffredemploi n° 1 :");
			MessageOffredemploi mod = messageoffredemploiDAO.findById(1);
			out.println("Id : " + mod.getId());
			out.println("Corps Message : " + mod.getCorpsmessage());
			out.println("Date d'Envoi : " + mod.getDateenvoi());
			out.println("Cv : " + mod.getCandidatureBean().getCv());
			out.println("Offre Emploi : " + mod.getOffreEmploiBean().getTitre());
			out.println();

			out.println("Obtention du messageoffredemploi n° 2 :");
			mod = messageoffredemploiDAO.findById(2);
			out.println("Id : " + mod.getId());
			out.println("Corps Message : " + mod.getCorpsmessage());
			out.println("Date d'Envoi : " + mod.getDateenvoi());
			out.println("Cv : " + mod.getCandidatureBean().getCv());
			out.println("Offre Emploi : " + mod.getOffreEmploiBean().getTitre());
			out.println();

			out.println("Obtention du messageoffredemploi n° 3 :");
			mod = messageoffredemploiDAO.findById(3);
			out.println("Id : " + mod.getId());
			out.println("Corps Message : " + mod.getCorpsmessage());
			out.println("Date d'Envoi : " + mod.getDateenvoi());
			out.println("Cv : " + mod.getCandidatureBean().getCv());
			out.println("Offre Emploi : " + mod.getOffreEmploiBean().getTitre());
			out.println();
		} catch (Exception e_tests_6) {
			// TODO Auto-generated catch block
			e_tests_6.printStackTrace();
		}
	}

}