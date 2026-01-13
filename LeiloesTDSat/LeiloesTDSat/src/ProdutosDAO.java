/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutosDAO {

    public boolean cadastrarProduto(ProdutosDTO produto) {

        String sql = "INSERT INTO produtos (nome, valor, status) VALUES (?, ?, ?)";

         try {
        conectaDAO conexao = new conectaDAO();
        Connection conn = conexao.connectDB();

        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, produto.getNome());
        pst.setInt(2, produto.getValor());
        pst.setString(3, produto.getStatus());

        pst.executeUpdate();
        return true; // ✅ SUCESSO

    } catch (SQLException e) {
        e.printStackTrace();
        return false; // ❌ FALHA
    }
}

    
    public ArrayList<ProdutosDTO> listarProdutos() {

        ArrayList<ProdutosDTO> lista = new ArrayList<>();
        String sql = "SELECT * FROM produtos";

        try {
            conectaDAO conexao = new conectaDAO();
            Connection conn = conexao.connectDB();

            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                ProdutosDTO produto = new ProdutosDTO();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setValor(rs.getInt("valor"));
                produto.setStatus(rs.getString("status"));

                lista.add(produto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}


    
    
    
        


