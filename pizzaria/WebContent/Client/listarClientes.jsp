<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/materialize.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link rel="stylesheet" href="../css/main.css">
<link rel="stylesheet" href="../css/cadastrar-cliente.css">
</head>
<body>

	<jsp:include page="../imports/headerAdmin.jsp"></jsp:include>
	<h2>Listagem de funcionarios</h2>
	<div class="main-container ">

		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Item Name</th>
					<th>Item Price</th>
				</tr>
			</thead>

			<tbody>
				<tr>
					<td>Alvin</td>
					<td>Eclair</td>
					<td>$0.87</td>
				</tr>
				<tr>
					<td>Alan</td>
					<td>Jellybean</td>
					<td>$3.76</td>
				</tr>
				<tr>
					<td>Jonathan</td>
					<td>Lollipop</td>
					<td>$7.00</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>