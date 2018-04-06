package com.swapsystem.pojo;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/*主页上显示的物品卡片信息*/
@Component("stuffcard")
public class StuffCard {
    private String stuffImg;
    private String title;
    private String willing;
    private BigDecimal price;
    private String headImg;
    private String username;
    private int sid;
    private int uid;
    private String link;

    public StuffCard() {
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getStuffImg() {
        return stuffImg;
    }

    public void setStuffImg(String stuffImg) {
        this.stuffImg = stuffImg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWilling() {
        return willing;
    }

    public void setWilling(String willing) {
        this.willing = willing;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "StuffCard{" +
                "stuffImg='" + stuffImg + '\'' +
                ", title='" + title + '\'' +
                ", willing='" + willing + '\'' +
                ", price=" + price +
                ", headImg='" + headImg + '\'' +
                ", username='" + username + '\'' +
                ", sid=" + sid +
                ", uid=" + uid +
                '}';
    }
}
