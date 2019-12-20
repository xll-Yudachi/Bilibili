package com.yudachi.bilibili;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectUrl implements PageProcessor{

    public void process(Page page) {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Program Files (x86)\\Google\\ChromeDriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get( "https://search.jd.com/Search?keyword=%E7%BE%8E%E5%A6%86&enc=utf-8&qrst=1&rt=1&stop=1&vt=2&wq=%E7%BE%8E%E5%A6%86&stock=1&page=44&s=182&click=0");

        page.setRawText(driver.getPageSource());



        List<String> all = page.getHtml().links().regex("https://item\\.jd\\.com/[1-9][0-9]{10}\\.html").all();

        Set<String> set = new HashSet<>(all);

        /*List<String> all = page.getHtml().links().all();*/
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\IDEAWorkSpace\\bilibili-Crawler\\src\\main\\java\\com\\yudachi\\bilibili\\url2.txt", true)));
            set.forEach(item->{
                try {
                    bw.write(item);
                    bw.newLine();
                    bw.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(all.size());

        driver.quit();
    }

    public Site getSite() {
        return Site.me().setSleepTime(100).setRetrySleepTime(3);
    }

    public static void main(String[] args) {
        Spider.create(new CollectUrl())
                .addUrl(
                       "https://search.jd.com/Search?keyword=%E7%BE%8E%E5%A6%86&enc=utf-8&qrst=1&rt=1&stop=1&vt=2&wq=%E7%BE%8E%E5%A6%86&stock=1&page=44&s=182&click=0"
                )
                .addPipeline(new ConsolePipeline()).run();
    }

}