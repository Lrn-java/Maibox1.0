package Maibox.li.GetData;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.concurrent.Executor;

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

            if(!file.exists()){
                file.mkdirs();
            }


            fileWriter = new FileWriter(file, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            //使用集合类来保存值
            Set set = new HashSet();

            FileReader fileReader = new FileReader("C:\\Users\\Lrn\\Desktop\\File数据库.txt");

            /*预留问题
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            */

            bufferedWriter.write(user + "\n");
            bufferedWriter.flush();

            //刷新
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if(bufferedWriter == null){
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            if(fileWriter == null){
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
