package com.yudachi.bilibili;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.selenium.SeleniumDownloader;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * 爬取类
 */
public class BilibiliCopyrightCrawler implements PageProcessor {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/bilibili";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "ZUIEWANGGUAN";

    public void process(Page page) {

        List<String> list = new Html("<div data-v-efd4826e=\"\" class=\"drop-list-v2-content-wrp\"><div data-v-efd4826e=\"\" title=\"定制软广\" class=\"drop-list-v2-item\"><div data-v-efd4826e=\"\" class=\"drop-list-v2-item-cont\"><p data-v-efd4826e=\"\" class=\"item-cont-main\">定制软广</p> <p data-v-efd4826e=\"\" class=\"item-cont-sub\"></p></div> <i data-v-efd4826e=\"\" class=\"drop-list-v2-item-icon iconfont icon-duihao\"></i></div><div data-v-efd4826e=\"\" title=\"节目赞助\" class=\"drop-list-v2-item\"><div data-v-efd4826e=\"\" class=\"drop-list-v2-item-cont\"><p data-v-efd4826e=\"\" class=\"item-cont-main\">节目赞助</p> <p data-v-efd4826e=\"\" class=\"item-cont-sub\"></p></div> <i data-v-efd4826e=\"\" class=\"drop-list-v2-item-icon iconfont icon-duihao\"></i></div><div data-v-efd4826e=\"\" title=\"Slogan\" class=\"drop-list-v2-item\"><div data-v-efd4826e=\"\" class=\"drop-list-v2-item-cont\"><p data-v-efd4826e=\"\" class=\"item-cont-main\">Slogan</p> <p data-v-efd4826e=\"\" class=\"item-cont-sub\"></p></div> <i data-v-efd4826e=\"\" class=\"drop-list-v2-item-icon iconfont icon-duihao\"></i></div><div data-v-efd4826e=\"\" title=\"二维码\" class=\"drop-list-v2-item\"><div data-v-efd4826e=\"\" class=\"drop-list-v2-item-cont\"><p data-v-efd4826e=\"\" class=\"item-cont-main\">二维码</p> <p data-v-efd4826e=\"\" class=\"item-cont-sub\"></p></div> <i data-v-efd4826e=\"\" class=\"drop-list-v2-item-icon iconfont icon-duihao\"></i></div><div data-v-efd4826e=\"\" title=\"Logo\" class=\"drop-list-v2-item\"><div data-v-efd4826e=\"\" class=\"drop-list-v2-item-cont\"><p data-v-efd4826e=\"\" class=\"item-cont-main\">Logo</p> <p data-v-efd4826e=\"\" class=\"item-cont-sub\"></p></div> <i data-v-efd4826e=\"\" class=\"drop-list-v2-item-icon iconfont icon-duihao\"></i></div><div data-v-efd4826e=\"\" title=\"TVC植入\" class=\"drop-list-v2-item\"><div data-v-efd4826e=\"\" class=\"drop-list-v2-item-cont\"><p data-v-efd4826e=\"\" class=\"item-cont-main\">TVC植入</p> <p data-v-efd4826e=\"\" class=\"item-cont-sub\"></p></div> <i data-v-efd4826e=\"\" class=\"drop-list-v2-item-icon iconfont icon-duihao\"></i></div><div data-v-efd4826e=\"\" title=\"字幕推广\" class=\"drop-list-v2-item\"><div data-v-efd4826e=\"\" class=\"drop-list-v2-item-cont\"><p data-v-efd4826e=\"\" class=\"item-cont-main\">字幕推广</p> <p data-v-efd4826e=\"\" class=\"item-cont-sub\"></p></div> <i data-v-efd4826e=\"\" class=\"drop-list-v2-item-icon iconfont icon-duihao\"></i></div><div data-v-efd4826e=\"\" title=\"口播\" class=\"drop-list-v2-item\"><div data-v-efd4826e=\"\" class=\"drop-list-v2-item-cont\"><p data-v-efd4826e=\"\" class=\"item-cont-main\">口播</p> <p data-v-efd4826e=\"\" class=\"item-cont-sub\"></p></div> <i data-v-efd4826e=\"\" class=\"drop-list-v2-item-icon iconfont icon-duihao\"></i></div><div data-v-efd4826e=\"\" title=\"其它\" class=\"drop-list-v2-item\"><div data-v-efd4826e=\"\" class=\"drop-list-v2-item-cont\"><p data-v-efd4826e=\"\" class=\"item-cont-main\">其它</p> <p data-v-efd4826e=\"\" class=\"item-cont-sub\"></p></div> <i data-v-efd4826e=\"\" class=\"drop-list-v2-item-icon iconfont icon-duihao\"></i></div><div data-v-efd4826e=\"\" title=\"贴片\" class=\"drop-list-v2-item\"><div data-v-efd4826e=\"\" class=\"drop-list-v2-item-cont\"><p data-v-efd4826e=\"\" class=\"item-cont-main\">贴片</p> <p data-v-efd4826e=\"\" class=\"item-cont-sub\"></p></div> <i data-v-efd4826e=\"\" class=\"drop-list-v2-item-icon iconfont icon-duihao\"></i></div></div>").xpath("//*[@class=\"drop-list-v2-item\"]/@title").all();


        Connection conn = null;
        Statement stmt = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();



            for (int i = 0; i < list.size(); i++) {
                String sql = "INSERT into commercial_way VALUES (" + (i + 1) +","+"'"+ list.get(i) +"')";
                System.out.println(sql);
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
        System.out.println("Goodbye!");

    }

    @Override
    public Site getSite() {
        return Site.me().setSleepTime(100).setRetrySleepTime(3);
    }


    public static void main(String[] args) throws Exception {


        System.setProperty("selenuim_config", "D:\\IDEAWorkSpace\\bilibili-Crawler\\src\\main\\java\\com\\yudachi\\config\\config.ini");
        Spider.create(new BilibiliCopyrightCrawler())
                .addUrl("https://www.bilibili.com/")
                .setDownloader(new SeleniumDownloader(
                        "C:\\Program Files (x86)\\Google\\ChromeDriver\\chromedriver.exe")
                        .setSleepTime(10000))
                .run();

    }
}