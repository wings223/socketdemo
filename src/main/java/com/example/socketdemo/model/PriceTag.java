package com.example.socketdemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 电子标签类
 */
@Entity
public class PriceTag {
    @Id @GeneratedValue
    private Long id;
    private String networkIP;
    private String tinyIP;
    private String lcdType;
    private Double imgLength;
    private String img0;
    private String barcode;
    private String outputNum;
    private String kindZone;
    private String str0;
    private String mainProIP;
    private Integer downloadTimes;
    private Date downloadDateTime;
    private String locate;
    private String tradeName;
    private String GR_status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNetworkIP() {
        return networkIP;
    }

    public void setNetworkIP(String networkIP) {
        this.networkIP = networkIP;
    }

    public String getTinyIP() {
        return tinyIP;
    }

    public void setTinyIP(String tinyIP) {
        this.tinyIP = tinyIP;
    }

    public String getLcdType() {
        return lcdType;
    }

    public void setLcdType(String lcdType) {
        this.lcdType = lcdType;
    }

    public Double getImgLength() {
        return imgLength;
    }

    public void setImgLength(Double imgLength) {
        this.imgLength = imgLength;
    }

    public String getImg0() {
        return img0;
    }

    public void setImg0(String img0) {
        this.img0 = img0;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getOutputNum() {
        return outputNum;
    }

    public void setOutputNum(String outputNum) {
        this.outputNum = outputNum;
    }

    public String getKindZone() {
        return kindZone;
    }

    public void setKindZone(String kindZone) {
        this.kindZone = kindZone;
    }

    public String getStr0() {
        return str0;
    }

    public void setStr0(String str0) {
        this.str0 = str0;
    }

    public String getMainProIP() {
        return mainProIP;
    }

    public void setMainProIP(String mainProIP) {
        this.mainProIP = mainProIP;
    }

    public Integer getDownloadTimes() {
        return downloadTimes;
    }

    public void setDownloadTimes(Integer downloadTimes) {
        this.downloadTimes = downloadTimes;
    }

    public Date getDownloadDateTime() {
        return downloadDateTime;
    }

    public void setDownloadDateTime(Date downloadDateTime) {
        this.downloadDateTime = downloadDateTime;
    }

    public String getLocate() {
        return locate;
    }

    public void setLocate(String locate) {
        this.locate = locate;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public String getGR_status() {
        return GR_status;
    }

    public void setGR_status(String GR_status) {
        this.GR_status = GR_status;
    }
}
