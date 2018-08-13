package com.eatwhat.dao;

import com.eatwhat.entity.Conment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
* 描述：
* @author xin_anzhang
* @date 2018/08/13
*/
@Component
public interface ConmentMapper {

    /**
    * @des 添加Conment
    * @param conment
    */
    int saveConment(Conment conment);

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
    * @des 修改Conment
    * @param conment
    */
    int updateConment(Conment conment);

    /**
    * @des 根据Id获取
    * @param recordId
    */
    Conment findById(String recordId);

    /**
    * @des 根据id 集合查询信息
    * @param idArr
    */
    List<Conment> findByIdArr(@Param("idArr") Long[] idArr);


    /**
    * @des 根据条件计数
    * @param pageRequest
    */
    int count(Conment conment);

}