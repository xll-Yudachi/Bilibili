package com.yudachi.bilibili;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 爬取类
 */
public class ImportDB{

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://rm-bp18m3nq36659195gbo.mysql.rds.aliyuncs.com:3306/homework?characterEncoding=utf-8&useSSL=false";

    //  Database credentials
    static final String USER = "wky";
    static final String PASS = "Wangkaiyi12345";

    public static void main(String[] args) throws Exception {



        Connection conn = null;
        Statement stmt = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();


            String str = "纪录片, 电影, 电视剧";
            String[] split = str.split(",");
            for (int i = 0; i < split.length; i++) {
                String sql = "INSERT INTO category " +
                        "(parentId,category_name) " +
                        "VALUES ( "+ 15 +",'"  + split[i].trim()+ "')";
                stmt.executeUpdate(sql);
            }



        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try

    }
}