package com.RaceGardens.Home;

import java.sql.*;

public class SeeCustomerDetails extends JDBC_connection_suite{
    public void databaseView() throws SQLException{
        Connection connection = jdbc();
        Statement stmt = connection.createStatement();

        String query = "select * from race_gardens";
        ResultSet rset = stmt.executeQuery(query);

        while(rset.next()){
            System.out.println(rset.getString("customer_id")+"\t"+rset.getString("full_name")
            +"\t"+rset.getString("contact_no")+"\t"+rset.getString("email_id")
            +"\t"+rset.getString("type_of_room_AC_NAC")+"\t"+rset.getString("tv_in_room")
            +"\t"+rset.getString("broadband_enabled")+"\t"+rset.getString("laundry_enabled"));
        }

        stmt.close();
        rset.close();
        connection.close();
    }
}
