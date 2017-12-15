/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.servico;

import api.modelo.Galeria;
import api.modelo.Imagem;
import api.modelo.Usuario;

/**
 *
 * @author sham
 */
public interface ServicoImagem {
    public Galeria readAll();
    public Imagem readById(int id);
    public Galeria readByUsuario(Usuario usuario);
    public Imagem deleteById(int id);
}
