package JDBC.learning;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class jbdc02 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");

        Class.forName(driver);
        Connection connection = (Connection) DriverManager.getConnection(url,user,password);
        Statement statement = connection.createStatement();
        int i=0;
//        i = statement.executeUpdate("CREATE TABLE new_actor(id INT PRIMARY KEY auto_increment,NAME VARCHAR(32),SEX CHAR(1))");
        i = statement.executeUpdate("INSERT INTO new_actor VALUES(NULL,'Frank','男')");
//        i = statement.executeUpdate("UPDATE new_actor SET NAME = 'Salroy' WHERE id=1");
//        i = statement.executeUpdate("DELETE FROM new_actor WHERE id=3");
        System.out.println(i>0?"成功":"失败");
    }
}
