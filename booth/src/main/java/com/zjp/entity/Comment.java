package com.zjp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author zjp
 * @since 2023-04-12
 */
@ApiModel(value = "Comment对象", description = "")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "comment_id", type = IdType.AUTO)
    private Integer commentId;

    private String sentence;

    private Integer goodId;

    private String openid;

    private String speaktime;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }
    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }
    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }
    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }
    public String getSpeaktime() {
        return speaktime;
    }

    public void setSpeaktime(String speaktime) {
        this.speaktime = speaktime;
    }

    @Override
    public String toString() {
        return "Comment{" +
            "commentId=" + commentId +
            ", sentence=" + sentence +
            ", goodId=" + goodId +
            ", openid=" + openid +
            ", speaktime=" + speaktime +
        "}";
    }
}
