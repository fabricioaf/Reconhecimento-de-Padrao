/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.dao;

import api.dao.GaleriaDAO;
import api.modelo.Imagem;
import api.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author shan
 */
public class GaleriaDAOMariaDB implements GaleriaDAO{
    
    Connection connection;
    String sql;

    public GaleriaDAOMariaDB() {
        connection = Conexao.getInstance().getConnection();
    }

    @Override
    public Imagem create(Usuario usuario, Imagem imagem) {
        try {
            sql = "insert into galeria values( ?, ?);";
            PreparedStatement comandoSQL = connection.prepareStatement(sql);
            comandoSQL.setInt(1, usuario.getId());
            comandoSQL.setInt(2, imagem.getId());
            comandoSQL.executeQuery();
        } catch (Exception e) {
            System.out.println("Erro: create : GaleriaDaoMariaDB");
        }
        return imagem;
    }

    @Override
    public List<Integer> readByUsuario(Usuario usuario) {
        List<Integer> listaIdImagens = new LinkedList<>();
        try {
            sql = "select id_imagem from galeria where id = ? ";
            PreparedStatement comandoSQL = connection.prepareStatement(sql);
            comandoSQL.setInt(1, usuario.getId());
            ResultSet resultSet = comandoSQL.executeQuery();
            while(resultSet.next()){
                listaIdImagens.add(resultSet.getInt(1));
            }
        } catch (Exception e) {
            System.out.println("Erro: readByUsuario: GaleriaDAOMariaDB");
        }
        
        return listaIdImagens;
    }

    @Override
    public int readByImagem(Imagem imagem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       
}

