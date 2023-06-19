package Maibox.li.Sidebar;

import Maibox.li.Windows.LoginScreen;
import Maibox.li.Windows.MainInterfaceProperties;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 这个类是用于写左上角的面板
 * 这个面板中有三个按钮点击后的所有属性
 */
public class UpperLeftPanel implements MainInterfaceProperties {


    /**
     * 写邮件的方法
     */
    public static void main(String[] args) {

    }

    /**
     * 这个方法是点击写0邮件按钮所执行的操作
     */
    public void WriteAMessage(){
        WriteAMessage_Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mainInterface();           //主面板按钮的作用
                /*LoginScreen LoginScreen = new LoginScreen();
                LoginScreen.mainInterface();*/
                menuBarOne();
                menuBarTwo();
                menuBarThree();
                setLines();
                textField();
                titleBar();
                super.mouseClicked(e);
            }
        });

    }

}
