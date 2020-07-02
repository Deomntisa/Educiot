package xyz.demontisa;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.log4j.Logger;

import java.util.Arrays;

public class GetPJJsonDid {

    private static final Logger log = Logger.getLogger(GetPJContent.class);

    public Long[] getPJDid(String pjJson){

        JsonParser parser = new JsonParser();
        JsonObject json = (JsonObject) parser.parse(pjJson);
        JsonArray array = json.get("data").getAsJsonArray();

        log.warn("已获取到所有评教JSON" + array);

//        JsonObject array1 = array.get((0)).getAsJsonObject();
//
//        log.warn(array1);
//
//        log.warn(array1.size());
//
//        JsonArray array2 = array1.get("data").getAsJsonArray();
//
//        log.warn(array2);
//
//        log.warn(array2.size());

//        JsonObject array3 = array2.get((0)).getAsJsonObject();

//        log.warn(array3);

//        JsonArray array4 = array3.get("data").getAsJsonArray();

//        log.warn(array4);

//        JsonObject array5 = array4.get((0)).getAsJsonObject();

//        log.warn(array5);

//        String array6 = array5.get("did").toString();

//        log.warn(array6);
        Long[] did = new Long[array.size()];

        for (int i = 0; i < array.size(); i++){

            JsonObject array1 = array.get((i)).getAsJsonObject();

//            log.warn("已获取到第" + (i + 1) + "个项目的JSON数据" + array1);
            log.warn("已获取到第" + (i + 1) + "个项目的JSON数据");

            JsonArray array2 = array1.get("data").getAsJsonArray();

//            log.warn("正在解析JsonArray数据转换为JsonObject" + array2);

            log.warn("此项目总共有" + array2.size() + "个分段");

            JsonObject array3 = array2.get((0)).getAsJsonObject();

//            log.warn("已成功转换为JsonObject" + array3);

            log.warn("正在获取data数据");

            JsonArray array4 = array3.get("data").getAsJsonArray();

//            log.warn("已成功获取data数据" + array4);

            JsonObject array5 = array4.get((0)).getAsJsonObject();

//            log.warn("已成功获取最高分段的JSON数据" + array5);

            log.warn("正在获取did");

            long array6 = array5.get("did").getAsLong();

            log.warn("已成功获取第" + (i + 1) + "个项目最高分的did " + array6);

            did[i] = array6;

        }

        log.warn("已获取所有最高分段did " + Arrays.toString(did));
        return did;
    }
}
