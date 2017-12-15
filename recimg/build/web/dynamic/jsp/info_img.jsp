<%-- 
    Document   : info_img
    Created on : Dec 8, 2017, 6:49:31 PM
    Author     : shan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Dados da Imagem</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="/recimg/static/css/style.css">
    </head>
    <body>
        <h1 id="titulo_principal">Reconhecimento de Imagens</h1>
        <div class="content">
            <form id="menu" method="post">
                <input type="submit" value="Perfil" formaction="/recimg/Perfil">
                <input type="submit" value="Minhas Imagens" formaction="/recimg/MinhasImagens">
                <input type="submit" value="Sair" formaction="/recimg/">
            </form>      
            <h2 id="subtitulo_principal">Dados da Imagem</h2>
            <div id="sub_content">
                <img src="${pageContext.request.contextPath}/static/img/image_estrela_completa_baixo.jpg" title="Imagem Selecionada" ></br>
                <div id="info_imagem">
                    <p>Nome: </p>
                    <p id="dado_nome">Minha Imagem 0</p>
                    </br>                    
                    <p>Tamanho: </p>
                    <p id="dado_tamanho">100 x 100</p>
                    </br>
                    <p>Tipo: </p>
                    <p id="dado_tipo"> .jpg</p>
                    </br>
                    </br>
                    <p>Padrões Reconhecidos:</p>
                    <lu>
                        <li>Modelo Padrão 0</li>
                        <li>Modelo Padrão 1</li>
                        <li>Modelo Padrão 2</li>
                    </lu>
                    </br>
                    <form method="post" action="${pageContext.request.contextPath}/Reconhecimento">
                        <input class="formInput" type="submit" value="Reconhecimento">
                    </form>
                </div>
            </div>
    </body>
</html>