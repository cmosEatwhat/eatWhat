package com.eatwhat.service;

import com.eatwhat.entity.Shops;

/**
* 描述： 服务实现层接口
* @author xin_anzhang
* @date 2018/08/13
*/
public interface ShopsService {

    /**
    * @des 添加Shops
    * @param shops
    */
    Shops saveShops(Shops shops);

    /**
    * @des 根据id删除
    * @param recordId
    */
    int deleteById(String recordId);




    /**
     * @des 根据Id获取
     * @param recordId
     */
    Shops findById(String recordId);



}