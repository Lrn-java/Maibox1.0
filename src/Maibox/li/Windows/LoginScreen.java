package Maibox.li.Windows;

import Maibox.li.GetData.RegistrationInformation;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

/**
 * @author Lrn
 */
public class LoginScreen implements Login,RegistrationInterface, RegistrationInformation,MainInterfaceProperties{


    int[] LENGTH = new int[]{0,6,16};
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
            setLines();

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
                        throw new UserNameMessageError(errorMessage);
                    } catch (UserNameMessageError ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }
    /**
     * 少量组件面板中按钮监听效果的重写
     */
    @Override
    public void menuBarOne() {
        MainInterfaceProperties.super.menuBarOne();
        WriteAMessage_Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                WriteAMessage_Button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                WriteAMessage_Button.setFont(new Font("微软雅黑",Font.BOLD,14));
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                WriteAMessage_Button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                WriteAMessage_Button.setFont(new Font("微软雅黑",Font.PLAIN,14));
                super.mouseExited(e);
            }
        });

        Inbox_Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Inbox_Button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                Inbox_Button.setFont(new Font("微软雅黑",Font.BOLD,14));
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Inbox_Button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                Inbox_Button.setFont(new Font("微软雅黑",Font.PLAIN,14));
                super.mouseExited(e);
            }
        });

        Contacts_Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Contacts_Button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                Contacts_Button.setFont(new Font("微软雅黑",Font.BOLD,14));
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Contacts_Button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                Contacts_Button.setFont(new Font("微软雅黑",Font.PLAIN,14));
                super.mouseExited(e);
            }
        });

    }

    /**
     * 这个方法是预览窗口
     */
    public void mainInterface() {

            //该方法是一个添加附件的按钮，这个按钮组件可以进行磁盘的读取，供用户添加附件
            MainInterfaceProperties.super.mainInterface();
            M_J_LABEL.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    JFrame frame = new JFrame();
                    frame.setBounds(300,500,300,300);

                    // 创建文件选择器对象
                    JFileChooser fileChooser = new JFileChooser();

                    // 显示文件对话框并等待用户选择文件或目录
                    int result = fileChooser.showOpenDialog(frame);

                    // 如果用户选择了文件或目录，则打印选择的路径
                    if (result == JFileChooser.APPROVE_OPTION) {
                        System.out.println("选择的路径：" + fileChooser.getSelectedFile().getAbsolutePath());
                    }
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    super.mouseClicked(e);
                }
            });

        /*
         该按钮是一个<超大附件>按钮:
         1.当用户点击超大附件按钮时会弹出一个自己磁盘的列表。可供用户选择。
         */


        M_J_LABEL_TWO.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFrame frame = new JFrame();

                // 创建文件选择器对象
                JFileChooser fileChooser = new JFileChooser();

                // 显示文件对话框并等待用户选择文件或目录
                int result = fileChooser.showOpenDialog(frame);

                // 如果用户选择了文件或目录，则打印选择的路径
                if (result == JFileChooser.APPROVE_OPTION) {
                    System.out.println("选择的路径：" + fileChooser.getSelectedFile().getAbsolutePath());
                }
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setBounds(270,140,400,400);
                frame.pack();
                //frame.setVisible(true);
                super.mouseClicked(e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                M_J_LABEL_TWO.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                M_J_LABEL_TWO.setFont(new Font("微软雅黑",Font.BOLD,15));
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                M_J_LABEL_TWO.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                M_J_LABEL_TWO.setFont(new Font("微软雅黑",Font.PLAIN,15 ));
                super.mouseExited(e);
            }
        });

        M_J_LABEL_THREE.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFrame frame = new JFrame();

                // 创建文件选择器对象
                JFileChooser fileChooser = new JFileChooser();
                String[] Image_Format = new String[]{"JPG","jpg","GIF","gif","Png","png","TIF","tif","PCX","pcx","TGA","tga","EXIF","exif"，"WEBP","webp","INDD","indd"};
                FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter(Image_Format[0],Image_Format[1]);
                FileNameExtensionFilter fileNameExtensionFilter1 = new FileNameExtensionFilter(Image_Format[2],Image_Format[3]);
                FileNameExtensionFilter fileNameExtensionFilter2 = new FileNameExtensionFilter(Image_Format[4],Image_Format[5]);
                FileNameExtensionFilter fileNameExtensionFilter3 = new FileNameExtensionFilter(Image_Format[6],Image_Format[7]);
                FileNameExtensionFilter fileNameExtensionFilter4 = new FileNameExtensionFilter(Image_Format[8],Image_Format[9]);
                FileNameExtensionFilter fileNameExtensionFilter5 = new FileNameExtensionFilter(Image_Format[10],Image_Format[11]);
                FileNameExtensionFilter fileNameExtensionFilter6 = new FileNameExtensionFilter(Image_Format[12],Image_Format[13]);
                FileNameExtensionFilter fileNameExtensionFilter7 = new FileNameExtensionFilter(Image_Format[14],Image_Format[15]);
                FileNameExtensionFilter fileNameExtensionFilter8 = new FileNameExtensionFilter(Image_Format[16],Image_Format[17]);
                FileNameExtensionFilter fileNameExtensionFilter9 = new FileNameExtensionFilter(Image_Format[14],Image_Format[15]);
                
                byte i = 1;
                for(int i = 0;i<=Image_Format.length;i++){
                    out.println("第"+j+"个索引"+Image_Format[i]);
                    j++
                }

                fileChooser.setFileFilter(fileNameExtensionFilter);
                fileChooser.setFileFilter(fileNameExtensionFilter1);
                fileChooser.setFileFilter(fileNameExtensionFilter2);
                fileChooser.setFileFilter(fileNameExtensionFilter3);
                fileChooser.setFileFilter(fileNameExtensionFilter4);
                fileChooser.setFileFilter(fileNameExtensionFilter5);
                fileChooser.setFileFilter(fileNameExtensionFilter6);
                fileChooser.setFileFilter(fileNameExtensionFilter7);
                fileChooser.setFileFilter(fileNameExtensionFilter8);
                fileChooser.setFileFilter(fileNameExtensionFilter9);


                // 显示文件对话框并等待用户选择文件或目录
                int result = fileChooser.showOpenDialog(frame);

                // 如果用户选择了文件或目录，则打印选择的路径
                if (result == JFileChooser.APPROVE_OPTION) {
                    System.out.println("选择的路径：" + fileChooser.getSelectedFile().getAbsolutePath());
                }
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setBounds(270,140,400,400);
                frame.pack();
                super.mouseClicked(e);
            }
            
            M_J_LABEL_FOUR.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFrame frame = new JFrame();

                // 创建文件选择器对象
                JFileChooser fileChooser = new JFileChooser();
                String[] Image_Format = new String[]{"JPG","jpg","GIF","gif","Png","png","TIF","tif","PCX","pcx","TGA","tga","EXIF","exif"，"WEBP","webp","INDD","indd"};
                
                // 显示文件对话框并等待用户选择文件或目录
                int result = fileChooser.showOpenDialog(frame);

                // 如果用户选择了文件或目录，则打印选择的路径
                if (result == JFileChooser.APPROVE_OPTION) {
                    System.out.println("选择的路径：" + fileChooser.getSelectedFile().getAbsolutePath());
                }
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setBounds(270,140,400,400);
                frame.pack();
                super.mouseClicked(e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                M_J_LABEL_FOUR.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                M_J_LABEL_FOUR.setFont(new Font("微软雅黑",Font.BOLD,15));
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                M_J_LABEL_FOUR.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                M_J_LABEL_FOUR.setFont(new Font("微软雅黑",Font.PLAIN,15));
                super.mouseExited(e);
            }
        });

        /*
         * 预览按钮,新窗口按钮按钮重写
         */
        Preview_Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Preview_Button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                Preview_Button.setFont(new Font("微软雅黑",Font.BOLD,15));
                super.mouseEntered(e);
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Preview_Button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                Preview_Button.setFont(new Font("微软雅黑",Font.PLAIN,15));
                super.mouseEntered(e);
                super.mouseExited(e);
            }
        });

        /*
         * 预览和新窗口按钮
         */
        NewWindow_Button.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                NewWindow_Button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                NewWindow_Button.setFont(new Font("微软雅黑",Font.BOLD,15));
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                NewWindow_Button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                NewWindow_Button.setFont(new Font("微软雅黑",Font.PLAIN,15));
                super.mouseExited(e);
            }
        });

        /*
         * 抄送按钮重写
         */
        carbonCopy_Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                carbonCopy_Button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                carbonCopy_Button.setFont(new Font("微软雅黑",Font.BOLD,14));
                carbonCopy_Button.setToolTipText("什么是抄送:\n同时将这一封邮件发送给其他联系人。");
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                carbonCopy_Button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                carbonCopy_Button.setFont(new Font("微软雅黑",Font.PLAIN,14));
                super.mouseExited(e);
            }
        });

        /*
         * 密送按钮重写
         */
        Bcc_Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Bcc_Button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                Bcc_Button.setFont(new Font("微软雅黑",Font.BOLD,14));
                Bcc_Button.setToolTipText("什么是密送:\t同时将这一封邮件发送给其他联系人，但收件人及抄送人不会看到密送人。");
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Bcc_Button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                Bcc_Button.setFont(new Font("微软雅黑",Font.PLAIN,14));
                super.mouseExited(e);
            }
        });

        /*
         * 分别发送按钮重写
         */
        SendSeparately_Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                SendSeparately_Button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                SendSeparately_Button.setFont(new Font("微软雅黑",Font.BOLD,14));
                SendSeparately_Button.setToolTipText("什么是分别发送:\n会对多个人进行一对一发送。每个人将收到单独发送给TA的邮件");
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                SendSeparately_Button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                SendSeparately_Button.setFont(new Font("微软雅黑",Font.PLAIN,14));
                super.mouseExited(e);
            }
        });
    }
    /*
     * 这个方法是来自MainInterfaceProperties.java
     * 这个接口提供的第二菜单栏面板，这个面板中具有多个标签按钮，这些按钮都具有一些操作
     */

    public void menuBarTwo() {
        MainInterfaceProperties.super.menuBarTwo();
        ImportantContacts_JButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                ImportantContacts_JButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                ImportantContacts_JButton.setFont(new Font("微软雅黑",Font.BOLD,15));
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                ImportantContacts_JButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                ImportantContacts_JButton.setFont(new Font("微软雅黑",Font.PLAIN,15));
                super.mouseExited(e);
            }
        });

        StarMail_JButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                StarMail_JButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                StarMail_JButton.setFont(new Font("微软雅黑",Font.BOLD,15));
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                StarMail_JButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                StarMail_JButton.setFont(new Font("微软雅黑",Font.PLAIN,15));
                super.mouseExited(e);
            }
        });

        Sent_JButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Sent_JButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                Sent_JButton.setFont(new Font("微软雅黑",Font.BOLD,15));
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Sent_JButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                Sent_JButton.setFont(new Font("微软雅黑",Font.PLAIN,15));
                super.mouseExited(e);
            }
        });

        DraftBin_JButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                DraftBin_JButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                DraftBin_JButton.setFont(new Font("微软雅黑",Font.BOLD,15));
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                DraftBin_JButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                DraftBin_JButton.setFont(new Font("微软雅黑",Font.PLAIN,15));
                super.mouseExited(e);
            }
        });

        Deleted_JButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Deleted_JButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                Deleted_JButton.setFont(new Font("微软雅黑",Font.BOLD,15));
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Deleted_JButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                Deleted_JButton.setFont(new Font("微软雅黑",Font.PLAIN,15));
                super.mouseExited(e);
            }
        });

        dustbin_JButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                dustbin_JButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                dustbin_JButton.setFont(new Font("微软雅黑",Font.BOLD,15));
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                dustbin_JButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                dustbin_JButton.setFont(new Font("微软雅黑",Font.PLAIN,15));
                super.mouseExited(e);
            }
        });

        FileRelocation_JButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                FileRelocation_JButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                FileRelocation_JButton.setFont(new Font("微软雅黑",Font.BOLD,15));
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                FileRelocation_JButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                FileRelocation_JButton.setFont(new Font("微软雅黑",Font.PLAIN,15));
                super.mouseExited(e);
            }
        });

        AttachmentManagement.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                AttachmentManagement.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                AttachmentManagement.setFont(new Font("微软雅黑",Font.BOLD,15));
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                AttachmentManagement.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                AttachmentManagement.setFont(new Font("微软雅黑",Font.PLAIN,15));
                super.mouseExited(e);
            }
        });

        Calendar_JButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Calendar_JButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                Calendar_JButton.setFont(new Font("微软雅黑",Font.BOLD,15));
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Calendar_JButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                Calendar_JButton.setFont(new Font("微软雅黑",Font.PLAIN,15));
                super.mouseExited(e);
            }
        });

        notepad_JButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                notepad_JButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                notepad_JButton.setFont(new Font("微软雅黑",Font.BOLD,15));
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                notepad_JButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                notepad_JButton.setFont(new Font("微软雅黑",Font.PLAIN,15));
                super.mouseExited(e);
            }
        });

        resume_JButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                resume_JButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                resume_JButton.setFont(new Font("微软雅黑",Font.BOLD,15));
                super.mouseEntered(e);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                resume_JButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                resume_JButton.setFont(new Font("微软雅黑",Font.PLAIN,15));
                super.mouseExited(e);
            }
        });

        InvoiceAssistant_JButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                InvoiceAssistant_JButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                InvoiceAssistant_JButton.setFont(new Font("微软雅黑",Font.BOLD,15));
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                InvoiceAssistant_JButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                InvoiceAssistant_JButton.setFont(new Font("微软雅黑",Font.PLAIN,15));
                super.mouseExited(e);
            }
        });

        ReadDaily_JButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                ReadDaily_JButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                ReadDaily_JButton.setFont(new Font("微软雅黑",Font.BOLD,15));
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                ReadDaily_JButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                ReadDaily_JButton.setFont(new Font("微软雅黑",Font.PLAIN,15));
                super.mouseExited(e);
            }
        });

        greetingCard_JButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                greetingCard_JButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                greetingCard_JButton.setFont(new Font("微软雅黑",Font.BOLD,15));
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                greetingCard_JButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                greetingCard_JButton.setFont(new Font("微软雅黑",Font.PLAIN,15));
                super.mouseExited(e);
            }
        });

        documentation_JButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                documentation_JButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                documentation_JButton.setFont(new Font("微软雅黑",Font.BOLD,15));
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                documentation_JButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                documentation_JButton.setFont(new Font("微软雅黑",Font.PLAIN,15));
                super.mouseExited(e);
            }
        });
    }
}
