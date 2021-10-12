package serve;

import tools.JudgeOnline;
import tools.MyJson;

import java.io.*;
import java.net.Socket;


/**
 * 为每一个请求连接的用户创建一个线程
 */

public class ServerThread extends Thread{
    private Socket socket;    //线程中的处理对象
    private OutputStream out; //输出流对象
    private InputStream in;
    private String name;


    public ServerThread(Socket socket){
        this.socket = socket;
    }

    public void sendMsg(String msg){
        try {
            out.write(msg.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public String getUserName(){
        return name;
    }

    public void run() {
        try {
            // 获取输入 输出流，用于接收消息与发送消息
            in = socket.getInputStream();
            out = socket.getOutputStream();

            BufferedReader brd = new BufferedReader(new InputStreamReader(in));
            MyJson myJson = new MyJson();
            MsgMange mange;
            String msg = brd.readLine();
            while(msg!=null){  //用于接收客户端发送来的每一条消息
                System.out.println(msg);  //打印收到的每条消息
                Information info = null;
                info = myJson.toInfo(msg);
                mange = new MsgMange(info);
                if(info.getType().equals("chat")){
                    mange.chatMsg();
                } else if(info.getType().equals("login")){
                    name = info.getSrc();
                    serve.OnlineUser.addClient(info.getSrc(),this);
                    System.out.print("此时在线用户:");
                    System.out.println(OnlineUser.onlineMap);
                } else if(info.getType().equals("add")){
                    mange.addFriend();
                }else if(info.getType().equals("leave")){
                    break;
                }
                msg = brd.readLine();
            }
            OnlineUser.onlineMap.remove(name);
            closeMe();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //关闭当前客户机与服务器的连接。
    public void closeMe() throws IOException {
        in.close();
        out.close();
        socket.close();
    }

}