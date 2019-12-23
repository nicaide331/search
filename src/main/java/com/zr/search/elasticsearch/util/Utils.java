package com.zr.search.elasticsearch.util;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;

/**
 * 描述
 *
 * @author nicaide
 * @date 2019年12月23日 11:50:00
 */
public class Utils {

//    public static final String PATH = "E:\\ideaspace\\search\\src\\main\\resources\\tmdb.json";

    public static String  getPath() {
        Resource resource = new ClassPathResource("tmdb.json");
        String path = null;
        try {
            path = resource.getFile().getPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }

}
