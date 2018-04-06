package com.swapsystem.pojo;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Component("stuff")
/*用户发布的物品类*/
public class Stuff {
    private int id;
    private String name;
    private BigDecimal originalPrice;
    private BigDecimal price;
    private String description;
    private String oldness;
    private Date buyDate;
    private String otherInfo;
    private String willing;
    private int uid;
    private int cid;
    private List<Img> imgList=null;


    public List<Img> getImgList() {
        return imgList;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setImgList(List<Img> imgList) {
        this.imgList = imgList;
    }

    public Stuff() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOldness() {
        return oldness;
    }

    public void setOldness(String oldness) {
        this.oldness = oldness;
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }

    public String getWilling() {
        return willing;
    }

    public void setWilling(String willing) {
        this.willing = willing;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }


    @Override
    public String toString() {
        return "Stuff{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", originalPrice=" + originalPrice +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", oldness='" + oldness + '\'' +
                ", buyDate=" + buyDate +
                ", otherInfo='" + otherInfo + '\'' +
                ", willing='" + willing + '\'' +
                ", uid=" + uid +
                ", cid=" + cid +
                ", imgList=" + imgList +
                '}';
    }
}
