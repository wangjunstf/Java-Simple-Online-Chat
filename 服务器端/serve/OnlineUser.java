package serve;

import serve.ServerThread;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;


public class OnlineUser {
    //保存在线用户和对应线程
    public static HashMap<String, ServerThread> onlineMap = new HashMap<String, ServerThread>();

    //该方法无需定义实例对象
    private OnlineUser(){}

    public static void addClient(String name,ServerThread st){
        onlineMap.put(name,st);
        if(MsgStore.offMapMsg.containsKey(name)){
            Queue<String> t = MsgStore.offMapMsg.get(name);
            while(!t.isEmpty()){
                st.sendMsg(t.poll());
            }

        }
        System.out.println(name+"已经上线");
    }

    public static boolean isOnline(String name){
        if(onlineMap.containsKey(name)){
            return true;   //存在，即在线
        }else{
            return true;    //不存在，即不在线
        }

    }

}