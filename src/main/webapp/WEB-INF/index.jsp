<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" charset="utf8" src="js/jquery-1.12.4.js"></script>
<link rel="stylesheet" type="text/css"	href="https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css">
<link type="text/css" rel="stylesheet" href="css/floremipy.css" />
<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"	href="https://cdn.datatables.net/1.10.15/css/dataTables.bootstrap.min.css">
	
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>FloreMipy</title>
</head>
<body>
	<img src="/images/verdure_low_sized.jpg" width="100%" height="100%"
		style="position: absolute;">
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
		<div class="col-md-1">
			<h6><%=edd.floremipy.FloreMipyApplication.startDate.toString()%></h6>
		</div>
	</div>
	<div class="row spacer">
		<div class="col-md-12"></div>
	</div>

	<div id="demo"></div>
	<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
	<script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="js/dataTables.bootstrap.min.js"></script>
	<script type="text/javascript">
		/*    {"id":123,"name":"olivier","category":"arbre","price":100.0,"stock":10,"description":"ceci est un olivier","imgsrc":"olivier.jpg"} */

		$(document).ready(function() {
			
			$('#demo')
					.html(
							'<table id="example" class="table table-striped table-bordered" cellspacing="0" width="100%"></table>');
			
			var table = $('#example').dataTable({
				ajax: {
					url:'../api/products',
					type: 'GET',
					dataSrc:''
					},
				columns: [ {
					title: "Ref",
					data: "id"
				}, {
					title: "Nom",
					data: "name",
					orderable: false
				}, {
					title: "Catégorie",
					data: "category"
				}, {
					title: "Prix",
					data: "price"
				}, {
					title: "Stock",
					data: "stock"
				}, {
					title: "Description",
					data: "description",
					orderable: false
				}, {
					title: "Image",
					orderable: false,
                    "render": function (data, type, JsonResultRow, meta) {
                        return '<img src="/images/'+JsonResultRow.imgsrc+'" width="100px">';
                    }
                } ]
			});
		});
		
	</script>
</body>
</html>