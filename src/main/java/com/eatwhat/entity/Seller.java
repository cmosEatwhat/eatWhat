package com.eatwhat.entity;

import javax.persistence.*;
import java.io.Serializable;

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