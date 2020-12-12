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
public class SignedUpasBarber extends JFrame {
    public JTextField tf1;
    public JTextField tf2;
    public JTextField tf3;
    public JTextField tf4;
    public JTextField tf5;
    ControllerSignUpAsBarber controllerSignUpAsBarber;
    public JPanel panel;
    
    public SignedUpasBarber(SignUpController signUpController) {
        
      controllerSignUpAsBarber= new ControllerSignUpAsBarber(this); 
    
    
     attributesSetter(); 
     loginasbarber();
      validation();   
      
      PlaceHolder holder = new PlaceHolder(tf1, "Please! enter your Username");       
      PlaceHolder holder1 = new PlaceHolder(tf2, "Please! enter your Password");      
      PlaceHolder holder2 = new PlaceHolder(tf3, "Please! enter your Full Name");      
      PlaceHolder holder3 = new PlaceHolder(tf4, "Please! enter your Phone Number");      
      PlaceHolder holder4 = new PlaceHolder(tf5, "Please! enter your Location");
 
        
    }
       private void attributesSetter(){        
        this.setVisible(true);
        this.setSize(270,270);
        this.setTitle("Sign Up");  
        
        
    }
         public void loginasbarber(){   
             
        
 
        JPanel p = new JPanel();
        this.add(p);
        
        tf1 = new JTextField(20);
        tf2 = new JTextField(20);
        tf3 = new JTextField(20);
        tf4 = new JTextField(20);
        tf5 = new JTextField(20);
        
        JButton sisnUp = new JButton("Save");
        sisnUp.addActionListener(controllerSignUpAsBarber);
        sisnUp.setActionCommand("save");
        
       
        p.add(tf1);
        p.add(tf2);
	p.add(tf3);
        p.add(tf4);
        p.add(tf5);
        p.add(sisnUp);
                
       
    }
  // Validation and repainting
    private void validation(){
        this.validate();
        this.repaint();
    }
    
}
