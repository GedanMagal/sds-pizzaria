<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/imports/header.jsp"></jsp:include>
	
	<section class="content">
		<div class="row">
			<div class="card-pagamento">

				
				 	<div id="flip-container" class="flip-container">  	
  					<div class="flipper">  		
   			 		<div class="front" id="front">  
   			 		<button class="waves-effect waves-light btn" id="btn1" onclick="document.querySelector('#flip-container').classList.toggle('hover');">Cartão</button>			
      				<!-- Conteúdo da frente -->  
      				<br>	
      				<label>Valor total:</label>
      				<input type="text" value="0.00">
      				<label>Troco para</label>
      				<input type="text" value="0.00">
   					</div>  		
    			<div class="back">
    			<button class="waves-effect waves-light btn" id="btn1" onclick="document.querySelector('#flip-container').classList.toggle('hover');">Dinheiro</button>  			
     				<div class="pay-card">
     					<i class="material-icons">credit_card</i>
     					<label>
                        <input name="cartao" type="radio"  />
        				<span>visa</span>
      					</label>
      					<i class="material-icons">credit_card</i>
     					<label>
                        <input name="cartao" type="radio"  />
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
		<a class="btn waves-effect waves-light fl-right" href="login.jsp"
								>
								prosseguir <i class="material-icons right">send</i>
		</a>  
			
			</div>
		</div>
		
		
		
	</section>
	<jsp:include page="imports/footer.jsp"/>
</body>
</html>