<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
	<div class="container" id="menu">
		<img src="/images/logo_floremipy.png">
		<ul class="nav nav-pills">
				 <li><a id="menuAccueil" href=<c:url value="/"/>>Accueil</a></li>
                 <sec:authorize access="isAuthenticated()">
                 	<li><a id="menuLogout" href=<c:url value="/logout"/>>Déconnexion</a></li>
                 </sec:authorize>
				 <sec:authorize access="hasAnyRole('ADMIN','CLIENT')">
                 	<li><a id="menuArticleList" href=<c:url value="/articleList"/>>Liste des articles</a></li>
                 	<li><a id="menuChoixModeLivraison" href=<c:url value="/choixModeLivraison"/>>Choix du mode de livraison</a></li>
                 	<li><a id="menuChoixAdresseLivraison" href=<c:url value="/choixAdresseLivraison"/>>Choix de l'adresse de livraison</a></li>
                 </sec:authorize>
                 <sec:authorize access="hasAnyRole('ADMIN','JARDINIER')">
                 	<li><a id="menuCommandeList" href=<c:url value="commandeList"/>>Liste des livraisons du jour</a></li>
                 </sec:authorize>
		</ul>
	</div>	