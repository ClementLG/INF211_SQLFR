<%@page import="eu.telecom_bretagne.cabinet_recrutement.service.IServiceCandidature"%>
<%@page import="eu.telecom_bretagne.cabinet_recrutement.data.model.Candidature"%>
<%@page import="eu.telecom_bretagne.cabinet_recrutement.front.utils.ServicesLocator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%
  IServiceCandidature serviceCandidature = (IServiceCandidature) ServicesLocator.getInstance().getRemoteInterface("ServiceCandidature");
  Object utilisateur = session.getAttribute("utilisateur");
  Candidature candX = (Candidature) utilisateur;
  serviceCandidature.supressionDuneCandidature(serviceCandidature.getCandidature(candX.getId()));
  
  session.invalidate();
  response.sendRedirect("index.jsp");
%>