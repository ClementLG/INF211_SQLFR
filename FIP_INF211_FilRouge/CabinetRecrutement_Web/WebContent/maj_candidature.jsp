<%@page import="eu.telecom_bretagne.cabinet_recrutement.data.model.SecteurActivite"%>
<%@page import="eu.telecom_bretagne.cabinet_recrutement.data.model.NiveauQualification"%>
<%@page import="eu.telecom_bretagne.cabinet_recrutement.service.IServiceSecteur"%>
<%@ page language="java" contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@page import="eu.telecom_bretagne.cabinet_recrutement.front.utils.ServicesLocator,
                eu.telecom_bretagne.cabinet_recrutement.service.IServiceCandidature,
                eu.telecom_bretagne.cabinet_recrutement.data.model.Candidature,
                java.util.List"%>

<%
  IServiceCandidature serviceCandidature = (IServiceCandidature) ServicesLocator.getInstance().getRemoteInterface("ServiceCandidature");
  List<Candidature> candidatures = serviceCandidature.listeCandidature();
  List<NiveauQualification> niveauqualif = serviceCandidature.listeNiveauQualification();
  List<SecteurActivite> secteurActs = serviceCandidature.listeSecteurs();
  IServiceSecteur serviceSecteur = (IServiceSecteur) ServicesLocator.getInstance().getRemoteInterface("ServiceSecteur");
  Object utilisateur = session.getAttribute("utilisateur");
  Candidature candX = (Candidature) utilisateur;
  //DEBUG DE KALITE
  //out.println("o------k :"+candX.getAdresseemail());
%>
<%
	//?action=nouvelle_candidature&date_naissance=a&adresse_postale=b&adresse_email=c&cv=d&niveau=5&secteur=23&submit-insertion=
//Pas de nom prenom car on a zappe che pas pk...
if(request.getParameter("submit-insertion") != null){
	if(request.getParameter("date_naissance").matches("((0?[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/\\d{4})")
	&& request.getParameter("adresse_postale").length() >0
	&& request.getParameter("adresse_email").matches("[a-z0-9.-]+@[a-z0-9.-]+\\.[a-zA-Z]{2,6}")
	&& request.getParameter("cv").length() >0
	&& request.getParameter("niveau").length() >0
	&& request.getParameter("nom").length() >0
	&& request.getParameter("prenom").length() >0
	&& request.getParameter("secteur").length() >0
	){
		candX.setNom(request.getParameter("nom"));
		candX.setPrenom(request.getParameter("prenom"));
		candX.setAdresseemail(request.getParameter("adresse_email"));
		candX.setAdressepostale(request.getParameter("adresse_postale"));
		candX.setCv(request.getParameter("cv"));
		candX.setDatenaissance(serviceCandidature.convertDate(request.getParameter("date_naissance")));
		candX.setNiveauQualificationBean(serviceCandidature.findNQByID(Integer.parseInt(request.getParameter("niveau"))));
		candX=serviceCandidature.execUpdate(candX);
		candX = serviceCandidature.RAZsecteurs(candX.getId());
		serviceCandidature.majSecteursActivites(request.getParameterValues("secteur"), candX.getId());
		candX=serviceCandidature.getCandidature(candX.getId());
		session.setAttribute("utilisateur",candX);
		
		//out.println("iDDDDDDDDDDDDDDDDDDDDDDD = "+cand_ok.getId());
		//serviceCandidature.majSecteursActivites(request.getParameterValues("secteur"), cand_ok.getId());
		//rediriger vers un truc, persite returne lentreprise et donc l ID --cllg
		out.println("<h1 style=\"color: green;text-align: center\"> Candidature MAJ ! </h1>");
	
	} else {
		if (!request.getParameter("date_naissance").matches("((0?[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/\\d{4})")
		&& request.getParameter("date_naissance").length() > 0) {
	out.println("<h2 style=\"color: red;text-align: center\"> Date  au incorrecte !  (jj/mm/aaaa) ! </h2>");
		} else if (!request.getParameter("adresse_email").matches("[a-z0-9.-]+@[a-z0-9.-]+\\.[a-zA-Z]{2,6}")
		&& request.getParameter("adresse_email").length() > 0) {

	out.println(
			"<h2 style=\"color: red;text-align: center\"> adresse email incorrecte ! (exemple@fournisseur.ex) </h2>");
		} else
	out.println("<h2 style=\"color: red;text-align: center\"> merci de rentrer des champs ! </h2>");
	}
}
%>
<!-- base code demo -->
<div class="row">
  <div class="col-lg-12">
    <div class="panel panel-default">
      <div class="panel-heading"><h3><i class="fa fa-user"></i> Mise à jour de la candidature</h3></div> <!-- /.panel-heading -->
      <div class="panel-body">
        
            <div class="col-lg-offset-2 col-lg-8
                        col-xs-12">
              <form role="form" action="template.jsp" method="get">
                <input type="hidden" name="action" value="maj_candidature" />

				<div class="form-group">
					<input class="form-control" placeholder="Prénom" name="prenom" value="<%=candX.getPrenom()%>"/>
				</div>
				<div class="form-group">
					<input class="form-control" placeholder="Nom" name="nom" value="<%=candX.getNom()%>"/>
				</div>

				<div class="form-group">
                  <input class="form-control" placeholder="Date de naissance (format jj/mm/aaaa)" name="date_naissance" value="<%=serviceCandidature.convertDatetoString(candX.getDatenaissance())%>"/>                
                </div>
                <div class="form-group">
                  <input class="form-control" placeholder="Adresse postale (ville)" name="adresse_postale" value="<%=candX.getAdressepostale() %>" />
                </div>
                <div class="form-group">
                  <input class="form-control" placeholder="Adresse email" name="adresse_email" value="<%=candX.getAdresseemail() %>" />
                </div>
                <div class="form-group">
                  <textarea class="form-control" placeholder="Curriculum vitæ" rows="5" name="cv"> <%=candX.getCv()%></textarea>       
                </div>
                <div class="col-lg-3">
                  <div class="form-group">
                    <label>Niveau de qualification</label>
                    <small>
                    <% for(NiveauQualification nq : niveauqualif){%>
                      
                        <div class="radio">
                          <label>
                            <input type="radio" name="niveau" value="<%=nq.getId()%>" <%if(candX.getNiveauQualificationBean().getId().equals(nq.getId())) out.println("checked");%>/><%=nq.getIntitule()%>
                            <%//if(candX.getNiveauqualificationBean().getId()==nq.getId()) out.println("checked"); %>
                          </label>
                        </div>
                        <%} %>                         
                    </small>
                  </div>
                </div>
                <div class="col-lg-9">
                <div class="form-group">
                  <label>Secteur(s) d'activité</label>
                  <small>
                    <table border="0" width="100%">
                      <!-- Un petit système à la volée pour mettre les checkboxes en deux colonnes...  -->
                      		<%
                      		int i=0;
                      		for(SecteurActivite s : secteurActs) {
                      			i++;
                      			if(i%2 == 0) {%>
		                            
		                            <td>
		                              <input type="checkbox" name="secteur" value="<%=s.getId()%>" <%if(serviceCandidature.doesSectorExist(candX.getSecteurActivites(), s.getId())) out.println("checked"); %>/><%=s.getIntitule()%>
		                            </td>
		                            </tr>
                            	<%} else{%>
                            		<tr>
		                            <td>
		                              <input type="checkbox" name="secteur" value="<%=s.getId()%>" <%if(serviceCandidature.doesSectorExist(candX.getSecteurActivites(), s.getId())) out.println("checked"); %>/><%=s.getIntitule()%>
		                            </td>
		                            
                            	<%} %>
                            <%} 
                      		if(i%2==1) out.println("</tr>");%>
                              
                    </table>                
                  </small>
                </div>
                </div>
                <div class="text-center">
                  <button type="submit" class="btn btn-success btn-circle btn-lg" name="submit-insertion"><i class="fa fa-check"></i></button>
              	  </button>
              </form>
            </div>
            <div class="col-lg-12 text-center">
              <br/>
              <!-- Button trigger modal -->
              <button class="btn btn-danger" data-toggle="modal" data-target="#modalSuppressionCandidature">
                <i class="glyphicon glyphicon-remove-sign fa-lg"></i> Supprimer cette candidature
              </button>
              <!-- Modal -->
              <div class="modal fade" id="modalSuppressionCandidature" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
                <div class="modal-dialog">
                  <div class="modal-content">
                    <div class="modal-header">
                      <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                      <h4 class="modal-title" id="myModalLabel">Êtes-vous sûr de vouloir supprimer votre candidature ?</h4>
                    </div>
                    <div class="modal-body">
                      Attention, cette opération n'est pas réversible !
                    </div>
                    <div class="modal-footer">
                      <button type="button" class="btn btn-default" data-dismiss="modal">Annuler</button>
                      <button type="button"
                              class="btn btn-primary"
                              onclick="window.location.href='suppression_candidature.jsp?id_candidature=13'">
                        Supprimer
                      </button>
                    </div>
                  </div> <!-- /.modal-content -->
                </div> <!-- /.modal-dialog -->
              </div> <!-- /.modal -->
            </div>
            
      </div> <!-- /.panel-body -->
    </div> <!-- /.panel -->
  </div> <!-- /.col-lg-12 -->
</div> <!-- /.row -->

