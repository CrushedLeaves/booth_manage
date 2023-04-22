package com.zjp.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
/**
 * <p>
 * 
 * </p>
 *
 * @author zjp
 * @since 2023-04-12
 */
@TableName("order_good")
@ApiModel(value = "OrderGood对象", description = "")
public class OrderGood implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer orderId;

    private Integer goodId;

    private Integer num;

    private Integer discount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }
    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "OrderGood{" +
            "id=" + id +
            ", orderId=" + orderId +
            ", goodId=" + goodId +
            ", num=" + num +
            ", discount=" + discount +
        "}";
    }
}
