package com.eatwhat.service;

import com.eatwhat.entity.Foods;
import com.eatwhat.entity.food.FoodsVo;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
* 描述： 服务实现层接口
* @author xin_anzhang
* @date 2018/08/13
*/
public interface FoodsService {

    /**
    * @des 添加Foods
    * @param foods
    */
    Foods saveFoods(Foods foods);

    /**
    * @des 根据id删除
    * @param recordId
    */
    int deleteById(String recordId);

    /**
    * @des 根据id集合删除
    * @param idArr
    */
    int deleteByIdArr(Long[] idArr);

    /**
    * @des 修改Foods
    * @param foods
    */
    Foods updateFoods(Foods foods);

    /**
    * @des 根据Id获取
    * @param recordId
    */
    Foods findById(String recordId);

    /**
    * @des 根据id 集合查询信息
    * @param idArr
    */
    List<FoodsVo> findByIdArr(Long[] idArr);


    /**
    * @des 根据条件计数
    * @param foods
    */
    int count(Foods foods);

    PageInfo<FoodsVo> findByShopsId(String shopsId,int pageNum, int pageSize);
}