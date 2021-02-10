package eu.telecom_bretagne.cabinet_recrutement.service;

import java.util.List;

import javax.ejb.Remote;

import eu.telecom_bretagne.cabinet_recrutement.data.model.Entreprise;
import eu.telecom_bretagne.cabinet_recrutement.data.model.OffreEmploi;

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
int NbOffreByEntID(int idEnterprise);
}
