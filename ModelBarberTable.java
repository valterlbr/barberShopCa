/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barberapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Valter
 */
public class ModelBarberTable {
    
      public ArrayList<Users> getUsers(){
          
        ArrayList<Users> users = new ArrayList<Users>();
        
        try {

            String dbServer =  "jdbc:mysql://apontejaj.com:3306/Valter_2019308?useSSL=false";
            String user = "Valter_2019308";
            String password = "2019308";
            String query = "SELECT * FROM appointmentsToAprove";

            // Get a connection to the database
            Connection conn = DriverManager.getConnection(dbServer, user, password);

            // Get a statement from the connection
            Statement stmt = conn.createStatement();

            // Execute the query
            ResultSet rs = stmt.executeQuery(query);
            
            Users u;

            // Loop through the result set
            while (rs.next()) {
                
               // System.out.println(rs.getString("id") + "\t" + rs.getString("username") + "\t" + rs.getString("password"));
              
                 
                        u = new Users(
                        rs.getString("day"),
                        rs.getString("time")
                        
                        );
                        
                        users.add(u);
            }
             
            // Close the result set, statement and the connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            System.out.println("SQL Exception:");

            // Loop through the SQL Exceptions
            while (se != null) {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());

                se = se.getNextException();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return users;
 }
    
}
