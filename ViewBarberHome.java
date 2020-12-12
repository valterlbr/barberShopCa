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
public class ViewBarberHome extends JFrame {
    JTextField tf1;    
    JTextField tf2;
    JTextField tf3;    
    JTextField tf4;
    JTable tableAppToAprove;
    int position =50;
    JPanel miniMainLeft;
    Controller controller;
    ControllerBarberHome controllerBarberHome;
     ModelBarberTable  modelBarberTable;

    public ViewBarberHome(Controller controller) {
           // We encapsulated the building process of the window
       this.controller =  controller;

       this.controllerBarberHome = new ControllerBarberHome(this);
       this.modelBarberTable = new  ModelBarberTable();
        attributesSetter();
        components();
        validation();
        
    }
    
    // Setting attributes
    private void attributesSetter(){        
        this.setVisible(true);
        this.setSize(500,500);
        this.setTitle("Barber Home Page");     
      
    }
    
    private void components(){
     
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
        
        
   //jTable    
    
   
    tf1 = new JTextField(10);
    tf2 = new JTextField(10); 
    tf3 = new JTextField(10);
    tf4 = new JTextField(10);   
    
    
       tableAppToAprove = new JTable();
         
       tableAppToAprove.setPreferredScrollableViewportSize(new Dimension(100,150));
        
        DefaultTableModel model = new DefaultTableModel();
        
        Object[] columnsName = new Object[2];
        
        columnsName[0] = "day";
        columnsName[1] = "time";
        
        
        model.setColumnIdentifiers(columnsName);
        
        Object[] rowData = new Object[2];
        
        for(int i = 0; i < modelBarberTable.getUsers().size(); i++){
            
            rowData[0] = modelBarberTable.getUsers().get(i).getDay();
             rowData[1] = modelBarberTable.getUsers().get(i).getTime();
              
               model.addRow(rowData);
        }
        
        tableAppToAprove.setModel(model);
        
          
        JScrollPane ToAprove = new JScrollPane( tableAppToAprove);                  
         
       tableAppToAprove.addMouseListener(controllerBarberHome);
    
    
        // ORGANISING THE RIGHT HAND SIDE
        JPanel right = new JPanel();
       
        FlowLayout rightLayout = new FlowLayout();
        right.setLayout(rightLayout);
        rightLayout.setAlignment(FlowLayout.RIGHT);
        
       
        
        JButton b3 = new JButton("Close");       
        b3.addActionListener(controller);
        b3.setActionCommand("close");
        right.add(b3);
        
        right.add(b3);
        
        
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
        
        JLabel l2 = new JLabel("appointments to aprove");
        miniMainLeft.add(l2);
        miniMainLeft.add(ToAprove);
        

        // ORGANISING RIGHT HAND SIDE
        JPanel miniMainRight = new JPanel();
        miniMainArea.add(miniMainRight);
        
        // DEVIDING MINI RIGHT SECCTION INTO TWO (TWO ROWS - ONE COLUMN)
        GridLayout miniMainRightLayout = new GridLayout(2,1);
        miniMainRight.setLayout(miniMainRightLayout);
        //miniMainRight.add(tf1);
        // miniMainRight.add(tf2);
        // ORGANISING THE UPPER PART
        JLabel l3 = new JLabel("Tipy here date of appointments Avalible ");
        JPanel upper = new JPanel();
        miniMainRight.add(upper);
        JButton bSave = new JButton("Save");        
        bSave.addActionListener(controllerBarberHome);
        bSave.setActionCommand("save");
        upper.add(l3);
        upper.add(tf1);
        upper.add(tf2);
        upper.add(bSave);
        
        
        upper.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        
        // ORGANISING THE LOWER PART
        JPanel lower = new JPanel();
        miniMainRight.add(lower);
        lower.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JLabel l4 = new JLabel("Aprove appointment here");
        JButton aprove = new JButton("Aprove");        
        aprove.addActionListener(controllerBarberHome);
        aprove.setActionCommand("aprove");
        lower.add(l4);
        lower.add(tf3);
        lower.add(tf4);
        lower.add(aprove);
        
        mainArea.add(miniMainArea, BorderLayout.CENTER);
        
        
     
     }
    
     // Validation and repainting
    private void validation(){
        this.validate();
        this.repaint();
    }
}
   
    

