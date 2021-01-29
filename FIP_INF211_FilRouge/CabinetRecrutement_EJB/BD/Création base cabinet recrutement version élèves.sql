--
-- Clement LE GRUIEC
-- Elouan LE DUC
-- 01/2020 - INF211
-- IMT Altantique FIP 2A
-- Permet de setup la base de donnee du projet fil rouge.
--


--
-- Remise a zero
--

-- commande : DROP DATABASE IF EXISTS XXX  pour éviter erreurs (si table déjà existante...)
-- postgresql aime pas trop, enlever si erreur

DROP  TABLE IF EXISTS secteuroffre;
DROP TABLE IF EXISTS secteurcandidature;
DROP TABLE IF EXISTS secteuractivite;
DROP TABLE IF EXISTS messageoffredemploi;
DROP TABLE IF EXISTS messagecandidature;
DROP TABLE IF EXISTS candidature;
DROP TABLE IF EXISTS offreemploi;
DROP TABLE IF EXISTS entreprise;
DROP TABLE IF EXISTS niveauqualification;
-- note ordre important avec les FK

--
-- Creation des tables (ordre important aussi)
--

CREATE TABLE entreprise (
	id serial NOT NULL,
	nom varchar(255) NOT NULL,
	descriptif text,
	adressepostale varchar(255),
	PRIMARY KEY (id)
);


CREATE TABLE niveauqualification (
	intitule varchar(255) NOT NULL,
	PRIMARY KEY (intitule)
);


CREATE TABLE secteuractivite (
	intitule varchar(255) NOT NULL,
	PRIMARY KEY (intitule)
);


CREATE TABLE offreemploi (
    id serial NOT NULL,
	titre varchar(255) NOT NULL,
	entreprise integer NOT NULL,
	descriptifmission text,
	profilrecherche text,
	datedepot date,
	niveauqualification varchar(255),
	PRIMARY KEY (id),
	FOREIGN KEY (entreprise) REFERENCES entreprise(id),
	FOREIGN KEY (niveauqualification) REFERENCES niveauqualification(intitule)
);


CREATE TABLE candidature (
    id serial NOT NULL,
	niveauqualification varchar(255),
	datenaissance date,
	adressepostale varchar(255),
	adresseemail varchar(255) NOT NULL,
	cv text,
	datedepot date,
	PRIMARY KEY (id),
    FOREIGN KEY (niveauqualification) REFERENCES niveauqualification(intitule)
);


CREATE TABLE secteuroffre (
	offreemploi integer NOT NULL,
	secteuractivite varchar(255) NOT NULL,
	PRIMARY KEY (offreemploi,secteuractivite),
    FOREIGN KEY (offreemploi) REFERENCES offreemploi(id),
    FOREIGN KEY (secteuractivite) REFERENCES secteuractivite(intitule)
);

CREATE TABLE secteurcandidature (
	secteuractivite varchar(255) NOT NULL,
	candidature integer NOT NULL,
	PRIMARY KEY (secteuractivite,candidature),
    FOREIGN KEY (candidature) REFERENCES candidature(id),
    FOREIGN KEY (secteuractivite) REFERENCES secteuractivite(intitule)
);

CREATE TABLE messageoffredemploi (
	id serial NOT NULL,
	offreemploi integer NOT NULL,
	dateEnvoi date,
	corpsmessage text,
	candidature integer NOT NULL,
	PRIMARY KEY (id),
    FOREIGN KEY (offreemploi) REFERENCES offreemploi(id),
    FOREIGN KEY (candidature) REFERENCES candidature(id)
);

CREATE TABLE messagecandidature (
    id serial NOT NULL,
	offreemploi integer NOT NULL,
	candidature integer NOT NULL,
	dateEnvoi DATE,
	corpsmessage text,
	PRIMARY KEY (id),
    FOREIGN KEY (offreemploi) REFERENCES offreemploi(id),
    FOREIGN KEY (candidature) REFERENCES candidature(id)
);


-- Ajout des donnees de base donnee par le CC.
-- Le secteur d'activité
-- Valeur à choisir parmi : Achats/Logistique, Assistanat/Secrétariat, Agriculture, Agroali- mentaire, Assurance, Audit/Conseil/Expertises, BTP/Immobilier, Commercial, Com- munication/Art/Média/Mode, Comptabilité, Direction Générale/Executive, Distribution/- Commerce, Electronique/Microélectronique, Environnement, Finance/Banque, Forma- tion/Enseignement, Hôtellerie/Restauration/Tourisme, Industrie/Ingénierie/Production, Informatique, Juridique/Fiscal/Droit, Marketing, Public/Parapublic, Ressources Hu- maines, Santé/Social/Biologie/Humanitaire, Télécom/Réseaux.
-- Note : pour des questions pratiques, cette liste peut être réduite.
-- Le niveau de qualiﬁcation
-- Valeur à choisir parmi : CAP/BEP, Bac, Bac+3, Bac+5, Doctorat.



INSERT INTO niveauqualification (intitule) VALUES ('CAP/BEP'), ('Bac'), ('Bac+3'), ('Bac+5'), ('Doctorat');
INSERT INTO secteuractivite (intitule) VALUES ('Achats/Logistique'),('Assistanat/Secrétariat'),('Agriculture'),('Agroali- mentaire'),('Assurance'),('Audit/Conseil/Expertises'),('BTP/Immobilier'),('Commercial'),('Com- munication/Art/Média/Mode'),('Comptabilité'),('Direction Générale/Executive'),('Distribution/- Commerce'),('Electronique/Microélectronique'),('Environnement'),('Finance/Banque'),('Forma- tion/Enseignement'),('Hôtellerie/Restauration/Tourisme'),('Industrie/Ingénierie/Production'),('Informatique'),('Juridique/Fiscal/Droit'),('Marketing'),('Public/Parapublic'),('Ressources Hu- maines'),('Santé/Social/Biologie/Humanitaire'),('Télécom/Réseaux');

INSERT INTO entreprise (nom, descriptif, adressepostale) values ('IMT Atlantique','IMT Atlantique est une grande école pionnière en formation, en recherche et en entrepreneuriat et en tout plein de choses...','Plouzané');
INSERT INTO entreprise (nom, descriptif, adressepostale) values ('ENIB','Une école d''ingénieur juste à côté...','Plouzané');
-- CLLG - 28012021 : ok avec querytool postgresql								 