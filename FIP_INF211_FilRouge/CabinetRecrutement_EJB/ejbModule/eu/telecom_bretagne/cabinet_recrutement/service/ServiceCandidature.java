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

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebService;

import eu.telecom_bretagne.cabinet_recrutement.data.dao.CandidatureDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.dao.EntrepriseDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.dao.NiveauqualificationDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.dao.OffreemploiDAO;
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
	  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	  LocalDateTime now = LocalDateTime.now();  
	  System.out.println(dtf.format(now));
	  Date dateBonne=new Date(0);
	try {
		dateBonne = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(dtf.format(now)+"");
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return dateBonne;
  }
  
  //-----------------------------------------------------------------------------
  public Date convertDate(String date) {
	  Date dateConverti=new Date(0);
	try {
		dateConverti = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(date);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return dateConverti;
  }
  
  //-----------------------------------------------------------------------------
  public Candidature execPersist(Candidature candidature) {
	  candidatureDAO.persist(candidature);
	  return null;
  }
}
