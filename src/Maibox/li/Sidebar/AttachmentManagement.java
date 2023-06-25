package Maibox.li.Sidebar;

import javax.swing.*;
import java.awt.*;

/**
 * 这个类是附件管理属性
 */
public class AttachmentManagement extends FileRelovationPanel{

    private final JPanel AttachmentManagement = new JPanel();
    private final JLabel AllAttachmentManagement = new JLabel();

    @Override
    public void setFileRelocation() {
        AttachmentManagement.setBounds(240,140,1394,870);
        AttachmentManagement.setBackground(Color.white);
        AttachmentManagement.setLayout(null);

        //先删除面板
        M_J_FRAME.remove(FileRelocationPanel);
        Container CONTAINER = M_J_FRAME.getContentPane();
        CONTAINER.add(AttachmentManagement,null);
        M_J_FRAME.revalidate();
    }
}
