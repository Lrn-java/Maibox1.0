package Maibox.li.Windows;

import Maibox.li.GetData.RegistrationInformation;
import Maibox.li.Sidebar.LeftButton;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

import static java.lang.System.out;


/**
 * @author Lrn
 */
public class LoginScreen implements Login,RegistrationInterface,RegistrationInformation,MainInterfaceProperties,Runnable{


    final int[] LEN = new int[]{0,6,16};
    public LoginScreen() {
        this.setJframe();
        this.setLoginButton();         //登录按钮
        this.setEnrollButton();        //注册按钮
        this.confirmSave();
        this.getLeftButton();          //文件中转站
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
        SIGN_BUTTON.addMouseListener(  new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mainInterface();
                textField();
                titleBar();
                menuBarOne();
                menuBarTwo();
                menuBarThree();
                setLines();

                run();    //线程开启
                super.mouseClicked(e);
                J_FRAME.setVisible(false);
            }
        });
            //登录成功后关闭登录界面
    }

    /**
     * 这个方法用来重写左侧按钮的所有监听
     */
    private void getLeftButton(){
        new LeftButton().FileRelocation_JButton();
    }
    /*
    这个方法是一个输入正文的方法监听方法
     */
    @Override
    public void titleBar() {
        M_J_TEXT_AREA.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                M_J_TEXT_AREA.setText("");
                super.mouseClicked(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //计数器
                int count = M_J_TEXT_AREA.getText().length();
                if(count == 0){
                    try {
                        //等待0.12秒
                        Thread.sleep(120);
                        M_J_TEXT_AREA.setText("输入正文");
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                super.mouseExited(e);
            }
        });
        MainInterfaceProperties.super.titleBar();
    }

    /**
     * 搜索框的属性
     */
    @Override
    public void run() {
        M_J_TEXT_FIELD.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                M_J_TEXT_FIELD.setText("");
                super.mouseClicked(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                try {
                    if(M_J_TEXT_FIELD.getText().length() == 0){
                        Thread.sleep(120);          //等待0.12秒
                        M_J_TEXT_FIELD.setText("🔍搜索");
                    }
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                super.mouseExited(e);
            }
        });
    }
    /**
     * 注册按钮
     */
    @Override
    public void setEnrollButton() {
        Login.super.setEnrollButton();
        REGISTRATION_BUTTON.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setRegistrationInterface();
                super.mouseClicked(e);
            }
        });
    }

    //注册界面
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

                int len = R_J_TEXT_FIELD1.getText().length();
                /**
                  *判断用户信息注册的长度是否合法，若合法则进行下一项
                  *长度合法后就写入数据库中
                  *写入数据库中时将所有的文本框内容都清空
                  */
                if (len > LEN[0] && len <= LEN[1] &&
                        passwordO.length() >= LEN[1] && passwordO.length() <= LEN[2] &&
                        passwordO.equals(passwordT)) {

                        getMassage(R_J_TEXT_FIELD1.getText(),passwordT);
                        JOptionPane.showMessageDialog(null,"注册成功!","",JOptionPane.WARNING_MESSAGE);

                        //清除注册后文本框中所有信息
                        R_J_TEXT_FIELD1.setText("");
                        R_J_PASSWORD_FIELD1.setText("");
                        R_J_PASSWORD_FIELD2.setText("");
                        R_J_FRAME.setVisible(false);   //隐藏窗口
                } else {
                    try {
                        String errorMessage = "用户信息无效！\n" +
                                "用户名长度必须为 1-3 个字符,密码长度必须介于 6 到 16 个字符之间,两次密码必须一致!";
                        //清空注册框中的密码信息
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
            public void mouseClicked(MouseEvent e) {
                mainInterface();                 //点击写邮件后发生的操作
                super.mouseClicked(e);
            }

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
                //窗体
                JFrame jFrame = new JFrame();

                //标签
                JLabel jLabel_One = new JLabel();
                jLabel_One.setText("添加超大附件");
                jLabel_One.setBounds(50,5,130,20);
                jLabel_One.setFont(new Font("微软雅黑",Font.PLAIN,16));

                jFrame.setBounds(700, 280, 520, 500);
                jFrame.getContentPane().setBackground(Color.WHITE);
                jFrame.setLayout(null);
                jFrame.setResizable(false);
                jFrame.setUndecorated(false);
                jFrame.setVisible(true);

                JLabel jLabel_Two = new JLabel();
                jLabel_Two.setText("扩展后可上传10G大文件，获得2T超大存储空间");
                jLabel_Two.setBounds(50,25,260,20);
                //容器
                Container container = jFrame.getContentPane();
                //面板
                JPanel m_jPanel = new JPanel();
                JPanel s_jPanel = new JPanel();

                m_jPanel.setLayout(null);
                m_jPanel.setBounds(0,0,520,500);
                m_jPanel.setBackground(Color.white);
                m_jPanel.add(jLabel_One);
                m_jPanel.add(jLabel_Two);

                s_jPanel.setBounds(50,50,400,375);
                s_jPanel.setBackground(new Color(0xFAFAFAFA, true));
                s_jPanel.setLayout(null);

                m_jPanel.add(s_jPanel);

                container.add(m_jPanel);

                JButton jButton_on = new JButton();
                JButton jButton_open = new JButton();

                jButton_on.setBounds(105,95,180,30);
                jButton_on.setBackground(new Color(0x328FFA));
                jButton_on.setForeground(new Color(0xFFFFFF));
                jButton_on.setText("上传本地文件");
                jButton_on.setFont(new Font("微软雅黑",Font.PLAIN,15));
                s_jPanel.add(jButton_on);

                jButton_open.setBounds(105,225,180,30);
                jButton_open.setBackground(new Color(0x328FFA));
                jButton_open.setForeground(new Color(0xFFFFFF));
                jButton_open.setText("从文件中转站中选择");
                jButton_open.setFont(new Font("微软雅黑",Font.PLAIN,15));
                s_jPanel.add(jButton_open);

                JLabel jLabel = new JLabel("———————————————————————");
                jLabel.setBounds(55,160,300,20);
                s_jPanel.add(jLabel);

                //上传本地文件按钮监听事件
                jButton_on.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        JFrame frame = new JFrame();
                        frame.setBounds(300,500,300,300);

                        // 创建文件选择器对象
                        JFileChooser fileChooser = new JFileChooser();

                        // 显示文件对话框并等待用户选择文件或目录
                        int result = fileChooser.showOpenDialog(frame);

                        //如果用户选择了文件，则将文件添加到面板中
                        if (result == JFileChooser.APPROVE_OPTION) {
                            File selectedFile = fileChooser.getSelectedFile();
                            JLabel jLabel4 = new JLabel(selectedFile.getName());
                            s_jPanel.add(jLabel4);
                            s_jPanel.revalidate();
                            s_jPanel.repaint();
                        }

                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        super.mouseClicked(e);
                    }
                });

                //从文件中转站点击按钮后触发的事件
                jButton_open.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {

                        super.mouseClicked(e);
                    }
                });

                /*
                 *预留思路
                 * 需要在这里做两个功能
                 * 添加超大文件按钮-点击这个按钮会直接打开磁盘管理器（所有文件都可查看）只有文件超过10G的才可被添加进去。
                 * 从文件中转站中选择-点击这个按钮会直接打开文件中转站中保存的文件。
                 */

                // 创建文件选择器对象
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

        /*
         图片按钮
         1.可以展示所有问价供用户选择
         2.可以更精确的使用户选择想要的图片格式
         */
        M_J_LABEL_THREE.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFrame frame = new JFrame();

                JFileChooser fileChooser = new JFileChooser();
                String[] Image_Format_Name = new String[]{"BMP", "JPG", "PNG", "TIF", "GIF", "PCX", "TGA", "EXIF", "FPX", "SVG",
                        "PSD", "CDR", "PCD", "DXF", "UFO", "EPS", "AI", "RAW","WMF","WEBP","AVIF","APNG"};

                String[] Image_Format = new String[Image_Format_Name.length];

                FileNameExtensionFilter[] filters = new FileNameExtensionFilter[Image_Format_Name.length];

                //设置图片格式筛选
                for (int i = 0; i < Image_Format_Name.length; i++) {
                    String formatName = Image_Format_Name[i];
                    String extension = formatName.toLowerCase();
                    Image_Format[i] = extension;
                    filters[i] = new FileNameExtensionFilter(formatName, extension);
                    fileChooser.setFileFilter(filters[i]);         //设置用户可以筛选图片格式jpg,png...
                }

                // 显示文件对话框并等待用户选择文件或目录
                int result = fileChooser.showOpenDialog(frame);

                // 如果用户选择了文件或目录，则打印选择的路径
                if (result == JFileChooser.APPROVE_OPTION) {
                    out.println("选择的路径：" + fileChooser.getSelectedFile().getAbsolutePath());
                }
                frame.pack();
                super.mouseClicked(e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                M_J_LABEL_THREE.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                M_J_LABEL_THREE.setFont(new Font("微软雅黑",Font.BOLD,15));
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                M_J_LABEL_THREE.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                M_J_LABEL_THREE.setFont(new Font("微软雅黑",Font.PLAIN,15));
                super.mouseExited(e);
            }
        });

        /*
         * 输入地址文本框监听效果
         */
            J_TEXT_FIELD_One.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    J_TEXT_FIELD_One.setText("");
                    super.mouseClicked(e);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    int count = J_TEXT_FIELD_One.getText().length();
                    if(count == 0) {
                        try {
                            Thread.sleep(120);    //等待0.12秒
                            J_TEXT_FIELD_One.setText("输入地址");
                        } catch (InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                    //不做任何操作
                }
            });

        /*
         * 输入文件的监听效果
         */
        M_J_TEXT_FIELD_Two.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                M_J_TEXT_FIELD_Two.setText("");
                super.mouseClicked(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                int count = M_J_TEXT_FIELD_Two.getText().length();    //计数器
                if(count == 0){
                    try {
                        Thread.sleep(120);
                        M_J_TEXT_FIELD_Two.setText("输入主题");
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }

                }
                super.mouseExited(e);
            }
        });
        /*
         *插入按钮重写
         */
        M_J_LABEL_FOUR.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
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