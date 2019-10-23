<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/materialize.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<link rel="stylesheet" href="../css/main.css">
<link rel="stylesheet" href="../css/admin.css">
</head>
<body>

	<jsp:include page="imports/headerAdmin.jsp" />

	<div class="main-container">
		<div class="row">
			<div class="img_pizza"></div>
		</div>
		<form action="admin?acao=montarpizza" method="post">
			<div class="row col s12 cont">

				<h4>Pedido</h4>
				<div class="input-field col s3 dsblock">
					<select id="select" onchange="addSabores()" name="quantidadeSabor">
						<option value="0" disabled selected>Escolha</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
					</select>

				</div>
				<div id="add" class="input-field col s3 dsnone">

					<select id="select" name="sabor1" data-sabor="ing" class="sabores">

						<option value="" disabled selected>Sabor 1</option>
						<c:forEach items="${sabores}" var="sabor">

							<option value="${sabor.idSabor}">${sabor.dsSabor}</option>

						</c:forEach>
					</select>

					<div id="ing">
						<h5>Ingredientes</h5>

						<div class="switch"></div>

					</div>


				</div>
				<div id="add2" class="input-field col s3 dsnone">

					<select id="select" name="sabor2" data-sabor="ing2"class="sabores">
						<option value="" disabled selected>Sabor 1</option>
						<c:forEach items="${sabores}" var="sabor">

							<option value="${sabor.idSabor}">${sabor.dsSabor }</option>
						</c:forEach>
					</select>

					<div id="ing2">
						<h5>Ingredientes</h5>

						<div class="switch"></div>

					</div>


				</div>
				<div id="add3" class="input-field col s3 dsnone">

					<select id="select" name="sabor3" data-sabor="ing3" class="sabores">
						<option value="" disabled selected>Sabor 1</option>
						<c:forEach items="${sabores}" var="sabor">
							<option value="${sabor.idSabor}">${sabor.dsSabor }</option>
						</c:forEach>
					</select>

					<div id="ing3">
						<h5>Ingredientes</h5>

						<div class="switch"></div>

					</div>

					<div class="clear"></div>
				</div>

				</div>



			
			<div class="row">
				<input type="submit"class="right waves-effect waves-light btn-small "value="Adicionar" />
			</div>
			</form>
	<div class="clear"></div>
	


	<div class="row col s12 cont">
		<div class=" input-field col s3 dsblock">

			<h4>Adicione bebidas</h4>
			<div class="input-field col s3 dsblock"></div>
			<c:forEach items="${produtos}" var="prod">
				<div class="card medium sm-card">
					<div class="card-image waves-effect waves-block waves-light">
						<img class="activator" src="img/refrigerante.jpg">
					</div>
					<div class="card-content">
						<span class="card-title activator grey-text text-darken-4">${prod.nomeProduto}</span>
							<span class="card-title activator grey-text text-darken-4">${prod.valorProduto }</span>
						<p>
						 		<a class="waves-effect waves-light btn-small"
								href="admin?acao=salvarPedido&produto=${prod.idProduto}&param=prod">Comprar</a>
						</p>
					</div>
				</div>
			</c:forEach>
				<p>
						 		<a class="waves-effect waves-light btn-small"
								href="admin?acao=salvarPedido&param=finalizar">Finalizar</a>
						</p>
		</div>
		
	

	<div class="clear"></div>
	</div>
		<p>${sabor1}</p>
			<p>${sabor2}</p>
			<p>${sabor3}</p>
	
	
	<div class="clear"></div>
	</div>

	<jsp:include page="imports/footer-admin.jsp" />
	<script>
		$(document)
				.ready(
						function() {

							$('.sabores').on(
									'change',
									function(e) {

										carregaIngrediente(
												e.currentTarget.dataset.sabor,
												e.currentTarget.value);

									});

							function carregaIngrediente(param, selector) {
								$
										.ajax({
											method : "POST",
											url : "saborServlet",
											data : "idSabor=" + selector,
											statusCode : {
												404 : function() {
													alert('pagina n�o encontrada')
												},
												500 : function() {
													alert('erro no servidor')
												}
											},
											success : function(dados) {
												$("#" + param).empty();
												var pDados = dados.split(":");

												for (var i = 0; i < pDados.length - 1; i++) {
													var codiIngre = pDados[i]
															.split("-")[0];
													var dsIngre = pDados[i]
															.split("-")[1];

													$("#" + param)
															.append(
																	"<div class='switch'>"
																			+ dsIngre
																			+ "<label><input type='checkbox' value='" + codiIngre +
									"'checked name='ingredientes'><span class='lever'></span></label></div>");

												}

											}

										});
							}
						});
	</script>


</body>
</html>