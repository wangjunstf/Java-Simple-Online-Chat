package serve;

import tools.MyJson;


/**
 * 该类用于服务器端消息管理
 */
public class MsgMange {
    Information infor;
    ServerThread st;
    public MsgMange(Information info){
        this.infor = info;
    }


    //用于处理聊天消息
    public void chatMsg(){
        ServerThread st = serve.OnlineUser.onlineMap.get(infor.getDst());
        String msg = new MyJson().toString(infor);
        if(st!=null){     //如果在线的话
            st.sendMsg(msg);
        }else{            //如果不在线的话
            MsgStore.add(infor.getDst(),msg);
        }

    }

    //用于处理添加好友
    public void addFriend(){
        ServerThread st = serve.OnlineUser.onlineMap.get(infor.getDst());
        if(st!=null){//说明用户在线
//            System.out.println(infor.getDst()+"在线");
            String msg = new MyJson().toString(infor);
            st.sendMsg(msg);
        }else{       //不在线
            MsgStore.add(infor.getDst(),new MyJson().toString(infor));
            System.out.println("你请求添加的好友"+ infor.getDst()+"不在线,已将消息存入离线消息");
        }
    }



}
