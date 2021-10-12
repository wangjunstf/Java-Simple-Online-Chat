package serverTools;

import tools.MyJson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class ClientThread extends Thread {
    private InputStream in;

    public ClientThread(InputStream in){
        this.in = in;
    }

    public void run(){
        try {
            BufferedReader brd = new BufferedReader(new InputStreamReader(in));
            String msg = brd.readLine();
            while(msg!=null){
                Information info = new MyJson().toInfo(msg);
                if(info.getType().equals("add")){
                    System.out.println("              ----------------------"+info.getSrc()+"请求添加你为好友----------------------");
                }else if(info.getType().equals("chat")){
                    System.out.println("              ----------------------你收到"+info.getSrc()+"的消息: "+info.getInfo()+"----------------------");
                }
//                System.out.println(msg);
                msg = brd.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

