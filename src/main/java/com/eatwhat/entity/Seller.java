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
@Table(name="seller")
public class Seller implements Serializable {

    /**
     *商家id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     *商家名
     */
    @Column(name = "foods_name")
    private String foodsName;

    /**
     *店铺Id
     */
    @Column(name = "shops_id")
    private Long shopsId;

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

    public String getFoodsName() {
        return this.foodsName;
    }
    public void setFoodsName(String foodsName) {
        this.foodsName = foodsName;
    }

    public Long getShopsId() {
        return this.shopsId;
    }
    public void setShopsId(Long shopsId) {
        this.shopsId = shopsId;
    }




}