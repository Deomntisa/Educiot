package xyz.demontisa;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Login {

    private static final Logger log = Logger.getLogger(Login.class);

    public static String educiotLogin() throws IOException {

        Scanner input = new Scanner(System.in);

        //提示用户输入用户名和密码
        System.out.println("请输入用户名：");
        System.out.print(">");
        String userId = input.nextLine();
        System.out.println("请输入密码：");
        System.out.print(">");
        String userPassword = input.nextLine();
        String pwd = MD5.pwdToMD5(userPassword);

        //接口地址
        final String spec = "http://educiot.com:32070/user/login";

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
        httpURLConnection.setRequestProperty("Content-Length", "93");
        httpURLConnection.setRequestProperty("Accept-Language", "zh-Hans-HK;q=1, en-HK;q=0.9");
        httpURLConnection.setDoOutput(true);

        try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpURLConnection.getOutputStream())) {
            outputStreamWriter.write("account=" + userId + "&client=1&code=0&pwd=" + pwd + "&version=2.3.5");
            outputStreamWriter.flush();
        }
        log.warn("正在登录");

        //如果HTTP状态码返回200,则输出获取到的数据
        if (httpURLConnection.getResponseCode() == 200) {
            log.warn("登录成功");
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            httpURLConnection.getInputStream()))) {
                String tempLine;
                StringBuilder resultBuffer = new StringBuilder();
                while ((tempLine = reader.readLine()) != null) {
                    resultBuffer.append(tempLine);
                }

                str = resultBuffer.toString();

            }

        }else {
            log.warn("登录失败");
        }
        //直接返回FDtoken
        JsonObject loginJson = new Gson().fromJson(str,JsonObject.class);

        log.warn("已获取到FDtoken " + loginJson.get("token").getAsString());

        return loginJson.get("token").getAsString();
    }

}
