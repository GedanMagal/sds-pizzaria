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
			<form id="finalizar">
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
					<h4>Selecione</h4>
						<div class="row col s12">
							<a class="waves-effect waves-light btn modal-trigger" href="#modal1">1 Sabor</a> 
							<a class="waves-effect waves-light btn modal-trigger" href="#modal2">2 Sabores</a>
						</div>
					</div>
				</div>
			<div class="col s6 m6">
					<div class="row">
						<div class="card">
							<div class="input-field col s10 datapedido">
								<input type="hidden" id="itemproduto" name="produto">
								</div>
							<div class="input-field col s10">
								<input type="hidden"  name="datapedido" class="datapedido">
							</div>
							<div class="input-field col s10">
								<input type="text" value="${pedido.valorPedido}"
									disabled="disabled">
							</div>
						</div>
					</div>
							<div class="row">
			<div class="card-pagamento">


				<div id="flip-container" class="flip-container">
				<input type="hidden" name="pagamento" value="dinheiro">
					<div class="flipper">
						<div class="front" id="front">
							<a class="waves-effect waves-light btn" id="btn1"
								onclick="document.querySelector('#flip-container').classList.toggle('hover');">Cartão</a>
							<!-- Conteï¿½do da frente -->
							<br>
							<label>Valor total:</label>
							<input type="hidden" name="valorPagamento" id="valorPagamento">
							<div id="total"></div>
							<label>Troco para</label>
							<input type="text" name="troco">
						</div>
						<div class="back">
							<a class="waves-effect waves-light btn" id="btn1"
								onclick="document.querySelector('#flip-container').classList.toggle('hover');">Dinheiro</a>
							<div class="pay-card">
								<i class="material-icons">credit_card</i>
								<label>
									<input name="cartao" type="radio" value="visa" />
									<span>visa</span>
								</label>
								<i class="material-icons">credit_card</i>
								<label>
									<input name="cartao" type="radio" value="master"/>
									<span>Master</span>
								</label>
								<i class="material-icons">credit_card</i>
								<label>
									<input name="cartao" type="radio" value="elo" />
									<span for="elo">Elo</span>
								</label>
							</div>
							<div class="tarja">
								<h5 align="center" style="color: lime;" >Total: ${total}</h5>
							</div>

						</div>
						<div class="clear"></div>
					</div>


				</div>
				

			</div>
		</div>
				</div>
			</div>

					
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
			<div class="row">
							<input class="btn waves-effect waves-light" type="button"name="botao" value="finalizar" onclick="finalizarpedid()">
					</div>
			</form>	
			<div class="clear"></div>
		
		<div id="modal1" class="modal modal-fixed-footer">
			<div class="modal-content">
			<div class="col s12">
			<div class="row">
				<div class="col s6">
					<h4>Tradicionais</h4>
					<ul class="collection">
						<c:forEach items="${prd}" var="produto">
							<li class="collection-item avatar"><img
								src="img/pizzaDese.jpg" alt="" class="circle"> <h4>
									<a  href="javascript:void(0);" onclick="addproduto(${produto.idProduto})"><span>${produto.nomeProduto }</span></a>

							</h4></li>
						</c:forEach>

					</ul>
				</div>
				<div class="col s6">
					<h4>Broto</h4>
					<ul class="collection">
						<c:forEach items="${brotos}" var="produto">
							<li class="collection-item avatar"><img
								src="img/pizzaDese.jpg" alt="" class="circle"> <h4>
									<a  href="javascript:void(0);" onclick="addproduto(${produto.idProduto})"><span>${produto.nomeProduto }</span></a>

							</h4></li>
						</c:forEach>

					</ul>
				</div>
			</div>
			</div>
			</div>


		</div>
		<div id="modal2" class="modal modal-fixed-footer">
		<form id="montarpizza">
			<div class="modal-content">
		
				<div class="row">
				
					<div class="col s12">
						<div class="col s6">
						
							<select name="tamanho">
								<option value="0">selecionar</option>
								<option value="tradicional">Tradicional</option>
								<option value="broto">broto</option>
							</select> <label class="active" for="nome">Tamanho</label>
							<h4>Sabores</h4>

							<div id="checkboxes">

								<c:forEach items="${sabores}" var="sabor">
									<input type="checkbox" name="sabores" value="${sabor.idSabor}"
										id="${sabor.idSabor}" />

									<label class="whatever" for="${sabor.idSabor}"> <img
										src="img/pizzaDese.jpg" alt="" width="50px">
										${sabor.dsSabor}
									</label>
								</c:forEach>

							</div>
						</div>
					</div>
					
						
				</div>
			</div>
			
			<div class="modal-footer">
				<input type="button" onclick="montarPizza()" class="modal-close waves-effect waves-green btn-flat" value="montar"/>
				</form>
			</div>
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
                                            + "<label><input type='checkbox'id='ingr' value='" + codiIngre +
                                            "'checked name='ingredientes'><span class='lever'></span></label></div>");
                                }
                            }
                        });
                }
            });
        
        function addproduto(idproduto){
        	 $.ajax({
        	method: "POST",
        	url: "carrinho?acao=add",
        	data: "idproduto="+ idproduto,
        	success: function(data) {
				$("#dados").append("<div id='dados' class='col s6'>"
					+"<input type='hidden' name='itemproduto' value="+data.idProduto+" >"
					+"<div class='card sm-card'>"+
					"<div class='card-image waves-effect waves-block waves-light'>"+
						"<img class='activator' src='img/pizzaDese.jpg'>"+
					"</div>"+
					"<div class='card-content'>"+
						"<span class='card-title activator grey-text text-darken-4'>"
							+data.nome+"<br>"+data.valor+"</span><p></p></div></div></div>");
				alert("adiconaro ao pedido!");
				$("#total").html("<h5>"+ data.total+"</h5>");
				$("#valorPagamento").val(data.total);
				$("#itemproduto").val(data.idProduto);
			}
        	 });
        }
        function finalizarpedid() {
        	 $.ajax({
             	method: "POST",
             	url: "carrinho?acao=finalizar",
             	data: $("#finalizar").serialize(),
             	success: function(data) {
     			alert(data.resposta)
     			$(".datapedido").html("<h5> data do pedido"+data.datapedido+"</h5>");
     			$("#dados").empty();
     			$("#total").html("<h5></h5>");
				$("#valorPagamento").val("");
				$("#itemproduto").val("");
             	}
             	 });
		}
        
      
        
        function montarPizza() {
       	 $.ajax({
            	method: "POST",
            	url: "carrinho?acao=montar",
            	data: $("#montarpizza").serialize(),
            	success: function(data) {
            	
            		$("#dados").append("<div id='dados' class='col s6'>"
        					+"<div class='card sm-card'>"+
        					"<div class='card-image waves-effect waves-block waves-light'>"+
        						"<img class='activator' src='img/pizzaDese.jpg'>"+
        					"</div>"+
        					"<div class='card-content'>"+
        						"<span class='card-title activator grey-text text-darken-4'>"
        							+data.nome+"<br></span><span class='card-title activator grey-text text-darken-4'>"
        							+data.preco+"<br></span><p></p></div></div></div>");
        				console.log(data.nome)
        				$("#total").html("<h5>"+ data.total+"</h5>");
        				$("#valorPagamento").val(data.total);
        				$("#itemproduto").val(data.idProduto);
        			
            	}
            	 });
		}
    </script>
</body>
</html>