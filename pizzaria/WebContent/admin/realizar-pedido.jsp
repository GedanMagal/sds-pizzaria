<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/materialize.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/cadastrar-cliente.css">
<link rel="stylesheet" href="css/side-bar-admin.css">
</head>
<body>
		<jsp:include page="imports/headerAdmin.jsp" />
	
	<div class="main-container">
		<div class="col s9 offset-s6">
			<h4>Realizar Pedido</h4>
		</div>		
		<div class="row">
			<div class="input-field col s6">
			<select>
			<option>selecionar</option>
			<c:forEach items="${pessoas}" var="p">
				<option ${p.idPessoa }>${p.nome } ${p.sobrenome }</option>
			</c:forEach>
			</select>
				<label class="active" for="nome">Cliente</label>
			</div>
			<div id="resultado">
			
			</div>
			<div class="input-field col s6">
				<form action="admin?acao=pesquisaCliente" method="post">
	
				<button class="btn waves-effect waves-light red" type="submit"
					name="action">
					Filtrar <i class="material-icons right">search</i>
				</button>
				</form>
			</div>				
		</div>
		
		<div class="main-container">
		<div class="row">
			<div class="img_pizza"></div>
		</div>
		<form action="admin?acao=montarpizza" method="post">
			<div class="row col s12 cont">

				<h4>Pedido</h4>
				<div class="input-field col s3 dsblock">
				<select name="tamanho">
						<option value="0" disabled selected>Escolha o Tamanho</option>
						<option value="Broto">Broto</option>
						<option value="8 Pedacos">8 Pedaços</option>
						
					</select>
					<select id="select" onchange="addSabores()" name="quantidadeSabor">
						<option value="0" disabled selected>Qtd sabores</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
					</select>
					
				</div>
				
				<div id="add" class="input-field col s3 dsnone">

					<select id="select" name="sabor" data-sabor="ing" class="sabores">

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

					<select id="select" name="sabor" data-sabor="ing2"class="sabores">
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

					<select id="select" name="sabor" data-sabor="ing3" class="sabores">
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
				<input type="submit" value="inserir pizza">
			</form>
	       <br>
	    
		</div>
			
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
													alert('pagina não encontrada')
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