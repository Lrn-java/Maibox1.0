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
     * @param user 该参数用来获取用户信息
     *             获取信息
     */
    default void getMassge(String user) {

        String listing = new String("C:\\Users\\Lrn\\Desktop");
        File file = new File(listing,"File数据库.txt");
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {

            //判断是否有此路径。创建路径
            if(!file.exists()){
                file.mkdirs();
            }


            fileWriter = new FileWriter(file, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            //使用集合类来保存值

            FileReader fileReader = new FileReader("C:\\Users\\Lrn\\Desktop\\File数据库.txt");

            /*预留问题
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            */

            bufferedWriter.write(user + "\n");
            //刷新
            bufferedWriter.flush();

            //关闭流
            bufferedWriter.close();
            fileWriter.close();

            try {

                InetAddress localhost = InetAddress.getLocalHost();

                String userName = "root";
                String password = "123456";
                String databasesURL = "jdbc:mysql://"+localhost.getHostAddress()+":3306/user_message";
                String IP = "jdbc:mysql://"+localhost.getHostAddress()+":3306/user_message";
                out.println(IP);

                //加载驱动
                Class.forName("com.mysql.cj.jdbc.Driver");

                //创建连接
                Connection connection = DriverManager.getConnection(userName,password,databasesURL);

                //获取的用户名和密码存入数据库中
                String insertQuery = "insert into usermessage (user,password) values (user,name)";  
                
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            } catch (UnknownHostException e) {
                throw new RuntimeException(e);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    default void connection(String usermessage,String password){
        if(!user.equalse("") && user != null){
            //预留问题
        }else{
            //写入到user_message数据库中，这个数据库中有一个表，用来保存用户名和密码这些基本信息
        try {

                //加载驱动
                Class.forName("com.mysql.cj.jdbc.Driver");

                //获取本机IP...
                InetAddress localhost = InetAddress.getLocalHost();

                String userName = "root";
                String password = "758206lrnandlnxA";
                String databasesURL = "jdbc:mysql://"+localhost.getHostAddress()+":3306/user_message";
                String IP = "jdbc:mysql://"+localhost.getHostAddress()+":3306/user_message";

                //创建连接
                Connection connection = DriverManager.getConnection(userName,password,databasesURL);
                String insertQuery = "insert into usermessage (user,password) values ()";

            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            } catch (UnknownHostException e) {
                throw new RuntimeException(e);
            }

        } catch (IOException e) {
            //抛出异常
            throw new RuntimeException(e);
        }
    }
}
}