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

public class InsertData{

  Connection con;

  Statement stmt;

  public InsertData(){

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

      System.out.println(
      stmt.executeUpdate("INSERT INTO address33 VALUES(55,'Larry','Rich','1111 Redwing Circle888','Bellevue','NE','68123')") + "row updated");

      System.out.println(
      stmt.executeUpdate("INSERT INTO address33 VALUES(1,'Fine','Ruth','1111 Redwing Circle','Bellevue','NE','68123')") + "row updated");
      System.out.println(
      stmt.executeUpdate("INSERT INTO address33 VALUES(2,'Howard','Curly','1000 Galvin Road South','Bellevue','NE','68005')") + "row updated");
      System.out.println(
      stmt.executeUpdate("INSERT INTO address33 VALUES(3,'Howard','Will','2919 Redwing Circle','Bellevue','NE','68123')") + "row updated");

      System.out.println(
      stmt.executeUpdate("INSERT INTO address33 VALUES(4,'Wilson','Larry','1121 Redwing Circle','Bellevue','NE','68124')") + "row updated");
      System.out.println(
      stmt.executeUpdate("INSERT INTO address33 VALUES(5,'Johnson','George','1300 Galvin Road South','Bellevue','NE','68006')") + "row updated");
      System.out.println(
      stmt.executeUpdate("INSERT INTO address33 VALUES(6,'Long','Matthew','2419 Redwing Circle','Bellevue','NE','68127')") + "row updated");

      System.out.println(
      stmt.executeUpdate("INSERT INTO address33 VALUES(44,'Tom','Matthew','1999 Redwing Circle','Bellevue','NE','68123')") + "row updated");

      stmt.executeUpdate("COMMIT");

      System.out.println("Data Inserted");
    }
    catch(SQLException e){

      System.out.println(e);
      System.out.println("Insert Data Failed");
    }

    try{

      stmt.close();

      con.close();
      System.out.println("Database connections closed");
    }
    catch(SQLException e){

      System.out.println("Connection close failed");
    }
  }

  public static void main(String args[]) {

    InsertData InsertData = new InsertData();
  }
}
