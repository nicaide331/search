package com.zr.search.elasticsearch;

import com.zr.search.elasticsearch.util.Utils;

import org.apache.commons.io.FileUtils;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述
 *
 * @author nicaide
 * @date 2019年12月23日 11:41:00
 */
public class P47 {

    public static void main(String[] args) {
        P47 p47 = new P47();
        p47.toMap();
    }

    public Map<String, Object> toMap() {
        Map map = new HashMap();

        File file = new File(Utils.getPath());

        String input = null;
        JSONObject jsonObject = null;
        try {
            input = FileUtils.readFileToString(file, "UTF-8");
            jsonObject=new JSONObject(input);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //将读取的数据转换为JSONObject
        System.out.println(jsonObject);
        return map;
    }
}
