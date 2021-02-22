package eu.telecom_bretagne.cabinet_recrutement.service;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.ejb.Remote;

import eu.telecom_bretagne.cabinet_recrutement.data.model.Candidature;
import eu.telecom_bretagne.cabinet_recrutement.data.model.Entreprise;
import eu.telecom_bretagne.cabinet_recrutement.data.model.NiveauQualification;
import eu.telecom_bretagne.cabinet_recrutement.data.model.OffreEmploi;
import eu.telecom_bretagne.cabinet_recrutement.data.model.SecteurActivite;

/**
 * Interface du service gérant les entreprises.
 * @author Philippe TANGUY
 */
@Remote
public interface IServiceCandidature
{
  //-----------------------------------------------------------------------------
  /**
   * Obtention d'une <{@link OffreEmploi}.
   * 
   * @param id id de l'offre à récupérer.
   * @return
   */
  public Candidature getCandidature(int id);
  /**
   * Obtention de la liste de toutes les entreprises.
   * 
   * @return la liste des entreprises dans une {@code List<Entreprise>}.
   */
  public List<Candidature> listeCandidature();
  //-----------------------------------------------------------------------------
  public List<NiveauQualification> listeNiveauQualification();
  public List<SecteurActivite> listeSecteurs();
  public NiveauQualification findNQByID(Integer id);
  public Date getCurrentDate();
  public Date convertDate(String date);
  public Candidature execPersist(Candidature candidature);
  public Candidature execUpdate(Candidature candidature);
  public String GetSecteursString(Candidature cand);
  public Set<SecteurActivite> transformSecteurs(String[] sect);
  public void majSecteursActivites(String[] sects, int idC);
  public Boolean doesSectorExist(Set<SecteurActivite> sects, int id);
}
