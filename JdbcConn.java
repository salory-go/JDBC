package JDBC.learning;

import com.mysql.jdbc.Driver;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcConn {

    @Test
    public void connect01() throws SQLException {
        Driver driver = new Driver();
        String url = "jdbc:mysql://localhost:3306/db02";
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","lzs");
        Connection connect = driver.connect(url, properties);
        System.out.println(connect);
    }

    @Test
    public void connect02() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/db02";
        Driver driver = (Driver)aClass.newInstance();
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","lzs");
        Connection connect = driver.connect(url, properties);
        System.out.println(connect);
    }

    @Test
    public void connect03() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/db02";
        Driver driver = (Driver)aClass.newInstance();
        Properties properties = new Properties();
        String user = "root";
        String password = "lzs";
        DriverManager.registerDriver(driver);//注册driver驱动
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }

    @Test
    public void connect04() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        //下面两句话也可以不要
//        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
//        Driver driver = (Driver)aClass.newInstance();
        String url = "jdbc:mysql://localhost:3306/db02";

        Properties properties = new Properties();
        String user = "root";
        String password = "lzs";

        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }
    @Test//使用最多
    public void connect05() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");

        Class.forName(driver);

        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }
}
