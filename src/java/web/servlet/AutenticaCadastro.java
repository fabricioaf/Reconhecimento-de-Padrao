/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.servlet;

import api.modelo.AcessoBanco;
import api.modelo.EnumPapeis;
import api.modelo.Papel;
import api.modelo.Usuario;
import api.servico.ServicoUsuario;
import core.servico.ServicoUsuarioImpl;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sham
 */
public class AutenticaCadastro extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //INICIANDO BANCO E OBJETOS
        req.setAttribute("usuarioLogado", AcessoBanco.getInstance().getUsuario());
        ServicoUsuario servicoUsuario = new ServicoUsuarioImpl();

        
        //EXTRAINDO DADOS DO HTML
        String nome = (String) req.getParameter("nome");
        String nomeUsuario = (String) req.getParameter("nomeUsuario");
        String email = (String) req.getParameter("mail");
        String senha = (String) req.getParameter("senha");
        String[] stringPapeis = (String[]) req.getParameterValues("papel");

        List<Papel> p = new LinkedList<>();
        for (String s : stringPapeis) {
            for (Papel papel : AcessoBanco.getInstance().getPapeis()) {
                if (papel.getDescricao() == EnumPapeis.valueOf(s)) {
                    p.add(papel);
                }
            }
        }
        
        //CRIANDO NOVO USUARIO
        Usuario u = new Usuario();
        u.setNome(nome);
        u.setEmail(email);
        u.setNomeUsuario(nomeUsuario);
        u.setSenha(senha);
        u.setPapeis(p);

        //CRIANDO USUARIO E SEUS PAPEIS E VERIFICANDO SE EXISTE
        Usuario usuario = servicoUsuario.create(u);
        
        // ALTERANDO DE PAGINA
        ServletContext sc = req.getServletContext();
        try {
            //SET USUARIO SER MOSTRADO INFORMAÇÕES DE CADASTRO
            req.setAttribute("usuarioCriado", usuario);
            sc.getRequestDispatcher("/dynamic/jsp/finalizarCadastro.jsp").forward(req, resp);

        } catch (ServletException | IOException e) {
            //CASO TENHA ALGUM ERRO DIRECIONAR PARA PERFIL
            sc.getRequestDispatcher("/dynamic/jsp/perfil.jsp").forward(req, resp);
        }

    }

}
