package com.zjp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author zjp
 * @since 2023-04-13
 */
@ApiModel(value = "Orders对象", description = "")
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "order_id", type = IdType.AUTO)
    private Integer orderId;

    private Integer boothId;

    @ApiModelProperty("0为已完成，1为退单，2为待完成")
    private String orderStatus;

    private String sumOrder;

    private String address;

    private String openid;

    private String phone;

    private LocalDateTime creattime;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
    public Integer getBoothId() {
        return boothId;
    }

    public void setBoothId(Integer boothId) {
        this.boothId = boothId;
    }
    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
    public String getSumOrder() {
        return sumOrder;
    }

    public void setSumOrder(String sumOrder) {
        this.sumOrder = sumOrder;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public LocalDateTime getCreattime() {
        return creattime;
    }

    public void setCreattime(LocalDateTime creattime) {
        this.creattime = creattime;
    }

    @Override
    public String toString() {
        return "Orders{" +
            "orderId=" + orderId +
            ", boothId=" + boothId +
            ", orderStatus=" + orderStatus +
            ", sumOrder=" + sumOrder +
            ", address=" + address +
            ", openid=" + openid +
            ", phone=" + phone +
            ", creattime=" + creattime +
        "}";
    }
}
