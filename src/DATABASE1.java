
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NYONGESA
 */
public class DATABASE1 {
     String host="jdbc:mysql://localhost:3306/hoteldb";
    String user="root";
    String pass="";
    
    Connection conn;
    
       public Connection getConnection(){
        try{
            
            conn=DriverManager.getConnection(host,user,pass);
            JOptionPane.showMessageDialog(null,"Connection Success!");
            return conn;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ""+ ex.getMessage());
            return null;
        }
    }
       public void insertclients(String id,String fname,String lname,String phone,String email){
           String q="INSERT INTO `clients`(`id`, `first name`, `last name`, `phone`, `e mail`) VALUES (?,?,?,?,?)";
           
        try{
             int k=0;
            PreparedStatement st=getConnection().prepareStatement(q);
            st.setString(1,id);
            st.setString(2,fname);
            st.setString(3,lname);
            st.setString(4,phone);
            st.setString(5,email);
            
            if(st.executeUpdate()>k){
                JOptionPane.showMessageDialog(null, "Client" +id + "saved" );
            }
            
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
       }
       public void updateclients(String id,String fname,String lname,String phone,String email){
     String q="UPDATE `clients` SET `first name`=?,`last name`=?,`phone`=?,`e mail`=? WHERE id=?";
           try{
               int k=0;
            PreparedStatement st=getConnection().prepareStatement(q);
            st.setString(1,id);
            st.setString(2,fname);
            st.setString(3,lname);
            st.setString(4,phone);
            st.setString(5,email);
            
            if(st.executeUpdate()>k){
                JOptionPane.showMessageDialog(null, "Client" + id + "Updated sccesfully" );
            }
            
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
     
       }
             public void deleteclients(String id){
     String q="DELETE FROM clients WHERE id=?";
           try{
               int k=0;
            PreparedStatement st=getConnection().prepareStatement(q);
            st.setString(1,id);
          
            
            if(st.executeUpdate()>k){
                JOptionPane.showMessageDialog(null, "Client" +id + "REecord deleted sccesfully" );
            }
            
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
     
       }
       public ResultSet getclients(){
           String q="SELECT * FROM `clients`"; 
           try{
           Statement st=getConnection().createStatement();
           ResultSet rs=st.executeQuery(q);
           return rs;}
           catch(SQLException x){
               JOptionPane.showMessageDialog(null, x.getMessage()); 
               return null;
           }
           
       }
        public void insertrooms(String number,String type,String phone,String reserved){
           String q="INSERT INTO `rooms`(`r_number`, `type`, `phone`, `reserved`) VALUES (?,?,?,?)";
           
        try{
             int k=0;
            PreparedStatement st=getConnection().prepareStatement(q);
            st.setString(1,number);
            st.setString(2,type);
            st.setString(3,phone);
            st.setString(4,reserved);
            
            if(st.executeUpdate()>k){
                JOptionPane.showMessageDialog(null, "Room" + number+ "saved" );
            }
            
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
       }
         public void updaterooms(String number,String type,String phone,String reserved){
     String q="UPDATE `rooms` SET `type`=?,`phone`=?,`reserved`=? WHERE `r_number`=?";
           try{
               int k=0;
            PreparedStatement st=getConnection().prepareStatement(q);
            st.setString(1,number);
            st.setString(2,type);
            st.setString(3,phone);
            st.setString(4,reserved);
            
            if(st.executeUpdate()>k){
                JOptionPane.showMessageDialog(null, "Room" + number + "Updated sccesfully" );
            }
            
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
     
       }
                  public void deleterooms(String number ){
     String q="DELETE FROM `rooms` WHERE `r_number`=?";
           try{
               int k=0;
            PreparedStatement st=getConnection().prepareStatement(q);
            st.setString(1,number);
          
            
            if(st.executeUpdate()>k){
                JOptionPane.showMessageDialog(null, "Room" + number + "Record deleted sccesfully" );
            }
            
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
     
       }
                   public ResultSet getrooms(){
           String q="SELECT * FROM `rooms`"; 
           try{
           Statement st=getConnection().createStatement();
           ResultSet rs=st.executeQuery(q);
           return rs;}
           catch(SQLException x){
               JOptionPane.showMessageDialog(null, x.getMessage()); 
               return null;
           }
           
       }
                     public ResultSet getroomtype(){
           String q="SELECT * FROM `type`"; 
           try{
           Statement st=getConnection().createStatement();
           ResultSet rs=st.executeQuery(q);
           return rs;}
           catch(SQLException x){
               JOptionPane.showMessageDialog(null, x.getMessage()); 
               return null;
           }}
                          public ResultSet getbookings(){
           String q="SELECT `id`, `client_id`, `room_number`, `date_in`, `date_out` FROM `bookings`"; 
           try{
           Statement st=getConnection().createStatement();
           ResultSet rs=st.executeQuery(q);
           return rs;}
           catch(SQLException x){
               JOptionPane.showMessageDialog(null, x.getMessage()); 
               return null;
           }
           
       }
                                            public void deletebookings(String id ){
     String q="DELETE FROM `bookings` WHERE id=?";
           try{
               int k=0;
            PreparedStatement st=getConnection().prepareStatement(q);
            st.setString(1,id);
          
            
            if(st.executeUpdate()>k){
                JOptionPane.showMessageDialog(null, "Booking " + id + "Record deleted sccesfully" );
            }
            
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
     
       }
                public void updatebookings(String id  ,String clientid ,String roomnumber,Date datein, Date dateout){
     String q="UPDATE `bookings` SET ` `client_id`=?,`room_number`=?,`date_in`=?,`date_out`=? WHERE id=?";
           try{
               int k=0;
            PreparedStatement st=getConnection().prepareStatement(q);
            st.setString(1,id);
            st.setString(2,clientid);
            st.setString(3,roomnumber);
           st.setDate(4, datein);
            st.setDate(5,dateout);
            if(st.executeUpdate()>k){
                JOptionPane.showMessageDialog(null, "Room" + id + "Updated sccesfully" );
            }
            
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
     
       }
 public void insertbookings(String id  ,String clientid ,String roomnumber,Date datein, Date dateout){
           String q="INSERT INTO `bookings`(`id`, `client_id`, `room_number`, `date_in`, `date_out`) VALUES (?,?,?,?,?)";
           
        try{
             int k=0;
            PreparedStatement st=getConnection().prepareStatement(q);
            st.setString(1,id);
            st.setString(2,clientid);
            st.setString(3,roomnumber);
            st.setDate(4, datein);
            st.setDate(5,dateout);
            if(st.executeUpdate()>k){
                JOptionPane.showMessageDialog(null, "Booking" + id + "saved" );
            }
            
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
       }
  public ResultSet getroomstype(){
           String q="SELECT * FROM `type`"; 
           try{
           Statement st=getConnection().createStatement();
           ResultSet rs=st.executeQuery(q);
           return rs;}
           catch(SQLException x){
               JOptionPane.showMessageDialog(null, x.getMessage()); 
               return null;
           }
           
       }

    
       }
