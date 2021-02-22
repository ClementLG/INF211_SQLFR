<%@page import="eu.telecom_bretagne.cabinet_recrutement.service.IServiceSecteur"%>
<%@ page language="java" contentType="text/html" pageEncoding="ISO-8859-1"%>

<%@page import="eu.telecom_bretagne.cabinet_recrutement.front.utils.ServicesLocator,
                eu.telecom_bretagne.cabinet_recrutement.service.IServiceCandidature,
                eu.telecom_bretagne.cabinet_recrutement.data.model.Candidature,
                java.util.List"%>

<%
  IServiceCandidature serviceCandidature = (IServiceCandidature) ServicesLocator.getInstance().getRemoteInterface("ServiceCandidature");
  List<Candidature> candidatures = serviceCandidature.listeCandidature();
  IServiceSecteur serviceSecteur = (IServiceSecteur) ServicesLocator.getInstance().getRemoteInterface("ServiceSecteur");
  Object utilisateur = session.getAttribute("utilisateur");
  Candidature candX = (Candidature) utilisateur;
  //DEBUG DE KALITE
  //out.println("o------k :"+candX.getAdresseemail());
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
                <% /**FAUDRA AJOUTER A LA FIN...
                <div class="form-group">
                <input class="form-control" placeholder="Nom" name="nom" />
              </div>
              <div class="form-group">
                <input class="form-control" placeholder="Prénom" name="prenom" />
              </div>*/
                %>
                
                <div class="form-group">
                  <input class="form-control" placeholder="Date de naissance (format jj/mm/aaaa)" name="date_naissance" value=<%=candX.getDatenaissance() %>/>                
                </div>
                <div class="form-group">
                  <input class="form-control" placeholder="Adresse postale (ville)" name="adresse_postale" value=<%=candX.getAdressepostale() %> />
                </div>
                <div class="form-group">
                  <input class="form-control" placeholder="Adresse email" name="adresse_email" value=<%=candX.getAdresseemail() %> />
                </div>
                <div class="form-group">
                  <textarea class="form-control" placeholder="Curriculum vitæ" rows="5" name="cv"> <%out.println(candX.getCv()) ;%></textarea>       
                </div>
                <div class="col-lg-3">
                  <div class="form-group">
                    <label>Niveau de qualification</label>
                    <small>
                      
                        <div class="radio">
                          <label>
                            <input type="radio" name="niveau" value="1" <%if(candX.getNiveauqualificationBean().getId()==1) out.print("checked"); %>/>CAP/BEP
                          </label>
                        </div>
                        
                        <div class="radio">
                          <label>
                            <input type="radio" name="niveau" value="2" <%if(candX.getNiveauqualificationBean().getId()==2) out.print("checked"); %>/>Bac
                          </label>
                        </div>
                        
                        <div class="radio">
                          <label>
                            <input type="radio" name="niveau" value="3" <%if(candX.getNiveauqualificationBean().getId()==3) out.print("checked"); %>/>Bac+3
                          </label>
                        </div>
                        
                        <div class="radio">
                          <label>
                            <input type="radio" name="niveau" value="4" <%if(candX.getNiveauqualificationBean().getId()==4) out.print("checked"); %>/>Bac+5
                          </label>
                        </div>
                        
                        <div class="radio">
                          <label>
                            <input type="radio" name="niveau" value="5" <%if(candX.getNiveauqualificationBean().getId()==5) out.print("checked"); %>/>Doctorat
                          </label>
                        </div>
                        
                    </small>
                  </div>
                </div>
                <div class="col-lg-9">
                <div class="form-group">
                  <label>Secteur(s) d'activité</label>
                  <small>
                    <table border="0" width="100%">
                      <!-- Un petit système à la volée pour mettre les checkboxes en deux colonnes...  -->
                      
                            <tr>
                            <td>
                              <input type="checkbox" name="secteur" value="1" <%if(serviceCandidature.doesSectorExist(candX.getSecteuractivites(), 1)) out.print("checked");%>/> Achats/Logistique
                            </td>
                            
                            <td>
                              <input type="checkbox" name="secteur" value="2" <%if(serviceCandidature.doesSectorExist(candX.getSecteuractivites(), 2)) out.print("checked");%>/> Assistanat/Secrétariat
                            </td>
                            </tr>
                            
                            <tr>
                            <td>
                              <input type="checkbox" name="secteur" value="3" <%if(serviceCandidature.doesSectorExist(candX.getSecteuractivites(), 3)) out.print("checked");%>/> Agriculture
                            </td>
                            
                            <td>
                              <input type="checkbox" name="secteur" value="4" <%if(serviceCandidature.doesSectorExist(candX.getSecteuractivites(), 4)) out.print("checked");%>/> Agroalimentaire
                            </td>
                            </tr>
                            
                            <tr>
                            <td>
                              <input type="checkbox" name="secteur" value="5" <%if(serviceCandidature.doesSectorExist(candX.getSecteuractivites(), 5)) out.print("checked");%>/> Assurance
                            </td>
                            
                            <td>
                              <input type="checkbox" name="secteur" value="6" <%if(serviceCandidature.doesSectorExist(candX.getSecteuractivites(), 6)) out.print("checked");%>/> Audit/Conseil/Expertises
                            </td>
                            </tr>
                            
                            <tr>
                            <td>
                              <input type="checkbox" name="secteur" value="7" <%if(serviceCandidature.doesSectorExist(candX.getSecteuractivites(), 7)) out.print("checked");%>/> BTP/Immobilier
                            </td>
                            
                            <td>
                              <input type="checkbox" name="secteur" value="8" <%if(serviceCandidature.doesSectorExist(candX.getSecteuractivites(), 8)) out.print("checked");%>/> Commercial
                            </td>
                            </tr>
                            
                            <tr>
                            <td>
                              <input type="checkbox" name="secteur" value="9" <%if(serviceCandidature.doesSectorExist(candX.getSecteuractivites(), 9)) out.print("checked");%>/> Communication/Art/Média/Mode
                            </td>
                            
                            <td>
                              <input type="checkbox" name="secteur" value="10" <%if(serviceCandidature.doesSectorExist(candX.getSecteuractivites(), 10)) out.print("checked");%>/> Comptabilité
                            </td>
                            </tr>
                            
                            <tr>
                            <td>
                              <input type="checkbox" name="secteur" value="11" <%if(serviceCandidature.doesSectorExist(candX.getSecteuractivites(), 11)) out.print("checked");%>/> Direction Générale/Executive
                            </td>
                            
                            <td>
                              <input type="checkbox" name="secteur" value="12" <%if(serviceCandidature.doesSectorExist(candX.getSecteuractivites(), 12)) out.print("checked");%>/> Distribution/Commerce
                            </td>
                            </tr>
                            
                            <tr>
                            <td>
                              <input type="checkbox" name="secteur" value="13" <%if(serviceCandidature.doesSectorExist(candX.getSecteuractivites(), 13)) out.print("checked");%>/> Electronique/Microélectronique
                            </td>
                            
                            <td>
                              <input type="checkbox" name="secteur" value="14" <%if(serviceCandidature.doesSectorExist(candX.getSecteuractivites(), 14)) out.print("checked");%>/> Environnement
                            </td>
                            </tr>
                            
                            <tr>
                            <td>
                              <input type="checkbox" name="secteur" value="15" <%if(serviceCandidature.doesSectorExist(candX.getSecteuractivites(), 15)) out.print("checked");%>/> Finance/Banque
                            </td>
                            
                            <td>
                              <input type="checkbox" name="secteur" value="16" <%if(serviceCandidature.doesSectorExist(candX.getSecteuractivites(), 16)) out.print("checked");%>/> Formation/Enseignement
                            </td>
                            </tr>
                            
                            <tr>
                            <td>
                              <input type="checkbox" name="secteur" value="17" <%if(serviceCandidature.doesSectorExist(candX.getSecteuractivites(), 17)) out.print("checked");%>/> Hôtellerie/Restauration/Tourisme
                            </td>
                            
                            <td>
                              <input type="checkbox" name="secteur" value="18" <%if(serviceCandidature.doesSectorExist(candX.getSecteuractivites(), 18)) out.print("checked");%>/> Industrie/Ingénierie/Production
                            </td>
                            </tr>
                            
                            <tr>
                            <td>
                              <input type="checkbox" name="secteur" value="19" <%if(serviceCandidature.doesSectorExist(candX.getSecteuractivites(), 19)) out.print("checked");%>/> Informatique
                            </td>
                            
                            <td>
                              <input type="checkbox" name="secteur" value="20" <%if(serviceCandidature.doesSectorExist(candX.getSecteuractivites(), 20)) out.print("checked");%>/> Juridique/Fiscal/Droit
                            </td>
                            </tr>
                            
                            <tr>
                            <td>
                              <input type="checkbox" name="secteur" value="21" <%if(serviceCandidature.doesSectorExist(candX.getSecteuractivites(), 21)) out.print("checked");%>/> Marketing
                            </td>
                            
                            <td>
                              <input type="checkbox" name="secteur" value="22" <%if(serviceCandidature.doesSectorExist(candX.getSecteuractivites(), 22)) out.print("checked");%>/> Public/Parapublic
                            </td>
                            </tr>
                            
                            <tr>
                            <td>
                              <input type="checkbox" name="secteur" value="23" <%if(serviceCandidature.doesSectorExist(candX.getSecteuractivites(), 23)) out.print("checked");%>/> Ressources Humaines
                            </td>
                            
                            <td>
                              <input type="checkbox" name="secteur" value="24" <%if(serviceCandidature.doesSectorExist(candX.getSecteuractivites(), 24)) out.print("checked");%>/> Santé/Social/Biologie/Humanitaire
                            </td>
                            </tr>
                            
                            <tr>
                            <td>
                              <input type="checkbox" name="secteur" value="25" <%if(serviceCandidature.doesSectorExist(candX.getSecteuractivites(), 25)) out.print("checked");%>/> Télécom/Réseaux
                            </td>
                            
                              <td>&nbsp;</td>
                              </tr>
                              
                    </table>                
                  </small>
                </div>
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
	//?action=nouvelle_candidature&date_naissance=a&adresse_postale=b&adresse_email=c&cv=d&niveau=5&secteur=23&submit-insertion=
//Pas de nom prenom car on a zappe che pas pk...
if(request.getParameter("submit-insertion") != null){
	if(request.getParameter("date_naissance").matches("((0?[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/\\d{4})")
	&& request.getParameter("adresse_postale").length() >0
	&& request.getParameter("adresse_email").matches("[a-z0-9.-]+@[a-z0-9.-]+\\.[a-zA-Z]{2,6}")
	&& request.getParameter("cv").length() >0
	&& request.getParameter("niveau").length() >0
	&& request.getParameter("secteur").length() >0
	){
		candX.setAdresseemail(request.getParameter("adresse_email"));
		candX.setAdressepostale(request.getParameter("adresse_postale"));
		candX.setCv(request.getParameter("cv"));
		candX.setDatenaissance(serviceCandidature.convertDate(request.getParameter("date_naissance")));
		candX.setNiveauQualificationBean(serviceCandidature.findNQByID(Integer.parseInt(request.getParameter("niveau"))));

		candX = serviceCandidature.execUpdate(candX);
		session.setAttribute("utilisateur",candX);
		
		//out.println("iDDDDDDDDDDDDDDDDDDDDDDD = "+cand_ok.getId());
		//serviceCandidature.majSecteursActivites(request.getParameterValues("secteur"), cand_ok.getId());
		//rediriger vers un truc, persite returne lentreprise et donc l ID --cllg
		out.println("<h1 style=\"color: green;text-align: center\"> Candidature MAJ ! </h1>");
		response.sendRedirect("index.jsp");
	
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
