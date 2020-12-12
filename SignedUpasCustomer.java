/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barberapp;

import com.placeholder.PlaceHolder;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Valter
 */
public class SignedUpasCustomer  extends JFrame{
    
    public JTextField tf1;
    public JTextField tf2;
    public JTextField tf3;
    public JTextField tf4;    
    ControllerSignUpAsCustumer controllerSignUpAsCustumer;
    public JPanel panel;
    
    public SignedUpasCustomer(SignUpController signUpController) {
        
     this.controllerSignUpAsCustumer = new ControllerSignUpAsCustumer(this);
 
     attributesSetter(); 
     loginasCustomer();
      validation();   
      PlaceHolder holder = new PlaceHolder(tf1, "Please! enter your Username");       
      PlaceHolder holder1 = new PlaceHolder(tf2, "Please! enter your Password");      
      PlaceHolder holder2 = new PlaceHolder(tf3, "Please! enter your Full Name");      
      PlaceHolder holder3 = new PlaceHolder(tf4, "Please! enter your Phone Number");      
      
 
        
    }
       private void attributesSetter(){        
        this.setVisible(true);
        this.setSize(270,270);
        this.setTitle("Sign Up");  
        
        
    }
         public void loginasCustomer(){
        JPanel p = new JPanel();
        this.add(p);
        
        tf1 = new JTextField(20);
        tf2 = new JTextField(20);
        tf3 = new JTextField(20);
        tf4 = new JTextField(20);
        
        JButton login = new JButton("Save");
        login.addActionListener(controllerSignUpAsCustumer);
        login.setActionCommand("save");
        
       
        p.add(tf1);
        p.add(tf2);
	p.add(tf3);
        p.add(tf4);
        p.add(login);
        
         
       
        
    }
  // Validation and repainting
    private void validation(){
        this.validate();
        this.repaint();
    }
    
    
}
