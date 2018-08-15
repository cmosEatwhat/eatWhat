package com.eatwhat.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 描述：模型
 * @author xin_zhang
 * @date 2018/08/14
 */
@Entity
@Data
@Table(name="category")
public class Category implements Serializable {

    /**
     *分类Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     *商铺Id
     */
    private Long shopId;

    /**
     *类名
     */
    @Column(name = "category_name")
    private String categoryName;

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

}