/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barberapp;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Valter
 */
public class SignUp extends JFrame {
    
    
    
    private JPanel panel;
    Controller controller;
    JComboBox singUp = null;
    SignUpController signUpController;
    
    public SignUp(Controller controller) {
           // We encapsulated the building process of the window
        this.signUpController = new SignUpController(this);
        attributesSetter();
        components();        
        validation();
        
    }
    
    // Setting attributes
    private void attributesSetter(){        
        this.setVisible(true);
        this.setSize(400,400);
        this.setTitle("Sign Up");  
        
        
    }
    //others components
    public void components(){
        
        panel = new JPanel();
        this.add(panel);
        
        String[] singStrings = { "Sign Up as Customer", "Sign Up as Barber" }; 
     //Create the combo box, select item at index 4. 
      //Indices start at 0, so 4 specifies the pig. 
      singUp = new JComboBox(singStrings); 
      singUp.setSelectedIndex(1); 
      panel.add(singUp);
      singUp.addActionListener(signUpController);
      singUp.setActionCommand("singUp");
       System.out.println(singUp.getSelectedItem());
       

}
      // Validation and repainting
    private void validation(){
        this.validate();
        this.repaint();
    }

      
  
}