package Maibox.li.Sidebar;

import Maibox.li.Run.Run;
import Maibox.li.Windows.LoginScreen;
import Maibox.li.Windows.MainInterfaceProperties;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 这个类是用于写左上角的面板
 * 这个面板中有三个按钮点击后的所有属性
 */
public class UpperLeftPanel implements MainInterfaceProperties {

    public final JPanel WriteAMessage = new JPanel();
    public final JFrame jFrame = new JFrame();

    public final JPanel jPanel = new JPanel();
    public JLabel jLabel = new JLabel();


    /**
     * 这个方法是用来写邮件面板执行的操作
     */
    public void setWriteAMessage(){
        WriteAMessage.setBounds(240, 140, 1394, 870);
        WriteAMessage.setBackground(Color.white);
        WriteAMessage.setLayout(null);

        Container container = M_J_FRAME.getContentPane();
        container.add(WriteAMessage);

        M_J_FRAME.remove(WriteAMessage);

        M_J_FRAME.revalidate();
        M_J_FRAME.repaint();

        //设置窗体大小
        jFrame.setBounds(240, 140, 1394, 870);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setVisible(true);

        jPanel.setBounds(240, 140, 1394, 870);
        jPanel.setLayout(null);

        //添加面板
        M_CONTAINER.add(jPanel);
        M_CONTAINER.add(jLabel);
    }

    /**
     *重写这个写邮件按钮的方法
     */
    @Override
    public void mainInterface() {
        MainInterfaceProperties.super.mainInterface();
    }


    /**
     * 这个方法是写邮件按钮执行的操作
     */
    public void WriteAMessage(){
        WriteAMessage_Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new FileRelovationPanel().remove();
                setWriteAMessage();           //调用本地方法
                //mainInterface();            //主面板按钮的作用
                /*LoginScreen LoginScreen = new LoginScreen();
                LoginScreen.mainInterface();*/
                super.mouseClicked(e);
            }
        });

    }

}
