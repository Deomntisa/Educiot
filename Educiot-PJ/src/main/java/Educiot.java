import xyz.demontisa.*;

import java.io.IOException;

public class Educiot {

    public static void main(String[] args) throws IOException {

        GetRelationId getRelationId = new GetRelationId();
        GetUserRid getUserRid = new GetUserRid();
        GetPJJsonDid getPJJsonDid = new GetPJJsonDid();


        //获取FDtoken
        String fdLoginReturnJson = Login.educiotLogin();

        //获取relationid
        String relationid = getRelationId.getNewRelationId(EduciotPJList.educiotPJList(fdLoginReturnJson));

        //获取rid
        String userListJson = PJUserList.pjUserList(fdLoginReturnJson, relationid);

        //获取评教信息
        String pjJson = GetPJMsgJson.getPJJson(fdLoginReturnJson,getUserRid.GetAllUserRid(userListJson),relationid);

        //获取评教内容
        new GetPJContent().getPJContent(pjJson);

        //获取评教最高分段did
        getPJJsonDid.getPJDid(pjJson);


    }

}