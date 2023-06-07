package Maibox.li.GetData;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

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
    default void getMassge(String usermessage,String password){
            //写入到user_message数据库中，这个数据库中有一个表，用来保存用户名和密码这些基本信息
        try {

                //加载驱动
                Class.forName("com.mysql.cj.jdbc.Driver");

                //获取本机IP...
                InetAddress localhost = InetAddress.getLocalHost();

                String mysql_user = "root";
                String mysql_password = "758206lrnandlnxA";
                String databasesURL = "jdbc:mysql://"+localhost.getHostAddress()+":3306/user_message";

                //创建连接
                Connection connection = DriverManager.getConnection(mysql_user,mysql_password,databasesURL);
                String insertQuery = "insert into usermessage (user,password) values ()";

            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            } catch (UnknownHostException e) {
                throw new RuntimeException(e);
            }

    }
}