/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.servlet;

import api.modelo.AcessoBanco;
import api.modelo.Usuario;
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
public class Autenticar extends HttpServlet {
     
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            request.setCharacterEncoding("UTF-8");
        } catch (Exception e) {
        }
        String nomeUsuario = (String) request.getParameter("usuario");
        String senha = (String)request.getParameter("senha");
        ServicoUsuarioImpl sui = new ServicoUsuarioImpl();
        Usuario usuarioBD = sui.readByNomeUsuario(nomeUsuario);
        ServletContext sc = getServletContext();
        if (usuarioBD != null && senha.equals(usuarioBD.getSenha())) {
            try {
                // SET USUARIO NO SINGLETON ACESSOBANCO
                AcessoBanco.getInstance().setUsuario(usuarioBD);
                
                request.setAttribute("usuarioLogado", AcessoBanco.getInstance().getUsuario());
                sc.getRequestDispatcher("/dynamic/jsp/perfil.jsp").forward(request, response);
            } catch (Exception e) {
            }
        } else {
            try {
                request.setAttribute("falhaAutenticacao", true);
                sc.getRequestDispatcher("/dynamic/jsp/login.jsp").forward(request, response);

            } catch (Exception e) {
            }
        }

    } 
    
}
