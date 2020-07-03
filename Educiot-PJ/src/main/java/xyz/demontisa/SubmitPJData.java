package xyz.demontisa;


import org.apache.log4j.lf5.util.StreamUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class SubmitPJData {

    private static final Logger log = LoggerFactory.getLogger(EduciotPJList.class);

    public static void submit(String postData) throws IOException {

        //接口地址
        final String spec = "http://educiot.com:32070/wxw/eva/submitstudentevaluateteacher";

        URL url = new URL(spec);
        URLConnection connection = url.openConnection();
        HttpURLConnection httpURLConnection = (HttpURLConnection) connection;


//        log.warn("正在设置HTTP请求头");
        //设置请求头
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip, deflate");
        httpURLConnection.setRequestProperty("Connection", "close");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty("Accept", "*/*");
        httpURLConnection.setRequestProperty("Host", "educiot.com:32070");
        httpURLConnection.setRequestProperty("User-Agent", "yu lian wang/2.3.7 (iPhone; iOS 13.5; Scale/2.00)");
        httpURLConnection.setRequestProperty("Content-Length", "2481");
        httpURLConnection.setRequestProperty("Accept-Language", "zh-Hans-HK;q=1, en-HK;q=0.9");
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestMethod("POST");

        //提交json数据
        OutputStream os = httpURLConnection.getOutputStream();
        os.write(postData.getBytes());
        os.flush();

//        try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
//                httpURLConnection.getOutputStream())) {
//            outputStreamWriter.flush();
//        }

        log.info("正在提交评教数据");
        //如果HTTP状态码返回200,则输出获取到的数据
        if (httpURLConnection.getResponseCode() == 200) {


            log.info("已成功提交数据，请登录客户端查看是否评教成功！");

        }else {
            ByteArrayOutputStream bufferStream = new ByteArrayOutputStream();
            StreamUtils.copy(httpURLConnection.getInputStream(), bufferStream);
            log.error("提交失败,HTTP状态码：{}, ResponseBody: {}", httpURLConnection.getResponseCode(), new String(bufferStream.toByteArray()));
        }
    }
}
