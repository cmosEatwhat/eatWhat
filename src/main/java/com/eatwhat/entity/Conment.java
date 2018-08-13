package com.eatwhat.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 描述：模型
 * @author xin_anzhang
 * @date 2018/08/13
 */
@Entity
@Table(name="conment")
public class Conment implements Serializable {

    /**
     *评论id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     *评论
     */
    @Column(name = "conment_context")
    private String context;

    /**
     *食品Id
     */
    @Column(name = "food_id")
    private Long foodId;


    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getContext() {
        return this.context;
    }
    public void setContext(String context) {
        this.context = context;
    }

    public Long getFoodId() {
        return this.foodId;
    }
    public void setFoodId(Long foodId) {
        this.foodId = foodId;
    }




}