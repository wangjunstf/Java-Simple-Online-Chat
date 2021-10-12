package tools;

import com.mysql.cj.xdevapi.JsonArray;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import serverTools.Information;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MyJson {

    //对象转字符串
    public String toString(Information info){
        JSONObject json = new JSONObject();
        json.put("inforType",info.getType());
        json.put("srcName",info.getSrc());
        json.put("dstName",info.getDst());
        json.put("info",info.getInfo());
        String str = json.toString()+"\r\n";
        return str;

    }

    //字符串转对象
    public Information toInfo(String str){
        str = str.substring(0,str.length());
        Information info = new Information("","","","");
        JSONParser parser=new JSONParser();
        try {
            Object obj = parser.parse(str);
            JSONObject json = (JSONObject)obj;
            info.setType(json.get("inforType").toString());
            info.setSrc(json.get("srcName").toString());
            info.setDst(json.get("dstName").toString());
            info.setInfo(json.get("info").toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return info;
    }

    //测试用main方法
    public static void main(String[] args){
        Information in =new Information("1","2","3","4");
        String s = new MyJson().toString(in);
        System.out.println(s);

        Information next = new MyJson().toInfo(s);
        String t = new MyJson().toString(next);

        System.out.println(t);
        System.out.println("sdfsdf");

//        String s = "Hello world\r\n";
//        String t = "Hello world";
//        System.out.println(s.length());
//        System.out.println(t.length());
//
//        System.out.println(s);
//        System.out.println(t);
//
//        System.out.println(s.substring(0,s.length()-2));
//        System.out.println(t);

    }
}