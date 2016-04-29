package com.giish.tosql.repository;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import okhttp3.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SAM on 2016/4/23.
 */
public class Parse<T> {
    private String urlCount = "https://api.parse.com/1/classes/%s?count=1&limit=0";
    private String urlQuery = "https://api.parse.com/1/classes/%s?limit=%d&skip=%d";
    private String urlObject = "https://api.parse.com/1/classes/%s/%s";

    private String parseApplicationId;
    private String parseRESTAPIKey;
    private String objectname;

    private int limit = 1000;

    public Parse(String parseApplicationId, String parseRESTAPIKey, String objectname) {
        this.parseApplicationId = parseApplicationId;
        this.parseRESTAPIKey = parseRESTAPIKey;
        this.objectname = objectname;
    }

    public Integer count() {
        JSONObject json = null;
        json = JSON.parseObject(this.getParseData(String.format(this.urlCount, this.objectname)));
        Integer count = json.getInteger("count");
        return count;
    }

    public List<T> listAllClazz(Class<T> clazz) {
        List<T> list = new ArrayList<T>();
        Integer count = this.count();
        int skip = 0;
        while (list.size() < count) {
            List<T> listtmp = this.listClazz(limit, skip, "-createdAt", clazz);
            skip += limit;
            list.addAll(listtmp);
        }
        return list;
    }

    //
    public List<T> listClazz(Integer limit, Integer skip, String order, Class<T> clazz) {
        List<T> list = null;
        JSONObject json = null;
        json = JSON.parseObject(this.getParseData(String.format(this.urlQuery, this.objectname, limit, skip) + (order != null ? "&order=" + order : "")));
        list = JSON.parseArray(json.getJSONArray("results").toJSONString(), clazz);
        return list;
    }

    public JSONArray listAll() {
        int skip = 0;
        JSONArray jarray = new JSONArray();
        Integer count = this.count();
        while (jarray.size() < count) {
            JSONArray jarray_tmp = this.list(limit, skip, "-createdAt");
            skip += limit;
            jarray.addAll(jarray_tmp);
            System.out.println("all:"+count+",now:"+jarray.size());
        }
        return jarray;
    }

    public JSONArray list(Integer limit, Integer skip, String order) {
        JSONObject json = null;
        JSONArray jarray = null;
        //System.out.println(String.format(this.urlQuery, this.objectname, limit, skip) + (order != null ? "&order=" + order : ""));
        json = JSON.parseObject(this.getParseData(String.format(this.urlQuery, this.objectname, limit, skip) + (order != null ? "&order=" + order : "")));
        //System.out.println(json);
        jarray = json.getJSONArray("results");
        return jarray;
    }

    public JSONObject get(String objectid) {
        JSONObject json = null;
        json = JSON.parseObject(this.getParseData(String.format(this.urlObject, this.objectname, objectid)));
        return json;
    }

    public JSONObject update(String objectid, String bodydata) {
        JSONObject jsonobj = null;
        try {
            OkHttpClient client = new OkHttpClient();
            MediaType media_json = MediaType.parse("application/json; charset=utf-8");
            RequestBody body = RequestBody.create(media_json, bodydata);
            Request request = new Request.Builder()
                    .url(String.format(urlObject,this.objectname, objectid))
                    .put(body)
                    .header("X-Parse-Application-Id", this.parseApplicationId)
                    .header("X-Parse-REST-API-Key", this.parseRESTAPIKey)
                    .build();
            Response response = null;
            response = client.newCall(request).execute();
            ResponseBody rsbody = response.body();
            jsonobj = JSON.parseObject(rsbody.string());
            rsbody.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonobj;
    }


    private String getParseData(String url) {
        String data = null;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .header("X-Parse-Application-Id", this.parseApplicationId)
                .header("X-Parse-REST-API-Key", this.parseRESTAPIKey)
                .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
            ResponseBody rsbody = response.body();
            data = rsbody.string();
            rsbody.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
    /*
    public static void main(String[] args) {
        Parse parse = new Parse("rBAtPxQklEI8iOsL2Dk4KBiMrBCuNBkm46ieGQsW", "SIYcPWssolg6lDg8Ru0EJhH1Fm3IbHbfxgqnelQk", "Gift");
        System.out.println(parse.list(100,0,"-createdAt"));
    }
    */
}
