package Maibox.li.Message;

import Maibox.li.GetData.RegistrationInformation;

import java.sql.*;

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

    private String USER = "";
    private String PASSWORD = "";

    public void getUserMessage(){

    }
    /**
     * 这个方法的作用是用来连接数据库的
     */
    public void connect(){
        /*try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(databaseURL,username,password);

            DBConnector(username,password,"jdbc:mysql://10.201.11.37:3306/user_message?useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true");
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("select * from usermessage");
            ResultSet ra = statement.executeQuery("insert into message values (USER,PASSWORD)");

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
        }*/

        String driver="com.mysql.jdbc.Driver";
        String user="root";
        String password="758206lrnandlxnA";
        String url="jdbc:mysql://10.201.11.37:3306/user_message";
        try{
            //加载数据库驱动
            Class.forName(driver);
            //连接数据库
            Connection conn=DriverManager.getConnection(url,user,password);
            System.out.println("连接成功!");
            //创建Statement对象
            Statement stmt=conn.createStatement();
            //建立结果集
            ResultSet rs=stmt.executeQuery("insert into message values (15,15)");
            System.out.println("查询成功!");
            while(rs.next()) {
                System.out.println(rs.getString(1)+" "+rs.getString("username"));
            }
            //关闭结果集
            rs.close();
            //关闭Statement对象
            stmt.close();
            //关闭数据库
            conn.close();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

}



