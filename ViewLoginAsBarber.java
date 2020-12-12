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
public class ViewLoginAsBarber extends JFrame{
    
    
    
   // Text fields must be class members so all methods can access them
    private JTextField tf1;
    private JTextField tf2;
    private JTextField tf3;
   
    Controller controller;
    
    public ViewLoginAsBarber (Controller controller){
        
    
        this.controller = controller;
        
        // We encapsulated the building process of the window
        attributesSetter();
        components();
        validation();
      PlaceHolder holder = new PlaceHolder(tf1, "Please! enter your Username");       
      PlaceHolder holder1 = new PlaceHolder(tf2, "Please! enter your Password");   
 
    }
    
    // Setting attributes
    
    private void attributesSetter(){
        this.setVisible(true);
        this.setSize(300,300);
        this.setTitle("Logged in as Berber");
    }
    
    // Organising components
    private void components(){
        JPanel p = new JPanel();
        this.add(p);
        
        tf1 = new JTextField(20);
        tf2 = new JTextField(20);
        tf3 = new JTextField(20);
        JButton login = new JButton("Login");
        login.addActionListener(controller);
        login.setActionCommand("loginBarber");
        
        JButton signup = new JButton("Sign Up");
        signup.addActionListener(controller);
        signup.setActionCommand("signUp");
       
        p.add(tf1);
        p.add(tf2);
	p.add(tf3);
        p.add(login);
        p.add(signup);
        
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
