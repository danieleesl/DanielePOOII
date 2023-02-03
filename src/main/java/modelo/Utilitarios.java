
package modelo;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Utilitarios {
    public void LimparTela(JPanel container){
        Component components[] = container.getComponents();
        
        for(Component component : components) {
            if(component instanceof JTextField) {
                ((JTextField)component).setText(null);
            }
        }
    }

    //public void LimparTela(JButton painel_dados) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
   // }

    public void LimparTela(JButton painel_dados) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
