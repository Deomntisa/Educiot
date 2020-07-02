package xyz.demontisa;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class EduciotPJList {

    private static final Logger log = Logger.getLogger(EduciotPJList.class);

    public static String educiotPJList(String fdtoken) throws IOException {

        //接口地址
        final String spec = "http://educiot.com:32070/educiot/teacher/eva/notify/list";

        String str = "";

        URL url = new URL(spec);
        URLConnection connection = url.openConnection();
        HttpURLConnection httpURLConnection = (HttpURLConnection) connection;

//        log.warn("正在设置HTTP请求头");
        //设置请求头
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip, deflate");
        httpURLConnection.setRequestProperty("Connection", "close");
        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        httpURLConnection.setRequestProperty("Accept", "*/*");
        httpURLConnection.setRequestProperty("Host", "educiot.com:32070");
        httpURLConnection.setRequestProperty("User-Agent", "yu lian wang/2.3.5 (iPhone; iOS 13.5; Scale/2.00)");
        httpURLConnection.setRequestProperty("Content-Length", "14");
        httpURLConnection.setRequestProperty("Accept-Language", "zh-Hans-HK;q=1, en-HK;q=0.9");
        httpURLConnection.setRequestProperty("FDtoken", fdtoken);
        httpURLConnection.setDoOutput(true);

        try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
                httpURLConnection.getOutputStream())) {
            outputStreamWriter.write("page=1&size=10");
            outputStreamWriter.flush();
        }

        log.info("正在获取评教列表");
        //如果HTTP状态码返回200,则输出获取到的数据
        if (httpURLConnection.getResponseCode() == 200) {
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
            log.info("已成功获取评教列表");
        }

        return str;
    }
}
