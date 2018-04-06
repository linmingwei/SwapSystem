package com.swapsystem.pojo;

import org.springframework.stereotype.Component;

@Component("img")
/*存储物品图片路径的类*/
public class Img {
    private int id;
    private String path;
    private int sid;

    public Img() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    @Override
    public String toString() {
        return "Img{" +
                "id=" + id +
                ", path='" + path + '\'' +
                ", sid=" + sid +
                '}';
    }
}
