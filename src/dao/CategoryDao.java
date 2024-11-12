/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import model.Category;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.*;
/**
 *
 * @author SANJEEV KUMAR
 */
public class CategoryDao {
    //all operaton method of table will be created using methods
    public static void save(Category category){
        String query="insert into category(name) values('"+category.getName()+"')";
        dboperations.setdataordelete(query,"Category Added Successfully"); 
        
    
}
    
    public static ArrayList<Category> getAllRecords(){
        ArrayList<Category> arraylist=new ArrayList<>();
        try{
            ResultSet rs=dboperations.getdata("select * from category");
            while(rs.next()){
                Category category=new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                arraylist.add(category);
            }
        
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        
        return arraylist;
        
    }
    
    public static void delete(String id){
        
        String query="delete from category where id='"+id+"'";
        dboperations.setdataordelete(query,"Category Deleted Successfully");
        
    }
}