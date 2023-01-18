package JDBC.learning;
import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Jdbc01 {
    public static void main(String[] args) throws SQLException {
        //前置工作，项目下创建一个文件夹
        //将mysql.jar拷贝到该目录，右键 add to project加入项目
        //注册驱动-加载Driver类
        Driver driver = new Driver();

        //获取连接-得到Connection
        //IP+端口+库
        String url = "jdbc:mysql://localhost:3306/db02";
        //将用户名和密码放入Properties对象
        Properties properties = new Properties();
        //下面一点都不能错
        properties.setProperty("user","root");
        properties.setProperty("password","lzs");

        Connection connect = driver.connect(url, properties);

        //执行增删改查-发送SQL
        String sql = "insert into actor values(null,'刘慈欣','男','1970-1-1','110')";
        //用于执行SQL语句并返回结果
        Statement statement = connect.createStatement();
        int rows = statement.executeUpdate(sql);//如果参数是SQL语句，返回的是影响行数
        System.out.println(rows>0?"成功":"失败");

        //释放资源-关闭连接
        statement.close();
        connect.close();
    }
}
