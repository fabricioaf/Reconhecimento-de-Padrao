/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.dao;

import api.modelo.Galeria;
import api.modelo.Imagem;

/**
 *
 * @author sham
 */
public interface ImagemDAO {
    public Imagem createImagem(Imagem imagem);
    public Imagem readById(int id);
    public Imagem readByName(String name);
    public Galeria readAll();
    public Imagem updateById(int id, Imagem imagem);
    public Imagem deleteById(int id);
    
   
}
