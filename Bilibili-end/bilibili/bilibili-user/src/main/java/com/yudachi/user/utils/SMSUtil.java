package com.yudachi.user.utils;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import org.json.JSONException;

import java.io.IOException;

public class SMSUtil {
    /**
     * @Description //TODO  发送短信
     * @Params
     * [
     * code 短信内容参数
     * appid 短信应用appid
     * appkey 短信应用对应的key
     * nationCode 区号 如+86
     * phoneNumber 发送到哪个手机号上
     * templateId 模板id
     * sign 签名内容
     * ]
     * @Return void
     **/
    public static void sendSms(String code, Integer appid, String appkey, String nationCode, String phoneNumber, Integer templateId, String sign){
        try {
            String[] params = {code};
            SmsSingleSender ssender = new SmsSingleSender(appid,appkey);
            SmsSingleSenderResult result = ssender.sendWithParam(nationCode, phoneNumber,
                    templateId, params, sign, "", "");
            System.out.println(result);
        } catch (HTTPException e) {
            // HTTP 响应码错误
            e.printStackTrace();
        } catch (JSONException e) {
            // JSON 解析错误
            e.printStackTrace();
        } catch (IOException e) {
            // 网络 IO 错误
            e.printStackTrace();
        }
    }
}
