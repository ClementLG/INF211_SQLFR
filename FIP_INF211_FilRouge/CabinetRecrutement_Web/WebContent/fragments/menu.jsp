<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@page import="eu.telecom_bretagne.cabinet_recrutement.front.utils.ServicesLocator,
                eu.telecom_bretagne.cabinet_recrutement.service.IServiceEntreprise,
                eu.telecom_bretagne.cabinet_recrutement.data.model.Entreprise,
                eu.telecom_bretagne.cabinet_recrutement.data.model.Candidature"%>

<%

Object utilisateur = session.getAttribute("utilisateur");
%>

<div class="navbar-default sidebar" role="navigation">
  <div class="sidebar-nav navbar-collapse">
  
    <ul class="nav" id="side-menu">

      <!--
        MENU PRINCIPAL
      -->

      <li><a href="index.jsp"><i class="fa fa-home"></i> Accueil</a></li>
      <li>
        <a href="#"><i class="fa fa-th"></i> Gestion des entreprises<span class="fa arrow"></span></a>
        <ul class="nav nav-second-level">
          <li><a href="template.jsp?action=nouvelle_entreprise">Nouvelle entreprise</a></li>
          <li><a href="template.jsp?action=liste_entreprises">Liste des entreprises</a></li>
          <li><a href="template.jsp?action=liste_offres">Liste de toutes les offres d'emploi</a></li>
        </ul> <!-- /.nav-second-level -->
      </li>
      <li>
        <a href="#"><i class="fa fa-users"></i> Gestion des candidatures<span class="fa arrow"></span></a>
        <ul class="nav nav-second-level">
          <li><a href="template.jsp?action=nouvelle_candidature">Nouvelle candidature</a></li>
          <li><a href="template.jsp?action=liste_candidatures">Liste des candidatures</a></li>
        </ul> <!-- /.nav-second-level -->
      </li>
      
      <!--
        MENU Entreprise
      -->
      <%

      if(utilisateur instanceof Entreprise){
    	  Entreprise entX = (Entreprise) utilisateur;
	  %>
      
	  <li><a href="#"><i class="fa fa-th"></i> Menu <strong>ENTREPRISE</strong><span class="fa arrow"></span></a>
      <ul class="nav nav-second-level collapse in" aria-expanded="true" style="">
      	<li><a href="template.jsp?action=maj_entreprise&amp;id_entreprise=2">Mettre � jour les informations de l'entreprise</a></li>
        	<li><a href="template.jsp?action=nouvelle_offre">Nouvelle offre d'emploi</a></li>
			<li><a href="template.jsp?action=entreprise_liste_offres&amp;id_entreprise=2">Liste de mes offres d'emploi (<%=entX.getOffreEmplois().size()%>)</a></li>
       </ul> <!-- /.nav-second-level -->
	   </li> 
		<%} %>
	
	  <%

      if(utilisateur instanceof Candidature){
	  %>
	   <li>
       	<a href="#"><i class="fa fa-user"></i> Menu <strong>CANDIDATURE</strong><span class="fa arrow"></span></a>
        	<ul class="nav nav-second-level collapse in" aria-expanded="true" style="">
            <li><a href="template.jsp?action=maj_candidature&amp;id_candidature=1">Mettre � jour les informations de la candidature</a></li>
            <li><a href="template.jsp?action=candidature_liste_offres&amp;id_candidature=1">Liste des offres d'emploi potentielles</a></li>
            </ul> <!-- /.nav-second-level -->
       </li>
       <%} %>
      <!--
        MENU SECONDAIRE
      -->

      <li><h4>&nbsp;</h4></li>
      <li><a href="http://formations.telecom-bretagne.eu/fip_inf210_fil_rouge/" target="_blank"><i class="fa fa-question-circle"></i> Documentation du fil rouge</a></li>
      <li><a href="http://srv-labs-006.enst-bretagne.fr/CabinetRecrutement_Web/" target="_blank"><i class="fa fa-certificate"></i> D�monstration du prototype</a></li>
      <li><a href="bootstrap/pages/" target="_blank"><i class="fa fa-thumbs-up"></i> D�mo du template SB Admin 2</a></li>
    </ul>
  </div> <!-- /.sidebar-collapse -->
</div> <!-- /.navbar-static-side -->
