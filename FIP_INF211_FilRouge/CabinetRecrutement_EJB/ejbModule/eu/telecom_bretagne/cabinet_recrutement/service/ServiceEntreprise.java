package eu.telecom_bretagne.cabinet_recrutement.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebService;

import eu.telecom_bretagne.cabinet_recrutement.data.dao.EntrepriseDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.model.Entreprise;

/**
 * Session Bean implementation class ServiceEntreprise
 * @author Elouan LE DUC
 * @author Clement LE GRUIEC
 * 
 */
@Stateless
@LocalBean
public class ServiceEntreprise implements IServiceEntreprise
{
  //-----------------------------------------------------------------------------
  @EJB private EntrepriseDAO         entrepriseDAO;
  //-----------------------------------------------------------------------------
  /**
   * Default constructor.
   */
  public ServiceEntreprise()
  {
    // TODO Auto-generated constructor stub
  }
  //-----------------------------------------------------------------------------
  @Override
  public Entreprise getEntreprise(int id)
  {
    return entrepriseDAO.findById(id);
  }
  //-----------------------------------------------------------------------------
  @Override
  public List<Entreprise> listeDesEntreprises()
  {
    return entrepriseDAO.findAll();
  }
  //-----------------------------------------------------------------------------
  @Override
  public Entreprise execPersist(Entreprise entreprise)
  {
    return entrepriseDAO.persist(entreprise);
  }
//-----------------------------------------------------------------------------
  @Override
  public Entreprise execUpdate(Entreprise entreprise)
  {
    return entrepriseDAO.update(entreprise);
  }
  //-----------------------------------------------------------------------------
}
