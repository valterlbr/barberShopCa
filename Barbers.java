/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barberapp;

/**
 *
 * @author Valter
 */
public class Barbers {
    
    private String username;
   private String password;
   private String fullnane;
   private int phonenumber;
   private String location;

    public Barbers(String name, String password, String fullnane, int phonenumber, String location) {
        this.username = username;
        this.password = password;
        this.fullnane = fullnane;
        this.phonenumber = phonenumber;
        this.location = location;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String name) {
        this.username = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullnane() {
        return fullnane;
    }

    public void setFullnane(String fullnane) {
        this.fullnane = fullnane;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
        
        
      
    
}
