package Maibox.li.Message;

import java.sql.*;
import java.util.ResourceBundle;
import java.util.Scanner;

import static java.lang.System.err;
import static java.lang.System.out;

/**
 * 该类的作用是连接数据库的作用，这个类最终要继承一个接口，
 * 这个接口会将所有用户注册的信息全部放置到数据库中去对比
 */
public class Message {

    //数据库地址
    private String username;
    private String password;
    private String databaseURL;

    public void DBConnector(String username,String pasword,String databaseURL){
        this.username = username;
        this.password = pasword;
        this.databaseURL = databaseURL;

    }

    public void connect(){
        try {
            Class.forName("com.musql.jdbc.Driver");
            Connection con = DriverManager.getConnection(databaseURL,username,password);

            DBConnector("root","758206lrnandlxnA","jdbc:mysql://localhost:3306/my_database?useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true");
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("select * from usermessage");

            for(int i = 0;rs.next();i++){
                out.println(rs.getString("user")+""+rs.getInt("password"));
            }

            //关闭这些流
            rs.close();
            statement.close();
            con.close();

        } catch (Exception e) {
            err.println("连接数据库出错:"+e.getMessage());
            e.printStackTrace();
        }
    }

}
