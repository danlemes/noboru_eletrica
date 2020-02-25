package Controladores;

import BancoDeDados.ConexaoBancoDeDados;
import Modelos.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ClienteDAO {
    
    Connection conn = ConexaoBancoDeDados.conectar();

    public boolean verificarSeCPFJaEstaCadastrado(String cpf, int id) throws SQLException {
        List dadosCliente = new ArrayList();
        
        String sql = "SELECT * FROM cliente "
                   + "WHERE cpf = " + cpf + " AND idCliente != " + id + " AND ativo = 1;";
        
        PreparedStatement cmd = (PreparedStatement) conn.prepareStatement(sql);
        cmd.execute(); 
        ResultSet resultado = cmd.executeQuery(sql);
        
        while (resultado.next()) {
            dadosCliente.add(resultado.getString("nome"));
        }
        if (dadosCliente.size() > 0) {
            return false;
        } else {
            return true;
        }
    }

    public void cadastrarCliente(Cliente cliente, JFrame frame) throws SQLException {
        String sql = "INSERT INTO cliente "
                   + "(nome, cpf, celular, email, ativo) "
                   + "VALUES (?,?,?,?,1)";
        
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, cliente.getNome());
        stmt.setString(2, cliente.getCpf());
        stmt.setString(3, cliente.getCelular());
        stmt.setString(4, cliente.getEmail());
        stmt.execute();
        stmt.close();
        JOptionPane.showMessageDialog(frame, "Cliente cadastrado com sucesso.");
        conn.close();
    }
}
