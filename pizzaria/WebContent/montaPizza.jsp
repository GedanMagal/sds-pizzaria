<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Monte sua pizza</title>
</head>
<body>
	<jsp:include page="imports/header.jsp"></jsp:include>

	<section class="content background-img ">

		<div class="container side-content">
			<div class="row">
				<div class="img_pizza"></div>
			</div>
			<div class="row col s12 cont">
				<h3>Monte sua pizza</h3>
				<div class="input-field col s3 dsblock">
					<select id="select" onchange="addSabores()">
						<option value="" disabled selected>Qtd.sabores</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
					</select>

				</div>
				<div id="add" class=" add input-field col s3 dsnone">
					<select  id="select"onchange="carregaIng()">
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
					<select  id="select"onchange="carregaIng()">
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
					<select   id="select">
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
			<div class="row btn_proximo">
				<a class="waves-effect waves-light btn">proximo</a>
			</div>

			<h4>Adicione bebidas</h4>
			<div class="card medium sm-card">
				<div class="card-image waves-effect waves-block waves-light">
					<img class="activator" src="img/refrigerante.jpg">
				</div>
				<div class="card-content">
					<span class="card-title activator grey-text text-darken-4">Coca-Cola<i
						class="material-icons right">menu</i></span>
					<p>
						<a class="waves-effect waves-teal btn-flat" href="#">Comprar</a>
					</p>
					<div id="add2" class="input-field col s10 ">
						<select  id="select"onchange="carregaIng()">
							<option value="" disabled selected>tamanho</option>
							<option value="1">Option 1</option>
							<option value="2">Option 2</option>
							<option value="3">Option 3</option>
						</select>
						<div class="clear"></div>
					</div>
				</div>

				<div class="card-reveal">
					<span class="card-title grey-text text-darken-4">Coca-Cola<i
						class="material-icons right">close</i></span>
					<p>Here is some more information about this product that is
						only revealed once clicked on.</p>


				</div>
			</div>

			<div class="card medium sm-card">
				<div class="card-image waves-effect waves-block waves-light">
					<img class="activator" src="img/refrigerante.jpg">
				</div>
				<div class="card-content">
					<span class="card-title activator grey-text text-darken-4">Coca-Cola<i
						class="material-icons right">menu</i></span>
					<p>
						<a class="waves-effect waves-teal btn-flat" href="#">Comprar</a>
					</p>
					<div id="add2" class="input-field col s10 ">
						<select id="select" onchange="carregaIng()">
							<option value="" disabled selected>tamanho</option>
							<option value="1">Option 1</option>
							<option value="2">Option 2</option>
							<option value="3">Option 3</option>
						</select>
						<div class="clear"></div>
					</div>
				</div>

				<div class="card-reveal">
					<span class="card-title grey-text text-darken-4">Coca-Cola<i
						class="material-icons right">close</i></span>
					<p>Here is some more information about this product that is
						only revealed once clicked on.</p>


				</div>
			</div>



			<div class="card medium sm-card">
				<div class="card-image waves-effect waves-block waves-light">
					<img class="activator" src="img/refrigerante.jpg">
				</div>
				<div class="card-content">
					<span class="card-title activator grey-text text-darken-4">Coca-Cola<i
						class="material-icons right">menu</i></span>
					<p>
						<a class="waves-effect waves-teal btn-flat" href="#">Comprar</a>
					</p>
					<div id="add2" class="input-field col s10 ">
						<select  id="select" onchange="carregaIng()">
							<option value="" disabled selected>tamanho</option>
							<option value="1">Option 1</option>
							<option value="2">Option 2</option>
							<option value="3">Option 3</option>
						</select>
						<div class="clear"></div>
					</div>
				</div>

				<div class="card-reveal">
					<span class="card-title grey-text text-darken-4">Coca-Cola<i
						class="material-icons right">close</i></span>
					<p>Here is some more information about this product that is
						only revealed once clicked on.</p>


				</div>
			</div>

			<div class="card medium sm-card">
				<div class="card-image waves-effect waves-block waves-light">
					<img class="activator" src="img/refrigerante.jpg">
				</div>
				<div class="card-content">
					<span class="card-title activator grey-text text-darken-4">Coca-Cola<i
						class="material-icons right">menu</i></span>
					<p>
						<a class="waves-effect waves-teal btn-flat" href="#">Comprar</a>
					</p>
					<div id="add2" class="input-field col s10 ">
						<select onchange="carregaIng()">
							<option value="" disabled selected>tamanho</option>
							<option value="1">Option 1</option>
							<option value="2">Option 2</option>
							<option value="3">Option 3</option>
						</select>
						<div class="clear"></div>
					</div>
				</div>

				<div class="card-reveal">
					<span class="card-title grey-text text-darken-4">Coca-Cola<i
						class="material-icons right">close</i></span>
					<p>Here is some more information about this product that is
						only revealed once clicked on.</p>


				</div>
			</div>
			<div class="clear"></div>
		</div>


			<div class="clear"></div>
	</section>

	<jsp:include page="imports/footer.jsp" />
</body>
</html>