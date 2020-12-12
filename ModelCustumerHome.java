/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barberapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Valter
 */
public class ModelCustumerHome {
    
    
    private static final String URL = "jdbc:mysql://apontejaj.com:3306/Valter_2019308?useSSL=false";
    private static final String USER = "Valter_2019308";
    private static final String PASS = "2019308";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Erro na conexão com o Banco de Dados: " + e);
        }
    }

    public static void closeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao fechar a conexão com o Banco de Dados: " + e);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt) {
        closeConnection(con);
        try {
            if (stmt != null) {
                stmt.close();
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao fechar a conexão com o Banco de Dados: " + e);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
        closeConnection(con, stmt);
        try {
            if (rs != null) {
                rs.close();
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao fechar a conexão com o Banco de Dados: " + e);
        }
    }
    
}
