package com.eatwhat.service;

import com.eatwhat.entity.Foods;
import com.eatwhat.entity.comment.PageModel;
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
    * @des 根据Id获取
     * @param recordId
     */
    Foods findById(String recordId);



    /*
     *根据分类和店铺查所有商品ID
     */
    List<Long> findByShopsIdAndCategoryId(String shopsId, String CategoryId, PageModel pageModel);
    /*
     *店铺和分类查菜品
     */
    List<FoodsVo> findAllByShopsIdAndCategoryId(String shopsId, String categoryId, PageModel pageModel);
    PageInfo<FoodsVo> findByShopsId(String shopsId, PageModel pageModel);
//    List<FoodsVo> findByShopsId(String shopsId, PageModel pageModel);
}