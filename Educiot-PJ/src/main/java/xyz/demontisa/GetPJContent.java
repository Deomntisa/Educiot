package xyz.demontisa;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;

import java.util.Arrays;


public class GetPJContent {

    private static final Logger log = Logger.getLogger(GetPJContent.class);

    public void getPJContent(String pjJson){


        //获取JsonArray中的data数据
        log.warn("正在获取JsonArray中的data数据");
        log.debug(pjJson);
        JsonObject educiotPJContent = new Gson().fromJson(pjJson,JsonObject.class);
        JsonArray educiotPJContentAsJsonArray = educiotPJContent.getAsJsonArray("data");

        log.warn("已成功获取到data数据");
        String newEduciotPJContentAsJsonArray = educiotPJContentAsJsonArray.toString();

        JSONArray json = JSONArray.fromObject(newEduciotPJContentAsJsonArray);

        log.warn("正在遍历评教内容");
        String[] educiotContent = new String[json.size()];
        for(int i=0; i<json.size(); i++){
            JSONObject name = json.getJSONObject(i);   // 遍历 jsonarray 数组，把每一个对象转成 json 对象
            educiotContent[i] =String.valueOf(name.get("name"));
        }

        log.info("已获取到所有评教内容 " + Arrays.toString(educiotContent));
    }
}
