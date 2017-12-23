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
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author shan
 */
public class InserirImagem extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        ServicoImagem si = new ServicoImagemImpl();

        //LENDO E PREPARANDO ENTRADAS
        Usuario usuario = AcessoBanco.getInstance().getUsuario();
        String nome = req.getParameter("description"); // Retrieves <input type="text" name="description">
        Part filePart = req.getPart("uploaded"); // Retrieves <input type="file" name="file">
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
        InputStream fileContent = filePart.getInputStream();
        
        Imagem img = new Imagem(nome, fileContent);
        si.createImagem(img, usuario);
        
        
        //PREPARANDO PARA CRIAR LISTA IMAGEM
        Galeria galeria = si.readByUsuario(usuario);

        req.setAttribute("galeria", galeria);
        req.setAttribute("usuarioLogado", AcessoBanco.getInstance().getUsuario());
        ServletContext context = getServletContext();
        try {
            context.getRequestDispatcher("/dynamic/jsp/minhas_imagens.jsp").forward(req, resp);
        } catch (Exception e) {
        }

    }

}
