

package controle;

import conexao.ConectaFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Fornecedores;
import modelo.Produtos;


public class ProdutosDAO {
    private Connection con;
    
    public ProdutosDAO() {
        this.con = new ConectaFactory().getConection();
    }
    public void cadastrarProdutos(Produtos obj) {
        try{
            String sql = "insert into tb_produtos(descricao, preco, qtd_estoque, for_id) values(?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement (sql);
            stmt.setString(1, obj.getDescricao());
            stmt.setDouble(2, obj.getPreco());
            stmt.setInt(3, obj.getQtd_estoque());
            stmt.setInt(4, obj.getFornecedor().getId());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");  
        }
        catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao efetuar o cadastro" + erro );
        }
    }
    
    
     public List<Produtos> listarProdutos(){
    try{
    List<Produtos> lista = new ArrayList<>();

String sql = "select p.id, p.descricao, p.preco, p.qtd_estoque, f.nome from tb_produtos as p "
        + "inner join tb_fornecedores as f on(p.for_id = f.id)";
    PreparedStatement stmt = con.prepareStatement(sql);
    ResultSet rs = stmt.executeQuery();

   while(rs.next()) {
       Produtos obj = new Produtos();
       Fornecedores f = new Fornecedores();
       
       obj.setId(rs.getInt("p.id"));
       obj.setDescricao(rs.getString("p.descricao"));
       obj.setPreco(rs.getDouble("p.preco"));
       obj.setQtd_estoque(rs.getInt("p.qtd_estoque"));
       
       
       f.setNome(rs.getString(("f.nome")));
       
       obj.setFornecedor(f);
       lista.add(obj);
   }
   return lista;
}
    
    catch(SQLException erro) {
        JOptionPane.showMessageDialog(null,"Erro ao listar os dados!" + erro);
        
        return null;
    }
    }

    
    
     public void alterarProdutos(Produtos obj){
        try {
       String sql = "update tb_produtos set descricao=?, preco=?, qtd_estoque=?, "
               + "for_id=? where id=?";
              
       PreparedStatement stmt = con.prepareStatement(sql);
       
       stmt.setString(1, obj.getDescricao());
       stmt.setDouble(2, obj.getPreco());
       stmt.setInt(3, obj.getQtd_estoque());
       
       stmt.setInt(4, obj.getFornecedor().getId());
       
       stmt.setInt(5, obj.getId());
              
       stmt.execute();
       stmt.close();
       
       JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
        } 
    catch(SQLException erro){
       JOptionPane.showMessageDialog(null, "Erro ao efetuar o cadastro" + erro);
        }
    }
      
     public void excluirProdutos(Produtos obj){
         try {
             String sql = "delete from tb_produtos where id=?";
             
             PreparedStatement stmt = con.prepareStatement(sql);
             stmt.setInt(1, obj.getId());
             
             stmt.execute();
             stmt.close();
             
             JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
         }
         catch(SQLException erro){
             JOptionPane.showMessageDialog(null, "Erro ao efetuar o cadastro" + erro);
         }
}

   
    
    public List<Produtos>ListarProdutoPorNome(String nome) { 
        try {
            List<Produtos> lista = new ArrayList<>();
            
            String sql = "select p.id, p.descricao, p.preco, p.qtd_estoque, f.nome from tb_produtos as p"
                    + "inner join tb_fornecedores as f on(p.for_id = f.id) where p.descricao like ?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome); 
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
                Produtos obj = new Produtos();
                Fornecedores f = new Fornecedores();
                
                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQtd_estoque(rs.getInt("p.qtd_estoque"));
                
                f.setNome(rs.getString(("f.nome")));
                
                obj.setFornecedor(f);
                lista.add(obj);
            }
            return lista;
    }
        catch(SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar os dados!" + erro);
            return null;
        }
}

    public List<Produtos> listarProdutosPorNome(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
     

