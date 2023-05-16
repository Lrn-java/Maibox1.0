package Maibox.li.Windows;

import javax.swing.*;
import java.awt.*;

/**
 * @author Lrn
 */
public interface Login {
    int[] USER_LEN = new int[]{8};
    int[] PASSWROD_LEN = new int[]{6,16};

    JFrame J_FRAME = new JFrame();
    JLabel J_LABEL1 = new JLabel();
    JLabel J_LABEL2 = new JLabel();
    JTextField J_TEXT_FIELD1 = new JTextField();
    JPasswordField J_PASSWORD_FIELD = new JPasswordField();
    Container CONTAINER = J_FRAME.getContentPane();

    /**
     *窗口
     */
    default void setJframe() {
        ImageIcon imageIcon = new ImageIcon("D:\\IDEA-Work\\Maibox1.0\\src\\LoginMaterial\\登录界面图片.jpg");
        JLabel jlabel = new JLabel(imageIcon);
        jlabel.setBounds(0, 0, 695, 530);
        J_FRAME.getLayeredPane().add(jlabel,new Integer(Integer.MIN_VALUE));
        JPanel jpanel = (JPanel) J_FRAME.getContentPane();

        J_FRAME.setBounds(620,280,695,530);
        J_FRAME.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        J_FRAME.setLayout(null);
        J_FRAME.setResizable(false);
        J_FRAME.setVisible(true);


        J_LABEL1.setBounds(205, 150, 150, 80);
        J_LABEL1.setFont(new Font("方正舒体",Font.BOLD, 18));
        J_LABEL1.setForeground(Color.BLACK);
        CONTAINER.add(J_LABEL1);

        J_LABEL2.setBounds(205, 200, 150, 80);
        J_LABEL2.setFont(new Font("方正舒体", Font.BOLD, 18));
        J_LABEL2.setForeground(Color.BLACK);
        CONTAINER.add(J_LABEL2);

        J_TEXT_FIELD1.setBounds(270,175,100,25);
        CONTAINER.add(J_TEXT_FIELD1);

        J_PASSWORD_FIELD.setBounds(270,225,100,25);
        J_PASSWORD_FIELD.setEchoChar('*');
        CONTAINER.add(J_PASSWORD_FIELD);

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
        SIGN_BUTTON.setBounds(205, 280, 60, 30);
        SIGN_BUTTON.setText("登录");
        CONTAINER.add(SIGN_BUTTON);
    }

    /**
     * 注册按钮
     */
    default void setEnrollButton(){
        REGISTRATION_BUTTON.setBounds(310, 280, 60, 30);
        REGISTRATION_BUTTON.setText("注册");
        CONTAINER.add(REGISTRATION_BUTTON);
    }
}