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
    * @des 根据Id获取
    * @param recordId
    */
    Foods findById(String recordId);



    List<FoodsVo> findByShopsId(@Param("shopsId") String shopsId);

    /*
     *根据分类和店铺查所有商品ID
     */
    List<Long> findByShopsIdAndCategoryId(@Param("shopId") String shopId,@Param("categoryId") String categoryId);



    FoodsVo findFoodById(@Param("foodId") Long foodId);
}