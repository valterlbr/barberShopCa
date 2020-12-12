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

/**
 *
 * @author Valter
 */
public class ControllerSignUpAsBarber implements ActionListener{
    
    SignUp view;
    SignedUpasBarber signedUpasBaber;
    
    public ControllerSignUpAsBarber(SignedUpasBarber signedUpasBarber) {
      
      this.signedUpasBaber = signedUpasBarber; 
      
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
    
      if (e.getActionCommand().equals("save")){
      
      Connection com = ModelSignUpAsBarber.getConnection();
        PreparedStatement stmt = null;
        
        String sql = "insert into barber(username,password,fullnane,phonenumber,location) values (?,?,?,?,?) ";
        try{
        stmt = com.prepareStatement(sql);
        stmt.setString(1, signedUpasBaber.tf1.getText());
        stmt.setString(2, signedUpasBaber.tf2.getText());        
        stmt.setString(3, signedUpasBaber.tf3.getText());
        stmt.setString(4, signedUpasBaber.tf4.getText());
        stmt.setString(5, signedUpasBaber.tf5.getText());
        stmt.executeUpdate();
        
        }catch(SQLException ex){
            System.out.println("error saving" +ex.toString());
        }finally {
        
        ModelSignUpAsBarber.closeConnection(com, stmt);
        JOptionPane.showMessageDialog(null, "signe up success");
    } 
      
    }
    }
}
      
    
    

