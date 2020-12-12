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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Valter
 */
public class ControllerSignUpAsCustumer implements ActionListener {
    
    
    SignedUpasCustomer signedUpasCustomer;
    
    
    public ControllerSignUpAsCustumer(SignedUpasCustomer signedUpasCustomer) {
      
      this.signedUpasCustomer = signedUpasCustomer;
      
        
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
    
     if (e.getActionCommand().equals("save")){
      
      Connection com = ModelSignUp.getConnection();
        PreparedStatement stmt = null;
        
        String sql = "insert into customer(username,password,fullnane,phonenumber) values (?,?,?,?) ";
        try{
        stmt = com.prepareStatement(sql);
        stmt.setString(1, signedUpasCustomer.tf1.getText());
        stmt.setString(2, signedUpasCustomer.tf2.getText());        
        stmt.setString(3, signedUpasCustomer.tf3.getText());
        stmt.setString(4, signedUpasCustomer.tf4.getText());
        stmt.executeUpdate();
        
        }catch(SQLException ex){
            System.out.println("error saving" +ex.toString());
        }finally {
        
            
        ModelSignUp.closeConnection(com, stmt);
        JOptionPane.showMessageDialog(null, "signe up success");
      
     }
     }
     }
}