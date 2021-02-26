<%@ page language="java" contentType="text/html" pageEncoding="ISO-8859-1"%>

<%@page import="eu.telecom_bretagne.cabinet_recrutement.front.utils.ServicesLocator,
                eu.telecom_bretagne.cabinet_recrutement.front.utils.Utils,
                eu.telecom_bretagne.cabinet_recrutement.service.IServiceOffreEmploi,
                eu.telecom_bretagne.cabinet_recrutement.data.model.OffreEmploi"%>
                
<%
  IServiceOffreEmploi serviceOffreEmploi = (IServiceOffreEmploi) ServicesLocator.getInstance().getRemoteInterface("ServiceOffreEmploi");
%>

<%
  String erreur = null;
  String idStringValue = request.getParameter("id");
  int id = -1;
  OffreEmploi offreEmploi = null;
  
  if(idStringValue == null)
  {
    erreur="Aucun identifiant d'entreprise n'est fourni dans la demande.";
  }
  else
  {
    try
    {
      id = new Integer(idStringValue);
      // C'est OK : on a bien un id
      IServiceOffreEmploi serviceEntreprise = (IServiceOffreEmploi) ServicesLocator.getInstance().getRemoteInterface("ServiceOffreEmploi");
      offreEmploi = serviceEntreprise.getOffreEmploi(id);
      if(offreEmploi == null)
      {
        erreur="Aucune offre d'emploie ne correspond à cet identifiant : " + id;
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
      <div class="panel-heading"><h3><i class="fa fa-th"></i> Informations sur l offre d emploie</h3></div> <!-- /.panel-heading -->
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
                  <td>OF_<%=offreEmploi.getId()%></td>
                </tr>
                <tr class="warning">
                  <td><strong>Titre</strong></td>
                  <td><%=offreEmploi.getTitre()%></td>
                </tr>
                <tr class="warning">
                  <td><strong>Entreprise</strong></td>
                  <td><%=offreEmploi.getEntrepriseBean().getNom()%></td>
                </tr>
                <tr class="warning">
                  <td><strong>Profil recherche</strong></td>
                  <td><%=offreEmploi.getProfilrecherche()%></td>
                </tr>
                <tr class="warning">
                  <td><strong>Niveau de qualification</strong></td>
                  <td><%=offreEmploi.getNiveauQualificationBean().getIntitule()%></td>
                </tr>
                <tr class="warning">
                  <td><strong>Secteur activite</strong></td>
                  <td><%=serviceOffreEmploi.GetSecteursString(offreEmploi)%></td>
                </tr>
                <tr class="warning">
                  <td><strong>Date de depot</strong></td>
                  <td><%=offreEmploi.getDatedepot()%></td>
                </tr>
                              
                <tr class="warning">
                  <td><strong>Descriptif</strong></td>
                  <td><%=Utils.text2HTML(offreEmploi.getDescriptifmission())%></td>
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
