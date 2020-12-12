/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barberapp;

import com.mysql.cj.jdbc.exceptions.MySQLQueryInterruptedException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Valter
 */
public class ViewSelectBarber extends JFrame{
    
    JPanel miniMainLeft;     
       private JPanel panel;    
       JComboBox choseBarber;
       Controller controller;
       ModelTableBraber  ModelTableBraber ;
       public ViewSelectBarber (Controller controller) {
       // We encapsulated the building process of the window
       this.controller = controller;
       attributesSetter();
       components();        
       validation();
       fillCombBox();
        
    }
    
    // Setting attributes
    private void attributesSetter(){        
        this.setVisible(true);
        this.setSize(400,400);
        this.setTitle("Sign Up");  
        
        
    }
    //others components
    public void components(){
         BorderLayout frameLayout = new BorderLayout();
        this.setLayout(frameLayout);
        
        
        // TOP SECTION SETUP
        JPanel topPanel = new JPanel();
        // DEVIDING TOP SECTION INTO TWO (ONE ROW - TWO COLUMNS)
        GridLayout topLayout = new GridLayout(1,2);
        topPanel.setLayout(topLayout);
        
        // ADDING THE PANEL TO THE FRAME
        this.add(topPanel, BorderLayout.PAGE_START);
        
        // ORGANISING LEFT HAND SIDE
        JPanel left = new JPanel();
        FlowLayout leftLayout = new FlowLayout();
        left.setLayout(leftLayout);
        leftLayout.setAlignment(FlowLayout.LEFT);
        
        JLabel l1 = new JLabel("Hair Life Barber");
        left.add(l1);
        
        // ADDING IT TO THE TOP SECTION
        topPanel.add(left);
        
        
  
        // ORGANISING THE RIGHT HAND SIDE
        JPanel right = new JPanel();
       
        FlowLayout rightLayout = new FlowLayout();
        right.setLayout(rightLayout);
        rightLayout.setAlignment(FlowLayout.RIGHT);
        
        
        
        
        
        JButton b4 = new JButton("Close");
        b4.addActionListener(controller);
        b4.setActionCommand("close");   
        right.add(b4);
        
        // ADDING IT TO THE TOP SECTION
        topPanel.add(right);
        
        // MAIN AREA SETUP
        JPanel mainArea = new JPanel();
        BorderLayout mainAreaLayout = new BorderLayout();
        mainArea.setLayout(mainAreaLayout);
        
        // ADDING THIS TO THE FRAME
        this.add(mainArea, BorderLayout.CENTER);
        
        // INNER TOP SECTION SETUP
        JPanel miniTopPanel = new JPanel();
        // HERE WE DON'T NEED TWO SECTIONS, SO JUST THE FLOW
        // LAYOUT WILL DO
        FlowLayout miniTopLayout = new FlowLayout();
        miniTopPanel.setLayout(miniTopLayout);
        miniTopLayout.setAlignment(FlowLayout.LEFT);
        
        mainArea.add(miniTopPanel, BorderLayout.PAGE_START);
        
        // INNER MAIN SECION SETUP
        JPanel miniMainArea = new JPanel();
        
        // DEVIDING TOP SECTION INTO TWO (ONE ROW - TWO COLUMNS)
        GridLayout miniMainLayout = new GridLayout(1,2);
        miniMainArea.setLayout(miniMainLayout);
        
        // ORGANISING LEFT HAND SIDE
        miniMainLeft = new JPanel();
        
        // JUST A BIT OF A TREAT TO SEE THE BORDER OF THE PANEL
        miniMainLeft.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        miniMainArea.add(miniMainLeft);
        
        // WE CAN ADD A FLOW LAYOUT MANAGER HERE TO PUT IT IN THE MIDDLE
        
        JLabel l2 = new JLabel("Choose your Account tipe model");
        miniMainLeft.add(l2);
        
        

        // ORGANISING RIGHT HAND SIDE
        JPanel miniMainRight = new JPanel();
        miniMainArea.add(miniMainRight);
        
        // DEVIDING MINI RIGHT SECCTION INTO TWO (TWO ROWS - ONE COLUMN)
        GridLayout miniMainRightLayout = new GridLayout(1,1);
        miniMainRight.setLayout(miniMainRightLayout);
        //miniMainRight.add(tf1);
        // miniMainRight.add(tf2);
        // ORGANISING THE UPPER PART
        JPanel upper = new JPanel();
        miniMainRight.add(upper);
        
        upper.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JLabel l3 = new JLabel("dont have account sign up now");
        upper.add(l3);
        
        
        mainArea.add(miniMainArea, BorderLayout.CENTER);
        
       choseBarber = new JComboBox();         
       miniMainLeft.add(choseBarber);
       choseBarber.addActionListener(controller);
       choseBarber.setActionCommand("selectBaber");
          
        
      /* JTable table1 = new JTable();
       ArrayList<Barbers> list =  ModelTableBraber.getBarber((String)choseBarber.getSelectedItem());
       DefaultTableModel model = new DefaultTableModel();
       model.setColumnIdentifiers(new Object []{"Username","Password","Full Name","Phone Number","Location"});
      Object [] row = new Object [5];
       for (int i = 0; i< list.size();i++){           
           
         row[0] = list.get(i).getUserName();
         row[1] = list.get(i).getPassword();
         row[2] = list.get(i).getFullnane();
         row[3] = list.get(i).getPhonenumber();
         row[4] = list.get(i).getLocation();
         model.addRow(row);        
       
       }
      
       JTable barberDetail = new JTable();
        barberDetail.setModel(model);*/
       
        JButton signUp = new JButton("Sign Up");
        signUp.addActionListener(controller);
        signUp.setActionCommand("signUp");
        //upper.add(barberDetail);
        upper.add(signUp);
        

}
      // Validation and repainting
    private void validation(){
        this.validate();
        this.repaint();
    }
   private void fillCombBox(){
       try{
       Connection com1 = ModelSignUp.getConnection();
        Statement st;
        st = com1.createStatement();
        
       String sql = "SELECT * FROM barber";        
     
       ResultSet rs = st.executeQuery(sql);
      while (rs.next()){
          
      choseBarber.addItem(rs.getString("fullnane"));
      }
      
      }
      catch(Exception e){
      
      }
      
      }
   
   
   }
      
    
    

