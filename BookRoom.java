package com.RaceGardens.Home;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

public class BookRoom extends JDBC_connection_suite{
    private int cust_id;
    private String from_date;
    private String to_date;
    private int no_of_rooms;
    public void doneBooking() throws SQLException, ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your customer identity number -- ");
        cust_id = sc.nextInt();
        System.out.println("Enter the date (DD-MM-YYYY) when you would like to visit us -- ");
        from_date = sc.next();
        System.out.println("Enter the date (DD-MM-YYYY) till when you would like to stay with us -- ");
        to_date = sc.next();
        System.out.println("Enter no. of rooms you need -- ");
        no_of_rooms = sc.nextInt();

        Connection connection = jdbc();
        String query = "select * from booking_race_gardens where date_from>='"+from_date+"' " +
                "and date_to<='"+to_date+"'";
        Statement statement = connection.createStatement();
        ResultSet rset = statement.executeQuery(query);

        if(!(rset.next())){
            if (new SimpleDateFormat("dd-MM-yyyy").parse(from_date).after(new Date())
            && new SimpleDateFormat("dd-MM-yyyy").parse(to_date).after(new Date())){

                query = "insert into booking_race_gardens values ("+cust_id+",'"+from_date+"','"+to_date+"',"+
                "(to_date('"+to_date+"')-to_date('"+from_date+"'))"+",sysdate,"+no_of_rooms+",4,"+
                        "("+no_of_rooms+"*"+"(to_date('"+to_date+"')-to_date('"+from_date+"'))*450))";

                PreparedStatement preparedStatement = connection.prepareStatement(query);
                int rowCount = preparedStatement.executeUpdate();
                if (rowCount>0){
                    System.out.println("You have been booked with us from "+from_date+" till "+to_date+"...");
                }
                preparedStatement.close();
            }else System.out.println("Please select a date after today's date !!!");
        }else System.out.println("Sorry!! We are booked for the selected time window...");
        rset.close();
        connection.close();
    }
}
