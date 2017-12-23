/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.dao;

import api.modelo.Padrao;
import java.util.List;

/**
 *
 * @author sham
 */
public interface PadraoDAO {
    
    public Padrao create(Padrao padrao);
    public Padrao readById(int id);
    public Padrao readByNome(String nome);
    public List<Padrao> readAll();
    public Padrao updateById(int id, Padrao padrao);
    public Padrao deleteById(int id);
    
}
