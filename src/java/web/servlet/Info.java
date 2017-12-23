/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.servlet;

import api.modelo.AcessoBanco;
import api.modelo.Galeria;
import api.modelo.Imagem;
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
 * @author shan
 */
public class Info extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        ServletContext sc = req.getServletContext();
        Usuario usuario = AcessoBanco.getInstance().getUsuario();
        ServicoImagem si = new ServicoImagemImpl();
        Galeria galeria = si.readByUsuario(usuario);
        
        for(int i = 0; i < galeria.getSize(); i++){
            String r = req.getParameter(i+"");
            if(r != null){
                Imagem img = galeria.getImagemById(i);
                AcessoBanco.getInstance().setImagem(img);
                req.setAttribute("index", i);
                break;
            }
        }
        req.setAttribute("imagem", AcessoBanco.getInstance().getImagem());
        try {
            req.setAttribute("falhaAutenticacao", false);
            sc.getRequestDispatcher("/dynamic/jsp/info_img.jsp").forward(req, resp);
        } catch (Exception e) {

        } //To change body of generated methods, choose Tools | Templates.
    }

}
