<%@ page language="java" contentType="text/html" pageEncoding="ISO-8859-1"%>

<%@page import="eu.telecom_bretagne.cabinet_recrutement.front.utils.ServicesLocator,
                eu.telecom_bretagne.cabinet_recrutement.service.IServiceEntreprise,
                eu.telecom_bretagne.cabinet_recrutement.data.model.Entreprise,
                java.util.List"%>

<%
  IServiceEntreprise serviceEntreprise = (IServiceEntreprise) ServicesLocator.getInstance().getRemoteInterface("ServiceEntreprise");
  List<Entreprise> entreprises = serviceEntreprise.listeDesEntreprises();
  //base code demo
%>

<!-- base code demo -->
<div class="row">
  <div class="col-lg-12">
    <div class="panel panel-default">
      <div class="panel-heading"><h3><i class="fa fa-th"></i> R�f�rencer une nouvelle entreprise</h3></div> <!-- /.panel-heading -->
      <div class="panel-body">
        
            <div class="col-lg-offset-2 col-lg-8
                        col-xs-12">
              <form role="form" action="template.jsp" method="get">
                <input type="hidden" name="action" value="nouvelle_entreprise" />
                <div class="form-group">
                  <input class="form-control" placeholder="Nom de l'entreprise" name="nom" />
                </div>
                <div class="form-group">
                  <textarea class="form-control" placeholder="Descriptif de l'entreprise" rows="5" name="descriptif"></textarea>
                </div>
                <div class="form-group">
                  <input class="form-control" placeholder="Adresse postale (ville)" name="adresse_postale" />
                </div>
                <div class="text-center">
                  <button type="submit" class="btn btn-success btn-circle btn-lg" name="submit-insertion"><i class="fa fa-check"></i></button>
                  <button type="reset"  class="btn btn-warning btn-circle btn-lg"><i class="fa fa-times"></i></button>
                </div>
              </form>
            </div>
            
      </div> <!-- /.panel-body -->
    </div> <!-- /.panel -->
  </div> <!-- /.col-lg-12 -->
</div> <!-- /.row -->
<%
//exemple et tests
//Entreprise ent_test = new Entreprise("42 rue du test", "Entreprise de Test", "TEST&CO");
//ent_test = entrepriseDAO.persist(ent_test);
//out.println(request.getParameter("adresse_postale")+ ","+request.getParameter("descriptif")+ ","+request.getParameter("nom"));

if(request.getParameter("submit-insertion") != null){
	if(request.getParameter("adresse_postale").length() >0
	&& request.getParameter("descriptif").length() >0
	&& request.getParameter("nom").length() >0){
		Entreprise ent_new = new Entreprise(request.getParameter("adresse_postale"), 
				request.getParameter("descriptif"),
				request.getParameter("nom"));
		serviceEntreprise.execPersist(ent_new);
		//rediriger vers un truc, persite returne lentreprise et donc l ID --cllg
		out.println("<h1 style=\"color: green;text-align: center\"> Entreprise ajout�e ! </h1>");
	}
	else {
		out.println("<h1 style=\"color: red;text-align: center\"> merci de rentrer des champs ! </h1>");
	}
}
//get
//action=nouvelle_entreprise&nom=test&descriptif=test&adresse_postale=plouzane&submit-insertion=
%>
        

