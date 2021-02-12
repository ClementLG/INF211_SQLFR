package eu.telecom_bretagne.cabinet_recrutement.data.dao;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class testtruc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date dateConverti=new Date(System.currentTimeMillis());
		System.out.println(dateConverti);
		java.util.Date date_util = new java.util.Date(12,2020,12);
		//Tu fais tes traitement sur date_util...
		 
		//Tu castes à la fin pour insérer en base.
		java.sql.Date date_sql = new java.sql.Date(date_util.getTime());
		System.out.println(date_sql);
		
		
		try {
			String s_datenaissance = "23/05/1998";
			java.util.Date datenaissance = new SimpleDateFormat("dd/MM/yyyy").parse(s_datenaissance);
			java.sql.Date test = new Date(datenaissance.getTime());
			
			System.out.println(datenaissance);
			System.out.println(test);
			date_sql = new java.sql.Date(datenaissance.getTime());
			System.out.println(date_sql);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Candidature cand : candidature.getSecteuractivites())out.print("<br>"+cand);

	}

}
