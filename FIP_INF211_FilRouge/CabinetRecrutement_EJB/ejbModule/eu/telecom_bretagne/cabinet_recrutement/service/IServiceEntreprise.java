package eu.telecom_bretagne.cabinet_recrutement.service;

import java.util.List;

import javax.ejb.Remote;

import eu.telecom_bretagne.cabinet_recrutement.data.model.Entreprise;

/**
 * Interface du service gérant les entreprises.
 * @author Philippe TANGUY
 */
@Remote
public interface IServiceEntreprise
{
  //-----------------------------------------------------------------------------
  /**
   * Obtention d'une <{@link Entreprise}.
   * 
   * @param id id de l'entreprise à récupérer.
   * @return
   */
  public Entreprise getEntreprise(int id);
  /**
   * Obtention de la liste de toutes les entreprises.
   * 
   * @return la liste des entreprises dans une {@code List<Entreprise>}.
   */
  public List<Entreprise> listeDesEntreprises();
  //-----------------------------------------------------------------------------
  /**
   * Permet d'envoyer le tuble dans la table
   * 
   * @return l'objet entreprise créé
   */
  public Entreprise execPersist(Entreprise entreprise);
//-----------------------------------------------------------------------------
  /**
   * Permet de maj le tuble dans la table
   * 
   * @return l'objet entreprise maj
   */
  public Entreprise execUpdate(Entreprise entreprise);
}
