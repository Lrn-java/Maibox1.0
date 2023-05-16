package Maibox.li.Windows;

import Maibox.li.GetData.RegistrationInformation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Lrn
 */
public class LoginScreen implements Login,RegistrationInterface, RegistrationInformation,MainInterfaceProperties{

    public static final String USER = null;
    public static final String PASSWORD = null;
    private static final int[] LENGTH = new int[]{0,6,16};
    public LoginScreen() {
        this.setJframe();
        this.setLoginButton();
        this.setEnrollButton();
        this.confirmSave();
    }
    /**
     * 登录界面方法
     */
    @Override
    public void setJframe() {
        Login.super.setJframe();
        J_LABEL1.setText("用户名");
        J_LABEL2.setText("密  码");
    }
    /**
     * 登录按钮
     */
    @Override
    public void setLoginButton() {
        Login.super.setLoginButton();
        SIGN_BUTTON.addActionListener(e -> {
            mainInterface();
            textField();
            titleBar();
            menuBarOne();
            menuBarTwo();
            menuBarThree();

            //登录成功后关闭登录界面
            J_FRAME.setVisible(false);
        });
    }
    /**
     * 注册按钮
     */
    @Override
    public void setEnrollButton() {
        Login.super.setEnrollButton();
        REGISTRATION_BUTTON.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setRegistrationInterface();
            }
        });
    }

    @Override
    public void setRegistrationInterface() {
        RegistrationInterface.super.setRegistrationInterface();
        R_J_LABEL1.setText("用户名:");
        R_J_LABEL2.setText("密 码:");
        R_J_LABEL3.setText("密 码:");
    }
    /**
     * 注册界面按钮(确认保存)
     */
    @Override
    public void confirmSave() {
        RegistrationInterface.super.confirmSave();
        J_BUTTON.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取用户信息
                char[] password1 = R_J_PASSWORD_FIELD1.getPassword();
                char[] password2 = R_J_PASSWORD_FIELD2.getPassword();

                String passwordO = String.valueOf(password1);
                String passwordT = String.valueOf(password2);

                if (R_J_TEXT_FIELD1.getText().length() > LENGTH[0] && R_J_TEXT_FIELD1.getText().length() <= LENGTH[1] &&
                        passwordO.length() >= LENGTH[1] && passwordO.length() <= LENGTH[2] &&
                        passwordO.equals(passwordT)) {

                        getMassge(R_J_TEXT_FIELD1.getText());    //写入文件
                        getMassge(passwordT);
                        JOptionPane.showMessageDialog(null,"注册成功!","",JOptionPane.WARNING_MESSAGE);

                        //清除用户信息
                        R_J_TEXT_FIELD1.setText("");
                        R_J_PASSWORD_FIELD1.setText("");
                        R_J_PASSWORD_FIELD2.setText("");
                        R_J_FRAME.setVisible(false);   //隐藏窗口
                } else {
                    try {
                        String errorMessage = "用户信息无效！\n" +
                                "用户名长度必须为 1-3 个字符,密码长度必须介于 6 到 16 个字符之间,两次密码必须一致!";
                        R_J_PASSWORD_FIELD1.setText("");
                        R_J_PASSWORD_FIELD2.setText("");
                        throw new UserNameMessage(errorMessage);
                    } catch (UserNameMessage ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }
}
