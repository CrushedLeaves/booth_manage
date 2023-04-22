package com.zjp.entity;

import java.io.Serializable;

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
 * @since 2023-04-04
 */
@ApiModel(value = "Business对象", description = "")
public class Business implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private String openid;

    private String busName;

    private String busPhone;

    private String imgAddress;

    @ApiModelProperty("'0'为男，'1'为女")
    private String gender;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }
    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }
    public String getBusPhone() {
        return busPhone;
    }

    public void setBusPhone(String busPhone) {
        this.busPhone = busPhone;
    }
    public String getImgAddress() {
        return imgAddress;
    }

    public void setImgAddress(String imgAddress) {
        this.imgAddress = imgAddress;
    }
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Business{" +
            "openid=" + openid +
            ", busName=" + busName +
            ", busPhone=" + busPhone +
            ", imgAddress=" + imgAddress +
            ", gender=" + gender +
        "}";
    }
}
