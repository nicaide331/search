package com.zr.search.elasticsearch.util;


import org.apache.http.HttpHost;
import org.elasticsearch.ElasticsearchStatusException;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.admin.indices.open.OpenIndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

/**
 * 描述
 *
 * @author nicaide
 * @date 2019年12月23日 17:58:00
 */
public class Connection {

        /**
         *  服务器地址
         */
        private static String host="127.0.0.1";
        /**
         *  端口
         */
        private static int port=9200;
        /**
         * 创建logger
         */
        private Logger logger = LoggerFactory.getLogger(Connection.class);



        public static RestHighLevelClient getConnection() {
            /**
             * 创建链接
             */
            RestHighLevelClient client = new RestHighLevelClient(
                    RestClient.builder(
                            new HttpHost("localhost", 9200, "http")
                    ));
            return client;
        }
    }