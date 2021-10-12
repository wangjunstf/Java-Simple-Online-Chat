package sql;

import java.sql.*;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Sql{
    //数据库地址
    private static final String url = "jdbc:MySQL://104.225.149.243:3306/chat";
    //jdbc驱动
    private static final String name = "com.mysql.jdbc.Driver";
    //用户名
    private static final String user = "root";
    //数据库密码
    private static final String password = "Wj19980619#";

    //建立连接
    Connection conn;

    //查询结果
    ResultSet rs;
    //执行查询
    Statement stmt;


    public Sql(){
        //加载jdbc驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //连接数据库
            conn = DriverManager.getConnection(url,user,password);
            stmt = conn.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    //测试用main方法
    public static void main(String[] args){
        Sql sql = new Sql();
        System.out.println("测试建表");
        sql.executeSql("create table user (name varchar(15) primary key,passwd varchar(20))");
        System.out.println("建表成功");

    }

    public boolean sqlStatus(){
        boolean flag = false;
        try {
            flag = conn.isClosed();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return flag;

    }

    public ResultSet getResult(String sql){
        try {
            //创建Statement,用于执行sql语句

            if(!conn.isClosed()){
                System.out.println("数据库连接成功");
            }else{
                System.out.println("数据库连接失败");
            }
            rs = stmt.executeQuery(sql);
            return rs;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public boolean executeSql(String sql){
        try {
            return stmt.execute(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public void closeSql(){
        if(rs!=null){
            try {
                rs.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            rs = null;
        }

        if(stmt!=null){
            try {
                stmt.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            stmt = null;
        }

        if(conn!=null){
            try {
                System.out.println("数据库已断开");
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            conn = null;
        }
    }

    public void getAll(String sql){
        ResultSet res = this.getResult(sql);
        try {
            ResultSetMetaData rsmd = res.getMetaData() ;
            int row = rsmd.getColumnCount();
            while(res.next()){
                for(int i=1;i<=row;i++){
                    System.out.print(res.getString(i)+" ");
                }
                System.out.println();
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(rs!=null){
                try {
                    rs.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
                rs = null;
            }
            if(stmt!=null){
                try {
                    stmt.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
                stmt = null;
            }

            if(conn!=null){
                try {
                    conn.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
                conn = null;
            }
        }
    }
}

//public class Sql {
//    public static void main(String[] args) {
//        Sql sql = new Sql();
//        sql.executeSql("update user set name=\"wen\" where name=\"wenxia\"");
//
//        sql.getAll("select * from user");
//    }
//}
