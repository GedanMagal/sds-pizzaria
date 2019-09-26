<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>

</head>
<body>
	<jsp:include page="imports/headerAdmin.jsp" />

	<div class="main-container">
	<form action="admin?acao=cadastrarPizza" method="POST">
		<div class="col s9 offset-s6">
			<h4>Produto</h4>
		</div>
		<div class="row">
			<div class="input-field col s6">
				<input type="text" name="sabor" id="sabor"> <label
					class="active" for="sabor">Sabor</label>
			</div>
			<div class="input-field col s6" id="form">
			
				<input type="text" name="ingredientes" id=txtIngrediente >
				<label class="active" for="ingredientes">Ingredientes</label>
				
			</div>
				<div class="botao">	
				<a class="btn waves-effect waves-light red" id="btn3">-</a>
				<a class="btn waves-effect waves-light" id="btn1">+</a>
			</div>
		</div>
		
		<div class="row">
			<div class="col s3 offset-s6">
				<button class="btn waves-effect waves-light red" type="submit"
					name="action">
					Limpar <i class="material-icons right">clear</i>
				</button>
			</div>
			<div class="col s3">
				<button class="btn waves-effect waves-light" type="submit"
					name="action">
					Salvar <i class="material-icons right">send</i>
				</button>

			</div>
		</div>
		</form>
	</div>

	
	<jsp:include page="imports/footer-admin.jsp" />


</body>


</html>