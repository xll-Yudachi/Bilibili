package com.yudachi.bilibili;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.selenium.SeleniumDownloader;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

/**
 * 爬取类
 */
public class BilibiliIndexCrawler implements PageProcessor {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/bilibili";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "ZUIEWANGGUAN";

    public void process(Page page) {

        List<String> list1 = page.getHtml().xpath("//*[@id=\"primaryChannelMenu\"]/span/div/a/span/text()").all();

        System.out.println(list1.toString());

        List<String> list = page.getHtml().xpath("//*[@class=\"sub-item\"]/a/text()").all();
        System.out.println(list.toString());
        /*for (int i = 0; i < list.size(); i++) {
            List<String> all = new Html(list.get(i)).xpath("//*[@class=\"name\"]").all();

            for (int j = 0; j < list.size(); i++) {
                System.out.println(list1.get(i) + "：" + all.get(i));
            }
        }*/


       /* Connection conn = null;
        Statement stmt = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();


            String str = "MAD·AMV, MMD·3D, 短片·手书·配音, 特摄, 综合";
            String[] split = str.split(",");
            for (int i = 0; i < split.length; i++) {
                String sql = "INSERT INTO category " +
                        "VALUES ( "+ 1 +", " + split[i].trim()+ ")";
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
        System.out.println("Goodbye!");*/


    }

    @Override
    public Site getSite() {
        return Site.me().setSleepTime(100).setRetrySleepTime(3);
    }


    public static void main(String[] args) throws Exception {


        System.setProperty("selenuim_config", "D:\\IDEAWorkSpace\\bilibili-Crawler\\src\\main\\java\\com\\yudachi\\config\\config.ini");
        Spider.create(new BilibiliIndexCrawler())
                .addUrl("https://www.bilibili.com/")
                .setDownloader(new SeleniumDownloader(
                        "C:\\Program Files (x86)\\Google\\ChromeDriver\\chromedriver.exe")
                        .setSleepTime(10000))
                .run();

    }
}