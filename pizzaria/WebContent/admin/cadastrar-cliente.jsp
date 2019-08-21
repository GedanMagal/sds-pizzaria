<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="../css/materialize.min.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="../css/main.css">
    <link rel="stylesheet" href="../css/cadastrar-cliente.css">
</head>
<body>
<div class="row">
<div class="col s3 bg-color a-side">
	<ul  class="left hide-on-med-and-down menu-admin">
				<li><a href="index.jsp">home</a></li>
				<li><a href="cardapio.jsp">cardapio</a></li>
				<li><a href="montaPizza.jsp">Monte seu pedido</a></li>
				<li><a href="carrinho.jsp"><i class="material-icons">shopping_cart</i> </a></li>
				<li><a class="waves-effect waves-light btn modal-trigger"
					href="login.jsp">login</a></li>
			</ul>

<div class="clear"></div>
</div>

    <section class="col s9">
     
        <div class="">
           <div class="header-title">
            <h4>Cadastrar Cliente</h4>
        </div>
            <h6>Dados Pessoais</h6>
            <div class="row">
                <div class="input-field col s6">
                    <input type="text" name="nome" id="nome">
                    <label class="active" for="nome">Nome</label>
                </div>
                <div class="input-field col s6">
                    <input type="text" name="sobrenome" id="sobrenome">
                    <label class="active" for="sobrenome">Sobrenome</label>
                </div>
            </div>
            <div class="row">
                <div class="col s12">
                    <p> <span class="gender">Sexo</span>
                        <label>
                            <input name="genero" type="radio" />
                            <span>Masculino</span>
                        </label>
                        <label>
                            <input name="genero" type="radio" />
                            <span>Feminino</span>
                        </label>
                    </p>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s6">
                    <input type="email" name="email" id="email">
                    <label class="active" for="email">E-mail</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s6">
                    <input type="text" name="senha" id="senha">
                    <label class="active" for="senha">Senha</label>
                </div>
            </div>
            <h6>Localização</h6>
            <div class="row">
                <div class="input-field col s6">
                    <input type="text" name="endereco" id="endereco">
                    <label class="active" for="nome">Endereço</label>
                </div>
                <div class="input-field col s3">
                    <input type="text" name="complemento" id="complemento">
                    <label class="active" for="complemento">Complemento</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s6">
                    <input type="text" name="localReferencia" id="localReferencia">
                    <label class="active" for="localReferencia">Local de Referência</label>
                </div>
            </div>
            <div class="row">
                <div class="col s12">
                    <p>
                        <label>
                            <input type="checkbox" class="termos" />
                            <span>Li e aceito os termos de uso</span>
                        </label>
                    </p>
                </div>
            </div>
            <div class="row">
                <div class="col s3 offset-s6">
                    <button class="btn waves-effect waves-light red" type="submit" name="action">Limpar
                        <i class="material-icons right">send</i>
                    </button>
                </div>
                <div class="col s3">
                    <button class="btn waves-effect waves-light" type="submit" name="action">Enviar
                        <i class="material-icons right">send</i>
                    </button>

                </div>
            </div>
            
        </div>
	
    </section>
 
</div>

</body>

</html>