//Jose Franco
//05/01/2025
//M9-Porogramming Assignment
//Demostraring conectivity to MySQL. Correct installation and configuration.
/*
 *
 * Professor Darrell Payne
 * Bellevue University
 *
 */

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

/**
 *
 * @author franco
 */
import java.net.URL;
import java.sql.*;

public class CreateTable{

  Connection con;

  Statement stmt;

  public CreateTable(){

    try{

      Class.forName("com.mysql.cj.jdbc.Driver");

      String url = "jdbc:mysql://localhost:3306/databasedb?";//Change to database name

      con = DriverManager.getConnection(url + "user=student1&password=pass");//Change to user name

      stmt = con.createStatement();
      
      System.out.println("Connection to database successfully.");
    }
    catch(Exception e){

      System.out.println("Error connection to database.");
      System.exit(0);
    }

    try{

      stmt.executeUpdate("DROP TABLE address33");
      System.out.println("Table address dropped.");
    }
    catch(SQLException e){

      System.out.println("Table address does not exist.");
    }

    try{

      stmt.executeUpdate("CREATE TABLE address33(ID int PRIMARY KEY,LASTNAME varchar(40)," +
                         "FIRSTNAME varchar(40), STREET varchar(40), CITY varchar(40), STATE varchar(40)," +
                         "ZIP varchar(40))");
      System.out.println("Table address created sucessfully.");
    }
    catch(SQLException e){

      System.out.println("Table address Creation failed.");
    }

    try{

      stmt.close();

      con.close();
      System.out.println("Database connections closed.");
    }
    catch(SQLException e){

      System.out.println("Connection close failed");
    }
  }

  public static void main(String args[]) {

    CreateTable createTable = new CreateTable();
  }
}
