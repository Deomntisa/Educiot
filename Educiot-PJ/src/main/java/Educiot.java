import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;

public class Educiot {
    public static void main(String[] args) throws IOException {

        Login login = new Login();
        MD5 md5 = new MD5();
        EduciotPJList pjList = new EduciotPJList();

        Scanner input = new Scanner(System.in);

        System.out.println("请输入用户名：");
        System.out.print(">");
        String userId = input.nextLine();
        System.out.println("请输入密码：");
        System.out.print(">");
        String userPassword = input.nextLine();
        //
        String fdLoginReturnJson = Login.educiotLogin(userId, MD5.pwdToMD5(userPassword));

        System.out.println("已获取到FDtoken(" + fdLoginReturnJson + ")");
//        String fdEduciotPJListReturnJson = EduciotPJList.educiotPJList(fdLoginReturnJson);
//        System.out.println(fdEduciotPJListReturnJson);
//        JsonObject educiotPJJson = new Gson().fromJson(fdEduciotPJListReturnJson,JsonObject.class);
//        String relationId = educiotPJJson.get("data").getAsString();
//        System.out.println(fdEduciotPJListReturnJson);

    }

}