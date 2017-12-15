<%-- 
    Document   : minhas_imagens
    Created on : Nov 22, 2017, 10:06:31 PM
    Author     : sham
--%>

<%@page import="java.awt.image.renderable.RenderContext"%>
<%@page import="api.modelo.Usuario"%>
<%@page import="api.modelo.Imagem"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="api.modelo.Galeria"%>
<%@page import="core.servico.ServicoImagemImpl"%>
<%@page import="java.io.File"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Minhas Imagens</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css">
        <script src="${pageContext.request.contextPath}/static/js/functions.js" type="text/javascript"></script>
    </head>
    <body>
        <h1 id="titulo_principal">Reconhecimento de Imagens</h1>
        <div class="content">
            <form id="menu" method="post">
                <input type="submit" value="Perfil" formaction="${pageContext.request.contextPath}/Perfil">
                <input type="submit" value="Sair" formaction="${pageContext.request.contextPath}/">
            </form>      
            <h2 id="subtitulo_principal">Minhas Imagens</h2>
            <div id="sub_content">
                <ul id="lista_imagens">
                    <%Usuario usuario = (Usuario) request.getAttribute("usuarioLogado");%>
                    <lu>
                    <%Galeria galeria = (Galeria) request.getAttribute("galeria");%>
                    <%int count = 0;%>
                    <%for(Imagem i : galeria.getImagens()){%>
                        <%String nome = i.getNome();%>
                        <%String imgPath = i.getLocalEquivalente();%>
                        <li>
                            <p><%=count+": "%><%=nome%> </p>
                            <img src="<%=imgPath%>" title="<%=nome%>" width="80px" height="80px">
                            <form method="post" action="${pageContext.request.contextPath}/Info">
                                <input type="submit" value="Info" name="">  
                            </form>
                            
                            <%count++;%>
                        </li>
                        </br>
                        <% int id = i.getId(); %>
                        <%--<script>criarImagem( "<%=id%>", "<%=nome%>" , "<%=imgPath%>");</script>
                        "${pageContext.request.contextPath}/static/img/image_estrela.jpg"--%>
                    <%}%>
                </ul>
            </div>
        </div>
    </body>
</html>
