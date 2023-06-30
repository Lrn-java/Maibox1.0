package Maibox.li.Sidebar;

import Maibox.li.Windows.MainInterfaceProperties;

import static java.lang.System.out;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

/**
 * 这个类是文件中转站属性
 */
public class FileRelovationPanel implements MainInterfaceProperties {


    private final JPanel FileRelocationPanel = new JPanel();
    //搜索框
    private final JTextField Search = new JTextField();
    //上传按钮
    private final JButton upload = new JButton("上传");

    //设置文件中转站标签的属性及样式最终添加到面板中
    private final JLabel FileRelocation = new JLabel("文件中转站·1");

    //四个按钮，分别是：发送，续期，下载，删除
    private final JButton Send = new JButton();
    private final JButton Renewal = new JButton();
    private final  JButton Download = new JButton();
    private final  JButton Delete = new JButton();
    /**
     * 文件中转站方法，这个方法中是文件中转站的方法
     */
    public void setFileRelocation() {
        FileRelocationPanel.setBounds(240, 140, 1394, 870);
        FileRelocationPanel.setBackground(Color.white);
        FileRelocationPanel.setLayout(null);

        //先移除面板
        M_J_FRAME.remove(M_J_PANEL);
        Container CONTAINER = M_J_FRAME.getContentPane();
        CONTAINER.add(FileRelocationPanel,null);
        M_J_FRAME.revalidate();
        M_J_FRAME.repaint();


        FileRelocation.setBounds(20,10,130,30);
        FileRelocation.setFont(new Font("微软雅黑",Font.BOLD,18));
        FileRelocationPanel.add(FileRelocation);

        //设置上传按钮属性及样式

        upload.setBackground(new Color(0x328FFA));
        upload.setForeground(new Color(0xFFFFFF));
        upload.setBounds(1050,27,70,30);
        upload.setFont(new Font("微软雅黑",Font.BOLD,15));
        FileRelocationPanel.add(upload);

        //设置文件中转站的搜索框
        Search.setText("🔍搜索");
        Search.setBounds(1150,30,210,25);
        FileRelocationPanel.add(Search);

        //设置一个淡蓝色的面板，这个面板中有一个选择框，四个按钮
        JPanel jPanel = new JPanel();
        jPanel.setBounds(20,70,1360,50);
        jPanel.setBackground(new Color(0xE3ECFA));
        FileRelocationPanel.add(jPanel);

        //发送按钮
        Send.setBounds(70,80,70,30);
        Send.setText("发送");
        Send.setBackground(new Color(0xFFFFFF));
        Send.setForeground(new Color(0x000000));
        Send.setFont(new Font("微软雅黑",Font.PLAIN,16));
        FileRelocationPanel.add(Send);
        //强制重绘10次
        for(int i = 0;i<5;i++){
                Send.requestFocus();
        }

        //续期按钮
        Renewal.setBounds(150,80,70,30);
        Renewal.setText("续期");
        Renewal.setBackground(new Color(0xFFFFFF));
        Renewal.setForeground(new Color(0x000000));
        Renewal.setFont(new Font("微软雅黑",Font.PLAIN,16));
        FileRelocationPanel.add(Renewal);
        //强制重绘10次
        for(int i = 0;i<5;i++){
            Renewal.requestFocus();
        }

        //下载按钮
        Download.setBounds(230,80,70,30);
        Download.setText("下载");
        Download.setBackground(new Color(0xFFFFFF));
        Download.setForeground(new Color(0x000000));
        Download.setFont(new Font("微软雅黑",Font.PLAIN,16));
        FileRelocationPanel.add(Download);
        //强制重绘10次
        for(int i = 0;i<5;i++){
            Download.requestFocus();
        }


        //删除按钮
        Delete.setBounds(310,80,70,30);
        Delete.setText("删除");
        Delete.setBackground(new Color(0xFFFFFF));
        Delete.setForeground(new Color(0x000000));
        Delete.setFont(new Font("微软雅黑",Font.PLAIN,16));
        FileRelocationPanel.add(Delete);
        //强制重绘10次
        for(int i = 0;i<5;i++){
            Delete.requestFocus();
        }

        //类型标签坐标及风格
        JLabel Type = new JLabel();
        Type.setText("类型");
        Type.setBounds(70,120,50,40);
        Type.setFont(new Font("微软雅黑",Font.PLAIN,15));
        FileRelocationPanel.add(Type);

        //文件名标签坐标及风格
        JLabel Filename = new JLabel();
        Filename.setText("文件名");
        Filename.setBounds(120,120,50,40);
        Filename.setFont(new Font("微软雅黑",Font.PLAIN,15));
        FileRelocationPanel.add(Filename);

        JLabel Size = new JLabel();
        Size.setText("大小");
        Size.setBounds(920,120,50,40);
        Size.setFont(new Font("微软雅黑",Font.PLAIN,15));
        FileRelocationPanel.add(Size);

        //过期时间
        JLabel ExpirationTime = new JLabel();
        ExpirationTime.setText("过期时间");
        ExpirationTime.setBounds(1020,120,80,40);
        ExpirationTime.setFont(new Font("微软雅黑",Font.PLAIN,15));
        FileRelocationPanel.add(ExpirationTime);

        //下载次数
        JLabel NumberOfDownloads = new JLabel();
        NumberOfDownloads.setText("下载次数");
        NumberOfDownloads.setBounds(1150,120,80,40);
        NumberOfDownloads.setFont(new Font("微软雅黑",Font.PLAIN,15));
        FileRelocationPanel.add(NumberOfDownloads);

        /*
         * 这段代码是预留问题，也算预留思路，待完成
         */
        JLabel Lines_One = new JLabel();
        JLabel Lines_Two = new JLabel();

        Lines_One.setText("———————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————");
        Lines_One.setBounds(25,160,1345,20);
        Lines_One.setBackground(new Color(255,255,255,0));
        Lines_One.setForeground(Color.GRAY);
        FileRelocationPanel.add(Lines_One);

        Lines_One.setText("———————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————");
        Lines_One.setBounds(25,200,1345,20);
        Lines_One.setBackground(new Color(255,255,255,0));
        Lines_One.setForeground(Color.GRAY);
        FileRelocationPanel.add(Lines_One);

        setUpload();
        setSearch();
    }

    /**
     * 当点击文件中转站后，弹出文件中转站画面
     */
    public void FileRelocation_JButton(){
        FileRelocation_JButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setFileRelocation();
                super.mouseClicked(e);
            }
        });

    }

    /**
     * 这个方法是用来移除文件中转站面板
     */
    public void remove(){
        //创建新面板
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);
        jPanel.setBounds(240, 140, 1394, 870);

        //删除文件中转站，并绘制新面板
        M_J_FRAME.remove(FileRelocationPanel);
        Container CONTAINER = M_J_FRAME.getContentPane();
        CONTAINER.add(jPanel,null);

        //重新获取
        M_J_FRAME.revalidate();//绘制新面板
        M_J_FRAME.repaint();
    }

    /**
     * 1.来源位置：文件中转站面板中
     * 2.按钮名：上传
     * 3.按钮监听操作：点击这个按钮后会获取用户磁盘，并弹出对话框，供用户选择
     */
    public void setUpload(){
        upload.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //窗体
                final JFrame jFrame = new JFrame();

                jFrame.setBounds(300,500,300,300);
                JFileChooser fileChooser = new JFileChooser();

                int result = fileChooser.showOpenDialog(jFrame);

                //如果用户选择了文件，将文件添加到面板中
                if (result == JFileChooser.APPROVE_OPTION) {
                    out.println("选择的路径:"+fileChooser.getSelectedFile().getAbsolutePath());
                }
                jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                jFrame.pack();
                super.mouseClicked(e);
            }
        });
    }

    /**
     * 文件中转站搜索框样式
     */
    public void setSearch(){
        Search.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Search.setText("");
                super.mouseClicked(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if(Search.getText().length() == 0){
                    try {
                        Thread.sleep(120);
                        Search.setText("🔍搜索");   //等待0.12秒
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                super.mouseExited(e);
            }
        });
    }

}