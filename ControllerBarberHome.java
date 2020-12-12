/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barberapp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Valter
 */
public class ControllerBarberHome implements ActionListener,MouseListener {
    
    
   ViewBarberHome viewBarberHome;
   ViewCustomerHome viewCustomerHome;
    
    public ControllerBarberHome( ViewBarberHome  viewBarberHome) {  
        
     this.viewBarberHome = viewBarberHome;             
     
      
     
    }
    
  public void updateAprovedAppoitments(){
    
    
       Connection com3 = ModelSignUp.getConnection();
       PreparedStatement stmt3 = null;
       String sql3 = "select day,time from  appointmentsToAprove";
         try{
       stmt3 = com3.prepareStatement(sql3);
       ResultSet rs = stmt3.executeQuery();
       viewBarberHome.tableAppToAprove.setModel(DbUtils.resultSetToTableModel(rs));
      
      }
      catch(Exception e){
      
      }
      
      }
    

     public void delete(){
         
    Connection com3 = ModelSignUp.getConnection();
        PreparedStatement stmt3 = null;
        
        String sql3 = "delete from appointmentsToAprove where day = ? ";
        try{
        stmt3 = com3.prepareStatement(sql3);
        stmt3.setString(1, viewBarberHome.tf3.getText());
                         
        stmt3.executeUpdate();
         }catch(SQLException ex){
            System.out.println("error saving" +ex.toString());
        }finally {
        
        ModelSignUp.closeConnection(com3, stmt3);
         
         
         System.out.println("delete");
     }  
        
      }
    
     
        @Override
        public void actionPerformed(ActionEvent e) {
        
        
         if(e.getActionCommand().equals("aprove")){
        Connection com = ModelSignUp.getConnection();
        PreparedStatement stmt = null;
        
        String sql = "insert into aprovedAppoitments (day,time) values (?,?) ";
        try{
        stmt = com.prepareStatement(sql);
        stmt.setString(1, viewBarberHome.tf3.getText());
        stmt.setString(2, viewBarberHome.tf4.getText());      
        stmt.executeUpdate();
        
        
        }catch(SQLException ex){
            System.out.println("error saving" +ex.toString());
        }finally {
        
        ModelSignUp.closeConnection(com, stmt);
        JOptionPane.showMessageDialog(null, "Appoitement Aproved");
        delete(); 
        updateAprovedAppoitments();
        viewBarberHome.tf3.setText("");
        viewBarberHome.tf4.setText("");
        
        
            }  
    
    }
    if(e.getActionCommand().equals("save")){
        
        Connection com = ModelSignUp.getConnection();
        PreparedStatement stmt = null;
        
        String sql = "insert into newappointments (day,time) values (?,?) ";
        try{
        stmt = com.prepareStatement(sql);
        stmt.setString(1, viewBarberHome.tf1.getText());
        stmt.setString(2, viewBarberHome.tf2.getText());      
        stmt.executeUpdate();
        
        }catch(SQLException ex){
            System.out.println("error saving" +ex.toString());
        }finally {
        
        ModelSignUp.closeConnection(com, stmt);
        JOptionPane.showMessageDialog(null, "new appoitment created");
         viewBarberHome.tf1.setText("");
         viewBarberHome.tf2.setText("");
            }  
    
    }
    
    }

    @Override
    public void mouseClicked(MouseEvent e) {        
      
         int line = viewBarberHome.tableAppToAprove.getSelectedRow();
       // JOptionPane.showMessageDialog(null, line);
        TableModel model = viewBarberHome.tableAppToAprove.getModel();
        viewBarberHome.tf3.setText(model.getValueAt(line,0).toString());
        viewBarberHome.tf4.setText(model.getValueAt(line,1).toString());
        
    
    }
    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
           }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
       
    }
}
