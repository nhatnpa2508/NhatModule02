/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 6/25/2019                     *
 * Time: 9:14 AM                     *
 *************************************
 */

package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
    static String dbURL = "jdbc:mysql://localhost:3306/image?useUnicode=true&characterEncoding=utf-8";
    static String userName = "root";
    static String passWord = "";

    static Connection connection;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(dbURL, userName, passWord);
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
