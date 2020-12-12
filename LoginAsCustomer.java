/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barberapp;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Valter
 */
public class LoginAsCustomer extends JFrame {
     
     public JPanel panel;
     private JTextField tf1;
     private JTextField tf2;
     private JTextField tf3;
    
    public  LoginAsCustomer() {
        
     
       
 
      // We encapsulated the building process of the window
        attributesSetter();
        components();
        validation();
    }
    
    // Setting attributes
    
    private void attributesSetter(){
        this.setVisible(true);
        this.setSize(400,400);
        this.setTitle("Home Page");
    }
    
    // Organising components
    private void components(){
        
        
        
    }
    
    // Validation and repainting
    private void validation(){
        this.validate();
        this.repaint();
    }
    
    // Getters for username and password
    public String getValueOne(){
        return tf1.getText();
    }
    public String getValueTwo(){
        return tf2.getText();
    }
    public void setResult(String result){
        tf3.setText(result);
    }   

}
