import java.io.IOException;
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

        login.educiotLogin(userId,md5.pwdToMD5(userPassword));

    }

}