<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" charset="utf8" src="js/jquery-1.12.4.js"></script>
<link rel="stylesheet" type="text/css"
	href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css">
<link type="text/css" rel="stylesheet" href="css/floremipy.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

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
	<script type="text/javascript"
		src="js/jquery-1.12.4.js"></script>
	<script type="text/javascript"
		src="js/jquery.dataTables.min.js"></script>
	<script type="text/javascript">
		/*    {"id":123,"name":"olivier","category":"arbre","price":100.0,"stock":10,"description":"ceci est un olivier","imgsrc":"olivier.jpg"} */

		$(document).ready(function() {
			
			// ancien appel ajax
			/*$.ajax({
				type: "GET",
				url : "api/products",
				dataType : 'json',
				data : {},
				async : false,
				success : function(data) {
					//dataSet = $.parseJSON(data);
					dataSet = data;
				}
			});*/
			
			$('#demo')
					.html(
							'<table cellpadding="0" cellspacing="0" border="0" class="display" id="example"></table>');
			
			var table = $('#example').dataTable({
				ajax: {
					url:'../api/products',
					type: 'GET',
					dataSrc:''
					},
				columns: [ {
					title: "id",
					data: "id"
				}, {
					title: "name",
					data: "name"
				}, {
					title: "category",
					data: "category"
				}, {
					title: "price",
					data: "price"
				}, {
					title: "stock",
					data: "stock"
				}, {
					title: "description",
					data: "description"
				}, {
					title: "imgsrc",
					data: "imgsrc"
				} ]
			});
		});
		
	</script>





</body>
</html>