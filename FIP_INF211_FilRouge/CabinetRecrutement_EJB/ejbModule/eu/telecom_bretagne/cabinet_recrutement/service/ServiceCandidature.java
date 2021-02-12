package eu.telecom_bretagne.cabinet_recrutement.service;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebService;

import eu.telecom_bretagne.cabinet_recrutement.data.dao.CandidatureDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.dao.EntrepriseDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.dao.NiveauqualificationDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.dao.OffreemploiDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.dao.SecteuractiviteDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.model.Candidature;
import eu.telecom_bretagne.cabinet_recrutement.data.model.Entreprise;
import eu.telecom_bretagne.cabinet_recrutement.data.model.NiveauQualification;
import eu.telecom_bretagne.cabinet_recrutement.data.model.OffreEmploi;

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
//chiade deso --cclg
  @Override
  public String GetSecteursString(Candidature cand) {
	 String SecteursToString = "";
	 
	 try {
		 SecteursToString+=cand.getSecteuractivites().iterator().next().getIntitule();
		 for (int i = 1; i < cand.getSecteuractivites().size(); i++) {
			 SecteursToString+="<br>"+cand.getSecteuractivites().iterator().next().getIntitule();
		}
		 
	 } catch (Exception e) {
		System.out.println("---------------- cassé get secteur acti ServiceCandidature");
	}

	return SecteursToString;
  }
  
  //-----------------------------------------------------------------------------
  public Candidature execPersist(Candidature candidature) {
	  candidatureDAO.persist(candidature);
	  return null;
  }
}
