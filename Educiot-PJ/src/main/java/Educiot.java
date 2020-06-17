import interfaces.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Educiot {

    public static void main(String[] args) throws IOException {

        Login login = new Login();
        MD5 md5 = new MD5();
        EduciotPJList pjList = new EduciotPJList();
        GetRelationId getRelationId = new GetRelationId();
        PJUserList pjUserList = new PJUserList();
        GetUserRid getUserRid = new GetUserRid();
        GetPJMsgJson pjMsgJson = new GetPJMsgJson();

        Scanner input = new Scanner(System.in);

        //提示用户输入用户名和密码
        System.out.println("请输入用户名：");
        System.out.print(">");
        String userId = input.nextLine();
        System.out.println("请输入密码：");
        System.out.print(">");
        String userPassword = input.nextLine();

        //获取FDtoken
        String fdLoginReturnJson = Login.educiotLogin(userId, MD5.pwdToMD5(userPassword));
        System.out.println("已获取到FDtoken(" + fdLoginReturnJson + ")");

        //获取relationid
        String relationid = getRelationId.GetNewRelationId(EduciotPJList.educiotPJList(fdLoginReturnJson));
        System.out.println("已获取到最新评教列表relationid(" + relationid + ")");

        //获取rid
        String userListJson = pjUserList.pjUserList(fdLoginReturnJson, relationid);
        System.out.println("已获取到所有评教用户的rid " + Arrays.toString(getUserRid.GetAllUserRid(userListJson)));

        //获取评教信息
        String pjJson = pjMsgJson.getPJJson(fdLoginReturnJson,getUserRid.GetAllUserRid(userListJson),relationid);
        System.out.println(pjJson);

    }

}