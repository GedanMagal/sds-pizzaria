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
		<jsp:include page="/imports/msg.jsp" />
		<div class="col s9 offset-s6">
			<h4>Realizar Pedido</h4>
		</div>
		<div class="row">
			<div class="input-field col s6">
				<select>
					<option>selecionar</option>
					<c:forEach items="${pessoas}" var="p">
						<option ${p.idPessoa }>${p.nome }${p.sobrenome }</option>
					</c:forEach>
				</select> <label class="active" for="nome">Cliente</label>
			</div>
			<div id="resultado"></div>
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
			
				<input type="hidden" name="acao" value="inserir">
				<div class="row col s12 cont">

					<h4>Pedido</h4>
					<div class="input-field col s6 dsblock">
						<div class="card">
							<h4>Tradicional</h4>
							<a class="waves-effect waves-light btn modal-trigger" href="#modal1">1
								Sabor</a> <a class="waves-effect waves-light btn modal-trigger" href="#modal2"">2 Sabores</a>
						</div>
						<div class="card">
							<h4>Broto</h4>
							<a class="waves-effect waves-light btn modal-trigger" href="#modal3">1 Sabor</a> 
							<a class="waves-effect waves-light btn modal-trigger" href="#modal4">2 Sabores</a>
						</div>
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

						<select id="select" name="sabor" data-sabor="ing2" class="sabores">
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
				<input type="submit" value="inserir pizza"
					class="btn waves-effect waves-light" name="botao">

				<button class="btn waves-effect waves-light" type="submit"
					name="botao" value="finalizar">
					finalizar Pedido <i class="material-icons right">check</i>
				</button>
			</form>
			<br>
			<div id="dados" class="col s6">
				<c:forEach items="${itens}" var="p">
					<div class="card sm-card">
						<div class="card-image waves-effect waves-block waves-light">
							<img class="activator" src="img/pizzaDese.jpg">
						</div>
						<div class="card-content">
							<span class="card-title activator grey-text text-darken-4">
								${p.nomeProduto}<br> 
								
							</span>
							<p></p>
						</div>

					</div>
				</c:forEach>
			</div>

			<div class="clear"></div>
		</div>
		<div id="modal1" class="modal modal-fixed-footer">
			<div class="modal-content">
			<form id="formp" action="montapizza" method="post">
			<input type="hidden" name="acao" value="inserir">
			<input type="hidden" name="tamanho" value="broto">
			<input type="hidden" name="quantidadeSabores" value="1">
 			<input type="hidden" name="" value="broto">
				<h4>Sabores</h4>
				<ul  class="collection">
				<c:forEach items="${prd}" var="produto">
					<li class="collection-item avatar">
					 <img src="img/pizzaDese.jpg" alt="" class="circle">
					<label>
        			<a href="montapizza?acao=adicionarcarrinho&idproduto=${produto.idProduto}"><span>${produto.nomeProduto }</span></a>
        			
      				</label>
					</li>
				</c:forEach>
				
			</ul>
			
			</form>
			</div>
			
			
		</div>
		<div id="modal2" class="modal modal-fixed-footer">
			<div class="modal-content">
			<div class="row">
			<div class="col s12">
			<div class="col s6">
				<h4>Sabores</h4>
				<ul>
				<c:forEach items="${sabores}" var="sabor" >
					<li>
					<label>
        			<input type="radio" name="sabor" value="${sabor.idSabor}"> 
        			<span>${sabor.dsSabor }</span>
      				</label>
					</li>
				</c:forEach>
				
			</ul>
			</div>
			
			<div class="col s6">
				<h4>Sabores</h4>
				<ul>
				<c:forEach items="${sabores}" var="sabor">
					<li>
					<label>
        			<input type="radio" name="sabor" value="${sabor.idSabor}"> 
        			<span>${sabor.dsSabor }</span>
      				</label>
					</li>
				</c:forEach>
				
			</ul>
			</div>
			</div>
			</div>
			</div>
			<div class="modal-footer">
				<a href="#!" class="modal-close waves-effect waves-green btn-flat">Agree</a>
			</div>
		</div>
		<div id="modal3" class="modal modal-fixed-footer">
			<div class="modal-content">
				<h4>Sabores</h4>
				<ul>
				<c:forEach items="${sabores}" var="sabor">
					<li>
					<label>
        			<input type="radio" name="sabor" value="${sabor.idSabor}"> 
        			<span>${sabor.dsSabor }</span>
      				</label>
					</li>
				</c:forEach>
				
			</ul>
			</div>
			<div class="modal-footer">
				<a href="#!" class="modal-close waves-effect waves-green btn-flat">Agree</a>
			</div>
		</div>
		
		<div id="modal4" class="modal modal-fixed-footer">
			<div class="modal-content">
			<div class="row">
			<div class="col s12">
			<div class="col s6">
				<h4>Sabores</h4>
				<ul>
				<c:forEach items="${sabores}" var="sabor">
					<li>
					<label>
        			<input type="radio" name="sabor" value="${sabor.idSabor}"> 
        			<span>${sabor.dsSabor }</span>
      				</label>
					</li>
				</c:forEach>
				
			</ul>
			</div>
			
			<div class="col s6">
				<h4>Sabores</h4>
				<ul>
				<c:forEach items="${sabores}" var="sabor">
					<li>
					<label>
        			<input type="radio" name="sabor" value="${sabor.idSabor}"> 
        			<span>${sabor.dsSabor }</span>
      				</label>
					</li>
				</c:forEach>
				
			</ul>
			</div>
			</div>
			</div>
			</div>
			<div class="modal-footer">
				<a href="#!" class="modal-close waves-effect waves-green btn-flat">Agree</a>
			</div>
		</div>
	</div>
	<jsp:include page="imports/footer-admin.jsp" />
	<script>
		$(document)
				.ready(
						function() {
							 M.AutoInit();
							$('.modal').modal();
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