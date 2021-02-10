package eu.telecom_bretagne.cabinet_recrutement.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebService;

import eu.telecom_bretagne.cabinet_recrutement.data.dao.EntrepriseDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.dao.OffreemploiDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.model.Entreprise;
import eu.telecom_bretagne.cabinet_recrutement.data.model.OffreEmploi;

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
  //-----------------------------------------------------------------------------
  @Override
  public int NbOffreByEntID(int idEnterprise)
  {
	int nb=9999;
	try {
		nb=offreemploiDAO.findOfferByEnterprise(idEnterprise).size();
		
	} catch (Exception e) {
		System.out.println("--------------------KASSE KASSE");
	}
	
    return nb;
  }
}
