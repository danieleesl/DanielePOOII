
package conexao;

import javax.swing.JOptionPane;

public class TestaConexao {
    
    public static void main(String[] args) { 
        try {
            new ConectaFactory().getConection();
            JOptionPane.showMessageDialog(null, "Conectada com sucesso");
            
        }catch (Exception erro) {
           JOptionPane.showMessageDialog(null, "Erro na conexão!" + erro);
        }
    }
    
}
