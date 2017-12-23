/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.servico;

import api.modelo.Padrao;
import java.util.List;

/**
 *
 * @author sham
 */
public interface ServicoPadrao {
    
    public Padrao create(Padrao padrao);
    public Padrao readById(int id);
    public List<Padrao> readAll();
}
