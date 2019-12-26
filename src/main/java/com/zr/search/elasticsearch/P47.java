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
        //创建索引
//        Utils.createIndex("zr");

        //插入数据
        Utils.bitchInsert();

        //关闭
        Utils.close();
    }


}
