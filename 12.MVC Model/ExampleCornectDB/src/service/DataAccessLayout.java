/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 6/20/2019                     *
 * Time: 1:52 PM                     *
 *************************************
 */

package service;

import java.sql.*;

public class DataAccessLayout {
    static Connection connection;
    static Statement statement;

    static String url = "jdbc:mysql://localhost:3306/inote";
    static String user = "root";
    static String pass = "nhat2508";

    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url,user,pass);
            return connection;
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
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
