package eu.telecom_bretagne.cabinet_recrutement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebService;

import eu.telecom_bretagne.cabinet_recrutement.data.dao.EntrepriseDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.dao.OffreemploiDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.model.Candidature;
import eu.telecom_bretagne.cabinet_recrutement.data.model.Entreprise;
import eu.telecom_bretagne.cabinet_recrutement.data.model.NiveauQualification;
import eu.telecom_bretagne.cabinet_recrutement.data.model.OffreEmploi;
import eu.telecom_bretagne.cabinet_recrutement.data.model.SecteurActivite;

/**
 * Session Bean implementation class ServiceEntreprise
 * @author Philippe TANGUY
 */
@Stateless
@LocalBean
public class ServiceOffreEmploi implements IServiceOffreEmploi
{
  //-----------------------------------------------------------------------------
  @EJB private OffreemploiDAO         offreemploiDAO;
  //-----------------------------------------------------------------------------
  /**
   * Default constructor.
   */
  public ServiceOffreEmploi()
  {
    // TODO Auto-generated constructor stub
  }
  //-----------------------------------------------------------------------------
  @Override
  public OffreEmploi getOffreEmploi(int id)
  {
    return offreemploiDAO.findById(id);
  }
  //-----------------------------------------------------------------------------
  @Override
  public List<OffreEmploi> listeOffreEmploi()
  {
    return offreemploiDAO.findAll();
  }
  //-----------------------------------------------------------------------------
  @Override
  public List<OffreEmploi> getEmploiBySectorAndNQ(Set<SecteurActivite> IDsSect, NiveauQualification idNQ)
  {
	  List<OffreEmploi> l = new ArrayList<>();
	  for(SecteurActivite s : IDsSect) {
		  System.out.println("--------------"+s.getId()+"--------"+idNQ.getId()+"---------------");
		  l.addAll(offreemploiDAO.findByActivitySector(s.getId(), idNQ.getId()));
	  }
    return l;
  }
//-----------------------------------------------------------------------------
  @Override
  public String GetSecteursString(OffreEmploi offres) {
	 String SecteursToString = "";
	 
	 try {
		 for (SecteurActivite secteurs_recup : offres.getSecteurActivites()) {
			 SecteursToString+=secteurs_recup.getIntitule()+"<br>";
			 //System.out.println(secteurs_recup.getIntitule());
         }			 
	 } catch (Exception e) {
		System.out.println("---------------- cassé get secteur acti ServiceOffresEmploi");
	}

	return SecteursToString;
  }
  //-----------------------------------------------------------------------------
  
}
