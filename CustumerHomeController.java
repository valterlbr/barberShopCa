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
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;





/**
 *
 * @author Valter
 */
public class CustumerHomeController implements ActionListener,MouseListener {
  
    ViewCustomerHome viewCustomerHome;
    private Object conn;
    
    public CustumerHomeController( ViewCustomerHome  viewCustomerHome) {       
     this.viewCustomerHome = viewCustomerHome;             
    
     
    }
    
    public void newAprovedAppoitments(){
        
     Connection com1 = ModelSignUp.getConnection();
       PreparedStatement stmt1 = null;
       String sql = "select day,time from newappointments";
         try{
       stmt1 = com1.prepareStatement(sql);
       ResultSet rs = stmt1.executeQuery();
       viewCustomerHome.tableNewApointments.setModel(DbUtils.resultSetToTableModel(rs));
      
      }
      catch(Exception e){
      
      }
      
      }
      
    public void updateAprovedAppoitments(){
    
    
        Connection com = ModelSignUp.getConnection();
       PreparedStatement stmt = null;
       String sql = "select day,time from aprovedAppoitments";
         try{
       stmt = com.prepareStatement(sql);
       ResultSet rs = stmt.executeQuery();
       viewCustomerHome.aprovedApp.setModel(DbUtils.resultSetToTableModel(rs));
      
      }
      catch(Exception e){
      
      }
      
      }
    

     public void delete(){
         
    Connection com1 = ModelSignUp.getConnection();
        PreparedStatement stmt1 = null;
        
        String sql = "delete from newappointments where day = ? ";
        try{
        stmt1 = com1.prepareStatement(sql);
        stmt1.setString(1, viewCustomerHome.tf1.getText());
            JOptionPane.showMessageDialog(null,"appointment booked");              
        stmt1.executeUpdate();
         }catch(SQLException ex){
            System.out.println("error saving" +ex.toString());
        }finally {
        
        ModelSignUp.closeConnection(com1, stmt1);
      
     }  
        
      }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
          
      if(e.getActionCommand().equals("delete")){
         
        Connection com = ModelSignUp.getConnection();
        PreparedStatement stmt = null;
        
        String sql = "delete from aprovedAppoitments where day = ? ";
        try{
        stmt = com.prepareStatement(sql);
        stmt.setString(1, viewCustomerHome.tf3.getText());
            JOptionPane.showMessageDialog(null,"are you sure you want dele it");              
        stmt.executeUpdate();
        
            
        }catch(SQLException ex){
            System.out.println("error saving" +ex.toString());
        }finally {
        
        ModelSignUp.closeConnection(com, stmt);   
         
        updateAprovedAppoitments();
        viewCustomerHome.tf3.setText("");
        
        }
      }
         else if (e.getActionCommand().equals("save")){
         
        Connection com1 = ModelSignUp.getConnection();
        PreparedStatement stmt1 = null;
        
        String sql1 = "insert into appointmentsToAprove (day,time) values (?,?) ";
        try{
        stmt1 = com1.prepareStatement(sql1);
        stmt1.setString(1, viewCustomerHome.tf1.getText());
        stmt1.setString(2, viewCustomerHome.tf2.getText());      
        stmt1.executeUpdate();
            System.out.println("kkkkkkkkkkk");
        }catch(SQLException ex){
            System.out.println("error saving" +ex.toString());
        }finally {
        
        ModelSignUp.closeConnection(com1, stmt1);
            delete();
            newAprovedAppoitments();
            System.out.println("saved");
            }  
    
        }   
        
        
        }  
      
     

    @Override
    public void mouseClicked(MouseEvent e) {
        
    
            
        int line = viewCustomerHome. tableNewApointments.getSelectedRow();
       
        TableModel model = viewCustomerHome. tableNewApointments.getModel();
        viewCustomerHome.tf1.setText(model.getValueAt(line,0).toString());
        viewCustomerHome.tf2.setText(model.getValueAt(line,1).toString());
        
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
