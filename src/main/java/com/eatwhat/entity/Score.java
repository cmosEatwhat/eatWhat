package com.eatwhat.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 描述：模型
 * @author xin_anzhang
 * @date 2018/08/13
 */
@Entity
@Table(name="score")
public class Score implements Serializable {

    /**
     *评分id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     *食品Id
     */
    @Column(name = "score_context")
    private double context;

    /**
     *食品Id
     */
    @Column(name = "food_id")
    private Long foodId;


    /**
     *创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss ")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
    private Date createTime;

    /**
     *更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss ")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
    private Date updateTime;


    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }


    public Long getFoodId() {
        return this.foodId;
    }
    public void setFoodId(Long foodId) {
        this.foodId = foodId;
    }

    public double getContext() {
        return context;
    }

    public void setContext(double context) {
        this.context = context;
    }
}