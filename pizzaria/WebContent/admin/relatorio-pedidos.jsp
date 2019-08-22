<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<<<<<<< HEAD
	<div class="container">
		<div>
			<jsp:include page="../imports/headerAdmin.jsp" />
		</div>
	</div>
	<div class="container">
		<div class="header-content">
			<h5>Relatórios de Pedidos</h5>
		</div>
		<div class="row">
			<div class="input-field col s3 offset-s1">
				<input type="text" class="datepicker" id="dataInicio"
					placeholder="Data de Inicio">
			</div>
			<div class="input-field col s3 offset-s1">
				<input type="text" class="datepicker" id="dataFim"
					placeholder="Data Final">
			</div>
			<div class="input-field col s3 offset-s1">
				<button class="btn waves-effect waves-light" type="submit"
					name="action">
					Gerar <i class="material-icons right">send</i>
				</button>
			</div>
		</div>
=======
<div class="row">
<jsp:include page="../imports/headerAdmin.jsp"/>
>>>>>>> refs/remotes/origin/master

		<table class="highlight centered responsive-table">
			<thead>
				<tr>
					<th>9999999</th>
					<th>Nome</th>
					<th>Quantidade de Pedido</th>
					<th>Valor</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>999999</td>
					<td>José</td>
					<td>2</td>
					<td>56.90</td>
				</tr>
				<tr>
					<td>999999</td>
					<td>José</td>
					<td>2</td>
					<td>56.90</td>
				</tr>
				<tr>
					<td>999999</td>
					<td>José</td>
					<td>2</td>
					<td>56.90</td>
				</tr>
				<tr>
					<td>999999</td>
					<td>José</td>
					<td>2</td>
					<td>56.90</td>
				</tr>
				<tr>
					<td>999999</td>
					<td>José</td>
					<td>2</td>
					<td>56.90</td>
				</tr>
				<tr>
					<td>999999</td>
					<td>José</td>
					<td>2</td>
					<td>56.90</td>
				</tr>
			</tbody>
		</table>

		<div class="row">
			<div class="input-field col s3 offset-s9">
				<button class="btn waves-effect waves-light" type="submit"
					name="action">
					Exportar <i class="material-icons right">send</i>
				</button>
			</div>
		</div>

	</div>

	<jsp:include page="footer-admin.jsp" />

</body>
</html>