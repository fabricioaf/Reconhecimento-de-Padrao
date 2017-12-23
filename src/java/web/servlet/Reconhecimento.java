/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.servlet;

import api.modelo.AcessoBanco;
import api.modelo.Galeria;
import api.modelo.Padrao;
import api.modelo.Usuario;
import api.servico.ServicoImagem;
import api.servico.ServicoPadrao;
import core.servico.ServicoImagemImpl;
import core.servico.ServicoPadraoImpl;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author shan
 */
public class Reconhecimento extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        ServicoPadrao servicoPadrao = new ServicoPadraoImpl();
        //int id = Integer.getInteger(req.getParameter("id"));
        //req.setAttribute("id", id);
        Usuario usuario = AcessoBanco.getInstance().getUsuario();
        List<Padrao> padroes = servicoPadrao.readAll();
        req.setAttribute("padroes", padroes);
        req.setAttribute("usuarioLogado", AcessoBanco.getInstance().getUsuario());
        try {
            ServletContext sc = req.getServletContext();
            sc.getRequestDispatcher("/dynamic/jsp/opcao_reconhecimento.jsp").forward(req, resp);;
        } catch (Exception e) {
        }
        
        
    }
    
    
    
}
