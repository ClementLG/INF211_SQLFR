package eu.telecom_bretagne.cabinet_recrutement.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import eu.telecom_bretagne.cabinet_recrutement.data.dao.SecteuractiviteDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.model.SecteurActivite;

/**
 * Session Bean implementation class ServiceSecteur
 * @author Philippe TANGUY
 */
@Stateless
@LocalBean
public class ServiceSecteur implements IServiceSecteur
{
  //-----------------------------------------------------------------------------
  @EJB private SecteuractiviteDAO         secteuractiviteDAO;
  //-----------------------------------------------------------------------------
  /**
   * Default constructor.
   */
  public ServiceSecteur()
  {
    // TODO Auto-generated constructor stub
  }
  //-----------------------------------------------------------------------------
  @Override
  public SecteurActivite getSecteurActivite(int id)
  {
    return secteuractiviteDAO.findById(id);
  }
  //-----------------------------------------------------------------------------
  @Override
  public List<SecteurActivite> listeDesSecteurs()
  {
    return secteuractiviteDAO.findAll();
  }
  //-----------------------------------------------------------------------------
  @Override
  public SecteurActivite execPersist(SecteurActivite SA)
  {
    return secteuractiviteDAO.persist(SA);
  }
  //-----------------------------------------------------------------------------
}
