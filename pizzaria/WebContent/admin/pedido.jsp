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
			<div id="add" class= "input-field col s3 dsnone">
				<select id ="select" onchange="carregaIng(this)">
					<option value="" disabled selected>Sabor 1</option>
					<c:forEach items="${sabores}" var="sabor">
						<option value="${sabor.idSabor}">${sabor.dsSabor }</option>
					</c:forEach>
				</select>
				<div id="ing" class="dsnone">
					<h5>Ingredientes</h5>
					<c:forEach items="${sabor.ingredientes}" var="ing" varStatus="status">
					<div class="switch label">
						<label>
						<c:set var="ingre" value="${status.first ? ' ' : ingre} ${ing.dsIngrediente}" />
						 <input type="checkbox"> <span
							class="lever"></span>

						</label>
					</div>
					</c:forEach>
				</div>
			</div>
			<div id="add2" class="input-field col s3 dsnone">
				<select id ="select" onchange="carregaIng(this)">
					<option value="" disabled selected>Sabor 1</option>
					<c:forEach items="${sabores}" var="sabor">
						<option value="${sabor.idSabor}">${sabor.dsSabor }</option>
					</c:forEach>
				</select>
				<div id="ing" class=" dsnone">
					<h5>Ingredientes</h5>
					<div class="switch">
						<label> Oregano <input type="checkbox"> <span
							class="lever"></span>

						</label>
					</div>
					<div class="switch">
						<label> Tomate <input type="checkbox"> <span
							class="lever"></span>
						</label>
					</div>
					<div class="switch">
						<label> Azeitona <input type="checkbox"> <span
							class="lever"></span>
						</label>
					</div>

					<div class="switch">
						<label> cebola <input type="checkbox"> <span
							class="lever"></span>
						</label>
					</div>
					<div class="switch">
						<label> Atum <input type="checkbox"> <span
							class="lever"></span>

						</label>
					</div>
				</div>

			</div>
			<div id="add3" class="input-field col s3 dsnone">
				<select id ="select" onchange="carregaIng(this)">
					<option value="" disabled selected>Sabor 1</option>
					<c:forEach items="${sabores}" var="sabor">
						<option value="${sabor.idSabor}">${sabor.dsSabor }</option>
					</c:forEach>
				</select>
				<div id="ing" class="dsnone">
					<h5>Ingredientes</h5>
					<div class="switch">
						<label> Oregano <input type="checkbox"> <span
							class="lever"></span>

						</label>
					</div>
					<div class="switch">
						<label> Tomate <input type="checkbox"> <span
							class="lever"></span>
						</label>
					</div>
					<div class="switch">
						<label> Azeitona <input type="checkbox"> <span
							class="lever"></span>
						</label>
					</div>

					<div class="switch">
						<label> cebola <input type="checkbox"> <span
							class="lever"></span>
						</label>
					</div>
					<div class="switch">
						<label> Atum <input type="checkbox"> <span
							class="lever"></span>

						</label>
					</div>
				</div>

			</div>

		</div>


		<h4>Adicione bebidas</h4>
		<div class="input-field col s3 dsblock">
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
	<div class="clear"></div>
		</div>
			<div class="clear"></div>
	</div>
	
	
	<jsp:include page="imports/footer-admin.jsp" />


</body>
</html>