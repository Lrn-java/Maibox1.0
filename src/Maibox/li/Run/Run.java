package Maibox.li.Run;

import Maibox.li.GetData.RegistrationInformation;
import Maibox.li.Windows.MainInterface;

import static java.lang.System.out;

public class Run implements RegistrationInformation {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        new MainInterface();
        long end = System.currentTimeMillis();
        out.println("程序总运行时间为:" + (end - start) + "毫秒");

    }
}