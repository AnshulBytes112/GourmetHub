/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;
import model.Bill;

/**
 *
 * @author SANJEEV KUMAR
 */
public class Billdao {
    public static String getId(){
        int id=1;
        try{
            
            ResultSet rs=dboperations.getdata("select max(id) from bill");
            if(rs.next()){
                id=rs.getInt(1);
                id+=1;
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        return String.valueOf(id);
    }
    
    //to insert bill details
    public static void save(Bill bill){
        String query="insert into bill values('"+bill.getId()+"','"+bill.getName()+"','"+bill.getMobilenumber()+"','"+bill.getEmail()+"','"+bill.getDate()+"','"+bill.getTotal()+"','"+bill.getCreatedby()+"')";
        dboperations.setdataordelete(query,"Bill details added successfully");
        
    }
    
    
    public static ArrayList<Bill> getAllRecordsByInc(String date){
        ArrayList<Bill> arrayList = new ArrayList<>();
        try{
            ResultSet rs = dboperations.getdata("select *from bill where date like '%"+date+"%'");
            while(rs.next())
            {
                Bill bill = new Bill();
                bill.setId(rs.getInt("id"));
                bill.setName(rs.getString("name"));
                bill.setMobilenumber(rs.getString("mobilenumber"));
                bill.setEmail(rs.getString("email"));
                bill.setDate(rs.getString("date"));
                bill.setTotal(rs.getString("total"));
                bill.setCreatedby(rs.getString("createdBy"));
                arrayList.add(bill);
            }
            
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        return arrayList;
    }
    
    
    public static ArrayList<Bill> getAllRecordsByDesc(String date){
        ArrayList<Bill> arrayList = new ArrayList<>();
        try{
            ResultSet rs = dboperations.getdata("select *from bill where date like '%"+date+"%' order by id DESC");
            while(rs.next())
            {
                Bill bill = new Bill();
                bill.setId(rs.getInt("id"));
                bill.setName(rs.getString("name"));
                bill.setMobilenumber(rs.getString("mobilenumber"));
                bill.setEmail(rs.getString("email"));
                bill.setDate(rs.getString("date"));
                bill.setTotal(rs.getString("total"));
                bill.setCreatedby(rs.getString("createdby"));
                arrayList.add(bill);
            }
            
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        return arrayList;
    }
    
}
