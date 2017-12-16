/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author sham
 */
public class Conexao {

    static private Conexao uniqueInstance = null;

    static public Conexao getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Conexao();
        }
        return uniqueInstance;
    }

    private Connection connection;
    
    private Conexao() {
        try {
             Class.forName("org.mariadb.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/SistemaWeb", "usuario", "123");
            System.out.println("Connectado UsuarioDAO!");

        } catch (Exception e) {
            System.out.println("Erro de Conexão: CONNECTION MARIADB");
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
}
