/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
//the class of different package is imported 
import model.User;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author SANJEEV KUMAR
 */
public class Userdao {
    public static void save(User user){
        String query="insert into user(name,email,phonenumber,address,password,status) values('"+user.getName()+"','"+user.getEmail()+"','"+user.getPhonenumber()+"','"+user.getAddress()+"','"+user.getPassword()+"','false')";
        dboperations.setdataordelete(query,"Registered successfully wait for Admin Approval!");
        
    }
    
    public static User login(String email,String password){
        User user=null;
        try{
            ResultSet rs=dboperations.getdata("Select status from user where email='"+email+"' and password='"+password+"'");
            while(rs.next()){
                user=new User();
                user.setStatus(rs.getString("status"));
        }}
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
    } 
        return user;
    }
    public static ArrayList<User> getAllRecords(String email){
    ArrayList<User> arraylist=new ArrayList<>();
    try{
        ResultSet rs=dboperations.getdata("select * from user where email like '%"+email+"%'");
        while(rs.next()){//this will add value to a list the values here correspond to the form columns as the data is for form(table)
            
            User user=new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            user.setPhonenumber(rs.getString("email"));
            user.setAddress(rs.getString("address"));
            user.setStatus(rs.getString("status"));
            arraylist.add(user);
            
        }
    
    }
    
    catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
    }
    return arraylist;



}
public static void changestatus(String email,String status){
    String query="'update user set status='"+status+"'where email='"+email+"'";
    dboperations.setdataordelete(query, "Status changed Sucessfully");
}


}
