/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.dao;

import api.dao.PapelDAO;
import api.modelo.EnumPapeis;
import api.modelo.Papel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author sham
 */
public class PapelDAOMariaDB implements PapelDAO {

    Connection connection;

    public PapelDAOMariaDB() {
        Conexao conexao = Conexao.getInstance();
        connection = conexao.getConnection();

    }

    @Override
    public Papel create(Papel papel) {
        //OK
        try {
            PreparedStatement cs = connection.prepareStatement("insert into papel values( ? , ? );");
            cs.setInt(1, papel.getId());
            cs.setString(2, papel.getDescricao().name());
            cs.executeQuery();
        } catch (Exception e) {
            System.out.println("Erro ao Criar : PapelDAO : CREATE");
        }
        return papel;
    }

    @Override
    public Papel readById(int id) {
        //OK ADAPTADA COM SWITCH
        Papel papel = new Papel();
        String sql = "select * from papel where id_papel =  ?";
        try {
            ResultSet resultSet;
            try (PreparedStatement comandoSQLp = connection.prepareStatement(sql)) {
                comandoSQLp.setInt(1, id);
                resultSet = comandoSQLp.executeQuery();
                resultSet.next();
                papel.setId(id);
                papel.setDescricao(EnumPapeis.valueOf(resultSet.getString(2)));
                comandoSQLp.close();
            }

            resultSet.close();
            return papel;

        } catch (Exception e) {
            System.out.println("Erro Conexão: PapelDAO ERRO: ReadById!");
        }
        return papel;
    }

    @Override
    public Papel readByDescricao(EnumPapeis descricao) {
        //NAO TESTADA
        Papel papel = null;
        String sql = "select * from papel where descricao =  ?";
        try {
            PreparedStatement comandoSQLp = connection.prepareStatement(sql);
            comandoSQLp.setString(1, descricao.toString());
            ResultSet resultSet = comandoSQLp.executeQuery();
            resultSet.next();
            papel = new Papel();
            papel.setId(resultSet.getInt(1));
            papel.setDescricao(EnumPapeis.valueOf(resultSet.getString(2)));
            comandoSQLp.close();
            resultSet.close();

        } catch (Exception e) {
            System.out.println("Erro Conexão: PapelDAO ERRO: ReadByDESCRICAO!");
        }

        return papel;
    }

    @Override
    public List<Papel> readAll() {
        //OK
        List<Papel> papeis = new LinkedList<>();
        String sql = "select * from papel";
        try (PreparedStatement comandoSQLp = connection.prepareStatement(sql)) {
            ResultSet resultSet = comandoSQLp.executeQuery();
            while (resultSet.next()) {
                Papel papel = new Papel();
                papel.setId(resultSet.getInt(1));
                String str = resultSet.getString(2);
                papel.setDescricao(EnumPapeis.valueOf(str));
                papeis.add(papel);
                
            }
            resultSet.close();
        } catch (Exception e) {
            System.out.println("Erro Conexão: PapelDAO ERRO: ReadALL!");
        }
        

        return papeis;
    }

    @Override
    public Papel update(Papel papel, Papel papelNovo) {
        //NAO TESTADA
        try {
            this.delete(papel);
            this.create(papelNovo);
            return papelNovo;
        } catch (Exception e) {
            System.out.println("Erro Conexão: PapelDAO ERRO: update!");
        }
        return papelNovo;
    }

    @Override
    public boolean delete(Papel papel) {
        //NAO TESTADA
        String delete = "delete from papel where id_papel =  ?";
        try {
            PreparedStatement comandoSQLp = connection.prepareStatement(delete);
            comandoSQLp.setInt(1, (int) papel.getId());
            comandoSQLp.executeQuery();
            return true;
        } catch (Exception e) {
            System.out.println("Erro Conexão: PapelDAO ERRO: delete!");
        }
        return false;
    }

}
