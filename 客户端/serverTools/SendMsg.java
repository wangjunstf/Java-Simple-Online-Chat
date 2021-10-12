package serverTools;

import tools.MyJson;

import java.io.IOException;
import java.io.OutputStream;

public class SendMsg {
    private OutputStream out;

    public SendMsg(OutputStream out){
        this.out = out;
    }
    public void sendloginMsg(String myName){
        Information infom = new Information("login",myName," "," ");
        String msg;
        msg = new MyJson().toString(infom);
        try {
            out.write(msg.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendLeave(String myName){
        Information infom = new Information("leave",myName,"","");
    }

    public void sendChatMsg(String myName,String friendName,String message){
        Information infom = new Information("chat",myName,friendName,message);
        String msg;
        msg = new MyJson().toString(infom);
        try {
            out.write(msg.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendAddFriendMsg(String myName,String friendName){
        Information infom = new Information("add",myName,friendName,"请求添加你为好友");
        String msg;
        msg = new MyJson().toString(infom);
        try {
            out.write(msg.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
