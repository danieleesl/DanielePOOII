
package controle;

import conexao.ConectaFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Clientes;
import modelo.Funcionario;


public class ClienteDAO {
    private Connection con;
    
    public ClienteDAO() {
        this.con = new ConectaFactory().getConection();
    }
    
    public void cadastrarCliente(Clientes obj){
        try {
       String sql = "insert into tb_clientes(nome, rg, cpf, email, telefone, celular, cep,"
               + "endereco, numero, complemento, bairro, cidade, estado )"
               + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
       PreparedStatement stmt = con.prepareStatement(sql);
       stmt.setString(1, obj.getNome());
       stmt.setString(2, obj.getRg());
       stmt.setString(3, obj.getCpf());
       stmt.setString(4, obj.getEmail());
       stmt.setString(5, obj.getTelefone());
       stmt.setString(6, obj.getCelular());
       stmt.setString(7, obj.getCep());
       stmt.setString(8, obj.getEndereco());
       //stmt.setInt(9, obj.getNumero);
       stmt.setInt(9, obj.getNumero());
       stmt.setString(10, obj.getComplemento());
       stmt.setString(11, obj.getBairro());
       stmt.setString(12, obj.getCidade());
       stmt.setString(13, obj.getEstado());
       
       stmt.execute();
       stmt.close();
       
       JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        } 
    catch(SQLException erro){
       JOptionPane.showMessageDialog(null, "Erro ao efetuar o cadastro" + erro);
        }
    }   
  
    public void alterarCliente(Clientes obj){
        try {
       String sql = "update tb_clientes set nome=?, rg=?, cpf=?, email=?, telefone=?, celular=?, "
               + "cep=?,endereco=?, numero=?, complemento=?, bairro=?, cidade=?, estado=? where id=?";
              
       PreparedStatement stmt = con.prepareStatement(sql);
       stmt.setString(1, obj.getNome());
       stmt.setString(2, obj.getRg());
       stmt.setString(3, obj.getCpf());
       stmt.setString(4, obj.getEmail());
       stmt.setString(5, obj.getTelefone());
       stmt.setString(6, obj.getCelular());
       stmt.setString(7, obj.getCep());
       stmt.setString(8, obj.getEndereco());
       //stmt.setInt(9, obj.getNumero);
       stmt.setInt(9, obj.getNumero());
       stmt.setString(10, obj.getComplemento());
       stmt.setString(11, obj.getBairro());
       stmt.setString(12, obj.getCidade());
       stmt.setString(13, obj.getEstado());
       stmt.setInt(14, obj.getId());
       
       stmt.execute();
       stmt.close();
       
       JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
        } 
    catch(SQLException erro){
       JOptionPane.showMessageDialog(null, "Erro ao efetuar o cadastro" + erro);
        }
    }
    
    
    public void excluirCliente(Clientes obj){
         try {
             String sql = "delete from tb_clientes where id=?";
             
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
    public List<Clientes> listarCliente(){
    try{
    List<Clientes> lista = new ArrayList<>();

String sql = "select * from tb_clientes";
PreparedStatement stmt = con.prepareStatement(sql);
ResultSet rs = stmt.executeQuery();

   while(rs.next()) {
       Clientes obj = new Clientes();
       
       obj.setId(rs.getInt("id"));
       obj.setNome(rs.getString("nome"));
       obj.setRg(rs.getString("rg"));
       obj.setCpf(rs.getString("cpf"));
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
    
      public List<Clientes> buscaClientePorNome(String nome){
          try {
              List<Clientes> lista = new ArrayList<>();
              String sql = "select * from tb_clientes where nome like?";
              PreparedStatement stmt = con.prepareStatement(sql);
              stmt.setString(1, nome);
              ResultSet rs = stmt.executeQuery(); 
              
              while (rs.next()){
                  Clientes obj = new Clientes();
                  
                  obj.setId(rs.getInt("id"));
                  obj.setNome(rs.getString("nome"));
                  obj.setRg(rs.getString("rg"));
                  obj.setCpf(rs.getString("cpf"));
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
      public Clientes ConsultaPorNome(String nome) {
          try {
              String sql = "select * from tb_clientes where nome=?";
              PreparedStatement stmt = con.prepareStatement(sql);
              stmt.setString(1, nome);
              
              ResultSet rs = stmt.executeQuery();
              
              Clientes obj = new Clientes();
              
              if(rs.next()) {
                  obj.setId(rs.getInt("id"));
                  obj.setNome(rs.getString("nome"));
                  obj.setRg(rs.getString("rg"));
                  obj.setCpf(rs.getString("cpf"));
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

    public void excluirFuncionario(Funcionario obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void alterarFuncionario(Funcionario obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void excluirFuncionarios(Funcionario obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
 
    


