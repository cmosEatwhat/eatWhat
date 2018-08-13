package com.eatwhat.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 描述：模型
 * @author xin_anzhang
 * @date 2018/08/13
 */
@Entity
@Table(name="shops")
public class Shops implements Serializable {

    /**
     *店铺Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     *店铺名
     */
    @Column(name = "shops_name")
    private String name;


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




}