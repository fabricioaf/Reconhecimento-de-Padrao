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
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
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
        try {
            String sql = "insert into padrao(nome_padrao, imagem_padrao, tipo) values( ?, ? , ?);";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, padrao.getNome());
            ps.setBlob(2, padrao.getInputStream());
            ps.setString(3, padrao.getTipo());
            ps.executeQuery();

        } catch (Exception e) {
            System.out.println("Erro create padraoDAOIMP ");
        }

        return this.readByNome(padrao.getNome());
    }

    @Override
    public Padrao readByNome(String nome) {

        Padrao padrao = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id_padrao, imagem_padrao, tipo, nome_padrao FROM padrao WHERE nome_padrao = ?;");
            preparedStatement.setString(1, nome);
            ResultSet resposta = preparedStatement.executeQuery();
            resposta.next();
            padrao = new Padrao();
            padrao.setId(resposta.getInt(1));
            padrao.setTipo(resposta.getString(2));
            padrao.setImage(resposta.getBinaryStream(3));
            padrao.setNome(resposta.getString(4));
        } catch (Exception e) {
            System.out.println("Erro readByNome padraoDAOIMP ");
        }

        return padrao;
    }

    @Override
    public Padrao readById(int id) {

        Padrao padrao = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id_padrao, tipo, imagem_padrao, nome_padrao FROM padrao where id_padrao = ?;");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            padrao = new Padrao();
            padrao.setId(resultSet.getInt(1));
            padrao.setTipo(resultSet.getString(2));
            padrao.setNome(resultSet.getString(4));
            padrao.setImage(resultSet.getBinaryStream(3));

        } catch (Exception e) {
            System.out.println("Erro readById padraoDAOIMP ");
        }

        return padrao;
    }

    @Override
    public List<Padrao> readAll() {
        List<Padrao> lista = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id_padrao, tipo, imagem_padrao, nome_padrao FROM padrao;");
            ResultSet resultSet = preparedStatement.executeQuery();
            lista = new LinkedList<>();
            while (resultSet.next()) {
                Padrao padrao = new Padrao();
                padrao.setId(resultSet.getInt(1));
                padrao.setTipo(resultSet.getString(2));
                padrao.setNome(resultSet.getString(4));
                padrao.setImage(resultSet.getBinaryStream(3));
                lista.add(padrao);
            }
            
        } catch (Exception e) {
            System.out.println("Erro readById padraoDAOIMP ");
        }

        return lista;
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
