/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 6/21/2019                     *
 * Time: 10:08 AM                     *
 *************************************
 */

package service;

import java.sql.*;

public class DatabaseConnection {
    public DatabaseConnection() {
    }

    public Connection getConnection() {
        try {
            String driverName = "con.mysql.jdbc.Driver";
            Class.forName(driverName);

            String url = "jdbc:mysql://localhost/inote";
            String id = "root";
            String password = "nhat2508";
            Connection connection = DriverManager.getConnection(url, id, password);
            return connection;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    Connection connection;
    Statement statement;
    public ResultSet getData(String sql){
        statement = null;
        try{
            statement = connection.createStatement();
            return statement.executeQuery(sql);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateData(String sql){
        statement = null;
        try {
            statement = connection.createStatement();
            return (statement.executeUpdate(sql) > 0);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
