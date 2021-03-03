<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@page import="eu.telecom_bretagne.cabinet_recrutement.front.utils.ServicesLocator,
                eu.telecom_bretagne.cabinet_recrutement.service.IServiceEntreprise,
                eu.telecom_bretagne.cabinet_recrutement.service.IServiceCandidature,
                eu.telecom_bretagne.cabinet_recrutement.data.model.Candidature,
                eu.telecom_bretagne.cabinet_recrutement.data.model.Entreprise"%>

<%

Object utilisateur = session.getAttribute("utilisateur");
%>

        
<div class="navbar-header">
  <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
    <span class="sr-only">Toggle navigation</span>
    <span class="icon-bar"></span>
    <span class="icon-bar"></span>
    <span class="icon-bar"></span>
  </button>
  <h4><a class="navbar-brand" href="template.jsp">Cabinet de recrutement <br><br> LE GRUIEC Clement et LE DUC Elouan&nbsp;</a></h4><br>
   
</div> <!-- /.navbar-header -->

<ul class="nav navbar-top-links navbar-right">

  <!-- Menu des messages -->
  <% if(utilisateur != null){ %>
  <li class="dropdown">
  	<a class="dropdown-toggle" data-toggle="dropdown" href="#">
    	<i class="fa fa-envelope fa-2x"></i>
        <i class="fa fa-caret-down fa-2x"></i>
    </a>
    <ul class="dropdown-menu dropdown-messages">
    	<li>
        	<a href="#"><i class="glyphicon glyphicon-import"></i> Messages reçus <span class="pull-right text-muted"><em>0</em></span></a>
        </li>
        <li class="divider"></li>
        <li>
          <a href="#"><i class="glyphicon glyphicon-export"></i> Messages envoyés <span class="pull-right text-muted"><em>0</em></span></a>
        </li>
        <li class="divider"></li>
        <li>
          <a class="text-center" href="template.jsp?action=liste_messages">
            <strong>Lire les messages</strong> <i class="fa fa-angle-right"></i>
          </a>
        </li>
  	</ul>
  </li><!-- /.dropdown-messages -->
  <%} %>

  <!-- Menu connexion -->
  <li class="dropdown">
    <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="true">
      <i class="fa fa-user fa-2x"></i>
      <i class="fa fa-caret-down fa-2x"></i>
    </a>
    <ul class="dropdown-menu dropdown-user">
      
        <li><a href="#"><i class="fa fa-user fa-fw"></i>
        <% if(utilisateur == null) out.println("Utilisateur non connecté"); 
        
        else {
  	  	if(utilisateur instanceof Entreprise)
  	  	{
  	  		Entreprise e = (Entreprise) utilisateur;
  	  		out.println(e.getNom());
  	  	}
  	  	else if(utilisateur instanceof Candidature)
  	  	{
  	  		Candidature c = (Candidature) utilisateur;
  	  		out.println(c.getAdresseemail());
  	  		
  	  	}

  	  }
        %>
        </a></li><li class="divider"></li>
        <% if(utilisateur == null){ %>
        	<li><a href="template.jsp?action=connexion"><i class="fa fa-sign-in fa-fw"></i> Login</a></li>
        <%} else { %>
        	<li><a href="deconnexion.jsp"><i class="fa fa-sign-in fa-fw"></i> Logout</a></li>
        <%} %>
        
      
    </ul> <!-- /.dropdown-user -->
  </li> <!-- /.dropdown -->

</ul> <!-- /.navbar-top-links -->











