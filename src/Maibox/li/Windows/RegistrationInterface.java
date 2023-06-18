package Maibox.li.Windows;

import javax.swing.*;
import java.awt.*;


/**
 * @author Lrn
 * 注册界面属性
 */
public interface RegistrationInterface {

    JFrame R_J_FRAME = new JFrame();
    JLabel R_J_LABEL1 = new JLabel();
    JLabel R_J_LABEL2 = new JLabel();
    JLabel R_J_LABEL3 = new JLabel();
    JTextField R_J_TEXT_FIELD1 = new JTextField(8);
    JPasswordField R_J_PASSWORD_FIELD1 = new JPasswordField();
    JPasswordField R_J_PASSWORD_FIELD2 = new JPasswordField();
    Container R_CONTAINER = R_J_FRAME.getContentPane();

    JButton J_BUTTON = new JButton();

    /**
     * 注册窗口属性
     */
    default void setRegistrationInterface(){
        ImageIcon imageIcon = new ImageIcon("D:\\IDEA-Work\\Maibox1.0\\src\\LoginMaterial\\注册界面.jpg");
        JLabel jlabel = new JLabel(imageIcon);
        jlabel.setBounds(0, 0, 695, 530);
        Integer minValue = Integer.MIN_VALUE;
        R_J_FRAME.getLayeredPane().add(jlabel,minValue);
        JPanel jpanel = (JPanel) R_J_FRAME.getContentPane();

        R_J_FRAME.setBounds(800, 390, 300, 300);
        R_J_FRAME.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        R_J_FRAME.setLayout(null);
        R_J_FRAME.setResizable(false);
        R_J_FRAME.setVisible(true);

        R_J_LABEL1.setBounds(60, 10, 150, 80);
        R_J_LABEL1.setFont(new Font("方正舒体",Font.PLAIN,18));
        R_J_LABEL1.setForeground(Color.BLACK);
        R_CONTAINER.add(R_J_LABEL1);

        R_J_LABEL2.setBounds(60, 50, 150, 80);
        R_J_LABEL2.setFont(new Font("方正舒体",Font.PLAIN,18));
        R_J_LABEL2.setForeground(Color.BLACK);
        R_CONTAINER.add(R_J_LABEL2);

        R_J_LABEL3.setBounds(60, 90, 150, 80);
        R_J_LABEL3.setFont(new Font("方正舒体",Font.PLAIN,18));
        R_J_LABEL3.setForeground(Color.BLACK);
        R_CONTAINER.add(R_J_LABEL3);

        R_J_TEXT_FIELD1.setBounds(120, 35, 80, 25);
        R_CONTAINER.add(R_J_TEXT_FIELD1);

        R_J_PASSWORD_FIELD1.setBounds(120, 75, 80, 25);
        R_J_PASSWORD_FIELD1.setEchoChar('*');
        R_CONTAINER.add(R_J_PASSWORD_FIELD1);
        R_CONTAINER.setBackground(Color.WHITE);

        R_J_PASSWORD_FIELD2.setBounds(120, 115, 80, 25);
        R_J_PASSWORD_FIELD2.setEchoChar('*');
        R_CONTAINER.add(R_J_PASSWORD_FIELD2);
        R_CONTAINER.setBackground(Color.WHITE);

        jpanel.setOpaque(false);
    }
    /**
     * 确认按钮
     */
    default void confirmSave(){
        J_BUTTON.setBounds(60, 160, 90, 25);
        J_BUTTON.setText("确认保存");
        R_CONTAINER.add(J_BUTTON);
    }
    /**
     * @param length 参数length，获取一个长度
     * @return 该方法返回获取的一个长度
     * 例如:在注册账号时输入的一个用户名，先求取输入的用户名的长度是否符合需求。
     * 示例代码：
     * int[] user = new int[]{0,6};
     * if(user > user[0] && user <= user[1])   //不允许出现魔法值
     *     out.println(true);  //满足条件
     */
    default int userNameMessage(String length){
        return length.length();
    }
}