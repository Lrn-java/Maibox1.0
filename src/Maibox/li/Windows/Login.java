package Maibox.li.Windows;

import javax.swing.*;
import java.awt.*;

/**
 * @author Lrn
 */
public interface Login {
    JFrame J_FRAME = new JFrame();
    JLabel J_LABEL1 = new JLabel();
    JLabel J_LABEL2 = new JLabel();
    JTextField J_TEXT_FIELD1 = new JTextField();
    JPasswordField J_PASSWORD_FIELD = new JPasswordField();
    JPanel J_PANEL = new JPanel();
    Container CONTAINER = J_FRAME.getContentPane();

    /**
     *窗口
     */
    default void setJframe() {
        ImageIcon imageIcon = new ImageIcon("D:\\IDEA-Work\\Maibox1.0\\src\\LoginMaterial\\img_1.png");
        JLabel jlabel = new JLabel(imageIcon);
        jlabel.setBounds(0, 0, 402, 520);
        Integer minValue = Integer.MIN_VALUE;
        J_FRAME.getLayeredPane().add(jlabel,minValue);

        J_FRAME.setBounds(620,280,695,530);
        J_FRAME.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        J_FRAME.setLayout(null);
        J_FRAME.setResizable(false);
        J_FRAME.setVisible(true);

        J_PANEL.setBounds(400,0,293,520);
        J_PANEL.setBackground(Color.white);
        CONTAINER.add(J_PANEL);

        //用户名提示标签
        J_LABEL1.setBounds(420, 250, 150, 80);
        J_LABEL1.setFont(new Font("方正舒体",Font.BOLD, 18));
        J_LABEL1.setForeground(Color.BLACK);
        J_PANEL.add(J_LABEL1);
        CONTAINER.add(J_LABEL1);

        //密码提示标签
        J_LABEL2.setBounds(420, 290, 150, 80);
        J_LABEL2.setFont(new Font("方正舒体", Font.BOLD, 18));
        J_LABEL2.setForeground(Color.BLACK);
        J_PANEL.add(J_LABEL2);
        CONTAINER.add(J_LABEL2);

        //用户名文本框
        J_TEXT_FIELD1.setBounds(490,280,100,25);
        J_PANEL.add(J_TEXT_FIELD1);
        CONTAINER.add(J_TEXT_FIELD1);

        //密码框
        J_PASSWORD_FIELD.setBounds(490,320,100,25);
        J_PASSWORD_FIELD.setEchoChar('*');
        J_PANEL.add(J_PASSWORD_FIELD);
        CONTAINER.add(J_PANEL);
        CONTAINER.add(J_PASSWORD_FIELD);
        JPanel jpanel = (JPanel) J_FRAME.getContentPane();

        jpanel.setOpaque(false);
    }
    /**
     * 登录与注册按钮
     */
    JButton SIGN_BUTTON = new JButton();
    JButton REGISTRATION_BUTTON = new JButton();
    /**
     * 登录按钮
     */
    default void setLoginButton(){
        SIGN_BUTTON.setBounds(425, 360, 60, 30);
        SIGN_BUTTON.setText("登录");
        J_PANEL.add(SIGN_BUTTON);

        CONTAINER.add(J_PANEL);
        CONTAINER.add(SIGN_BUTTON);

        for(int i = 0;i<5;i++){
            SIGN_BUTTON.requestFocus();
        }
    }
    /**
     * 注册按钮
     */
    default void setEnrollButton(){
        REGISTRATION_BUTTON.setBounds(530, 360, 60, 30);
        REGISTRATION_BUTTON.setText("注册");
        J_PANEL.add(REGISTRATION_BUTTON);

        CONTAINER.add(J_PANEL);
        CONTAINER.add(REGISTRATION_BUTTON);

        for(int i = 0;i<101;i++){
            REGISTRATION_BUTTON.requestFocus();
        }

    }
}