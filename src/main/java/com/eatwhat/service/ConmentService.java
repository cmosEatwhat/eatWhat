package com.eatwhat.service;

import com.eatwhat.entity.Conment;
import com.eatwhat.entity.comment.PageModel;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
* 描述： 服务实现层接口
* @author xin_anzhang
* @date 2018/08/13
*/
public interface ConmentService {

    /**
    * @des 添加Conment
    * @param conment
    */
    Conment saveConment(Conment conment);

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
    * @des 修改Conment
    * @param conment
    */
    Conment updateConment(Conment conment);

    /**
    * @des 根据Id获取
    * @param recordId
    */
    Conment findById(String recordId);

    /**
    * @des 根据id 集合查询信息
    * @param idArr
    */
    List<Conment> findByIdArr(Long[] idArr);


    /**
    * @des 根据条件计数
    * @param conment
    */
    int count(Conment conment);

    /**
     * @des 查单个商品所有评论
     * @param foodId
     */
    PageInfo<Conment> getConmentListByfoodId(String foodId,PageModel pageModel);

}