/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.dao;

import api.dao.UsuarioDAO;
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
public class UsuarioDAOMariaDB implements UsuarioDAO {

    Connection connection;

    public UsuarioDAOMariaDB() {
        Conexao conexao = Conexao.getInstance();
        connection = conexao.getConnection();
    }

    @Override
    public Usuario create(Usuario usuario) {
        //ok
        try {
            PreparedStatement cs = connection.prepareStatement("insert into usuario(nome, email, senha, nomeUsuario) values( ?, ?, ?, ?)");
            cs.setString(1, usuario.getNome());
            cs.setString(2, usuario.getEmail());
            cs.setString(3, usuario.getSenha());
            cs.setString(4, usuario.getNomeUsuario());
            cs.execute();
            cs.close();
        } catch (Exception e) {
            System.out.println("Erro Conexão: UsuarioDao : Create!");
        }
        return this.readByNomeUsuario(usuario.getNomeUsuario());
    }

    @Override
    public Usuario readById(int id) {
        //ok
        Usuario u = null;
        String sql = "select * from usuario where id = ?";
        try {
            PreparedStatement comandSQLp = connection.prepareStatement(sql);
            comandSQLp.setInt(1, id);
            ResultSet resultSet = comandSQLp.executeQuery();
            resultSet.next();
            u = new Usuario();
            u.setId(resultSet.getInt(1));
            u.setNome(resultSet.getString(2));
            u.setEmail(resultSet.getString(3));
            u.setSenha(resultSet.getString(4));
            u.setNomeUsuario(resultSet.getString(5));
            comandSQLp.close();
            resultSet.close();

        } catch (Exception e) {
            System.out.println("Erro Conexão: UsuarioDao : ReadByID!");
        }
        return u;
    }

    @Override
    public Usuario readByNomeUsuario(String nomeUsuario) {
        //OK
        Usuario u = null;
        String sql = "select * from usuario where nomeUsuario = ?;";
        try {
            PreparedStatement comandSQLp = connection.prepareStatement(sql);
            comandSQLp.setString(1, nomeUsuario);
            ResultSet resultSet = comandSQLp.executeQuery();
            resultSet.next();
            int id = resultSet.getInt("id");
            u = new Usuario();
            u.setId(id);
            u.setNome(resultSet.getString("nome"));
            u.setEmail(resultSet.getString("email"));
            u.setSenha(resultSet.getString("senha"));
            u.setNomeUsuario(resultSet.getString("nomeUsuario"));
            comandSQLp.close();
            resultSet.close();

        } catch (Exception e) {
            System.out.println("Erro Conexão: UsuarioDao : ReadByNomeUsuario!");
        }
        return u;
    }

    @Override
    public Usuario readByEmail(String email) {
        //ok
        Usuario u = null;
        String sql = "select * from usuario where email = ?;";
        try {
            PreparedStatement comandSQLp = connection.prepareStatement(sql);
            comandSQLp.setString(1, email);
            ResultSet resultSet = comandSQLp.executeQuery();
            resultSet.next();
            int id = resultSet.getInt("id");
            u = new Usuario();
            u.setId(id);
            u.setNome(resultSet.getString(2));
            u.setEmail(resultSet.getString(3));
            u.setSenha(resultSet.getString(4));
            u.setNomeUsuario(resultSet.getString(5));
            comandSQLp.close();
            resultSet.close();

        } catch (Exception e) {
            System.out.println("Erro Conexão: UsuarioDao : ReadByNomeEmail!");
        }
        return u;
    }
    

    @Override
    public List<Usuario> readAll() {
        //ok
        List<Usuario> usuarios = new LinkedList<>();
        String sql = "select * from usuario";
        try {
            PreparedStatement comandSQLp = connection.prepareStatement(sql);
            ResultSet resultSet = comandSQLp.executeQuery();
            while (resultSet.next()) {
                Usuario u = new Usuario();
                u.setId(resultSet.getInt(1));
                u.setNome(resultSet.getString(2));
                u.setEmail(resultSet.getString(3));
                u.setSenha(resultSet.getString(4));
                u.setNomeUsuario(resultSet.getString(5));
                usuarios.add(u);
            }
            comandSQLp.close();
            resultSet.close();

        } catch (Exception e) {
            System.out.println("Erro Conexão: UsuarioDao : ReadByALL!");
        }
        return usuarios;
    }

    @Override
    public Usuario update(Usuario usuario) {
        //NAO TESTADA
         try {
            PreparedStatement cs = connection.prepareStatement("update usuario set nome = ?, email = ?, senha = ?, nomeUsuario = ? where id = ? ");
            cs.setString(1, usuario.getNome());
            cs.setString(2, usuario.getEmail());
            cs.setString(3, usuario.getSenha());
            cs.setString(4, usuario.getNomeUsuario());
            cs.setInt(5, usuario.getId());
            cs.execute();
            cs.close();
        } catch (Exception e) {
            System.out.println("Erro Conexão: UsuarioDao : Update!");
        }
        return this.readById(usuario.getId());

    }

    @Override
    public boolean delete(Usuario usuario) {
        //NAO TESTADA
        try {
            this.delete(usuario.getId());
        } catch (Exception e) {
            System.out.println("Erro Conexão: UsuarioDao : deleteUsuario");
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        //ok
        try {
            PreparedStatement comandoSQL = connection.prepareStatement("delete from usuario where id = ?;");
            comandoSQL.setInt(1, id);
            comandoSQL.executeQuery();
            comandoSQL.close();
            return true;
        } catch (Exception e) {
            System.out.println("Erro Conexão: UsuarioDao : deleteID");
        }
        return false;
    }

}
