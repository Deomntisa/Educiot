import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Scanner;

public class Educiot {
    public static void main(String[] args) throws IOException {

        Login login = new Login();
        MD5 md5 = new MD5();
        Scanner input = new Scanner(System.in);

        System.out.println("请输入用户名：");
        System.out.print(">");
        String userId = input.nextLine();
        System.out.println("请输入密码：");
        System.out.print(">");
        String userPassword = input.nextLine();

        String returnJson = login.educiotLogin(userId,md5.pwdToMD5(userPassword));
//        System.out.println(returnJson);
        JsonObject json = new Gson().fromJson(returnJson,JsonObject.class);
        String fdToken = json.get("token").getAsString();
        System.out.println("已获取到FDtoken(" + fdToken + ")");

    }

}