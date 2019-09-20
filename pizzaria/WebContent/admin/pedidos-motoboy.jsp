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
<link rel="stylesheet" href="../css/side-bar-admin.css">
<link rel="stylesheet" href="../css/main.css">
</head>
<body>
	<!-- <nav> -->
	<!-- 		<a href="#" data-target="slide-out" class="sidenav-trigger"><i -->
	<!-- 			class="material-icons">menu</i></a> -->
	<!-- 		<div class="nav-wrapper main-menu"> -->

	<!-- 			<ul id="nav-mobile" class="right hide-on-med-and-down"> -->



	<!-- 			</ul> -->
	<!-- 		</div> -->
	<!-- 	</nav> -->

	<jsp:include page="imports/headerAdmin.jsp" />

	<div class="content bg-red-sal">
		<section class="side-content ">
			<div class="row">
				<h1 align="center">Pedidos do José</h1>
				<table>
					<tr>
						<td>Pedido</td>
						<td>Status</td>
						<td>Detelhes</td>
					</tr>
					<tr>
						<td>9999090</td>
						<td>Em andamento</td>

						<td><a href=""><i class="material-icons">add_box</i></a></td>
					</tr>
					<tr>
						<td>9999090</td>
						<td>Em andamento</td>

						<td><a href=""><i class="material-icons">add_box</i></a></td>
					</tr>
					<tr>
						<td>9999090</td>
						<td>Em andamento</td>
						<td><a href=""><i class="material-icons">add_box</i></a></td>
					</tr>
					<tr>
						<td>9999090</td>
						<td>Em andamento</td>
						<td><a href=""><i class="material-icons">add_box</i></a></td>
					</tr>
					<tr>
						<td>9999090</td>
						<td>Em andamento</td>
						<td><a href=""><i class="material-icons">add_box</i></a></td>
					</tr>
					<tr>
						<td>9999090</td>
						<td>Em andamento</td>
						<td><a href=""><i class="material-icons">add_box</i></a></td>
					</tr>
					<tr>
						<td>9999090</td>
						<td>Em andamento</td>
						<td><a href=""><i class="material-icons">add_box</i></a></td>
					</tr>
					<tr>
						<td>9999090</td>
						<td>Em andamento</td>
						<td><a href=""><i class="material-icons">add_box</i></a></td>
					</tr>
					<tr>
						<td>9999090</td>
						<td>Em andamento</td>
						<td><a href=""><i class="material-icons">add_box</i></a></td>
					</tr>
				</table>

			</div>

		</section>
		<div class="clear"></div>
	</div>
	
	

	<jsp:include page="imports/footer-admin.jsp" />

	
	<script>
		$('.navbar-fixed').attr('class', 'navbar');
	</script>

</body>
</html>