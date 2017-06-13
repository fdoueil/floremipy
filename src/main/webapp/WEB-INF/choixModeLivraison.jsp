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
				   <input id ="idTypeModeLivraison" name="idTypeModeLivraison" type="hidden"></input>	
					<div class="col-md-12">
							<%--  <c:set var = "errorConnected" scope = "session" value = "${false}"/>--%>
							<c:import url="/WEB-INF/menu.jsp" />
					</div>
					<br>
					
					<div class="col-md-12">
					<div class="well col-sm-6">
						<h3>Choix du mode de livraison</h3>
							<div class="container bg-grey col-sm-8 input-group">						
							<br>							
								<label class="radio-inline" onclick="add(0)"><input type="radio" name="optradio" checked>Livraison par Transporteur</label> 
								<label class="radio-inline" onclick="add(1)"><input type="radio" name="optradio">Livraison par la poste</label>
								<label class="radio-inline" onclick="add(2)"><input type="radio" name="optradio">Livraison par le magasin</label> 
								<label class="radio-inline" onclick="add(3)"><input type="radio" name="optradio">Reception par le client au magasin</label> 						
							<br>
							</div>
				 	</div> 
				 	<div class="col-sm-12 form-group">
								<button class="btn btn-default btn-md col-sm-6" value="Valider" type = "submit">
								<a style="vertical-align: middle" href=<c:url value="/choixModeLivraison/validate/${idTypeModeLivraison}"/>>Validation <span class="glyphicon glyphicon-ok"></span></a>
								</button>
					</div>
  				</div>	
			</div>
		</form>				 
	</div>
	<script type="text/javascript">
	function add(idProduit){
	    document.getElementById("idTypeModeLivraison").value=idProduit;
	}
	</script>
	
</body>
</html>