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
		
			<h4>Realizar Pedido</h4>
	
	
		
			<form action="montapizza?acao=finalizar" method="post">
				<div class="row">
			<div class="input-field col s6">
				<select name="pessoa">
					<option value="0">selecionar</option>
					<c:forEach items="${pessoas}" var="p">
						<option value="${p.idPessoa}">${p.nome } ${p.sobrenome }</option>
					</c:forEach>
				</select> <label class="active" for="nome">Cliente</label>
				<input type="hidden" name="idproduto" value="${p.idProduto}">
			</div>
			<div id="resultado"></div>
			<div class="input-field col s6">
				
			</div>
			</div>
					<div class="row col s12 cont">

					<h4>Pedido</h4>
					<div class="input-field col s6 dsblock">
					<div class="row col s6">
						
						
							<h4>Tradicional</h4>
							<div class="row col s12">
							<a class="waves-effect waves-light btn modal-trigger" href="#modal1">1
								Sabor</a> <a class="waves-effect waves-light btn modal-trigger" href="#modal2"">2 Sabores</a>
								
						
						
						
							<h4>Broto</h4>
							<a class="waves-effect waves-light btn modal-trigger" href="#modal3">1 Sabor</a> 
							<a class="waves-effect waves-light btn modal-trigger" href="#modal4">2 Sabores</a>
						
						</div>
						</div>
				
					</div>
				
			
		
			
					<div class="col s6 m6">
						<div class="row">
      						<div class="card">
							<div class="input-field col s10">
							<input type="hidden" value="${produto.idProduto}" name="produto">
							</div>
							<div class="input-field col s10">
							<input type="text" value="${total}" disabled="disabled">
							</div>
								<div class="input-field col s10">
							<input type="text" value="${pedido.dataPedido}" disabled="disabled"> 
							</div>
								<div class="input-field col s10">
							<input type="text" value="${pedido.valorPedido}" disabled="disabled"> 
							</div>
					</div>
					</div>
					</div>
					</div>
					
				<div class="row">
				<input class="btn waves-effect waves-light" type="submit"name="botao" value="finalizar">
						
					</div>
						

						</form>	
			
		
			

		
			
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
		
		<div id="modal1" class="modal modal-fixed-footer">
			<div class="modal-content">
			<div class="col s12">
				<div class="col s6">
					<h4>Sabores</h4>
					<ul class="collection">
						<c:forEach items="${prd}" var="produto">
							<li class="collection-item avatar"><img
								src="img/pizzaDese.jpg" alt="" class="circle"> <label>
									<a
									href="montapizza?acao=adicionarcarrinho&idproduto=${produto.idProduto}"><span>${produto.nomeProduto }</span></a>

							</label></li>
						</c:forEach>

					</ul>
				</div>
			</div>
			</div>


		</div>
		<div id="modal2" class="modal modal-fixed-footer">
			<div class="modal-content">
				<div class="row">
					<div class="col s12">
						<div class="col s6">
							<h4>Sabores</h4>
							<ul>
								<c:forEach items="${sabores}" var="sabor">
									<li><label> <input type="radio" name="sabor"
											value="${sabor.idSabor}"> <span>${sabor.dsSabor }</span>
									</label></li>
								</c:forEach>

							</ul>
						</div>

						<div class="col s6">
							<h4>Sabores</h4>
							<ul>
								<c:forEach items="${sabores}" var="sabor">
									<li><label> <input type="radio" name="sabor"
											value="${sabor.idSabor}"> <span>${sabor.dsSabor }</span>
									</label></li>
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
						<li><label> <input type="radio" name="sabor"
								value="${sabor.idSabor}"> <span>${sabor.dsSabor }</span>
						</label></li>
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
									<li><label> <input type="radio" name="sabor"
											value="${sabor.idSabor}"> <span>${sabor.dsSabor }</span>
									</label></li>
								</c:forEach>

							</ul>
						</div>

						<div class="col s6">
							<h4>Sabores</h4>
							<ul>
								<c:forEach items="${sabores}" var="sabor">
									<li><label> <input type="radio" name="sabor"
											value="${sabor.idSabor}"> <span>${sabor.dsSabor }</span>
									</label></li>
								</c:forEach>

							</ul>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<a href="#!" class="modal-close waves-effect waves-green btn-flat">Agree</a>
			</div>
			<div class="clear"></div>
		</div>
	<div class="clear"></div>

</div>
	<jsp:include page="imports/footer-admin.jsp" />
	<script>
        $(document).ready(function () {
                M.AutoInit();
                $('.modal').modal();
                $('.sabores').on(
                    'change',
                    function (e) {
                        carregaIngrediente(
                            e.currentTarget.dataset.sabor,
                            e.currentTarget.value);
                    });
                function carregaIngrediente(param, selector) {
                    $.ajax({
                            method: "POST",
                            url: "saborServlet",
                            data: "idSabor=" + selector,
                            statusCode: {
                                404: function () {
                                    alert('pagina não encontrada')
                                },
                                500: function () {
                                    alert('erro no servidor')
                                }
                            },
                            success: function (dados) {
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