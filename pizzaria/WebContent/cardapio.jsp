<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cárdapio</title>
</head>
<body>
	<jsp:include page="imports/header.jsp" />
	<section class="content background-img">
		<!-- <div class="carousel carousel-slider container">
    <a class="carousel-item" href="#one!">
    <img src="img/banner_site_pedepizza.jpg"></a>
    <a class="carousel-item" href="#two!"><img src="https://lorempixel.com/800/400/food/2"></a>
    <a class="carousel-item" href="#three!"><img src="https://lorempixel.com/800/400/food/3"></a>
    <a class="carousel-item" href="#four!"><img src="https://lorempixel.com/800/400/food/4"></a>
    </div>
         -->
		<div class=" content background-img">



			<div class="side-content">

				<form action="" class="formu_medium">
					<div class="row">
						<input type="search" name="pesquisa" class="col s8">
						<button>
							<i class="material-icons">search</i>
						</button>
					</div>
				</form>

				<h1>Pizzas</h1>
				<div class="card medium sm-card">
					<div class="card-image waves-effect waves-block waves-light">
						<img class="activator" src="img/pizza-1.jpg">
					</div>
					<div class="card-content">
						<span class="card-title activator grey-text text-darken-4">Mussarela<i
							class="material-icons right">menu</i></span>


						<div id="add2" class="input-field col s3 ">
							<select id="select">
								<option value="" disabled selected>tamanho</option>
								<option value="1">Option 1</option>
								<option value="2">Option 2</option>
								<option value="3">Option 3</option>
							</select>

						</div>
						<p>
							<a class="waves-effect waves-light btn-small" href="#">Comprar</a>
						</p>
					</div>
					<div class="card-reveal">
						<span class="card-title grey-text text-darken-4">Mussarela<i
							class="material-icons right">close</i></span>
						<p>Here is some more information about this product that is
							only revealed once clicked on.</p>
					</div>
				</div>
				<div class="card medium sm-card">
					<div class="card-image waves-effect waves-block waves-light">
						<img class="activator" src="img/pizza-1.jpg">
					</div>
					<div class="card-content">
						<span class="card-title activator grey-text text-darken-4">Mussarela<i
							class="material-icons right">menu</i></span>


						<div id="add2" class="input-field col s3 ">
							<select  id="select" onchange="carregaIng()">
								<option value="" disabled selected>tamanho</option>
								<option value="1">Option 1</option>
								<option value="2">Option 2</option>
								<option value="3">Option 3</option>
							</select>
							<div class="clear"></div>
						</div>
						<p>
							<a class="waves-effect waves-light btn-small" href="#">Comprar</a>
						</p>
					</div>
					<div class="card-reveal">
						<span class="card-title grey-text text-darken-4">Mussarela<i
							class="material-icons right">close</i></span>
						<p>Here is some more information about this product that is
							only revealed once clicked on.</p>
					</div>
				</div>

				<div class="card medium sm-card">
					<div class="card-image waves-effect waves-block waves-light">
						<img class="activator" src="img/pizza-1.jpg">
					</div>
					<div class="card-content">
						<span class="card-title activator grey-text text-darken-4">Mussarela<i
							class="material-icons right">menu</i></span>


						<div id="add2" class="input-field col s3 ">
							<select  id="select" onchange="carregaIng()">
								<option value="" disabled selected>tamanho</option>
								<option value="1">Option 1</option>
								<option value="2">Option 2</option>
								<option value="3">Option 3</option>
							</select>
							<div class="clear"></div>
						</div>
						<p>
							<a class="waves-effect waves-light btn-small" href="#">Comprar</a>
						</p>
					</div>
					<div class="card-reveal">
						<span class="card-title grey-text text-darken-4">Mussarela<i
							class="material-icons right">close</i></span>
						<p>Here is some more information about this product that is
							only revealed once clicked on.</p>
					</div>
				</div>

				<div class="card medium sm-card">
					<div class="card-image waves-effect waves-block waves-light">
						<img class="activator" src="img/pizza-1.jpg">
					</div>
					<div class="card-content">
						<span class="card-title activator grey-text text-darken-4">Mussarela<i
							class="material-icons right">menu</i></span>


						<div id="add2" class="input-field col s3 ">
							<select  id="select" onchange="carregaIng()">
								<option value="" disabled selected>tamanho</option>
								<option value="1">Option 1</option>
								<option value="2">Option 2</option>
								<option value="3">Option 3</option>
							</select>
							<div class="clear"></div>
						</div>
						<p>
							<a class="waves-effect waves-light btn-small" href="#">Comprar</a>
						</p>
					</div>
					<div class="card-reveal">
						<span class="card-title grey-text text-darken-4">Mussarela<i
							class="material-icons right">close</i></span>
						<p>Here is some more information about this product that is
							only revealed once clicked on.</p>
					</div>
				</div>

				<div class="card medium sm-card">
					<div class="card-image waves-effect waves-block waves-light">
						<img class="activator" src="img/pizza-1.jpg">
					</div>
					<div class="card-content">
						<span class="card-title activator grey-text text-darken-4">Mussarela<i
							class="material-icons right">menu</i></span>


						<div id="add2" class="input-field col s3 ">
							<select  id="select" onchange="carregaIng()">
								<option value="" disabled selected>tamanho</option>
								<option value="1">Option 1</option>
								<option value="2">Option 2</option>
								<option value="3">Option 3</option>
							</select>
							<div class="clear"></div>
						</div>
						<p>
							<a class="waves-effect waves-light btn-small" href="#">Comprar</a>
						</p>
					</div>
					<div class="card-reveal">
						<span class="card-title grey-text text-darken-4">Mussarela<i
							class="material-icons right">close</i></span>
						<p>Here is some more information about this product that is
							only revealed once clicked on.</p>
					</div>
				</div>

				<div class="card medium sm-card">
					<div class="card-image waves-effect waves-block waves-light">
						<img class="activator" src="img/pizza-1.jpg">
					</div>
					<div class="card-content">
						<span class="card-title activator grey-text text-darken-4">Mussarela<i
							class="material-icons right">menu</i></span>


						<div id="add2" class="input-field col s3 ">
							<select  id="select" onchange="carregaIng()">
								<option value="" disabled selected>tamanho</option>
								<option value="1">Option 1</option>
								<option value="2">Option 2</option>
								<option value="3">Option 3</option>
							</select>
							<div class="clear"></div>
						</div>
						<p>
							<a class="waves-effect waves-light btn-small" href="#">Comprar</a>
						</p>
					</div>
					<div class="card-reveal">
						<span class="card-title grey-text text-darken-4">Mussarela<i
							class="material-icons right">close</i></span>
						<p>Here is some more information about this product that is
							only revealed once clicked on.</p>
					</div>
				</div>

				<div class="card medium sm-card">
					<div class="card-image waves-effect waves-block waves-light">
						<img class="activator" src="img/pizza-1.jpg">
					</div>
					<div class="card-content">
						<span class="card-title activator grey-text text-darken-4">Mussarela<i
							class="material-icons right">menu</i></span>


						<div id="add2" class="input-field col s3 ">
							<select  id="select" onchange="carregaIng()">
								<option value="" disabled selected>tamanho</option>
								<option value="1">Option 1</option>
								<option value="2">Option 2</option>
								<option value="3">Option 3</option>
							</select>
							<div class="clear"></div>
						</div>
						<p>
							<a class="waves-effect waves-light btn-small" href="#">Comprar</a>
						</p>
					</div>
					<div class="card-reveal">
						<span class="card-title grey-text text-darken-4">Mussarela<i
							class="material-icons right">close</i></span>
						<p>Here is some more information about this product that is
							only revealed once clicked on.</p>
					</div>
				</div>

				<div class="card medium sm-card">
					<div class="card-image waves-effect waves-block waves-light">
						<img class="activator" src="img/pizza-1.jpg">
					</div>
					<div class="card-content">
						<span class="card-title activator grey-text text-darken-4">Mussarela<i
							class="material-icons right">menu</i></span>


						<div id="add2" class="input-field col s3 ">
							<select  id="select" onchange="carregaIng()">
								<option value="" disabled selected>tamanho</option>
								<option value="1">Option 1</option>
								<option value="2">Option 2</option>
								<option value="3">Option 3</option>
							</select>
							<div class="clear"></div>
						</div>
						<p>
							<a class="waves-effect waves-light btn-small" href="#">Comprar</a>
						</p>
					</div>
					<div class="card-reveal">
						<span class="card-title grey-text text-darken-4">Mussarela<i
							class="material-icons right">close</i></span>
						<p>Here is some more information about this product that is
							only revealed once clicked on.</p>
					</div>
				</div>

				<h1>Bebidas</h1>
				<div class="card medium sm-card">
					<div class="card-image waves-effect waves-block waves-light">
						<img class="activator" src="img/refrigerante.jpg">
					</div>
					<div class="card-content">
						<span class="card-title activator grey-text text-darken-4">Card
							Title<i class="material-icons right">menu</i>
						</span>
						<p>
							<a class="waves-effect waves-light btn-small" href="#">Comprar</a>
						</p>

						<div id="add2" class="input-field col s3 ">
							<select  id="select" onchange="">
								<option value="" disabled selected>tamanho</option>
								<option value="1">Option 1</option>
								<option value="2">Option 2</option>
								<option value="3">Option 3</option>
							</select>
							<div class="clear"></div>
						</div>
					</div>
				</div>

				<div class="card medium sm-card">
					<div class="card-image waves-effect waves-block waves-light">
						<img class="activator" src="img/refrigerante.jpg">
					</div>
					<div class="card-content">
						<span class="card-title activator grey-text text-darken-4">Card
							Title<i class="material-icons right">menu</i>
						</span>
						<p>
							<a class="waves-effect waves-light btn-small" href="#">Comprar</a>
						</p>

						<div class="input-field col s3 ">
							<select  id="select">
								<option value="" disabled selected>tamanho</option>
								<option value="1">Option 1</option>
								<option value="2">Option 2</option>
								<option value="3">Option 3</option>
							</select>
							<div class="clear"></div>
						</div>
					</div>
				</div>

				<div class="card medium sm-card">
					<div class="card-image waves-effect waves-block waves-light">
						<img class="activator" src="img/refrigerante.jpg">
					</div>
					<div class="card-content">
						<span class="card-title activator grey-text text-darken-4">Card
							Title<i class="material-icons right">menu</i>
						</span>
						<p>
							<a class="waves-effect waves-light btn-small" href="#">Comprar</a>
						</p>

						<div id="add2" class="input-field col s3 ">
							<select  id="select" onchange="carregaIng()">
								<option value="" disabled selected>tamanho</option>
								<option value="1">Option 1</option>
								<option value="2">Option 2</option>
								<option value="3">Option 3</option>
							</select>
							<div class="clear"></div>
						</div>
					</div>
				</div>

				<div class="card medium sm-card">
					<div class="card-image waves-effect waves-block waves-light">
						<img class="activator" src="img/refrigerante.jpg">
					</div>
					<div class="card-content">
						<span class="card-title activator grey-text text-darken-4">Card
							Title<i class="material-icons right">menu</i>
						</span>
						<p>
							<a class="waves-effect waves-light btn-small" href="#">Comprar</a>
						</p>

						<div id="add2" class="input-field col s3 ">
							<select  id="select" onchange="carregaIng()">
								<option value="" disabled selected>tamanho</option>
								<option value="1">Option 1</option>
								<option value="2">Option 2</option>
								<option value="3">Option 3</option>
							</select>
							<div class="clear"></div>
						</div>
					</div>
				</div>


			</div>

		</div>
		<div class="clear"></div>
	</section>
	<jsp:include page="imports/footer.jsp" />
</body>
</html>