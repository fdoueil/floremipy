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
<link href="https://fonts.googleapis.com/css?family=Playball" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
</head>

<style>
body {
	background-color:#b3cadb;
    font: 16px 'Ubuntu', sans-serif;
	line-height:1.4;
	padding: 10px;
	color:#5e91b2;
}



.input-group {
      border-radius: 0;
      margin-left: 15px;
      text-transform: uppercase;
      padding-left: 5px;
  }
  
  .btn-default {
      border-radius: 0;
      margin-left: 0px;
  }

.glyphicon{
color:#5e91b2;
}

td{
margin-left: 30px;
color:#5e91b2;
font-size: 10px;
background-color:#f4f5f7;
}

glyphicon glyphicon-plus{
cursor:pointer;
}

table{
margin-left: -15px;
}
 thead{
 border-radius: 5px;
 background-color:#dce2f2;
 color:#5e91b2;
 font-size: 12px;
 }
 
#TitreHaut, #TitreBas{
	color:#5e91b2;
}

#idQteCommandee{
 background-color:#dce2f2;
 color:#ba3e30;
 font-size: 12px;
}

</style>


<body>
	<div class="container">
		<form id="form" >
		<input id="idArticlePrixToAdd" name="idArticlePrixToAdd" type="hidden"></input>	
		<input id="idArticlePrixToDel" name="idArticlePrixToDel" type="hidden"></input>		
				<div class="row">
				   
					<div class="col-md-3">
							<%--  <c:set var = "errorConnected" scope = "session" value = "${false}"/>--%>
							<c:import url="/WEB-INF/menu.jsp" />
					</div>
					<br>
					
					<div class="col-md-9">
					<h3 id = "TitreHaut">Liste des commandes à livrer</h3>
						<table class="table table-hover">
						    <thead>
						      <tr>
						      <th>Nom du client</th>
						      <th>Adresse</th>
						      <th>Refrérence commande</th>
						      <th>Total commande</th>
						      <th>Date livraison</th>
						      </tr>
						    </thead>
						    <tbody>
						      <c:forEach var="commandListDTO" items="${COMMANDLISTDTO}">
     								<tr>
          								<td><c:out value="${commandListDTO.clientName}"/></td>
          								<td><c:out value="${commandListDTO.adress}"/></td>
          								<td><c:out value="${commandListDTO.commandReference}"/></td>
          								<td><c:out value="${commandListDTO.totalCommand}"/></td>
          								<td><fmt:formatDate type = "date" value = "${commandListDTO.deliveryDate}" /></td>
          							</tr>	
     							</c:forEach>
						    </tbody>
					  	</table>
					  </div>	
				
				 </div> 
			</div>
		</form>				 
	</div>
</body>
</html>