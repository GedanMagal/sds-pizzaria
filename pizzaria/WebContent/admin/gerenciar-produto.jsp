<!DOCTYPE html>
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

	<jsp:include page="../imports/headerAdmin.jsp" />

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
			<table>
				<thead>
					<tr>
						<th>Produto</th>
						<th>Tipo</th>
						<th>Valor</th>
					</tr>
				</thead>

				<tbody>
					<tr>
						<td>Coca Cola</td>
						<td>Refrigerante</td>
						<td>R$ 10,00</td>
						<td><a href="editar-produto.jsp"
							class="btn waves-effect waves-light red" name="action">
								Editar <i class="material-icons right">create</i>
						</a> <a href="adicionar-produto.jsp"
							class="btn waves-effect waves-light red" name="action">
								Excluir <i class="material-icons right">delete</i>
						</a></td>
					</tr>
					<tr>
						<td>Skol</td>
						<td>350ml</td>
						<td>100</td>
						<td><a href="editar-produto.jsp"
							class="btn waves-effect waves-light red" name="action">
								Editar <i class="material-icons right">create</i>
						</a> <a href="adicionar-produto.jsp"
							class="btn waves-effect waves-light red" name="action">
								Excluir <i class="material-icons right">delete</i>
						</a></td>
					</tr>
					<tr>
						<td>Fanta</td>
						<td>2L</td>
						<td>10</td>
						<td><a href="editar-produto.jsp"
							class="btn waves-effect waves-light red" name="action">
								Editar <i class="material-icons right">create</i>
						</a> <a href="adicionar-produto.jsp"
							class="btn waves-effect waves-light red" name="action">
								Excluir <i class="material-icons right">delete</i>
						</a></td>
					</tr>
				</tbody>
			</table>
		</div>

		<form action="editar-produto.jsp">
			<div class="row">
				<div class="input-field col s6">
					<button class="btn waves-effect waves-light red" type="submit"
						name="action">
						Novo Produto <i class="material-icons right">fiber_new</i>
					</button>
				</div>
			</div>
		</form>

	</div>

	<jsp:include page="imports/footer-admin.jsp" />

</body>


</html>