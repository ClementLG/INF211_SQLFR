<%@ page language="java" contentType="text/html" pageEncoding="ISO-8859-1"%>

<%@page import="eu.telecom_bretagne.cabinet_recrutement.front.utils.ServicesLocator,
                eu.telecom_bretagne.cabinet_recrutement.service.IServiceEntreprise,
                eu.telecom_bretagne.cabinet_recrutement.data.model.Entreprise,
                eu.telecom_bretagne.cabinet_recrutement.service.IServiceCandidature,
                eu.telecom_bretagne.cabinet_recrutement.data.model.Candidature,
                java.util.List"%>

<%
  String identifiant = request.getParameter("identifiant");
  if(identifiant == null) // Pas de paramètre "identifiant" => affichage du formulaire
  {
  	%>
  	<div class="col-xs-offset-1 col-xs-10">
		<form action="connexion.jsp" method="get">
		  <!-- <input type="hidden" name="action" value="connexion" /> -->
		  <p class="col-xs-offset-3 col-xs-6" style="text-align: center">Identifiant :</p>
		  <p class="col-xs-offset-3 col-xs-6" style="text-align: center"><input type="text" name="identifiant"/></p>
		  <p><input class="col-xs-offset-5 col-xs-2" style="text-align: center; margin-bottom: 1%" type="submit" value="Connexion"/></p>
		</form>
		<div class="alert alert-info col-xs-offset-3 col-xs-6">
         	L'identifiant est la clé primaire préfixée de :
            <ul>
               <li>pour une entreprise : <code>ENT_</code> <em>(ENT_12 par exemple)</em></li>
               <li>pour une candidature : <code>CAND_</code> <em>(CAND_7 par exemple)</em></li>
            </ul>
            <br/><em>Note : l'identification se fait sans mot de passe.</em>
         </div>
    </div>
         
  	<%
  }
  else                    // Paramètre "identifiant" existant => connexion
  {
  	if(identifiant.equals(""))
  	{
      %>
      <p class="erreur">Veuillez renseignez votre numéro d'identifiant pour pouvoir vous connecter</p>
      <a href="index.jsp">Retour...</a>
      <%
  	}
    else if(identifiant.startsWith("ENT_"))
  	{
  		IServiceEntreprise serviceEntreprise = (IServiceEntreprise) ServicesLocator.getInstance().getRemoteInterface("ServiceEntreprise");
  		int id = Integer.parseInt(identifiant.substring(4)); // On enlève le préfixe "ENT_";
  		Entreprise entreprise = serviceEntreprise.getEntreprise(id);
  		if(entreprise == null)
  		{
  			%>
  			<p class="erreur">Erreur : il n'y a pas d'entreprise avec cet identifiant : <%=identifiant%></p>
  			<a href="index.jsp">Retour...</a>
  			<%
  		}
  		else
  		{
        session.setAttribute("utilisateur",entreprise);
        response.sendRedirect("index.jsp");
  		}
  	}
  	else if(identifiant.startsWith("CAND_"))
  	{
  		IServiceCandidature serviceCandidature = (IServiceCandidature) ServicesLocator.getInstance().getRemoteInterface("ServiceCandidature");
  		int id = Integer.parseInt(identifiant.substring(5)); // On enlève le préfixe "CAND_";
  		Candidature candidature = serviceCandidature.getCandidature(id);
      if(candidature == null)
      {
        %>
        <p class="erreur">Erreur : il n'y a pas de candidature avec cet identifiant : <%=identifiant%></p>
        <a href="index.jsp">Retour...</a>
        <%
      }
      else
      {
        session.setAttribute("utilisateur",candidature);
        response.sendRedirect("index.jsp");
      }
  	}
  }
%>
