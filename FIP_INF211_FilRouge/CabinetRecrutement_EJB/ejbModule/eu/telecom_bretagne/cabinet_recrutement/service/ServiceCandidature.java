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
import eu.telecom_bretagne.cabinet_recrutement.data.dao.NiveauqualificationDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.dao.SecteuractiviteDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.model.Candidature;
import eu.telecom_bretagne.cabinet_recrutement.data.model.NiveauQualification;
import eu.telecom_bretagne.cabinet_recrutement.data.model.SecteurActivite;

/**
 * Session Bean implementation class ServiceEntreprise
 * @author Philippe TANGUY
 */
@Stateless
@LocalBean
public class ServiceCandidature implements IServiceCandidature
{
  //-----------------------------------------------------------------------------
  @EJB private CandidatureDAO         candidatureDAO;
  @EJB private NiveauqualificationDAO         niveauqualificationDAO;
  @EJB private SecteuractiviteDAO         secteuractiviteDAO;
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
  public Date getCurrentDate() {
	  Date currentDate=new Date(System.currentTimeMillis());
	  return currentDate;
  }
  
  //-----------------------------------------------------------------------------
  public Date convertDate(String date) {
	  //String date dd/mm/yyyy to Date object
	  java.sql.Date dateConvertiSQL = new Date(0);
	try {
		java.util.Date dateConverti = new SimpleDateFormat("dd/MM/yyyy").parse(date);
		dateConvertiSQL = new Date(dateConverti.getTime());
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return dateConvertiSQL;
  }
  
//-----------------------------------------------------------------------------

  @Override
  public String GetSecteursString(Candidature cand) {
	 String SecteursToString = "";
	 
	 try {
		 for (SecteurActivite secteurs_recup : cand.getSecteuractivites()) {
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
				 c.getSecteuractivites().add(s);
				 candidatureDAO.update(c);	
			} catch (Exception e) {
				System.out.println("---------------> majDuSecteurDansCandErreur");
			}
					 
			 
		}
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
}
