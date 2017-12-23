/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.dao;

import api.modelo.Papel;
import api.modelo.Usuario;
import java.util.List;

/**
 *
 * @author sham
 */
public interface PapelUsuarioDAO {
    public List<Integer> create(Usuario usuario, Papel papel);
    public List<Integer> readByUsuario(Usuario usuario);
    public List<Integer> readByPapel(Papel papel);
    public List<Integer> delete(Usuario usuario, Papel papel);
    
}
