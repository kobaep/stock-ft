package com.psa.database;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.roo.addon.json.RooJson;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
@RooJson(deepSerialize = true)
public class Stockdata {

    /**
     */
    private String symbol;

    /**
     */
    @Value("0")
    private Double closeVal;

    /**
     */
    @Value("0")
    private Double open1;

    /**
     */
    @Value("0")
    private Double open2;

    /**
     */
    @Value("0")
    private Double high;

    /**
     */
    @Value("0")
    private Double low;

    /**
     */
    @Value("0")
    private Double lastVal;

    /**
     */
    @Value("0")
    private Double buyVol;

    /**
     */
    @Value("0")
    private Double sellVol;

    /**
     */
    @Value("0")
    private Double buyVal;

    /**
     */
    @Value("0")
    private Double sellVal;

    /**
     */
    @Value("0")
    private Double tval;

    /**
     */
    @Value("0")
    private Double tvol;

    /**
     */
    @Value("0")
    private Double askV1;

    /**
     */
    @Value("0")
    private Double askV2;

    /**
     */
    @Value("0")
    private Double bidV1;

    /**
     */
    @Value("0")
    private Double bidV2;
}
