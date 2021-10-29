package com.RaceGardens.Home;

import java.sql.*;
import java.util.Scanner;

public class CheckBookings extends JDBC_connection_suite{
    private String to_date;
    private String from_date;
    public void check() throws SQLException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the window (start date and end date) in the format 'dd-mm-yyyy' -- ");
        from_date = sc.next();
        to_date = sc.next();

        Connection connection = jdbc();
        Statement stmt = connection.createStatement();

        String query = "select * from booking_race_gardens where date_from >= '"+from_date+
                "' or date_to<='"+to_date+"'";
        ResultSet rset = stmt.executeQuery(query);

        while(rset.next()){
            System.out.println(rset.getString("customer_id")+"\t"+rset.getString("date_from")
            +"\t"+rset.getString("date_to"));
        }

        stmt.close();
        rset.close();
        connection.close();
    }
}
