
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




public class FornecedoresDAO{
    private Connection con;
    
    public FornecedoresDAO() {
        this.con = new ConectaFactory().getConection();
    }
    
    public void cadastrarFornecedores(Fornecedores obj){
        try {
       String sql = "insert into tb_fornecedores(nome, cnpj, email, telefone, celular, cep,"
               + "endereco, numero, complemento, bairro, cidade, estado )"
               + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
       PreparedStatement stmt = con.prepareStatement(sql);
       stmt.setString(1, obj.getNome());
       stmt.setString(2, obj.getCnpj());
       stmt.setString(3, obj.getEmail());
       stmt.setString(4, obj.getTelefone());
       stmt.setString(5, obj.getCelular());
       stmt.setString(6, obj.getCep());
       stmt.setString(7, obj.getEndereco());
       //stmt.setInt(9, obj.getNumero);
       stmt.setInt(8, obj.getNumero());
       stmt.setString(9, obj.getComplemento());
       stmt.setString(10, obj.getBairro());
       stmt.setString(11, obj.getCidade());
       stmt.setString(12, obj.getEstado());
       
       stmt.execute();
       stmt.close();
       
       JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        } 
    catch(SQLException erro){
       JOptionPane.showMessageDialog(null, "Erro ao efetuar o cadastro" + erro);
        }
    }   
  
    public void alterarFornecedores(Fornecedores obj){
        try {
       String sql = "update tb_fornecedores set nome=?, cnpj=?, email=?, telefone=?, celular=?, "
               + "cep=?,endereco=?, numero=?, complemento=?, bairro=?, cidade=?, estado=? where id=?";
              
       PreparedStatement stmt = con.prepareStatement(sql);
       stmt.setString(1, obj.getNome());
       stmt.setString(2, obj.getCnpj());
       stmt.setString(3, obj.getEmail());
       stmt.setString(4, obj.getTelefone());
       stmt.setString(5, obj.getCelular());
       stmt.setString(6, obj.getCep());
       stmt.setString(7, obj.getEndereco());
       stmt.setInt(8, obj.getNumero());
       stmt.setString(9, obj.getComplemento());
       stmt.setString(10, obj.getBairro());
       stmt.setString(11, obj.getCidade());
       stmt.setString(12, obj.getEstado());
       stmt.setInt(13, obj.getId());
       
       stmt.execute();
       stmt.close();
       
       JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
        } 
    catch(SQLException erro){
       JOptionPane.showMessageDialog(null, "Erro ao efetuar o cadastro" + erro);
        }
    }
    
    
    public void excluirFornecedores(Fornecedores obj){
         try {
             //Verificar qual tabela banco de dados os formulario
             String sql = "delete from tb_fornecedores where id=?";
             
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
    public List<Fornecedores> listarFornecedores(){
    try{
    List<Fornecedores> lista = new ArrayList<>();

String sql = "select * from tb_fornecedores";
PreparedStatement stmt = con.prepareStatement(sql);
ResultSet rs = stmt.executeQuery();

   while(rs.next()) {
       Fornecedores obj = new Fornecedores();
       
       obj.setId(rs.getInt("id"));
       obj.setNome(rs.getString("nome"));
       obj.setCnpj(rs.getString("cnpj"));
       obj.setEmail(rs.getString("email"));
       obj.setTelefone(rs.getString("telefone"));
       obj.setCelular(rs.getString("celular"));
       obj.setCep(rs.getString("cep"));
       obj.setEndereco(rs.getString("endereco"));
       obj.setNumero(rs.getInt("numero"));
       obj.setComplemento(rs.getString("complemento"));
       obj.setBairro(rs.getString("bairro"));
       obj.setCidade(rs.getString("cidade"));
       obj.setEstado(rs.getString("estado"));
       
       lista.add(obj);
   }
   return lista;
}
    
    catch(SQLException erro) {
        JOptionPane.showMessageDialog(null,"Erro ao listar os dados!" + erro);
        
        return null;
    }
    }
    
      public List<Fornecedores> buscaFornecedoresPorNome(String nome){
          try {
              List<Fornecedores> lista = new ArrayList<>();
              String sql = "select * from tb_fornecedores where nome like?";
              PreparedStatement stmt = con.prepareStatement(sql);
              stmt.setString(1, nome);
              ResultSet rs = stmt.executeQuery(); 
              
              while (rs.next()){
                  Fornecedores obj = new Fornecedores();
                  
                  obj.setId(rs.getInt("id"));
                  obj.setNome(rs.getString("nome"));
                  obj.setCnpj(rs.getString("cnpj"));
                  obj.setEmail(rs.getString("email"));
                  obj.setTelefone(rs.getString("telefone"));
                  obj.setCelular(rs.getString("celular"));
                  obj.setCep(rs.getString("cep"));
                  obj.setEndereco(rs.getString("endereco"));
                  obj.setNumero(rs.getInt("numero"));                
                  obj.setComplemento(rs.getString("complemento"));
                  obj.setBairro(rs.getString("bairro"));
                  obj.setCidade(rs.getString("cidade"));
                  obj.setEstado(rs.getString("estado"));
       
                  lista.add(obj);
              }
              return lista;
          } 
          catch (SQLException erro) {
             JOptionPane.showMessageDialog(null, "Erro ao listar os dados!" + erro);
             return null;
          }
    }
      public Fornecedores ConsultaPorNome(String nome) {
          try {
              String sql = "select * from tb_fornecedores where nome=?";
              PreparedStatement stmt = con.prepareStatement(sql);
              stmt.setString(1, nome);
              
              ResultSet rs = stmt.executeQuery();
              
              Fornecedores obj = new Fornecedores();
              
              if(rs.next()) {
                  obj.setId(rs.getInt("id"));
                  obj.setNome(rs.getString("nome"));
                  obj.setCnpj(rs.getString("cnpj"));
                  obj.setEmail(rs.getString("email"));
                  obj.setTelefone(rs.getString("telefone"));
                  obj.setCelular(rs.getString("celular"));
                  obj.setCep(rs.getString("cep"));
                  obj.setEndereco(rs.getString("endereco"));
                  obj.setNumero(rs.getInt("numero"));
                  obj.setComplemento(rs.getString("complemento"));
                  obj.setBairro(rs.getString("bairro"));
                  obj.getCidade(rs.getString("cidade"));
                  obj.setEstado(rs.getString("estado"));
              }
              return obj;
          }
          catch (SQLException erro) {
              JOptionPane.showMessageDialog(null, "cliente não encontrado!");
              return null;
          }
      }

    
}
 
    


