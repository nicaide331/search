package com.zr.search.elasticsearch.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.zr.search.elasticsearch.moedl.Cast;
import com.zr.search.elasticsearch.moedl.ListCast;
import com.zr.search.elasticsearch.moedl.Movie;
import org.apache.commons.io.FileUtils;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;

/**
 * 描述
 *
 * @author nicaide
 * @date 2019年12月23日 11:50:00
 */
public class Utils {

//    public static final String PATH = "E:\\ideaspace\\search\\src\\main\\resources\\tmdb.json";

    public static String getPath() {
        Resource resource = new ClassPathResource("json.json");
        String path = null;
        try {
            path = resource.getFile().getPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }


    public static void createIndex(String index) {
        RestHighLevelClient client = Connection.getConnection();

        CreateIndexRequest request = new CreateIndexRequest("zr");
        try {
            client.indices().create(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void bitchInsert() {

        System.out.println("开始");

        RestHighLevelClient client = Connection.getConnection();
        Map map = new HashMap();
        File file = new File(Utils.getPath());

        String input = null;
        JSONObject jsonObject = null;
        try {
            input = FileUtils.readFileToString(file, "UTF-8");
            jsonObject = JSON.parseObject(input);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //将读取的数据转换为JSONObject
//        System.out.println(jsonObject);

        BulkRequest bulkRequest = new BulkRequest();

        for (JSONObject.Entry jojo : jsonObject.entrySet()){
            Map<Object, Object> movieMap = new HashMap<>();
            JSONObject j = (JSONObject) jojo.getValue();
//            JSONArray castArray = (JSONArray) j.get("cast");
//            List<Cast> cast = castArray.toJavaList(Cast.class);
//            List<String> names = new ArrayList<>();
//            for (Cast c : cast) {
//                names.add(c.getName());
//            }
//            ListCast listCast = new ListCast();
//            listCast.setName(names);
//            Map castMap = new HashMap();
//            castMap.put("name", listCast.getName());
//            j.put("cast", castMap);
            IndexRequest indexRequest = new IndexRequest("zr", "movie", String.valueOf(jojo.getKey())).source(j);
            bulkRequest.add(indexRequest);
        }

        try {
            client.bulk(bulkRequest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("结束");
    }

    public static void close() {
        try {
            Connection.getConnection().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
