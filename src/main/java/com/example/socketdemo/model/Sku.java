package com.example.socketdemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 商品类
 */
@Entity(name = "serversku")
public class Sku {
    @Id
    private String code;
    private String tradeName;
    private Double curPrice;
    @Column(name = "store_id")
    private String storeId;
    private Double originalPrice;
    private String reductionReason;
    private Double clubPrice;
    private String unitScript;
    private String discountNode;
    private String madein;
    private String classNum;
    private String specification;
    private String category;
    private String putStyle;
    private String locateStr;
    private String innerCode;
    private String startDate;
    private String endDate;
    private String code2D;
    private  String priceEmployee;
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public Double getCurPrice() {
        return curPrice;
    }

    public void setCurPrice(Double curPrice) {
        this.curPrice = curPrice;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public Double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getReductionReason() {
        return reductionReason;
    }

    public void setReductionReason(String reductionReason) {
        this.reductionReason = reductionReason;
    }

    public Double getClubPrice() {
        return clubPrice;
    }

    public void setClubPrice(Double clubPrice) {
        this.clubPrice = clubPrice;
    }

    public String getUnitScript() {
        return unitScript;
    }

    public void setUnitScript(String unitScript) {
        this.unitScript = unitScript;
    }

    public String getDiscountNode() {
        return discountNode;
    }

    public void setDiscountNode(String discountNode) {
        this.discountNode = discountNode;
    }

    public String getMadein() {
        return madein;
    }

    public void setMadein(String madein) {
        this.madein = madein;
    }

    public String getClassNum() {
        return classNum;
    }

    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPutStyle() {
        return putStyle;
    }

    public void setPutStyle(String putStyle) {
        this.putStyle = putStyle;
    }

    public String getLocateStr() {
        return locateStr;
    }

    public void setLocateStr(String locateStr) {
        this.locateStr = locateStr;
    }

    public String getInnerCode() {
        return innerCode;
    }

    public void setInnerCode(String innerCode) {
        this.innerCode = innerCode;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCode2D() {
        return code2D;
    }

    public void setCode2D(String code2D) {
        this.code2D = code2D;
    }

    public String getPriceEmployee() {
        return priceEmployee;
    }

    public void setPriceEmployee(String priceEmployee) {
        this.priceEmployee = priceEmployee;
    }

    @Override
    public String toString() {
        return "sku:|flag|styleChar|红灯|绿灯|"+innerCode+"|"
                + code + "|" + tradeName+ "|"+specification+"|"+classNum+"|"+unitScript+"|" + curPrice
                + "|促销价|"+startDate+"|"+endDate+"|"+clubPrice+"|"+priceEmployee+"|库存|二维码|"+madein+"|";

    }
}
