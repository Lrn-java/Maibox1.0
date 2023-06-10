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

    /**
     * 文件中转站点击后的事件
     */
    public void FileRelocation_JButton(){
        FileRelocation_JButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFrame jFrame = new JFrame();
                jFrame.setBounds(500,500,300,500);
                jFrame.setLayout(null);
                jFrame.setVisible(true);

                Container container = jFrame.getContentPane();

                super.mouseClicked(e);
            }
        });
    }
}