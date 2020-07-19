package Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author Chaos_Coke
 * @create 2020-07-15 09:43:18
 */
public class UtilsForJDBC {
    private static String driverName;
    private static String url;
    private static String userName;
    private static String pwd;

    static {

//        InputStream ips = UtilsForJDBC.class.getClassLoader().getResourceAsStream("jdbc.properties");
//        Properties properties = new Properties();
        Properties properties = new Properties();
        // 使用InPutStream流读取properties文件

        try {
            BufferedReader br = new BufferedReader(new FileReader("src\\jdbc.properties"));
            properties.load(br);
        } catch (IOException e) {
            e.printStackTrace();
        }
        driverName = properties.getProperty("driverName");
        url = properties.getProperty("url");
        userName = properties.getProperty("userName");
        pwd = properties.getProperty("pwd");

        try {
            Class.forName(driverName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConn(){
        Connection connection=null;
        try {
            connection= DriverManager.getConnection(url,userName,pwd);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
    public static void release(ResultSet rs, Statement st, Connection conn) {
        if(rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
