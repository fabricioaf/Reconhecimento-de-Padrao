/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.dao;

import api.dao.PapelUsuarioDAO;
import api.modelo.Papel;
import api.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author sham
 */
public class PapelUsuarioDAOMariaDB implements PapelUsuarioDAO {

    Connection connection;

    public PapelUsuarioDAOMariaDB() {
        Conexao conexao = Conexao.getInstance();
        connection = conexao.getConnection();
    }

    @Override
    public List<Integer> readByUsuario(Usuario usuario) {
        //OK
        List<Integer> papeis = new LinkedList<>();
        try {
            PreparedStatement comandSQLp = connection.prepareStatement("select * from papel_usuario where id_usuario = ? ;");
            comandSQLp.setInt(1, usuario.getId());
            ResultSet rs = comandSQLp.executeQuery();
            while (rs.next()) {
                papeis.add(rs.getInt(1));
            }
            comandSQLp.close();
            rs.close();

        } catch (Exception e) {
            System.out.println("Erro Conexão: PapelUsuarioDao: ReadByUsuario!");
        }

        return papeis;
    }

    @Override
    public List<Integer> readByPapel(Papel papel) {
        //NAO TESTADA
        List<Integer> usuarios = new LinkedList<>();
        try {
            PreparedStatement comandSQLp = connection.prepareStatement("select * from papel_usuario where id_papel = ?");
            comandSQLp.setString(1, papel.getId() + "");
            ResultSet rs = comandSQLp.executeQuery();
            while (rs.next()) {
                usuarios.add(rs.getInt(2));
            }
            comandSQLp.close();
            rs.close();

        } catch (Exception e) {
            System.out.println("Erro Conexão: PapelUsuarioDao: ReadByPapel!");
        }

        return usuarios;
    }

    @Override
    public List<Integer> create(Usuario usuario, Papel papel) {
        List<Integer> result = new LinkedList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("insert into papel_usuario values(?, ?);");
            int id = papel.getId();
            result.add(id);
            ps.setInt(1, id);
            id = usuario.getId();
            result.add(id);
            ps.setInt(2, id);
            ps.executeQuery();

        } catch (Exception e) {
            System.out.println("Erro Conexão: PapelUsuarioDao: Create!");
        }
        return result;
    }

    @Override
    public List<Integer> delete(Usuario usuario, Papel papel) {
        List<Integer> result = new LinkedList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("delete from papel_usuario where id_papel  = ? and id_usuario = ?");
            int id = papel.getId();
            result.add(id);
            ps.setInt(1, id);
            id = usuario.getId();
            result.add(id);
            ps.setInt(2, id);
            ps.executeQuery();

        } catch (Exception e) {
            System.out.println("Erro Conexão: PapelUsuarioDao: Create!");
        }
        return result;
    }

    
}
