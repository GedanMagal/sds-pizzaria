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
		<div class="row col s12 cont">
			<h4>Pedido</h4>
			<div class="input-field col s3 dsblock">
				<select id="select" onchange="addSabores()">
					<option value="" disabled selected>Qtd.sabores</option>
					
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
				</select>

			</div>
			<div id="add" class= "input-field col s3 ">
			
				<select id ="select" name="sabor" data-sabor="ing">
					<option value="" disabled selected>Sabor 1</option>
				<c:forEach items="${sabores}" var="sabor">
						<option value="${sabor.idSabor}">${sabor.idSabor} ${sabor.dsSabor }</option>
				</c:forEach>
					</select>
					
					<div id="ing">
					<h5>Ingredientes</h5>
					
					<div class="switch">
						
						

		
					</div>
					
					</div>
				
					
				</div>
				<div id="add2" class= "input-field col s3 ">
			
				<select id ="select" name="sabor" data-sabor="ing2">
					<option value="" disabled selected>Sabor 1</option>
				<c:forEach items="${sabores}" var="sabor">
			
						<option value="${sabor.idSabor}">${sabor.idSabor} ${sabor.dsSabor }</option>
				</c:forEach>
					</select>
					
					<div id="ing2">
					<h5>Ingredientes</h5>
					
					<div class="switch">
						
						

		
					</div>
					
					</div>
				
					
				</div>
				<div id="add3" class= "input-field col s3 ">
			
				<select id ="select" name="sabor" data-sabor="ing3">
					<option value="" disabled selected>Sabor 1</option>
				<c:forEach items="${sabores}" var="sabor">
				
					
						<option value="${sabor.idSabor}">${sabor.idSabor} ${sabor.dsSabor }</option>
				</c:forEach>
					</select>
					
					<div id="ing3">
					<h5>Ingredientes</h5>
					
					<div class="switch">

					</div>
					
					</div>
				
					
				</div>
			
		
			
</div>
	

		<div class="row col s12 cont">
		<div class=" input-field col s3 dsblock">
		
		<h4>Adicione bebidas</h4>
			<select id="select" onchange="addSabores()">
				<option value="" disabled selected>Bebida</option>
				<option value="1">Coca-cola</option>
				<option value="2">Guarana</option>
				<option value="3">Itubaina</option>
			</select> <select id="select" onchange="addSabores()">
				<option value="" disabled selected>Tamanho</option>
				<option value="1">1L</option>
				<option value="2">2L</option>
				<option value="3">300ml</option>
			</select>
				</div>
	<div class="clear"></div>
		</div>
		
			<div class="clear"></div>
	</div>
	
	
	<jsp:include page="imports/footer-admin.jsp" />
<script>
	$(document).ready(function() {

		$('select[name=sabor]').on('change',function(e){
			
			carregaIngrediente(e.currentTarget.dataset.sabor, e.currentTarget.value);			
			
		});

		function carregaIngrediente(param, selector) {
			$.ajax({
				method: "POST",
				  url: "saborServlet",
				  data: "idSabor="+ selector,
				  statusCode:{
					  404: function() {
						alert('pagina não encontrada')
					},
					500: function() {
						alert('erro no servidor')
					}
				  },		 
				  success: function(dados) {
					  $("#"+ param).empty();
					  var pDados = dados.split(":");
					 
						for(var i=0;i < pDados.length - 1;i++){
							var codiIngre = pDados[i].split("-")[0];
							var dsIngre = pDados[i].split("-")[1];							
							
							$("#"+ param).append("<div class='switch'><label>" + 
									dsIngre + "<input type='checkbox' value='" + codiIngre +
									"'><span class='lever'></span></label></div>");										
						
						}
						
				  }
				 
				});
		}
	});
</script>


</body>
</html>