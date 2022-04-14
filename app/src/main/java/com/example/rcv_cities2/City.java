package com.example.rcv_cities2;

import java.io.Serializable;
//Model class getters and setters constructors
public class City implements Serializable {
    private int imgID;
    private String name;
    private String state;
    private Long population;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    private String desc;
public static final String KEY_CITY="city";
    public int getImgID() {
        return imgID;
    }

    public void setImgID(int imgID) {
        this.imgID = imgID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public City(int imgID, String name, String state, Long population,String desc) {
        this.imgID = imgID;
        this.name = name;
        this.state = state;
        this.population = population;
        this.desc=desc;
    }
}
