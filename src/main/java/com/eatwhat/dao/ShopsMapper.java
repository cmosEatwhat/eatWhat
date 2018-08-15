package com.eatwhat.dao;

import com.eatwhat.entity.Shops;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
* 描述：
* @author xin_anzhang
* @date 2018/08/13
*/
@Component
public interface ShopsMapper {

    /**
    * @des 添加Shops
    * @param shops
    */
    int saveShops(Shops shops);

    /**
    * @des 根据id删除
    * @param recordId
    */
    int deleteById(@Param("recordId") String recordId);


    /**
    * @des 根据Id获取
    * @param recordId
    */
    Shops findById(String recordId);




}