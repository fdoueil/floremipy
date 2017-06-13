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
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body>
<img src="/images/verdure_low_sized.jpg" width="100%" height="100%" style="position:absolute;">
	<div class="container">
		<form id="form" >
				<div class="row">
				   <input id ="idAdresseLivraison" name="idAdresseLivraison" type="hidden"></input>	
					<div class="col-md-12">
							<%--  <c:set var = "errorConnected" scope = "session" value = "${false}"/>--%>
							<c:import url="/WEB-INF/menu.jsp" />
					</div>
					<br>
					
					<div class="col-md-12">
					<div class="well col-sm-6">
					<h3>Adresse</h3>
					<div class="col-sm-8 input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon glyphicon-flag"></i></span> <input
							class="form-control" id=locationAdresseLivraison type="texte"
							name="locationAdresseLivraison" value="${locationAdresseLivraison}"
							placeholder="Adresse" required="required">
					</div>
					<br>
					<div class="col-sm-4 input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon glyphicon-flag"></i></span> <input
							class="form-control" id=zipCodeAdresseLivraison type="texte"
							name="zipCodeAdresseLivraison" value="${zipCodeAdresseLivraison}"
							placeholder="Code postal" required="required">
					</div>
					<br>
					<div class="col-sm-8 input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon glyphicon-flag"></i></span> <input
							class="form-control" id=cityAdresseLivraison type="texte"
							name="cityAdresseLivraison" value="${cityAdresseLivraison}"
							placeholder="Ville" required="required">
					</div>
				 	</div> 
				 	<div class="col-sm-12 form-group">
								<button class="btn btn-default btn-md col-sm-6" value="Valider" type = "submit">
								<a style="vertical-align: middle" href=<c:url value="/choixAdresseLivraison/validate/${idAdresseLivraison}/${locationAdresseLivraison}/${zipCodeAdresseLivraison}/${cityAdresseLivraison}"/>>Validation <span class="glyphicon glyphicon-ok"></span></a>
								</button>
					</div>
  				</div>	
			</div>
		</form>				 
	</div>
</body>
</html>