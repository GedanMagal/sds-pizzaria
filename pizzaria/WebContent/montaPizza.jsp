<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Monte sua pizza</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<section class="content">

		<div class="container">
			<div class="row col s12">
				<h3>Monte sua pizza</h3>
				<div class="input-field col s3 dsblock">
					<select id="select" onchange="addSabores()">
						<option value="" disabled selected>Quantidade de sabores</option>
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
				<div id="add2" class="input-field col s3 dsnone">
					<select onchange="carregaIng()">
						<option value="" disabled selected>Sabor 2</option>
						<option value="1">Option 1</option>
						<option value="2">Option 2</option>
						<option value="3">Option 3</option>
					</select>
					<div  id="ing" class=" dsnone">
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
						<select >
							<option value="" disabled selected>Sabor 3</option>
							<option value="1">Option 1</option>
							<option value="2">Option 2</option>
							<option value="3">Option 3</option>
						</select>
						<div  id="ing" class="dsnone">
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
			
			<div class="row">
				<h4></h4>
			</div>
		</div>
		
		
	</section>

	<jsp:include page="footer.jsp" />
</body>
</html>