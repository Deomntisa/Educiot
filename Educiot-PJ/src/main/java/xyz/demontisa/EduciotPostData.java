package xyz.demontisa;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.log4j.Logger;

public class EduciotPostData {

    private static final Logger log = Logger.getLogger(EduciotPostData.class);

    public String getPostData(String[] rid,Long[] did){

        String postData = "[";
        for (int i = 0; i < rid.length; i++){

            postData += "{\"rid\":\"" + rid[i] + "\",\"ids\":[";

            for (int j = 0; j < did.length; j++){

                postData += "\"" + did[j] + "\",";
            }

            if (i == rid.length - 1){
                postData += "],\"remark\":\"\"}";
            }else {
                postData += "],\"remark\":\"\"},";
            }
        }
        postData += "]";

//        log.warn("已成功拼接postData " + postData);
        log.warn("已成功拼接postData");

//        JsonObject jsonObject = new Gson().fromJson(postData,JsonObject.class);

        return postData;
    }
}
