package Maibox.li.GetData;

import java.net.InetAddress;
import java.sql.*;
import static java.lang.System.out;

/**
 * @author 该接口用来读取用户信息
 */
public interface RegistrationInformation {

    /**
      *这个方法会连接到数据库，这个操作会将获取到的参数写入数据库中
      *有两个参数，被调用后会将信息写入数据库
      *usermessage：用户名
      *password：密码
      */
    default void getMassage(String usermessage,String password1){
            //写入到user_message数据库中，这个数据库中有一个表，用来保存用户名和密码这些基本信息
        try {

                //加载驱动
                Class.forName("com.mysql.cj.jdbc.Driver");

                //获取本机IP...

                //10.10.228.130
                String mysql_user = "root";
                String mysql_password = "*";
                String databasesURL = "jdbc:mysql://10.201.11.37:3306/user_message";

                //创建连接
                Connection connection = DriverManager.getConnection(databasesURL,mysql_user,mysql_password);
                Statement statement = connection.createStatement();
                //数据库的连接

            String insert = "insert into message. (user, u_message) values (?, ?)";
            PreparedStatement ps = connection.prepareStatement(insert);
            ps.setString(1, usermessage);
            ps.setString(2, password1);
            int rowsInserted = ps.executeUpdate();

            if(rowsInserted > 0){
                out.println("");
            }

            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
    }

}