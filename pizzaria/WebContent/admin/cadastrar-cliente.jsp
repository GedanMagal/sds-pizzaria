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
<<<<<<< HEAD
<div class="row">
<jsp:include page="header.jsp"/>

    <section class="col s9 main">
     
        <div class="col s9 offset-s6">
           <div class="header-title">
=======
       <jsp:include page="../imports/header.jsp"/>

        <ul class="sidenav" id="mobile-demo">

            <li><a href="">home</a></li>
            <li><a href="">cardapio</a></li>
            <li><a href="">Monte seu pedido</a></li>
            <li><a href="">carrinho</a></li>
            <li><a class="waves-effect waves-light btn modal-trigger" href="#modal1">login</a></li>

        </ul>
        <div class="clear"></div>


    <section>
        <div class="header-title">
>>>>>>> 377aabc8b585b815b33dbc5e784189d3b3f731ec
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
            <h6>Localiza��o</h6>
            <div class="row">
                <div class="input-field col s6">
                    <input type="text" name="endereco" id="endereco">
                    <label class="active" for="nome">Endere�o</label>
                </div>
                <div class="input-field col s3">
                    <input type="text" name="complemento" id="complemento">
                    <label class="active" for="complemento">Complemento</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s6">
                    <input type="text" name="localReferencia" id="localReferencia">
                    <label class="active" for="localReferencia">Local de Refer�ncia</label>
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
		<div class="clear"></div>
    </section>
 
</div>

</body>

</html>