/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barberapp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Valter
 */
public class ViewLogin extends JFrame {
    JPanel miniMainLeft;     
    private JPanel panel;    
    JComboBox loginAs = null;
    Controller controller;
    
    public ViewLogin(Controller controller) {
           // We encapsulated the building process of the window
       this.controller = controller;
        attributesSetter();
        components();        
        validation();
        
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
        
        JLabel l2 = new JLabel("Choose your Account tipe");
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
        
        String[] loginAsStrings = { "Login as Customer", "Login as Barber" }; 
     //Create the combo box, select item at index 4. 
      //Indices start at 0, so 4 specifies the pig. 
       loginAs = new JComboBox(loginAsStrings); 
       loginAs.setSelectedIndex(1); 
       miniMainLeft.add(loginAs);
       loginAs.addActionListener(controller);
       loginAs.setActionCommand("loginAs");
       System.out.println(loginAs.getSelectedItem());       

      
        JButton signUp = new JButton("Sign Up");
        signUp.addActionListener(controller);
        signUp.setActionCommand("signUp");   
        upper.add(signUp);
        

}
      // Validation and repainting
    private void validation(){
        this.validate();
        this.repaint();
    }

      
    
    
    
}
