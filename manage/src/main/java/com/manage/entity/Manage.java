package com.manage.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

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
 * @since 2023-04-16
 */
@ApiModel(value = "Manage对象", description = "")
public class Manage implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Integer userid;

    private String username;

    private String password;

    private LocalDateTime creattime;

    private String email;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public LocalDateTime getCreattime() {
        return creattime;
    }

    public void setCreattime(LocalDateTime creattime) {
        this.creattime = creattime;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Manage{" +
            "userid=" + userid +
            ", username=" + username +
            ", password=" + password +
            ", creattime=" + creattime +
            ", email=" + email +
        "}";
    }
}
