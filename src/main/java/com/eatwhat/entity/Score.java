package com.eatwhat.entity;

import javax.persistence.*;
import java.io.Serializable;

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
    @Column(name = "food_id")
    private Long foodId;


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




}