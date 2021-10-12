package serve;

import tools.JudgeOnline;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class TcpServer{
    private static final int PORT = 8843;  //定义一个接口
    ServerSocket serverSocket=null;        //用于创建服务器端套接字
    Socket socket=null;                    //用于获得链接
    InputStream in=null;                   //进来的流(接收来自客户端的消息)
    OutputStream out=null;                 //出去的流(将消息送往客户端)

    TcpServer(){
        try {
            serverSocket=new ServerSocket(PORT);
            if(!serverSocket.isClosed()){
                System.out.println("服务器已经开启");
            }
            while(true){
                //为每一个客户端监听一个端口
                socket = serverSocket.accept();
                //启动一个线程去处理这个对象
                ServerThread st = new ServerThread(socket);
                st.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        TcpServer server = new TcpServer();
    }
}