package UI;

import loginUI.AddFriend;
import serverTools.TcpClient;
import sql.Sql;
import loginUI.LoginDialog;
import test.MakePanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;


class CrollPane extends JFrame{
    private JPanel contentPane;
    private JScrollPane scrollPane;
    private JTextArea textArea;
    JPanel MainPanel = new JPanel();

    private void initMainPanel(){
        MainPanel.setSize(588,577);
        MainPanel.setLayout(new BorderLayout());
    }

    public CrollPane(){
        contentPane=new JPanel();  //内容
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        contentPane.setLayout(new BorderLayout(0,0));
        this.setContentPane(contentPane);
        scrollPane=new JScrollPane();
        contentPane.add(scrollPane,BorderLayout.CENTER);





        //------ 一个panel
        JPanel myPanel = new JPanel();
        myPanel.setLayout(new BorderLayout());
        myPanel.setSize(500,577);

        JTextArea text = new JTextArea();
        text.setSize(588,577);


        myPanel.add(text,BorderLayout.CENTER);


        scrollPane.setViewportView(myPanel);




        this.setTitle("聊天界面");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 500, 577);
        this.setVisible(true);
    }
    public static void main(String []args){

        loginUI.CrollPane example=new loginUI.CrollPane();
    }
}

public class MainChatWin extends JFrame {
    String name;
    Sql sql;

    //组件
    JButton addFriend = new JButton("添加好友");
    JPanel left;

    public MainChatWin(String name){
        init();
        addcomponent();
    }

    private void init(){
        this.setTitle("聊天界面");
        this.setLayout(new BorderLayout());
        this.setSize(870,577);
        this.setLocationRelativeTo(null);
//        this.setResizable(false);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void  addcomponent(){
        JButton b1 = new JButton("1");

        JButton b2 = new JButton("左边");
        JPanel left = new JPanel();
        left.setSize(200,600);
        left.add(b2);
        left.setLayout(new GridLayout(20,1));
        for(int i=0;i<10;i++){
            JButton b = new JButton(""+i);
            left.add(b);
        }


        JButton b3 = new JButton("3");
        JButton b4 = new JButton("4");

        JButton b5 = new JButton("5");
        JTextArea chatText = new JTextArea();


        this.add(b1,BorderLayout.EAST);
        this.add(left,BorderLayout.WEST);
        this.add(b3,BorderLayout.SOUTH);
        this.add(b4,BorderLayout.NORTH);
        this.add(chatText,BorderLayout.CENTER);

        this.setVisible(true);

    }








//    private void addCommponent(){
//        left = new JPanel();
//        left.setLayout(new FlowLayout());
//        left.setSize(200,577);
//
//        this.add(left,BorderLayout.WEST);
//
//        for(int i=0;i<10;i++){
//            JButton b = new JButton(""+i);
//            left.add(b);
//
//        }
//
//    }


    public static void main(String [] args)  {
        MainChatWin win = new MainChatWin("王俊");

    }
}
