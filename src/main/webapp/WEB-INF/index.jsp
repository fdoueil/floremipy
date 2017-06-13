<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" charset="utf8" src="js/jquery-1.12.4.js"></script>
	<link rel="stylesheet" type="text/css" href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css">
	<link type="text/css" rel="stylesheet" href="css/floremipy.css" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<title>FloreMipy</title>
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
    			<h3>Bienvenue dans FloreMiPy</h3> 
  			</div>
  	</div>	
  		<div class="col-md-1"></div>
	</div>
	<div class="row spacer">
		<div class="col-md-12"></div>
	</div>
	
   	<div id="demo"></div>
	<script type="text/javascript"
		src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
	<script type="text/javascript"
		src="http://cdn.datatables.net/1.10.6/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript">
		var dataSet = [ [ 'RefAA1', 'Palmier', '59', '100' ],
				[ 'RefAA2', 'Rosiers', '29', '200' ],
				[ 'RefAA3', 'Chrisanthème', '19', '10' ],
				[ 'RefAA4', 'Bananier', '9', '10' ],
				[ 'RefAA5', 'Olivier', '509', '10' ],
				[ 'RefAA6', 'Gazon', '0.1', '10000' ],
				[ 'RefAA7', 'Herbe gratuite', '0', '100' ], ];

		var ctr = 0;
		$("#update").click(function() {
			ctr++;
			dataSet.push([ ctr, ctr, ctr, ctr ]);
			console.log(JSON.stringify(dataSet));
		});

		$(document)
				.ready(
						function() {
							$('#demo')
									.html(
											'<table cellpadding="0" cellspacing="0" border="0" class="display" id="example"></table>');
							$('#example').dataTable({
								"data" : dataSet,
								"columns" : [ {
									"title" : "Reference"
								}, {
									"title" : "Nom"
								}, {
									"title" : "Prix en Euros"
								}, {
									"title" : "Quantité en stock",
								} ]
							});
						});
	</script>
	
</body>
</html>


