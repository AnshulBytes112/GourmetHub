/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import javax.swing.JOptionPane;


/**
 *
 * @author SANJEEV KUMAR
 */
public class tables {

    public static void main(String[] args) {
        try {
            String usertable = "create table user(id int AUTO_INCREMENT primary key UNIQUE NOT NULL,name varchar(200),email varchar(200) UNIQUE ,phonenumber varchar(200) UNIQUE ,address varchar(500) UNIQUE, password varchar(200),status varchar(200))";
            dboperations.setdataordelete(usertable, "User Table Created Successfully");
            String admin = "insert into user(name,email,phonenumber,address,password,status) values('Admin','admin@gmail.com','6299956922','DSCE','admin','true')";
            String categorytable = "create table category(id int AUTO_INCREMENT primary key,name varchar(200))";
            String productTable = "create table product(id int AUTO_INCREMENT primary key,name varchar(200),category varchar(200),price varchar(200))";
            String billtable = "create table bill(id int primary key,name varchar(200),mobilenumber varchar(200),email varchar(200),date varchar(200),total varchar(200),createdBy varchar(200))";
            dboperations.setdataordelete(billtable, "Bill Table Created  successfully");
            dboperations.setdataordelete(categorytable, "Category Table Created  successfully");
            dboperations.setdataordelete(admin, "Admin Registered successfully");
            dboperations.setdataordelete(productTable, "Product Table Created  successfully");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
}
