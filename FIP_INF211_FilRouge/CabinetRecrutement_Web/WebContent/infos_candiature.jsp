<%@ page language="java" contentType="text/html" pageEncoding="ISO-8859-1"%>

<%@page import="eu.telecom_bretagne.cabinet_recrutement.front.utils.ServicesLocator,
                eu.telecom_bretagne.cabinet_recrutement.front.utils.Utils,
                eu.telecom_bretagne.cabinet_recrutement.service.IServiceCandidature,
                eu.telecom_bretagne.cabinet_recrutement.data.model.Candidature"%>
<%
  IServiceCandidature serviceCandidature = (IServiceCandidature) ServicesLocator.getInstance().getRemoteInterface("ServiceCandature");
%>

<%
  String erreur = null;
  String idStringValue = request.getParameter("id");
  int id = -1;
  Candidature candidature = null;
  
  if(idStringValue == null)
  {
    erreur="Aucun identifiant de candidature n'est fourni dans la demande.";
  }
  else
  {
    try
    {
      id = new Integer(idStringValue);
      // C'est OK : on a bien un id
      IServiceCandidature serviceEntreprise = (IServiceCandidature) ServicesLocator.getInstance().getRemoteInterface("ServiceCandature");
      candidature = serviceEntreprise.getCandidature(id);
      if(candidature == null)
      {
        erreur="Aucune candidature ne correspond à cet identifiant : " + id;
      }
    }
    catch(NumberFormatException e)
    {
      erreur = "La valeur de l'identifiant n'est pas numérique";
    }
  }
%>

<div class="row">
  <div class="col-lg-12">
    <div class="panel panel-default">
      <div class="panel-heading"><h3><i class="fa fa-th"></i> Informations sur la candidature</h3></div> <!-- /.panel-heading -->
      <div class="panel-body">
        <%
        if(erreur != null) // Une erreur a été détectée et est affichée.
        {
         %>
         <div class="row col-xs-offset-1 col-xs-10">
           <div class="panel panel-red">
             <div class="panel-heading ">
               Impossible de traiter la demande
             </div>
             <div class="panel-body text-center">
               <p class="text-danger"><strong><%=erreur%></strong></p>
             </div>
           </div>
         </div> <!-- /.row col-xs-offset-1 col-xs-10 -->
         <%
         }
        else
        {
           %>
        <div class="table-responsive">
            <small>
            <table class="table">
              <tbody>
                <tr class="success">
                  <td width="200"><strong>Identifiant (login)</strong></td>
                  <td>CAND_<%=candidature.getId()%></td>
                </tr>
                <tr class="warning">
                  <td><strong>Adresse postale</strong></td>
                  <td><%=candidature.getAdressepostale()%></td>
                </tr>
                <tr class="warning">
                  <td><strong>Adresse email</strong></td>
                  <td><%=candidature.getAdresseemail()%></td>
                </tr>
                <tr class="warning">
                  <td><strong>Date de naissance</strong></td>
                  <td><%=candidature.getDatenaissance()%></td>
                </tr>
                <tr class="warning">
                  <td><strong>Niveau qualification</strong></td>
                  <td><%=candidature.getNiveauqualificationBean().getIntitule()%></td>
                </tr>
                <tr class="warning">
                  <td><strong>Secteur activite</strong></td>
                  <td><%=serviceCandidature.GetSecteursString(candidature)%></td>
                </tr>
                <tr class="warning">
                  <td><strong>Date de depot</strong></td>
                  <td><%=candidature.getDatedepot()%></td>
                </tr>
              </tbody>
            </table>
            </small>      
        </div>
          <%
        }
        %>
      </div> <!-- /.panel-body -->
    </div> <!-- /.panel -->
  </div> <!-- /.col-lg-12 -->
</div> <!-- /.row -->
