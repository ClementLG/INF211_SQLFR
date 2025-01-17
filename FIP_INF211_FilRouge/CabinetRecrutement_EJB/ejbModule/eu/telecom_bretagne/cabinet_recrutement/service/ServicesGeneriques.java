package eu.telecom_bretagne.cabinet_recrutement.service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.sun.xml.rpc.processor.modeler.j2ee.xml.javaIdentifierType;

import eu.telecom_bretagne.cabinet_recrutement.data.dao.CandidatureDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.dao.NiveauqualificationDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.dao.SecteuractiviteDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.model.NiveauQualification;
import eu.telecom_bretagne.cabinet_recrutement.data.model.SecteurActivite;


/**
 * Session Bean implementation class ServicesGeneriques
 * @author Elouan LE DUC
 * @author Clement LE GRUIEC
 * 
 */
@Stateless
@LocalBean
public class ServicesGeneriques implements IServicesGeneriques
{
	//-----------------------------------------------------------------------------
	@EJB private NiveauqualificationDAO         niveauqualificationDAO;
	@EJB private SecteuractiviteDAO         secteuractiviteDAO;
	//-----------------------------------------------------------------------------	

	@Override
	public Date getCurrentDate() {
		Date currentDate=new Date(System.currentTimeMillis());
		return currentDate;
	}
	//-----------------------------------------------------------------------------
	@Override
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
	public List<SecteurActivite> listeSecteurs()
	{
		return secteuractiviteDAO.findAll();
	}
	//-----------------------------------------------------------------------------
	@Override
	public List<NiveauQualification> listeNiveauQualification()
	{
		return niveauqualificationDAO.findAll();
	}
	//-----------------------------------------------------------------------------
	@Override
	public String convertDatetoString(java.util.Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String strDate= formatter.format(date);  
		return strDate;
	}



}
