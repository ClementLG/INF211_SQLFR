<%@ page language="java" contentType="text/html" pageEncoding="ISO-8859-1"%>

<%@page import="eu.telecom_bretagne.cabinet_recrutement.front.utils.ServicesLocator,
                eu.telecom_bretagne.cabinet_recrutement.service.IServiceCandidature,
                eu.telecom_bretagne.cabinet_recrutement.data.model.Candidature,
                java.util.List"%>

<%
  IServiceCandidature serviceCandidature = (IServiceCandidature) ServicesLocator.getInstance().getRemoteInterface("ServiceCandidature");
  List<Candidature> candidatures = serviceCandidature.listeCandidature();
%>

<div class="row">
  <div class="col-lg-12">
    <div class="panel panel-default">
      <div class="panel-heading"><h3><i class="fa fa-th"></i> Liste des candidatures r�f�renc�es </h3></div> <!-- /.panel-heading -->
      <div class="panel-body">
        <div class="dataTable_wrapper">
          <table class="table table-striped table-bordered table-hover" id="dataTables-example">
            <!--
              Nom des colonnes
            -->
            <thead>
              <tr>
                <th>Identifiant</th>
                <th>Adresse postale (ville)</th>
                <th>mail</th>
                <th>Niveau de qualification</th>
                <th>Date de depot</th>
              </tr>
            </thead>
            <!--
              Contenu du tableau
            -->
            <tbody>
              <%
              for(Candidature candidature : candidatures)
              {
                %>
                <tr>
                 <td>CAND_<%=candidature.getId()%></td>
                 <td><%=candidature.getAdressepostale()%></td>
                 <td><%=candidature.getAdresseemail()%></td>
                 <td><%=candidature.getNiveauQualificationBean().getIntitule()%></td>
                 <td><%=candidature.getDatedepot()%></td>
                  <td align="center"><a href="template.jsp?action=infos_candidature&id=<%=candidature.getId()%>"><i class="fa fa-eye fa-lg"></i></a></td>
                </tr>
                <%
              }
              %>
            </tbody>
          </table>
        </div> <!-- /.table-responsive -->
      </div> <!-- /.panel-body -->
    </div> <!-- /.panel -->
  </div> <!-- /.col-lg-12 -->
</div> <!-- /.row -->
