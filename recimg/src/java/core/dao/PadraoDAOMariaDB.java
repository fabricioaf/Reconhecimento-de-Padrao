/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.dao;

import api.dao.PadraoDAO;
import api.modelo.Padrao;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.imageio.ImageIO;

/**
 *
 * @author shan
 */
public class PadraoDAOMariaDB implements PadraoDAO {
    
    Connection connection;

    public PadraoDAOMariaDB() {
        connection = Conexao.getInstance().getConnection();
    }

    @Override
    public Padrao create(Padrao padrao) {
        InputStream inputStream = null;
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(padrao.getPadrao(), ".jpg", baos);
        } catch (Exception e) {
            System.out.println("Erro ao Procurar Imagem local PadraoDAOmariaDB");
            return padrao;
        }
        try {
            String sql = "insert into padrao values( ?, ?, ?);";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, padrao.getId());
            ps.setBlob(2, inputStream);
            ps.setString(3, padrao.getNome());
            
        } catch (Exception e) {
            System.out.println("Erro create padraoDAOIMP ");
        }

        return padrao;
    }

    @Override
    public Padrao readById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Padrao updateById(int id, Padrao padrao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Padrao deleteById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
