<%-- 
    Document   : login
    Created on : Nov 17, 2017, 4:55:25 PM
    Author     : sham
--%>

<%@page import="core.dao.Conexao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css">
    </head>
    <body>
        <h1 id="titulo_principal">Reconhecimento de Imagens</h1>
        <div class="content">
            <form id="menu" method="get">
                <input type="submit" value="Informações" formaction="https://web.fe.up.pt/~jmsa/recpad/index.htm">
                <input type="submit" value="Ajuda" hidden="true">
            </form>    
            <h2 id="subtitulo_principal">Faça seu login</h2>
            <form method="post" action="${pageContext.request.contextPath}/Autenticar.action">
                Nome de Usuário
                <input class="formInput formTextInput" id="usernameLogin" type="text" name="usuario" pattern="([A-z0-9À-ž\s]){3,}" required</br>
                Senha
                <input class="formInput formTextInput" id="pswLogin"  type="password" name="senha" pattern="([A-z0-9À-ž\s]){3,}" required></br>


                <script type="text/javascript">
                    var inputSenha = document.getElementById(pswLogin);
                    var inputLogin = document.getElementById(usernameLogin);
                    inputLogin.setAttribute("class", "formInput", "formTextInput", "invalid");
                    inputSenha.setAttribute("class", "formInput", "formTextInput", "invalid");

                </script>
                <%
                    if ((boolean) request.getAttribute("falhaAutenticacao")) {
                        out.println("<p class='invalid'>Usuario ou senha Incorretos</p>");

                    }%>

                <input class="formInput submitButton" type="submit" value="Autenticar">       
            </form>
        </div>
        <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
    </body>
</html>

