/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.servlet;

import api.modelo.AcessoBanco;
import api.modelo.Galeria;
import api.modelo.Usuario;
import api.servico.ServicoImagem;
import core.servico.ServicoImagemImpl;
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
public class MinhasImagens extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext sc = req.getServletContext();
        ServicoImagem si = new ServicoImagemImpl();
        Usuario usuario = AcessoBanco.getInstance().getUsuario();
        Galeria galeria = si.readByUsuario(usuario);
        req.setAttribute("galeria", galeria);
        req.setAttribute("usuarioLogado", AcessoBanco.getInstance().getUsuario());
        try {
            sc.getRequestDispatcher("/dynamic/jsp/minhas_imagens.jsp").forward(req, resp);
        } catch (Exception e) {
            
        }
    }

}
