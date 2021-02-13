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
DROP  TABLE IF EXISTS secteur_offre;
DROP TABLE IF EXISTS secteur_offre;
DROP TABLE IF EXISTS secteur_candidature;
DROP TABLE IF EXISTS secteur_activite;
DROP TABLE IF EXISTS message_offredemploi;
DROP TABLE IF EXISTS message_candidature;
DROP TABLE IF EXISTS candidature;
DROP TABLE IF EXISTS offre_emploi;
DROP TABLE IF EXISTS entreprise;
DROP TABLE IF EXISTS niveau_qualification;
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


CREATE TABLE niveau_qualification (
	id serial NOT NULL,
	intitule varchar(255) NOT NULL,
	PRIMARY KEY (id)
);


CREATE TABLE secteur_activite (
	id serial NOT NULL,
	intitule varchar(255) NOT NULL,
	PRIMARY KEY (id)
);


CREATE TABLE offre_emploi (
    id serial NOT NULL,
	titre varchar(255) NOT NULL,
	entreprise integer NOT NULL,
	descriptifmission text,
	profilrecherche text,
	datedepot date,
	niveau_qualification integer,
	PRIMARY KEY (id),
	FOREIGN KEY (entreprise) REFERENCES entreprise(id),
	FOREIGN KEY (niveau_qualification) REFERENCES niveau_qualification(id)
);


CREATE TABLE candidature (
    id serial NOT NULL,
	niveau_qualification integer,
	datenaissance date,
	adressepostale varchar(255),
	adresseemail varchar(255) NOT NULL,
	cv text,
	datedepot date,
	PRIMARY KEY (id),
    FOREIGN KEY (niveau_qualification) REFERENCES niveau_qualification(id)
);


CREATE TABLE secteur_offre (
	offre_emploi integer NOT NULL,
	secteur_activite integer NOT NULL,
	PRIMARY KEY (offre_emploi,secteur_activite),
    FOREIGN KEY (offre_emploi) REFERENCES offre_emploi(id),
    FOREIGN KEY (secteur_activite) REFERENCES secteur_activite(id)
);

CREATE TABLE secteur_candidature (
	secteur_activite integer NOT NULL,
	candidature integer NOT NULL,
	PRIMARY KEY (secteur_activite,candidature),
    FOREIGN KEY (candidature) REFERENCES candidature(id),
    FOREIGN KEY (secteur_activite) REFERENCES secteur_activite(id)
);

CREATE TABLE message_offredemploi (
	id serial NOT NULL,
	offre_emploi integer NOT NULL,
	dateEnvoi date,
	corpsmessage text,
	candidature integer NOT NULL,
	PRIMARY KEY (id),
    FOREIGN KEY (offre_emploi) REFERENCES offre_emploi(id),
    FOREIGN KEY (candidature) REFERENCES candidature(id)
);

CREATE TABLE message_candidature (
    id serial NOT NULL,
	offre_emploi integer NOT NULL,
	candidature integer NOT NULL,
	dateEnvoi DATE,
	corpsmessage text,
	PRIMARY KEY (id),
    FOREIGN KEY (offre_emploi) REFERENCES offre_emploi(id),
    FOREIGN KEY (candidature) REFERENCES candidature(id)
);


-- Ajout des donnees de base donnee par le CC.
-- Le secteur d'activité
-- Valeur à choisir parmi : Achats/Logistique, Assistanat/Secrétariat, Agriculture, Agroali- mentaire, Assurance, Audit/Conseil/Expertises, BTP/Immobilier, Commercial, Com- munication/Art/Média/Mode, Comptabilité, Direction Générale/Executive, Distribution/- Commerce, Electronique/Microélectronique, Environnement, Finance/Banque, Forma- tion/Enseignement, Hôtellerie/Restauration/Tourisme, Industrie/Ingénierie/Production, Informatique, Juridique/Fiscal/Droit, Marketing, Public/Parapublic, Ressources Hu- maines, Santé/Social/Biologie/Humanitaire, Télécom/Réseaux.
-- Note : pour des questions pratiques, cette liste peut être réduite.
-- Le niveau de qualiﬁcation
-- Valeur à choisir parmi : CAP/BEP, Bac, Bac+3, Bac+5, Doctorat.



INSERT INTO niveau_qualification (intitule) VALUES ('CAP/BEP'), ('Bac'), ('Bac+3'), ('Bac+5'), ('Doctorat');
INSERT INTO secteur_activite (intitule) VALUES ('Achats/Logistique'),('Assistanat/Secrétariat'),('Agriculture'),('Agroali- mentaire'),('Assurance'),('Audit/Conseil/Expertises'),('BTP/Immobilier'),('Commercial'),('Com- munication/Art/Média/Mode'),('Comptabilité'),('Direction Générale/Executive'),('Distribution/- Commerce'),('Electronique/Microélectronique'),('Environnement'),('Finance/Banque'),('Forma- tion/Enseignement'),('Hôtellerie/Restauration/Tourisme'),('Industrie/Ingénierie/Production'),('Informatique'),('Juridique/Fiscal/Droit'),('Marketing'),('Public/Parapublic'),('Ressources Hu- maines'),('Santé/Social/Biologie/Humanitaire'),('Télécom/Réseaux');

INSERT INTO entreprise (nom, descriptif, adressepostale) VALUES ('IMT Atlantique','IMT Atlantique est une grande école pionnière en formation, en recherche et en entrepreneuriat et en tout plein de choses...','Plouzané');
INSERT INTO entreprise (nom, descriptif, adressepostale) VALUES ('ENIB','Une école d''ingénieur juste à côté...','Plouzané');
INSERT INTO entreprise (nom, descriptif, adressepostale) VALUES ('GOOGLE','Grande entreprise de la Tech','DUBLIN Irlande');

INSERT INTO candidature (cv,datenaissance,adresseemail,adressepostale,niveau_qualification,datedepot) VALUES ('CV1',TO_DATE('01/01/1999','DD-MM-YYYY'),'jean@gmail.com','4 rue des bouleaux PARIS',3,TO_DATE('06/02/2021','DD-MM-YYYY'));
INSERT INTO candidature (cv,datenaissance,adresseemail,adressepostale,niveau_qualification,datedepot) VALUES ('CV2',TO_DATE('18/11/2000','DD-MM-YYYY'),'paul@gmail.com','46 rue des ifs BORDEAUX',2,TO_DATE('03/02/2021','DD-MM-YYYY'));
INSERT INTO candidature (cv,datenaissance,adresseemail,adressepostale,niveau_qualification,datedepot) VALUES ('CV3',TO_DATE('27/09/1997','DD-MM-YYYY'),'jacques@gmail.com','34 rue des arbustes MARSEILLE',4,TO_DATE('24/01/2021','DD-MM-YYYY'));
INSERT INTO candidature (cv,datenaissance,adresseemail,adressepostale,niveau_qualification,datedepot) VALUES ('CV4',TO_DATE('14/04/1994','DD-MM-YYYY'),'pierre@gmail.com','8 rue des tulipes LYON',4,TO_DATE('30/01/2021','DD-MM-YYYY'));
INSERT INTO candidature (cv,datenaissance,adresseemail,adressepostale,niveau_qualification,datedepot) VALUES ('CV5',TO_DATE('07/06/2000','DD-MM-YYYY'),'florian@gmail.com','27 rue des paquerettes LILLE',4,TO_DATE('11/02/2021','DD-MM-YYYY'));
INSERT INTO candidature (cv,datenaissance,adresseemail,adressepostale,niveau_qualification,datedepot) VALUES ('CV6',TO_DATE('30/10/2001','DD-MM-YYYY'),'matthieu@gmail.com','26 rue des coquelicots ANGERS',4,TO_DATE('27/01/2021','DD-MM-YYYY'));

INSERT INTO offre_emploi (titre,entreprise,descriptifmission,niveau_qualification,profilrecherche,datedepot) VALUES ('Stage codage de PASS',1,'Coder tout le backend en PHP',1,'Etudiant Ingénieur',TO_DATE('01/01/2021','DD-MM-YYYY'));
INSERT INTO offre_emploi (titre,entreprise,descriptifmission,niveau_qualification,profilrecherche,datedepot) VALUES ('Stage gestion BDD',2,'Analyse BDD du personnel',4,'Etudiant Ingénieur',TO_DATE('05/01/2021','DD-MM-YYYY'));
INSERT INTO offre_emploi (titre,entreprise,descriptifmission,niveau_qualification,profilrecherche,datedepot) VALUES ('Thèse en IA',3,'Ameliorer recherche avec une IA',5,'Doctorant Informatique',TO_DATE('18/01/2021','DD-MM-YYYY'));
INSERT INTO offre_emploi (titre,entreprise,descriptifmission,niveau_qualification,profilrecherche,datedepot) VALUES ('CDI Data Analyst',3,'Detecter tendance du marché',4,'Ingénieur Data',TO_DATE('27/01/2021','DD-MM-YYYY'));
INSERT INTO offre_emploi (titre,entreprise,descriptifmission,niveau_qualification,profilrecherche,datedepot) VALUES ('PostDoc Compression Image',1,'Ameliorer algo compression',5,'Doctorant Informatique',TO_DATE('06/02/2021','DD-MM-YYYY'));

INSERT INTO message_candidature (offre_emploi,candidature,corpsmessage,dateenvoi) VALUES (1,2,'Bonjour je souhaite avoir le stage',TO_DATE('03/02/2021','DD-MM-YYYY'));
INSERT INTO message_candidature (offre_emploi,candidature,corpsmessage,dateenvoi) VALUES (2,3,'Bonsoir je souhaite avoir le stage siouplait',TO_DATE('03/02/2021','DD-MM-YYYY'));
INSERT INTO message_candidature (offre_emploi,candidature,corpsmessage,dateenvoi) VALUES (3,1,'Bonjour je souhaite être docteur',TO_DATE('03/02/2021','DD-MM-YYYY'));

INSERT INTO message_offredemploi (offre_emploi,candidature,corpsmessage,dateenvoi) VALUES (1,2,'Voici une offre de stage pour vous',TO_DATE('01/01/2021','DD-MM-YYYY'));
INSERT INTO message_offredemploi (offre_emploi,candidature,corpsmessage,dateenvoi) VALUES (2,3,'Voici une offre de stage pour vous',TO_DATE('05/01/2021','DD-MM-YYYY'));
INSERT INTO message_offredemploi (offre_emploi,candidature,corpsmessage,dateenvoi) VALUES (3,1,'Voici une offre de thèse pour vous',TO_DATE('18/01/2021','DD-MM-YYYY'));

INSERT INTO secteur_candidature (candidature,secteur_activite) VALUES (1,19);
INSERT INTO secteur_candidature (candidature,secteur_activite) VALUES (1,25);
INSERT INTO secteur_candidature (candidature,secteur_activite) VALUES (2,19);
INSERT INTO secteur_candidature (candidature,secteur_activite) VALUES (3,19);
INSERT INTO secteur_candidature (candidature,secteur_activite) VALUES (4,19);
INSERT INTO secteur_candidature (candidature,secteur_activite) VALUES (5,25);
INSERT INTO secteur_candidature (candidature,secteur_activite) VALUES (6,19);

INSERT INTO secteur_offre (offre_emploi,secteur_activite) VALUES (1,19);
INSERT INTO secteur_offre (offre_emploi,secteur_activite) VALUES (2,19);
INSERT INTO secteur_offre (offre_emploi,secteur_activite) VALUES (3,19);
INSERT INTO secteur_offre (offre_emploi,secteur_activite) VALUES (3,25);
INSERT INTO secteur_offre (offre_emploi,secteur_activite) VALUES (4,19);
INSERT INTO secteur_offre (offre_emploi,secteur_activite) VALUES (5,19);
