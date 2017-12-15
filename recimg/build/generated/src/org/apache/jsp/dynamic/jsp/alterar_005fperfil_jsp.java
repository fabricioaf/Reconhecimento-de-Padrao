package org.apache.jsp.dynamic.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import api.modelo.Usuario;

public final class alterar_005fperfil_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Alterar Perfil</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/css/style.css\">\n");
      out.write("        <script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/js/functions.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1 id=\"titulo_principal\">Reconhecimento de Imagens</h1>\n");
      out.write("        <div class=\"content\">\n");
      out.write("            <form id=\"menu\" method=\"post\">\n");
      out.write("                <input type=\"submit\" value=\"Perfil\" formaction=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/Perfil\">\n");
      out.write("                <input type=\"submit\" value=\"Minhas Imagens\" formaction=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/MinhasImagens\">\n");
      out.write("                <input type=\"submit\" value=\"Sair\" formaction=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/\" >\n");
      out.write("            </form>      \n");
      out.write("            <h2 id=\"subtitulo_principal\">Alterar Perfil</h2>\n");
      out.write("            <div id=\"sub_content\">\n");
      out.write("                <form action=\"\">\n");
      out.write("                    <img id=\"fotoPerfil\"src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/img/me.jpg\" title=\"Sham Vinicius Fiorin\"></br>\n");
      out.write("                    <input type=\"submit\" value=\"Alterar Foto\"></br>\n");
      out.write("                    ");
 Usuario u = (Usuario) request.getAttribute("usuarioLogado");
      out.write("\n");
      out.write("                </form>\n");
      out.write("                <p>Nome:</p> \n");
      out.write("                ");
if(u != null) { 
      out.write("\n");
      out.write("                <h3 id=\"nome\"> ");
      out.print( u.getNome());
      out.write(" </h3>\n");
      out.write("                <p>E-mail:</p>\n");
      out.write("                <h3> ");
      out.print( u.getEmail());
      out.write(" </h3>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("                <form method=\"post\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/AtualizacaoPerfil\">\n");
      out.write("                    <p>Nome</p>\n");
      out.write("                    <input name=\"novoNome\" class=\"formInput formTextInput\" title=\"Insira novo nome\"></br>\n");
      out.write("                    <p>Email</p>\n");
      out.write("                    <input name=\"novoEmail\" class=\"formInput formTextInput\" title=\"Insira novo Email\"></br>\n");
      out.write("                    <p>Senha Atual</p> \n");
      out.write("                    <input class=\"formInput formTextInput\" name=\"senha\" type=\"password\" title=\"Insira sua senha\"  pattern=\"([A-z0-9À-ž\\s]){3,}\"></br>\n");
      out.write("                    <p>Nova Senha</p>\n");
      out.write("                    <input class=\"formInput formTextInput\" name=\"senhaCheck\" type=\"password\" title=\"Insira nova senha\"  pattern=\"([A-z0-9À-ž\\s]){3,}\"></br>\n");
      out.write("                    <p>Confirme Nova Senha</p>\n");
      out.write("                    <input class=\"formInput formTextInput\" name=\"senhaCheckConfirmation\" type=\"password\" title=\"Insira nova senha\"  pattern=\"([A-z0-9À-ž\\s]){3,}\"></br>\n");
      out.write("                    <input type=\"submit\" value=\"Salvar Alterações\">\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
