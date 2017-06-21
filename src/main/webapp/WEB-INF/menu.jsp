<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
	<div class="container" id="menu">
		<img src="/images/logo_floremipy.png">
		<ul class="nav nav-pills">
				 <li><a id="menuAccueil" href=<c:url value="/"/>>Accueil</a></li>

				 <c:if test="${userConnecte==null || userConnecte.getIdCustomer()==0}">
                 	<li><a id="menuLogin" href=<c:url value="/login"/>>Connexion</a></li>
                 </c:if>
                 <c:if test="${userConnecte!=null && userConnecte.getIdCustomer()>0}">
                 	<li><a id="menuLogout" href=<c:url value="/logout"/>>Déconnexion</a></li>
                 </c:if>	
                 <c:if test="${userConnecte.getRole()=='CLIENT'}">
                 	<li><a id="menuArticleList" href=<c:url value="/articleList"/>>Liste des articles</a></li>
                 	<li><a id="menuChoixModeLivraison" href=<c:url value="/choixModeLivraison"/>>Choix du mode de livraison</a></li>
                 	<li><a id="menuChoixAdresseLivraison" href=<c:url value="/choixAdresseLivraison"/>>Choix de l'adresse de livraison</a></li>
                 </c:if>
                 <c:if test="${userConnecte.getRole()=='JARDINIER'}">
                 	<li><a id="menuCommandeList" href=<c:url value="commandeList"/>>Liste des livraisons du jour</a></li>
                 </c:if>
		</ul>
	</div>	