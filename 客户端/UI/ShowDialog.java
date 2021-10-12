package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowDialog{
    private JDialog warning = new JDialog();
    private JLabel message = new JLabel();
    private JButton ok = new JButton("确定");
    private JFrame frame = new JFrame();
    private boolean flag = false; //确认注册标志

    ShowDialog(JFrame f){
        frame = f;

    }

    //测试main方法
    public static void main(String[] args){
//        JFrame f = new JFrame();
        ShowDialog s = new ShowDialog(null);
        s.showMessage("该用户名可以注册，请确认");
    }




    public boolean showMessage(String msg){
        warning = new JDialog(this.frame);
        message.setText(msg);
        //设置对话框属性
        warning.setLayout(new FlowLayout());
        warning.setSize(340,160);
        //设置居中
        warning.setLocationRelativeTo(null);

        //设置警告消息
        message.setBounds(10,50,50,40);
        warning.add(message);
        ok.setBounds(70,70,55,35);
        warning.add(ok);

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag = true;
                warning.setVisible(false);
            }
        });

        //设置为模式对话框
        warning.setModal(true);
        warning.setVisible(true);
        return flag;


    }
}
