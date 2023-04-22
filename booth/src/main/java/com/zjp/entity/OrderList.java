package com.zjp.entity;

/**
 * <p>
 *     订单接口的返回类
 *
 * </p>
 *
 * @author zjp
 * @since 2023-04-02
 */


import java.util.List;

public class OrderList {
    private int orderId;

    private String boothName;

    public int getOrderId() {
        return orderId;
    }

    public String getBoothName() {
        return boothName;
    }

    public int getState() {
        return state;
    }

    public String getTime() {
        return time;
    }

    public String getSum() {
        return sum;
    }

    public int getNum() {
        return num;
    }

    public List<String> getImages() {
        return images;
    }

    private int state;

    private String time;

    private String sum;

    @Override
    public String toString() {
        return "OrderList{" +
                "orderId=" + orderId +
                ", boothName='" + boothName + '\'' +
                ", state=" + state +
                ", time='" + time + '\'' +
                ", sum='" + sum + '\'' +
                ", num=" + num +
                ", images=" + images +
                '}';
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setBoothName(String boothName) {
        this.boothName = boothName;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    private int num;

    private List<String> images;
}
