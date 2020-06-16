import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class Login {

    public static void educiotLogin(String userId,String pwd) throws IOException {

        //接口地址
        final String spec = "http://educiot.com:32070/user/login";

        URL url = new URL(spec);
        URLConnection connection = url.openConnection();
        HttpURLConnection httpURLConnection = (HttpURLConnection) connection;

        //设置请求头
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip, deflate");
        httpURLConnection.setRequestProperty("Connection", "close");
        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        httpURLConnection.setRequestProperty("Accept", "*/*");
        httpURLConnection.setRequestProperty("Host", "educiot.com:32070");
        httpURLConnection.setRequestProperty("User-Agent", "yu lian wang/2.3.4 (iPhone; iOS 13.5; Scale/2.00)");
        httpURLConnection.setRequestProperty("Content-Length", "93");
        httpURLConnection.setRequestProperty("Accept-Language", "zh-Hans-HK;q=1, en-HK;q=0.9");
        httpURLConnection.setDoOutput(true);

        try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
                httpURLConnection.getOutputStream())) {
            outputStreamWriter.write("account=" + userId + "&client=1&code=0&pwd=" + pwd + "&version=2.3.4");
            outputStreamWriter.flush();
        }
        //如果HTTP状态码返回200,则输出获取到的信息
        if (httpURLConnection.getResponseCode() == 200) {
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            httpURLConnection.getInputStream()))) {
                String tempLine = null;
                StringBuilder resultBuffer = new StringBuilder();
                while ((tempLine = reader.readLine()) != null) {
                    resultBuffer.append(tempLine);
                }

                System.out.println(resultBuffer.toString());
            }
        }
    }
}
