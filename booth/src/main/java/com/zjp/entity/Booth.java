package com.zjp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;

/**
 * <p>
 * 
 * </p>
 *
 * @author zjp
 * @since 2023-04-03
 */
@ApiModel(value = "Booth对象", description = "")
public class Booth implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "booth_id", type = IdType.AUTO)
    private Integer boothId;

    private String boothName;

    private String boothAddress;

    private String boothPhone;

    private String businessId;

    private String boothStartTime;

    public String getBoothImg() {
        return boothImg;
    }

    public void setBoothImg(String boothImg) {
        this.boothImg = boothImg;
    }

    private String boothEndTime;

    private String boothImg;



    public String getBoothStartTime() {
        return boothStartTime;
    }


    public String getBoothEndTime() {
        return boothEndTime;
    }

    public void setBoothStartTime(String boothStartTime) {
        this.boothStartTime = boothStartTime;
    }

    public void setBoothEndTime(String boothEndTime) {
        this.boothEndTime = boothEndTime;
    }

    public Integer getAdPoints() {
        return adPoints;
    }

    private Integer adPoints;

    private Integer rewardPoints;

    public Integer getBoothId() {
        return boothId;
    }

    public void setBoothId(Integer boothId) {
        this.boothId = boothId;
    }
    public String getBoothName() {
        return boothName;
    }

    public void setBoothName(String boothName) {
        this.boothName = boothName;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getBoothAddress() {
        return boothAddress;
    }

    public void setBoothAddress(String boothAddress) {
        this.boothAddress = boothAddress;
    }
    public String getBoothPhone() {
        return boothPhone;
    }


    public void setAdPoints(Integer adPoints) {
        this.adPoints = adPoints;
    }
    public Integer getRewardPoints() {
        return rewardPoints;
    }

    public void setRewardPoints(Integer rewardPoints) {
        this.rewardPoints = rewardPoints;
    }


    @Override
    public String toString() {
        return "Booth{" +
                "boothId=" + boothId +
                ", boothName='" + boothName + '\'' +
                ", boothAddress='" + boothAddress + '\'' +
                ", boothPhone='" + boothPhone + '\'' +
                ", businessId=" + businessId +
                ", boothStartTime='" + boothStartTime + '\'' +
                ", boothEndTime='" + boothEndTime + '\'' +
                ", boothImg='" + boothImg + '\'' +
                ", adPoints=" + adPoints +
                ", rewardPoints=" + rewardPoints +
                '}';
    }

    public void setBoothPhone(String boothPhone) {
        this.boothPhone = boothPhone;
    }
}
