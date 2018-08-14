package com.eatwhat.entity.food;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description:
 * @Author: zhangxin_an
 * @CreateDate: 2018/8/14 11:31
 */

/**
 * 描述：模型
 *
 * @author xin_anzhang
 * @date 2018/08/13
 */
@Entity
public class FoodsVo implements Serializable {

    /**
     * 食品Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * 食品名
     */
    @Column(name = "foods_name")
    private String name;

    /**
     * 食品价格
     */
    @Column(name = "foods_price")
    private BigDecimal price;


    /**
     * 食品图片
     */
    @Column(name = "foods_image")
    private String image;


    /**
     *更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss ")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
    private Date updateTime;
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