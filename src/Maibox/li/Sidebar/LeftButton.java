package Maibox.li.Sidebar;

import Maibox.li.Windows.MainInterfaceProperties;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 这个类是用来重写左侧按钮的类
 */
public class LeftButton implements MainInterfaceProperties {


    private final JPanel FileRelocationPanel = new JPanel();
    /**
     * 文件中转站方法，这个方法中是文件中转站的方法
     */
    private void setFileRelocation() {
        FileRelocationPanel.setBounds(240, 140, 1394, 870);
        FileRelocationPanel.setBackground(Color.white);
        FileRelocationPanel.setLayout(null);

        //移除文件发送面板
        M_J_FRAME.remove(M_J_PANEL);
        Container CONTAINER = M_J_FRAME.getContentPane();
        CONTAINER.add(FileRelocationPanel,null);
        M_J_FRAME.revalidate();
        M_J_FRAME.repaint();

        //设置文件中转站标签的属性及样式最终添加到面板中
        JLabel FileRelocation = new JLabel("文件中转站·1");
        FileRelocation.setBounds(20,10,130,30);
        FileRelocation.setFont(new Font("微软雅黑",Font.BOLD,18));
        FileRelocationPanel.add(FileRelocation);

        //设置上传按钮属性及样式
        JButton upload = new JButton("上传");
        upload.setBackground(new Color(0x328FFA));
        upload.setForeground(new Color(0xFFFFFF));
        upload.setBounds(1050,30,70,25);
        upload.setFont(new Font("微软雅黑",Font.BOLD,15));
        FileRelocationPanel.add(upload);

        //设置文件中转站的搜索框
        JTextField jTextField = new JTextField();
        jTextField.setText("搜索");
        jTextField.setBounds(1200,30,180,25);
        FileRelocationPanel.add(jTextField);

        //设置一个面板
        JPanel jPanel = new JPanel();
        jPanel.setBounds(50,1349,1349,50);
        jPanel.setBackground(Color.blue);
        FileRelocationPanel.add(jPanel);
    }

    /**
     * 当点击文件中转站后，重新绘制文件中转站面板
     */
    public void FileRelocation_JButton(){
        FileRelocation_JButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //调用文件中转站方法
                setFileRelocation();
                super.mouseClicked(e);
            }
        });
    }
}