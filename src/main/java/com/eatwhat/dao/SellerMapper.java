package com.eatwhat.dao;

import com.eatwhat.entity.Seller;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
* 描述：
* @author xin_anzhang
* @date 2018/08/13
*/
@Component
public interface SellerMapper {

    /**
    * @des 添加Seller
    * @param seller
    */
    int saveSeller(Seller seller);

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
    * @des 修改Seller
    * @param seller
    */
    int updateSeller(Seller seller);

    /**
    * @des 根据Id获取
    * @param recordId
    */
    Seller findById(String recordId);

    /**
    * @des 根据id 集合查询信息
    * @param idArr
    */
    List<Seller> findByIdArr(@Param("idArr") Long[] idArr);


    /**
    * @des 根据条件计数
    * @param pageRequest
    */
    int count(Seller seller);

}