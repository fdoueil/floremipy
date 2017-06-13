<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8" name="viewport" content="width=device-width, initial-scale=1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Playball" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
<script src="js/script.js" type="text/javascript" language="javascript"></script>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>


<body>
	<div class="container-fluid bg-grey" id="menu">	
				<div class="container-fluid bg-grey" id="menu">
				<ul class="nav nav-pills nav-stacked">
  					<li><a href=<c:url value="/"/>>Accueil</a></li>
  					<li><a href=<c:url value="/articleList"/>>Liste des articles</a></li>
  					<li><a href=<c:url value="choixModeLivraison"/>>Choix du mode de livraison</a></li>
  					<li><a href=<c:url value="commandeList"/>>Voir les commandes à livrer</a></li>
				</ul>
			</div>	
</body>
</html>