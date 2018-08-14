package com.eatwhat.dao;

import com.eatwhat.entity.Foods;
import com.eatwhat.entity.food.FoodsVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
* 描述：
* @author xin_anzhang
* @date 2018/08/13
*/
@Component
public interface FoodsMapper {

    /**
    * @des 添加Foods
    * @param foods
    */
    int saveFoods(Foods foods);

    /**
    * @des 根据id删除
    * @param recordId
    */
    int deleteById(@Param("recordId") String recordId);

    /**
    * @des 根据id集合删除
    * @param idArr
    */
    int deleteByIdArr(@Param("idArr") Long[] idArr);

    /**
    * @des 修改Foods
    * @param foods
    */
    int updateFoods(Foods foods);

    /**
    * @des 根据Id获取
    * @param recordId
    */
    Foods findById(String recordId);

    /**
    * @des 根据id 集合查询信息
    * @param idArr
    */
    List<FoodsVo> findByIdArr(@Param("idArr") Long[] idArr);


    /**
    * @des 根据条件计数
    * @param foods
    */
    int count(Foods foods);

    List<FoodsVo> findByShopsId(@Param("shopsId") String shopsId);
}