package com.zr.search.elasticsearch;

import cn.hutool.json.JSONUtil;
import com.zr.search.elasticsearch.moedl.Movie;
import com.zr.search.elasticsearch.util.Connection;
import com.zr.search.elasticsearch.util.Utils;

import org.apache.commons.io.FileUtils;

import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * 描述
 *
 * @author nicaide
 * @date 2019年12月23日 11:41:00
 */
public class P47 {

    public static void main(String[] args) {
        P47 p47 = new P47();
        p47.bitchInsert();
    }

    public void bitchInsert() {
        Map map = new HashMap();

        File file = new File(Utils.getPath());

        String input = null;
        JSONObject jsonArray = null;
        try {
            input = FileUtils.readFileToString(file, "UTF-8");
            jsonArray = new JSONObject(input);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //将读取的数据转换为JSONObject
//        System.out.println(jsonObject);

        RestHighLevelClient client = Connection.getConnection();

//        CreateIndexRequest request = new CreateIndexRequest("zr");
//        try {
//            client.indices().create(request);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        List<Movie> movies = new ArrayList<>();
        Iterator iter = jsonArray.keys();
        while (iter.hasNext()) {
            String key = (String) iter.next();
            try {
                String value = jsonArray.getString(key);
                JSONObject json = new JSONObject(value);
                Movie movie = JSONUtil.toBean(value, Movie.class);
                movies.add(movie);
                String mmm = movie.toString();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }


        for (Movie movie : movies) {
            Map<String, Object> movieMap = new HashMap<>();
            movieMap.put("title", movie.getTitle());
            IndexRequest indexRequest = new IndexRequest("zr", "movie", String.valueOf(movie.getId())).source(movieMap);
            try {
                client.index(indexRequest);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("结束");
    }

}
