package com.yudachi.bilibili;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.selenium.SeleniumDownloader;
import us.codecraft.webmagic.processor.PageProcessor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 爬取类
 */
public class BilibiliItemCrawler implements PageProcessor {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/bilibili-recommender";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "ZUIEWANGGUAN";

    public void process(Page page) {

        Connection conn = null;
        Statement stmt = null;


        try{
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();

            String id = new IdWorker().nextId() + "";

            String title;
            if (page.getHtml().xpath("//*[@class=\"video-title\"]/@title") == null) {
                title = null;
                return;
            } else {
                title = page.getHtml().xpath("//*[@class=\"video-title\"]/@title").toString();
            }


            String upid = "1205094464939364352";

            System.out.println("title:" + title);


            String partition_1;
            if (page.getHtml().xpath("//*[@id=\"viewbox_report\"]/div[1]/span[1]/a[1]/text()") == null) {
                partition_1 = null;
            } else {
                partition_1 = page.getHtml().xpath("//*[@id=\"viewbox_report\"]/div[1]/span[1]/a[1]/text()").toString();
            }

            System.out.println("partition_1:" + partition_1);

            String partition_2;
            if (page.getHtml().xpath("//*[@id=\"viewbox_report\"]/div[1]/span[1]/a[2]/text()") == null) {
                partition_2 = null;
            } else {
                partition_2 = page.getHtml().xpath("//*[@id=\"viewbox_report\"]/div[1]/span[1]/a[2]/text()").toString();
            }

            System.out.println("partition_2:" + partition_2);


            String uploadTime;
            if (page.getHtml().xpath("//*[@id=\"viewbox_report\"]/div[1]/span[2]/text()") == null) {
                uploadTime = null;
            } else {
                uploadTime = page.getHtml().xpath("//*[@id=\"viewbox_report\"]/div[1]/span[2]/text()").toString();
            }

            System.out.println("uploadTime:" + uploadTime);

            SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );

            Date uploadDate = sdf.parse(uploadTime);

            String highestRank;
            if (page.getHtml().xpath("//*[@id=\"viewbox_report\"]/div[1]/span[3]/text()") == null) {
                highestRank = null;
            } else {
                highestRank = page.getHtml().xpath("//*[@id=\"viewbox_report\"]/div[1]/span[3]/text()").toString();
            }


            Integer rank = 0;
            if (highestRank != null){
                String tmp = "";
                char[] demo = highestRank.toCharArray();
                for (int i = 0; i < demo.length; i++) {
                    if (demo[i] >= '0' && demo[i] <='9') {
                        tmp += demo[i];
                    }
                }
                rank = Integer.parseInt(tmp);

                System.out.println("highestRank:" + rank);
            }



            String playNum;
            if (page.getHtml().xpath("//*[@id=\"viewbox_report\"]/div[2]/span[1]/@title") == null) {
                playNum = null;
            } else {
                playNum = page.getHtml().xpath("//*[@id=\"viewbox_report\"]/div[2]/span[1]/@title").toString().substring(4);
            }

            System.out.println("playNum:" + playNum);

            Integer play_num = Integer.valueOf(playNum);


            String danmuNum;
            if (page.getHtml().xpath("//*[@id=\"viewbox_report\"]/div[2]/span[2]/@title") == null) {
                danmuNum = null;
            } else {
                danmuNum = page.getHtml().xpath("//*[@id=\"viewbox_report\"]/div[2]/span[2]/@title").toString().substring(7);
            }

            System.out.println("danmuNum:" + danmuNum);

            Integer danmu_num = Integer.valueOf(danmuNum);


            String likeNum;
            if (page.getHtml().xpath("//*[@id=\"arc_toolbar_report\"]/div[1]/span[1]/@title") == null) {
                likeNum = null;
            } else {
                likeNum = page.getHtml().xpath("//*[@id=\"arc_toolbar_report\"]/div[1]/span[1]/@title").toString().substring(3);
            }

            System.out.println("likeNum:" + likeNum);

            Integer like_num = Integer.valueOf(likeNum);

            String coinNum;
            if (page.getHtml().xpath("//*[@id=\"arc_toolbar_report\"]/div[1]/span[2]/text()") == null) {
                coinNum = null;
            } else {
                coinNum = page.getHtml().xpath("//*[@id=\"arc_toolbar_report\"]/div[1]/span[2]/text()").toString();
            }

            System.out.println("coinNum:" + coinNum);

            coinNum = coinNum.trim();

            Integer coin_num = 0;

            if (coinNum.indexOf("万") >= 0){
                coinNum = coinNum.substring(0, coinNum.length()-1);
                coin_num = new Double(Double.parseDouble(coinNum) * 10000).intValue();
            }else{
                coin_num = new Double(Double.parseDouble(coinNum)).intValue();
            }


            System.err.println(coinNum);


            String collectNum;
            if (page.getHtml().xpath("//*[@id=\"arc_toolbar_report\"]/div[1]/span[3]/text()") == null) {
                collectNum = null;
            } else {
                collectNum = page.getHtml().xpath("//*[@id=\"arc_toolbar_report\"]/div[1]/span[3]/text()").toString();
            }

            System.out.println("collectNum:" + collectNum);


            Integer collect_num = 0;

            collectNum = collectNum.trim();
            if (collectNum.indexOf("万") >= 0){
                collectNum = collectNum.substring(0, collectNum.length()-1);
                collect_num =  new Double(Double.parseDouble(collectNum) * 10000).intValue();
            }else{
                collect_num =  new Double(Double.parseDouble(collectNum)).intValue();
            }


            String shareNum;
            if (page.getHtml().xpath("//*[@id=\"arc_toolbar_report\"]/div[1]/span[4]/text()") == null) {
                shareNum = null;
            } else {
                shareNum = page.getHtml().xpath("//*[@id=\"arc_toolbar_report\"]/div[1]/span[4]/text()").toString();
            }

            System.out.println("shareNum:" + shareNum);

            Integer share_num = 0;

            shareNum = shareNum.trim();
            if (shareNum.indexOf("万") >= 0){
                shareNum = shareNum.substring(0, shareNum.length()-1);
                share_num =  new Double(Double.parseDouble(shareNum) * 10000).intValue();
            }else{
                share_num =  new Double(Double.parseDouble(shareNum)).intValue();
            }


            String videoInfo;
            if (page.getHtml().xpath("//*[@id=\"v_desc\"]/div[1]/text()") == null) {
                videoInfo = null;
            } else {
                videoInfo = page.getHtml().xpath("//*[@id=\"v_desc\"]/div[1]/text()").toString();
            }

            System.out.println("videoInfo:" + videoInfo);


            String tag = "";

            if (page.getHtml().xpath("//*[@id=\"v_tag\"]/ul/li").all() == null) {
                tag = null;
            } else {
                List<String> list = page.getHtml().xpath("//*[@id=\"v_tag\"]/ul/li/a/text()").all();
                for (int i = 0; i < list.size(); i++) {
                    if (i < list.size() - 1){
                        tag += list.get(i) + "|";
                    }else{
                        tag += list.get(i);
                    }
                }
            }

            System.out.println("tag:" + tag);

                String sql = "INSERT INTO video " +
                        "(id,title,upid,partition_1,partition_2,upload_time,highest_rank,play_num,danmu_num,like_num,coin_num,collect_num,share_num,video_info,tag) " +
                        "VALUES ('"+ id +"','" + title + "','" +upid +"','"  + partition_1 + "','" + partition_2 + "','" + uploadTime + "'," + rank + "," + play_num + "," + danmu_num + "," + like_num + "," + coin_num + "," + collect_num + "," + share_num + ",'" + videoInfo + "','" + tag + "')";
            System.err.println(sql);
            stmt.executeUpdate(sql);



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

    @Override
    public Site getSite() {
        return Site.me().setSleepTime(100).setRetrySleepTime(3);
    }


    public static void main(String[] args) throws Exception {
       //https://www.bilibili.com/video/av75042396

        BufferedReader br = new BufferedReader(new FileReader(new File("D:\\IDEAWorkSpace\\bilibili-Crawler\\src\\main\\java\\com\\yudachi\\bilibili\\url2.txt")));
        List<String> list = new ArrayList<>();
        String url;
        while ( (url = br.readLine()) != null){
            list.add(url);
        }

        System.setProperty("selenuim_config", "D:\\IDEAWorkSpace\\bilibili-Crawler\\src\\main\\java\\com\\yudachi\\config\\config.ini");
        Spider.create(new BilibiliItemCrawler())
                .addUrl(list.toArray(new String[list.size()]))
                .setDownloader(new SeleniumDownloader(
                        "C:\\Program Files (x86)\\Google\\ChromeDriver\\chromedriver.exe")
                        .setSleepTime(10000))
                .run();

    }
}