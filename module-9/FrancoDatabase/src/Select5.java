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
import java.sql.*;

public class Select5{

  public static void main(String args[]){

    try{

      Connection con;

      Class.forName("com.mysql.cj.jdbc.Driver");

      String url = "jdbc:mysql://localhost:3306/databasedb?";//Change to database name

      con = DriverManager.getConnection(url + "user=student1&password=pass");//Change to user name

      System.out.println("Connection established - now executing a select");

      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM address33");

     System.out.println("Received Results:");

     int i = rs.getMetaData().getColumnCount();

     while(rs.next()){

       for(int x = 1; x <= i; ++x){

         System.out.println(rs.getString(x));
       }

       System.out.println("");
     }

     stmt.close();
     con.close();
    }
    catch (java.lang.Exception ex){

      ex.printStackTrace();
    }
  }
}
