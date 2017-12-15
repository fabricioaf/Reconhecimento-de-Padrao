/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.dao;

import api.dao.ImagemDAO;
import api.modelo.Galeria;
import api.modelo.Imagem;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.imageio.ImageIO;

/**
 *
 * @author sham
 */
public class ImagemDAOMariaDB implements ImagemDAO {

    Connection connection;

    public ImagemDAOMariaDB() {
        connection = Conexao.getInstance().getConnection();
    }

    @Override
    public Imagem createImagem(Imagem imagem) {
        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(imagem.getImage(), ".jpg", os);
            String sql = "insert into imagem(?, ?, ?, ?);";
            InputStream inputStream = new ByteArrayInputStream(os.toByteArray());
            PreparedStatement comandoSQL = connection.prepareStatement(sql);
            comandoSQL.setString(1, imagem.getTipo());
            comandoSQL.setString(2, imagem.getNome());
            comandoSQL.setString(3, imagem.getTamanho());
            comandoSQL.setBlob(4, inputStream);
        } catch (Exception e) {
        }
        return imagem;
    }

    @Override
    public Imagem readById(int id) {
        Imagem img = new Imagem();
        String sql = "select id_imagem, nome, tamanho, tipo, imagem from imagem where id = ?;";
        try {
            PreparedStatement comandoSQL = connection.prepareStatement(sql);
            comandoSQL.setInt(1, id);
            ResultSet resultSet = comandoSQL.executeQuery();
            resultSet.next();
            img.setId(resultSet.getInt(1));
            img.setNome(resultSet.getString(2));
            img.setTamanho(resultSet.getString(3));
            img.setTipo(resultSet.getString(4));
            img.setImage(resultSet.getBinaryStream(5));
        } catch (Exception e) {
            System.out.println("Erro: ReadById ImagemDAOMariaDB");
        }
        return img;
    }

    @Override
    public Galeria readAll() {
        Galeria galeria = new Galeria();
        String sql = "select id_imagem, nome, tamanho, tipo, imagem from imagem;";
        try {
            PreparedStatement comandoSQL = connection.prepareStatement(sql);
            ResultSet resultSet = comandoSQL.executeQuery();
            while (resultSet.next()) {
                Imagem img = new Imagem();
                img.setId(resultSet.getInt(1));
                img.setNome(resultSet.getString(2));
                img.setTamanho(resultSet.getString(3));
                img.setTipo(resultSet.getString(4));
                img.setImage(resultSet.getBinaryStream(5));
                galeria.addImagem(img);
            }
        } catch (Exception e) {
        }
        return galeria;
    }

    @Override
    public Imagem updateById(int id, Imagem imagem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Imagem deleteById(int id) {
        Imagem img = new Imagem();
        String sql = "delete from imagem where id = ?;";
        try {
            PreparedStatement comandoSQL = connection.prepareStatement(sql);
            comandoSQL.setInt(1, id);
            comandoSQL.executeQuery();
        } catch (Exception e) {
            System.out.println("Erro: deleteById ImagemDAOMariaDB");
        }
        return img;
    }

}
