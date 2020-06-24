package xyz.demontisa;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;

public class PJUserList {

    private static Logger log = Logger.getLogger(PJUserList.class);

    public static String pjUserList(String fdtoken, String relationid) throws IOException {

        //接口地址
        final String spec = "http://educiot.com:32070/wxw/eva/studentevaluatelist";

        String str = "";

        URL url = new URL(spec);
        URLConnection connection = url.openConnection();
        HttpURLConnection httpURLConnection = (HttpURLConnection) connection;

        log.warn("正在设置HTTP请求头");
        //设置请求头
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip, deflate");
        httpURLConnection.setRequestProperty("Connection", "close");
        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        httpURLConnection.setRequestProperty("Accept", "*/*");
        httpURLConnection.setRequestProperty("Host", "educiot.com:32070");
        httpURLConnection.setRequestProperty("User-Agent", "yu lian wang/2.3.4 (iPhone; iOS 13.5; Scale/2.00)");
        httpURLConnection.setRequestProperty("Content-Length", "14");
        httpURLConnection.setRequestProperty("Accept-Language", "zh-Hans-HK;q=1, en-HK;q=0.9");
        httpURLConnection.setRequestProperty("FDtoken", fdtoken);
        httpURLConnection.setDoOutput(true);

        try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
                httpURLConnection.getOutputStream())) {
            outputStreamWriter.write("tid=" + relationid);
            outputStreamWriter.flush();
        }
        log.warn("正在获取评教成员");

        //如果HTTP状态码返回200,则输出获取到的数据
        if (httpURLConnection.getResponseCode() == 200) {

            log.warn("已获取到评教成员");

            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            httpURLConnection.getInputStream()))) {
                String tempLine = null;
                StringBuilder resultBuffer = new StringBuilder();
                while ((tempLine = reader.readLine()) != null) {
                    resultBuffer.append(tempLine);
                }

                str = resultBuffer.toString();

            }
        }else {
            log.warn("获取失败");
        }

        return str;
    }
}
