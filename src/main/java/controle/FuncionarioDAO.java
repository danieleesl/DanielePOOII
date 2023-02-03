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
import modelo.Funcionario;
import visao.frmLogin;
import visao.frmMenu;


public class FuncionarioDAO {
      private Connection con;
    
    public FuncionarioDAO() {
        this.con = new ConectaFactory().getConection();
    }
    
    public void cadastrarFuncionario(Funcionario obj){
        try {
       String sql = "insert into tb_funcionarios(nome, rg, cpf, email, senha, cargo, nivel_acesso, "
               + " telefone, celular, cep, endereco, numero, complemento, bairro, cidade, estado) "
               + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
       PreparedStatement stmt = con.prepareStatement(sql);
       stmt.setString(1, obj.getNome());
       stmt.setString(2, obj.getRg());
       stmt.setString(3, obj.getCpf());
       stmt.setString(4, obj.getEmail());
       stmt.setString(5, obj.getSenha());
       stmt.setString(6, obj.getCargo());
       stmt.setString(7, obj.getNivel_acesso());
       stmt.setString(8, obj.getTelefone());
       stmt.setString(9, obj.getCelular());
       stmt.setString(10, obj.getCep());
       stmt.setString(11, obj.getEndereco());
       stmt.setInt(12, obj.getNumero());
       stmt.setString(13, obj.getComplemento());
       stmt.setString(14, obj.getBairro());
       stmt.setString(15, obj.getCidade());
       stmt.setString(16, obj.getEstado());
       
        
       stmt.execute();
       stmt.close();
       
       JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        } 
    catch(SQLException erro){
       JOptionPane.showMessageDialog(null, "Erro ao efetuar o cadastro" + erro);
        }
    }   
  
    public void alterarFuncionario(Funcionario obj){
        try {
       String sql = "update tb_funcionarios set nome=?, rg=?, cpf=?, email=?, senha=?, cargo=?, nivel_acesso=?, telefone=?, celular=?, "
               + "cep=?,endereco=?, numero=?, complemento=?, bairro=?, cidade=?, estado=? "
               + "where id=?";
              
       PreparedStatement stmt = con.prepareStatement(sql);
       stmt.setString(1, obj.getNome());
       stmt.setString(2, obj.getRg());
       stmt.setString(3, obj.getCpf());
       stmt.setString(4, obj.getEmail());
       stmt.setString(5, obj.getSenha());
       stmt.setString(6, obj.getCargo());
       stmt.setString(7, obj.getNivel_acesso());
       stmt.setString(8, obj.getTelefone());
       stmt.setString(9, obj.getCelular());
       stmt.setString(10, obj.getCep());
       stmt.setString(11, obj.getEndereco());
       stmt.setInt(12, obj.getNumero());
       stmt.setString(13, obj.getComplemento());
       stmt.setString(14, obj.getBairro());
       stmt.setString(15, obj.getCidade());
       stmt.setString(16, obj.getEstado());
       stmt.setInt(17, obj.getId());
       
       
       stmt.execute();
       stmt.close();
       
       JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
        } 
    catch(SQLException erro){
       JOptionPane.showMessageDialog(null, "Erro ao efetuar o cadastro" + erro);
        }
    }
    
    public void excluirFuncionario(Funcionario obj){
         try {
             String sql = "delete from tb_funcionarios where id=?";
             
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

    /**
     *
     * @return
     */
    public List<Funcionario> listarFuncionario(){
    try{
    List<Funcionario> lista = new ArrayList<>();

String sql = "select * from tb_funcionarios";
PreparedStatement stmt = con.prepareStatement(sql);
ResultSet rs = stmt.executeQuery();

   while(rs.next()) {
       Funcionario obj = new Funcionario();
       
       obj.setId(rs.getInt("id"));
       obj.setNome(rs.getString("nome"));
       obj.setRg(rs.getString("rg"));
       obj.setCpf(rs.getString("cpf"));
       obj.setEmail(rs.getString("email"));
       obj.setSenha(rs.getString("senha"));
       obj.setCargo(rs.getString("cargo"));
       obj.setNivel_acesso(rs.getString("nivel_acesso"));
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
    
      public List<Funcionario> buscaFuncionarioPorNome(String nome){
          try {
              List<Funcionario> lista = new ArrayList<>();
              String sql = "select * from tb_funcionarios where nome like?";
              PreparedStatement stmt = con.prepareStatement(sql);
              stmt.setString(1, nome);
              ResultSet rs = stmt.executeQuery(); 
              
              
              while (rs.next()){
                  Funcionario obj = new Funcionario();
                  
                  obj.setId(rs.getInt("id"));
                  obj.setNome(rs.getString("nome"));
                  obj.setRg(rs.getString("rg"));
                  obj.setCpf(rs.getString("cpf"));
                  obj.setEmail(rs.getString("email"));
                  obj.setSenha(rs.getString("senha"));
                  obj.setCargo(rs.getString("cargo"));
                  obj.setNivel_acesso(rs.getString("nivel_acesso"));
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

   
    public Funcionario ConsultaPorNome(String nome) {
          try {
              String sql = "select * from tb_funcionarios where nome=?";
              PreparedStatement stmt = con.prepareStatement(sql);
              stmt.setString(1, nome);
              
              ResultSet rs = stmt.executeQuery();
              
              Funcionario obj = new Funcionario();
              
              if(rs.next()) {
                  obj.setId(rs.getInt("id"));
                  obj.setNome(rs.getString("nome"));
                  obj.setRg(rs.getString("rg"));
                  obj.setCpf(rs.getString("cpf"));
                  obj.setEmail(rs.getString("email"));
                  obj.setSenha(rs.getString("senha"));
                  obj.setCargo(rs.getString("cargo"));
                  obj.setNivel_acesso(rs.getString("nivel_acesso"));
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

    public void alterarFuncionarios(Funcionario obj) {
       throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
  public void efetuarLogin(String email, String senha){
    try {
        String sql = "Select * from tb_funcionarios where email=? and senha=?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1,email);
        stmt.setString(2,senha);
        
        ResultSet rs = stmt.executeQuery();
        
        if(rs.next()) {
            JOptionPane.showMessageDialog(null, "Seja bem vindo ao sistema!");
            frmMenu tela = new frmMenu();
            tela.usuarioLogado = rs.getString("nome");
            tela.setVisible(true);
        }
        else {
            JOptionPane.showMessageDialog(null, "Dados incorretos!");
            new frmLogin().setVisible(true);
        }  
        }
    catch (SQLException erro) {
        JOptionPane.showMessageDialog(null, "Erro" + erro);
    }  
}

    public List<Fornecedores> listarFornecedores() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
