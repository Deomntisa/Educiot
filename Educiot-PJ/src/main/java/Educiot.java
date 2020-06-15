import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class Educiot {
    public static void main(String[] args) {

        Login login = new Login();
        login.educiotLogin("440823200204082711","e8ceb9db84687cfbd8a6aedfdda3c2f9");
    }
}
class Login {
    public String educiotLogin(String userId, String pwd) {
        /*
            http://educiot.com:32070/user/login
            account=userid
            &client=1&code=0
            &pwd=pwd
            &version=2.3.4
        */
        String result = "";
        BufferedReader read = null;

        try {
            //创建URL
            URL realurl = new URL("http://educiot.com:32070/user/login?account=" + userId + "&client=1&code=0&pwd=" + pwd + "&version=2.3.4");
            //打开链接
            HttpURLConnection connection = realurl.openConnection();


            //设置请求头
            connection.setRequestProperty("Accept-Encoding", "gzip, deflate");
            connection.setRequestProperty("Connection", "close");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Accept", "*/*");
            connection.setRequestProperty("Host", "educiot.com:32070");
            connection.setRequestProperty("User-Agent", "yu lian wang/2.3.4 (iPhone; iOS 13.5; Scale/2.00)");
            connection.setRequestProperty("Content-Length", "93");
            connection.setRequestProperty("Accept-Language", "zh-Hans-HK;q=1, en-HK;q=0.9");

            connection.setConnectTimeout(10000);
            connection.setReadTimeout(10000);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            //建立连接
            connection.connect();

            // 定义 BufferedReader输入流来读取URL的响应
            read = new BufferedReader(new InputStreamReader(
                    connection.getInputStream(), "UTF-8"));
            String line;//循环读取
            while ((line = read.readLine()) != null) {
                result += line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (read != null) {//关闭流
                try {
                    read.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return result;

    }
}

