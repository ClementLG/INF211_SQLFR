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
  IServiceOffreEmploi serviceOffreEmploi = (IServiceOffreEmploi) ServicesLocator.getInstance().getRemoteInterface("ServiceOffreEmploi");
  IServiceEntreprise serviceEntreprise = (IServiceEntreprise) ServicesLocator.getInstance().getRemoteInterface("ServiceEntreprise");
  List<NiveauQualification> niveauqualif = serviceOffreEmploi.listeNiveauQualification();
  List<SecteurActivite> secteurActs = serviceOffreEmploi.listeSecteurs();
  Object utilisateur = session.getAttribute("utilisateur");
  Entreprise entX = (Entreprise) utilisateur;
  
  //action/=nouvelle_offre&titre=azdazd&descriptif_mission=azdazd&profil_recherche=azdazdazd&niveau=1&secteur=1&submit-insertion=#
%>

<%
if(request.getParameter("submit-insertion") != null){
	if(request.getParameter("titre").length() >0
	&& request.getParameter("descriptif_mission").length() >0
	&& request.getParameter("profil_recherche").length() >0
	&& request.getParameter("niveau").length() >0
	&& request.getParameter("secteur").length() >0){
		
		OffreEmploi of_ok = new OffreEmploi(
				serviceOffreEmploi.getCurrentDate(),
				request.getParameter("descriptif_mission"),
				request.getParameter("profil_recherche"),
				request.getParameter("titre"),
				entX,
				serviceOffreEmploi.findNQByID(Integer.parseInt(request.getParameter("niveau")))
				);
		
		try{
			of_ok = serviceOffreEmploi.execPersist(of_ok);
			entX.getOffreEmplois().add(of_ok);
			entX = serviceEntreprise.execUpdate(entX);
			serviceOffreEmploi.majSecteursActivites(request.getParameterValues("secteur"), of_ok.getId());
			entX=serviceEntreprise.getEntreprise(entX.getId());
			session.setAttribute("utilisateur", entX);
			out.println("<h1 style=\"color: green;text-align: center\"> offre ajout�e ! </h1>");
			
		} catch(Exception e){
			out.println("<h1 style=\"color: red;text-align: center\"> Erreur lors de l'ajout  ! </h1>");
			
		}
		
		
	}
}


%>
<!-- base code demo -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3>
					<i class="glyphicon glyphicon-transfer"></i> R�f�rencer une
					nouvelle offre d'emploi
				</h3>
			</div>
			<!-- /.panel-heading -->
			<div class="panel-body">

				<div
					class="col-lg-offset-2 col-lg-8
                        col-xs-12">
					<form role="form" action="template.jsp" method="get">
						<input type="hidden" name="action" value="nouvelle_offre" />
						<div class="form-group">
							<input class="form-control" placeholder="Titre de l'offre"
								name="titre" />
						</div>
						<div class="form-group">
							<textarea class="form-control"
								placeholder="Descriptif de la mission" rows="5"
								name="descriptif_mission"></textarea>
						</div>
						<div class="form-group">
							<textarea class="form-control" placeholder="Profil recherch�"
								rows="5" name="profil_recherche"></textarea>
						</div>
						<div class="col-lg-3">
							<div class="form-group">
								<label>Niveau de qualification</label> <small> <% for(NiveauQualification nq : niveauqualif){%>

									<div class="radio">
										<label> <input type="radio" name="niveau"
											value=<%=nq.getId() %> /><%=nq.getIntitule() %>
										</label>
									</div> <%} %>
								</small>
							</div>
						</div>
						<div class="col-lg-9">
							<div class="form-group">
								<label>Secteur(s) d'activit�</label> <small>
									<table border="0" width="100%">
										<!-- Un petit syst�me � la vol�e pour mettre les checkboxes en deux colonnes...  -->
										<%
                      		int i=0;
                      		for(SecteurActivite s : secteurActs) {
                      			i++;
                      			if(i%2 == 0) {%>

										<td><input type="checkbox" name="secteur"
											value=<%=s.getId()%> /><%=s.getIntitule()%></td>
										</tr>
										<%} else{%>
										<tr>
											<td><input type="checkbox" name="secteur"
												value=<%=s.getId()%> /><%=s.getIntitule()%></td>

											<%} %>
											<%} 
                      		if(i%2==1) out.println("</tr>");%>
										
									</table>
								</small>
							</div>
						</div>
						<div class="text-center">
							<button type="submit" class="btn btn-success btn-circle btn-lg"
								name="submit-insertion">
								<i class="fa fa-check"></i>
							</button>
							<button type="reset" class="btn btn-warning btn-circle btn-lg">
								<i class="fa fa-times"></i>
							</button>
						</div>
					</form>
				</div>

			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->


