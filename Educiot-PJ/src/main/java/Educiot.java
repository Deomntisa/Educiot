import interfaces.*;

import org.apache.log4j.Logger;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Educiot {

    private static Logger log = Logger.getLogger(Educiot.class);

    public static void main(String[] args) throws IOException {

        Login login = new Login();
        MD5 md5 = new MD5();
        EduciotPJList pjList = new EduciotPJList();
        GetRelationId getRelationId = new GetRelationId();
        PJUserList pjUserList = new PJUserList();
        GetUserRid getUserRid = new GetUserRid();
        GetPJMsgJson pjMsgJson = new GetPJMsgJson();
        GetPJContent pjContent = new GetPJContent();
        GetPJJsonDid pjJsonDid = new GetPJJsonDid();


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
        log.info("已获取到FDtoken " + fdLoginReturnJson);

        //获取relationid
        String relationid = getRelationId.getNewRelationId(EduciotPJList.educiotPJList(fdLoginReturnJson));
        log.info("已获取到最新评教列表relationid " + relationid);

        //获取rid
        String userListJson = PJUserList.pjUserList(fdLoginReturnJson, relationid);
        log.info("已获取到所有评教用户的rid " + Arrays.toString(getUserRid.GetAllUserRid(userListJson)));

        //获取评教信息
        String pjJson = GetPJMsgJson.getPJJson(fdLoginReturnJson,getUserRid.GetAllUserRid(userListJson),relationid);
        log.info("已获取到评教信息 " + pjJson);
        log.info("已获取到所有评教内容 " + Arrays.toString(pjContent.getPJContent(pjJson)));

        log.info(Arrays.toString(pjJsonDid.getPJDid(pjJson)));


    }

}