/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import javax.swing.JOptionPane;
import java.sql.*;
/**
 *
 * @author SANJEEV KUMAR
 */
public class dboperations {
    //this fucntion is responsible for performing sql operation
    public static void setdataordelete(String query,String msg){
        try{
            //this will create a connection with sql
            Connection con=ConnectionProvider.getCon();
            Statement st= con.createStatement();
            st.executeUpdate(query);
            //we can check if the message is empty or not
            if(!msg.equals("")){
                JOptionPane.showMessageDialog(null,msg);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Message", JOptionPane.ERROR_MESSAGE);
    }
    
}
public static ResultSet getdata(String query){
   try{
       Connection con=ConnectionProvider.getCon();
       Statement st= con.createStatement();
       ResultSet rs=st.executeQuery(query);
       return rs;
       
   }
   catch(Exception e){
       JOptionPane.showMessageDialog(null, e, "Message", JOptionPane.ERROR_MESSAGE);
       return null;
}

}
}
