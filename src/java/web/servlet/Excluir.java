/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.servlet;

import api.dao.UsuarioDAO;
import api.modelo.AcessoBanco;
import api.modelo.Usuario;
import core.dao.UsuarioDAOMariaDB;
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
public class Excluir extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("usuarioLogado", AcessoBanco.getInstance().getUsuario());
        UsuarioDAO udao = new UsuarioDAOMariaDB();
        List<Usuario> usuarios = udao.readAll();
        
        ServletContext sc = req.getServletContext();
        for(int i = 0; i < usuarios.size(); i++){
            String r = req.getParameter(i+"");
            if(r != null){
                udao.delete(Integer.parseInt(r));
                usuarios = udao.readAll();
            }
            
        }
        req.setAttribute("usuarios", usuarios);
        try {
            sc.getRequestDispatcher("/dynamic/jsp/excluir.jsp").forward(req, resp);
        } catch (Exception e) {
        }
        
    }
    
    
    
}
