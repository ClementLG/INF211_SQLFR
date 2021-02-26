package eu.telecom_bretagne.cabinet_recrutement.service;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.ejb.Remote;

import eu.telecom_bretagne.cabinet_recrutement.data.model.Entreprise;
import eu.telecom_bretagne.cabinet_recrutement.data.model.NiveauQualification;
import eu.telecom_bretagne.cabinet_recrutement.data.model.OffreEmploi;
import eu.telecom_bretagne.cabinet_recrutement.data.model.SecteurActivite;

/**
 * Interface du service gérant les entreprises.
 * @author Philippe TANGUY
 */
@Remote
public interface IServiceOffreEmploi
{
  //-----------------------------------------------------------------------------
  /**
   * Obtention d'une <{@link OffreEmploi}.
   * 
   * @param id id de l'offre à récupérer.
   * @return
   */
  public OffreEmploi getOffreEmploi(int id);
  /**
   * Obtention de la liste de toutes les entreprises.
   * 
   * @return la liste des entreprises dans une {@code List<Entreprise>}.
   */
  public List<OffreEmploi> listeOffreEmploi();
  //-----------------------------------------------------------------------------
  public List<OffreEmploi> getEmploiBySectorAndNQ(Set<SecteurActivite> IDsSect, NiveauQualification idNQ);
  public String GetSecteursString(OffreEmploi offres);
  public List<NiveauQualification> listeNiveauQualification();
  public List<SecteurActivite> listeSecteurs();
  public Date getCurrentDate();
  public NiveauQualification findNQByID(Integer id);
  public OffreEmploi execPersist(OffreEmploi oe);
  public OffreEmploi execUpdate(OffreEmploi oe);
  
  
}
