package com.zr.search.elasticsearch.moedl;

import lombok.Data;

import java.util.Date;

/**
 * 描述
 *
 * @author nicaide
 * @date 2019年12月23日 11:43:00
 */
@Data
public class Movie {

    private Integer id;

    private String title;


    @Override
    public String toString() {
        return "{index: {_index: zr," +
                "_type:" + title +"," +
                "_id:" + id + "}}";
    }
}
