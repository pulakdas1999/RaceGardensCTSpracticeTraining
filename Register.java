package com.RaceGardens.Home;
import java.sql.*;
import java.util.Scanner;

public class Register extends JDBC_connection_suite{
    private String full_name;
    private long contact_no;
    private String email;
    private String type_of_room;
    private String tv_in_room;
    private String broadband;
    private String laundry;
    public void register_user() throws SQLException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your Full Name -- ");
        full_name = sc.nextLine();
        System.out.println("Enter your contact number -- ");
        contact_no = sc.nextLong();
        System.out.println("Enter your mail address -- ");
        email = sc.next();
        System.out.println("Enter type of room (AC/NON-AC) -- ");
        type_of_room = sc.next();
        System.out.println("Do you want a TV in room (Yes/No) -- ");
        tv_in_room = sc.next();
        System.out.println("Do you want broadband connectivity (Yes/No) -- ");
        broadband = sc.next();
        System.out.println("Do want us to do your laundry (Yes/No) -- ");
        laundry = sc.next();

        Connection connection = jdbc();
        String query = "insert into race_gardens(customer_id, full_name, contact_no, email_id, type_of_room_AC_NAC," +
                "tv_in_room, broadband_enabled, laundry_enabled)" +
                " values(RACE_GD_SQ.nextval, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = this.connection.prepareStatement(query);

        preparedStatement.setString(1, full_name);
        preparedStatement.setLong(2, contact_no);
        preparedStatement.setString(3, email);
        preparedStatement.setString(4, type_of_room);
        preparedStatement.setString(5, tv_in_room);
        preparedStatement.setString(6, broadband);
        preparedStatement.setString(7, laundry);

        int rowCount = preparedStatement.executeUpdate();
        if (rowCount>0){
            System.out.println("Registered!!!");
        }
        preparedStatement.close();
        connection.close();
    }
}
