/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.sql.*;
import java.util.*;

/**
 *
 * @author bgctub
 */
public class DBConnection {
    String dbName,  user,  passwd, url;
    public DBConnection(String dbName, String user, String passwd){
        this.dbName = dbName;
        this.user = user;
        this.passwd = passwd;
        this.url = "jdbc:mysql://localhost:3306/"+this.dbName;
    }
    
    private Connection connect() throws ClassNotFoundException, SQLException{
         Class.forName("com.mysql.jdbc.Driver");
         Connection con = DriverManager.getConnection(this.url,this.user,this.passwd);
         return con;
    }
    
  
    public ArrayList<Customer> readStudent() {
        ArrayList<Customer> cust = new ArrayList<>(); 
        try {
             Connection con = connect();
             PreparedStatement pstmt = con.prepareStatement("SELECT * FROM STUDENT");
             ResultSet rst = pstmt.executeQuery();
             while(rst.next()){
                 String firstName = rst.getString("FIRSTNAME");
                 String lastName = rst.getString("LASTNAME");
                 Customer c = new Customer(firstName,lastName);
                 cust.add(c);
             }
        } catch (ClassNotFoundException ex) {
            
        }
        catch (SQLException ex) {
            
        }
        return cust;
    }
    
    //INSERT INTO STUDENT(FIRSTNAME,LASTNAME) VALUES("Subhasish","Ghosh");
    public void writeStudent(String f, String l) {
        try {
             Connection con = connect();
             PreparedStatement pstmt = con.prepareStatement("INSERT INTO STUDENT(FIRSTNAME,LASTNAME) VALUES(?,?)");
             pstmt.setString(1, f);
             pstmt.setString(2, l);             
             pstmt.executeUpdate();
             
        } catch (ClassNotFoundException ex) {
            
        }
        catch (SQLException ex) {
            
        }
    }
    
    
}
