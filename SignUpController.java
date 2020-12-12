/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barberapp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Valter
 */
public class SignUpController implements ActionListener {

    SignUp view;    
    SignedUpasBarber barber;
    SignedUpasCustomer signedUpasCustomer;
    
    public SignUpController(SignUp view) {
      
      this.view = view;  
      
        
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
      
      if (e.getActionCommand().equals("singUp")){
          
           if (view.singUp.getSelectedIndex()== 1){
              
           this.barber = new SignedUpasBarber(this);
             
                
      } 
            if (view.singUp.getSelectedIndex()== 0){
            this.signedUpasCustomer = new SignedUpasCustomer (this);
     }     

    }
        
   }
    
}
