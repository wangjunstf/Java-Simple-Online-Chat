package UI;


import sql.Sql;
import tools.ExistJudge;
import tools.MyMd5;
import tools.ExistJudge;

import javax.swing.*;
import java.awt.event.*;


class Login extends JFrame{
    private String name;
    private String passwd;

    //组件
    private JLabel titleLabel = new JLabel(new ImageIcon("/Users/wangjun/java/wechat/source/back.jpg"));//标题图片
    private JTextField nameField = new JTextField("输入账号");
    private JPasswordField passField = new JPasswordField("输入密码*********");
    private JButton login = new JButton("登录");
    private JButton register = new JButton("注册");
    private JFrame tFrame = this;  //指代本窗口
    Sql sql;
    Register registerFrame;
    Login(){
        init();
        addComponent();
        addListener();
    }

    //初始化登录界面
    private void init(){
        this.setTitle("加密通信系统");
        this.setSize(670,377);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sql = new Sql();  //数据库对象
    }

    //添加组件
    private void addComponent(){
        this.setLayout(null);
        //输入账号
        nameField.setBounds(230,121,209,35);
        this.add(nameField);

        //输入密码
        passField.setBounds(230,171,209,35);
        this.add(passField);

        //登录按钮
        login.setBounds(263,221,55,35);
        this.add(login);

        //注册按钮
        register.setBounds(351,221,55,35);
        this.add(register);

        titleLabel.setBounds(0,0,670,377);
        this.add(titleLabel);
        this.setVisible(true);
    }



    //添加事件
    private void addListener(){
        nameField.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if(nameField.getText().equals("输入账号"))
                    nameField.setText("");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                if(nameField.getText().equals("")){
                    nameField.setText("输入账号");
                }
            }
        });


        passField.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if(passField.getText().equals("输入密码*********"))
                    passField.setText("");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                if(passField.getText().equals("")){
                    passField.setText("输入密码*********");
                }
            }
        });

        login.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                String currentPasswd = MyMd5.getMd5(passField.getText());
                ExistJudge existName = new ExistJudge(sql);
                if(existName.existJudge(nameField.getText())){
                    if(currentPasswd.equals(existName.getPasswd(nameField.getText()))){
                        new ShowDialog(tFrame).showMessage("登录成功");
                    }else{
                        new ShowDialog(tFrame).showMessage("密码错误");
                    }
                }else{
                    new ShowDialog(tFrame).showMessage("用户名或密码错误");
                }


//                if(new ExistJudge(nameField.getText(), sql).existJudge(nameField.getText())){
//                    new ShowDialog(tFrame).showMessage("用户存在");
//                }
//                if(existJudge(nameField.getText()))


            }
        });

        register.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                new Register(sql);
            }
        });

    }

}

public class Main {

    public static void main(String[] args) {
        Login login = new Login();

    }
}




//import java.awt.*;
//import javax.swing.*;
//
////方法1:通过在JFrame中添加一个JPanel，背景图片放在JPanel上来实现
//public class Main extends JFrame         //默认的事BorderLayout
//{
//    //创建一个容器
//    Container ct;
//    //创建背景面板。
//    BackgroundPanel bgp;         //自定义的背景类
//
//    //创建一个按钮，用来证明我们的确是创建了背景图片，而不是一张图片。
//    JButton jb;
//    public static void main(String[] args)
//    {
//        new Main();
//    }
//    public Main()
//    {
//        //不采用任何布局方式。
//        ct=this.getContentPane();
//        this.setLayout(null);
//
//        //重新绘制背景图片
//        bgp=new BackgroundPanel((new ImageIcon("/Users/wangjun/java/wechat/source/jiami.jpeg")).getImage()); //参数是一个Image对象,
//        bgp.setBounds(0,0,480,380);
//        ct.add(bgp);
//
//        //创建按钮
//        jb=new JButton("测试按钮");
//        jb.setBounds(60,30,160,30);
//        ct.add(jb);
//
//        this.setSize(480,380);
//        this.setLocation(400,300);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setVisible(true);
//    }
//}
//class BackgroundPanel extends JPanel
//{
//    Image im;
//    public BackgroundPanel(Image im)
//    {
//        this.im=im;
//        this.setOpaque(true);                    //设置控件不透明,若是false,那么就是透明
//    }
//    //Draw the background again,继承自Jpanle,是Swing控件需要继承实现的方法,而不是AWT中的Paint()
//    public void paintComponent(Graphics g)       //绘图类,详情可见博主的Java 下 java-Graphics
//    {
//        super.paintComponents(g);
//        g.drawImage(im,0,0,this.getWidth(),this.getHeight(),this);  //绘制指定图像中当前可用的图像。图像的左上角位于该图形上下文坐标空间的 (x, y)。图像中的透明像素不影响该处已存在的像素
//
//    }
//}


