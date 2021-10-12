package serve;
import java.util.*;

/**
 * 当用户不在线时，可以作为消息缓冲器
 */
public class MsgStore {
    public static HashMap<String, Queue<String>> offMapMsg = new HashMap<String, Queue<String>>();

    private void MsgMange(){}

    public static void add(String name,String msg){
        if(offMapMsg.containsKey(name)){
            Queue<String> q = offMapMsg.get(name);
            q.offer(msg);
        }else{
            Queue<String> queue =new LinkedList<String>();
            offMapMsg.put(name,queue);
            queue.offer(msg);
        }
        System.out.println("已添加"+name+"的离线消息 "+msg);
    }
    public static void main(String[] args){

        HashMap<String,String> map = new HashMap<String, String>();
        map.put("a","1");
        map.put("b","2");
        map.put("c","3");

        System.out.println(map);
        map.remove("a");
        System.out.println(map);

    }
}
