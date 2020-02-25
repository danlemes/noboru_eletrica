package BancoDeDados;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexaoBancoDeDados {
          
    public static java.sql.Connection conectar(){
        
        java.sql.Connection conexao = null;
        
        String url =        "jdbc:mysql://localhost:3306/noboru_eletrica?useSSL=false";
        String user =       "root";
        String password =   "root";
        
        try { 
            conexao = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return conexao;
    }
}
