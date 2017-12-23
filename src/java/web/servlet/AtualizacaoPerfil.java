/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.servlet;

import api.modelo.AcessoBanco;
import api.modelo.Usuario;
import api.servico.ServicoUsuario;
import core.servico.ServicoUsuarioImpl;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sham
 */
public class AtualizacaoPerfil extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (Exception e) {
        }

        Usuario usuario = AcessoBanco.getInstance().getUsuario();
        ServicoUsuario servicoUsuario = new ServicoUsuarioImpl();

        String novoNome = (String) req.getParameter("novoNome");
        String novoEmail = (String) req.getParameter("novoEmail");
        String senha = (String) req.getParameter("senha");
        String novoSenha = (String) req.getParameter("senhaCheck");
        String novoSenhaConfirmation = (String) req.getParameter("senhaCheckConfirmation");
        ServletContext sc = req.getServletContext();

        //TRATANDO USUARIO
        if (novoNome != null) {
            usuario.setNome(novoNome);
        }
        //TRATANDO EMAIL
        if (novoEmail != null) {
            usuario.setEmail(novoEmail);
        }
        //TRATANDO SENHA
        if (senha != null) {
            if(senha.equals(usuario.getSenha())){
                usuario.setSenha(novoSenha);
            }
            
        }
        Usuario usuarioDB = servicoUsuario.updateByUsuario(usuario);
        if (usuarioDB != null) {
            AcessoBanco.getInstance().setUsuario(usuarioDB);
        } else {
            System.out.println("Erro ao Update");
        }

        req.setAttribute("usuarioLogado", AcessoBanco.getInstance().getUsuario());
        try {
            sc.getRequestDispatcher("/dynamic/jsp/alterar_perfil.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
        }
    }

}
