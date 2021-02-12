<%@ page language="java" contentType="text/html" pageEncoding="ISO-8859-1"%>

<%@page import="eu.telecom_bretagne.cabinet_recrutement.front.utils.ServicesLocator,
                eu.telecom_bretagne.cabinet_recrutement.service.IServiceCandidature,
                eu.telecom_bretagne.cabinet_recrutement.data.model.Candidature,
                java.util.List"%>

<%
  IServiceCandidature serviceCandidature = (IServiceCandidature) ServicesLocator.getInstance().getRemoteInterface("ServiceCandature");
  List<Candidature> candidatures = serviceCandidature.listeCandidature();
%>
<!-- base code demo -->
<div class="row">
  <div class="col-lg-12">
    <div class="panel panel-default">
      <div class="panel-heading"><h3><i class="fa fa-user"></i> DEV EN COURS - Référencer une nouvelle candidature</h3></div> <!-- /.panel-heading -->
      <div class="panel-body">
        
            <div class="col-lg-offset-2 col-lg-8
                        col-xs-12">
              <form role="form" action="template.jsp" method="get">
                <input type="hidden" name="action" value="nouvelle_candidature" />
                <% /**FAUDRA AJOUTER A LA FIN...
                <div class="form-group">
                <input class="form-control" placeholder="Nom" name="nom" />
              </div>
              <div class="form-group">
                <input class="form-control" placeholder="Prénom" name="prenom" />
              </div>*/
                %>
                
                <div class="form-group">
                  <input class="form-control" placeholder="Date de naissance (format jj/mm/aaaa)" name="date_naissance" />
                </div>
                <div class="form-group">
                  <input class="form-control" placeholder="Adresse postale (ville)" name="adresse_postale" />
                </div>
                <div class="form-group">
                  <input class="form-control" placeholder="Adresse email" name="adresse_email" />
                </div>
                <div class="form-group">
                  <textarea class="form-control" placeholder="Curriculum vitæ" rows="5" name="cv"></textarea>
                </div>
                <div class="col-lg-3">
                  <div class="form-group">
                    <label>Niveau de qualification</label>
                    <small>
                      
                        <div class="radio">
                          <label>
                            <input type="radio" name="niveau" value="1" />CAP/BEP
                          </label>
                        </div>
                        
                        <div class="radio">
                          <label>
                            <input type="radio" name="niveau" value="2" />Bac
                          </label>
                        </div>
                        
                        <div class="radio">
                          <label>
                            <input type="radio" name="niveau" value="3" />Bac+3
                          </label>
                        </div>
                        
                        <div class="radio">
                          <label>
                            <input type="radio" name="niveau" value="4" />Bac+5
                          </label>
                        </div>
                        
                        <div class="radio">
                          <label>
                            <input type="radio" name="niveau" value="5" />Doctorat
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
                              <input type="checkbox" name="secteur" value="1" /> Achats/Logistique
                            </td>
                            
                            <td>
                              <input type="checkbox" name="secteur" value="2" /> Assistanat/Secrétariat
                            </td>
                            </tr>
                            
                            <tr>
                            <td>
                              <input type="checkbox" name="secteur" value="3" /> Agriculture
                            </td>
                            
                            <td>
                              <input type="checkbox" name="secteur" value="4" /> Agroalimentaire
                            </td>
                            </tr>
                            
                            <tr>
                            <td>
                              <input type="checkbox" name="secteur" value="5" /> Assurance
                            </td>
                            
                            <td>
                              <input type="checkbox" name="secteur" value="6" /> Audit/Conseil/Expertises
                            </td>
                            </tr>
                            
                            <tr>
                            <td>
                              <input type="checkbox" name="secteur" value="7" /> BTP/Immobilier
                            </td>
                            
                            <td>
                              <input type="checkbox" name="secteur" value="8" /> Commercial
                            </td>
                            </tr>
                            
                            <tr>
                            <td>
                              <input type="checkbox" name="secteur" value="9" /> Communication/Art/Média/Mode
                            </td>
                            
                            <td>
                              <input type="checkbox" name="secteur" value="10" /> Comptabilité
                            </td>
                            </tr>
                            
                            <tr>
                            <td>
                              <input type="checkbox" name="secteur" value="11" /> Direction Générale/Executive
                            </td>
                            
                            <td>
                              <input type="checkbox" name="secteur" value="12" /> Distribution/Commerce
                            </td>
                            </tr>
                            
                            <tr>
                            <td>
                              <input type="checkbox" name="secteur" value="13" /> Electronique/Microélectronique
                            </td>
                            
                            <td>
                              <input type="checkbox" name="secteur" value="14" /> Environnement
                            </td>
                            </tr>
                            
                            <tr>
                            <td>
                              <input type="checkbox" name="secteur" value="15" /> Finance/Banque
                            </td>
                            
                            <td>
                              <input type="checkbox" name="secteur" value="16" /> Formation/Enseignement
                            </td>
                            </tr>
                            
                            <tr>
                            <td>
                              <input type="checkbox" name="secteur" value="17" /> Hôtellerie/Restauration/Tourisme
                            </td>
                            
                            <td>
                              <input type="checkbox" name="secteur" value="18" /> Industrie/Ingénierie/Production
                            </td>
                            </tr>
                            
                            <tr>
                            <td>
                              <input type="checkbox" name="secteur" value="19" /> Informatique
                            </td>
                            
                            <td>
                              <input type="checkbox" name="secteur" value="20" /> Juridique/Fiscal/Droit
                            </td>
                            </tr>
                            
                            <tr>
                            <td>
                              <input type="checkbox" name="secteur" value="21" /> Marketing
                            </td>
                            
                            <td>
                              <input type="checkbox" name="secteur" value="22" /> Public/Parapublic
                            </td>
                            </tr>
                            
                            <tr>
                            <td>
                              <input type="checkbox" name="secteur" value="23" /> Ressources Humaines
                            </td>
                            
                            <td>
                              <input type="checkbox" name="secteur" value="24" /> Santé/Social/Biologie/Humanitaire
                            </td>
                            </tr>
                            
                            <tr>
                            <td>
                              <input type="checkbox" name="secteur" value="25" /> Télécom/Réseaux
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
		
		Candidature cand_ok = new Candidature(
		request.getParameter("adresse_email"), 
		request.getParameter("adresse_postale"), 
		request.getParameter("cv"),
		serviceCandidature.getCurrentDate(),
		serviceCandidature.convertDate(request.getParameter("date_naissance")),
		serviceCandidature.findNQByID(Integer.parseInt(request.getParameter("niveau")))
		);
		String[] sect = request.getParameterValues("secteur");
		
		cand_ok.setSecteurActivites(serviceCandidature.transformSecteurs(sect));
		serviceCandidature.execPersist(cand_ok);
		//rediriger vers un truc, persite returne lentreprise et donc l ID --cllg
		out.println("<h1 style=\"color: green;text-align: center\"> Entreprise ajoutée ! </h1>");
	
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
