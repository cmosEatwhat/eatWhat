package com.eatwhat.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 描述：模型
 * @author xin_anzhang
 * @date 2018/08/13
 */
@Entity
@Table(name="foods")
public class Foods implements Serializable {

    /**
     *食品Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     *食品名
     */
    @Column(name = "foods_name")
    private String name;

    /**
     *食品价格
     */
    @Column(name = "foods_price")
    private BigDecimal price;

    /**
     *食品图片
     */
    @Column(name = "foods_image")
    private String image;

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

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return this.price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    public String getImage() {
        return this.image;
    }
    public void setImage(String image) {
        this.image = image;
    }




}