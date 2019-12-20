package com.yudachi.bilibili;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class BilibiliSearchCrawler implements PageProcessor{

    public void process(Page page) {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Program Files (x86)\\Google\\ChromeDriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://search.bilibili.com");
        driver.findElement(By.id("search-keyword")).sendKeys("鹿乃");

        driver.findElement(By.className("searchBtn")).click();

        try {
            Thread.sleep(3000);
        } catch (Exception e) {

        }

        //利用js模拟页面滚动
        /*String javascript_f = "window.scrollTo(0, document.body.scrollHeight * 0.9)";
        ((JavascriptExecutor)driver).executeScript(javascript_f);

        try {
            Thread.sleep(3000);
        } catch (Exception e) {

        }

        String javascript_s = "window.scrollTo(0, document.body.scrollHeight * 0.85)";
        ((JavascriptExecutor)driver).executeScript(javascript_s);

        try {
            Thread.sleep(5000);
        } catch (Exception e) {

        }*/

        page.setRawText(driver.getPageSource());


        /*System.out.println(page.getHtml().xpath("//*[@id=\"all-list\"]/div[1]/div[2]/ul[2]/li[]"));*/

        List<String> all = page.getHtml().xpath("//*[@class=\"video-list clearfix\"]/li/a/@href").all();

        all.forEach(item->{
            System.out.println(item);
        });


        List<String> list = page.getHtml().links().regex("https://item\\.jd\\.com/[1-9][0-9]{10}\\.html").all();
        Set<String> set = new HashSet<String>(list);

        Iterator it = set.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }

        driver.quit();
    }

    public Site getSite() {
        return Site.me().setSleepTime(100).setRetrySleepTime(3);
    }

    public static void main(String[] args) {
        Spider.create(new BilibiliSearchCrawler())
                .addUrl(
                        "https://search.bilibili.com"
                )
                .addPipeline(new ConsolePipeline()).run();
    }

}