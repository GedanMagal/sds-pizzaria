<!DOCTYPE html>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/materialize.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link rel="stylesheet" href="../css/main.css">
<link rel="stylesheet" href="../css/cadastrar-cliente.css">
</head>
<body>

	<jsp:include page="imports/headerAdmin.jsp" />

	<div class="main-container">
		<div class="col s9 offset-s6">
			<h4>Gerenciar Produto</h4>
		</div>
		<div class="row">
			<div class="input-field col s6">
				<input type="text" name="produto" id="produto"> <label
					class="active" for="nome">Descrição</label>
			</div>
			<div class="input-field col s6">
				<button class="btn waves-effect waves-light red" type="submit"
					name="action">
					Filtrar <i class="material-icons right">search</i>
				</button>
			</div>
		</div>


		<div class="row">
			<table  class="striped centered">
				<thead>
					<tr>
						<th>id</th>
						<th>nome</th>
						<th>tamanho</th>
						<th>Valor</th>
						<th>estoque</th>
						<th>tipo</th>
					</tr>
				</thead>

				<tbody>
				<c:forEach items="${produtos}" var="prod">
					<tr>
						
						<td>${prod.idProduto}</td>
						<td>${prod.nomeProduto}</td>
						<td>${prod.tamanho}</td>
						<td>${prod.valorProduto}</td>
						<td>${prod.quantidade}</td>
						<td>${prod.dsTipo}</td>
						
						
						<td>
						<a href="editar-produto.jsp"class="btn waves-effect waves-light red" name="action">
								Editar <i class="material-icons right">create</i>
						</a> <a href="adicionar-produto.jsp"
							class="btn waves-effect waves-light red" name="action">
								Excluir <i class="material-icons right">delete</i>
						</a>
						</td>
						</c:forEach>
					</tr>
					
				</tbody>
			</table>
		</div>

		
			<div class="row">
				<div class="input-field col s6">
					<a class="btn waves-effect waves-light red" href="cadastrar-produto.jsp">
						Novo Produto <i class="material-icons right">fiber_new</i>
					</a>
				</div>
			</div>
	

	</div>

	<jsp:include page="imports/footer-admin.jsp" />

</body>


</html>