/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barberapp;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Valter
 */
public class LoginsAsBarber extends JFrame{
    
   // LoginController logincontroller;
    public JPanel panel;
    
    public LoginsAsBarber() {
        
     new Controller();
     attributesSetter(); 
     loginasbarber();
      validation();   
        
    }
       private void attributesSetter(){        
        this.setVisible(true);
        this.setSize(300,300);
        this.setTitle("Sign Up");  
        
        
    }
         public void loginasbarber(){
        panel = new JPanel();
        this.add(panel);
        
        
         JTextField tf1 = new JTextField(20);
         JTextField tf2 = new JTextField(20);
         JTextField tf3 = new JTextField(20);
         JTextField tf4 = new JTextField(20);
         JTextField tf5 = new JTextField(20);
         tf1.setVisible(true);
         tf2.setVisible(true);
         tf3.setVisible(true);
         tf4.setVisible(true);
         tf5.setVisible(true);
         panel.add(tf1);
         panel.add(tf2);
         panel.add(tf3);
         panel.add(tf4);
         panel.add(tf5); 
         
       
        
    }
  // Validation and repainting
    private void validation(){
        this.validate();
        this.repaint();
    }
    
}
