package com.eatwhat.entity.food;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
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
@Data
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

    private Double avgScore;
    /**
     *更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss ")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
    private Date updateTime;



}