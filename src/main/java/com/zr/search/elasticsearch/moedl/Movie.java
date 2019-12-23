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

    private String title;

    private String tagline;

    private Date release_date;

    private Double popularity;

    private String original_title;

    private Integer budget;

}
