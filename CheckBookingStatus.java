package com.RaceGardens.Home;

import java.sql.*;
import java.util.Scanner;

public class CheckBookingStatus {
    private int cust_id;
    String url = "jdbc:oracle:thin:@//localhost:1521/xe";
    String user = "hr";
    String password = "123";
    public void check() throws SQLException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your customer id -- ");
        cust_id = sc.nextInt();
        Driver driver = new oracle.jdbc.driver.OracleDriver();
        DriverManager.registerDriver(driver);

        Connection connection = DriverManager.getConnection(url, user, password);
        Statement stmt = connection.createStatement();

        String query = "select * from booking_race_gardens where customer_id="+cust_id;
        ResultSet rset = stmt.executeQuery(query);

        while(rset.next()){
            System.out.println(rset.getString("date_from")+"\t"+rset.getString("date_to"));
        }

        stmt.close();
        rset.close();
        connection.close();
    }
}
