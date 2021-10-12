package UI;

import sql.Sql;
import tools.MyMd5;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Register extends JFrame {
    private JLabel nameLabel = new JLabel("账号");
    private JLabel passLabel = new JLabel("密码");
    private JLabel passLabel2 = new JLabel("确认");
    private JTextField nameField = new JTextField();
    private JPasswordField passField = new JPasswordField();
    private JPasswordField passField2 = new JPasswordField();
    private String bestPasswd; //加密后的密码
    Sql sql;

    private JButton register = new JButton("注册");

    //判断该用户是否存在
    private boolean existJudge(String n){
        ResultSet res =  sql.getResult("select * from user where name = \""+n+"\"");
        try {
            if(res.next()){
                //如果存在数据，返回true
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    Register(Sql sql){
        this.sql = sql;
        init();
        addComponent();
        addListener();
    }

    private void init(){
        this.setTitle("注册账号");
        this.setSize(470,350);
        this.setLocationRelativeTo(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(2);
    }

    private void addComponent(){
        this.setLayout(null);
        nameLabel.setBounds(105,80,50,35);
        this.add(nameLabel);

        nameField.setBounds(150,80,209,35);
        this.add(nameField);

        //密码提示框
        passLabel.setBounds(105,135,50,35);
        this.add(passLabel);

        //密码输入框
        passField.setBounds(150,135,209,35);
        this.add(passField);

        //密码确认
        passLabel2.setBounds(105,190,50,35);
        this.add(passLabel2);

        //密码确认输入
        passField2.setBounds(150,190,209,35);
        this.add(passField2);

        register.setBounds(210,245,75,35);
        this.add(register);
        this.setVisible(true);
    }

    JFrame Tframe = this; //零时对象

    public String getPrimaryName(String str) {
        return "\""+str +"\"";
    }
    private void addListener(){
        register.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if(nameField.getText().equals("") || passField.getText().equals("") ){
                    new ShowDialog(Tframe).showMessage("用户名或密码不能为空");
                }else if(!passField.getText().equals(passField2.getText())){
                    new ShowDialog(Tframe).showMessage("密码不一致");
                }else{
                    if(existJudge(nameField.getText())){
                        new ShowDialog(Tframe).showMessage("用户已存在");
                    }else{
                        if(new ShowDialog(Tframe).showMessage("注册就绪，请确认")){
                            bestPasswd = MyMd5.getMd5(passField.getText());
                            String s = "insert into user values ("+getPrimaryName(nameField.getText())+','+getPrimaryName(bestPasswd)+")";
                            sql.executeSql(s);
//                            new ShowDialog(Tframe).showMessage("注册成功");
                            Tframe.setVisible(false);


                        }else{
                            System.out.println("用户已经退出");
                        }


                    }

                }
            }
        });
        register.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {


            }
            @Override
            public void mouseReleased(MouseEvent e) {

            }
            @Override
            public void mouseEntered(MouseEvent e) {

            }
            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    public static void main(String[] args){
        new Register(new Sql());
    }
}

