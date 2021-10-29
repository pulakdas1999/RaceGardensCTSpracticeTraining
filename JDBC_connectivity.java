package JDBC_package;
import java.sql.*;

public class JDBC_connectivity {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:oracle:thin:@//localhost:1521/xe";
        String user = "hr";
        String password = "123";

        Driver driver = new oracle.jdbc.driver.OracleDriver();
        DriverManager.registerDriver(driver);

        Connection connection = DriverManager.getConnection(url, user, password);
        Statement stmt = connection.createStatement();

        String query = "select * from order_table";
        ResultSet rset = stmt.executeQuery(query);

        while(rset.next()){
            System.out.println(rset.getString("cust_name")+"\t"+rset.getString("order_id"));
        }

        stmt.close();
        rset.close();
        connection.close();
    }
}
