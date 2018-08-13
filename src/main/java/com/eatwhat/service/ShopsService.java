package com.eatwhat.service;

import com.eatwhat.entity.Shops;

import java.util.List;

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
    * @des 根据id集合删除
    * @param idArr
    */
    int deleteByIdArr(Long[] idArr);

    /**
    * @des 修改Shops
    * @param shops
    */
    Shops updateShops(Shops shops);

    /**
    * @des 根据Id获取
    * @param recordId
    */
    Shops findById(String recordId);

    /**
    * @des 根据id 集合查询信息
    * @param idArr
    */
    List<Shops> findByIdArr(Long[] idArr);


    /**
    * @des 根据条件计数
    * @param shops
    */
    int count(Shops shops);

}