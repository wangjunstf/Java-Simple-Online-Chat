package tools;
import sql.Sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.ResultSet;


public class ExistJudge {
    private Sql sql;
    String name;
    public ExistJudge(Sql sql){
        this.sql = sql;
        this.name = name;
        //判断该用户是否存在

    }

    public boolean existJudge(String n){
        ResultSet res =  sql.getResult("select * from user where name = \""+n+"\"");
        try {
            if(res.next()){
                //如果存在数据，返回true
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public String getPasswd(String user){
        String sqlStr = "select * from user where name="+Tools.getPrimaryName(user);
        String netPasswd = null;
        ResultSet res = sql.getResult(sqlStr);
        try {
            res.next();
            netPasswd = res.getString(2);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return netPasswd;
    }


    //test用main方法
    public static void main(String[] args){

        ExistJudge existJudge = new ExistJudge(new Sql());
        System.out.println(existJudge.getPasswd("wangjun"));


//        System.out.println(existJudge.existJudge("wangjun"));
//        System.out.println(existJudge.existJudge("wangjund"));
        ;
    }


}
