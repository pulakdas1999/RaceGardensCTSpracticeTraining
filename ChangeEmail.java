package com.RaceGardens.Home;

import java.sql.*;
import java.util.Scanner;

public class ChangeEmail extends JDBC_connection_suite{
    private int cust_id;
    private String email;
    public void changeEmail() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your customer id -- ");
        cust_id = sc.nextInt();
        System.out.println("Enter new email -- ");
        email = sc.next();

        Connection connection = jdbc();

        String query = "update race_gardens set email_id='"+email+"' where customer_id="+cust_id;
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        int rowCount = preparedStatement.executeUpdate();
        if (rowCount>0){
            System.out.println("Updated!!!");
        }
        preparedStatement.close();
        connection.close();
    }
}
