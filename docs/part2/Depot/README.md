---
authors: LE GRUIEC Clément & LE DUC ELOUAN
date: 14/02/2021
Depot : Partie2
promo : FIP2022
---

# PROJET FIL ROUGE

## Docs rendus

- Les codes sources correspondants à la partie 2 sont dispos dans :
_Depot/CodeSources/Part2/_

- La partie 3 est presque terminée également, les fichiers supplémentaires sont disponibles dans : 
_Depot/CodeSources/Part3/_

- Une archive du projet complet est également présente dans :
_Depot/CodeSources/FULL.zip/_

- Les documents de la partie 1 ont été mis à jour ainsi que la fiche de temps :
_Depot/DocumentsMisAJour/_

- Le projet fonctionne.


## Tests

- La partie 2 a été testée avec controlesDAO.
(voir _Depot/CodeSources/Part2/controlesDAO/controlesDAO.java_)

- La partie 3 a été en partie testée :
	- Les pages fonctionnent
	- L'affichage des listes de candidatures, d'offres d'emplois  et d'entreprise fonctionne.
	- L'affichage des infos détaillés sur le tuple fonctionne.
	- L'ajout d'une entreprise fonctionne
	- L'ajout d'une candidature fonctionne
	- L'affichage du nombre d'élément sur la page d'accueil fonctionne.
	
	
	- Bugs détectés sur la partie :
		- Les secteurs linkés à candidature ne sont pas synchronisés dans PgAdmin. Disparition au reboot du srv. (table tampon secteur_candidature).
		- Voir pour faire un persist en cascade.
		- problèmes au remove aussi pour les mêmes raisons...


:email: clement.le-gruiec@imt-atlantique.net
:email: elouan.le-duc@imt-atlantique.net


 

