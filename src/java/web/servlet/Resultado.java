/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.servlet;

import api.modelo.AcessoBanco;
import api.modelo.Padrao;
import api.modelo.Usuario;
import api.servico.ServicoPadrao;
import core.servico.ServicoPadraoImpl;
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
 * @author shan
 */
public class Resultado extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("usuarioLogado", AcessoBanco.getInstance().getUsuario());
        req.setAttribute("imagem", AcessoBanco.getInstance().getImagem());
        ServicoPadrao servicoPadrao = new ServicoPadraoImpl();
        String boxPadroes[] = req.getParameterValues("checkboxPadrao");
        List<Padrao> padroes = new LinkedList<>();
        if (boxPadroes != null && boxPadroes.length > 0) {
            for (String item : boxPadroes) {
                int id = Integer.parseInt(item);
                Padrao p = servicoPadrao.readById(id);
                padroes.add(p);
                System.out.println(p.getStringBase64());
            }
        }else{
            System.out.println("CheckBox invalid");
        }
        
        req.setAttribute("padroes", padroes);
        try {
            ServletContext sc = req.getServletContext();
            sc.getRequestDispatcher("/dynamic/jsp/resultado_reconhecimento.jsp").forward(req, resp);;
        } catch (Exception e) {
        }

    }

}
