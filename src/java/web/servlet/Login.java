/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.servlet;

import api.modelo.Imagem;
import api.servico.ServicoImagem;
import core.servico.ServicoImagemImpl;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sham
 */
public class Login extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) {
                                

        ServletContext sc = req.getServletContext();
        try {
          
            req.setAttribute("falhaAutenticacao", false);
            sc.getRequestDispatcher("/dynamic/jsp/login.jsp").forward(req, res);
        } catch (Exception e) {

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext sc = req.getServletContext();
        try {
            req.setAttribute("falhaAutenticacao", false);
            sc.getRequestDispatcher("/dynamic/jsp/login.jsp").forward(req, resp);
        } catch (Exception e) {

        }
    }

}
