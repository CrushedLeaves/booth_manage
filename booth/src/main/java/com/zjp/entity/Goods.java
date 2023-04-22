package com.zjp.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author zjp
 * @since 2023-04-02
 */
@ApiModel(value = "Goods对象", description = "")
public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Integer goodId;

    private String goodName;

    private String goodType;

    public Integer getBoothId() {
        return boothId;
    }

    public void setBoothId(Integer boothId) {
        this.boothId = boothId;
    }

    private Integer likeNum;

    private Integer boothId;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    private BigDecimal price;

    private BigDecimal discount;

    private String description;

    private String imageUrl;

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }
    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }
    public String getGoodType() {
        return goodType;
    }

    public void setGoodType(String goodType) {
        this.goodType = goodType;
    }
    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Goods{" +
            "goodId=" + goodId +
            ", goodName=" + goodName +
            ", goodType=" + goodType +
            ", likeNum=" + likeNum +
            ", price=" + price +
            ", discount=" + discount +
            ", desc=" + description +
            ", imageUrl=" + imageUrl +
        "}";
    }
}
