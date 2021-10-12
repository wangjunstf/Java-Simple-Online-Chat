package serverTools;

import tools.JudgeOnline;
import tools.MyJson;

import javax.swing.plaf.synth.SynthLookAndFeel;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class TcpClient{
    private static final int PORT =  8843;
    private String serverIP="127.0.0.1";

    private Socket socket=null;            //用于获得链接
    private InputStream in=null;           //进来的流(接收来自服务器的消息)
    private OutputStream out=null;         //出去的流(将消息送往服务器)



    TcpClient(){
        try {
            socket=new Socket(serverIP,PORT);        //建立连接
            out = socket.getOutputStream();
            in = socket.getInputStream();
            new ClientThread(in).start();   //开启客户端监听消息

            SendMsg sendMsg = new SendMsg(out);

            Scanner scan = new Scanner(System.in);
            String name;
            String friend;
            String msg;
            System.out.println("请输入你的用户名：");
            name = scan.nextLine();
            sendMsg.sendloginMsg(name);
            int a;
            System.out.println("1:发送消息");
            System.out.println("2:添加好友");
            System.out.println("3:退出");

            while(true){
                System.out.println("请输入操作序号:");
                a = scan.nextInt();
                if(a==1){
                    System.out.println("请输入好友名称:");
                    String t = scan.nextLine();
                    friend = scan.nextLine();
                    System.out.println("请输入消息内容:");
                    msg = scan.nextLine();
                    sendMsg.sendChatMsg(name,friend,msg);
                }

                if(a==2){
                    System.out.println("请输入好友名称:");
                    String t = scan.nextLine();
                    friend = scan.nextLine();
                    sendMsg.sendAddFriendMsg(name,friend);
                }

                if(a==3){
                    sendMsg.sendLeave(name);
                    break;
                }
            }
            System.out.println("你已经退出:");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Socket getSocket(){
        return socket;
    }

    public void tcpClose(){
        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String []args) throws IOException {
        TcpClient client = new TcpClient();

    }


}
