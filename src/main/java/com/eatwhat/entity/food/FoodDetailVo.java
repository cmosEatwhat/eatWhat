package com.eatwhat.entity.food;

import com.eatwhat.entity.Conment;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Author: zhangxin_an
 * @CreateDate: 2018/8/14 16:45
 */
@Data
public class FoodDetailVo  implements Serializable {

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

    /**
     *评论
     */
    private List<Conment> conmentList;

    private String shopsAddress;


}