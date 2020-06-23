package interfaces;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;

public class GetPJJsonDid {

    private static Logger log = Logger.getLogger(GetPJContent.class);

    public void getPJDid(String pjJson){
/*
     {
      "data":{
    "items":[
      {
        "itemstring":"手机",
        "itemcoord":{"x":0,"y":100,"width":40,"height":20},
      }
    ],
        "session_id":"",
      },
      "code":0,
      "message":"OK"
}*/

        JSONObject jsonObject = JSONObject.fromObject(pjJson);
//        JSONObject data = jsonObject.getJSONObject("data");
//        JSONArray json = jsonObject.getJSONObject("data").getJSONArray("data");
//        JSONObject row = null;
//
        log.warn(jsonObject.get("data"));

        String dataStr = jsonObject.getString("data");

        JSONObject abc = JSONObject.fromObject(dataStr);

        log.warn(abc.size());
//        https://blog.csdn.net/qq_34309663/article/details/80508125
//        for(int i=0; i<json.size(); i++){
//            row = json.getJSONObject(i);
//            System.out.println("itemstring ：" + row.get("itemstring"));
//            JSONObject itemcoord = row.getJSONObject("itemcoord");
//            System.out.println("x：" + itemcoord.get("x"));
//            System.out.println("y：" + itemcoord.get("y"));
//            System.out.println("width：" + itemcoord.get("width"));
//            System.out.println("height：" + itemcoord.get("height"));
//        }
//        System.out.println("session_id：" + data.get("session_id"));
//        System.out.println("code：" + jsonObject.get("code"));
//        System.out.println("code：" + jsonObject.get("message"));

    }
}
