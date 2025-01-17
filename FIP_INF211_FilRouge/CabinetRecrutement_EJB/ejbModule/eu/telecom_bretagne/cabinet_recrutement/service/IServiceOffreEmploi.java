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
 * Interface du service gérant les offres d'emploi.
 * @author Elouan LE DUC
 * @author Clement LE GRUIEC
 * 
 */
@Remote
public interface IServiceOffreEmploi extends IServicesGeneriques
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
  /**
   * Obtention des offres emplois correspondant au secteur et à au niveau qualification infiqués
   * 
   * @param Liste des secteurs, le niveau de qualification.
   * 
   * @return List<OffreEmploi>
   */
  public List<OffreEmploi> getEmploiBySectorAndNQ(Set<SecteurActivite> IDsSect, NiveauQualification idNQ);
  /**
   * Transforme une liste de secteur en string
   * 
   * @param OffreEmploi.
   * 
   * @return String[] liste des secteurs d'activité
   */
  
  public String GetSecteursString(OffreEmploi offres);
  /**
   * Obtention du NQ recherché.
   * 
   * @param id id du niveau qualification à récupérer.
   * 
   * @return NQ
   */
  public NiveauQualification findNQByID(Integer id);
  /**
   * Permet de persister l'offre emploi
   * 
   * @param offre emploi Objet à persister.
   * 
   * @return OffreEmploi
   */
  public OffreEmploi execPersist(OffreEmploi oe);
  /**
   * Permet de maj l'offre emploi
   * 
   * @param offre emploi Objet à maj.
   * 
   * @return OffreEmploi
   */
  public OffreEmploi execUpdate(OffreEmploi oe);
  /**
   * Permet de d'ajouter des secteurs à une OffreEmploi
   * 
   * @param id id de l' OffreEmploi, sects liste des secteur sous forme de string
   * 
   */
  public void majSecteursActivites(String[] sects, int idOF);
  
  
}
