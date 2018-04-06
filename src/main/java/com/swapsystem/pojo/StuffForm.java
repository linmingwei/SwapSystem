package com.swapsystem.pojo;

import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.sql.Date;

public class StuffForm {
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
    private int sid;
//    MultipartFile file;

    public StuffForm() {
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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

//    public MultipartFile getFile() {
//        return file;
//    }
//
//    public void setFile(MultipartFile file) {
//        this.file = file;
//    }


    @Override
    public String toString() {
        return "StuffForm{" +
                "name='" + name + '\'' +
                ", originalPrice=" + originalPrice +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", oldness='" + oldness + '\'' +
                ", buyDate=" + buyDate +
                ", otherInfo='" + otherInfo + '\'' +
                ", willing='" + willing + '\'' +
                ", uid=" + uid +
                ", cid=" + cid +
                ", sid=" + sid +
                '}';
    }
}
