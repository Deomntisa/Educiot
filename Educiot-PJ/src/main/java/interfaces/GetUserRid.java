package interfaces;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GetUserRid {

    public String[] GetAllUserRid(String userListJson){
        //获取JsonArray中的data数据
        JsonObject educiotPJJson = new Gson().fromJson(userListJson,JsonObject.class);
        JsonArray relationId = educiotPJJson.getAsJsonArray("data2");
        String newRelationId = relationId.toString();

        JSONArray json = JSONArray.fromObject(newRelationId);
        //声明存放rid的动态数组
        String[] newRid = new String[json.size()];
        for(int i=0;i<json.size();i++){
            JSONObject rid = json.getJSONObject(i);   // 遍历 jsonarray 数组，把每一个对象转成 json 对象
//            System.out.println(rid.get("rid"));   // 得到 relationid 每个对象中的属性值
            newRid[i] =String.valueOf(rid.get("rid"));
        }

        return newRid;
    }
}
