package Maibox.li.Windows;

import javax.swing.*;

/**
 *异常处理类,用于处理注册时用户输入有误信息
 */
public class UserNameMessage extends Exception{
    private final String user;
    public UserNameMessage(String user){
        super(user);
        this.user = user;
    }
    /**
     * 捕获异常时，弹出对话框
     */
    @Override
    public void printStackTrace() {
        super.printStackTrace();
        JOptionPane.showMessageDialog(null,user,"注册失败!",JOptionPane.ERROR_MESSAGE);
    }
}