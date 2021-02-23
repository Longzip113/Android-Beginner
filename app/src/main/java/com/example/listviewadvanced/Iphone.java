package com.example.listviewadvanced;

public class Iphone {
    private String name;
    private String desc;
    private Integer image;

    public Iphone(String name, String desc, Integer image) {
        this.name = name;
        this.desc = desc;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }
}
