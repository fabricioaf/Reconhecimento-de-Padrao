/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.servico;

import api.dao.GaleriaDAO;
import api.dao.ImagemDAO;
import api.modelo.Galeria;
import api.modelo.Imagem;
import api.modelo.Usuario;
import api.servico.ServicoImagem;
import core.dao.GaleriaDAOMariaDB;
import core.dao.ImagemDAOMariaDB;
import java.util.List;

/**
 *
 * @author sham
 */
public class ServicoImagemImpl implements ServicoImagem{
    
        private final ImagemDAO idao;
        private final GaleriaDAO gdao;

    public ServicoImagemImpl() {
        idao = new ImagemDAOMariaDB();
        gdao = new GaleriaDAOMariaDB();
    }

    @Override
    public Imagem createImagem(Imagem imagem, Usuario usuario) {
        idao.createImagem(imagem);
        gdao.create(usuario, imagem);
        return idao.readByName(imagem.getNome());
    }

    
    
    @Override
    public Galeria readAll() {
        return idao.readAll();
    }
    
    @Override
    public Galeria readByUsuario(Usuario usuario){
        Galeria galeria = new Galeria();    
        List<Integer> lista = gdao.readByUsuario(usuario);
        for(int i : lista){
            galeria.addImagem(idao.readById(i));
        }
        return galeria;
    }

    @Override
    public Imagem readById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Imagem deleteById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
