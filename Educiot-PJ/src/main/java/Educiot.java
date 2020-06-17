import interfaces.*;

import java.io.IOException;
import java.util.Scanner;

public class Educiot {

    public static void main(String[] args) throws IOException {

        Login login = new Login();
        MD5 md5 = new MD5();
        EduciotPJList pjList = new EduciotPJList();
        GetRelationId getRelationId = new GetRelationId();
        PJUserList pjUserList = new PJUserList();
        GetUserRid getUserRid = new GetUserRid();

        Scanner input = new Scanner(System.in);

        System.out.println("请输入用户名：");
        System.out.print(">");
        String userId = input.nextLine();
        System.out.println("请输入密码：");
        System.out.print(">");
        String userPassword = input.nextLine();
        //FDtoken
        String fdLoginReturnJson = Login.educiotLogin(userId, MD5.pwdToMD5(userPassword));
        System.out.println("已获取到FDtoken(" + fdLoginReturnJson + ")");

        //relationid
        String relationid = getRelationId.GetNewRelationId(EduciotPJList.educiotPJList(fdLoginReturnJson));
        System.out.println("已获取到最新评教列表relationid(" + relationid + ")");

        //rid
        String userListJson = pjUserList.pjUserList(fdLoginReturnJson,relationid);
        System.out.println(userListJson);
        getUserRid.GetAllUserRid(userListJson);


    }

}