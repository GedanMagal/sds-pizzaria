<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Pagamento</title>
</head>

<body>
	<jsp:include page="/imports/header.jsp"></jsp:include>

	<section class="content">
		<div class="row">
			<div class="card-pagamento">
			<form action="index?acao=gerarpedido" method="post">
				<input type="hidden" name="idcliente" value="${id.idPessoa}">
				
				<div id="flip-container" class="flip-container">
					<div class="flipper">
						<div class="front" id="front">
							<a class="waves-effect waves-light btn" id="btn1"
								onclick="document.querySelector('#flip-container').classList.toggle('hover');">Cart�o</a>
							<!-- Conte�do da frente -->
							<br>
							<label>Valor total:</label>
							<input type="text" value="${totalPagar}" name="valorPagamento">
							<label>Troco para</label>
							<input type="text" value="0.00" name="troco">
						</div>
						<div class="back">
							<a class="waves-effect waves-light btn" id="btn1"
								onclick="document.querySelector('#flip-container').classList.toggle('hover');">Dinheiro</a>
							<div class="pay-card">
								<i class="material-icons">credit_card</i>
								<label>
									<input name="cartao" type="radio" />
									<span>visa</span>
								</label>
								<i class="material-icons">credit_card</i>
								<label>
									<input name="cartao" type="radio" />
									<span>Master</span>
								</label>
								<i class="material-icons">credit_card</i>
								<label>
									<input name="cartao" type="radio" id="elo" />
									<span for="elo">Elo</span>
								</label>
							</div>
							<div class="tarja">
							</div>

						</div>
						<div class="clear"></div>
					</div>


				</div>
				<input type="submit" class="btn waves-effect waves-light fl-right"
					value="prosseguir"/>
		
			</form>
			</div>
			
		</div>



	</section>
	<jsp:include page="imports/footer.jsp" />
</body>

</html>