/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barberapp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Valter
 */
public class Controller  implements ActionListener {
    ViewSelectBarber viewSelectBarber;
    ModelCustomer modelCustomer;
    ModelBarber modelBarber;
    ViewBarberHome viewBarberHome;
    ViewCustomerHome viewCustomerHome;
    SignUp signup;
    ViewLoginAsBarber viewLoginAsBarber;
    ViewLogin viewLogin;
    LoginsAsBarber loginasbarber;
    ViewLoginAsCustomer viewLoginAsCustomer;
    
    
    public Controller(){
        
        this.viewLogin = new ViewLogin(this);   
       
        this.modelCustomer = new ModelCustomer();
        this.modelBarber = new ModelBarber();
        
    }

    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
      if(e.getActionCommand().equals("close")){ 
      int n = JOptionPane.showConfirmDialog(viewLogin,"are u sure", "confirme", JOptionPane.YES_NO_OPTION);
     System.out.println(n);
      if (n == 0){
          System.exit(0);
      
      }
         }
        
        if (e.getActionCommand().equals("loginAs")){
          
          if (viewLogin.loginAs.getSelectedIndex()== 1){
              
             
          this.viewLoginAsBarber = new ViewLoginAsBarber(this);           
                
               
                
      } 
          if (viewLogin.loginAs.getSelectedIndex()== 0){
                   
               this.viewLoginAsCustomer = new ViewLoginAsCustomer (this);
                   
                    }     

                 }
        
        
       if(e.getActionCommand().equals("loginBarber")){
        String un = viewLoginAsBarber.getValueOne();
        String pw = viewLoginAsBarber.getValueTwo();
        
        User user = new User(un, pw);
                
        boolean result = modelBarber.login(user);
        
        String resultMessage = "Try again with valid credentials";
        
        if(result){
            this.viewBarberHome = new ViewBarberHome(this);
        }
        
        viewLoginAsBarber.setResult(resultMessage);
    }
    
    
       if(e.getActionCommand().equals("signUp")){
            this.signup = new SignUp(this);
           
}     
  
       
       if(e.getActionCommand().equals("loginCustomer")){
        String un = viewLoginAsCustomer.getValueOne();
        String pw = viewLoginAsCustomer.getValueTwo();
        
        User user = new User(un, pw);
                
        boolean result = modelCustomer.login(user);
        
        String resultMessage = "Try again with valid credentials";
        
        if(result){
            this.viewCustomerHome = new ViewCustomerHome(this);
            
        }
        
        viewLoginAsCustomer.setResult(resultMessage);
    }
    
    
       if(e.getActionCommand().equals("signUp")){
            this.signup = new SignUp(this);
           
}       
 
}
}
    

