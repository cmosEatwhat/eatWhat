package com.eatwhat.service;

import com.eatwhat.entity.Seller;

import java.util.List;

/**
* 描述： 服务实现层接口
* @author xin_anzhang
* @date 2018/08/13
*/
public interface SellerService {

    /**
    * @des 添加Seller
    * @param seller
    */
    Seller saveSeller(Seller seller);

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
    * @des 修改Seller
    * @param seller
    */
    Seller updateSeller(Seller seller);

    /**
    * @des 根据Id获取
    * @param recordId
    */
    Seller findById(String recordId);

    /**
    * @des 根据id 集合查询信息
    * @param idArr
    */
    List<Seller> findByIdArr(Long[] idArr);


    /**
    * @des 根据条件计数
    * @param seller
    */
    int count(Seller seller);

}