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
        JSONArray data = jsonObject.getJSONArray("data");
        JSONObject newJsonObject = JSONObject.fromObject(data.toString());
        System.out.println(newJsonObject.toString());
        data = jsonObject.getJSONArray("data");

//        JSONArray items = jsonObject.getJSONObject("data").getJSONArray("data");
//        JSONObject row = null;
        JSONArray json = JSONArray.fromObject(data);
        for(int i=0; i<json.size(); i++){
//            JSONArray json = JSONArray.fromObject(data.getJSONObject(i));
//            row = data.getJSONObject(i);
            System.out.println("itemstring ：" + json.toString());
//            JSONObject itemcoord = row.getJSONObject("itemcoord");
//            System.out.println("x：" + itemcoord.get("x"));
//            System.out.println("y：" + itemcoord.get("y"));
//            System.out.println("width：" + itemcoord.get("width"));
//            System.out.println("height：" + itemcoord.get("height"));
        }
//        System.out.println("session_id：" + data.get("session_id"));
//        System.out.println("code：" + jsonObject.get("code"));
//        System.out.println("code：" + jsonObject.get("message"));

    }
}
