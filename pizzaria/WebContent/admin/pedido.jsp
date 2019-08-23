<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

	<jsp:include page="header-admin.jsp" />


	<div class="container">
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
			<div id="add" class=" add input-field col s3 dsnone">
				<select onchange="carregaIng()">
					<option value="" disabled selected>Sabor 1</option>
					<option value="1">Option 1</option>
					<option value="2">Option 2</option>
					<option value="3">Option 3</option>
				</select>
				<div id="ing" class="dsnone">
					<h5>Ingredientes</h5>
					<div class="switch label">
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
			<div id="add2" class="input-field col s3 dsnone">
				<select onchange="carregaIng()">
					<option value="" disabled selected>Sabor 2</option>
					<option value="1">Option 1</option>
					<option value="2">Option 2</option>
					<option value="3">Option 3</option>
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
				<select>
					<option value="" disabled selected>Sabor 3</option>
					<option value="1">Option 1</option>
					<option value="2">Option 2</option>
					<option value="3">Option 3</option>
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
	
	<jsp:include page="footer-admin.jsp" />

</body>
</html>