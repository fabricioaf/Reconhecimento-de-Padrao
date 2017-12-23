/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.servico;

import api.dao.PadraoDAO;
import api.modelo.Padrao;
import api.servico.ServicoPadrao;
import core.dao.PadraoDAOMariaDB;
import java.util.List;

/**
 *
 * @author shan
 */
public class ServicoPadraoImpl implements ServicoPadrao{

    PadraoDAO pdao;
    
    public ServicoPadraoImpl() {
        pdao = new PadraoDAOMariaDB();
    }

    @Override
    public List<Padrao> readAll() {
        
        return pdao.readAll();
    }
    
    

    @Override
    public Padrao create(Padrao padrao) {
        return pdao.create(padrao);
    }

    @Override
    public Padrao readById(int id) {
        return pdao.readById(id);
    }
    
    
    
}
