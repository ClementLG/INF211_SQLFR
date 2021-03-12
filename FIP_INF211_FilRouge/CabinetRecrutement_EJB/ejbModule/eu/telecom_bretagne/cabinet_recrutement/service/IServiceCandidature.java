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
 * Interface du service gérant les candidature.
 * @author Elouan LE DUC
 * @author Clement LE GRUIEC
 * 
 */
@Remote
public interface IServiceCandidature extends IServicesGeneriques
{
  //-----------------------------------------------------------------------------
  /**
   * Obtention d'une candidature recherché.
   * 
   * @param id id de la candidature à récupérer.
   * @return Candidature 
   */
  public Candidature getCandidature(int id);
  /**
   * Obtention de la liste de toutes les entreprises.
   * 
   * @return la liste des entreprises dans une {@code List<Entreprise>}.
   */
  public List<Candidature> listeCandidature();
  /**
   * Obtention du NQ recherché.
   * 
   * @param id id du niveau qualification à récupérer.
   * 
   * @return NQ
   */
  public NiveauQualification findNQByID(Integer id);
  /**
   * Permet de persister la candidature
   * 
   * @param candidature Objet à persister.
   * 
   * @return Candidature
   */
  public Candidature execPersist(Candidature candidature);
  /**
   * Permet de maj la candidature
   * 
   * @param candidature Objet à maj.
   * 
   * @return Candidature
   */
  public Candidature execUpdate(Candidature candidature);
  /**
   * Transforme une liste de secteur en string
   * 
   * @param candidature.
   * 
   * @return String[] liste des secteurs d'activité
   */
  public String GetSecteursString(Candidature cand);
  /**
   * Transforme une liste de string en secteur
   * 
   * @param String[] liste des secteur en string.
   * 
   * @return Secteurs
   */
  public Set<SecteurActivite> transformSecteurs(String[] sect);
  /**
   * Permet de d'ajouter des secteurs à une candidature
   * 
   * @param id id de la candidature, sects liste des secteur sous forme de string
   * 
   * @return Candidature
   */
  public void majSecteursActivites(String[] sects, int idC);
  /**
   * Verifie l'existence de secteur dans une candidature
   * 
   * @param secteurs à vérifier, id de la candidature
   * 
   * @return Candidature
   */
  public Boolean doesSectorExist(Set<SecteurActivite> sects, int id);
  /**
   * Permet de supprimer une une candidature
   * 
   * @param candidature.
   * 
   */
  public void supressionDuneCandidature(Candidature c);
  /**
   * Permet de remettre à zero les secteurs d'activités
   * 
   * @param id id de la candidature Objet.
   * 
   * @return Candidature
   */
  public Candidature RAZsecteurs(int idC);
}
