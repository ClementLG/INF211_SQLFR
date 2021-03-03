<%@page import="eu.telecom_bretagne.cabinet_recrutement.data.model.MessageCandidature"%>
<%@page import="eu.telecom_bretagne.cabinet_recrutement.data.model.MessageOffredemploi"%>
<%@page
	import="eu.telecom_bretagne.cabinet_recrutement.service.IServiceEntreprise"%>
<%@page
	import="eu.telecom_bretagne.cabinet_recrutement.data.model.Entreprise"%>
<%@page import="javax.servlet.jsp.tagext.TryCatchFinally"%>
<%@page
	import="eu.telecom_bretagne.cabinet_recrutement.data.model.OffreEmploi"%>
<%@page
	import="eu.telecom_bretagne.cabinet_recrutement.service.IServiceOffreEmploi"%>
<%@page
	import="eu.telecom_bretagne.cabinet_recrutement.data.model.SecteurActivite"%>
<%@page
	import="eu.telecom_bretagne.cabinet_recrutement.data.model.NiveauQualification"%>
<%@ page language="java" contentType="text/html"
	pageEncoding="ISO-8859-1"%>

<%@page
	import="eu.telecom_bretagne.cabinet_recrutement.front.utils.ServicesLocator,
                eu.telecom_bretagne.cabinet_recrutement.data.model.Candidature,
                java.util.List"%>

<%
  IServiceEntreprise serviceEntreprise = (IServiceEntreprise) ServicesLocator.getInstance().getRemoteInterface("ServiceEntreprise");
  Object utilisateur = session.getAttribute("utilisateur");
  
  if(utilisateur == null) out.println("Utilisateur non connecté"); 
  
  else {
  	if(utilisateur instanceof Entreprise)
  	{
  		Entreprise entX = (Entreprise) utilisateur;
  		%>
  		<div class="col-lg-12">
  	    <div class="panel panel-default">
  	      <div class="panel-heading"><h3><i class="fa fa-envelope"></i> Liste des messages</h3></div> <!-- /.panel-heading -->
  	      <div class="panel-body">

  	        <div class="panel-group" id="accordion">

  	          <!-- Liste des messages reçus -->
  	          <div class="panel panel-default">
  	            <div class="panel-heading">
  	              <h4 class="panel-title">
  	                <a data-toggle="collapse" data-parent="#accordion" href="#collapseMessagesEnvoyes" aria-expanded="true"><i class="glyphicon glyphicon-export"></i> Message envoyes</a>
  	              </h4>
  	            </div>
  	            <div id="collapseMessagesEnvoyes" class="panel-collapse collapse in" aria-expanded="true" style="">
  	              <div class="panel-body">
  	                
  	                  <small>
  	                    <div class="dataTable_wrapper">
  	                     <table class="table table-striped table-bordered table-hover" "="">
  	                       <thead>
  	                         <tr>
  	                           <th>Identifiant</th>
  	                           <th>Destinataire</th>
  	                           <th>Offre</th>
  	                           <th>Date d'envoi</th>
  	                           <th>Message</th>
  	                         </tr>
  	                       </thead>
  	                       <tbody>
  	                       <%for(OffreEmploi of : entX.getOffreEmplois()){
  	                    	   for(MessageOffredemploi msgOf : of.getMessageOffredemplois()){
  	                    		 %>
  	                    		 <tr>
	  	                             <td><%=msgOf.getId() %></td>
	  	                             <td><a href="template.jsp?action=infos_candidature&amp;id=<%=msgOf.getCandidatureBean().getId()%>"><%=msgOf.getCandidatureBean().getAdresseemail() %></a></td>
	  	                             <td><a href="template.jsp?action=infos_offre&amp;id=<%=of.getId()%>"><%=of.getTitre()%></a></td>
	  	                             <td><%=msgOf.getDateenvoi()%></td>
	  	                             <td><%=msgOf.getCorpsmessage() %></td>
  	                           	</tr>
  	                    		 
  	                    		 <%  
  	                    	   }
  	                       }
  	                       %>
  	                           
  	                       </tbody>
  	                       <tbody>
  	                         
  	                       </tbody>
  	                     </table>
  	                   </div> <!-- /.table-responsive -->
  	                 </small>
  	                 
  	              </div>
  	            </div>
  	          </div>

  	          <!-- Liste des messages envoyés -->
  	          <div class="panel panel-default">
  	            <div class="panel-heading">
  	              <h4 class="panel-title">
  	                <a data-toggle="collapse" data-parent="#accordion" href="#collapseMessagesRecus" aria-expanded="true"><i class="glyphicon glyphicon-import"></i> Messages reçus</a>
  	              </h4>
  	            </div>
  	            <div id="collapseMessagesRecus" class="panel-collapse collapse in" aria-expanded="true" style="">
  	              <div class="panel-body">
  	                
  	                  <small>
  	                    <div class="dataTable_wrapper">
  	                     <table class="table table-striped table-bordered table-hover" "="">
  	                       <thead>
  	                         <tr>
  	                           <th>Identifiant</th>
  	                           <th>Expediteur</th>
  	                           <th>Offre</th>
  	                           <th>Date d'envoi</th>
  	                           <th>Message</th>
  	                         </tr>
  	                       </thead>
  	                       <tbody>
  	                         <%for(OffreEmploi of : entX.getOffreEmplois()){
  	                    	   for(MessageCandidature msgC : of.getMessageCandidatures()){
  	                    		 %>
  	                    		 <tr>
	  	                             <td><%=msgC.getId() %></td>
	  	                             <td><a href="template.jsp?action=infos_candidature&amp;id=<%=msgC.getCandidatureBean().getId()%>"><%=msgC.getCandidatureBean().getAdresseemail() %></a></td>
	  	                             <td><a href="template.jsp?action=infos_offre&amp;id=<%=of.getId()%>"><%=of.getTitre()%></a></td>
	  	                             <td><%=msgC.getDateenvoi()%></td>
	  	                             <td><%=msgC.getCorpsmessage() %></td>
  	                           	</tr>
  	                    		 
  	                    		 <%  
  	                    	   }
  	                       }
  	                       %>
  	                       </tbody>
  	                     </table>
  	                   </div> <!-- /.table-responsive -->
  	                 </small>
  	                 
  	              </div>
  	            </div>
  	          </div>
  	          
  	        </div> <!-- /.panel-group -->

  	      </div> <!-- /.panel-body -->
  	    </div> <!-- /.panel -->
  	  </div> <!-- /.col-lg-12 -->

  	<% }
  	else if(utilisateur instanceof Candidature)
  	{
  		Candidature candX = (Candidature) utilisateur;  
  		%>
  		<div class="col-lg-12">
  	    <div class="panel panel-default">
  	      <div class="panel-heading"><h3><i class="fa fa-envelope"></i> Liste des messages</h3></div> <!-- /.panel-heading -->
  	      <div class="panel-body">

  	        <div class="panel-group" id="accordion">

  	          <!-- Liste des messages reçus -->
  	          <div class="panel panel-default">
  	            <div class="panel-heading">
  	              <h4 class="panel-title">
  	                <a data-toggle="collapse" data-parent="#accordion" href="#collapseMessagesEnvoyes" aria-expanded="true"><i class="glyphicon glyphicon-export"></i> Message envoyes</a>
  	              </h4>
  	            </div>
  	            <div id="collapseMessagesEnvoyes" class="panel-collapse collapse in" aria-expanded="true" style="">
  	              <div class="panel-body">
  	                
  	                  <small>
  	                    <div class="dataTable_wrapper">
  	                     <table class="table table-striped table-bordered table-hover" "="">
  	                       <thead>
  	                         <tr>
  	                           <th>Identifiant</th>
  	                           <th>Destinataire</th>
  	                           <th>Offre</th>
  	                           <th>Date d'envoi</th>
  	                           <th>Message</th>
  	                         </tr>
  	                       </thead>
  	                       <tbody>
  	                       <%for(MessageCandidature msgC : candX.getMessageCandidatures()){
  	                    		 %>
  	                    		 <tr>
	  	                             <td><%=msgC.getId() %></td>
	  	                             <td><a href="template.jsp?action=infos_candidature&amp;id=<%=msgC.getCandidatureBean().getId()%>"><%=msgC.getCandidatureBean().getAdresseemail() %></a></td>
	  	                             <td><a href="template.jsp?action=infos_offre&amp;id=<%=msgC.getOffreEmploiBean().getId()%>"><%=msgC.getOffreEmploiBean().getTitre()%></a></td>
	  	                             <td><%=msgC.getDateenvoi()%></td>
	  	                             <td><%=msgC.getCorpsmessage() %></td>
  	                           	</tr>
  	                    		 
  	                    		 <%  
  	                       }
  	                       %>
  	                           
  	                       </tbody>
  	                       <tbody>
  	                         
  	                       </tbody>
  	                     </table>
  	                   </div> <!-- /.table-responsive -->
  	                 </small>
  	                 
  	              </div>
  	            </div>
  	          </div>

  	          <!-- Liste des messages envoyés -->
  	          <div class="panel panel-default">
  	            <div class="panel-heading">
  	              <h4 class="panel-title">
  	                <a data-toggle="collapse" data-parent="#accordion" href="#collapseMessagesRecus" aria-expanded="true"><i class="glyphicon glyphicon-import"></i> Messages reçus</a>
  	              </h4>
  	            </div>
  	            <div id="collapseMessagesRecus" class="panel-collapse collapse in" aria-expanded="true" style="">
  	              <div class="panel-body">
  	                
  	                  <small>
  	                    <div class="dataTable_wrapper">
  	                     <table class="table table-striped table-bordered table-hover" "="">
  	                       <thead>
  	                         <tr>
  	                           <th>Identifiant</th>
  	                           <th>Expediteur</th>
  	                           <th>Offre</th>
  	                           <th>Date d'envoi</th>
  	                           <th>Message</th>
  	                         </tr>
  	                       </thead>
  	                       <tbody>
  	                         <%for(MessageOffredemploi msgOf : candX.getMessageOffredemplois() ){
  	                    		 %>
  	                    		 <tr>
	  	                             <td><%=msgOf.getId() %></td>
	  	                             <td><a href="template.jsp?action=infos_candidature&amp;id=<%=msgOf.getCandidatureBean().getId()%>"><%=msgOf.getCandidatureBean().getAdresseemail() %></a></td>
	  	                             <td><a href="template.jsp?action=infos_offre&amp;id=<%=msgOf.getOffreEmploiBean().getId()%>"><%=msgOf.getOffreEmploiBean().getTitre()%></a></td>
	  	                             <td><%=msgOf.getDateenvoi()%></td>
	  	                             <td><%=msgOf.getCorpsmessage() %></td>
  	                           	</tr>
  	                    		 
  	                    		 <%  
  	                       }
  	                       %>
  	                       </tbody>
  	                     </table>
  	                   </div> <!-- /.table-responsive -->
  	                 </small>
  	                 
  	              </div>
  	            </div>
  	          </div>
  	          
  	        </div> <!-- /.panel-group -->

  	      </div> <!-- /.panel-body -->
  	    </div> <!-- /.panel -->
  	  </div> <!-- /.col-lg-12 -->

  	<% 
  	}

  }
  
  //action/=nouvelle_offre&titre=azdazd&descriptif_mission=azdazd&profil_recherche=azdazdazd&niveau=1&secteur=1&submit-insertion=#
%>


  

<!-- /.row -->


