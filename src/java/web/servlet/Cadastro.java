/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.servlet;

import api.dao.PapelDAO;
import api.modelo.AcessoBanco;
import api.modelo.Papel;
import core.dao.PapelDAOMariaDB;
import java.io.IOException;
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
public class Cadastro extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        PapelDAO pdao = new PapelDAOMariaDB();
        List<Papel> papeis = pdao.readAll();
        AcessoBanco.getInstance().setPapeis(papeis);
        req.setAttribute("usuarioLogado", AcessoBanco.getInstance().getUsuario());
        req.setAttribute("papeis", papeis);
        boolean falha = false;
        req.setAttribute("falhaCriarUsuario", falha );
        req.setAttribute("usuarioCriado", falha );
        try {
            ServletContext sc = req.getServletContext();
            sc.getRequestDispatcher("/dynamic/jsp/cadastro.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {

        }
    }

}
