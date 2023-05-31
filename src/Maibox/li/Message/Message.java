package Maibox.li.Message;

import Maibox.li.GetData.RegistrationInformation;

import java.sql.*;
import java.util.ResourceBundle;
import java.util.Scanner;

import static java.lang.System.err;
import static java.lang.System.out;

/**
 * 该类的作用是连接数据库的作用，这个类最终要继承一个接口，
 * 这个接口会将所有用户注册的信息全部放置到数据库中去对比
 */
//这个数据库连接继承了一个接口，这个接口中获取的值会被存放在数据库中
public class Message implements RegistrationInformation {

    /**
     * username:这个成员变量是用来输入用户姓名的
     * password；这个成员变量是用来输入用户登录密码的
     * URL：它是一个连接数据库的地址
     */
    private String username;
    private String password;
    private String databaseURL;

    /**
     *
     * @param username 连接数据库的用户名
     * @param pasword  连接数据库的密码
     * @param databaseURL   连接数据的一个驱动地址，通过该驱动地址可以进行对数据库的一个本地连接，注意这个练级的地址必须与自己系统的时区一样，否则会导致连接数据库错误
     */
    public void DBConnector(String username,String pasword,String databaseURL){
        this.username = username;
        this.password = pasword;
        this.databaseURL = databaseURL;

    }

    /**
     * 这个方法的作用是用来连接数据库的
     */
    public void connect(){
        try {
            Class.forName("com.musql.jdbc.Driver");
            Connection con = DriverManager.getConnection(databaseURL,username,password);

            DBConnector("root","758206lrnandlxnA","jdbc:mysql://10.201.11.37:3306/my_database?useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true");
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
            //当连接数据失败后提示用户
            err.println("连接数据库出错:"+e.getMessage());
            e.printStackTrace();
        }
    }

}
