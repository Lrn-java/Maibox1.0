package Maibox.li.Sidebar;

import Maibox.li.Windows.MainInterfaceProperties;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static java.lang.System.out;


/**
 * 这个类是用来重写左侧按钮的类
 */
public class LeftButton implements MainInterfaceProperties {

    /**
     * 文件中转站方法，这个方法中是文件中转站的方法
     */
    JPanel FileRelocationPanel = new JPanel();
    private void setFileRelocation(){
        FileRelocationPanel.setBounds(240,140,1394,870);
        FileRelocationPanel.setBackground(Color.white);
        FileRelocationPanel.setLayout(null);
        M_CONTAINER.add(FileRelocationPanel);
        //将面板置最顶层
        M_CONTAINER.setComponentZOrder(FileRelocationPanel,0);
        //刷新面板
        M_J_FRAME.requestFocus();
    }

    /**
     * 文件中转站方法
     */
    public void FileRelocation_JButton(){
        FileRelocation_JButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //调用中转站方法
                setFileRelocation();
                super.mouseClicked(e);
            }
        });
    }
}