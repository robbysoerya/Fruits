package com.labti.fruits;

import java.util.ArrayList;

public class Model {
    String name, image, detailid, detailen;

    public Model(String name, String image, String detailid, String detailen) {
        this.name = name;
        this.image = image;
        this.detailid = detailid;
        this.detailen = detailen;
    }

    public String getDetailid() {
        return detailid;
    }

    public void setDetailid(String detailid) {
        this.detailid = detailid;
    }

    public String getDetailen() {
        return detailen;
    }

    public void setDetailen(String detailen) {
        this.detailen = detailen;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
