package tools;

import serve.ServerThread;

import java.io.IOException;
import java.net.Socket;

public class JudgeOnline extends Thread{
    private Socket socket;    //线程中的处理对象

    public JudgeOnline(Socket socket){
        this.socket = socket;
    }

    public void run(){
//        while(true){
//            if(isServerClose(socket)){//打开连接
//                try {
//                    new ServerThread(socket).closeMe();
//                    System.out.println("用户退出");
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//
//        }
    }

    private Boolean isServerClose(Socket socket){
        try{
            socket.sendUrgentData(0xFF);//发送1个字节的紧急数据，默认情况下，服务器端没有开启紧急数据处理，不影响正常通信
            return false;
        }catch(Exception se){
            return true;
        }
    }
}
