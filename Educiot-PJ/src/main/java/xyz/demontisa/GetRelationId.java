package xyz.demontisa;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;

public class GetRelationId {

    private static Logger log = Logger.getLogger(GetRelationId.class);

    public String getNewRelationId(String fdEduciotPJListReturnJson){

        log.warn("正在获取JsonArray中的data数据");
        //获取JsonArray中的data数据
        JsonObject educiotPJJson = new Gson().fromJson(fdEduciotPJListReturnJson,JsonObject.class);
        JsonArray relationId = educiotPJJson.getAsJsonArray("data");
        String newRelationId = relationId.toString();

        log.warn("已成功获取到data数据");

        JSONArray json = JSONArray.fromObject(newRelationId);
        String newRid = null;

        log.warn("正在遍历relationid");

        for(int i=0;i<1;i++){
            JSONObject rid = json.getJSONObject(i);   // 遍历 jsonarray 数组，把每一个对象转成 json 对象
//            System.out.println(rid.get("relationid"));   // 得到 relationid 每个对象中的属性值
            newRid =String.valueOf(rid.get("relationid"));
        }

        log.warn("已成功遍历relationid");

        return newRid;
    }
}
