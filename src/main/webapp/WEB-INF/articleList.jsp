<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta charset="utf-8" name="viewport" content="width=device-width, initial-scale=1">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link type="text/css" rel="stylesheet" href="css/floremipy.css" />
	<link href="https://fonts.googleapis.com/css?family=Playball" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>

<body>
    <img src="/images/verdure_low_sized.jpg" width="100%" height="100%" style="position:absolute;">
	<div class="row">
		<div class="col-md-2">
			<c:import url="/WEB-INF/menu.jsp" />
		</div>
		<div class="col-md-1"></div>
		<div class="col-md-8 text-center">	
			<div>
    			<h3>Liste des articles disponibles</h3> 
  			</div>
  		</div>	
  		<div class="col-md-1"></div>
	</div>
	<div class="row spacer">
		<div class="col-md-12"></div>
	</div>		
	<div class="container">
		<form id="form" >
		<input id="idArticlePrixToAdd" name="idArticlePrixToAdd" type="hidden"></input>	
		<input id="idArticlePrixToDel" name="idArticlePrixToDel" type="hidden"></input>		
				<div class="row">
				   
					<div class="col-md-3">
							<%--  <c:set var = "errorConnected" scope = "session" value = "${false}"/>--%>
					</div>
					<br>
					
					<div class="col-md-9">
					<h3 id = "TitreBas">Stock dispo internet</h3>
						<table class="table table-hover">
						    <thead>
						      <tr>
						      <th>Nom</th>
						      <th>Image</th>
						      <th>Description</th>
						      <th>Prix</th>
						      <th>Quantité en stock</th>
						      <th>Ajouter un article</th>
						      </tr>
						    </thead>
						    <tbody>
						      <c:forEach var="articlePrixDTO" items="${articlePrixDTOListeHaut}">
     								<tr>
          								<td><c:out value="${articlePrixDTO.name}"/></td>
          								<td><img src="${pageContext.request.contextPath}/images/${articlePrixDTO.img}" height = "100px"/></td>
          								<td><c:out value="${articlePrixDTO.description}" /></td>
          								<td><c:out value="${articlePrixDTO.priceValue}" /></td>
          								<td><c:out value="${articlePrixDTO.quantityInStock}" /></td>
          								<td><a href=<c:url value="articleList/add/${articlePrixDTO.id}"/>><span class=" glyphicon glyphicon-plus"></span></a></td>
          							</tr>	
     							</c:forEach>
						    </tbody>
					  	</table>
					  </div>	
					  
					  <div class="col-md-9">
					  <h3 id = "TitreBas">Contenu de la commande</h3>
						<table class="table table-hover">
						    <thead>
						      <tr>
						      <th>Nom</th>
						      <th>Image</th>
						      <th>Description</th>
						      <th>Prix</th>
						      <th>Quantité en stock</th>
						      <th>Quantité commandée</th>
						      <th>Retirer un article</th>
						      </tr>
						    </thead>
						    <tbody>
						      <c:forEach var="articlePrixDTO" items="${articlePrixDTOListeBas}">
     								<tr>
          								<td><c:out value="${articlePrixDTO.name}"/></td>
          								<td><img src="${pageContext.request.contextPath}/images/${articlePrixDTO.img}" height = "100px"/></td>
          								<td><c:out value="${articlePrixDTO.description}" /></td>
          								<td><c:out value="${articlePrixDTO.priceValue}" /></td>
          								<td><c:out value="${articlePrixDTO.quantityInStock}" /></td>
          								<td><input class="form-control input-sm" id=idQteCommandee type="text" name="idQteCommandee" value="${articlePrixDTO.quantityOrder}"></td>
          								<td ><a href=<c:url value="articleList/del/${articlePrixDTO.id}"/>><span class=" glyphicon glyphicon-remove"></span></a></td>
          							</tr>	
     							</c:forEach>
						    </tbody>
					  	</table>
					  </div>	
					  <div class="col-sm-6 form-group">
								<button class="btn btn-default btn-md col-sm-8" value="Commander">
								<a style="vertical-align: middle" href=<c:url value="articleList/addCommande"/>>Commander <span class="glyphicon glyphicon-ok"></span></a>
								</button>
							</div>
				 </div> 
			</div>
		</form>				 
	</div>
	<script type="text/javascript">
	function add(idProduit){
	    document.getElementById("idArticlePrixToAdd").value=idProduit;
	    /*  document.getElementById("form").submit();*/
	}
	function del(idProduit){
		document.getElementById("idArticlePrixToDel").value=idProduit;
	    /*document.getElementById("form").submit();*/
	}
	</script>
</body>
</html>