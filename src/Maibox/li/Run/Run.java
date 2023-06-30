package Maibox.li.Run;

import Maibox.li.GetData.RegistrationInformation;
import Maibox.li.Windows.Login;
import Maibox.li.Windows.MainInterface;

import javax.swing.*;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

import static java.lang.System.out;

public class Run implements RegistrationInformation, Login {
    private final String[] user = new String[]{"电","子","与","信","息","工","程","学","院"};
    private static final String[] password = new String[]{"d","z","y","x","x","g","c","x","y","2","0","2","2","0","2"};
    private static int currentIndex;
    private static int pacurrentIndex;
    private static final Timer t = new Timer();
    public Run(){
        new MainInterface();
        currentIndex = 0;
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                if (currentIndex < user.length) {
                    String value = user[currentIndex++];
                    J_TEXT_FIELD1.setText(J_TEXT_FIELD1.getText() + value + " ");
                } else {
                    t.cancel();
                }
            }
        }, 1000, 1000);

    }
    public static void run(){
        pacurrentIndex = 0;
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                if (pacurrentIndex < password.length) {
                    String value = password[pacurrentIndex++];
                    J_PASSWORD_FIELD.setText(J_PASSWORD_FIELD.getText() + value + " ");
                } else {
                    t.cancel();
                }
            }
        }, 1000, 1000);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        new MainInterface();
        long end = System.currentTimeMillis();
        out.println("程序总运行时间为:" + (end - start) + "毫秒");

    }
}