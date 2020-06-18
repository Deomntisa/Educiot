package interfaces;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;

public class GetPJJsonDid {

    private static Logger log = Logger.getLogger(GetPJContent.class);

    public String[][] getPJDid(String pjJson){


        //获取JsonArray中的data数据
        log.warn("正在获取JsonArray中的data数据");

        JsonObject educiotPJContent = new Gson().fromJson(pjJson,JsonObject.class);
        JsonArray educiotPJContentAsJsonArray = educiotPJContent.getAsJsonArray("data");

        //data
        log.warn("已成功获取到data数据");
        String newEduciotPJContentAsJsonArray = educiotPJContentAsJsonArray.toString();

        JsonObject did = new Gson().fromJson(newEduciotPJContentAsJsonArray,JsonObject.class);

        //did

        JSONArray json = JSONArray.fromObject(newEduciotPJContentAsJsonArray);
        JSONArray newDid = JSONArray.fromObject(did);




        log.warn("正在遍历did");
        String[][] educiotContent = new String[json.size()][newDid.size()];

        for(int i = 0; i < json.size(); i++){
            for (int j = 0; j < newDid.size(); j++){

                JSONObject name = json.getJSONObject(i);   // 遍历 jsonarray 数组，把每一个对象转成 json 对象
                JSONObject dId = newDid.getJSONObject(j);   // 遍历 jsonarray 数组，把每一个对象转成 json 对象
                educiotContent[i][j] =String.valueOf(dId.get("did"));
            }

        }
        log.warn("已成功遍历将评教内容");
        return educiotContent;
    }
}
