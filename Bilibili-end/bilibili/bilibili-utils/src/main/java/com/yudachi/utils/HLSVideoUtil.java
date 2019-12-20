package com.yudachi.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 此文件用于视频文件处理，步骤如下：
 * 1、生成mp4
 * 2、生成m3u8
 *
 */
public class HLSVideoUtil extends VideoUtil {

    String ffmpeg_path = "D:\\Program Files\\ffmpeg-20180227-fa0c9d6-win64-static\\bin\\ffmpeg.exe";//ffmpeg的安装位置
    String video_path = "D:\\BaiduNetdiskDownload\\test1.avi";
    String m3u8_name = "test1.m3u8";
    String m3u8folder_path = "D:/BaiduNetdiskDownload/Movies/test1/";
    public HLSVideoUtil(String ffmpeg_path, String video_path, String m3u8_name,String m3u8folder_path){
        super(ffmpeg_path);
        this.ffmpeg_path = ffmpeg_path;
        this.video_path = video_path;
        this.m3u8_name = m3u8_name;
        this.m3u8folder_path = m3u8folder_path;
    }

    private void clear_m3u8(String m3u8_path){
        //删除原来已经生成的m3u8及ts文件
        File m3u8dir = new File(m3u8_path);
        if(!m3u8dir.exists()){
            m3u8dir.mkdirs();
        }
       /* if(m3u8dir.exists()&&m3u8_path.indexOf("/hls/")>=0){//在hls目录方可删除，以免错误删除
            String[] children = m3u8dir.list();
            //删除目录中的文件
            for (int i = 0; i < children.length; i++) {
                File file = new File(m3u8_path, children[i]);
                file.delete();
            }
        }else{
            m3u8dir.mkdirs();
        }*/
    }

    //ffmpeg.exe -i C:\Users\a\Videos\xc\买家登陆.mp4 -c:v libx264 -c:a aac -strict -2 -f hls -hls_list_size 0 C:\Users\a\Videos\xc\output.m3u8

    /**
     * 生成m3u8文件
     * @return 成功则返回success，失败返回控制台日志
     */
    public String generateM3u8(){
        //清理m3u8文件目录
        clear_m3u8(m3u8folder_path);
 /*
        ffmpeg -i  lucene.mp4   -hls_time 10 -hls_list_size 0   -hls_segment_filename ./hls/lucene_%05d.ts ./hls/lucene.m3u8
         */
//        String m3u8_name = video_name.substring(0, video_name.lastIndexOf("."))+".m3u8";
        List<String> commend = new ArrayList<String>();
        commend.add(ffmpeg_path);
        commend.add("-i");
        commend.add(video_path);
        commend.add("-hls_time");
        commend.add("10");
        commend.add("-hls_list_size");
        commend.add("0");
        commend.add("-hls_segment_filename");
//        commend.add("D:/BaiduNetdiskDownload/Movies/test1/test1_%05d.ts");
        commend.add(m3u8folder_path  + m3u8_name.substring(0,m3u8_name.lastIndexOf(".")) + "_%05d.ts");
//        commend.add("D:/BaiduNetdiskDownload/Movies/test1/test1.m3u8");

        commend.add(m3u8folder_path  + m3u8_name );

        System.err.println(commend);

        String outstring = null;
        try {
            ProcessBuilder builder = new ProcessBuilder();
            builder.command(commend);
            //将标准输入流和错误输入流合并，通过标准输入流程读取信息
            builder.redirectErrorStream(true);
            Process p = builder.start();
            outstring = waitFor(p);

        } catch (Exception ex) {

            ex.printStackTrace();

        }

        //通过查看视频时长判断是否成功
        Boolean check_video_time = check_video_time(video_path, m3u8folder_path + m3u8_name);



        if(!check_video_time){
            return outstring;
        }



        //通过查看m3u8列表判断是否成功
        List<String> ts_list = get_ts_list();
        if(ts_list == null){
            return outstring;
        }


        return "success";


    }

    /**
     * 检查视频处理是否完成
     * @return ts列表
     */
    public List<String> get_ts_list() {
//        String m3u8_name = video_name.substring(0, video_name.lastIndexOf("."))+".m3u8";
        List<String> fileList = new ArrayList<String>();
        List<String> tsList = new ArrayList<String>();
        String m3u8file_path =m3u8folder_path + m3u8_name;
        BufferedReader br = null;
        String str = null;
        String bottomline = "";
        try {
            br = new BufferedReader(new FileReader(m3u8file_path));
            while ((str = br.readLine()) != null) {
                bottomline = str;
                if(bottomline.endsWith(".ts")){
                    tsList.add(bottomline);
                }
                //System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if (bottomline.contains("#EXT-X-ENDLIST")) {
//            fileList.add(hls_relativepath+m3u8_name);
            fileList.addAll(tsList);
            return fileList;
        }
        return null;

    }


    /**
     * 获取视频总时间
     */
    public int getVideoTime(String video_path) {
        int time = 0;
        List<String> commands = new ArrayList<>();
        commands.add("ffmpeg");
        commands.add("-i");
        commands.add(video_path);
        try {
            ProcessBuilder builder = new ProcessBuilder();
            builder.command(commands);
            Process p = builder.start();

            //从输入流中读取视频信息
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            StringBuilder stringBuilder = new StringBuilder();
            String line = "";
            while ((line = br.readLine()) != null) {
                stringBuilder.append(line);
            }
            br.close();

            //从视频信息中解析时长
            String regexDuration = "Duration: (.*?), start: (.*?), bitrate: (\\d*) kb\\/s";
            Pattern pattern = Pattern.compile(regexDuration);
            Matcher m = pattern.matcher(stringBuilder.toString());
            if (m.find()) {
                 time = getTimelen(m.group(1));
                System.out.println("视频时长：" + time + "s , 开始时间：" + m.group(2) + ", 比特率：" + m.group(3) + "kb/s");
            }

            String regexVideo = "Video: (.*?), (.*?), (.*?)[,\\s]";
            pattern = Pattern.compile(regexVideo);
            m = pattern.matcher(stringBuilder.toString());
            if (m.find()) {
                System.out.println("编码格式：" + m.group(1) + ", 视频格式：" + m.group(2) + ", 分辨率：" + m.group(3) + "kb/s");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return time;
    }

    // 格式:"00:00:10.68"
    public int getTimelen(String timelen) {
        int min = 0;
        String strs[] = timelen.split(":");
        if (strs[0].compareTo("0") > 0) {
            // 秒
            min += Integer.valueOf(strs[0]) * 60 * 60;
        }
        if (strs[1].compareTo("0") > 0) {
            min += Integer.valueOf(strs[1]) * 60;
        }
        if (strs[2].compareTo("0") > 0) {
            min += Math.floor(Float.valueOf(strs[2]));
        }
        return min;
    }


    public static void main(String[] args) throws IOException {
        String ffmpeg_path = "D:/FFmpeg/bin/ffmpeg.exe";//ffmpeg的安装位置
        String video_path = "D:/FFmpeg/bilibili.mp4";
        String m3u8_name = "1.m3u8";
        String m3u8_path = "D:/FFmpeg/1/";
        HLSVideoUtil videoUtil = new HLSVideoUtil(ffmpeg_path,video_path,m3u8_name,m3u8_path);
        /*String s = videoUtil.generateM3u8();
        System.out.println(s);
        System.out.println(videoUtil.get_ts_list());*/
        int videoTime = videoUtil.getVideoTime(video_path);
        System.err.println(videoTime);
    }
}