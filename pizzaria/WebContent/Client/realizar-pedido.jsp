<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>Insert title here</title>
  
</head>

<body>
   <jsp:include page="../imports/header.jsp"/>
        <ul class="sidenav" id="mobile-demo">
            <li><a href="">home</a></li>
            <li><a href="">cardapio</a></li>
            <li><a href="">Monte seu pedido</a></li>
            <li><a href="">carrinho</a></li>
            <li><a class="waves-effect waves-light btn modal-trigger" href="#modal1">login</a></li>
        </ul>
        <div class="clear"></div>
    </div>


    <section>
        <div class="container">
            <div class="row">
                <div class="input-field col s6">
                    <label class="active" for="procurar">Pesquisar Cliente</label>
                    <input type="search" name="search" id="procurar">
                </div>
            </div>
            <div class="row">
                <form class="col s12">
                    <div class="row">
                        <div class="input-field col s4">
                            <label>Cliente</label>
                            <input type="text" class="cliente" name="cliente" disabled>
                        </div>
                        <div class="input-field col s6">
                            <label>Telefone</label>
                            <input type="text" class="telefone" name="telefone" disabled>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                            <label>Endereço</label>
                            <input type="text" class="endereco" name="endereco" disabled>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s3">
                            <select>
                                <option value="" disabled selected>Tipo</option>
                                <option value="1">Tipo 1</option>
                                <option value="2">Tipo 2</option>
                                <option value="3">Tipo 3</option>
                            </select>
                        </div>
                        <div class="input-field col s2">
                            <select>
                                <option value="" disabled selected>Tamanho</option>
                                <option value="1">Tamanho 1</option>
                                <option value="2">Tamanho 2</option>
                                <option value="3">Tamanho 3</option>
                            </select>
                        </div>
                        <div class="input-field col s2">
                            <input type="number" name="quantidade" id="quantidade">
                            <label class="active" for="quantidade">Quantidade</label>
                        </div>
                        <div class="input-field col s2">
                            <select>
                                <option value="" disabled selected>Sabor</option>
                                <option value="1">Sabor 1</option>
                                <option value="2">Sabor 2</option>
                                <option value="3">Sabor 3</option>
                            </select>
                        </div>
                        <div class="input-field col s2">
                            <input type="text" name="valor" id="valor" disabled>
                            <label class="active" for="valor">Valor</label>
                        </div>
                        <div class="col s1" style="margin-top: 25px">
                            <a class="btn-floating btn-small waves-effect waves-light red">
                                <i class="material-icons">remove</i>
                            </a>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col s2 offset-s11">
                            <a class="btn-floating btn-small waves-effect waves-light green">
                                <i class="material-icons">add</i>
                            </a>
                        </div>
                    </div>


                    <div class="row">
                        <div class="input-field col s12">
                            <textarea id="observacoes" class="materialize-textarea"></textarea>
                            <label for="observacoes">Observações</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col s3">
                            <input type="text" name="valorTotal" id="valorTotal" disabled>
                            <label class="active" for="valorTotal">Valor Total</label>
                        </div>
                        <div class="col s3 offset-s3">
                            <button class="btn waves-effect waves-light" type="submit" name="action">Salvar
                                <i class="material-icons right">send</i>
                            </button>
                        </div>
                        <div class="col s3">
                            <button class="btn waves-effect waves-light red" type="submit" name="action">Cancelar
                                <i class="material-icons right">send</i>
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </section>



    <footer class="page-footer">
        <div class="container">
            <div class="row">
                <div class="col l6 s12">
                    <h5 class="white-text">Footer Content</h5>
                    <p class="grey-text text-lighten-4">You can use rows and columns here to organize your footer content.
                    </p>
                </div>
                <div class="col l4 offset-l2 s12">
                    <h5 class="white-text">Links</h5>
                    <ul>
                        <li><a class="grey-text text-lighten-3" href="#!">Link 1</a></li>
                        <li><a class="grey-text text-lighten-3" href="#!">Link 2</a></li>
                        <li><a class="grey-text text-lighten-3" href="#!">Link 3</a></li>
                        <li><a class="grey-text text-lighten-3" href="#!">Link 4</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="footer-copyright">
            <div class="container">
                © 2014 Copyright Text
                <a class="grey-text text-lighten-4 right" href="#!">More Links</a>
            </div>
        </div>
        <div class="clear"></div>
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
        <script type="text/javascript" src="js/main.js"></script>
    </footer>

</body>

</html>