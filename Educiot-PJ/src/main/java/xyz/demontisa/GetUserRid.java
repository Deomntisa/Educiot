package xyz.demontisa;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;

import java.util.Arrays;

public class GetUserRid {

    private static final Logger log = Logger.getLogger(GetUserRid.class);

    public String[] GetAllUserRid(String userListJson){

        log.debug(userListJson);

        log.warn("正在获取JsonArray中的data1数据");
        //获取JsonArray中的data2数据
        JsonObject educiotPJJson = new Gson().fromJson(userListJson,JsonObject.class);
        JsonArray relationId = educiotPJJson.getAsJsonArray("data1");
        String newRelationId = relationId.toString();

        log.warn("已成功获取到data1数据");

        JSONArray json = JSONArray.fromObject(newRelationId);
        //声明存放rid的动态数组
        String[] newRid = new String[json.size()];

        log.warn("正在遍历用户rid");

        for(int i=0;i<json.size();i++){

            JSONObject rid = json.getJSONObject(i);   // 遍历 jsonarray 数组，把每一个对象转成 json 对象
            newRid[i] =String.valueOf(rid.get("rid"));
        }

        log.info("已获取到所有评教用户的rid " + Arrays.toString(newRid));
        return newRid;
    }
}
