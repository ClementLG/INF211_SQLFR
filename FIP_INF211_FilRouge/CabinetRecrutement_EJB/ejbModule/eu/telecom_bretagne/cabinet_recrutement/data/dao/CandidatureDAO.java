package eu.telecom_bretagne.cabinet_recrutement.data.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import eu.telecom_bretagne.cabinet_recrutement.data.model.Candidature;

/**
 * Session Bean implementation class CandidatureDAO
 * @author Philippe TANGUY
 */
@Stateless
@LocalBean
public class CandidatureDAO
{
  //-----------------------------------------------------------------------------
  /**
   * Référence vers le gestionnaire de persistance.
   */
  @PersistenceContext
  EntityManager entityManager;
  //-----------------------------------------------------------------------------
  /**
   * Default constructor.
   */
  public CandidatureDAO()
  {
    // TODO Auto-generated constructor stub
  }
  //-----------------------------------------------------------------------------
  public Candidature findById(Integer id)
  {
    return entityManager.find(Candidature.class, id);
  }
  //----------------------------------------------------------------------------
  @SuppressWarnings({ "rawtypes", "unchecked" })
  public List<Candidature> findAll()
  {
    Query query = entityManager.createQuery("select Candidature from Candidature Candidature order by Candidature.id");
    List l = query.getResultList(); 
    
    return (List<Candidature>)l;
  }
  //-----------------------------------------------------------------------------
  public Candidature persist(Candidature Candidature)
  {
	  if (Candidature!=null)
	  {
		  entityManager.persist(Candidature);
	  }
	  return Candidature;
  }
  
  public Candidature update(Candidature Candidature)
  {
	  if (Candidature!=null)
	  {
		  entityManager.merge(Candidature); 
	  }
	  return Candidature;
  }
  
  public void remove(Candidature Candidature)
  {
	  if (Candidature!=null)
	  {
		  entityManager.remove(Candidature);
	  }
  }
  public List<Candidature> CandidatureAvecNiveauEtSecteur(String secteur,String nvQualif )
  {
	  List l=null;
	  if (secteur!=null && nvQualif!=null)
	  {
		  Query query = entityManager.createQuery("select candidature FROM (SELECT * FROM candidature JOIN secteur_candidature on secteur_candidature.candidature = candidature.id) as test JOIN secteur_activite on secteur_activite = secteur_activite.id;");
		  l = query.getResultList(); 
		  
	  }
	  return l;
  }
  
  
}
