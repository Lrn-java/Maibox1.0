package Maibox.li.Windows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Spliterator;

/**
 * @author Lrn
 * 邮箱界面属性
 */

public interface MainInterfaceProperties {
    JFrame M_J_FRAME = new JFrame();
    JPanel M_J_PANEL = new JPanel();
    JLabel jLabel1 = new JLabel("新邮件");
    JLabel jLabel2 = new JLabel("收件人");
    JLabel jLabel3 = new JLabel("主  题");
    JLabel Preview_Button = new JLabel("预览");
    JLabel NewWindow_Button = new JLabel("新窗口打开");
    JLabel carbonCopy_Button = new JLabel("抄送");
    JLabel Bcc_Button = new JLabel("密送");
    JLabel symbol = new JLabel("|");
    JLabel SendSeparately_Button = new JLabel("分别发送");
    Container M_CONTAINER = M_J_FRAME.getContentPane();

    /**
     * 该方法的作用是主界面的属性
     */
    default void mainInterface() {
        M_J_FRAME.setBounds(0, 0, 1920, 1080);
        M_J_FRAME.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        M_J_FRAME.setLayout(null);
        M_J_FRAME.setResizable(true);
        M_J_FRAME.setVisible(true);

        M_J_PANEL.setBounds(240, 140, 1394, 870);
        M_J_PANEL.setBackground(Color.white);
        M_J_PANEL.setLayout(null);
        M_CONTAINER.add(M_J_PANEL);

        //新邮件
        jLabel1.setBounds(20, 5, 50, 50);
        jLabel1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        jLabel1.setForeground(Color.BLACK);
        M_J_PANEL.add(jLabel1);

        //收件人
        jLabel2.setBounds(20, 40, 50, 50);
        jLabel2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        jLabel2.setForeground(Color.BLACK);
        M_J_PANEL.add(jLabel2);

        //主题
        jLabel3.setBounds(20, 75, 50, 50);
        jLabel3.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        jLabel3.setForeground(Color.BLACK);
        M_J_PANEL.add(jLabel3);

        //预览
        Preview_Button.setBounds(1200,8,50,50);
        Preview_Button.setFont(new Font("微软雅黑",Font.PLAIN,15));
        M_J_PANEL.add(Preview_Button);

        //新窗口
        NewWindow_Button.setBounds(1250,8,100,50);
        NewWindow_Button.setFont(new Font("微软雅黑",Font.PLAIN,15));
        M_J_PANEL.add(NewWindow_Button);

        //抄送
        carbonCopy_Button.setBounds(1180,75,50,50);
        carbonCopy_Button.setFont(new Font("微软雅黑",Font.PLAIN,15));
        M_J_PANEL.add(carbonCopy_Button);

        //密送
        Bcc_Button.setBounds(1225,75,50,50);
        Bcc_Button.setFont(new Font("微软雅黑",Font.PLAIN,15));
        M_J_PANEL.add(Bcc_Button);

        //抄送与密送之间的一个符号
        symbol.setBounds(1260,75,50,50);
        symbol.setFont(new Font("微软雅黑",Font.PLAIN,15));
        M_J_PANEL.add(symbol);

        //分别发送
        SendSeparately_Button.setBounds(1270,75,100,50);
        SendSeparately_Button.setFont(new Font("微软雅黑",Font.PLAIN,15));
        M_J_PANEL.add(SendSeparately_Button);

    }
    JTextArea M_J_TEXT_AREA = new JTextArea();
    JScrollPane M_J_SCROLL_PANE = new JScrollPane(M_J_TEXT_AREA);

    /**
     * 面板中添加文本域
     */
    default void textField() {
        M_J_TEXT_AREA.setText("输入正文");
        M_J_TEXT_AREA.setFont(new Font("楷体", Font.PLAIN, 20));
        M_J_TEXT_AREA.setRows(4);
        M_J_TEXT_AREA.setColumns(80);

        M_J_SCROLL_PANE.setBounds(20, 200, 1200, 650);
        M_J_PANEL.add(M_J_SCROLL_PANE);
    }
    JPanel M_J_PANEL_TITLE_BAR = new JPanel();

    /**
     * 该方法是主界面标题栏
     */
    default void titleBar(){
        M_J_PANEL_TITLE_BAR.setBounds(0, 10, 1920, 120);
        M_J_PANEL_TITLE_BAR.setBackground(Color.white);
        M_CONTAINER.add(M_J_PANEL_TITLE_BAR);
    }
    /**
     * 四个组件:
     * M_J_PANEL_MENU_BAR_ONE:面板
     * M_J_BUTTON_ONE:写邮件（JButton）
     * M_J_BUTTON_TWO:收件箱(JButton)
     * M_J_BUTTON_THREE:通讯录(JButton)
     */
    JPanel M_J_PANEL_MENU_BAR_ONE = new JPanel();
    JButton M_J_BUTTON_ONE = new JButton();
    JButton M_J_BUTTON_TWO = new JButton();
    JButton M_J_BUTTON_THREE = new JButton();

    JLabel WriteAMessage_Button = new JLabel("写邮件");
    JLabel Inbox_Button = new JLabel("收件箱");
    JLabel Contacts_Button = new JLabel("通讯录");
    /**
     * 该方法是邮箱菜单栏具有少量组件
     */
    default void menuBarOne(){

        M_J_PANEL_MENU_BAR_ONE.setBounds(10,140,220,130);
        M_J_PANEL_MENU_BAR_ONE.setBackground(Color.white);
        M_CONTAINER.add(M_J_PANEL_MENU_BAR_ONE);

        //写邮件
        WriteAMessage_Button.setBounds(5,15,15,15);
        WriteAMessage_Button.setFont(new Font("微软雅黑",Font.PLAIN,15));
        M_J_PANEL_MENU_BAR_ONE.add(WriteAMessage_Button);

        //收件箱
        Inbox_Button.setBounds(5,20,15,15);
        Inbox_Button.setFont(new Font("微软雅黑",Font.PLAIN,15));
        M_J_PANEL_MENU_BAR_ONE.add(Inbox_Button);

        //通讯录
        Contacts_Button.setBounds(5,40,15,15);
        Contacts_Button.setFont(new Font("微软雅黑",Font.PLAIN,15));
        M_J_PANEL_MENU_BAR_ONE.add(Contacts_Button);

    }

    JPanel M_J_PANEL_MENU_BAR_TWO = new JPanel();
    /**
     * 该方法是邮箱菜单栏具有大量组件
     */
    default void menuBarTwo(){
        M_J_PANEL_MENU_BAR_TWO.setBounds(10,280,220,728);
        M_J_PANEL_MENU_BAR_TWO.setBackground(Color.white);
        M_CONTAINER.add(M_J_PANEL_MENU_BAR_TWO);
    }
    JPanel M_J_PANEL_MENU_BAR_THREE = new JPanel();

    /**
     * 该方法是联系人面板
     */
    default void menuBarThree(){
        M_J_PANEL_MENU_BAR_THREE.setBounds(1645,140,260,870);
        M_J_PANEL_MENU_BAR_THREE.setBackground(Color.white);
        M_CONTAINER.add(M_J_PANEL_MENU_BAR_THREE);
    }

}