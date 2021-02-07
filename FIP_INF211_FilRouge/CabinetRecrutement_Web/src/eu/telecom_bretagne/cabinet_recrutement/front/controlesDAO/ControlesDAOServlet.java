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
import eu.telecom_bretagne.cabinet_recrutement.data.dao.NiveauqualificationDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.dao.SecteuractiviteDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.model.Candidature;
import eu.telecom_bretagne.cabinet_recrutement.data.model.Entreprise;
import eu.telecom_bretagne.cabinet_recrutement.data.model.NiveauQualification;
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

	out.println("-----------------------------------------------------------------------------");
	
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
    
    
  }
  
  
  //-----------------------------------------------------------------------------
  
  
  
  
}
